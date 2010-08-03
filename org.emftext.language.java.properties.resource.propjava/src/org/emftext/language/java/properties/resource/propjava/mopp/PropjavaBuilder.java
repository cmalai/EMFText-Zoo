/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.java.properties.resource.propjava.mopp;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.expressions.AssignmentExpression;
import org.emftext.language.java.expressions.ExpressionsFactory;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.operators.OperatorsFactory;
import org.emftext.language.java.parameters.OrdinaryParameter;
import org.emftext.language.java.parameters.ParametersFactory;
import org.emftext.language.java.properties.PropertiesPackage;
import org.emftext.language.java.properties.Property;
import org.emftext.language.java.properties.resource.propjava.util.PropjavaEObjectUtil;
import org.emftext.language.java.properties.resource.propjava.util.PropjavaStringUtil;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.Return;
import org.emftext.language.java.statements.StatementsFactory;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypesFactory;

public class PropjavaBuilder implements org.emftext.language.java.properties.resource.propjava.IPropjavaBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		// change this to return true to enable building of all resources
		for(String segment : uri.segmentsList()){
			if(segment.toLowerCase().equals("bin"))
				return false;
		}

		return false;
	}
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.java.properties.resource.propjava.mopp.PropjavaResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		
		URI javaURI = resource.getURI().trimFileExtension().appendFileExtension("java");
		Resource javaResource = resource.getResourceSet().createResource(javaURI);
		javaResource.getContents().addAll(
				EcoreUtil.copyAll(resource.getContents()));
		
		boolean changed = true;
		
		while (changed) {
			changed = false;
			Collection<Property> properties = PropjavaEObjectUtil.getObjectsByType(javaResource.getAllContents(), PropertiesPackage.eINSTANCE.getProperty());
			for (Property property : properties) {
				convertToField(property);
				changed = true;
				break;
			}
		}
		
		try {
			javaResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
	private void convertToField(Property property) {
		Field field = createField(property);
		// create getter
		createGetter(property, field);
		// create setter
		if (!property.isReadonly()) {
			createSetter(property, field);
		}
		
		EcoreUtil.replace(property, field);
	}

	private void createSetter(Property property, Field field) {
		ClassMethod setterMethod = MembersFactory.eINSTANCE.createClassMethod();
		setterMethod.setName("set" + PropjavaStringUtil.capitalize(property.getName()));
		setterMethod.setTypeReference(TypesFactory.eINSTANCE.createVoid());
		
		OrdinaryParameter parameter = ParametersFactory.eINSTANCE.createOrdinaryParameter();
		parameter.setName("newValue");
		TypeReference typeReference = field.getTypeReference();
		TypeReference tReferenceCopy = (TypeReference) EcoreUtil.copy(typeReference);
		parameter.setTypeReference(tReferenceCopy);
		setterMethod.getParameters().add(parameter);
		
		AssignmentExpression assignment = ExpressionsFactory.eINSTANCE.createAssignmentExpression();
		assignment.setAssignmentOperator(OperatorsFactory.eINSTANCE.createAssignment());
		
		IdentifierReference parameterRef = ReferencesFactory.eINSTANCE.createIdentifierReference();
		parameterRef.setTarget(parameter);
		assignment.setValue(parameterRef);
		IdentifierReference fieldRef = ReferencesFactory.eINSTANCE.createIdentifierReference();
		fieldRef.setTarget(field);
		assignment.setChild(fieldRef);
		
		ExpressionStatement assignmentStatement = StatementsFactory.eINSTANCE.createExpressionStatement();
		assignmentStatement.setExpression(assignment);
		setterMethod.getStatements().add(assignmentStatement);
		((MemberContainer) property.eContainer()).getMembers().add(setterMethod);
	}

	private void createGetter(Property property, Field field) {
		// create getter
		ClassMethod getterMethod = MembersFactory.eINSTANCE.createClassMethod();
		getterMethod.setName("get" + PropjavaStringUtil.capitalize(property.getName()));
		
		Return returnStatement = StatementsFactory.eINSTANCE.createReturn();
		IdentifierReference fieldRef = ReferencesFactory.eINSTANCE.createIdentifierReference();
		fieldRef.setTarget(field);
		returnStatement.setReturnValue(fieldRef);
		
		getterMethod.getStatements().add(returnStatement);
		
		TypeReference typeReference = field.getTypeReference();
		TypeReference tReferenceCopy = (TypeReference) EcoreUtil.copy(typeReference);
		getterMethod.setTypeReference(tReferenceCopy);
		
		((MemberContainer) property.eContainer()).getMembers().add(getterMethod);
	}

	private Field createField(Property property) {
		// create field
		Field field = MembersFactory.eINSTANCE.createField();
		field.setName(property.getName());
		TypeReference typeReference = property.getTypeReference();
		field.setTypeReference(typeReference);
		field.getAnnotationsAndModifiers().add(ModifiersFactory.eINSTANCE.createPrivate());
		return field;
	}
	
}
