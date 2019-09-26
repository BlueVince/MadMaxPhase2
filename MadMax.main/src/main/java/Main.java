import java.io.*;

import Controller.LoginCtrl;
import Model.Crypt;

public class Main {

	public static void main(String[] args) {
		/*String str = "hello world!\nI can confidentely tell that nobody will ever know my password is \"LeLamantin\" !!";
		String key = "awqp" + "dktisnro";
		
		String res = Crypt.encrypt(str, key);
		System.out.println(res);
		
		String outputPath = "C:\\Users\\vince\\Desktop\\" + "decrypted.txt";
		File outputFile = new File(outputPath);
		BufferedWriter wr = null;
		try {
			wr = new BufferedWriter(new FileWriter(outputFile));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			wr.write(res);
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		@SuppressWarnings("unused")
		LoginCtrl loginCtrl = new LoginCtrl();
		
	}

}
