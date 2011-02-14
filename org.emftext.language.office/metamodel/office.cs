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

SYNTAXDEF office
FOR <http://emftext.org/office>
START OfficeModel

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	generateCodeFromGeneratorModel = "true";
}

RULES { 
	OfficeModel ::= "officemodel" name[]
					"{" elements* "}" ;
	
	Office ::= "office" name[];
	
	Employee ::= "employee" name[] 
				 "works" "in" worksIn[] 
				 "works" "with" 
				 worksWith[] ("," worksWith[])* ;
}