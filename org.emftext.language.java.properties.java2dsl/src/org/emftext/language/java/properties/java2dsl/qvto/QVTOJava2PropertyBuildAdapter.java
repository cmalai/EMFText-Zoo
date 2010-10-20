package org.emftext.language.java.properties.java2dsl.qvto;

import java.util.Arrays;
import java.util.List;

import org.emftext.language.java.java2dsl.AbstractQVTOBuilderAdapter;
import org.emftext.language.java.java2dsl.util.MetaModelName;


public class QVTOJava2PropertyBuildAdapter extends AbstractQVTOBuilderAdapter {

	@Override
	public int getTimeout() {
		return 300000;
	}

	@Override
	public int getMaxActiveThreads() {
		return 1;
	}

	@Override
	public String getDirectoryWithScripts() {
		return "transformations";
	}

	@Override
	public String getScriptInOneDirection() {
		return "java2propjava";
	}

	@Override
	public String getScriptInOtherDirection() {
		return "propjava2java";
	}

	@Override
	public String getFileExtension() {
		return "propjava";
	}
	
	@Override
	public String getUtilClassName() {
		return "PropertyQVTOStatisticUtil";
	}

	@Override
	public MetaModelName getMetaModelInLeftDirection() {
		return MetaModelName.PROPERTY;
	}

	@Override
	public MetaModelName getMetaModelInRightDirection() {
		return MetaModelName.PROPERTY;
	}

	@Override
	public List<String> getImportantMappingOperationNameInLeftDirection() {
		return Arrays.asList("Member_Property","Member_Property_ReadOnly");
	}

	@Override
	public List<String> getImportantMappingOperationNameInRightDirection() {
		return Arrays.asList("Member_PropertyToGetter","Member_PropertyToSetter");
	}

}