package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

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
		guiUM.getBtnUpdateUsers().addActionListener(this);
		guiUM.getBtnRegister().addActionListener(this);
		
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
			
			guiUM.getDTMTUsers().removeRow(guiUM.getTUsers().getSelectedRow());
			arrayLU.removeUser(guiUM.getTUsers().getSelectedRow());
			
		}
		if(e.getSource() == guiUM.getBtnUpdateUsers()) {
			
			//ArrayList<Users> usersList= arrayLU.getArrayListUsers();
			
			guiUM.getTUsers().getSelectedRow();
			guiUM.getDTMTUsers().setValueAt(guiUM.getTUser(), guiUM.getTUsers().getSelectedRow(), 0);
			
			
		}
		
		if(e.getSource() == guiUM.getBtnRegister()) {
			
			// PasswordField se pasa a un vector de tipo char
			char[] passwordChars = guiUM.getJNewPassword().getPassword();
	        
	        // Se vonvierte el vector de caracteres en una cadena de texto
			String password = new String(passwordChars);
	        //---------------------------------------------------------------------
			
			String typeUser = (String) guiUM.getCXTypeUser().getSelectedItem();
			String statusUser = (String) guiUM.getCxState().getSelectedItem();
			
			System.out.println(typeUser);
			System.out.println(statusUser);

			
	        user = new Users(guiUM.getTUser().getText(),password,
					typeUser,statusUser);
	        
	        fXML.writeXML("Users.xml", "Users", user.getDataName(), user.getData());
	        
	        arrayLU.addUser(user);
	        // Borrar el contenido del array de caracteres por motivos de seguridad
	        
	        Arrays.fill(passwordChars, ' ');
	        
	        guiUM.cleanForm();
	        
	        guiUM.getDTMTUsers().addRow(arrayLU.getDataMatrixUsers());
			
		}
		
	
	}
	
	
	
}
