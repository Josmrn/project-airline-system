package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesAirlinesXML;
import data.FilesFlightXML;
import data.FilesTicketsXML;
import domain.Airlines;
import domain.Flights;
import domain.PrintTicket;
import domain.Tickets;
import presentation.GUIMain;
import presentation.GUIPrintTickets;

public class ControllerPrint implements ActionListener{
	
	private PrintTicket printT;
	private GUIPrintTickets guiPT;
	private FilesTicketsXML fTXML;
	private FilesFlightXML fFXML;
	private FilesAirlinesXML fAXML;
	private ArrayListPrint arrayLPrint;

	public ControllerPrint(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		printT = new PrintTicket();
		guiPT = new GUIPrintTickets();
		guiMain.getDesktopMain().add(guiPT);
		arrayLPrint = new ArrayListPrint();
		fTXML = new FilesTicketsXML();
		fFXML = new FilesFlightXML();
		fAXML = new FilesAirlinesXML();
		ArrayList<Tickets> ticketLis = fTXML.returnTickets("Tickets.xml", "Ticket");
		guiPT.fillTicketNum(ticketLis);
		ArrayList<Flights> flightList = fFXML.getFlights("Flights.xml", "Flight");
		guiPT.fillFlightNum(flightList);
		ArrayList<Airlines> airlineList = fAXML.returnAirlines("Airlines.xml", "Airline");
		guiPT.fillAirlineName(airlineList);
		
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
