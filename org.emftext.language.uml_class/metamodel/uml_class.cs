SYNTAXDEF uml_class
FOR <http://org.emftext/uml_class>
START ClassDiagramm

OPTIONS{
    generateCodeFromGeneratorModel = "true";
    reloadGeneratorModel = "true";
    overrideManifest = "false";
}

TOKENS{
		DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
}

TOKENSTYLES {
    "classdiagramm" COLOR #0000CC, BOLD;
    "ac" COLOR #0000CC, BOLD;
    "md" COLOR #0000CC, BOLD;
    "void" COLOR #0000CC, BOLD;
    "class" COLOR #0000CC, BOLD;
    "extends" COLOR #0000CC, BOLD; 
    "attribute" COLOR #0000CC, BOLD;
    "method" COLOR #0000CC, BOLD;
    "association" COLOR #0000CC, BOLD;
    "p" COLOR #0000CC, BOLD;
    "->" COLOR #0000CC, BOLD;
    ".." COLOR #0000CC, BOLD;
    ":" COLOR #0000CC, BOLD;
    "BOOLEAN" COLOR #00BBCC, BOLD;
    "STRING" COLOR #00BBCC, BOLD;
    "INTEGER" COLOR #00BBCC, BOLD;
    "TYPE" COLOR #00BBCC, BOLD;
   
}

RULES{
		
		ClassDiagramm::= "classdiagramm"  name[]
		                  "{" 
		                          primitiveDatatypes*
		                          class*
		                          association*
		                  		  
		                  "}"  ;
		
		Method::=	"method" 
					( "ac" access[])?
		          	( "md" modifier[] )*
		          	name[]
		          	"("
		          	    (parameter ("," parameter)*)? 
		          	")" ":"
		          	(return[]? | "void" | ("p" p_return[])? )
		          	;
		
		Attribute::=  "attribute"
					  ( "ac" access[])?
		              ( "md" modifier[] )*
		              name[]
		              ":"
		              ( type[]? | ("p" p_type[])? )
		              ;
		              
		Parameter::=  name[] ":" ( type[]? | ("p" p_type[])? ) ;
		
		Class::= "class"
					( "ac" access[])?
                    ( "md" modifier[] )*
                    name[]
                    ("extends" parent[])?
                    "{"
                         attribute* 
                         method*
                   	"}"
                    ;
		
		Association::= "association"
		                  targetDesc[]
		                  "("
		                      source[] "->" target[]
		                      ":"
		                      minCardinality['"','"']
		                      ".."
		                      maxCardinality['"','"']
		                  ")" ;
		                  
	    Boolean ::= "BOOLEAN" placeholder[] value? ;
        
        String ::= "STRING" placeholder[] value? ;
        
        Integer ::= "INTEGER" placeholder[] value? ;
        
        //allgemeiner Typ, verwendbar f�r die Erstellung von Regeln
        PrimitiveDataType ::= "TYPE" placeholder[] ; 
        
        BooleanObject ::= value['"','"'] ; 
        
        IntegerObject ::= value['"','"'] ;
        
        StringObject ::= value['"','"'];
		
}