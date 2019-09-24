package Model;

public class temp {

	public static void main(String[] args) {
		Crypt crp = new Crypt();
		String txt = "bonjourebbbbb", key = "hello", res = "";
		
		//System.out.println(txt);
		System.out.println(Integer.toBinaryString(txt.charAt(0)));
		System.out.println(Integer.toBinaryString(key.charAt(0)));
		
		res = crp.encrypt(txt, key);
		
		//System.out.println(res);
		System.out.println(Integer.toBinaryString(res.charAt(0)));
		
		res = crp.encrypt(res, key);
		
		//System.out.println(res);
		System.out.println(Integer.toBinaryString(res.charAt(0)));
	}

}
