package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import presentation.GUIBrands;
import presentation.GUIMain;
import domain.Brands;
import data.FilesBrandsXML;
import data.FilesLogicXML;
import data.FilesXML;

public class ControllerBrands implements ActionListener {

	private GUIBrands guiB;
	private FilesXML fXML;
	private Brands brand;
	private FilesBrandsXML fBXML;
	private FilesLogicXML fLXML;
	private ArrayListBrands arrayLB;
	
	private String userType;

	public ControllerBrands(GUIMain guiMain, String userType) {
        guiB = new GUIBrands(userType);
        guiMain.getDesktopMain().add(guiB);
        brand = new Brands();
        fXML = new FilesXML();
        fBXML = new FilesBrandsXML();
        fLXML = new FilesLogicXML();
        arrayLB = new ArrayListBrands();
        this.userType = userType;
        fXML.createXML("Brands", "Brands.xml");
        initializerAction();
    }

	private void refreshData() {
		guiB.getDTMTBrands().setRowCount(0);
		ArrayList<Brands> arrayBrands = fBXML.returnBrand("Brands.xml", "Brand");

		for (Brands elemento : arrayBrands) {
			guiB.getDTMTBrands().addRow(new Object[] { elemento.getNameBrands() });
		}
	}

	private void initializerAction() {
		refreshData();
		guiB.getBtnRegisterBrand().addActionListener(this);
		guiB.getBtnConsultBrand().addActionListener(this);
		guiB.getBtnEditBrands(userType).addActionListener(this);
		guiB.getBtnRemoveBrand(userType).addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == guiB.getBtnRegisterBrand()) {
			

	        boolean brandExists = fLXML.dataExistOnXML("Brands.xml", "Brand", "nameBrands", guiB.getTAddBrand().getText());

	        if (brandExists) {
	            JOptionPane.showMessageDialog(null, "La marca ya existe en el sistema");
	            return;
	        }

	        brand = new Brands(guiB.getTAddBrand().getText());
	        fBXML.writeBrandsXML("Brands.xml", "Brand", brand.getDataName(), brand.getData());
	        arrayLB.addBrand(brand);
	        guiB.getDTMTBrands().addRow(new Object[]{guiB.getTAddBrand().getText()});
	        guiB.cleanForm();
	        refreshData();
	    }

		if (e.getSource() == guiB.getBtnEditBrands(userType)) {
		    String currentBrandName = guiB.getTWriteBrand().getText();
		    String newBrandName = guiB.getTAddBrand().getText();

		    fBXML.modifyBrand("Brands.xml", "Brand", currentBrandName, newBrandName);

		    JOptionPane.showMessageDialog(null, "Marca modificada exitosamente");
		    refreshData();
		}

		if (e.getSource() == guiB.getBtnRemoveBrand(userType)) {
		    String brandName = guiB.getTWriteBrand().getText();
		    Brands brand = fBXML.deleteBrand("Brands.xml", "Brand", brandName);
		    
		    if (brand != null) {
		        arrayLB.removeBrand(brand);
		        refreshData();
		        JOptionPane.showMessageDialog(null, "La marca se eliminó correctamente.");
		    } else {
		        JOptionPane.showMessageDialog(null, "La marca no se encontró o no pudo ser eliminada.");
		    }
		}



		
		if (e.getSource() == guiB.getBtnConsultBrand()) {
			
		    String brandName = guiB.getTWriteBrand().getText();

		    Brands brand = fBXML.searchBrand("Brands.xml", "Brand", brandName);

		    if (brand != null) {
		        JOptionPane.showMessageDialog(null, "Marca encontrada");
		        guiB.getTAddBrand().setText(brand.getNameBrands());
		    } else {
		        JOptionPane.showMessageDialog(null, "Marca NO encontrada");
		    }
			
		}

	}

}
