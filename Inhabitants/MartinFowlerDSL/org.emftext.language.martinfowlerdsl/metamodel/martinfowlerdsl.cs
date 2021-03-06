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

SYNTAXDEF martinfowlerdsl
FOR <http://www.emftext.org/language/martinfowlerdsl>
START StateMachine

OPTIONS {
	licenceHeader = "../../org.dropsbox/licence.txt";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE T_RESETTING $'resetting'$;
}



TOKENSTYLES {
	"T_RESETTING" COLOR #800055, BOLD;
}

RULES {
	StateMachine ::= 
		"events"   (events: Event)*   "end"
  		"commands" (events: Command)* "end"
  		"start" start[]
		states+;
 
	State ::= 
		"state" name[]
		("actions" "{" (actions[])+ "}")?
		transitions*
  		"end";
 
	Event      ::= (resetting[T_RESETTING])? name[] code[];
	Command    ::= name[] code[];
	Transition ::= trigger[] "=>" target[];
}