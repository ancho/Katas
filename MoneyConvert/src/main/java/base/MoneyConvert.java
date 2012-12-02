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
		
	}
	public String convert(int amount) {
		return convertSingleDigit(amount);
	}
	
	private String convertSingleDigit(int amount) {
		return dictionary.get(amount);
	}

}
