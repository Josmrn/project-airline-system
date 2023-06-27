package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.Airlines;
import domain.Planes;
import data.FilesXML;
import data.FilesLogicXML;
import presentation.GUIMain;
import presentation.GUIPlanes;

public class ControllerAircraft implements ActionListener{

	private GUIPlanes guiP;
	private FilesXML fXML;
	private FilesLogicXML fLogXML;
	private Planes plane;
	private ArrayListAircraft arrayLAircrafts;
	
	public ControllerAircraft(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		plane = new Planes();
		guiP = new GUIPlanes();
		guiMain.getDesktopMain().add(guiP);
		fXML = new FilesXML();
		fLogXML = new FilesLogicXML();
		arrayLAircrafts = new ArrayListAircraft();
		
		fXML.createXML("Planes", "Planes.xml");
		
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		
		refreshData();
		guiP.getBtnAddPlanes().addActionListener(this);
		guiP.getBtnEditPlanes().addActionListener(this);
		guiP.getBtnRemovePlanes().addActionListener(this);
		guiP.getBtnConsultPlane().addActionListener(this);
	}
	
	
	// Método para refrescar la tabla con los datos dentro del xml
			private void refreshData() {

			guiP.getDTMTPlanes().setRowCount(0);
			ArrayList<Planes> arrayPlanes = fLogXML.returnPlanes("Planes.xml", "Plane");

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

			fLogXML.writePlaneXML("Airlines.xml", "Airline", plane.getDataName(), plane.getData());

			arrayLAircrafts.addAircraft(plane);

			guiP.getDTMTPlanes().addRow(new Object[] { guiP.getTWritePlanes().getText(),airline,model,guiP.getTYear().getText()});

			System.out.print(arrayLAircrafts.getArrayListAircraft().size());
			
			
		}
		
		if(e.getSource() == guiP.getBtnEditPlanes()) {
			
			// Obtiene los datos del formulario
			String plane = guiP.getTWritePlanes().getText();
			String airline = (String) guiP.getCxPlaneAirline().getSelectedItem();
			String model = (String) guiP.getCxPlaneModel().getSelectedItem();
			String year = guiP.getTYear().getText();
			

			int selectedRow = guiP.getTPlanes().getSelectedRow();
			int selectedColumn = guiP.getTPlanes().getSelectedColumn();
									
			// Verifica si hay una fila seleccionada
			if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.");
			return;
			}
			// Verifica si hay una columna de ticket seleccionada
			if (selectedColumn != 0) {
			JOptionPane.showMessageDialog(null, "Por favor, seleccione la columna de la matricula del avion para editar.");
			return;
			}
								    
			//Guarda el valor del ticket original
			Object planeOriginal = guiP.getDTMTPlanes().getValueAt(selectedRow, selectedColumn);
								    
			// Modifica el pasajero en el archivo XML
			fLogXML.modifyPlane("Planes.xml", "Plane",planeOriginal,plane, airline, model,year);
								    
			// Modifica los datos en la tabla
			guiP.getDTMTPlanes().setValueAt(plane, selectedRow, 0);
			guiP.getDTMTPlanes().setValueAt(airline, selectedRow, 1);
			guiP.getDTMTPlanes().setValueAt(model, selectedRow, 2);
			guiP.getDTMTPlanes().setValueAt(year, selectedRow, 3);

			
		}
		
		if(e.getSource() == guiP.getBtnRemovePlanes()) {
			
			String plane = guiP.getTSearchPlanes().getText();

			// Elimina el dato dentro del xml y refrescar en la tabla
			Planes p = fLogXML.searchPlaneAndDelete("Planes.xml", "Plane", plane);

			if (p != null) {
				arrayLAircrafts.removePlanes(p);
				refreshData();
				JOptionPane.showMessageDialog(null, "El avion se eliminó correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "El avion no se encontró o no pudo ser eliminado.");
			}
			
			
		}
		if(e.getSource() == guiP.getBtnConsultPlane()) {
			
			String planee = guiP.getTSearchPlanes().getText();
			Planes plane = fLogXML.searchPlane("Planes.xml", "Plane", planee);

			if (plane != null) {
				// El usuario fue encontrado, puedes mostrar los detalles en la interfaz o
				// realizar cualquier acción adicional
				JOptionPane.showMessageDialog(null, "Avion encontrado");
				guiP.getTWritePlanes().setText(plane.getRegisterOfAircft());
				guiP.getCxPlaneAirline().setSelectedItem(plane.getAirline());
				guiP.getCxPlaneModel().setSelectedItem(plane.getModel());
				guiP.getTYear().setText(String.valueOf(plane.getYear()));
				
				

			} else {
				// El usuario no fue encontrado, puedes mostrar un mensaje de error o realizar
				// cualquier acción adicional
				JOptionPane.showMessageDialog(null, "Avion no encontrado");
			}
			
			
			
		}
		
		
		
	}

}
