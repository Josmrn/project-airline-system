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
		//guiL.getBtnRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == guiL.getBtnLogin()) {
			
			/*--------------------------------------------------------*/
			
			char[] passwordChars = guiL.getJPassword().getPassword();
			String password = new String(passwordChars);
			
			/*--------------------------------------------------------*/
						
			boolean loginUserAndPassword = fXML.userExistWithPasswordOnXML("Users.xml", "Users", "user", "password", guiL.getTUser().getText(), 
					password);
			//Vector que en la posicion 0 tendra el tipo de usuario y en la posicion 1 tendra el estado del usuario 
			String[] TypeAndStatus = fXML.returnTypeAndStatus("Users.xml", "Users", "user", "password", guiL.getTUser().getText(), 
					password);
			
			
			if(loginUserAndPassword==true) {
				
				System.out.println(TypeAndStatus[0]);
				System.out.println(TypeAndStatus[1]);
				
				if(TypeAndStatus[0].equals("Administrador") && TypeAndStatus[1].equals("Activo")) {
					
					new ControllerMain();
					guiL.dispose();
					
					
				}else if(TypeAndStatus[0].equals("Administrador") && TypeAndStatus[1].equals("Inactivo")) {
					
					JOptionPane.showMessageDialog(null, "El Usuario se encuentra inactivo");
					
				}
				if(TypeAndStatus[0].equals("Colaborador") && TypeAndStatus[1].equals("Activo")) {
					
					//Aqui deberia ir una ControllerMain sin la pestaña de Gestion de usuarios, porque es un Colaborador
					
					
				}else if(TypeAndStatus[0].equals("Colaborador") && TypeAndStatus[1].equals("Inactivo")) {
					
					JOptionPane.showMessageDialog(null, "El Usuario se encuentra inactivo");
					
				}
				
			}else {
				
	            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
	        }
			
			
				Arrays.fill(passwordChars, ' ');
	        
				guiL.cleanForm();
				
				
				
			
		}
		
		/*if(e.getSource() == guiL.getBtnRegister()) {
			new ControllerRegister();
			guiL.dispose();
		}*/
		
	}
	
}
