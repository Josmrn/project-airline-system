package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import data.FilesXML;
import domain.Users;
import presentation.ViewUserManage;

public class ControllerUserManage implements ActionListener{
	
	private ViewUserManage viewUM;
	private Users us;
	private FilesXML fXML;

	public ControllerUserManage() {
		viewUM = new ViewUserManage();
		us = new Users();
		fXML = new FilesXML();
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		viewUM.getBtnRegister().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewUM.getBtnRegister()) {
			// PasswordField se pasa a un vector de tipo char
						char[] passwordChars = viewUM.getJPassword().getPassword();
				        
				        // Se vonvierte el vector de caracteres en una cadena de texto
						String password = new String(passwordChars);
				        //---------------------------------------------------------------------
						
						String typeUser = (String) viewUM.getCXTypeUser().getSelectedItem();
						String statusUser = (String) viewUM.getCxState().getSelectedItem();
						
						
				        us = new Users(viewUM.getTUserAdd().getText(),password,
								typeUser,statusUser);
				        
				        fXML.writeXML("Users.xml", "Users", us.getDataName(), us.getData());
				        
				        // Borrar el contenido del array de caracteres por motivos de seguridad
				        
				        Arrays.fill(passwordChars, ' ');
				        
				        viewUM.cleanForm();
		}
		
	}

}
