import java.sql.SQLException;
import java.util.ArrayList;
import DAO.DAO;
import Controller.LoginCtrl;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		LoginCtrl loginCtrl = new LoginCtrl();
		
		/*
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			users.addAll(DAO.getAllUsers());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("all");
		for (User user : users) {
			System.out.println(user.getId() + " | " + user.getUser() + " | " + user.getPassword());
		}
		
		String userName = "testUser", userPass = "testPass";
		
		System.out.println("to add");
		System.out.println(userName + " | " + userPass);
		
		User usr = null;
		
		try {
			usr = DAO.addUser(userName, userPass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("added");
		System.out.println(usr.getId() + " | " + usr.getUser() + " | " + usr.getPassword());
		*/
	}

}
