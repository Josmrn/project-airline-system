package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentation.GUIBrands;
import presentation.GUIMain;
import domain.Brands;
import data.FilesXML;

public class ControllerBrands implements ActionListener {
	
	private GUIBrands guiB;
	private Brands brand;
	private FilesXML fXML;

	public ControllerBrands(GUIMain guiMain) {
		guiB = new GUIBrands();
		guiMain.getDesktopMain().add(guiB);
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
			
			System.out.println("Click en registro de marca");
		}
		
		if(e.getSource() == guiB.getBtnEditBrands()) {
			
		}
		
		if(e.getSource() == guiB.getBtnRemoveBrand()) {
			
		}
		
	}

	
}
