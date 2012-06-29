package base;

public class StringCalculator {

	public int add(String expression) {
		
		if( expression.isEmpty() ) return 0;
		
		if( expression.contains(",")){
			String[] numberLiterals = expression.split(",");
			return Integer.parseInt(numberLiterals[0]) + Integer.parseInt(numberLiterals[1]);
		}
		return Integer.parseInt(expression);
	}

}
