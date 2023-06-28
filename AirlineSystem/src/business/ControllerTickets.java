package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import domain.Tickets;
import data.FilesXML;
import data.FilesTicketsXML;
import presentation.GUITickets;
import presentation.GUIMain;

public class ControllerTickets implements ActionListener {

	private Tickets ticket;
	private GUITickets guiT;
	private FilesXML fXML;
	private FilesTicketsXML fTXML;
	private ArrayListTickets arrayLTickets;
	
	private String UserType;

	public ControllerTickets(GUIMain guiMain,String userType) {
		// TODO Auto-generated constructor stub
		ticket = new Tickets();
		guiT = new GUITickets(userType);
		guiMain.getDesktopMain().add(guiT);
		fXML = new FilesXML();
		fTXML = new FilesTicketsXML();
		arrayLTickets = new ArrayListTickets();
		UserType = userType;
		
		fXML.createXML("Tickets", "Tickets.xml");
		
		initializerAction();
	}

	private void initializerAction() {
		// TODO Auto-generated method stub
		refreshData();
		guiT.getBtnAddTickets().addActionListener(this);
		guiT.getBtnEditTickets(UserType).addActionListener(this);
		guiT.getBtnRemoveTickets(UserType).addActionListener(this);
		guiT.getBtnConsultTickets().addActionListener(this);
	}
	
	// Método para refrescar la tabla con los datos dentro del xml
		private void refreshData() {

			guiT.getDTMTTickets().setRowCount(0);
			ArrayList<Tickets> arrayTickets = fTXML.returnTickets("Tickets.xml", "Ticket");

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
		    int ticketNumber = Integer.parseInt(guiT.getTTicketNumber().getText());
		    int passportNumber = Integer.parseInt(guiT.getTPassportNumber().getText());
		    int flightNumber = Integer.parseInt(guiT.getTFlightNumber().getText());

		    if (arrayLTickets.ticketExists(ticketNumber)) {
		        JOptionPane.showMessageDialog(null, "El ticket ya existe");
		    } else {
		        ticket = new Tickets(ticketNumber, passportNumber, flightNumber);

		        fTXML.writeTicketXML("Tickets.xml", "Ticket", ticket.getDataName(), ticket.getData());

		        arrayLTickets.addTicket(ticket);

		        guiT.getDTMTTickets().addRow(new Object[] { String.valueOf(ticketNumber), String.valueOf(passportNumber), String.valueOf(flightNumber) });

		        System.out.print(arrayLTickets.getArrayListTickets().size());
		    }
		}


		if (e.getSource() == guiT.getBtnEditTickets(UserType)) {
		
			int ticketNum = Integer.parseInt(guiT.getTTicketNumber().getText());
			int passportNum = Integer.parseInt(guiT.getTPassportNumber().getText());
			int flightNum = Integer.parseInt(guiT.getTFlightNumber().getText());

			int selectedRow = guiT.getTTickets().getSelectedRow();
			int selectedColumn = guiT.getTTickets().getSelectedColumn();
			
			
		    if (selectedRow == -1) {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.");
		        return;
		    }
		    
		    if (selectedColumn != 0) {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione la columna del numero de ticket para editar.");
		        return;
		    }
		    
		    
		    Object ticketNumOriginal = guiT.getDTMTTickets().getValueAt(selectedRow, selectedColumn);
		    
		    
		    fTXML.modifyTicket("Tickets.xml", "Ticket",ticketNumOriginal, ticketNum, passportNum, flightNum);
		    
			
			guiT.getDTMTTickets().setValueAt(ticketNum, selectedRow, 0);
			guiT.getDTMTTickets().setValueAt(passportNum, selectedRow, 1);
			guiT.getDTMTTickets().setValueAt(flightNum, selectedRow, 2);

			
		}

		if (e.getSource() == guiT.getBtnRemoveTickets(UserType)) {
			
			int ticketNum = Integer.parseInt(guiT.getTSearchTickets().getText());

			// Elimina el dato dentro del xml y refrescar en la tabla
			Tickets t = fTXML.searchTicketAndDelete("Tickets.xml", "Ticket", ticketNum);

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
			Tickets ticket = fTXML.searchTicket("Tickets.xml", "Ticket", ticketNum);

			if (ticket != null) {
			
				JOptionPane.showMessageDialog(null, "Ticket encontrado");
				guiT.getTTicketNumber().setText(String.valueOf(ticket.getTicketNum()));
				guiT.getTPassportNumber().setText(String.valueOf(ticket.getPassportNum()));
				guiT.getTFlightNumber().setText(String.valueOf(ticket.getFlightNum()));
				

			} else {
				JOptionPane.showMessageDialog(null, "Ticket no encontrado");
			}
			
			
		}
	}

}