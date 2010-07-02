package org.emftext.language.java.test.bugs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.resource.JavaSourceOrClassFileResourceFactoryImpl;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.java.resource.util.JavaPostProcessor;
import org.emftext.language.java.resource.util.UnicodeConverterProvider;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypesFactory;
import org.junit.Test;

public class Test1415 extends TestCase {

	private static String OUT_FOLDER = "./output";
	
	public Test1415() {
		super();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java", new JavaSourceOrClassFileResourceFactoryImpl());	
		emptyFolder(new File(OUT_FOLDER), false);
	}
	
	protected Map<?, ?> getLoadOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IJavaOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		map.put(IJavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new JavaPostProcessor());
		return map;
	}

	protected ResourceSet getResourceSet() {
		ResourceSet rs = new ResourceSetImpl();
		rs.getLoadOptions().putAll(getLoadOptions());
		return rs;
	}
	
	@Test
	public void testWithoutResourceSet() throws IOException {
		Commentable commentable = ContainersFactory.eINSTANCE.createCompilationUnit();
		Classifier classifier   = commentable.getConcreteClassifier("java.util.List");
		ClassifierReference reference = TypesFactory.eINSTANCE.createClassifierReference();
		reference.setTarget(classifier);
		
		Factory f = (Factory) Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get("java");
		
		Resource r = f.createResource(URI.createFileURI(OUT_FOLDER + "/test1415-1.java"));
		
		r.getContents().add(reference);
		
		r.save(null);
		
		BufferedReader in = new BufferedReader(new FileReader(OUT_FOLDER + "/test1415-1.java"));
		String str = in.readLine();
		
		//proxy can not be resolved without RS
		assertTrue(reference.getTarget().eIsProxy());
		assertEquals("List", str);
	}
	
	@Test
	public void testWithoutNamespacePrinting() throws IOException {
		Commentable commentable = ContainersFactory.eINSTANCE.createCompilationUnit();
		Classifier classifier   = commentable.getConcreteClassifier("java.util.List");
		ClassifierReference reference = TypesFactory.eINSTANCE.createClassifierReference();
		reference.setTarget(classifier);
		
		ResourceSet rs = getResourceSet();
		Resource r = rs.createResource(URI.createFileURI(OUT_FOLDER + "/test1415-2.java"));
		
		r.getContents().add(reference);
		
		r.save(null);

		BufferedReader in = new BufferedReader(new FileReader(OUT_FOLDER + "/test1415-2.java"));
		String str = in.readLine();
		
		assertFalse(reference.getTarget().eIsProxy());
		assertEquals("List", str);
	}
	
	@Test
	public void testWithNamespacePrinting() throws IOException {
		Commentable commentable = ContainersFactory.eINSTANCE.createCompilationUnit();
		Classifier classifier   = commentable.getConcreteClassifier("java.util.List");
		ClassifierReference reference = TypesFactory.eINSTANCE.createClassifierReference();
		reference.setTarget(classifier);
		
		ResourceSet rs = getResourceSet();
		Resource r = rs.createResource(URI.createFileURI(OUT_FOLDER + "/test1415-3.java"));
		rs.getLoadOptions().put(JavaClasspath.OPTION_ALWAYS_USE_FULLY_QUALIFIED_NAMES, true);
		r.getContents().add(reference);
		
		r.save(null);

		BufferedReader in = new BufferedReader(new FileReader(OUT_FOLDER + "/test1415-3.java"));
		String str = in.readLine();
		
		assertFalse(reference.getTarget().eIsProxy());
		assertEquals("java.util.List", str);
	}
	
	@Test
	public void testFileSplitting() throws IOException {
		CompilationUnit cu1 = ContainersFactory.eINSTANCE.createCompilationUnit();
		CompilationUnit cu2 = ContainersFactory.eINSTANCE.createCompilationUnit();
		Class class1 = ClassifiersFactory.eINSTANCE.createClass();
		Class class2 = ClassifiersFactory.eINSTANCE.createClass();
		cu1.getClassifiers().add(class1);
		cu2.getClassifiers().add(class2);
		
		cu1.getNamespaces().add("org");
		cu1.getNamespaces().add("my");
		cu1.getNamespaces().add("namespace1");
		class1.setName("Class1");
		
		cu2.getNamespaces().add("org");
		cu2.getNamespaces().add("my");
		cu2.getNamespaces().add("namespace2");
		class2.setName("Class2");
		
		String src_folder_name = "test1415-src-folder-1";
		
		ResourceSet rs = getResourceSet();
		Resource r = rs.createResource(URI.createFileURI(OUT_FOLDER + "/" + src_folder_name + ".java"));
		r.getContents().add(cu1);
		r.getContents().add(cu2);
		
		r.save(null);

		assertTrue(new File(OUT_FOLDER + "/" + src_folder_name + "/org/my/namespace1/Class1.java").exists());
		assertTrue(new File(OUT_FOLDER + "/" + src_folder_name + "/org/my/namespace2/Class2.java").exists());
	}
	
	@Test
	public void testFileSplittingWithoutResourceSet() throws IOException {
		CompilationUnit cu1 = ContainersFactory.eINSTANCE.createCompilationUnit();
		CompilationUnit cu2 = ContainersFactory.eINSTANCE.createCompilationUnit();
		Class class1 = ClassifiersFactory.eINSTANCE.createClass();
		Class class2 = ClassifiersFactory.eINSTANCE.createClass();
		cu1.getClassifiers().add(class1);
		cu2.getClassifiers().add(class2);
		
		cu1.getNamespaces().add("org");
		cu1.getNamespaces().add("my");
		cu1.getNamespaces().add("namespace1");
		class1.setName("Class1");
		
		cu2.getNamespaces().add("org");
		cu2.getNamespaces().add("my");
		cu2.getNamespaces().add("namespace2");
		class2.setName("Class2");
		
		String src_folder_name = "test1415-src-folder-2";
		
		Factory f = (Factory) Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get("java");
		Resource r = f.createResource(URI.createFileURI(OUT_FOLDER + "/" + src_folder_name + ".java"));
		
		r.getContents().add(cu1);
		r.getContents().add(cu2);
		
		r.save(null);

		assertTrue(new File(OUT_FOLDER + "/" + src_folder_name + "/org/my/namespace1/Class1.java").exists());
		assertTrue(new File(OUT_FOLDER + "/" + src_folder_name + "/org/my/namespace2/Class2.java").exists());
	}
	
	public void emptyFolder(File path, boolean deleteFolder) {
		if (path.exists() && !path.getName().startsWith(".")) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					emptyFolder(files[i], true);
				} else {
					files[i].delete();
					System.out.println(files[i]);
				}
			}
		}
		if (deleteFolder) path.delete();
	}


}
