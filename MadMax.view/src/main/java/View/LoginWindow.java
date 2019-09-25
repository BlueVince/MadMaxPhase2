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
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JPasswordField p1;
	private JButton btn1;
	private JPanel panel;
	private JLabel lblX;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Window frame = new Window();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public LoginWindow() {
		this.init();
		
	}
	
	public LoginWindow(ActionListener listener) {
		this.init();
		
		if (listener != null) {
			this.getBtn1().addActionListener(listener);
		}
		

	}

	/**
	 * Create the frame.
	 */
	private void init() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/View/Image/notre logo.png")));
		setTitle("Sign in");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 442);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(311, 0, 315, 442);
		contentPane.add(panel);
		
		tf1 = new JTextField();
		tf1.setBounds(33, 148, 251, 31);
		tf1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(33, 114, 210, 23);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setForeground(new Color(65, 105, 225));
		lblUsername.setBackground(Color.BLACK);
		
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(33, 190, 251, 26);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setForeground(new Color(65, 105, 225));
		
		p1 = new JPasswordField();
		p1.setBounds(33, 227, 251, 32);
		p1.setColumns(10);
		
		this.setBtn1(new JButton("Sign in"));
		btn1.setForeground(Color.WHITE);
		btn1.setBackground(new Color(65, 105, 225));
		
		lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				System.exit(0);;
			}
		});
		
		lblX.setBounds(282, 11, 23, 32);
		lblX.setForeground(Color.RED);
		lblX.setFont(new Font("Verdana", Font.BOLD, 30));
		panel.setLayout(null);
		panel.add(lblPassword);
		panel.add(p1);
		panel.add(btn1);
		panel.add(lblUsername);
		panel.add(tf1);
		panel.add(lblX);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginWindow.class.getResource("/View/Image/decrypt.png")));
		label.setBounds(33, 0, 247, 442);
		contentPane.add(label);
		
		this.setUndecorated(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
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
		btn1.setBounds(84, 287, 159, 40);
	}
}

