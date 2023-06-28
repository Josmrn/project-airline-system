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
		data = new Object[arrayLPrint.size()][23];
		
		for(int i=0; i<this.data.length; i++) {
			
		}
	}

}
