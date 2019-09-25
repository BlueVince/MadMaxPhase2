package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import View.LoginWindow;
import DAO.DAO;
import Model.User;

public class LoginCtrl implements ActionListener {

	private LoginWindow view;
	
	public LoginCtrl() {
		this.setView(new LoginWindow(this));
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == this.getView().getBtn1()) {
			String userName = this.getView().getTf1().getText();
			String password = String.valueOf(this.getView().getP1().getPassword());
			
			System.out.println(userName + " | " + password);
			
			User usr = null;
			boolean userIsValid = false;
			
			try {
				usr = DAO.getUserByName(userName);
				
				if (usr != null) {
					System.out.println(usr.getUser() + " | " + usr.getPassword());
					LoginCtrl loginCtrl2 = new LoginCtrl();
					
					if (usr.getUser().equals(userName) && usr.getPassword().equals(password)) {
						userIsValid = true;
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if (userIsValid) {
				System.out.println("user valid");
			}
			else {
				System.out.println("user invalid");
			}
		}
	}

	private LoginWindow getView() {
		return view;
	}

	private void setView(LoginWindow view) {
		this.view = view;
	}

}
