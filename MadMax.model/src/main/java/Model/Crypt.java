package Model;

public abstract class Crypt {
	
	public static String encrypt(String str, String key) {
		String res = "";
		char c1, c2, c3 = '0';
		int i = 0;

		for(i = 0; i < str.length(); i++) {

			c1 = str.charAt(i);
			c2 = key.charAt(i % key.length());
			
			c3 = (char)(c1 ^ c2);

			res += c3;
		}

		return res;
	}

}
