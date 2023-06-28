package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesFlightXML;
import data.FilesTicketsXML;
import domain.Flights;
import domain.Tickets;
import presentation.GUIHistoryTickets;
import presentation.GUIMain;

public class ControllerHistoryTicket implements ActionListener{
	
	private GUIHistoryTickets guiHT;
	private FilesFlightXML fFXML;
	private FilesTicketsXML fTXML;

	public ControllerHistoryTicket(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		guiHT = new GUIHistoryTickets();
		guiMain.getDesktopMain().add(guiHT);
		fFXML = new FilesFlightXML();
		fTXML = new FilesTicketsXML();

		ArrayList<Tickets> ticketLis = fTXML.returnTickets("Tickets.xml", "Ticket");
		guiHT.fillTickets(ticketLis);
		ArrayList<Flights> departList = fFXML.getFlights("Flights.xml", "Flight");
		guiHT.fillDeparture(departList);
		ArrayList<Flights> arrivalList = fFXML.getFlights("Flights.xml", "Flight");
		guiHT.fillArrival(arrivalList);
		ArrayList<Flights> dataDeparList = fFXML.getFlights("Flights.xml", "Flight");
		guiHT.fillDepartData(dataDeparList);
		ArrayList<Flights> dataArrivList = fFXML.getFlights("Flights.xml", "Flight");
		guiHT.fillArrivaDate(dataArrivList);
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiHT.getBtnFilter().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiHT.getBtnFilter()) {
			//Tiene que cargar toda la información a la tabla
		}
		
	}

}
