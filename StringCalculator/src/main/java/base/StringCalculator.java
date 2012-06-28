package base;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER = ",";

	public int add(String expression) {
		
		if( expression.isEmpty() ){
			return 0;
		}
		if( expression.contains(DEFAULT_DELIMITER) ){
			String[] numberLiterals = expression.split(DEFAULT_DELIMITER);
			return toInt( numberLiterals[0] ) + toInt( numberLiterals[1] );
		}
		return toInt(expression);
	}

	private int toInt(String expression) {
		return Integer.parseInt(expression);
	}

}
