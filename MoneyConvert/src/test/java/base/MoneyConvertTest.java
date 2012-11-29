package base;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MoneyConvertTest {

	
	private MoneyConvert mc;

	@Before
	public void setUp() {
		mc = new MoneyConvert();
	}
	
	@Test
	public void convert_1_to_9() {
		assertConvertedNumber(1, "one");
		assertConvertedNumber(2, "two");
		assertConvertedNumber(3, "three");
		assertConvertedNumber(4, "four");
		assertConvertedNumber(5, "five");
		assertConvertedNumber(6, "six");
		assertConvertedNumber(7, "seven");
		assertConvertedNumber(8, "eight");
		assertConvertedNumber(9, "nine");
	}
	
	@Test
	public void convert_10_to_90() throws Exception {
		
		assertConvertedNumber(10, "ten");
		assertConvertedNumber(20, "twenty");
		assertConvertedNumber(30, "thirty");
		assertConvertedNumber(40, "fourty");
		assertConvertedNumber(50, "fifty");
		assertConvertedNumber(60, "sixty");
		assertConvertedNumber(70, "seventy");
		assertConvertedNumber(80, "eighty");
		assertConvertedNumber(90, "ninety");
	}
	
	@Test
	public void convert_11_to_19() throws Exception {
		assertConvertedNumber(11, "eleven");
		assertConvertedNumber(12, "twelve");
		assertConvertedNumber(13, "thirteen");
		assertConvertedNumber(14, "fourteen");
		assertConvertedNumber(15, "fifteen");
		assertConvertedNumber(16, "sixteen");
		assertConvertedNumber(17, "seventeen");
		assertConvertedNumber(18, "eighteen");
		assertConvertedNumber(19, "nineteen");
	}

	@Test
	public void convert_21_to_twentyone() throws Exception {
		assertConvertedNumber(21, "twentyone");
		assertConvertedNumber(22, "twentytwo");
		assertConvertedNumber(23, "twentythree");
		assertConvertedNumber(44, "fourtyfour");
	}
	
	@Test
	public void convert_100_to_300() throws Exception {
		assertConvertedNumber(100, "onehundret");
		assertConvertedNumber(200, "twohundret");
		assertConvertedNumber(300, "threehundret");
	}
	
	@Test
	public void convert_121_to_onehundretandtwentyone() throws Exception {
		assertConvertedNumber(111, "onehundretandeleven");
		assertConvertedNumber(121, "onehundretandtwentyone");
	}
	
	@Test
	public void convert_1000_to_onethousand() throws Exception {
		assertConvertedNumber(1000, "onethousand");
	}
	
	@Test
	public void convert_1001_to_onethousandone() throws Exception {
		assertConvertedNumber(1001, "onethousandone");
	}

	@Test
	public void convert_1234_to_onethousandtwohundretandthirtyfour() throws Exception {
		assertConvertedNumber(1234, "onethousandtwohundretandthirtyfour");
	}
	
	@Test
	public void convert_10000_to_tenthousand() throws Exception {
		assertConvertedNumber(10000, "tenthousand");
	}
	
	@Test
	public void convert_11111_to_eleventhousandonehundretandeleven() throws Exception {
		assertConvertedNumber(11111, "eleventhousandonehundretandeleven");
	}
	
	@Test
	public void convert_111111_to_onehundreteleventhousandonehundretandeleven() throws Exception {
		assertConvertedNumber(111111, "onehundretandeleventhousandonehundretandeleven");
	}
	
	@Test
	public void convert_999999_to_ninehundretandninethousandandninetynine() throws Exception {
		assertConvertedNumber(999999, "ninehundretandninetyninethousandninehundretandninetynine");
	}




	private void assertConvertedNumber(int amount, String convertedString) {
		assertThat( mc.convert(amount), is(convertedString));
	}
	

}
