SYNTAXDEF c
FOR <http://www.reuseware.org/simple_c>
START CompilationUnit

OPTIONS {
	tokenspace = 1;
	autofixSimpleLeftrecursion = false;
}

TOKENS {
}

RULES {
	CompilationUnit ::= definitions* ;
	
	Method ::= "void" name[] "(" ")" "{" statements* "}" ;
	
	Variable ::= "int" name[] ";" ;
	
	Struct ::= "struct" name[] "{" "}" ;
	
	Statement ::= "return" ";";
}