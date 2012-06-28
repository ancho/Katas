package base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringCalculator {

	private static final String NEWLINE = "\n";
	private static final String DEFAULT_DELIMITER = ",";
	private static final String DELIMITER_REGEX = "[" + DEFAULT_DELIMITER + NEWLINE + "]";

	public int add(String expression) {
		String[] parsedExpression = parse( expression );
		
		String delimiterExpression = parsedExpression[0];
		String numberLiterals = parsedExpression[1];
		
		return calculateSum(numberLiterals, delimiterExpression);
	}

	private String[] parse(String expression) {
		//TODO: parse expression; match delimiter and numberLiterals; return both as array of string;
		String[] splittetCalculatorInformation = new String[2];
		String calculator_pattern = "^(//(.)\n)?(.*)$";
		String delimiter = DEFAULT_DELIMITER;
		String numberLiterals = null;
		
		
		Pattern pattern = Pattern.compile(calculator_pattern, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(expression);
		
		if( matcher.find() ){
			if( matcher.group(2) != null ){
				delimiter = matcher.group(2);
			}
			
			numberLiterals = matcher.group(3);
		}
		
		
		splittetCalculatorInformation[0] = getDelimiterExpression( delimiter );
		splittetCalculatorInformation[1] = numberLiterals;
				
		return splittetCalculatorInformation;
	}

	private String getDelimiterExpression(String delimiter) {
		return "[" + delimiter + NEWLINE + "]";
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
