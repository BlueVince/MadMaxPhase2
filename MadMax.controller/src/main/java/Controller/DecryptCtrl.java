package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.DecryptWindow;

public class DecryptCtrl implements ActionListener {

	private DecryptWindow view;
	
	public DecryptCtrl() {
		this.setView(new DecryptWindow(this));
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == this.getView().getBtnBrowse()) {
			
		}
		
		else if (source == this.getView().getBtnDecryptAndSave()) {
			
		}
	}

	private DecryptWindow getView() {
		return view;
	}

	private void setView(DecryptWindow view) {
		this.view = view;
	}

}
