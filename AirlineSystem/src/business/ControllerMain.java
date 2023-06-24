package business;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import presentation.GUIAirlines;
import presentation.GUIBrands;
import presentation.GUIFlights;
import presentation.GUIMain;
import presentation.GUIModel;
import presentation.GUIPlanes;

public class ControllerMain implements ActionListener{
	
	private GUIMain guiMain; 
	private Dimension desktopSize, FrameSize;
	private GUIPlanes guiPlanes;
	private GUIFlights guiF;

	public ControllerMain() {
		guiMain = new GUIMain();
		guiPlanes = new GUIPlanes();
		guiF = new GUIFlights();
		
		
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
			 new ControllerUserManage();
		}
		
		if(e.getSource() == guiMain.getMiAddBrand()) {
			new ControllerBrands(guiMain);
		}
		
		if(e.getSource() == guiMain.getMiEditModels()) {
			new ControllerModels(guiMain);
		}
		
		if(e.getSource() == guiMain.getMiManageAirline()) {
			System.out.println("MenuItem ManageAirline clicked!");
			new ControllerAirline(guiMain);
		}
		
		if(e.getSource() == guiMain.getMiManageAircraft()) {
			new ControllerAircraft(guiMain);
		}
		
		if(e.getSource() == guiMain.getMiManageFlight()) {
			new ControllerFlights(guiMain);
		}
		
		
	}
}
