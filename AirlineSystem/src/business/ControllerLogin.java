package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUILogin;

public class ControllerLogin implements ActionListener{

	private GUILogin guiL;
	
	public ControllerLogin() {
		
		guiL = new GUILogin();
		
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiL.getBtnLogin().addActionListener(this);
		guiL.getBtnRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == guiL.getBtnLogin()) {
			
		}
		
		if(e.getSource() == guiL.getBtnRegister()) {
			new ControllerRegister();
			guiL.dispose();
		}
		
	}
	
}
