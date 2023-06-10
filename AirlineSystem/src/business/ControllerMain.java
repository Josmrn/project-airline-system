package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUIMain;

public class ControllerMain implements ActionListener{
	
	private GUIMain guiMain; 

	public ControllerMain() {
		guiMain = new GUIMain();
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiMain.getMiCreateUser().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiMain.getMiCreateUser()) {
			
			new ControllerRegister();
			
			
		}
		
		
	}
}
