package blow_fish;


/**
 * This class contain all functions which are used for
 * Blowfish cipher method.
 * 
 * @author ondrejvane
 * @version 1.0
 *
 */
public class BlowfishAlgorithm {
	
	
    private static int s_box_1[] = {

    		1415, 2653, 5897, 9323, 8462, 6433, 8327, 9502, 8841, 9716, 9399, 3751,
    		1582, 2974, 9445, 9230, 7816, 4062, 8620, 8998, 6280, 3482, 5342, 1170,
    		6795, 8214, 8086, 5132, 8230, 6647, 3938, 4460, 9550, 5822, 3172, 5359,
    		4081, 2848, 1117, 4502, 8410, 2701, 9385, 2110, 5559, 6446, 2294, 8954,
    		9303, 8196, 2442, 8810, 9756, 6593, 3446, 1284, 7564, 8233, 7867, 8316,
    		5271, 2019, 4914, 5648, 5669, 2346, 5348, 6104, 5432, 6648, 2133, 9360,
    		7260, 2491, 4127, 3372, 4587, 2066, 9631, 5588, 1748, 8152, 6920, 9628,
    		2925, 4091, 7153, 6436, 7892, 5903, 6001, 1330, 5305, 4882, 7466, 5213,
    		8414, 6951, 9415, 1160, 9413, 3057, 2703, 6575, 9591, 9530, 9218, 6117,
    		3819, 3261, 1793, 1051, 1854, 8074, 4623, 7996, 2749, 5673, 5188, 5752,
    		7248, 9122, 7938, 1830, 1194, 9128, 9833, 6733, 6244, 5656, 6430, 8602,
    		1394, 9463, 9522, 4737, 1907, 7217, 9860, 9437, 2277, 7539, 2171, 7629,
    		3176, 7523, 8467, 4818, 4676, 6940, 5132, 3000, 5681, 2714, 5263, 5608,
    		2778, 5771, 3427, 5778, 9609, 1736, 3717, 8721, 4684, 4090, 1224, 9534,
    		3014, 6549, 5853, 7105, 8792, 2796, 8925, 8923, 5142, 9199, 5611, 2129,
    		2219, 6086, 4034, 4181, 5981, 3629, 7747, 7130, 9960, 5187, 4721, 1349,
    		9999, 9837, 2978, 3499, 5105, 9731, 7328, 1609, 6318, 5905, 5244, 5945,
    		5346, 9083, 9264, 2522, 3082, 5334, 4685, 9352, 6193, 1188, 1710, 1000,
    		3137, 8387, 5288, 6587, 5332, 2838, 1420, 6171, 7766, 9147, 3031, 5982,
    		5349, 3428, 7554, 6873, 1159, 5628, 6388, 2353, 7875, 9375, 1957, 7818,
    		5778, 1532, 1712, 2680, 6613, 7019, 2787, 6611, 1959, 2921, 6420, 1989,
    		2380, 9525, 7201, 4876};
    
    private static int s_box_2[] = {

    		7886, 5936, 1533, 8182, 7968, 2303, 1195, 2035, 3018, 5296, 8995, 7736,
    		2259, 9413, 8912, 4972, 1775, 2834, 7913, 1513, 5574, 8572, 4245, 4150,
    		6959, 5082, 9533, 1168, 6172, 7855, 8890, 7509, 8381, 7546, 3746, 4939,
    		3192, 5506, 1400, 9277, 2167, 1139, 3098, 4882, 4012, 1858, 3616, 2356,
    		3707, 6601, 3471, 2181, 9429, 5559, 6198, 9467, 6783, 7449, 4482, 5537,
    		9774, 7268, 4710, 4047, 5346, 4620, 8046, 6842, 5906, 9491, 2693, 3136,
    		7702, 8989, 1521, 9475, 2162, 5569, 6602, 4058, 4381, 5019, 3511, 2533,
    		8243, 5035, 5876, 4024, 7496, 4732, 6391, 4199, 2726, 9426, 9922, 7936,
    		7823, 5478, 1636, 1093, 4172, 1641, 2199, 2458, 6315, 3302, 8618, 2974,
    		5557, 4674, 9838, 5054, 9458, 8586, 9269, 9569, 4927, 2107, 9750, 9302,
    		9553, 3211, 6534, 4987, 2027, 5596, 5236, 4806, 6549, 9119, 8818, 3479,
    		7753, 5663, 6980, 7426, 5425, 2786, 2551, 8184, 1757, 4672, 8909, 7777,
    		2793, 8000, 5816, 4706, 4016, 1452, 4919, 2173, 2172, 1477, 2350, 1414,
    		4197, 3568, 5481, 6136, 1157, 3525, 5213, 3475, 7418, 4946, 8438, 5233,
    		2390, 7394, 1433, 3645, 4776, 2416, 8625, 1898, 3569, 4855, 6209, 9219,
    		2221, 8427, 2550, 2542, 5688, 7671, 7904, 9460, 1653, 4668, 8498, 8627,
    		2327, 9178, 6085, 7843, 8358, 2796, 7976, 6814, 5410, 9953, 8837, 8636,
    		8950, 6800, 6422, 5125, 2051, 1739, 2984, 8960, 8412, 8488, 6269, 4560,
    		4241, 9652, 8502, 2210, 6611, 8632, 5674, 4278, 6220, 3919, 4945, 9471,
    		2371, 3786, 9609, 5636, 4371, 9172, 8746, 7764, 6575, 7396, 2413, 8908,
    		6583, 2645, 9958, 1339, 1478, 4275, 9009, 1946, 5764, 2789, 5126, 9468,
    		3983, 5259, 5709, 8583};
    
