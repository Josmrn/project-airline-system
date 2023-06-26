package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.Tickets;
import data.FilesXML;
import data.FilesLogicXML;
import presentation.GUITickets;
import presentation.GUIMain;

public class ControllerTickets implements ActionListener {

	private Tickets ticket;
	private GUITickets guiT;
	private FilesXML fXML;
	private FilesLogicXML fLogXML;
	private ArrayListTickets arrayLTickets;
	

	public ControllerTickets(GUIMain guiMain) {
		// TODO Auto-generated constructor stub
		ticket = new Tickets();
		guiT = new GUITickets();
		guiMain.getDesktopMain().add(guiT);
		fXML = new FilesXML();
		fLogXML = new FilesLogicXML();
		arrayLTickets = new ArrayListTickets();
		
		fXML.createXML("Tickets", "Tickets.xml");
		
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		refreshData();
		guiT.getBtnAddTickets().addActionListener(this);
		guiT.getBtnEditTickets().addActionListener(this);
		guiT.getBtnRemoveTickets().addActionListener(this);
		guiT.getBtnConsultTickets().addActionListener(this);
	}
	
	// Método para refrescar la tabla con los datos dentro del xml
		private void refreshData() {

			guiT.getDTMTTickets().setRowCount(0);
			ArrayList<Tickets> arrayTickets = fLogXML.returnTickets("Tickets.xml", "Ticket");

			for (Tickets elemento : arrayTickets) {
				guiT.getDTMTTickets().addRow( new Object[] { elemento.getTicketNum(), elemento.getPassportNum(),
						elemento.getFlightNum() });
			}
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//Se debe validar para cada tiquete la disponibilidad de espacio y clase
		if (e.getSource() == guiT.getBtnAddTickets()) {
			
			ticket = new Tickets(Integer.parseInt(guiT.getTTicketNumber().getText()),
					Integer.parseInt(guiT.getTPassportNumber().getText()),
					Integer.parseInt(guiT.getTFlightNumber().getText()));

			fLogXML.writeTicketXML("Tickets.xml", "Ticket", ticket.getDataName(), ticket.getData());

			arrayLTickets.addTicket(ticket);

			guiT.getDTMTTickets()
					.addRow(new Object[] { guiT.getTTicketNumber().getText(),guiT.getTPassportNumber().getText(),
							guiT.getTFlightNumber().getText()});

			System.out.print(arrayLTickets.getArrayListTickets().size());
			
		}

		if (e.getSource() == guiT.getBtnEditTickets()) {
			
			// Obtiene los datos del formulario
			int ticketNum = Integer.parseInt(guiT.getTTicketNumber().getText());
			int passportNum = Integer.parseInt(guiT.getTPassportNumber().getText());
			int flightNum = Integer.parseInt(guiT.getTFlightNumber().getText());

			int selectedRow = guiT.getTTickets().getSelectedRow();
			int selectedColumn = guiT.getTTickets().getSelectedColumn();
			
			// Verifica si hay una fila seleccionada
		    if (selectedRow == -1) {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.");
		        return;
		    }
		    // Verifica si hay una columna de ticket seleccionada
		    if (selectedColumn == -1) {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione la columna del numero del ticket para editar.");
		        return;
		    }
		    
		    Object ticketNumOriginal = guiT.getDTMTTickets().getValueAt(selectedRow, selectedColumn);
		    
		    // Modifica el pasajero en el archivo XML
		    fLogXML.modifyTicket("Tickets.xml", "Ticket",ticketNumOriginal, ticketNum, passportNum, flightNum);
		    
			// Modifica los datos en la tabla
			guiT.getDTMTTickets().setValueAt(ticketNum, selectedRow, 0);
			guiT.getDTMTTickets().setValueAt(passportNum, selectedRow, 1);
			guiT.getDTMTTickets().setValueAt(flightNum, selectedRow, 2);

			
			
		}

		if (e.getSource() == guiT.getBtnRemoveTickets()) {
			
			int ticketNum = Integer.parseInt(guiT.getTSearchTickets().getText());

			// Elimina el dato dentro del xml y refrescar en la tabla
			Tickets t = fLogXML.searchTicketAndDelete("Tickets.xml", "Ticket", ticketNum);

			if (t != null) {
				arrayLTickets.removeTicket(t);
				refreshData();
				JOptionPane.showMessageDialog(null, "El ticket se eliminó correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "El ticket no se encontró o no pudo ser eliminado.");
			}
			
		}
		if (e.getSource() == guiT.getBtnConsultTickets()) {
			
			int ticketNum = Integer.parseInt(guiT.getTSearchTickets().getText());
			Tickets ticket = fLogXML.searchTicket("Tickets.xml", "Ticket", ticketNum);

			if (ticket != null) {
				// El usuario fue encontrado, puedes mostrar los detalles en la interfaz o
				// realizar cualquier acción adicional
				JOptionPane.showMessageDialog(null, "Ticket encontrado");
				guiT.getTTicketNumber().setText(String.valueOf(ticket.getTicketNum()));
				guiT.getTPassportNumber().setText(String.valueOf(ticket.getPassportNum()));
				guiT.getTFlightNumber().setText(String.valueOf(ticket.getFlightNum()));
				

			} else {
				// El usuario no fue encontrado, puedes mostrar un mensaje de error o realizar
				// cualquier acción adicional
				JOptionPane.showMessageDialog(null, "Ticket no encontrado");
			}
			
			
		}
	}

}