package business;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUIBrands;
import presentation.GUIMain;
import presentation.GUIModel;
import presentation.ViewUserManage;

public class ControllerMain implements ActionListener{
	
	private GUIMain guiMain; 
	private GUIBrands guiB;
	private GUIModel guiM;
	private Dimension desktopSize, FrameSize;
	private ViewUserManage viewUM;

	public ControllerMain() {
		guiMain = new GUIMain();
		guiB = new GUIBrands();
		guiM = new GUIModel();
		
		initializerAction();
	}

	private void initializerAction() {
		guiMain.getMiAddBrand().addActionListener(this);
		guiMain.getMiEditModels().addActionListener(this);
		guiMain.getMiUsersManag().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Gestion de Usuarios
		if(e.getSource() == guiMain.getMiUsersManag()) {
			 System.out.println("MenuItem UsersManag clicked!");
			 new ControllerUserManage();
		}
		
		if(e.getSource() == guiMain.getMiAddBrand()) {
			desktopSize = guiMain.getDesktopMain().getSize();
			FrameSize = guiB.getSize();
			guiB.setLocation((desktopSize.width-FrameSize.width)/2, (desktopSize.height-FrameSize.height)/2);
			guiMain.getDesktopMain().add(guiB);
			guiB.setVisible(true);
		}
		
		if(e.getSource() == guiMain.getMiEditModels()) {
			desktopSize = guiMain.getDesktopMain().getSize();
			FrameSize = guiM.getSize();
			guiM.setLocation((desktopSize.width-FrameSize.width)/2, (desktopSize.height-FrameSize.height)/2);
			guiMain.getDesktopMain().add(guiM);
			guiM.setVisible(true);
		}
		
		
	}
}
