package business;

import java.util.ArrayList;

import domain.Tickets;

public class ArrayListTickets {
	private ArrayList<Tickets> arrayLTickets;
	private Object data[][];
	
	public ArrayListTickets() {
		arrayLTickets = new ArrayList<Tickets>();
	}
	
	public void addTicket(Tickets t) {
		arrayLTickets.add(t);
	}
	
	public void insertTicket(int index, Tickets t) {
		arrayLTickets.add(index, t);
	}
	
	public void removeTicket(int index) {
		arrayLTickets.remove(index);
	}
	
	public void removeTicket(Tickets t) {
		arrayLTickets.remove(t);
	}
	
	public void replaceTicket(int index, Tickets t) {
		arrayLTickets.set(index, t);
	}
	
	public boolean searchTicket(Tickets t) {
		return arrayLTickets.contains(t);
	}
	
	public void cleanArrayListTickets() {
		arrayLTickets.clear();
	}
	
	public ArrayList<Tickets> getArrayListTickets(){
		return arrayLTickets;
	}
	
	//La matrix de datos de usuario ingresados
	public void setDataMatrixTickets(ArrayList<Tickets> arrayLTickets) {
		
		data = new Object[arrayLTickets.size()][4];
		
		for(int i=0; i<this.data.length;i++) {

			data[i][0]=arrayLTickets.get(i).getTicketNum();
			data[i][1]=arrayLTickets.get(i).getPassportNum();
			data[i][2]=arrayLTickets.get(i).getFlightNum();
			
		}
	}
	
	
	public Object[][] getDataMatrixTickets(){
		return data;
	}
	
	public String getTickets(ArrayList<Tickets> arrayLTickets) {
		
		String Tickets = "";

		for(Tickets u:arrayLTickets) {
			Tickets+=u.toString();
		}
		return Tickets;
	}
	
}
