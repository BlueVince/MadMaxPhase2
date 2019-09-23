package model;

public class CLcrypt {

	public String m_crypt(String inputString, String key) {
		String outputString = "";
		
		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i), keyC = key.charAt(i % key.length());
			
			boolean[] boolC = charToBoolean(c);
			boolean[] boolKeyC = charToBoolean(keyC);
			
			boolean[] boolResult = new boolean[8];
			
			for (int bit = 0; bit < 8; ++bit) {
				boolResult[bit] = boolC[bit] ^ boolKeyC[bit];
			}
			
			char outC = booleanToChar(boolResult);
			
			outputString += outC;
		}
		
		return outputString;
	}
	
	private boolean[] charToBoolean(char c) {
		boolean [] b = new boolean[8];
		
		for (int i = 0; i < 8; ++i) {
			b[i] = (c & (1 << i)) != 0;
		}
		
		return b;
	}
	
	private char booleanToChar(boolean[] b) {
		char c = '0';
		
		for (int i = 0; i < 8; ++i) {
		    if (b[i]) c |= (1 << i);
		}
		
		return c;
	}
	
}
