package base;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER = ",";

	public int add(String expression) {
		
		return calculateSum(expression);
	}

	private int calculateSum(String delimitedNumbers) {
		int sum = 0;

		if( ! delimitedNumbers.isEmpty() ){
			String[] numberLiterals = delimitedNumbers.split(DEFAULT_DELIMITER);
			
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
