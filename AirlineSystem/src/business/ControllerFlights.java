package business;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import data.FilesFlightXML;
import data.FilesXML;
import data.FilesPlanesXML;
import domain.Flights;
import domain.Planes;
import presentation.GUIFlights;
import presentation.GUIMain;

public class ControllerFlights implements ActionListener {

	private GUIFlights guiF;
	private Flights f;
	private FilesXML fXML;
	private FilesFlightXML fFXML;
	private FilesPlanesXML fPXML;
	private ArrayListFlight arrayLFlight;
	
	private String UserType;

	public ControllerFlights(GUIMain guiMain,String userType) {
		// TODO Auto-generated constructor stub
		guiF = new GUIFlights(userType);
		guiMain.getDesktopMain().add(guiF);
		f = new Flights();
		fXML = new FilesXML();
		fFXML = new FilesFlightXML();
		fPXML = new FilesPlanesXML();
		arrayLFlight = new ArrayListFlight();
		fXML.createXML("Flights", "Flights.xml");
		UserType = userType;
		
		ArrayList<Planes> planelList = fPXML.returnPlanes("Planes.xml", "Plane");
		
		guiF.fillAirlineComboBox(planelList);
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		refreshFlight();
		guiF.getBtnAddFlight().addActionListener(this);
		guiF.getBtnEditFlights(UserType).addActionListener(this);
		guiF.getBtnRemoveFlights(UserType).addActionListener(this);
		guiF.getBtnConsultFlight().addActionListener(this);
	}
	
