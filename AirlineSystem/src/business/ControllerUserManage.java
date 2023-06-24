package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import data.FilesXML;
import domain.Users;
import presentation.ViewUserManage;

public class ControllerUserManage implements ActionListener {

	private ViewUserManage viewUM;
	private Users us;
	private FilesXML fXML;
	private ArrayListUsers arrayLU;

	public ControllerUserManage() {
		viewUM = new ViewUserManage();
		us = new Users();
		fXML = new FilesXML();
		arrayLU = new ArrayListUsers();
		initializerAction();
	}

	//Método para refrescar la tabla con los datos dentro del xml
	private void refreshData() {
		
		viewUM.getDTMTUsers().setRowCount(0);
		ArrayList<Users> arrayUsers = fXML.returnUsers("Users.xml", "User");
		
		for(Users elemento : arrayUsers) {
			viewUM.getDTMTUsers().addRow(new Object[] { elemento.getUser(), elemento.getPassword(), elemento.getTypeUser(), elemento.getState()});
		}
		
	}
	
	private void initializerAction() {
		// TODO Auto-generated method stub
		refreshData();
		viewUM.getBtnRegister().addActionListener(this);
		viewUM.getBtnConsultUser().addActionListener(this);
		viewUM.getBtnEditUsers().addActionListener(this);
		viewUM.getBtnReadUsers().addActionListener(this);
		viewUM.getBtnRemoveUser().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewUM.getBtnRegister()) {
			// PasswordField se pasa a un vector de tipo char
			char[] passwordChars = viewUM.getJPassword().getPassword();

			// Se vonvierte el vector de caracteres en una cadena de texto
			String password = new String(passwordChars);
			// ---------------------------------------------------------------------

			String typeUser = (String) viewUM.getCXTypeUser().getSelectedItem();
			String statusUser = (String) viewUM.getCxState().getSelectedItem();

			us = new Users(viewUM.getTUserAdd().getText(), password, typeUser, statusUser);

			fXML.writeLoginXML("Users.xml", "User", us.getDataName(), us.getData());

			arrayLU.addUser(us);

			viewUM.getDTMTUsers().addRow(new Object[] { viewUM.getTUserAdd().getText(), password, typeUser, statusUser});

			// Borrar el contenido del array de caracteres por motivos de seguridad

			Arrays.fill(passwordChars, ' ');

			// Se añade a la tabla
			viewUM.cleanForm();
			System.out.print(arrayLU.getArrayListUsers().size());
		}
		if (e.getSource() == viewUM.getBtnReadUsers()) {
			//Botón para leer los datos del usuario que están dentro del archivo xml
		}
		if (e.getSource() == viewUM.getBtnEditUsers()) {
			//Botón de editar usuarios que están dentro del xml
			//Se tiene que actualizar los datos dentro del xml y refrescar en la tabla

			char[] passwordChars = viewUM.getJPassword().getPassword();

			// Se vonvierte el vector de caracteres en una cadena de texto
			String password = new String(passwordChars);
			// ---------------------------------------------------------------------

			String typeUser = (String) viewUM.getCXTypeUser().getSelectedItem();
			String statusUser = (String) viewUM.getCxState().getSelectedItem();

			viewUM.getDTMTUsers().setValueAt(viewUM.getTUserAdd().getText(), viewUM.getTUsers().getSelectedRow(), 0);
			viewUM.getDTMTUsers().setValueAt(password, viewUM.getTUsers().getSelectedRow(), 1);
			viewUM.getDTMTUsers().setValueAt(typeUser, viewUM.getTUsers().getSelectedRow(), 2);
			viewUM.getDTMTUsers().setValueAt(statusUser, viewUM.getTUsers().getSelectedRow(), 3);

		}

		if (e.getSource() == viewUM.getBtnRemoveUser()) {
			//Eliminar dato dentro del xml y refrescar en la tabla
			viewUM.getDTMTUsers().removeRow(viewUM.getTUsers().getSelectedRow());//este no

		}
		if (e.getSource() == viewUM.getBtnConsultUser()) {
			//Buscar dentro del xml y mostrar en los espacios correspondientes
			us = fXML.searchUsers("Users.xml", "user", viewUM.getTWriteName().getText());
			viewUM.getTUserAdd().setText(us.getUser());
			viewUM.getJPassword().setText(us.getPassword());
			viewUM.getCXTypeUser().setSelectedItem(us.getTypeUser());
			viewUM.getCxState().setSelectedItem(us.getState());
			
		}

	}

}
