package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import domain.Users;
import data.FilesXMLUserManag;
import presentation.GUIUserManage;

public class ControllerUsersManag implements ActionListener{
	
	private Users user;
	private FilesXMLUserManag fXML;
	private ArrayListUsers arrayLU;
	private GUIUserManage guiUM;
	
	public ControllerUsersManag() {
		user = new Users();
		fXML = new FilesXMLUserManag();
		arrayLU = new ArrayListUsers();
		guiUM = new GUIUserManage();
		
		
		initializerAction();
		
	}
	
	private void initializerAction() {
		
		guiUM.getBtnConsultUser().addActionListener(this);
		guiUM.getBtnEditUsers().addActionListener(this);
		guiUM.getBtnReadUsers().addActionListener(this);
		guiUM.getBtnRemoveUser().addActionListener(this);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiUM.getBtnReadUsers()) {
			
			
			
			
		}
		if(e.getSource() == guiUM.getBtnConsultUser()) {
			
			
			
		}
		if(e.getSource() == guiUM.getBtnEditUsers()) {
			
			
			
		}
		if(e.getSource() == guiUM.getBtnRemoveUser()) {
			
			
			
		}
	
	}
	
	
	
}
