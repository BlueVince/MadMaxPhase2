package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DAO;
import Model.Crypt;
import Model.Dictionary;
import Model.Key;
import View.DecryptWindow;

public class DecryptCtrl implements ActionListener {

	private DecryptWindow view;
	private int nFile = 1;
	
	public DecryptCtrl() {
		this.setView(new DecryptWindow(this));
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == this.getView().getBtnBrowse()) {
			System.out.println("Browse button clicked");
		}
		
		else if (source == this.getView().getBtnDecryptAndSave()) {
			System.out.println("Decrypt button clicked");
			
			String nFileStr = "00" + nFile;
			nFileStr = nFileStr.substring(nFileStr.length() - 3);
			
			String inputPath = "C:\\Users\\vince\\Desktop\\fichiers_cryptes\\" + "fichier" + nFileStr + "crypte.txt";
			String outputPath = "C:\\Users\\vince\\Desktop\\fichiers_decryptes\\" + "fichier" + nFileStr + "decrypte.txt";
			
			File inputFile = new File(inputPath);
			File outputFile = new File(outputPath);
			BufferedReader rd = null;
			BufferedWriter wr = null;

			try {

				rd = new BufferedReader(new FileReader(inputFile));
				
				ArrayList<Dictionary> dico = DAO.getWholeDictionary();
//				ArrayList<Dictionary> dico = new ArrayList<Dictionary>();
//				dico.add(new Dictionary(0, "hello", "english"));
//				dico.add(new Dictionary(0, "world", "english"));
//				dico.add(new Dictionary(0, "confidentely", "english"));

				Key key = new Key("awqpmndf", 12);
				
				String bestDecryptedText = "";
				int bestDecryptedNWords = 0;
				String bestKey = "";
				boolean decrypting = true;
				
				String outputStr = "";
				
				/**/
				while (decrypting) {
					String cryptedText = "", decryptedText = "", line = null;
					
					do {
						line = rd.readLine();
						
						if (line != null) {
							cryptedText += line + "\n";
						}
					} while (line != null);
					
					cryptedText = cryptedText.substring(0, cryptedText.length() - 1);
					
					decryptedText = Crypt.encrypt(cryptedText, key.getKeyString());
					
					int nWords = 0;
					for (Dictionary word: dico) {
						if (decryptedText.contains(word.getWord())) {
							nWords++;
						}
					}
					
					if (nWords > bestDecryptedNWords) {
						bestDecryptedText = decryptedText;
						bestDecryptedNWords = nWords;
						bestKey = key.getKeyString();
						
//						System.out.println("Decrypted text:");
//						System.out.println(bestDecryptedText);
//						System.out.println("Key used:" + bestKey);
//						System.out.println("Words recognized:" + bestDecryptedNWords);
						
						outputStr += "Decrypted text:" + "\n" + bestDecryptedText + "\n\n"
								+ "Key used:" + "\n" + bestKey + "\n\n"
								+ "Words recognized:" + "\n" + bestDecryptedNWords
								+ "\n----------------\n";
					}
					else {
						System.out.println("Key used:" + key.getKeyString());
					}
					
					if (!key.increment()) {
						decrypting = false;
					}
					else {
						decrypting = true;

						rd.close();
						rd = new BufferedReader(new FileReader(inputFile));
					}
				}
				/**/
				
				/*
				while (decrypting) {
					String cryptedText = "", decryptedText = "", line = null;
					
					do {
						line = rd.readLine();
						
						if (line != null) {
							cryptedText += line + "\n";
						}
					} while (line != null);
					
					cryptedText = cryptedText.substring(0, cryptedText.length() - 1);
					
					decryptedText = Crypt.encrypt(cryptedText, key.getKeyString());
					
					int nWords = 0;
					for (Dictionary word: dico) {
						if (decryptedText.contains(word.getWord())) {
							nWords++;
						}
					}
					
					if (nWords > bestDecryptedNWords) {
						bestDecryptedText = decryptedText;
						bestDecryptedNWords = nWords;
						
						System.out.println("Decrypted text:");
						System.out.println(bestDecryptedText);
						System.out.println("Key used:" + key.getKeyString());
						System.out.println("Words recognized:" + bestDecryptedNWords);
					}
					
					if (!key.increment()) {
						decrypting = false;
					}
					else {
						decrypting = true;

						rd.close();
						rd = new BufferedReader(new FileReader(inputFile));
					}
				}
				/**/
				
				if (bestDecryptedNWords > 0) {
					if (!outputFile.exists()) {
						outputFile.createNewFile();
					}
					
					wr = new BufferedWriter(new FileWriter(outputFile));
					
					wr.write(bestDecryptedText);
					
					System.out.println("!! Best Decryption !!");
					System.out.println("Decrypted text:");
					System.out.println(bestDecryptedText);
					System.out.println("Key used:" + bestKey);
					System.out.println("Words recognized:" + bestDecryptedNWords);
					outputStr += "!! Best Decryption !!" + "\n\n"
							+ "Decrypted text:" + "\n" + bestDecryptedText + "\n\n"
							+ "Key used:" + "\n" + bestKey + "\n\n"
							+ "Words recognized:" + "\n" + bestDecryptedNWords;
				}
				
				this.getView().getTextpanel().setText(outputStr);
				
				if (rd != null)
					rd.close();
				if (wr != null)
					wr.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		

		this.nFile++;
	}

	private DecryptWindow getView() {
		return view;
	}

	private void setView(DecryptWindow view) {
		this.view = view;
	}

}
