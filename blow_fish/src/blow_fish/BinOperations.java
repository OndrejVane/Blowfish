package blow_fish;



/**
 * This class contain some basic binary operations which 
 * are used in Blowfish cipher.
 * 
 * @author ondrejvane
 * @version 1.0
 *
 */
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
	
	/**
	 * Function which is add two binary numbers. The result is modulated
	 * by value 2^32. So max value of adding is 2^32.
	 * @param s1		First binary number.
	 * @param s2		Second binary number.
	 * @return		Result of adding first and second number.
	 */
	public static String binaryAdd(String s1, String s2) {
	    
		if (s1 == null || s2 == null) return "";
	    int first = s1.length() - 1;
	    int second = s2.length() - 1;
	    StringBuilder sb = new StringBuilder();
	    int carry = 0;
	    
	    while (first >= 0 || second >= 0) {
	        int sum = carry;
	        if (first >= 0) {
	            sum += s1.charAt(first) - '0';
	            first--;
	        }
	        if (second >= 0) {
	            sum += s2.charAt(second) - '0';
	            second--;
	        }
	        carry = sum >> 1;
	        sum = sum & 1;
	        sb.append(sum == 0 ? '0' : '1');
	    }
	    

	    sb.reverse();
	    return String.valueOf(sb);
	}
	

}
