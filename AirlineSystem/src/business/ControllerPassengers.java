package business;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import domain.Passengers;
import data.FilesXML;
import data.FilesLoginXML;
import presentation.GUIMain;
import presentation.GUIPassengers;

public class ControllerPassengers implements ActionListener{
	
	private Passengers passen;
	private GUIPassengers guiPass;
	private FilesXML fXML;
	private FilesLoginXML fLogXML;
//	private ArrayListPasengers arrayLPass;
	
	public ControllerPassengers(GUIMain guiMain) {
		
		passen = new Passengers();
		guiPass = new GUIPassengers();
		guiMain.getDesktopMain().add(guiPass);
		fXML = new FilesXML();
		fLogXML = new FilesLoginXML();
		
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
			
			
			
		}
		if(e.getSource() == guiPass.getBtnConsultPassenger()) {
			
			
			
		}
		if(e.getSource() == guiPass.getBtnEditPassengers()) {
			
			
			
		}
		if(e.getSource() == guiPass.getBtnRemovePassengers()) {
			
			
			
		}
		
		
	}
	
	
}
