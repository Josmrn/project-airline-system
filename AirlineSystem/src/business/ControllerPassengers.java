package business;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.Passengers;
import data.FilesXML;
import data.FilesPassXML;
import presentation.GUIMain;
import presentation.GUIPassengers;

public class ControllerPassengers implements ActionListener {

	private Passengers passen;
	private GUIPassengers guiPass;
	private FilesXML fXML;
	private FilesPassXML fPXML;
	private ArrayListPassengers arrayLPass;
	
	private String UserType;

	public ControllerPassengers(GUIMain guiMain, String userType) {

		passen = new Passengers();
		guiPass = new GUIPassengers(userType);
		guiMain.getDesktopMain().add(guiPass);
		fXML = new FilesXML();
		fPXML = new FilesPassXML();
		arrayLPass = new ArrayListPassengers();
		UserType = userType;

		fXML.createXML("Passengers", "Passengers.xml");

		initializerAction();
	}

	// Método para refrescar la tabla con los datos dentro del xml
	private void refreshData() {

		guiPass.getDTMTPassengers().setRowCount(0);
		ArrayList<Passengers> arrayPassengers = fPXML.returnPassengers("Passengers.xml", "Passenger");

		for (Passengers elemento : arrayPassengers) {
			guiPass.getDTMTPassengers().addRow(new Object[] { elemento.getPassportNum(), elemento.getName(),
					elemento.getLastName(), elemento.getBornDate(), elemento.getEmail(), elemento.getCellphone() });
		}
	}

	public void initializerAction() {

		refreshData();
		guiPass.getBtnAddPassenger().addActionListener(this);
		guiPass.getBtnConsultPassenger().addActionListener(this);
		guiPass.getBtnEditPassengers(UserType).addActionListener(this);
		guiPass.getBtnRemovePassengers(UserType).addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == guiPass.getBtnAddPassenger()) {

			passen = new Passengers(Integer.parseInt(guiPass.getTPassport().getText()), guiPass.getTName().getText(),
					guiPass.getTLastName().getText(), guiPass.getTBirthDate().getText(), guiPass.getTEmail().getText(),
					Integer.parseInt(guiPass.getTCellphone().getText()));

			fPXML.writePassengerXML("Passengers.xml", "Passenger", passen.getDataName(), passen.getData());

			arrayLPass.addPassenger(passen);

			guiPass.getDTMTPassengers()
					.addRow(new Object[] { guiPass.getTPassport().getText(), guiPass.getTName().getText(),
							guiPass.getTLastName().getText(), guiPass.getTBirthDate().getText(),
							guiPass.getTEmail().getText(), guiPass.getTCellphone().getText() });

			System.out.print(arrayLPass.getArrayListPassengers().size());

		}
		if (e.getSource() == guiPass.getBtnConsultPassenger()) {

			int passportNum = Integer.parseInt(guiPass.getTSearchPassenger().getText());
			Passengers passenger = fPXML.searchPassengers("Passengers.xml", "Passenger", passportNum);

			if (passenger != null) {
				// El pasajero fue encontrado, puedes mostrar los detalles en la interfaz o
				// realizar cualquier acción adicional
				JOptionPane.showMessageDialog(null, "Pasajero encontrado");
				guiPass.getTPassport().setText(String.valueOf(passenger.getPassportNum()));
				guiPass.getTName().setText(passenger.getName());
				guiPass.getTLastName().setText(passenger.getLastName());
				guiPass.getTBirthDate().setText(passenger.getBornDate());
				guiPass.getTEmail().setText(passenger.getEmail());
				guiPass.getTCellphone().setText(String.valueOf(passenger.getCellphone()));

			} else {
				// El pasajero no fue encontrado, puedes mostrar un mensaje de error o realizar
				// cualquier acción adicional
				JOptionPane.showMessageDialog(null, "Pasajero no encontrado");
			}

		}
		if (e.getSource() == guiPass.getBtnEditPassengers(UserType)) {

			// Obtiene los datos del formulario
			int passportNum = Integer.parseInt(guiPass.getTPassport().getText());
			String name = guiPass.getTName().getText();
			String lastName = guiPass.getTLastName().getText();
			String birthDate = guiPass.getTBirthDate().getText();
			String email = guiPass.getTEmail().getText();
			int cellphone = Integer.parseInt(guiPass.getTCellphone().getText());

			int selectedRow = guiPass.getTPassengers().getSelectedRow();
			int selectedColumn = guiPass.getTPassengers().getSelectedColumn();
			
			// Verifica si hay una fila seleccionada
		    if (selectedRow == -1) {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.");
		        return;
		    }
		    // Verifica si hay una columna de ticket seleccionada
		    if (selectedColumn != 0) {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione la columna del numero de pasaporte para editar.");
		        return;
		    }
		    //Guarda el numero de pasaporte original
		    Object passportNumOriginal = guiPass.getDTMTPassengers().getValueAt(selectedRow, selectedColumn);
		    
		    // Modifica el pasajero en el archivo XML
		    fPXML.modifyPassenger("Passengers.xml", "Passenger",passportNumOriginal, passportNum, name, lastName, birthDate, email,
		 	cellphone);

			// Modifica los datos en la tabla
			guiPass.getDTMTPassengers().setValueAt(passportNum, selectedRow, 0);
			guiPass.getDTMTPassengers().setValueAt(name, selectedRow, 1);
			guiPass.getDTMTPassengers().setValueAt(lastName, selectedRow, 2);
			guiPass.getDTMTPassengers().setValueAt(birthDate, selectedRow, 3);
			guiPass.getDTMTPassengers().setValueAt(email, selectedRow, 4);
			guiPass.getDTMTPassengers().setValueAt(cellphone, selectedRow, 5);

			

		}
		if (e.getSource() == guiPass.getBtnRemovePassengers(UserType)) {

			int passportNum = Integer.parseInt(guiPass.getTSearchPassenger().getText());

			// Elimina el dato dentro del xml y refrescar en la tabla
			Passengers p = fPXML.searchPassengerAndDelete("Passengers.xml", "Passenger", passportNum);

			if (p != null) {
				arrayLPass.removePassenger(p);
				refreshData();
				JOptionPane.showMessageDialog(null, "El pasajero se eliminó correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "El pasajero no se encontró o no pudo ser eliminado.");
			}

		}

	}

}
