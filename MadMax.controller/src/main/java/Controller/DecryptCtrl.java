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

import DAO.DAO;
import Model.Crypt;
import Model.Key;
import View.DecryptWindow;

public class DecryptCtrl implements ActionListener {

	private DecryptWindow view;
	
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
			
			String inputPath = "C:\\Users\\vince\\Desktop\\" + "crypted.txt";
			String outputPath = "C:\\Users\\vince\\Desktop\\" + "decrypted.txt";
			
			File inputFile = new File(inputPath);
			File outputFile = new File(outputPath);
			BufferedReader rd = null;
			BufferedWriter wr = null;

			try {

				rd = new BufferedReader(new FileReader(inputFile));

				Key key = new Key("awqp", 12);
				
				String bestDecryptedText = "";
				int bestDecryptedWords = 0;
				boolean decrypting = true;
				
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
					
					int words = DAO.containedWords(decryptedText);
					
					if (words > bestDecryptedWords) {
						bestDecryptedText = decryptedText;
						bestDecryptedWords = words;
						
						System.out.println("Decrypted text:");
						System.out.println(bestDecryptedText);
						System.out.println("Key used:" + key.getKeyString());
						System.out.println("Words recognized:" + bestDecryptedWords);
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
				
				if (bestDecryptedWords > 0) {
					if (!outputFile.exists()) {
						outputFile.createNewFile();
					}
					
					wr = new BufferedWriter(new FileWriter(outputFile));
					
					wr.write(bestDecryptedText);
					
					System.out.println("!! Best Decryption !!");
					System.out.println("Decrypted text:");
					System.out.println(bestDecryptedText);
					System.out.println("Key used:" + key.getKeyString());
					System.out.println("Words recognized:" + bestDecryptedWords);
				}
				
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
	}

	private DecryptWindow getView() {
		return view;
	}

	private void setView(DecryptWindow view) {
		this.view = view;
	}

}
