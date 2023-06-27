package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUIAirlines;
import presentation.GUIMain;

public class ControllerAirlines implements ActionListener{

	private GUIAirlines guiAir; 
	
	public ControllerAirlines(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		guiAir = new GUIAirlines();
		guiMain.getDesktopMain().add(guiAir);
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiAir.getBtnAddAirlines().addActionListener(this);
		guiAir.getBtnEditAirlines().addActionListener(this);
		guiAir.getBtnRemoveAirlines().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiAir.getBtnAddAirlines()) {
			
		}
		
		if(e.getSource() == guiAir.getBtnEditAirlines()) {
			
		}
		
		if(e.getSource() == guiAir.getBtnRemoveAirlines()) {
			
		}
	}

}
