package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Users;
import presentation.GUIUser;

public class ControllerRegister implements ActionListener{
	
	private GUIUser guiU;
	private Users us;

	public ControllerRegister() {
		// TODO Auto-generated constructor stub
		guiU = new GUIUser();
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiU.getBtnNewRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiU.getBtnNewRegister()) {
			
		}
	}

}
