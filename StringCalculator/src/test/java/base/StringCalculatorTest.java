package base;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void empty_string_should_retrun_zero() {
		StringCalculator calculator = new StringCalculator();
		assertThat( calculator.add(""), is(0));
	}

	@Test
	public void single_number_literal_returns_its_value() throws Exception {
		StringCalculator calculator = new StringCalculator();
		assertThat( calculator.add("42"), is(42));
	}
	

}
