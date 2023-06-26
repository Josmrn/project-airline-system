package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.FilesLogicXML;
import data.FilesXML;
import domain.Brands;
import domain.Models;
import presentation.GUIMain;
import presentation.GUIModel;

public class ControllerModels implements ActionListener{

	private GUIModel guiM;
	private Models model;
	private FilesXML fXML;
	private FilesLogicXML fLXML;
	private ArrayListModels arrayLM;
	
	public ControllerModels(GUIMain guiMain) {
	    guiM = new GUIModel();
	    guiMain.getDesktopMain().add(guiM);
	    model = new Models();
	    fXML = new FilesXML();
	    fLXML = new FilesLogicXML();

	    arrayLM = new ArrayListModels();
	    fXML.createXML("Models", "Models.xml");
	   
	    ArrayList<Brands> brandList = fLXML.getBrandXML("Brands.xml", "Brand");
	    guiM.fillBrandCXComboBox(brandList);
	    
	    initializerAction();
	}

	
	public void refreshModel() {
		guiM.getDTMTModels().setRowCount(0);
		ArrayList<Models> arrayModels = fLXML.returnModels("Models.xml", "Model");
		
		for(Models elemento: arrayModels) {
			guiM.getDTMTModels().addRow(new Object[] {elemento.getModel(), elemento.getNameBrands(), 
					elemento.getExecSeats(), elemento.getTourSeats(), elemento.getEcoSeats()});
		}
	}

	private void initializerAction() {
		refreshModel();
		guiM.getBtnAddModels().addActionListener(this);
		guiM.getBtnEditModels().addActionListener(this);
		guiM.getBtnRemoveModels().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == guiM.getBtnAddModels()) {
			
		    boolean modelExist = fLXML.ModelsExistOnXML("Models.xml", "Model", "model", guiM.getTWriteModels().getText());

		    if (modelExist) {
		        JOptionPane.showMessageDialog(null, "El modelo de avión ya se encuentra en el sistema");
		        return;
		    }

		    String nameBrand = (String) guiM.getCxBrandAircraft().getSelectedItem();
		    int execSeats = 0;
		    int tourSeats = 0;
		    int ecoSeats = 0;

		    try {
		        execSeats = Integer.parseInt(guiM.getTExecutiveSeats().getText());
		        tourSeats = Integer.parseInt(guiM.getTTouristSeats().getText());
		        ecoSeats = Integer.parseInt(guiM.getTEconomicSeats().getText());
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "Por favor ingresa un valor numérico válido en los campos de asientos");
		        return;
		    }

		    model = new Models(guiM.getTWriteModels().getText(), nameBrand, execSeats, tourSeats, ecoSeats);

		    fLXML.writeModelXML("Models.xml", "Model", model.getDataName(), model.getData());
		    arrayLM.addModel(model);
		    guiM.getDTMTModels().addRow(new Object[]{guiM.getTWriteModels(), nameBrand, execSeats, tourSeats, ecoSeats});
		    guiM.cleanForm();
		    refreshModel();
		}

		
		if(e.getSource() == guiM.getBtnEditModels()) {
			
		}
		
		if(e.getSource() == guiM.getBtnRemoveModels()) {
			
		}
		
	}
}
