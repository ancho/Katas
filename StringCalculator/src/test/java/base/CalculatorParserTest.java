package base;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;


import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CalculatorParserTest {

	private CalculatorParser parser;

	@Before
	public void setUp() {
		parser = new CalculatorParser();
	}

	@Test
	public void empty_expression_should_return_empty_list(){
		assertThat( parser.parse("").size(), is(0));
	}
	
	@Test
	public void should_recognize_default_number_literals_pattern() throws Exception {
		String expression = "1,2,3,4";
		assertThat(parser.parse(expression) , hasItems( expression.split(",")) );
	}
	
	@Test
	public void should_recognize_custom_delimiter() throws Exception {
		String numberLiterals = "1;2;3";
		assertThat( parser.parse("//;\n" + numberLiterals), hasItems( numberLiterals.split(";")) );
	}
	
	@Test
	public void should_recognize_newline_as_delimiter() throws Exception {
		String expression = "1\n2,3";
		assertThat( parser.parse(expression), hasItems( expression.split("[\n,]")));
	}

}
