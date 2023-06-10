package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUIBrand;

import domain.Brands;

import data.FilesXML;

public class ControllerBrands implements ActionListener {
	
	private GUIBrand guiB;
	private Brands brand;
	private FilesXML fXMLBr;

	public ControllerBrands() {
		
		guiB = new GUIBrand();
		brand = new Brands();
		fXMLBr = new FilesXML();
		
		fXMLBr.createXML("Brands", "Brands.xml");
		initializerAction();
	}
	
	
	
	
	private void initializerAction() {
		
		guiB.getBtnRegisterBrand().addActionListener(this);
		guiB.getBtnConsultBrand().addActionListener(this);
		guiB.getBtnEditBrands().addActionListener(this);
		guiB.getBtnReadBrand().addActionListener(this);
		guiB.getBtnRemoveBrand().addActionListener(this);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiB.getBtnRegisterBrand()) {
			
			brand = new Brands(guiB.getTNameBrands().getText());
			
			fXMLBr.writeXML("Brands.xml", "Brands", brand.getDataName(), brand.getData());
			
			guiB.cleanForm();
			
			guiB.getDTMTBrands().addRow(brand.getData());
			
			
		}
		
	}

	
}
