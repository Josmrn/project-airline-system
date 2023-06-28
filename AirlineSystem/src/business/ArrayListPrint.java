package business;

import java.util.ArrayList;

import domain.PrintTicket;

public class ArrayListPrint {
	
	private ArrayList<PrintTicket> arrayLPrint;
	private Object data[][];

	public ArrayListPrint() {
		// TODO Auto-generated constructor stub
		arrayLPrint = new ArrayList<>();
	}
	
	public void addPrint(PrintTicket p) {
		arrayLPrint.add(p);
	}
	
	public void insertPrint(int index, PrintTicket p) {
		arrayLPrint.add(p);
	}
	
	public void removePrint(PrintTicket p) {
		arrayLPrint.remove(p);
	}
	
	public boolean searchPrint(PrintTicket p) {
		return arrayLPrint.contains(p);
	}
	
	public ArrayList<PrintTicket> getArrayListPrintTicket(){
		return arrayLPrint;
	}
	
	public void setDataMatrixPrint(ArrayList<PrintTicket> arrayLPrint) {
		data = new Object[arrayLPrint.size()][25];
		
		for(int i=0; i<this.data.length; i++) {
			data[i][0] = arrayLPrint.get(i).getTicketNum();
			data[i][1] = arrayLPrint.get(i).getPassportNum();
			data[i][2] = arrayLPrint.get(i).getName();
			data[i][3] = arrayLPrint.get(i).getLastName();
			data[i][4] = arrayLPrint.get(i).getBornDate();
			data[i][5] = arrayLPrint.get(i).getEmail();
			data[i][6] = arrayLPrint.get(i).getCellphone();
			data[i][7] = arrayLPrint.get(i).getTicketNum();
			data[i][8] = arrayLPrint.get(i).getDepartureCity();
			data[i][9] = arrayLPrint.get(i).getDepartureDate();
			data[i][10] = arrayLPrint.get(i).getDepartureHour();
			data[i][11] = arrayLPrint.get(i).getArrivalCity();
			data[i][12] = arrayLPrint.get(i).getArrivalDate();
			data[i][13] = arrayLPrint.get(i).getArrivalHour();
			data[i][14] = arrayLPrint.get(i).getNameAirline();
			data[i][15] = arrayLPrint.get(i).getCountry();
			data[i][16] = arrayLPrint.get(i).getRegisterOfAircft();
			data[i][17] = arrayLPrint.get(i).getAirline();
			data[i][18] = arrayLPrint.get(i).getModel();
			data[i][19] = arrayLPrint.get(i).getYear();
			data[i][20] = arrayLPrint.get(i).getDateTicketPurchase();
			data[i][21] = arrayLPrint.get(i).getHourTicketPurchase();
			data[i][22] = arrayLPrint.get(i).getExecSeats();
			data[i][0] = arrayLPrint.get(i).getTourSeats();
			data[i][0] = arrayLPrint.get(i).getEcoSeats();
		}
	}
	
	public Object[][] getDataMatrixPrint(){
		return data;
	}
	
	public String getPrintTicket(ArrayList<PrintTicket> arrayLPrint) {
		String PrintTicket = " ";
		
		for(PrintTicket p : arrayLPrint) {
			PrintTicket += p.toString();
		}
		return PrintTicket;
	}
}
