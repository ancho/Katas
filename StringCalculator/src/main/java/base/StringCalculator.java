package base;

public class StringCalculator {

	private static final String NEWLINE = "\n";
	private static final String DEFAULT_DELIMITER = ",";
	private static final String DELIMITER_REGEX = "[" + DEFAULT_DELIMITER + NEWLINE + "]";

	public int add(String expression) {
		
		return calculateSum(expression, DELIMITER_REGEX);
	}

	private int calculateSum(String delimitedNumbers, String delimiterRegex) {
		int sum = 0;

		if( ! delimitedNumbers.isEmpty() ){
			String[] numberLiterals = delimitedNumbers.split( delimiterRegex );
			
			for (String numberLiteral : numberLiterals) {
				sum += toInt(numberLiteral);
			}
		}			
		return sum;
	}

	private int toInt(String numberLiteral) {
		return Integer.parseInt(numberLiteral);
	}

}
