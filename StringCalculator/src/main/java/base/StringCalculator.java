package base;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	private static final String CACLULATOR_PATTERN = "^(//(.)\n)?(.*)$";

	class CalculatorInformation{
		private String delimiterRegex;
		private List<String> numberLiterals;
		
		public String getDelimiterRegex() {
			return delimiterRegex;
		}
		public void setDelimiterRegex(String delimiterRegex) {
			this.delimiterRegex = delimiterRegex;
		}
		public List<String> getNumberLiterals() {
			return numberLiterals;
		}
		public void setNumberLiterals(String... numberLiterals) {
			this.numberLiterals = Arrays.asList(numberLiterals);
		}
		
	}

	private static final String NEWLINE = "\n";
	private static final String DEFAULT_DELIMITER = ",";

	public int add(String expression) {
		CalculatorInformation calcInfo = parse( expression );
		
		return calculateSum(calcInfo);
	}

	private CalculatorInformation parse(String expression) {
		CalculatorInformation calcInfo = new CalculatorInformation();
		
		String delimiter = DEFAULT_DELIMITER;
		String numberLiterals = null;
		
		Pattern pattern = Pattern.compile(CACLULATOR_PATTERN, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(expression);
		
		if( matcher.find() ){
			if( matcher.group(2) != null ){
				delimiter = matcher.group(2);
			}
			
			numberLiterals = matcher.group(3);
		}
		
		calcInfo.setDelimiterRegex( getDelimiterExpression( delimiter ) );
		
		String[] numberList = splitNumberLiterals( numberLiterals, getDelimiterExpression(delimiter) );
		calcInfo.setNumberLiterals( numberList );
				
		return calcInfo;
	}

	private String[] splitNumberLiterals(String numberLiterals, String delimiterExpression) {

		return numberLiterals.split( delimiterExpression );
	}

	private String getDelimiterExpression(String delimiter) {
		return "[" + delimiter + NEWLINE + "]";
	}

	private int calculateSum(CalculatorInformation calcInfo) {
		int sum = 0;
		
		for (String numberLiteral : calcInfo.getNumberLiterals() ) {
			if( numberLiteral.isEmpty() ) continue;
			
			int number = toInt( numberLiteral );
			
			if( number < 0 ) continue;
			sum += number;
		}
		return sum;
	}

	private int toInt(String numberLiteral) {
		return Integer.parseInt(numberLiteral);
	}

}
