package base;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class MoneyConvertTest {

	@Test
	public void convert_0_to_EmptyString() {
		MoneyConvert mc = new MoneyConvert();
		assertThat(mc.convert(0), is(""));
	}
	
	@Test
	public void convert_1_to_one() throws Exception {
		MoneyConvert mc = new MoneyConvert();
		assertThat(mc.convert(1), is("one"));
	}

}
