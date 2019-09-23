package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CLctrlCrypt {

	public void ecrireFichierSimple(String path, String texte) {
		File f = new File(path);
		
		try {
			PrintWriter p = new PrintWriter(f);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String lireFichierSimple(String path) {
		File f = new File(path);
		
		f.read
		
		return null;
	}
	
	public String crypter(String texte, String Key) {
		
		return null;
	}
	
}
