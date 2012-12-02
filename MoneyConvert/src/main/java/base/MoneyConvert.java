package base;

import java.util.HashMap;
import java.util.Map;

public class MoneyConvert {

	private static Map<Integer, String> dictionary = new HashMap<Integer, String>();

	private int amount = 0;

	static {
		dictionary.put(1, "one");
		dictionary.put(2, "two");
		dictionary.put(3, "three");
		dictionary.put(4, "four");
		dictionary.put(5, "five");
		dictionary.put(6, "six");
		dictionary.put(7, "seven");
		dictionary.put(8, "eight");
		dictionary.put(9, "nine");
		dictionary.put(10, "ten");
		
		dictionary.put(11, "eleven");
		
		dictionary.put(20, "twenty");
		dictionary.put(30, "thirty");
		dictionary.put(40, "fourty");
		dictionary.put(50, "fifty");
		dictionary.put(60, "sixty");
		dictionary.put(70, "seventy");
		dictionary.put(80, "eighty");
		dictionary.put(90, "ninety");

	}

	public String convert(int amount) {
		String amountAsString = "";
		this.amount = amount;

		amountAsString += convertFourDigit();
		amountAsString += convertThreeDigit();
		amountAsString += convertDoubleDigit();
		amountAsString += convertSingleDigit();
		return amountAsString;
	}

	private String convertFourDigit() {
		String amountAsString = "";
		if (amount >= 1000) {
			int fourDigitAmount = amount / 1000;
			updateAmount(fourDigitAmount*1000);
			amountAsString += new MoneyConvert().convert(fourDigitAmount);
			amountAsString += "thousand";
		}
		return amountAsString;
	}

	private String convertThreeDigit() {
		String amountAsString = "";
		if (amount >= 100) {
			int threeDigitAmount = amount / 100;
			updateAmount(threeDigitAmount * 100);
			amountAsString += lookup(threeDigitAmount);
			amountAsString += "hundret";
		}
		return amountAsString;
	}

	private String convertSingleDigit() {
		int singleDigit = amount % 10;
		return lookup(singleDigit);
	}

	private String convertDoubleDigit() {
		int doubleDigit = 0;
		if( dictionary.containsKey( amount )){
			doubleDigit = amount;
		}
		else{
			doubleDigit = (amount / 10) * 10;
		}
		updateAmount(doubleDigit);
		return lookup(doubleDigit);
	}

	private void updateAmount(int value) {
		amount -= value;
	}

	private String lookup(int key) {
		if (dictionary.containsKey(key)) {
			return dictionary.get(key);
		}
		return "";
	}
}
