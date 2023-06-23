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
	private Users users;
	private ArrayListUsers arrayLU;
	
	
	public ControllerLogin() {
		guiL = new GUILogin();
		fXML = new FilesXML();
		
		users = new Users("admin","admin","Administrador","Activo");
		arrayLU = new ArrayListUsers();
		
		fXML.createXML("Users", "Users.xml");
		fXML.writeLoginXML("Users.xml", "User", users.getDataName(), users.getData());
		
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
						
			boolean loginUserAndPassword = fXML.userExistWithPasswordOnXML("Users.xml", "User", "user", "password", guiL.getTUser().getText(), password);
			
			System.out.println(loginUserAndPassword);
			
			//Vector que en la posicion 0 tendra el tipo de usuario y en la posicion 1 tendra el estado del usuario 
			
			String[] TypeAndStatus = fXML.returnTypeAndStatus("Users.xml", "User", "user", "password", guiL.getTUser().getText(), password);
			
			System.out.println("Hola Login");
			
			if(loginUserAndPassword == true) {
				
				System.out.println(TypeAndStatus[0]);
				System.out.println(TypeAndStatus[1]);
				
				if(TypeAndStatus[0].equals("Administrador") && TypeAndStatus[1].equals("Activo")) {
					
					System.out.println("Entre en el If admin acti");
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
		
		/*if(e.getSource() == guiL.getBtnRegister()) {
			new ControllerRegister();
			guiL.dispose();
		}*/
		
	}
	
}
