package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUIHisFlights;
import presentation.GUIMain;

public class ControllerHistoryFlight implements ActionListener{
	
	private GUIHisFlights guiHF;

	public ControllerHistoryFlight(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		guiHF = new GUIHisFlights();
		guiMain.getDesktopMain().add(guiHF);
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiHF.getBtnSearchFlight().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiHF.getBtnSearchFlight()) {
			
		}
	}

}
