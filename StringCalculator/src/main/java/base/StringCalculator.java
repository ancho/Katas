package base;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER = ",";
	private static final String NEWLINE_DELIMITER = "\n";
	private static final String DELIMITER_EXPRESSION = "[" + DEFAULT_DELIMITER + NEWLINE_DELIMITER + "]";

	public int add(String expression) {
		
		return calculateSum(expression);
	}

	private int calculateSum(String expression) {
		
		int sum = 0;
		
		for (String numberLiteral : expression.split(DELIMITER_EXPRESSION)) {
			if( numberLiteral.isEmpty() ) continue;
			sum += toInt(numberLiteral);
		}
		return sum;
	}

	private int toInt(String numberLiteral) {
		return Integer.parseInt(numberLiteral);
	}

}
