package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorParser {

	private static final String CALCULATOR_PATTERN = "(//(.)\n)?((-?\\d+.?)+)";
	private static final String NEWLINE_DELIMITER = "\n";
	private static final String DEFAULT_DELIMITER = ",";
	private List<String> numberLiterals;
	private Pattern pattern;

	public CalculatorParser() {
		numberLiterals = new ArrayList<String>();
		pattern = Pattern.compile(CALCULATOR_PATTERN, Pattern.DOTALL);
	}

	public List<String> parse(String expression) {
		
		Matcher matcher = pattern.matcher(expression);
		
		if( matcher.find() ){
			String delimiterRegex = getDelimiterRegex(matcher);
			split(matcher, delimiterRegex);
		}
		return numberLiterals;
	}


	private String getDelimiterRegex(Matcher matcher) {
		String delimiter = matcher.group(2);
		
		if( delimiter == null ){
			delimiter = DEFAULT_DELIMITER;
		}
		return "[" + delimiter + NEWLINE_DELIMITER + "]";
	}

	private void split(Matcher matcher, String delimiter) {
		String delimitedNumbers = matcher.group(3);
		if( delimitedNumbers != null ){
			String[] splittedLiterals = delimitedNumbers.split(delimiter);
			numberLiterals = Arrays.asList( splittedLiterals );
		}
	}
}
