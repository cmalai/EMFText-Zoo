package org.emftext.language.java.resource.java.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.NestedExpression;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.resource.java.IJavaReferenceResolveResult;
import org.emftext.language.java.resource.java.analysis.decider.ConcreteClassifierDecider;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;
import org.emftext.language.java.resource.java.analysis.decider.TypeParameterDecider;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.rtypes.ClassifierReferenceTarget;

public class ClassifierReferenceTargetValueReferenceResolver implements org.emftext.language.java.resource.java.IJavaReferenceResolver<org.emftext.language.java.types.rtypes.ClassifierReferenceTarget, org.emftext.language.java.classifiers.Classifier> {
	
	public java.lang.String deResolve(Classifier classifier, ClassifierReferenceTarget tContainer, org.eclipse.emf.ecore.EReference reference) {
		if(!(tContainer.eContainer() instanceof ClassifierReference)) {
			return classifier.getName();
		}
		ClassifierReference container = (ClassifierReference) tContainer.eContainer();
		
		if (classifier instanceof ConcreteClassifier) {
			ConcreteClassifier concreteClassifier = (ConcreteClassifier) classifier;
			boolean namespaceMissing = true;
			if(container.eContainer() instanceof NamespaceClassifierReference) {
				namespaceMissing = ((NamespaceClassifierReference)container.eContainer()).getNamespaces().isEmpty();
			}		
			Object fullNamesOption = container.eResource().getResourceSet().getLoadOptions().get(
					JavaClasspath.OPTION_ALWAYS_USE_FULLY_QUALIFIED_NAMES);	
			if (!(fullNamesOption instanceof Boolean)) {
				fullNamesOption = Boolean.FALSE;
			}
			if (namespaceMissing && Boolean.TRUE.equals(fullNamesOption)) {
				String packageName = "";
				String fullClassName = concreteClassifier.getName();
				EObject parent = concreteClassifier.eContainer();
				while(parent instanceof Classifier) {
					fullClassName = ((Classifier)parent).getName() + "." + fullClassName;
					parent = parent.eContainer();
				}
				if (parent instanceof CompilationUnit) {
					EList<String> namespaces = ((CompilationUnit)parent).getNamespaces();
					for(String s : namespaces) { packageName += s + "."; }
				}
				return packageName + fullClassName;
			}
			
			if(concreteClassifier.getFullName() != null) {
				return concreteClassifier.getFullName();
			}
		}
		return classifier.getName();
	}	

	public void resolve(java.lang.String identifier, ClassifierReferenceTarget tContainer, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<Classifier> result) {
		List<IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
		
		if(!(tContainer.eContainer() instanceof ClassifierReference)) {
			return ;
		}
		ClassifierReference container = (ClassifierReference) tContainer.eContainer();
		
		EObject startingPoint = null;
		EObject target = null;
		boolean hasNamespace = false;
		
		if (container.eContainer() instanceof NamespaceClassifierReference) {
			NamespaceClassifierReference ncr = (NamespaceClassifierReference) container.eContainer();
			int idx = ncr.getClassifierReferences().indexOf(container);
			if(idx > 0) {
				hasNamespace = true;
				startingPoint = ncr.getClassifierReferences().get(idx - 1).getTarget();
			}
			else {
				if(ncr.getNamespaces().size() > 0) {
					hasNamespace = true;
					EObject lastClassInNS = ConcreteClassifierDecider.resolveRelativeNamespace(
							ncr, 0, container, container, reference);
					if (lastClassInNS != null) {
						startingPoint = lastClassInNS;
					}
					else {
						//absolute class starting with package
						target = resolveFullQualifiedTypeReferences(identifier, ncr, container, reference);
					}
				}
			}
		}
		
		if (target == null) {
			//new constructor call can be part of reference chain
			if (startingPoint == null && container.eContainer().eContainer() instanceof NewConstructorCall) {
				NewConstructorCall ncc = (NewConstructorCall) container.eContainer().eContainer();
				if (ncc.eContainmentFeature().equals(ReferencesPackage.Literals.REFERENCE__EXTENSIBLE_NEXT)) {
					startingPoint = ((Reference) ncc.eContainer()).getReferencedType();
					
					//a ncc can be encapsulated in nested expressions
					EObject outerContainer = ncc.eContainer();
					while (outerContainer instanceof NestedExpression) {
						Expression nestedExpression = ((NestedExpression)outerContainer).getExpression();
						if (nestedExpression instanceof Reference) {
							outerContainer = (Reference) nestedExpression;
						}
						else {
							break;
						}
					}
					
					if (outerContainer instanceof NewConstructorCall) {
						NewConstructorCall outerNcc = (NewConstructorCall) outerContainer;
						if (outerNcc.getAnonymousClass() != null) {
							startingPoint = outerNcc.getAnonymousClass();
						}
						else {
							startingPoint = outerNcc.getTypeReference().getTarget();
						}
					}
				}
			}
			
			if (startingPoint == null) {
				startingPoint = container;
			}
			
			if (hasNamespace) {
				if (startingPoint instanceof ConcreteClassifier) {
					for(ConcreteClassifier cand : ((ConcreteClassifier)startingPoint).getAllInnerClassifiers()) {
						if (identifier.equals(cand.getName())) {
							target = cand;
							break;
						}
					}
				}
				else if (startingPoint instanceof TypeParameter) {
					for(TypeReference extendsClassifierReference : ((TypeParameter)startingPoint).getExtendTypes()) {
						ConcreteClassifier extendsClassifier = (ConcreteClassifier) extendsClassifierReference.getTarget();
						for(ConcreteClassifier cand : extendsClassifier.getAllInnerClassifiers()) {
							if (identifier.equals(cand.getName())) {
								target = cand;
								break;
							}
						}
					}
				}

			}
			else {
				deciderList.add(new ConcreteClassifierDecider());
				deciderList.add(new TypeParameterDecider());
				
				ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
				
				target = treeWalker.walk(startingPoint, identifier, container, reference);
			}

		}
		
		if (target != null) {
			result.addMapping(identifier, (Classifier) target);
		}
	}
	
	private EObject resolveFullQualifiedTypeReferences(String identifier,
			NamespaceClassifierReference ncr, EObject container, EReference reference) {
		
		int idx = ncr.getClassifierReferences().indexOf(container);
		if(ncr.getNamespaces().size() > 0 && idx == 0) {
			EObject target = null;
			//if the reference is qualified, the target can be directly found
			String containerName = ncr.getNamespacesAsString();
			if (containerName.contains("$")) {
				String firstClassName = containerName.substring(0, containerName.indexOf("$"));
				ConcreteClassifier firstClass = (ConcreteClassifier) EcoreUtil.resolve(
						JavaClasspath.get(ncr).getClassifier(firstClassName), container.eResource());
				target = ConcreteClassifierDecider.resolveRelativeNamespace(
						ncr, ncr.getNamespaces().indexOf(firstClass.getName()) + 1, firstClass, container, reference);
				for(ConcreteClassifier cand : ((ConcreteClassifier)target).getAllInnerClassifiers()) {
					if (identifier.equals(cand.getName())) {
						target = cand;
						break;
					}
				}
			}
			else {
				target = (Classifier) EcoreUtil.resolve(
						JavaClasspath.get(ncr).getClassifier(containerName + identifier), container.eResource());
			}

			return target;
		}
		return null;
		
	}
	
	public void setOptions(Map<?, ?> options) {
	}
	
}