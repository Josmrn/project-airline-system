package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.Airlines;
import data.FilesXML;
import data.FilesAirlinesXML;
import presentation.GUIAirlines;
import presentation.GUIMain;

public class ControllerAirlines implements ActionListener{

	private GUIAirlines guiAir;
	private Airlines airline;
	private FilesXML fXML;
	private FilesAirlinesXML fAXML;
	private ArrayListAirline arrayLAirlines;
	
	
	public ControllerAirlines(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		airline = new Airlines();
		guiAir = new GUIAirlines();
		guiMain.getDesktopMain().add(guiAir);
		fXML = new FilesXML();
		fAXML = new FilesAirlinesXML();
		arrayLAirlines = new ArrayListAirline();
		
		fXML.createXML("Airlines", "Airlines.xml");

		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		refreshData();
		guiAir.getBtnAddAirlines().addActionListener(this);
		guiAir.getBtnEditAirlines().addActionListener(this);
		guiAir.getBtnRemoveAirlines().addActionListener(this);
		guiAir.getBtnConsultAirlines().addActionListener(this);
	}
	
	
		// Método para refrescar la tabla con los datos dentro del xml
		private void refreshData() {

		guiAir.getDTMTAirlines().setRowCount(0);
		ArrayList<Airlines> arrayAirlines = fAXML.returnAirlines("Airlines.xml", "Airline");

		for (Airlines elemento : arrayAirlines) {
			guiAir.getDTMTAirlines().addRow( new Object[] { elemento.getNameAirline(), elemento.getCountry() });
			}
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiAir.getBtnAddAirlines()) {
			
			airline = new Airlines(guiAir.getTWriteAirlines().getText(),guiAir.getTOpeCenter().getText());

			fAXML.writeAirlineXML("Airlines.xml", "Airline", airline.getDataName(), airline.getData());

			arrayLAirlines.addAirline(airline);

			guiAir.getDTMTAirlines().addRow(new Object[] { guiAir.getTWriteAirlines().getText(),guiAir.getTOpeCenter().getText()});

			System.out.print(arrayLAirlines.getArrayLAirlines().size());
			
		}
		
		if(e.getSource() == guiAir.getBtnEditAirlines()) {
			
			// Obtiene los datos del formulario
			String nameAirline = guiAir.getTWriteAirlines().getText();
			String country = guiAir.getTOpeCenter().getText();

			int selectedRow = guiAir.getTAirlines().getSelectedRow();
			int selectedColumn = guiAir.getTAirlines().getSelectedColumn();
						
			// Verifica si hay una fila seleccionada
			if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.");
			return;
			}
			// Verifica si hay una columna de ticket seleccionada
			if (selectedColumn != 0) {
			JOptionPane.showMessageDialog(null, "Por favor, seleccione la columna del nombre de aerolinea para editar.");
			return;
			}
					    
			//Guarda el valor del ticket original
			Object nameAirlineOriginal = guiAir.getDTMTAirlines().getValueAt(selectedRow, selectedColumn);
					    
			// Modifica el pasajero en el archivo XML
			fAXML.modifyAirline("Airlines.xml", "Airline",nameAirlineOriginal, nameAirline, country);
					    
			// Modifica los datos en la tabla
			guiAir.getDTMTAirlines().setValueAt(nameAirline, selectedRow, 0);
			guiAir.getDTMTAirlines().setValueAt(country, selectedRow, 1);
	
			
		}
		
		if(e.getSource() == guiAir.getBtnRemoveAirlines()) {
			
			String nameAirline = guiAir.getTSearchAirline().getText();

			// Elimina el dato dentro del xml y refrescar en la tabla
			Airlines a = fAXML.searchAirlineAndDelete("Airlines.xml", "Airline", nameAirline);

			if (a != null) {
				arrayLAirlines.removeAirline(a);
				refreshData();
				JOptionPane.showMessageDialog(null, "La aerolinea se eliminó correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "La aerolinea no se encontró o no pudo ser eliminado.");
			}
			
		}
		if(e.getSource() == guiAir.getBtnConsultAirlines()) {
			
			String nameAirline = guiAir.getTSearchAirline().getText();
			Airlines airline = fAXML.searchAirline("Airlines.xml", "Airline", nameAirline);

			if (airline != null) {
				// El usuario fue encontrado, puedes mostrar los detalles en la interfaz o
				// realizar cualquier acción adicional
				JOptionPane.showMessageDialog(null, "Aerolinea encontrada");
				guiAir.getTWriteAirlines().setText(airline.getNameAirline());
				guiAir.getTOpeCenter().setText(airline.getCountry());
				

			} else {
				// El usuario no fue encontrado, puedes mostrar un mensaje de error o realizar
				// cualquier acción adicional
				JOptionPane.showMessageDialog(null, "Aerolinea no encontrada");
			}
			
		}
	}

}
