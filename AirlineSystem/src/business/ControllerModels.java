package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUIMain;
import presentation.GUIModel;

public class ControllerModels implements ActionListener{

	private GUIModel guiM;
	
	public ControllerModels(GUIMain guiMain) {
		guiM = new GUIModel();
		guiMain.getDesktopMain().add(guiM);
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiM.getBtnAddModels().addActionListener(this);
		guiM.getBtnEditModels().addActionListener(this);
		guiM.getBtnRemoveModels().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiM.getBtnAddModels()) {
			System.out.println("Ingresó a la condición del botón agregar");
		}
		
		if(e.getSource() == guiM.getBtnEditModels()) {
			
		}
		
		if(e.getSource() == guiM.getBtnRemoveModels()) {
			
		}
		
	}
}
