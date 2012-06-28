package base;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void empty_string_should_evaluate_to_zero() {
		StringCalculator calculator = new StringCalculator();
		assertThat( calculator.add(""), is(0) );
	}
	
	@Test
	public void single_literal_number_should_avaluate_ist_value() throws Exception {
		StringCalculator calculator = new StringCalculator();
		assertThat( calculator.add("42"), is(42) );
	}

}
