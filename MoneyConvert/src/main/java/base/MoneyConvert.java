package base;

import java.util.HashMap;
import java.util.Map;

public class MoneyConvert {

	private static Map<Integer, String> dictionary = new HashMap<Integer, String>();
	private StringBuffer convertedNumber = new StringBuffer();
	
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
		dictionary.put(20, "twenty");
		dictionary.put(30, "thirty");
		dictionary.put(40, "fourty");
		dictionary.put(50, "fifty");
		dictionary.put(60, "sixty");
		dictionary.put(70, "seventy");
		dictionary.put(80, "eighty");
		dictionary.put(90, "ninety");
		dictionary.put(11, "eleven");
		dictionary.put(12, "twelve");
		dictionary.put(13, "thirteen");
		dictionary.put(14, "fourteen");
		dictionary.put(15, "fifteen");
		dictionary.put(16, "sixteen");
		dictionary.put(17, "seventeen");
		dictionary.put(18, "eighteen");
		dictionary.put(19, "nineteen");
		
		dictionary.put(100, "hundret");
		dictionary.put(1000, "thousand");

		
	}
	
	public String convert(int amount) {
		amountToString(amount);
		
		String convertedAmount = convertedNumber.toString();
		convertedNumber.setLength(0);
		
		return convertedAmount;
	}

	private void amountToString(int amount) {
		
		amount = convertFourDigitAmount(amount);
		amount = convertTripleDigitAmount(amount);
		amount = convertDoubleDigitAmount(amount);
		convertSingleDigitAmount(amount);
	}



	private void convertSingleDigitAmount(int amount) {
		int singleDigitAmount = amount % 10;
		if ( singleDigitAmount > 0 ){
			convertedNumber.append( dictionary.get(singleDigitAmount) );
		}
	}

	private int convertDoubleDigitAmount(int amount) {

		int doubleDigitAmount = amount % 100;
		int doubleDigitIndex = calculateDoubleDigitIndex(doubleDigitAmount);
		
		String number = dictionary.get(doubleDigitIndex);
		
		if ( number != null ){
			convertedNumber.append( number );
			return amount - doubleDigitIndex;
		}
		return amount;
	}

	private int convertTripleDigitAmount(int amount) {
		if ( amount >= 100 ){
			int tribleDigitAmount = amount % 1000;
			int singlDigitIndex = tribleDigitAmount / 100;
			
			convertSingleDigitAmount(singlDigitIndex);
			convertedNumber.append( dictionary.get(100) );
			amount = amount - (singlDigitIndex * 100);
			if(amount>0){
				convertedNumber.append("and");
			}
		}
		return amount;
	}

	private int convertFourDigitAmount(int amount) {
		if ( amount >= 1000 ){
			int fourDigitAmount = ( amount / 1000 ) * 1000;
			int singleDigitIndex = fourDigitAmount/1000;
			
			amountToString(singleDigitIndex);
			convertedNumber.append(dictionary.get(1000));
			amount = amount - fourDigitAmount;
			
		}
		return amount;
	}
	
	private int calculateDoubleDigitIndex(int amount) {
		
		if ( dictionary.containsKey(amount) ){
			return amount;
		}
		return (amount / 10) * 10;
	}

}
