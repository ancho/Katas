package base;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator calculator;
	
	@Before
	public void setUp(){
		calculator = new StringCalculator();
	}
	
	@Test
	public void empty_string_should_evaluate_to_zero() {
		assertThat( calculator.add(""), is(0) );
	}
	
	@Test
	public void single_literal_number_should_avaluate_ist_value() throws Exception {
		assertThat( calculator.add("42"), is(42) );
	}
	
	@Test
	public void literal_numbers_with_delimiter_should_evaluate_to_sum() throws Exception {
		assertThat( calculator.add( "1,2" ), is(3) );
	}
	
	@Test
	public void multiple_literal_numbers_with_delimiters_should_evaluate_to_sum(){
		assertThat( calculator.add("1,2,3"), is(6) );
	}
	
	@Test
	public void newline_between_numbers_should_be_recognized() throws Exception {
		assertThat( calculator.add("1\n2,3"), is(6));
	}
	
	@Test
	public void custom_delimiter_should_be_possible() throws Exception {
		assertThat( calculator.add("//;\n1;2;3"), is(6) );
	}
	
	@Test
	public void negative_number_literals_should_be_ignored() throws Exception {
		assertThat( calculator.add("-1"), is(0) );
		assertThat( calculator.add("1,-2,3"), is(4) );
	}

}
