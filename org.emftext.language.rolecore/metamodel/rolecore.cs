//*******************************************************************************
// Copyright (c) 2006-2010 
// Software Technology Group, Dresden University of Technology
// 
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0 
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
// 
// Contributors:
//   Software Technology Group - TU Dresden, Germany 
//      - initial API and implementation
// ******************************************************************************/

SYNTAXDEF rolecore
FOR <http://www.emftext.org/language/rolecore>
START RCPackage

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	//reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	overrideBuilder = "false";
	additionalDependencies = "org.emftext.language.rolecore.ecore_compiler";
}

TOKENS {
	DEFINE T_ABSTRACT $'abstract'$;
	DEFINE T_DERIVED $'derived'$;
	DEFINE T_VOLATILE $'volatile'$;
	DEFINE T_UNIQUE $'unique'$;
	DEFINE T_ORDERED $'ordered'$;
	DEFINE T_UNSETTABLE $'unsettable'$;
	DEFINE T_CHANGEABLE $'changeable'$;
	DEFINE T_TRANSIENT $'transient'$;
	DEFINE T_ID $'iD'$;
	DEFINE T_CONTAINMENT $'containment'$;
	DEFINE T_RESOLVEPROXIES $'resolveProxies'$;
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	
	DEFINE REFTYPE $'type:'(('A'..'Z'|'a'..'z'|'0'..'9'|'_')+'->')?('A'..'Z'|'a'..'z'|'0'..'9'|'-'|'_')+$;
	
}

TOKENSTYLES {
	"RCPackage" COLOR #00A000, BOLD;
	"CoreClass" COLOR #600000, BOLD;
	"Role" COLOR #00A000, BOLD;
	"is" COLOR #00A000, BOLD;
	"played" COLOR #00A000, BOLD;
	"by" COLOR #00A000, BOLD;
	"COMMENT" COLOR #008000;
}

RULES {
	RCPackage ::= 
		"RCPackage" name[] 
		(#1 nsPrefix[])? (#1 nsURI['"', '"'])? !0
		("Imports" "{" !0 (imports)+ !0	"}")? #1
		"{"
			coreClasses* 
			roles*
		"}";
	
	Import ::= "prefix" ":" prefix[] #1 rcPackage['<','>'] ( #1 rcPackageLocationHint['<','>'])?;
	
	@Foldable
	Role      ::= 
		"Role" name[] "is" "played" "by" playedBy[]
		"{" ( eStructuralFeatures | eOperations )* !0 "}";
	
	@Foldable	
	CoreClass ::= 
		"CoreClass" name[] (#1 "extends" #1 (rcPackage[] ".")? super[])? #1
		"{" ( eStructuralFeatures | eOperations )* !0 "}";

	EAttribute ::= 
		(
			derived[T_DERIVED] | 
			volatile[T_VOLATILE] |
			unique[T_UNIQUE] |
			ordered[T_ORDERED] |
			unsettable[T_UNSETTABLE] | 
			changeable[T_CHANGEABLE] | 
			transient[T_TRANSIENT] | 
			iD[T_ID] 
		#1)* 
		"attribute" #1 eType[] #1 name[] ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ";";
	
	EParameter ::= 
		//(eAnnotations)* 
		(
			ordered[T_ORDERED] |
			unique[T_UNIQUE]
		#1)* eType[] #1 name[] ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ;
	
	EReference ::= 
		(
			containment[T_CONTAINMENT] |
			derived[T_DERIVED] |
			transient[T_TRANSIENT] |
			volatile[T_VOLATILE] |
			unique[T_UNIQUE] |
			ordered[T_ORDERED] |
			unsettable[T_UNSETTABLE] |
			changeable[T_CHANGEABLE] |
			resolveProxies[T_RESOLVEPROXIES]
		)* 
		"reference" #1 eType[REFTYPE] #1 name[] 
		( #1 "(" lowerBound[] ".." upperBound[] ")" )?  (#1 "opposite" #1 eOpposite[])? ";";
	
	EOperation ::=
		(
			ordered[T_ORDERED] |
			unique[T_UNIQUE]
		#1 )* 
		"operation" #1 ("void" | eType[]) 
		( #1 "(" lowerBound[] ".." upperBound[] ")" )? #1 
		//("<" eTypeParameters ("," eTypeParameters)* ">")? 
		name[] #1 
		"(" (eParameters ("," #1 eParameters)* )? ")"
		("throws" #1 eExceptions[] ("," #1 eExceptions[])*)? ";";
}