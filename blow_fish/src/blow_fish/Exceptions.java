package blow_fish;



/**
 * This class contain own exceptions to check input text
 * in UserInterface.
 * @author ondrejvane
 * @version 1.0
 */
class InvalidCharException extends Exception{  
	 /**
	 * Define new exception.
	 */
	private static final long serialVersionUID = 1L;

	InvalidCharException(String s){  
	  super(s);  
	 }  
	}  


/**
 * @author ondrejvane
 *
 */
class CharException{
		
	/**
	 * This function check input text. When the text contain some letters which
	 * is not in 8-bit table it throw exception.
	 * @param input						Checking input text.
	 * @throws InvalidCharException		Exception which is marks the text as invalid.
	 */
	static void validateChar(String input)throws InvalidCharException{  
		   
		for(int i = 0; i<input.length(); i++) {				
			if(input.charAt(i) > 255) {
				
				throw new InvalidCharException("Bad char");
				
			}
				   
		} 
	}
}

/**
 * @author ondrejvane
 *
 */
class InvalidInputException extends Exception{  
	 /**
	 * Define new exception.
	 */
	private static final long serialVersionUID = 2L;

	InvalidInputException(String n){  
	  super(n);  
	 }  
	}  


/**
 * @author ondrejvane
 *
 */
class InputException{
		
	/**
	 * This function check input text. When the text is empty throw exception.
	 * @param input						Checking input text.
	 * @throws InvalidInputException		Exception which is marks the text is empty.
	 */
	static void validateInput(String input)throws InvalidInputException{  
		   	
		if(input.length() == 0) {
			throw new InvalidInputException("Bad input!");
		}
		   
	} 
}



