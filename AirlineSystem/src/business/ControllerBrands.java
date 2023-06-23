package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentation.GUIBrands;
import domain.Brands;
import data.FilesXML;

public class ControllerBrands implements ActionListener {
	
	private GUIBrands guiB;
	private Brands brand;
	private FilesXML fXML;

	public ControllerBrands() {
		
		//No registra marcas
		
		guiB = new GUIBrands();
		brand = new Brands();
		fXML = new FilesXML();
		
		fXML.createXML("Brands", "Brands.xml");
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
			
			brand = new Brands(guiB.getTAddBrand().getText());
			
			fXML.writeLoginXML("Brands.xml", "Brands", brand.getDataName(), brand.getData());
			
			guiB.cleanForm();
			
			guiB.getDTMTBrands().addRow(brand.getData());
		}
		
	}

	
}
