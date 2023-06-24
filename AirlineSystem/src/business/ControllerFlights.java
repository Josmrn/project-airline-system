package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUIFlights;
import presentation.GUIMain;

public class ControllerFlights implements ActionListener {

	private GUIFlights guiF;

	public ControllerFlights(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		guiF = new GUIFlights();
		guiMain.getDesktopMain().add(guiF);
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiF.getBtnAddFlight().addActionListener(this);
		guiF.getBtnEditFlights().addActionListener(this);
		guiF.getBtnRemoveFlights().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == guiF.getBtnAddFlight()) {

		}

		if (e.getSource() == guiF.getBtnEditFlights()) {

		}

		if (e.getSource() == guiF.getBtnRemoveFlights()) {

		}
	}

}
