package base;

public class MoneyConvert {

	public String convert(int amount) {
		if ( amount == 1 ){
			return "one";
		}
		else if ( amount == 2 ) {
			return "two";
		}
		return "";
	}

}
