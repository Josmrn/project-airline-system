package business;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import presentation.GUIMain;


public class ControllerMain implements ActionListener{
	
	private GUIMain guiMain; 
	//private Dimension desktopSize, FrameSize;
	private String userType;

	public ControllerMain(String typeUser) {
		guiMain = new GUIMain(typeUser);
		userType = typeUser; 
		initializerAction();
	}
	
	public void centerScreen(JInternalFrame cWindows) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension file = cWindows.getSize();
		
		int posX = (int) (screen.getWidth() - file.getWidth()) / 2;
		int posY = (int) (screen.getHeight() - file.getHeight()) / 2;
		cWindows.setLocation(posX, posY-100);
	}

	private void initializerAction() {
		guiMain.getMiAddBrand().addActionListener(this);
		guiMain.getMiEditModels().addActionListener(this);
		guiMain.getMiUsersManag().addActionListener(this);
		guiMain.getMiManageAirline().addActionListener(this);
		guiMain.getMiManageAircraft().addActionListener(this);
		guiMain.getMiManageFlight().addActionListener(this);
		guiMain.getMiManagePassenger().addActionListener(this);
		guiMain.getMiManageTickets().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Gestion de Usuarios
		if(e.getSource() == guiMain.getMiUsersManag()) {
			 System.out.println("MenuItem UsersManag clicked!");
			 new ControllerUserManage(guiMain);
		}
		
		if(e.getSource() == guiMain.getMiAddBrand()) {
			new ControllerBrands(guiMain,userType);
		}
		
		if(e.getSource() == guiMain.getMiEditModels()) {
			new ControllerModels(guiMain,userType);
		}
		
		if(e.getSource() == guiMain.getMiManageAirline()) {
			System.out.println("MenuItem ManageAirline clicked!");
			new ControllerAirlines(guiMain,userType);
		}
		
		if(e.getSource() == guiMain.getMiManageAircraft()) {
			new ControllerPlanes(guiMain,userType);
		}
		
		if(e.getSource() == guiMain.getMiManageFlight()) {
			new ControllerFlights(guiMain,userType);
		}
		if(e.getSource() == guiMain.getMiManagePassenger()) {
			new ControllerPassengers(guiMain,userType);
		}
		if(e.getSource() == guiMain.getMiManageTickets()) {
			new ControllerTickets(guiMain,userType);
		}
		
		
	}
}