	public void refreshFlight() {
		guiF.getDTMTFlights().setRowCount(0);
		ArrayList<Flights> arrayFlights = fFXML.getFlights("Flights.xml", "Flight");

		for (Flights elemento : arrayFlights) {
			guiF.getDTMTFlights().addRow(new Object[] { elemento.getFlightNum(),elemento.getDepartureCity(), elemento.getDepartureDate(), 
					elemento.getDepartureHour(),elemento.getArrivalCity(), elemento.getArrivalDate(), elemento.getArrivalHour(), 
					elemento.getPlane(),elemento.getAmountOfExecSeat(), elemento.getAmountOfTourSeat(), 
					elemento.getAmountOfEcoSeat()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == guiF.getBtnAddFlight()) {
			
			//No se puede repetir vuelos con los mismos aviones en un rango de 20 horas, validación aquí y en xml
			//Numero generado
			Random random = new Random();
			int randomNumber = random.nextInt(101);
			//ComboBox
			String planeAirline = (String) guiF.getCxFlightAirline().getSelectedItem();
			
			//Fechas de salida y llegada respectivamente
			Date depDate = guiF.getDepartureData().getDate();
			LocalDate departureDate = depDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			Date arrDate = guiF.getArrivalDate().getDate();
			LocalDate arrivalDate = arrDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			//Horas de salida y llegada respectivamente
			String depHour = guiF.getTDepartureHour().getText();
			String arrHour = guiF.getTArrivalHour().getText();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
			LocalTime departureHour = LocalTime.parse(depHour, formatter);
			LocalTime arrivalHour = LocalTime.parse(arrHour, formatter);
			
			f = new Flights(randomNumber,guiF.getTDepartureCity().getText(),departureDate,
					departureHour,guiF.getTArrivalCity().getText(),
					arrivalDate,arrivalHour,planeAirline,
					Integer.parseInt(guiF.getTExecutive().getText()),Integer.parseInt(guiF.getTTourist().getText()),
					Integer.parseInt(guiF.getTEconomic().getText()));
			
			//String[] newFlightData = f.getData(); 
			
			//Flights existingFlight = fFXML.searchFlight("Flights.xml", "Flight", newFlightData[7]);
			 // Validación de superposición de vuelos en un rango de 20 horas
		    boolean isValidFlight = true;
		    for (Flights existingFlight : arrayLFlight.getArrayListFlights()) {
		        if (existingFlight.getPlane().equals(planeAirline)) {
		        	LocalDate existingDepartureDate = existingFlight.getDepartureDate();
		            LocalTime existingDepartureHour = existingFlight.getDepartureHour();
		            LocalDateTime existingDepartureDateTime = LocalDateTime.of(existingDepartureDate, existingDepartureHour);
		            
		            LocalDate existingArrivalDate = existingFlight.getArrivalDate();
		            LocalTime existingArrivalHour = existingFlight.getArrivalHour();
		            LocalDateTime existingArrivalDateTime = LocalDateTime.of(existingArrivalDate, existingArrivalHour);
		            
		            LocalDateTime newDepartureDateTime = LocalDateTime.of(departureDate, departureHour);
		            LocalDateTime newArrivalDateTime = LocalDateTime.of(arrivalDate, arrivalHour);
		            
		            if (newDepartureDateTime.isBefore(existingArrivalDateTime.plusHours(20))
		                    && newArrivalDateTime.isAfter(existingDepartureDateTime.minusHours(20))) {
		                isValidFlight = false;
		                break;
		            }
		        }
		    }

		    if (isValidFlight) {
		        // Realizar el registro del nuevo vuelo
		        fFXML.writeFlightXML("Flights.xml", "Flight", f.getDataName(), f.getData());
		        arrayLFlight.addFlight(f);
		        guiF.getDTMTFlights().addRow(new Object[] { randomNumber, guiF.getTDepartureCity().getText(),
		                departureDate, departureHour, guiF.getTArrivalCity().getText(), arrivalDate, arrivalHour,
		                planeAirline, Integer.parseInt(guiF.getTExecutive().getText()),
		                Integer.parseInt(guiF.getTTourist().getText()), Integer.parseInt(guiF.getTEconomic().getText()) });
		        
		        System.out.print(arrayLFlight.getArrayListFlights().size());
		    } else {
		    	JOptionPane.showMessageDialog(null, "No se pudo registrar el vuelo");
		    }
		    
		}

		fFXML.modifyFlight("Flights.xml", "Flight", guiF.getTSearchFlights().getText(), f.getDataName(), f.getData());


		if (e.getSource() == guiF.getBtnRemoveFlights(UserType)) {
			
			int flightNum = Integer.parseInt(guiF.getTSearchFlights().getText());

			// Elimina el dato dentro del xml y refrescar en la tabla
			Flights f = fFXML.searchFlightAndDelete("Flights.xml", "Flight", flightNum);

			if (f != null) {
				arrayLFlight.removeFlight(f);
				refreshFlight();
				JOptionPane.showMessageDialog(null, "El vuelo se eliminó correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "El vuelo no se encontró o no pudo ser eliminado.");
			}	
			
			
		}
		
		if(e.getSource() == guiF.getBtnConsultFlight()) {
			Flights flight = fFXML.searchFlight("Flights.xml", "Flight", guiF.getTSearchFlights().getText());
			
			if(flight != null ) {
				//Falta agregar las horas en la consulta
				JOptionPane.showMessageDialog(null, "Vuelo encontrado");
				guiF.getTDepartureCity().setText(flight.getDepartureCity());
				guiF.getTArrivalCity().setText(flight.getArrivalCity());
				//guiF.getDepartureData().setSelectableDateRange(f.getDepartureDate(), f.getDepartureDate());
				//guiF.getArrivalDate().setSelectableDateRange(arrivalDate, arrivalDate);
				guiF.getTDepartureHour().setText(String.valueOf(flight.getDepartureHour()));
				guiF.getTArrivalHour().setText(String.valueOf(flight.getArrivalHour()));
				guiF.getCxFlightAirline().setSelectedItem(flight.getPlane());
				guiF.getTExecutive().setText(String.valueOf(flight.getAmountOfExecSeat()));
				guiF.getTTourist().setText(String.valueOf(flight.getAmountOfTourSeat()));
				guiF.getTEconomic().setText(String.valueOf(flight.getAmountOfEcoSeat()));
			}
		}
	}

}
