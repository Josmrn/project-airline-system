package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import presentation.GUILogin;
import data.FilesXML;
import domain.Users;

public class ControllerLogin implements ActionListener{

	private GUILogin guiL;
	private FilesXML fXML;
	private Users userAdmin;
	
	public ControllerLogin() {
		
		guiL = new GUILogin();
		fXML = new FilesXML();
		userAdmin = new Users("admin","admin","Administrador","Activo");
		
		fXML.createXML("Users", "Users.xml");
		fXML.writeXML("Users.xml", "Users", userAdmin.getDataName(), userAdmin.getData());
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		guiL.getBtnLogin().addActionListener(this);
		guiL.getBtnRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == guiL.getBtnLogin()) {
			
			char[] passwordChars = guiL.getJPassword().getPassword();
			String password = new String(passwordChars);
			
			boolean loginSuccess = fXML.userExistWithPasswordOnXML("Users.xml", "Users", "user", "password", guiL.getTUser().getText(), 
					password);
			
			
			if(loginSuccess) {
				
				JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
				
			}else {
				
	            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
	        }
			
			
				Arrays.fill(passwordChars, ' ');
	        
				guiL.cleanForm();
				
				new ControllerMain();
				guiL.dispose();
			
		}
		
		if(e.getSource() == guiL.getBtnRegister()) {
			new ControllerRegister();
			guiL.dispose();
		}
		
	}
	
}
