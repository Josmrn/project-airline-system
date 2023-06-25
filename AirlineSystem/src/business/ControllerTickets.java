package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUITickets;
import presentation.GUIMain;

public class ControllerTickets implements ActionListener {

	private GUITickets guiT;

	public ControllerTickets(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		guiT = new GUITickets();
		guiMain.getDesktopMain().add(guiT);
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		
		
		guiT.getBtnAddTickets().addActionListener(this);
		guiT.getBtnEditTickets().addActionListener(this);
		guiT.getBtnRemoveTickets().addActionListener(this);
		guiT.getBtnConsultTickets().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == guiT.getBtnAddTickets()) {

		}

		if (e.getSource() == guiT.getBtnEditTickets()) {

		}

		if (e.getSource() == guiT.getBtnRemoveTickets()) {

		}
		if (e.getSource() == guiT.getBtnConsultTickets()) {
			
		}
	}

}