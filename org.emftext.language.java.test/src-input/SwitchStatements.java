public class SwitchStatements {
	{
		switch (3) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}
	}
	public void switchStatement() {
		switch (4) {
			case 1:
				break;
			case 2:
				break;
			default:
				break;
		}
	}
	
	public void switchWithExpression() {
		switch (4 + 3) {
			case 1:
				break;
			case 2:
				break;
			default:
				break;
		}
	}
	
	public void switchWithExpression2() {
		int i = 4;
		switch (i + 3) {
			case 1:
				break;
			case 2:
				break;
			default:
				break;
		}
	}
	
	public void caseWithOneStatement() {
		switch (4) {
			case 1:
				switchStatement();
				break;
			default:
				break;
		}
	}
	
	public void caseWithTwoStatements() {
		switch (4) {
			case 2:
				switchStatement();
				switchStatement();
				break;
			default:
				break;
		}
	}
	
	public void caseWithBlockAsStatement() {
		switch (4) {
			case 1:
				switchStatement();
				break;
			case 2:
				{
					switchStatement();
				}
				break;
			default:
				break;
		}
	}
	
	public void defaultCaseWithMultipleStatements() {
		switch (4) {
			case 1:
				break;
			case 2:
				break;
			default:
				switchStatement();
				{
					switchStatement();
				}
				break;
		}
	}
	
	public void switchMultipleCases() {
		switch (4) {
			case 1:
				break;
			case 2:
			case 3:
			case 4:
				break;
			default:
				break;
		}
	}

	public void switchWithDefaultCaseFirst() {
		switch (3) {
			default: break;
			case 0: break;
		}
	}
	
	public void switchWithDefaultMiddle(){
		switch (2){
		case 0: break;
		default : break;
		case 1 : break;
		}
	}
	
	public void switchWithNoDefault(){
		switch(2){
		case 0 : break;
		case 1 : break;
		}
	}
}