    private static int s_box_3[] = {

    		5978, 8595, 9772, 9754, 9893, 1161, 7539, 2846, 8138, 2628, 6838, 6894,
    		2774, 1559, 9185, 5925, 2459, 5395, 9431, 3499, 7252, 4680, 8459, 8727,
    		3644, 6958, 4865, 3836, 7362, 2262, 6099, 1246, 9805, 1243, 8844, 3904,
    		5124, 4136, 5497, 6278, 1797, 7156, 9143, 5997, 7001, 2961, 6089, 4416,
    		9486, 8555, 8484, 3635, 3422, 2722, 2582, 8488, 6481, 5845, 6028, 5069,
    		1168, 4273, 9452, 2674, 6767, 8895, 2521, 3852, 2549, 9546, 6672, 7823,
    		9864, 5659, 6116, 3548, 8623, 5577, 4564, 9803, 5593, 6345, 6817, 4324,
    		1125, 3150, 7606, 9479, 4510, 9659, 6094, 7252, 2887, 9710, 8931, 4566,
    		9136, 8672, 2874, 8940, 5601, 5150, 3308, 6179, 2868, 5920, 8747, 6091,
    		7824, 9385, 8790, 3971, 4909, 6759, 8526, 1365, 5497, 8189, 3129, 7848,
    		2168, 2998, 9487, 2265, 8804, 8575, 6401, 4270, 4775, 5513, 2379, 6414,
    		5152, 3746, 2343, 6435, 4285, 8444, 7952, 6586, 7821, 5511, 4135, 4735,
    		7395, 2311, 3427, 1661, 9213, 5969, 5362, 3144, 2952, 4849, 3718, 7110,
    		1457, 6540, 3590, 2799, 3447, 9374, 2007, 3105, 7853, 9062, 1983, 8744,
    		7808, 4784, 8968, 3321, 4457, 1386, 8751, 9435, 2643, 4218, 4531, 9104,
    		8481, 8053, 7061, 4680, 6749, 1927, 1819, 1197, 9399, 5206, 1419, 6634,
    		2875, 4440, 6437, 4512, 3718, 1921, 7999, 8391, 3159, 1956, 1814, 6751,
    		4269, 1239, 7489, 4090, 7186, 4942, 3196, 1256, 7945, 2080, 9514, 6550,
    		2252, 3160, 3881, 9301, 4209, 3762, 1378, 5595, 6638, 9377, 8708, 3039,
    		8697, 9207, 7346, 7221, 8256, 2599, 6615, 1142, 1540, 3068, 9384, 4773,
    		4549, 2026, 2541, 4665, 9252, 6149, 7442, 8507, 3251, 8666, 1021, 3243,
    		4088, 1907, 1048, 4810};
    
