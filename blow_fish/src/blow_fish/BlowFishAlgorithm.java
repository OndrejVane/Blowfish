package blow_fish;



public class BlowFishAlgorithm {
	
	public static String text;
	public static String key;
	
	public static void getText(String inputText) {
		text = inputText;
	}
	
	public static void getKey(String inputKey) {
		key = inputKey;
	}
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

	public static String stringToBinary(String text) {
		
		String bin = "";
		
		for(int i=0; i<text.length(); i++) {
			bin = bin + decToByte(text.charAt(i));
		}
		return bin;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(stringToBinary("test"));
		
	}

}
