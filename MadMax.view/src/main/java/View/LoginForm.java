package View;

import java.awt.color.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener {
	
	private JLabel l1, l2, l3;
	private JTextField tf1;
	private JPasswordField p1;
	private JButton btn1;
	
	public LoginForm() {
		JFrame frame = new JFrame("CESI Decrypt");
		
		this.setL1(new JLabel("CESI Decrypt"));
		this.getL1().setForeground(Color.DARK_GRAY);
		this.getL1().setFont(new Font("Arial", Font.BOLD, 20));
		this.setL2(new JLabel("Nom d'utilisateur"));
		this.setL3(new JLabel("mot de passe"));
		
		this.setTf1(new JTextField());
		this.setP1(new JPasswordField());
		
		this.setBtn1(new JButton("connexion"));

		this.getL1().setBounds(100, 30, 400, 30);
		this.getL2().setBounds(100, 70, 200, 30);
		this.getL3().setBounds(100, 110, 200, 30);
		this.getTf1().setBounds(300, 70, 200, 30);
		this.getP1().setBounds(300, 110, 200, 30);
		this.getBtn1().setBounds(350, 160, 100, 30);

		frame.add(this.getL1());
		frame.add(this.getL2());
		frame.add(this.getTf1());
		frame.add(this.getL3());
		frame.add(this.getP1());
		frame.add(this.getBtn1());

		frame.setSize(600, 270);
		frame.setLayout(null);
		frame.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getBtn1().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == this.getBtn1()) {
			System.out.println(this.getTf1().getText() + " | " + String.valueOf(getP1().getPassword()));
		}
	}

	public JLabel getL1() {
		return l1;
	}

	public void setL1(JLabel l1) {
		this.l1 = l1;
	}

	public JLabel getL2() {
		return l2;
	}

	public void setL2(JLabel l2) {
		this.l2 = l2;
	}

	public JLabel getL3() {
		return l3;
	}

	public void setL3(JLabel l3) {
		this.l3 = l3;
	}

	public JTextField getTf1() {
		return tf1;
	}

	public void setTf1(JTextField tf1) {
		this.tf1 = tf1;
	}

	public JPasswordField getP1() {
		return p1;
	}

	public void setP1(JPasswordField p1) {
		this.p1 = p1;
	}

	public JButton getBtn1() {
		return btn1;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}      

}