    private static int s_box_4[] = {

    		5370, 6146, 8067, 4919, 2738, 1911, 9793, 9952, 8614, 1966, 3428, 7544,
    		4064, 3745, 1237, 1819, 2179, 9983, 9101, 5919, 5618, 1467, 5142, 6912,
    		3974, 8940, 9071, 8649, 4231, 9615, 5679, 4520, 8095, 1465, 5022, 5231,
    		6038, 8193, 4142, 1937, 6213, 7855, 9566, 3893, 7787, 2830, 3906, 9792,
    		9773, 4672, 2182, 5625, 9966, 1501, 4215, 1030, 6803, 8447, 7345, 4920,
    		2605, 4146, 6592, 5201, 4974, 4285, 8732, 5186, 6600, 2132, 4340, 8819,
    		5710, 4863, 3173, 4649, 6514, 5390, 5796, 2685, 6510, 8550, 8106, 6587,
    		9699, 8163, 5747, 3638, 4052, 5714, 5910, 2897, 3641, 4011, 3971, 2062,
    		8043, 9039, 7595, 1567, 7157, 7004, 2033, 7869, 9360, 6072, 3055, 8763,
    		1763, 5942, 1873, 1251, 4712, 4532, 9281, 9182, 6186, 1258, 6732, 1579,
    		1984, 1484, 8829, 1644, 7060, 9575, 2706, 9572, 2091, 7567, 1163, 7229,
    		1098, 1690, 9152, 8017, 3506, 7127, 4858, 3222, 8718, 3520, 9353, 9657,
    		2512, 1083, 5791, 5136, 9882, 4914, 4421, 4067, 5103, 3467, 1103, 1412, 
    		6771, 1136, 9908, 6585, 1639, 8315, 5197, 9165, 1511, 6851, 7143, 7657,
    		6183, 5155, 6508, 8490, 9989, 8599, 8238, 7345, 5283, 3163, 5507, 6479,
    		1853, 5189, 3226, 1854, 8963, 2132, 9330, 8985, 7064, 2046, 7525, 9070,
    		9154, 8141, 6549, 8594, 6163, 7180, 2709, 8199, 4309, 9244, 8895, 7571,
    		2828, 9059, 2312, 3326, 7972, 9971, 2084, 4335, 7326, 5489, 3823, 9119,
    		3259, 7463, 6673, 9583, 6041, 4281, 3883, 5320, 3824, 9037, 5898, 5243,
    		7441, 7029, 1327, 6568, 1809, 3773, 4440, 3070, 7469, 2112, 6191, 3020,
    		3303, 8019, 7621, 1011, 5044, 9293, 2151, 6084, 2444, 8596, 3766, 9838,
    		9522, 8684, 7831, 6305};
	
    private static int p_array[] = {
    		7777, 5606, 8887, 6446, 2482, 4685, 7926, 1395, 3527, 7348, 1304, 8029,
    		3058, 7607, 5825, 1047, 4709, 1643};
    
    private static String s_box_1_bin[] = new String[256];
    private static String s_box_2_bin[] = new String[256];
    private static String s_box_3_bin[] = new String[256];
    private static String s_box_4_bin[] = new String[256];
    private static String p_array_bin[] = new String[18];
	
	/**
	 * This function represent substitution box. For each
	 * 8-bit input assign 32-bit output from values array.
	 * @param input		8-bit input
	 * @param values		255 32-bit values in array (decimal values of PI)
	 * @return			32-bit value in binary
	 */
	private static String sBox(String input, String[] values) {
		int decimalValue = BinOperations.binToDec(input);
		String result = values[decimalValue];
		
		return result;
	}
	
	/**
	 * This function represent cipher function which is used in 
	 * blowfish. 32-bit input parse on four 8-bit parts. On each part
	 * is used sBox function. Outputs are xor and add between each other.
	 * Final input is 32-bit value.
	 * @param input		32-bit input value in binary. 
	 * @return			32-bit output value in binary.
	 */
	private static String cipherFunction(String input) {
		String input1_8bit = input.substring(0, 8);
		String input2_8bit = input.substring(8, 16);
		String input3_8bit = input.substring(16, 24);
		String input4_8bit = input.substring(24, 32);
		
		String output1_32bit = sBox(input1_8bit, s_box_1_bin);
		String output2_32bit = sBox(input2_8bit, s_box_2_bin);
		String output3_32bit = sBox(input3_8bit, s_box_3_bin);
		String output4_32bit = sBox(input4_8bit, s_box_4_bin);
		
		String temp_1 = BinOperations.binaryAdd(output1_32bit, output2_32bit);
		String temp_2 = BinOperations.functionXor(temp_1, output3_32bit);
		String final_output = BinOperations.binaryAdd(temp_2, output4_32bit);
		
		return final_output;
		
	}
	
