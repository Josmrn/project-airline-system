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

public class ControllerModels implements ActionListener {

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

		for (Models elemento : arrayModels) {
			guiM.getDTMTModels().addRow(new Object[] { elemento.getName(), elemento.getBrand(), elemento.getExecSeats(),
					elemento.getTourSeats(), elemento.getEcoSeats() });
		}
	}

	private void initializerAction() {
		refreshModel();
		guiM.getBtnAddModels().addActionListener(this);
		guiM.getBtnEditModels().addActionListener(this);
		guiM.getBtnRemoveModels().addActionListener(this);
		guiM.getBtnConsultModel().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == guiM.getBtnAddModels()) {
			boolean modelExist = fLXML.modelsExistOnXML("Models.xml", "Model", "model",
					guiM.getTWriteModels().getText());

			if (modelExist) {
				JOptionPane.showMessageDialog(null, "El modelo de avión ya se encuentra en el sistema");
				return;
			}


			model = new Models(guiM.getTWriteModels().getText(), guiM.getCXBrandAircraft().getSelectedItem().toString(),
					Integer.parseInt(guiM.getTExecutiveSeats().getText()),
					Integer.parseInt(guiM.getTTouristSeats().getText()),
					Integer.parseInt(guiM.getTEconomicSeats().getText()));

			fLXML.writeModelXML("Models.xml", "Model", model.getDataName(), model.getData());
			arrayLM.addModel(model);
			guiM.getDTMTModels().addRow(new Object[] { guiM.getTWriteModels().getText(),
					guiM.getCXBrandAircraft().getSelectedItem(), Integer.parseInt(guiM.getTExecutiveSeats().getText()),
					Integer.parseInt(guiM.getTTouristSeats().getText()),
					Integer.parseInt(guiM.getTEconomicSeats().getText())});
			guiM.cleanForm();
			refreshModel();
		}

		if (e.getSource() == guiM.getBtnEditModels()) {
		    String execSeatsStr = guiM.getTExecutiveSeats().getText();
		    String tourSeatsStr = guiM.getTTouristSeats().getText();
		    String ecoSeatsStr = guiM.getTEconomicSeats().getText();

		    int execSeats = Integer.parseInt(execSeatsStr);
		    int tourSeats = Integer.parseInt(tourSeatsStr);
		    int ecoSeats = Integer.parseInt(ecoSeatsStr);

		    fLXML.modifyModel("Models.xml", "Model", guiM.getTWriteModels().getText(), String.valueOf(guiM.getCXBrandAircraft().getSelectedItem()), execSeats, tourSeats, ecoSeats);

		    JOptionPane.showMessageDialog(null, "Se ha modificado exitosamente");
		    refreshModel();
		}


		if (e.getSource() == guiM.getBtnRemoveModels()) {
			
			Models model = fLXML.modelDelete("Models.xml", "Model", guiM.getTSearchModels().getText());
			
			if(model != null) {
				arrayLM.removeModel(model);
				refreshModel();
				JOptionPane.showMessageDialog(null, "El modelo se eliminó correctamente.");
			}else {
				JOptionPane.showMessageDialog(null, "El modelo no se encontró o no pudo ser eliminado.");
			}
		}
		
		if(e.getSource() == guiM.getBtnConsultModel()) {
			
			Models model = fLXML.searchModel("Models.xml", "Model", guiM.getTSearchModels().getText());
			
			if(model != null) {
				JOptionPane.showMessageDialog(null, "Modelo encontrado");
				guiM.getTWriteModels().setText(model.getName());
				guiM.getCXBrandAircraft().setSelectedItem(model.getBrand());
				guiM.getTExecutiveSeats().setText(String.valueOf(model.getExecSeats()));
				guiM.getTTouristSeats().setText(String.valueOf(model.getTourSeats()));
				guiM.getTEconomicSeats().setText(String.valueOf(model.getEcoSeats()));
				
			}else {
				JOptionPane.showMessageDialog(null, "Modelo NO encontrado");
			}
			
		}
	}
}
