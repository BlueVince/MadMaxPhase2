package main;

import controller.CLctrlCrypt;

public class mainMVC {

	public static void main(String[] args) throws Exception  {
	
		CLctrlCrypt o1;
		String reponse;
		
		o1 = new CLctrlCrypt();
		o1.ecrireFichierSimple("C:\\Users\\vince\\Desktop\\fichier\\a.txt", "Bonjour a tous. Comment Allez vous?");
		
		reponse = o1.lireFichierSimple("C:\\Users\\vince\\Desktop\\fichier\\a.txt");
		System.out.println(reponse);
		
		reponse = o1.crypter(reponse, "adhyudertjutl");
		System.out.println(reponse);
		o1.ecrireFichierSimple("C:\\Users\\vince\\Desktop\\fichier\\b.txt", reponse);
		
		reponse = o1.lireFichierSimple("C:\\Users\\vince\\Desktop\\fichier\\b.txt");
		reponse = o1.crypter(reponse, "adhyudertjutl");
		o1.ecrireFichierSimple("C:\\Users\\vince\\Desktop\\fichier\\c.txt", reponse);
		System.out.println(reponse);
		
		System.out.println("Terminé");
	}

}
