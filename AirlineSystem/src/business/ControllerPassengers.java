package business;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import domain.Passengers;
import data.FilesXML;
import data.FilesLogicXML;
import presentation.GUIMain;
import presentation.GUIPassengers;

public class ControllerPassengers implements ActionListener{
	
	private Passengers passen;
	private GUIPassengers guiPass;
	private FilesXML fXML;
	private FilesLogicXML fLogXML;
//	private ArrayListPasengers arrayLPass;
	
	public ControllerPassengers(GUIMain guiMain) {
		
		passen = new Passengers();
		guiPass = new GUIPassengers();
		guiMain.getDesktopMain().add(guiPass);
		fXML = new FilesXML();
		fLogXML = new FilesLogicXML();
		//arrayLPass = new ArrayListPassengers();
		
		fXML.createXML("Passengers", "Passengers.xml");
		
		initializerAction();
	}
	
	//Método para refrescar la tabla con los datos dentro del xml
		private void refreshData() {
		/*	
			guiPass.getDTMTPassengers().setRowCount(0);
			ArrayList<Passengers> arrayPassengers = fLogXML.returnPassengers("Passengers.xml", "Passenger");
			
			for(Passengers elemento : arrayPassengers) {
				guiPass.getDTMTPassengers().addRow(new Object[] { elemento.getPassportNum(),
						elemento.getName(),elemento.getLastName(), elemento.getEmail(),
						elemento.getBornDate(),elemento.getCellphone()});
			}*/
		}
	
	
	
	public void initializerAction() {
		
		refreshData();
		guiPass.getBtnAddPassenger().addActionListener(this);
		guiPass.getBtnConsultPassenger().addActionListener(this);
		guiPass.getBtnEditPassengers().addActionListener(this);
		guiPass.getBtnRemovePassengers().addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == guiPass.getBtnAddPassenger()) {
			
			passen = new Passengers(Integer.parseInt(guiPass.getTPassport().getText()),
					guiPass.getTName().getText(),guiPass.getTLastName().getText(),
					guiPass.getTBirthDate().getText(),guiPass.getTEmail().getText(),
					Integer.parseInt(guiPass.getTCellphone().getText()));
			
			fLogXML.writePassengerXML("Passengers.xml", "Passenger", passen.getDataName(), passen.getData());
			
			//arrayLPass.addPassenger(passen);
			
			guiPass.getDTMTPassengers().addRow(new Object[] {guiPass.getTPassport().getText(),
					guiPass.getTName().getText(),guiPass.getTLastName().getText(),
					guiPass.getTBirthDate().getText(),guiPass.getTEmail().getText(),
					guiPass.getTCellphone().getText()});
			
			//System.out.print(arrayLPass.getArrayListPassengers().size());
			
			
		}
		if(e.getSource() == guiPass.getBtnConsultPassenger()) {
			
			int passportNum = Integer.parseInt(guiPass.getTSearchPassenger().getText());
		    Passengers passenger = fLogXML.searchPassengers("Passengers.xml", "Passenger", passportNum);
		    
		    if (passenger != null) {
		        // El usuario fue encontrado, puedes mostrar los detalles en la interfaz o realizar cualquier acción adicional
		    	JOptionPane.showMessageDialog(null, "Pasajero encontrado");
		    	guiPass.getTPassport().setText(String.valueOf(passenger.getPassportNum()));
		    	guiPass.getTName().setText(passenger.getName());
		    	guiPass.getTLastName().setText(passenger.getLastName());
		    	guiPass.getTBirthDate().setText(passenger.getBornDate());
		    	guiPass.getTEmail().setText(passenger.getEmail());
		    	guiPass.getTCellphone().setText(String.valueOf(passenger.getCellphone()));
		   
		    } else {
		        // El usuario no fue encontrado, puedes mostrar un mensaje de error o realizar cualquier acción adicional
		        JOptionPane.showMessageDialog(null, "Pasajero no encontrado");
		    }
			
			
			
			
		}
		if(e.getSource() == guiPass.getBtnEditPassengers()) {
			
			
			
		}
		if(e.getSource() == guiPass.getBtnRemovePassengers()) {
			
			
			
		}
		
		
	}
	
	
}
