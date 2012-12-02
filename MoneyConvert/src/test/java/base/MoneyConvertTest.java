package base;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyConvertTest {

	private MoneyConvert mc;
	
	
	@Before
	public void setUp() {
		mc = new MoneyConvert();
	}

	@Test
	public void convert_0_to_EmptyString() {
		assertThat(mc.convert(0), is(""));
	}
	
	@Test
	public void convert_1_to_one() throws Exception {
		assertThat(mc.convert(1), is("one"));
	}
	
	@Test
	public void convert_2_to_two() throws Exception {
		assertThat(mc.convert(2), is("two"));
	}

}
