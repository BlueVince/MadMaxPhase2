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

public class DecryptWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lblX_1;
	private JButton BtnBrowse, BtnDecryptAndSave;

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
		
		if (listener != null) {
			this.getBtnBrowse().addActionListener(listener);
			this.getBtnDecryptAndSave().addActionListener(listener);
		}
		

	}

	/**
	 * Create the frame.
	 */
	private void init() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DecryptWindow.class.getResource("/View/Image/notre logo.png")));
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
		label.setIcon(new ImageIcon(DecryptWindow.class.getResource("/View/Image/notre logo.png")));
		contentPane.add(label);
		
		this.setBtnBrowse(new JButton("Browse..."));
		this.getBtnBrowse().setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.getBtnBrowse().setForeground(Color.WHITE);
		this.getBtnBrowse().setBackground(Color.DARK_GRAY);
		this.getBtnBrowse().setBounds(398, 142, 153, 44);
		contentPane.add(this.getBtnBrowse());
		
		this.setBtnDecryptAndSave(new JButton("Decrypt and Save"));
		this.getBtnDecryptAndSave().setBackground(Color.DARK_GRAY);
		this.getBtnDecryptAndSave().setForeground(Color.WHITE);
		this.getBtnDecryptAndSave().setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.getBtnDecryptAndSave().setBounds(398, 265, 153, 44);
		contentPane.add(this.getBtnDecryptAndSave());
		
		this.lblX_1 = new JLabel("X");
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

	public JButton getBtnBrowse() {
		return BtnBrowse;
	}

	public void setBtnBrowse(JButton btnBrowse) {
		BtnBrowse = btnBrowse;
	}

	public JButton getBtnDecryptAndSave() {
		return BtnDecryptAndSave;
	}

	public void setBtnDecryptAndSave(JButton btnDecryptAndSave) {
		BtnDecryptAndSave = btnDecryptAndSave;
	}
}

