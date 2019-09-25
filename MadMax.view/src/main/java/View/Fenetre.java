package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;

public class Fenetre extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tf1;
	private JPasswordField p1;
	private JButton btn1;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 442);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(311, 0, 299, 403);
		panel.setLayout(null);
		contentPane.add(panel);
		
		tf1 = new JTextField();
		tf1.setBounds(27, 133, 251, 31);
		panel.add(tf1);
		tf1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(27, 99, 210, 23);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setForeground(new Color(65, 105, 225));
		lblUsername.setBackground(Color.BLACK);
		
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(27, 175, 251, 26);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setForeground(new Color(65, 105, 225));
		
		p1 = new JPasswordField();
		p1.setBounds(27, 212, 251, 32);
		panel.add(p1);
		p1.setColumns(10);
		
		this.setBtn1(new JButton("Se connecter"));
		btn1.setForeground(Color.WHITE);
		btn1.setBackground(new Color(65, 105, 225));
		
		this.getBtn1().addActionListener(this);
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
		btn1.setBounds(78, 272, 159, 40);
		panel.add(btn1);
	}      
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == this.getBtn1()) {
			System.out.println(this.getTf1().getText() + " | " + String.valueOf(getP1().getPassword()));
		}
	}
}

