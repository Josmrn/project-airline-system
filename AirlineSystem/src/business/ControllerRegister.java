package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

 //import javax.swing.JPasswordField;

import domain.Users;
import presentation.GUIUser;
import data.FilesXML;

public class ControllerRegister implements ActionListener{
	
	private GUIUser guiU;
	private Users us;
	private FilesXML fXML;

	public ControllerRegister() {
		// TODO Auto-generated constructor stub
		guiU = new GUIUser();
		fXML = new FilesXML();
		us = new Users();
		
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiU.getBtnNewRegister().addActionListener(this);
		guiU.getBtnReturn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guiU.getBtnNewRegister()) {
			
			//PasswordField se pasa a un vector de tipo char
	        
			char[] passwordChars = guiU.getPwdIngresarContrasea().getPassword();
	        
	        // Se vonvierte el vector de caracteres en una cadena de texto
	        
			String password = new String(passwordChars);
	        ////////////////////////////////////////////////
			
			String typeUser = (String) guiU.getCXTypeUser().getSelectedItem();
			String statusUser = (String) guiU.getComboBox().getSelectedItem();
			
			
	        us = new Users(guiU.getTxtCrearNuevoUsuario().getText(),password,
					typeUser,statusUser);
	        
	        fXML.writeXML("Users.xml", "Users", us.getDataName(), us.getData());
	        
	        // Borrar el contenido del array de caracteres por motivos de seguridad
	        
	        Arrays.fill(passwordChars, ' ');
	        
	        guiU.cleanForm();
			
		}
		
		if(e.getSource() == guiU.getBtnReturn()) {
			
			
			new ControllerLogin();
			guiU.dispose();
			
			
		}
	}

}
