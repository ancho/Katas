package base;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER = ",";

	public int add(String expression) {
		
		return calculateSum(expression);
	}

	private int calculateSum(String expression) {
		
		int sum = 0;
		
		for (String numberLiteral : expression.split(DEFAULT_DELIMITER)) {
			if( numberLiteral.isEmpty() ) continue;
			sum += toInt(numberLiteral);
		}
		return sum;
	}

	private int toInt(String numberLiteral) {
		return Integer.parseInt(numberLiteral);
	}

}
