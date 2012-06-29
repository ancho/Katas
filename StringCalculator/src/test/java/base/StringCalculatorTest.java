package base;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {


	private StringCalculator calculator;

	@Before
	public void initCalculator() {
		calculator = new StringCalculator();
	}

	@Test
	public void empty_string_should_retrun_zero() {
		assertThat( calculator.add(""), is(0));
	}

	@Test
	public void single_number_literal_returns_its_value() throws Exception {
		assertThat( calculator.add("42"), is(42));
	}
	
	@Test
	public void two_delimited_number_literals_returns_sum() throws Exception {
		assertThat( calculator.add("1,2"), is(3));
	}
	
	@Test
	public void multiple_delimited_number_literals_returns_sum() throws Exception {
		assertThat( calculator.add("1,2,3,4"), is(10));
	}
	

}
