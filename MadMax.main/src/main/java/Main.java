import java.io.*;

import Controller.LoginCtrl;
import Model.Crypt;

public class Main {

	public static void main(String[] args) {
		/*
		String inputPath = "C:\\Users\\vince\\Desktop\\" + "manual_crypted.txt";
		File inputFile = new File(inputPath);
		BufferedReader rd = null;
		
		String str = "";
		String key = "awqpmndfgtej";
		
		try {
			rd = new BufferedReader(new FileReader(inputFile));
			str = rd.readLine();
			rd.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		String res = Crypt.encrypt(str, key);
		System.out.println(res);
		
		String outputPath = "C:\\Users\\vince\\Desktop\\" + "manual_decrypted.txt";
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
		}
		/**/
		
		@SuppressWarnings("unused")
		LoginCtrl loginCtrl = new LoginCtrl();
		
	}

}
