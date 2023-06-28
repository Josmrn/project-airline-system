package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.Airlines;
import domain.Models;
import domain.Planes;
import data.FilesXML;
import data.FilesModelsXML;
import data.FilesAirlinesXML;
import data.FilesPlanesXML;
import presentation.GUIMain;
import presentation.GUIPlanes;

public class ControllerPlanes implements ActionListener{

	private GUIPlanes guiP;
	private FilesXML fXML;
	private FilesPlanesXML fPXML;
	private FilesModelsXML fMXML;
	private FilesAirlinesXML fAXML;
	private Planes plane;
	private ArrayListAircraft arrayLAircrafts;
	
	private String UserType;
	
	public ControllerPlanes(GUIMain guiMain, String userType) {
		// TODO Auto-generated constructor stub
		plane = new Planes();
		guiP = new GUIPlanes(userType);
		guiMain.getDesktopMain().add(guiP);
		fXML = new FilesXML();
		fPXML = new FilesPlanesXML();
		fMXML = new FilesModelsXML();
		fAXML = new FilesAirlinesXML();
		arrayLAircrafts = new ArrayListAircraft();
		UserType = userType;
		
		fXML.createXML("Planes", "Planes.xml");
		
		ArrayList<Models> modelList = fMXML.returnModels("Models.xml", "Model");
		ArrayList<Airlines> airlineList = fAXML.returnAirlines("Airlines.xml", "Airline");

		guiP.fillModelsComboBox(modelList);
		guiP.fillAirlineComboBox(airlineList);

		
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		
		refreshData();
		guiP.getBtnAddPlanes().addActionListener(this);
		guiP.getBtnEditPlanes(UserType).addActionListener(this);
		guiP.getBtnRemovePlanes(UserType).addActionListener(this);
		guiP.getBtnConsultPlane().addActionListener(this);
	}
	
	
	// Método para refrescar la tabla con los datos dentro del xml
			private void refreshData() {

			guiP.getDTMTPlanes().setRowCount(0);
			ArrayList<Planes> arrayPlanes = fPXML.returnPlanes("Planes.xml", "Plane");

			for (Planes elemento : arrayPlanes) {
				guiP.getDTMTPlanes().addRow( new Object[] { elemento.getRegisterOfAircft(), elemento.getAirline(),
						elemento.getModel(),elemento.getYear()});
				}
			}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiP.getBtnAddPlanes()) {
			
			String airline = (String) guiP.getCxPlaneAirline().getSelectedItem();
		    String model = (String) guiP.getCxPlaneModel().getSelectedItem();
			
			plane = new Planes(guiP.getTWritePlanes().getText(),airline,model,Integer.parseInt(guiP.getTYear().getText()));

			fPXML.writePlanesXML("Planes.xml", "Plane", plane.getDataName(), plane.getData());

			arrayLAircrafts.addAircraft(plane);

			guiP.getDTMTPlanes().addRow(new Object[] { guiP.getTWritePlanes().getText(),airline,model,guiP.getTYear().getText()});

			System.out.print(arrayLAircrafts.getArrayListAircraft().size());
			
			
		}
		
		if(e.getSource() == guiP.getBtnEditPlanes(UserType)) {
			
			
			String nameRegister = guiP.getTWritePlanes().getText();
			String airline = (String) guiP.getCxPlaneAirline().getSelectedItem();
		    String model = (String) guiP.getCxPlaneModel().getSelectedItem();
			int year = Integer.parseInt(guiP.getTYear().getText());
			
			int selectedRow = guiP.getTPlanes().getSelectedRow();
			int selectedColumn = guiP.getTPlanes().getSelectedColumn();
									
			if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.");
			return;
			}
			
			if (selectedColumn != 0) {
			JOptionPane.showMessageDialog(null, "Por favor, seleccione la columna de la matricula del avion para editar.");
			return;
			}
			
			Object nameRegisterOriginal = guiP.getDTMTPlanes().getValueAt(selectedRow, selectedColumn);

			
			guiP.getDTMTPlanes().setValueAt(nameRegister, selectedRow, 0);
			guiP.getDTMTPlanes().setValueAt(airline, selectedRow, 1);
			guiP.getDTMTPlanes().setValueAt(model, selectedRow, 2);
			guiP.getDTMTPlanes().setValueAt(year, selectedRow, 3);

			fPXML.modifyPlanes("Planes.xml", "Plane",nameRegisterOriginal ,nameRegister ,airline ,model, year);
			
			
		}
		
		if(e.getSource() == guiP.getBtnRemovePlanes(UserType)) {
			
			String plane = guiP.getTSearchPlanes().getText();

			// Elimina el dato dentro del xml y refrescar en la tabla
			Planes p = fPXML.planesDelete("Planes.xml", "Plane", plane);

			if (p != null) {
				arrayLAircrafts.removePlanes(p);
				refreshData();
				JOptionPane.showMessageDialog(null, "El avion se eliminó correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "El avion no se encontró o no pudo ser eliminado.");
			}		
		}
		if(e.getSource() == guiP.getBtnConsultPlane()) {
			
			Planes plane = fPXML.searchPlanes("Planes.xml", "Plane", guiP.getTSearchPlanes().getText());

			if (plane != null) {
				JOptionPane.showMessageDialog(null, "Avion encontrado");
				guiP.getTWritePlanes().setText(plane.getRegisterOfAircft());
				guiP.getCxPlaneAirline().setSelectedItem(plane.getAirline());
				guiP.getCxPlaneModel().setSelectedItem(plane.getModel());
				guiP.getTYear().setText(String.valueOf(plane.getYear()));
		
			} else {
				JOptionPane.showMessageDialog(null, "Avion no encontrado");
			}	
			
		}
				
	}

}