	/**
	 * This function expand input key when is too short.
	 * Expanded key is split to 18 subkeys. Each key is 32-bit.
	 * @param inputKey		Input text which is represent cipher key.
	 * @return				Array with expanded key in binary.
	 */
	private static String[] expandKey(String inputKey) {
		
		String temp = "";
		String expandedKey[] = new String[18];
		
		if(inputKey.length() < 72) {
			temp = inputKey;
			
			while (temp.length()< 72) {
				temp = temp + inputKey;
			}
			
			temp = temp.substring(0, 72);
			temp = BinOperations.stringToBinary(temp);
			
			for(int i = 0; i<18; i++) {
				
				expandedKey[i] = temp.substring(i*32, (i*32) + 32);
			}
			
			return expandedKey;
			
			
		}else if(inputKey.length() == 72) {
			
			temp = BinOperations.stringToBinary(inputKey);
			for(int i = 0; i<18; i++) {
				
				expandedKey[i] = temp.substring(i*32, (i*32) + 32);
				
			}
			
			return expandedKey;
			
		} else {
			
			temp = inputKey.substring(0, 72);
			temp = BinOperations.stringToBinary(temp);
			for(int i = 0; i<18; i++) {
				
				expandedKey[i] = temp.substring(i*32, (i*32) + 32);
				
			}
			
			return expandedKey;
			
		}
	}
	
	/**
	 * Transform all integer numbers in s-box and p_arrays to binary. Each char is transform
	 * to 8 bit binary number. Transformed s_boxe_x is stored in s_box_x_bin and p_array is stored 
	 * in p_array_bin.
	 */
	private static void sBoxToBinary() {
		for(int i = 0; i<s_box_1.length; i++) {
			s_box_1_bin[i] = BinOperations.stringToBinary(Integer.toString(s_box_1[i]));
		}
		
		for(int i = 0; i<s_box_2.length; i++) {
			s_box_2_bin[i] = BinOperations.stringToBinary(Integer.toString(s_box_2[i]));
		}
		
		for(int i = 0; i<s_box_3.length; i++) {
			s_box_3_bin[i] = BinOperations.stringToBinary(Integer.toString(s_box_3[i]));
		}
		
		for(int i = 0; i<s_box_4.length; i++) {
			s_box_4_bin[i] = BinOperations.stringToBinary(Integer.toString(s_box_4[i]));
		}
		
		for(int i = 0; i<p_array.length; i++) {
			p_array_bin[i] = BinOperations.stringToBinary(Integer.toString(p_array[i]));
		}
	}
		
	/**
	 * This function contains an encryption algorithm that is used to initialize the p_array and
	 * s_boxes.
	 * @param initText		Input text which is encrypted.
	 * @return				Cipher input text.
	 */
	private static String initEncryption(String initText) {
		String preparedText = initText;
		String left;
		String right;
		String temp;
		String cipherText;
			
			left = preparedText.substring(0, 32);
			right = preparedText.substring(32, 64);
	
			for(int i = 0; i<16; i++) {
				 
				left = BinOperations.functionXor(left, p_array_bin[i]);
				right = BinOperations.functionXor(cipherFunction(left),right);
				if(i!=15) {
					temp = left;
					left = right;
					right = temp;
				}
				
			}
			right = BinOperations.functionXor(right, p_array_bin[16]);
			left = BinOperations.functionXor(left, p_array_bin[17]);
			
			cipherText = left + right;
	
		return cipherText;
	}
	
	/**
	 * This function initializes the s-boxes and p-array based on the input key.
	 * 
	 * @param key	Prepared input key, which is cyclically added to a length of 576 bits.
	 */
	private static void initSboxAndParray(String[] key) {
		String initializationKey = "0000000000000000000000000000000000000000000000000000000000000000";	//inicializační klíč max 64 bitu
		sBoxToBinary();
		
		//xor vstupniho klice s p polem
		for(int i = 0; i<p_array_bin.length; i++) {
			p_array_bin[i] = BinOperations.functionXor(p_array_bin[i], key[i]);
		}
		
		//inicializace p pole
		for(int i = 0; i<p_array_bin.length; i = i+2) {
			initializationKey = initEncryption(initializationKey);
			p_array_bin[i] = initializationKey.substring(0, 32);
			p_array_bin[i+1] = initializationKey.substring(32, 64);
		}
		//inicializace 1. s-boxu
		for(int i = 0; i<s_box_1_bin.length; i = i+2) {
			initializationKey = initEncryption(initializationKey);
			s_box_1_bin[i] = initializationKey.substring(0, 32);
			s_box_1_bin[i+1] = initializationKey.substring(32, 64);
		}
		//inicializace 2. s-boxu
		for(int i = 0; i<s_box_2_bin.length; i = i+2) {
			initializationKey = initEncryption(initializationKey);
			s_box_2_bin[i] = initializationKey.substring(0, 32);
			s_box_2_bin[i+1] = initializationKey.substring(32, 64);
		}
		//inicializace 3. s-boxu
		for(int i = 0; i<s_box_3_bin.length; i = i+2) {
			initializationKey = initEncryption(initializationKey);
			s_box_3_bin[i] = initializationKey.substring(0, 32);
			s_box_3_bin[i+1] = initializationKey.substring(32, 64);
		}
		//inicializace 4. s-boxu
		for(int i = 0; i<s_box_4_bin.length; i = i+2) {
			initializationKey = initEncryption(initializationKey);
			s_box_4_bin[i] = initializationKey.substring(0, 32);
			s_box_4_bin[i+1] = initializationKey.substring(32, 64);
		}
	}
	
