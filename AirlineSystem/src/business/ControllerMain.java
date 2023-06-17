package business;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.GUIBrands;
import presentation.GUIMain;
import presentation.GUIModel;
import presentation.GUIRegister;
import presentation.GUIUserManage;

public class ControllerMain implements ActionListener{
	
	private GUIMain guiMain; 
	private GUIRegister guiR;
	private GUIBrands guiB;
	private GUIModel guiM;
	private GUIUserManage guiUM;
	private Dimension desktopSize, FrameSize;

	public ControllerMain() {
		guiMain = new GUIMain();
		guiR = new GUIRegister();
		guiB = new GUIBrands();
		guiM = new GUIModel();
		guiUM = new GUIUserManage();
		initializerAction();
	}

	private void initializerAction() {
		guiMain.getMiCreateUser().addActionListener(this);
		guiMain.getMiAddBrand().addActionListener(this);
		guiMain.getMiEditModels().addActionListener(this);
		guiMain.getMiUsersManag().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Crear Usuario
		if(e.getSource() == guiMain.getMiCreateUser()) {
			
			 desktopSize = guiMain.getDesktopMain().getSize();
			 FrameSize = guiR.getSize();
			 guiR.setLocation((desktopSize.width-FrameSize.width)/2, (desktopSize.height-FrameSize.height)/2);
			 guiMain.getDesktopMain().add(guiR);
			 guiR.setVisible(true);
		}
		//Gestion de Usuarios
		if(e.getSource() == guiMain.getMiUsersManag()) {
			 System.out.println("MenuItem UsersManag clicked!");
			 desktopSize = guiMain.getDesktopMain().getSize();
				FrameSize = guiUM.getSize();
				guiUM.setLocation((desktopSize.width-FrameSize.width)/2, (desktopSize.height-FrameSize.height)/2);
				guiMain.getDesktopMain().add(guiUM);
				guiUM.setVisible(true);
			
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
