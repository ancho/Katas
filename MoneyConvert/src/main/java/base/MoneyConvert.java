package base;

import java.util.HashMap;
import java.util.Map;

public class MoneyConvert {

	private static Map<Integer, String> dictionary = new HashMap<Integer, String>();
	
	static {
		dictionary.put(0, "");
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
		
		int doubleDigit = (amount / 10) * 10;
		amountAsString += convertSingleDigit(doubleDigit);
		
		int singleDigit = amount % 10;
		amountAsString += convertSingleDigit(singleDigit);
		return amountAsString;
	}
	
	private String convertSingleDigit(int amount) {
		return dictionary.get(amount);
	}

}
