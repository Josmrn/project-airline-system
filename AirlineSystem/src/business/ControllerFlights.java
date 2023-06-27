package business;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.FilesFlightXML;
import data.FilesXML;
import domain.Flights;

import presentation.GUIFlights;
import presentation.GUIMain;

public class ControllerFlights implements ActionListener {

	private GUIFlights guiF;
	private Flights f;
	private FilesXML fXML;
	private FilesFlightXML fFXML;
	private ArrayListFlight arrayLFlight;

	public ControllerFlights(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		guiF = new GUIFlights();
		guiMain.getDesktopMain().add(guiF);
		f = new Flights();
		fXML = new FilesXML();
		fFXML = new FilesFlightXML();
		arrayLFlight = new ArrayListFlight();
		fXML.createXML("Flights", "Flights.xml");
		
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiF.getBtnAddFlight().addActionListener(this);
		guiF.getBtnEditFlights().addActionListener(this);
		guiF.getBtnRemoveFlights().addActionListener(this);
		guiF.getBtnConsultFlight().addActionListener(this);
	}
	
	public void refreshFlight() {
		guiF.getDTMTFlights().setRowCount(0);
		ArrayList<Flights> arrayFlights = fFXML.getFlights("Flights.xml", "Flight");

		for (Flights elemento : arrayFlights) {
			guiF.getDTMTFlights().addRow(new Object[] { elemento.getDepartureCity(), elemento.getDepartureDate(), elemento.getDepartureHour(),
					elemento.getPlane(), elemento.getArrivalCity(), elemento.getArrivalDate(), elemento.getArrivalHour(),
					elemento.getAmountOfExecSeat(), elemento.getAmountOfTourSeat(), elemento.getAmountOfEcoSeat()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == guiF.getBtnAddFlight()) {

			//No se puede repetir vuelos con los mismos aviones en un rango de 20 horas, validación aquí y en xml
			
		}

		if (e.getSource() == guiF.getBtnEditFlights()) {

		}

		if (e.getSource() == guiF.getBtnRemoveFlights()) {

		}
		
		if(e.getSource() == guiF.getBtnConsultFlight()) {
			
		}
	}

}
