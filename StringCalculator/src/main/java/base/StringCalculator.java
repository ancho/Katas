package base;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER = ",";
	private static final String NEWLINE_DELIMITER = "\n";
	private static final String DELIMITER_EXPRESSION = "[" + DEFAULT_DELIMITER + NEWLINE_DELIMITER + "]";

	public int add(String expression) {
		String[] numberLiterals = parse(expression);
		return calculateSum(numberLiterals);
	}

	private String[] parse(String expression) {
		String[] numberLiterals = expression.split(DELIMITER_EXPRESSION);
		return numberLiterals;
	}

	private int calculateSum(String[] numberLiterals) {
		
		int sum = 0;
		
		for (String numberLiteral : numberLiterals) {
			if( numberLiteral.isEmpty() ) continue;
			sum += toInt(numberLiteral);
		}
		return sum;
	}

	private int toInt(String numberLiteral) {
		return Integer.parseInt(numberLiteral);
	}

}
