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

public class DecryptWindow extends JFrame implements ActionListener {

	private JPanel contentPane;
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
	
	public DecryptWindow() {
		this.init();
	}
	
	public DecryptWindow(ActionListener listener) {
		this.init();
		
		if (listener == null) {
			listener = this;
		}
		
		this.getBtn1().addActionListener(listener);
	}

	/**
	 * Create the frame.
	 */
	private void init() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DecryptWindow.class.getResource("/View/Image/decrypt.png")));
		setTitle("Sign in");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 626, 442);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(33, 0, 247, 442);
		label.setIcon(new ImageIcon(DecryptWindow.class.getResource("/View/Image/decrypt.png")));
		contentPane.add(label);
		
		JButton btnBrowse = new JButton("Browse...");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBrowse.setForeground(Color.WHITE);
		btnBrowse.setBackground(Color.DARK_GRAY);
		btnBrowse.setBounds(398, 142, 143, 44);
		contentPane.add(btnBrowse);
		
		JButton btnDecryptAndSave = new JButton("Decrypt and Save");
		btnDecryptAndSave.setBackground(Color.DARK_GRAY);
		btnDecryptAndSave.setForeground(Color.WHITE);
		btnDecryptAndSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDecryptAndSave.setBounds(398, 265, 143, 44);
		contentPane.add(btnDecryptAndSave);
		
		JLabel lblX_1 = new JLabel("X");
		lblX_1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
		});
		lblX_1.setForeground(Color.RED);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblX_1.setBounds(595, 11, 21, 34);
		contentPane.add(lblX_1);
		
		this.setUndecorated(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
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
	}

	public void setBtn1(JButton btn1) {
	}
}

