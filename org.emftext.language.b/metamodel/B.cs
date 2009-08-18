SYNTAXDEF mch
FOR <http://www.computing.surrey.ac.uk/metamodels/B>
START Machine

OPTIONS {
	basePackage = "org.emftext.language.b.resource.mch";
	resourcePluginID = "org.emftext.language.b.resource.mch";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

RULES {
	
	Machine ::= 
		"MACHINE" name[]
		("SET" sets (";" sets)*)?
		("VARIABLES" variables ("," variables)*)?
		("INVARIANT" invariants ("/\\" invariants)*)?
		("INITIALISATION" initialisations ("||" initialisations)*)?
		("OPERATIONS" operations (";" operations)*)?
		"END"
		;
	
	SET ::= name[];

	Variable ::= name[]; // | "preceeds"  ":" preceeds[]| "type"  ":" type[] )* "}"  ;

	// TODO this will not work, since expressions do not confirm to the default
	// token (TEXT)	
	Expression ::= expression[];
	Action     ::= expression[];
	Predicate  ::= expression[];
	Any        ::= expression[];
	If         ::= expression[];
	Begin      ::= expression[];
	
	Operation ::= outputs "<--" name[] ("(" inputs ")")? "=="
		("PRE" preconditions ("/\\")* "THEN")?
		statements ("||" statements)*
		"END";
	
	Skip ::= "SKIP";
	
	// TODO the EGL script does only write variables that are defined?!
	VariableList ::= variables ("," variables)*;
}