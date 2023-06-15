package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import domain.Users;
import presentation.GUIRegister;
import data.FilesXML;

public class ControllerRegister implements ActionListener{
	
	// Hay que arreglar el registro de usuario
	
	private GUIRegister guiR;
	//private GUIMain guiM;
	//private GUIUser guiU;
	private Users us;
	private FilesXML fXML;

	public ControllerRegister() {
		guiR = new GUIRegister();
		//guiM = new GUIMain();
		//guiU = new GUIUser();
		fXML = new FilesXML();
		us = new Users();
		
		initializerAction();
	}

	private void initializerAction() {
		
		//Comento el boton register, porque deberia ser eliminado
		guiR.getBtnNewRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Asi como este if, porque deberia ser eliminado el boton register
		if(e.getSource() == guiR.getBtnNewRegister()) {
			
			// PasswordField se pasa a un vector de tipo char
			char[] passwordChars = guiR.getJNewPassword().getPassword();
	        
	        // Se vonvierte el vector de caracteres en una cadena de texto
			String password = new String(passwordChars);
	        //---------------------------------------------------------------------
			
			String typeUser = (String) guiR.getCXTypeUser().getSelectedItem();
			String statusUser = (String) guiR.getCxState().getSelectedItem();
			
			
	        us = new Users(guiR.getTAddUser().getText(),password,
					typeUser,statusUser);
	        
	        fXML.writeXML("Users.xml", "Users", us.getDataName(), us.getData());
	        
	        // Borrar el contenido del array de caracteres por motivos de seguridad
	        
	        Arrays.fill(passwordChars, ' ');
	        
	        guiR.cleanForm();
			
		}
	}
}
