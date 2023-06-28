package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesAirlinesXML;
import data.FilesTicketsXML;
import domain.Airlines;
import domain.Tickets;
import presentation.GUIMain;
import presentation.GUIPrintTickets;

public class ControllerPrint implements ActionListener {

	private GUIPrintTickets guiPT;
	private FilesTicketsXML fTXML;
	private FilesAirlinesXML fAXML;

	public ControllerPrint(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		
		guiPT = new GUIPrintTickets();
		guiMain.getDesktopMain().add(guiPT);
		fTXML = new FilesTicketsXML();
		fAXML = new FilesAirlinesXML();
		ArrayList<Tickets> ticketLis = fTXML.returnTickets("Tickets.xml", "Ticket");
		guiPT.fillTicketNum(ticketLis);
		ArrayList<Airlines> airlineList = fAXML.returnAirlines("Airlines.xml", "Airline");
		guiPT.fillAirlineName(airlineList);

		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiPT.getBtnContinue().addActionListener(this);
		guiPT.getBtnPrint().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiPT.getBtnContinue()) {
			//Debe reunir la información ingresada con la que se necesita mostrar en la tabla
		}
		
		if(e.getSource() == guiPT.getBtnPrint()) {
			//Imprimir en la tabla 
		}

	}

}
