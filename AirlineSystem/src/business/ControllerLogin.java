package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import presentation.GUILogin;
import data.FilesLoginXML;
import data.FilesXML;
import domain.Users;

public class ControllerLogin implements ActionListener{

	private GUILogin guiL;
	private FilesXML fXML;
	private FilesLoginXML fLXML;
	private Users users;
	private ArrayListUsers arrayLU;
	
	
	public ControllerLogin() {
		guiL = new GUILogin();
		fXML = new FilesXML();
		fLXML = new FilesLoginXML();
		users = new Users("admin","admin","Administrador","Activo");
		arrayLU = new ArrayListUsers();
		
		fXML.createXML("User", "Users.xml");
		fLXML.writeLoginXML("Users.xml", "User", users.getDataName(), users.getData());
		
		arrayLU.addUser(users);
		
		
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
						
			boolean loginUserAndPassword = fLXML.userExistWithPasswordOnXML("Users.xml", "User",guiL.getTUser().getText(), password);
			
			System.out.println(loginUserAndPassword);
			
			//Vector que en la posicion 0 tendra el tipo de usuario y en la posicion 1 tendra el estado del usuario 
			
			String[] TypeAndStatus = fLXML.returnTypeAndStatus("Users.xml", "User",guiL.getTUser().getText(), password);

			
			if(loginUserAndPassword == true) {
				
				System.out.println(TypeAndStatus[0]);
				System.out.println(TypeAndStatus[1]);
				
				if(TypeAndStatus[0].equals("Administrador") && TypeAndStatus[1].equals("Activo")) {
					new ControllerMain();
					guiL.dispose();
					
					
				}else if(TypeAndStatus[0].equals("Administrador") && TypeAndStatus[1].equals("Inactivo")) {
					
					JOptionPane.showMessageDialog(null, "El Usuario se encuentra inactivo");
					
				}
				if(TypeAndStatus[0].equals("Colaborador") && TypeAndStatus[1].equals("Activo")) {
					
					System.out.println("Entre en el If colab acti");
					new ControllerMain2();
					guiL.dispose();
					
				}else if(TypeAndStatus[0].equals("Colaborador") && TypeAndStatus[1].equals("Inactivo")) {
					
					JOptionPane.showMessageDialog(null, "El Usuario se encuentra inactivo");
					
				}
				
			}else {
				
	            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
	        }
			
			
				Arrays.fill(passwordChars, ' ');
	        
				guiL.cleanForm();
					
			
				
		}
		
		
	}
	
}
