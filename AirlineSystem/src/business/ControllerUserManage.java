package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import data.FilesLogicXML;
import domain.Users;
import presentation.GUIMain;
import presentation.GUIUserManage;


public class ControllerUserManage implements ActionListener {

	private GUIUserManage guiUM;
	private Users us;
	private FilesLogicXML fLXML;
	private ArrayListUsers arrayLU;
	
	private String UserType;

	public ControllerUserManage(GUIMain guiMain, String userType) {
		guiUM = new GUIUserManage(userType);
		guiMain.getDesktopMain().add(guiUM);
		us = new Users();
		UserType = userType;
		fLXML = new FilesLogicXML();
		arrayLU = new ArrayListUsers();
		initializerAction();
	}

	//Método para refrescar la tabla con los datos dentro del xml
	private void refreshData() {
		
		guiUM.getDTMTUsers().setRowCount(0);
		ArrayList<Users> arrayUsers = fLXML.returnUsers("Users.xml", "User");
		
		for(Users elemento : arrayUsers) {
			guiUM.getDTMTUsers().addRow(new Object[] { elemento.getUser(), elemento.getPassword(), elemento.getTypeUser(), elemento.getState()});
		}
	}

	private void initializerAction() {
		refreshData();
		guiUM.getBtnRegister().addActionListener(this);
		guiUM.getBtnConsultUser().addActionListener(this);
		guiUM.getBtnEditUsers(UserType).addActionListener(this);
		guiUM.getBtnRemoveUser(UserType).addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == guiUM.getBtnRegister()) {

		    // Verifica si el usuario ya existe en el XML
		    boolean userExists = fLXML.dataExistOnXML("Users.xml", "User", "user", guiUM.getTUserAdd().getText());
		    
		    if (userExists) {
		        JOptionPane.showMessageDialog(null, "El usuario ya existe en el sistema");
		        return;
		    }

		    char[] passwordChars = guiUM.getJPassword().getPassword();
		    String password = new String(passwordChars);
		    String typeUser = (String) guiUM.getCXTypeUser().getSelectedItem();
		    String statusUser = (String) guiUM.getCxState().getSelectedItem();

		    us = new Users(guiUM.getTUserAdd().getText(), password, typeUser, statusUser);

		    fLXML.writeLoginXML("Users.xml", "User", us.getDataName(), us.getData());

		    arrayLU.addUser(us);

		    guiUM.getDTMTUsers().addRow(new Object[]{guiUM.getTUserAdd().getText(), password, typeUser, statusUser});

		    Arrays.fill(passwordChars, ' ');

		    guiUM.cleanForm();
		}
		
		
		if (e.getSource() == guiUM.getBtnEditUsers(UserType)) {
			
		    // Obtiene los datos
		    String username = guiUM.getTUserAdd().getText();
		    char[] passwordChars = guiUM.getJPassword().getPassword();
		    String password = new String(passwordChars);
		    String typeUser = (String) guiUM.getCXTypeUser().getSelectedItem();
		    String statusUser = (String) guiUM.getCxState().getSelectedItem();

		    int selectedRow = guiUM.getTUsers().getSelectedRow();
		    int selectedColumn = guiUM.getTUsers().getSelectedColumn();

		    // Verifica si hay una fila seleccionada
		    if (selectedRow == -1) {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.");
		        return;
		    }
		    
		    if (selectedColumn != 0) {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione la columna del numero de ticket para editar.");
		        return;
		    }
		    
		    Object usernameOriginal = guiUM.getDTMTUsers().getValueAt(selectedRow, selectedColumn);
		    
		    guiUM.getDTMTUsers().setValueAt(username, selectedRow, 0);
		    guiUM.getDTMTUsers().setValueAt(password, selectedRow, 1);
		    guiUM.getDTMTUsers().setValueAt(typeUser, selectedRow, 2);
		    guiUM.getDTMTUsers().setValueAt(statusUser, selectedRow, 3);

		    fLXML.modifyUser("Users.xml", "User",usernameOriginal, username, password, typeUser, statusUser);
		}

		if (e.getSource() == guiUM.getBtnRemoveUser(UserType)) {
			
		    String username = guiUM.getTWriteName().getText();
		    
		    // Elimina el dato dentro del xml y refrescar en la tabla
		    Users us = fLXML.searchUserAndDelete("Users.xml", "User", username);

		    if (us != null) {
		        arrayLU.removePerson(us);
		        refreshData();
		        JOptionPane.showMessageDialog(null, "El usuario se eliminó correctamente.");
		    } else {
		    	JOptionPane.showMessageDialog(null, "El usuario no se encontró o no pudo ser eliminado.");  
		    }
		}
		
		if (e.getSource() == guiUM.getBtnConsultUser()) {
			 
		    Users user = fLXML.searchUsers("Users.xml", "User", guiUM.getTWriteName().getText());
		    
		    if (user != null) {
		    	JOptionPane.showMessageDialog(null, "Usuario encontrado");
		    	guiUM.getTUserAdd().setText(user.getUser());
		    	guiUM.getJPassword().setText(user.getPassword());
		    	guiUM.getCXTypeUser().setSelectedItem(user.getTypeUser());
		    	guiUM.getCxState().setSelectedItem(user.getState());
		   
		    } else {
		        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
		    }
		    
		}

	}

}
