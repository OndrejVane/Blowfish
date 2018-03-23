package blow_fish;



public class BinOperations {
	
	
	/**
	 * Function which convert integer number to eight-length
	 * binary number. Number is store as string. 
	 * @param number		Integer number from 0 to 255.
	 * @return text		String with binary representation of number.
	 */
	private static String decToByte(int number) {
		String text;
		String temp = "";
		int numberOfZero;
		
		text = Integer.toBinaryString(number);
		
		if(text.length() != 8) {
			numberOfZero = 8-text.length();
			for(int i = 0; i<numberOfZero; i++) {
				temp = temp + "0";
			}
			text = temp + text;
		}
		return text;
	}

	/**
	 * Function which transform text to binary number. Each letter is transformed
	 * to 8-bit length bin number.
	 * @param text		Input text.
	 * @return			Transformed text in binary number.
	 */
	public static String stringToBinary(String text) {
		
		String bin = "";
		
		for(int i=0; i<text.length(); i++) {
			bin = bin + decToByte(text.charAt(i));
		}
		return bin;
	}
	
	/**
	 * Function which is represent XOR function.
	 * @param input1			Input first bin number.
	 * @param input2			Input second bin number.
	 * @return				Return result of XOR function.
	 */
	public static String functionXor(String input1, String input2) {
		
		String result = "";
		
		for(int i = 0; i<input1.length(); i++) {
			if(input1.charAt(i) == input2.charAt(i)) {
				result = result + "0";
			}else {
				result = result + "1";
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(functionXor("10101101", "10101101"));
		System.out.println(functionXor("10101101", "01010010"));
		System.out.println(functionXor("0111011010101", "1011000100100"));
	}

}
