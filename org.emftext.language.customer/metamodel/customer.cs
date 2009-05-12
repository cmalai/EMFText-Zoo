SYNTAXDEF customer
FOR <http://www.emftext.org/language/customer>
START Customer

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENS {
	DEFINE T_VEGETARIAN $'vegetarian'$;
}

TOKENSTYLES {
	"CUSTOMER" COLOR #009bd3, BOLD;
	"WANTS" COLOR #009bd3, BOLD;
	"SOMETHING" COLOR #009bd3, BOLD;
	"TEXT" COLOR #202020;
}

RULES {
	Customer ::= "CUSTOMER" name[] ("(" isVegetarian[T_VEGETARIAN] ")")? "WANTS" requests*;
	ExtraIngredient ::= name[];
}