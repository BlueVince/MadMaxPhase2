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
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class DecryptWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblX_1;
	private JButton BtnBrowse, BtnDecryptAndSave;
	private JPanel panel;
	private JTextPane textpanel;
	private JFileChooser fileChooser;

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
			this.getBtnBrowse().addActionListener(this);
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
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(312, 0, 314, 442);
		contentPane.add(panel);
		
		this.setBtnBrowse(new JButton("Browse..."));
		this.getBtnBrowse().setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.getBtnBrowse().setForeground(Color.WHITE);
		this.getBtnBrowse().setBackground(new Color(65, 105, 225));
		
		this.setBtnDecryptAndSave(new JButton("Decrypt and Save"));
		this.getBtnDecryptAndSave().setBackground(new Color(65, 105, 225));
		this.getBtnDecryptAndSave().setForeground(Color.WHITE);
		this.getBtnDecryptAndSave().setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(81)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(BtnBrowse, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addComponent(BtnDecryptAndSave, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(116)
					.addComponent(BtnBrowse, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(BtnDecryptAndSave, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		this.setTextpanel(new JTextPane());
		this.getTextpanel().setText("teststetuyzdgkjd");
		scrollPane.setViewportView(this.getTextpanel());
		panel.setLayout(gl_panel);
		
		this.setUndecorated(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		/* init du filechooser */
		fileChooser = new JFileChooser();
	}

	public JButton getBtnBrowse() {
		return BtnBrowse;
	}

	public void setBtnBrowse(JButton btnBrowse) {
		BtnBrowse = btnBrowse;
		BtnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	public JButton getBtnDecryptAndSave() {
		return BtnDecryptAndSave;
	}

	public void setBtnDecryptAndSave(JButton btnDecryptAndSave) {
		BtnDecryptAndSave = btnDecryptAndSave;
	}

	public void actionPerformed(ActionEvent e) {
		Object Source = e.getSource();
		if (Source == this.getBtnBrowse()) {
			/* affichage du dialog et test si le bouton ok est pressé */
			if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				/*
				try {
					// demande au système d'ouvrir le fichier précédemment séléctionné
					Desktop.getDesktop().open(fileChooser.getSelectedFile());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				/**/
			}
		}
	}

	public JTextPane getTextpanel() {
		return textpanel;
	}

	public void setTextpanel(JTextPane textpanel) {
		this.textpanel = textpanel;
	}

	public JFileChooser getFileChooser() {
		return this.fileChooser;
	}

	public void setTextpanel(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}
	
}

