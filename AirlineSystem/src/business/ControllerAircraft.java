package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUIMain;
import presentation.GUIPlanes;

public class ControllerAircraft implements ActionListener{

	private GUIPlanes guiP;
	
	public ControllerAircraft(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		guiP = new GUIPlanes();
		guiMain.getDesktopMain().add(guiP);
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiP.getBtnAddPlanes().addActionListener(this);
		guiP.getBtnEditPlanes().addActionListener(this);
		guiP.getBtnRemovePlanes().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiP.getBtnAddPlanes()) {
			
		}
		
		if(e.getSource() == guiP.getBtnEditPlanes()) {
			
		}
		
		if(e.getSource() == guiP.getBtnRemovePlanes()) {
			
		}
	}

}
