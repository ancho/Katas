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
	public void singleDigitsConvert() throws Exception {
		assertThat(mc.convert(0), is(""));
		assertThat(mc.convert(1), is("one"));
		assertThat(mc.convert(2), is("two"));
		assertThat(mc.convert(3), is("three"));
		assertThat(mc.convert(4), is("four"));
		assertThat(mc.convert(5), is("five"));
		assertThat(mc.convert(6), is("six"));
		assertThat(mc.convert(7), is("seven"));
		assertThat(mc.convert(8), is("eight"));
		assertThat(mc.convert(9), is("nine"));
	}

}
