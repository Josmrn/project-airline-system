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
	private ArrayListUsers arrayLU;

	public ControllerUserManage() {
		viewUM = new ViewUserManage();
		us = new Users();
		fXML = new FilesXML();
		arrayLU = new ArrayListUsers();
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		viewUM.getBtnRegister().addActionListener(this);
		viewUM.getBtnConsultUser().addActionListener(this);
		viewUM.getBtnEditUsers().addActionListener(this);
		viewUM.getBtnReadUsers().addActionListener(this);
		viewUM.getBtnRemoveUser().addActionListener(this);
		viewUM.getBtnUpdateUsers().addActionListener(this);
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
				        
				       
				        arrayLU.addUser(us);
					        
					        
				        viewUM.getDTMTUsers().addRow(new Object[] {viewUM.getTUserAdd().getText(),password,
									typeUser,statusUser});
				        
				        // Borrar el contenido del array de caracteres por motivos de seguridad
				        
				        Arrays.fill(passwordChars, ' ');
				        
				        //Se añade a la tabla
				        
				        
				        viewUM.cleanForm();
				        System.out.print(arrayLU.getArrayListUsers().size());
		}
		if(e.getSource() == viewUM.getBtnReadUsers()) {
						
		}
		if(e.getSource() == viewUM.getBtnEditUsers()) {
			
		}
		if(e.getSource() == viewUM.getBtnUpdateUsers()) {
			
			char[] passwordChars = viewUM.getJPassword().getPassword();
	        
	        // Se vonvierte el vector de caracteres en una cadena de texto
			String password = new String(passwordChars);
	        //---------------------------------------------------------------------
			
			String typeUser = (String) viewUM.getCXTypeUser().getSelectedItem();
			String statusUser = (String) viewUM.getCxState().getSelectedItem();
			
			viewUM.getDTMTUsers().setValueAt(viewUM.getTUserAdd().getText(),viewUM.getTUsers().getSelectedRow() , 0);
			viewUM.getDTMTUsers().setValueAt(password,viewUM.getTUsers().getSelectedRow() , 1);
			viewUM.getDTMTUsers().setValueAt(typeUser,viewUM.getTUsers().getSelectedRow() , 2);
			viewUM.getDTMTUsers().setValueAt(statusUser,viewUM.getTUsers().getSelectedRow() , 3);
			
		}
		if(e.getSource() == viewUM.getBtnRemoveUser()) {
			
			viewUM.getDTMTUsers().removeRow(viewUM.getTUsers().getSelectedRow());
			
			
		}
		if(e.getSource() == viewUM.getBtnConsultUser()) {
			
		}
		
	}

}
