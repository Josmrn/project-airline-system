package business;

import java.util.ArrayList;

import domain.Airlines;

public class ArrayListAirline {
	
	private ArrayList<Airlines> arrayLAirlines;
	private Object data[][];

	public ArrayListAirline() {
		arrayLAirlines = new ArrayList<Airlines>();
	}
	
	public void addAirline(Airlines air) {
		arrayLAirlines.add(air);
	}
	
	public void insertAirline(int index, Airlines air) {
		arrayLAirlines.add(index, air);
	}
	
	public void removeAirlines(int index) {
		arrayLAirlines.remove(index);
	}
	
	public void removeAirline(Airlines air) {
		arrayLAirlines.remove(air);
	}
	
	public void replaceAirline(int index, Airlines air) {
		arrayLAirlines.set(index, air);
	}
	
	public boolean searchAirline(Airlines air) {
		return arrayLAirlines.contains(air);
	}
	
	public void cleanArrayListAirline() {
		arrayLAirlines.clear();
	}
	
	public ArrayList<Airlines> getArrayLAirlines(){
		return arrayLAirlines;
	}
	
	public void setDataMatrixAirline(ArrayList<Airlines> arrayLAirlines) {
		
		data = new Object[arrayLAirlines.size()][2];
		
		for(int i=0; i<this.data.length;i++) {

			data[i][0]=arrayLAirlines.get(i).getNameAirline();
			data[i][1]=arrayLAirlines.get(i).getCountry();
		}
	}
	
	
	public Object[][] getDataMatrixAirline(){
		return data;
	}
	
	
	public String getAirline(ArrayList<Airlines> arrayLAirlines) {
		
		String airlines = "";
		
		for(Airlines air: arrayLAirlines) {
			airlines += air.toString();
		}
		return airlines;
	}

}