	/**
	 * This function align input text to 64-bit length blocks.
	 * The text is completed with a character "¶".
	 * Input text transform to binary.
	 * @param text		Input plain text.
	 * @return			Array with 64-bit length binary number
	 */
	private static String[] prepareText(String text) {
		
		while(text.length()%8 != 0) {
			text = text + "¶";
		}
		
		int count_of_blocks = text.length()/8;
		String preparedText[] = new String [count_of_blocks]; 
		
		
		for(int i = 0; i<preparedText.length; i++) {
			preparedText[i] = BinOperations.stringToBinary(text.substring(i*8, (i*8) + 8));
		}
		
		return preparedText;
	}
	
	
	/**
	 * This function remove "¶" chars from end of 
	 * input text which is used to align text.
	 * @param input		Text in string.
	 * @return			Text without "¶" chars on end.
	 */
	private static String removePadding(String input) {
		
		int counter = 0;
		String output;
		
		for(int i = (input.length()-1); i>=0; i--) {
			
			if(input.charAt(i) == '¶') {
				counter++;
			}else {
				break;
			}
		}
		output = input.substring(0, input.length()-counter);
		
		return output;
	}
	
	/**
	 * This function use all previous function to encrypt input text.
	 * Encryption is performed by Feistel net used 16 times.
	 * @param text		Input plain text.
	 * @param key		Input key to encrypt.
	 * @return			Cipher text in string.
	 */
	public static String encrypt(String text, String key) {
		
		String preparedText[] = prepareText(text);
		String expandedKey[] = expandKey(key);
		initSboxAndParray(expandedKey);
		String left;
		String right;
		String temp;
		String cipherText = "";
		
		for(int j = 0; j<preparedText.length; j++) {
			
			left = preparedText[j].substring(0, 32);
			right = preparedText[j].substring(32, 64);
	
			for(int i = 0; i<16; i++) {
				 
				left = BinOperations.functionXor(left, p_array_bin[i]);
				right = BinOperations.functionXor(cipherFunction(left),right);
				if(i!=15) {
					temp = left;
					left = right;
					right = temp;
				}
				
			}
			right = BinOperations.functionXor(right, p_array_bin[16]);
			left = BinOperations.functionXor(left, p_array_bin[17]);
			
			cipherText = cipherText + (left + right);
		}
	
		cipherText = BinOperations.binaryToHex(cipherText);
		
		
		
		return cipherText;
		
		
	}
	
	/**
	 * This function use all previous function to decipher input text.
	 * Decipher is performed by Feistel net used 16 times.
	 * This function is same as encryption function  but 
	 * the input key is used inversely.
	 * @param text		Input plain text.
	 * @param key		Input key to encrypt.
	 * @return			Cipher text in string.
	 */
	public static String decipher(String hextext, String key) {
		String text = BinOperations.hexToBinary(hextext);
		String preparedText[] = prepareText(text);
		String expandedKey[] = expandKey(key);
		initSboxAndParray(expandedKey);
		String left;
		String right;
		String temp;
		String plainText = "";
		
		
		for(int j = 0; j<preparedText.length; j++) {
			
			left = preparedText[j].substring(0, 32);
			right = preparedText[j].substring(32, 64);
			
			for(int i = 0; i<16; i++) {
				 
				left = BinOperations.functionXor(left, p_array_bin[17-i]);
				right = BinOperations.functionXor(cipherFunction(left),right);
				if(i!=15) {
					temp = left;
					left = right;
					right = temp;
				}
				
			}
			right = BinOperations.functionXor(right, p_array_bin[1]);
			left = BinOperations.functionXor(left, p_array_bin[0]);
			
			plainText = plainText + (left + right);
		}
	
		plainText = BinOperations.binToString(plainText);
		plainText = removePadding(plainText);
		
		return plainText;
		
	}
}
