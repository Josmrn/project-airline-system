package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import data.FilesLoginXML;
import domain.Users;
import presentation.GUIMain;
import presentation.GUIUserManage;


public class ControllerUserManage implements ActionListener {

	private GUIUserManage guiUM;
	private Users us;
	private FilesLoginXML fLXML;
	private ArrayListUsers arrayLU;

	public ControllerUserManage(GUIMain guiMain) {
		guiUM = new GUIUserManage();
		guiMain.getDesktopMain().add(guiUM);
		us = new Users();
		fLXML = new FilesLoginXML();
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
		// TODO Auto-generated method stub
		refreshData();
		guiUM.getBtnRegister().addActionListener(this);
		guiUM.getBtnConsultUser().addActionListener(this);
		guiUM.getBtnEditUsers().addActionListener(this);
		guiUM.getBtnRemoveUser().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == guiUM.getBtnRegister()) {
			// PasswordField se pasa a un vector de tipo char
			char[] passwordChars = guiUM.getJPassword().getPassword();

			// Se vonvierte el vector de caracteres en una cadena de texto
			String password = new String(passwordChars);
			// ---------------------------------------------------------------------

			String typeUser = (String) guiUM.getCXTypeUser().getSelectedItem();
			String statusUser = (String) guiUM.getCxState().getSelectedItem();

			us = new Users(guiUM.getTUserAdd().getText(), password, typeUser, statusUser);

			fLXML.writeLoginXML("Users.xml", "User", us.getDataName(), us.getData());

			arrayLU.addUser(us);

			guiUM.getDTMTUsers().addRow(new Object[] { guiUM.getTUserAdd().getText(), password, typeUser, statusUser});

			// Borrar el contenido del array de caracteres por motivos de seguridad

			Arrays.fill(passwordChars, ' ');

			// Se añade a la tabla
			guiUM.cleanForm();
			System.out.print(arrayLU.getArrayListUsers().size());
			
		}
		
		if (e.getSource() == guiUM.getBtnEditUsers()) {
		    // Obtener los datos del formulario
		    String username = guiUM.getTUserAdd().getText();
		    char[] passwordChars = guiUM.getJPassword().getPassword();
		    String password = new String(passwordChars);
		    String typeUser = (String) guiUM.getCXTypeUser().getSelectedItem();
		    String statusUser = (String) guiUM.getCxState().getSelectedItem();

		    // Obtener el modelo de tabla y la fila seleccionada
		    DefaultTableModel model = (DefaultTableModel) guiUM.getTUsers().getModel();
		    int selectedRow = guiUM.getTUsers().getSelectedRow();

		    // Modificar los datos en la tabla
		    model.setValueAt(username, selectedRow, 0);
		    model.setValueAt(password, selectedRow, 1);
		    model.setValueAt(typeUser, selectedRow, 2);
		    model.setValueAt(statusUser, selectedRow, 3);

		    // Modificar el usuario en el archivo XML
		    fLXML.modifyUser("Users.xml", "User", username, password, typeUser, statusUser);
		}


		if (e.getSource() == guiUM.getBtnRemoveUser()) {
		    String username = guiUM.getTWriteName().getText();
		    
		    // Eliminar dato dentro del xml y refrescar en la tabla
		    Users us = fLXML.searchUserAndDelete("Users.xml", "User", username);

		    if (us != null) {
		        arrayLU.removePerson(us);
		        refreshData();
		        JOptionPane.showMessageDialog(null, "El usuario se eliminó correctamente.");
		    } else {
		        // Mostrar un mensaje de error o realizar alguna acción adecuada
		    	JOptionPane.showMessageDialog(null, "El usuario no se encontró o no pudo ser eliminado.");
		        
		    }
		}
		
		if (e.getSource() == guiUM.getBtnConsultUser()) {
		    String username = guiUM.getTWriteName().getText();
		    Users user = fLXML.searchUsers("Users.xml", "User", username);
		    
		    if (user != null) {
		        // El usuario fue encontrado, puedes mostrar los detalles en la interfaz o realizar cualquier acción adicional
		    	JOptionPane.showMessageDialog(null, "Usuario encontrado");
		    	guiUM.getTUserAdd().setText(user.getUser());
		    	guiUM.getJPassword().setText(user.getPassword());
		    	guiUM.getCXTypeUser().setSelectedItem(user.getTypeUser());
		    	guiUM.getCxState().setSelectedItem(user.getState());
		   
		    } else {
		        // El usuario no fue encontrado, puedes mostrar un mensaje de error o realizar cualquier acción adicional
		        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
		    }
		    
		}

	}

}
