package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import presentation.GUIBrands;
import presentation.GUIMain;
import domain.Brands;
import data.FilesLogicXML;
import data.FilesXML;

public class ControllerBrands implements ActionListener {

	private GUIBrands guiB;
	private FilesXML fXML;
	private Brands brand;
	private FilesLogicXML fLXML;
	private ArrayListBrands arrayLB;

	public ControllerBrands(GUIMain guiMain) {
        guiB = new GUIBrands();
        guiMain.getDesktopMain().add(guiB);
        brand = new Brands();
        fXML = new FilesXML();
        fLXML = new FilesLogicXML();
        arrayLB = new ArrayListBrands();
        fXML.createXML("Brands", "Brands.xml");

        initializerAction();
    }

	private void refreshData() {
		guiB.getDTMTBrands().setRowCount(0);
		ArrayList<Brands> arrayBrands = fLXML.returnBrand("Brands.xml", "Brand");

		for (Brands elemento : arrayBrands) {
			guiB.getDTMTBrands().addRow(new Object[] { elemento.getNameBrands() });
		}
	}

	private void initializerAction() {
		refreshData();
		guiB.getBtnRegisterBrand().addActionListener(this);
		guiB.getBtnConsultBrand().addActionListener(this);
		guiB.getBtnEditBrands().addActionListener(this);
		guiB.getBtnReadBrand().addActionListener(this);
		guiB.getBtnRemoveBrand().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == guiB.getBtnRegisterBrand()) {
			

	        boolean brandExists = fXML.dataExistOnXML("Brands.xml", "Brand", "nameBrands", guiB.getTAddBrand().getText());

	        if (brandExists) {
	            JOptionPane.showMessageDialog(null, "La marca ya existe en el sistema");
	            return;
	        }

	        brand = new Brands(guiB.getTAddBrand().getText());
	        fLXML.writeBrandsXML("Brands.xml", "Brand", brand.getDataName(), brand.getData());
	        arrayLB.addBrand(brand);
	        guiB.getDTMTBrands().addRow(new Object[]{guiB.getTAddBrand().getText()});
	        guiB.cleanForm();
	        refreshData();
	    }

		if (e.getSource() == guiB.getBtnEditBrands()) {

		}

		if (e.getSource() == guiB.getBtnRemoveBrand()) {
			
			//Falta crear el XML para eliminar
			
			if(brand != null) {
				arrayLB.removeBrand(brand);
				refreshData();
				JOptionPane.showMessageDialog(null, "La marca se eliminó correctamente.");
		    } else {
		    	JOptionPane.showMessageDialog(null, "La marca no se encontró o no pudo ser eliminado.");  
		    }
		}
		
		if(e.getSource() == guiB.getBtnConsultBrand()) {
			//No funciona aún
			Brands brand = fLXML.searchBrand("Brands.xml", "Brand", guiB.getTWriteBrand().getText());
			
			if(brand != null) {
				JOptionPane.showMessageDialog(null, "Marca encontrada");
				guiB.getTAddBrand().setText(brand.getNameBrands());
			}else {
				JOptionPane.showMessageDialog(null, "Marca NO encontrada");
			}
			
		}

	}

}
