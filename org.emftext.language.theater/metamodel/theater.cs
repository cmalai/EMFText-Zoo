SYNTAXDEF theater
FOR <http://www.emftext.org/language/theater>
START Play

OPTIONS { 
	overrideManifest="false";
	usePredefinedTokens="false";
	overrideClasspath="false";
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";	
}

TOKENS{
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE NAME $('A'..'Z' | 'a'..'z' | '0'..'9' )+$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	
}

RULES{
	
	Play::= "play" name['"','"'] "roles" "(" declaredRoles* ")" ensemble  acts*;
	
	Ensemble::= "ensemble" "(" actors* ")" ;
	
	Actor::= name['"','"'] "plays" (plays['"','"'])+ ",";
	
	Role::= name['"','"'];
	
	Act::= "Actus" name[NAME] "." scenes*;
	
	Scene::=  "Scena" name[NAME] "." elements*;
	
	Speech::= playedBy[NAME]("," playedBy[NAME])* ":"  text['"','"'];
	
	Direction ::= text['[',']'];
}