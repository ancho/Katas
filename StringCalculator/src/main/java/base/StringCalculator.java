package base;

import java.util.List;


public class StringCalculator {

	public int add(String expression) {
		CalculatorParser parser = new CalculatorParser();
		return calculateSum(parser.parse(expression));
	}

	private int calculateSum(List<String> numberLiterals) {
		
		int sum = 0;
		
		for (String numberLiteral : numberLiterals) {
			int number = toInt(numberLiteral);
			if( number < 0 ) continue;
			sum += number;
		}
		return sum;
	}

	private int toInt(String numberLiteral) {
		return Integer.parseInt(numberLiteral);
	}

}
