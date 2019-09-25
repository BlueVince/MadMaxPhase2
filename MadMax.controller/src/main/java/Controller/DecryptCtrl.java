package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.DecryptWindow;
import View.LoginWindow;

public class DecryptCtrl implements ActionListener {

	private DecryptWindow view;
	
	public DecryptCtrl() {
		this.setView(new DecryptWindow(this));
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == this.getView().getBtn1()) {
			
		}
	}

	private DecryptWindow getView() {
		return view;
	}

	private void setView(DecryptWindow view) {
		this.view = view;
	}

}
