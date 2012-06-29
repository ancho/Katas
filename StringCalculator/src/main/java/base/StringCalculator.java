package base;

public class StringCalculator {

	public int add(String expression) {
		
		if( expression.isEmpty() ) return 0;
		return Integer.parseInt(expression);
	}

}
