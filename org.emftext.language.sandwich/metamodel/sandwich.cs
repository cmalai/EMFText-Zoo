SYNTAXDEF sandwich
FOR <http://www.emftext.org/language/sandwich>
START Recipe

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	tokenspace = "1";
}

TOKENSTYLES {
	"RECIPE" COLOR #000000, BOLD;
	"TOAST" COLOR #9d3838, BOLD;
	"ADD" COLOR #008000, BOLD;
	"CLEAN" COLOR #009bd3, BOLD;

	"TEXT" COLOR #000000;
}

RULES {
	Recipe ::= "RECIPE" ingredients* instructions*;
	Ingredient ::= name;
	IngredientName ::= value[];
	Clean ::= "CLEAN" using[]?;
	Add ::= "ADD" using[]?;
	Toast ::= "TOAST" using[]?;
}