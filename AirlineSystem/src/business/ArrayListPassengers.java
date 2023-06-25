package business;

import java.util.ArrayList;

import domain.Passengers;

public class ArrayListPassengers {
	private ArrayList<Passengers> arrayLPassengers;
	private Object data[][];
	
	public ArrayListPassengers() {
		arrayLPassengers = new ArrayList<Passengers>();
	}
	
	public void addPassenger(Passengers p) {
		arrayLPassengers.add(p);
	}
	
	public void insertPassenger(int index, Passengers p) {
		arrayLPassengers.add(index, p);
	}
	
	public void removePassenger(int index) {
		arrayLPassengers.remove(index);
	}
	
	public void removePassenger(Passengers p) {
		arrayLPassengers.remove(p);
	}
	
	public void replacePassenger(int index, Passengers p) {
		arrayLPassengers.set(index, p);
	}
	
	public boolean searchPassenger(Passengers p) {
		return arrayLPassengers.contains(p);
	}
	
	public void cleanArrayListPassengers() {
		arrayLPassengers.clear();
	}
	
	public ArrayList<Passengers> getArrayListPassengers(){
		return arrayLPassengers;
	}
	
	//La matrix de datos de usuario ingresados
	public void setDataMatrixPassengers(ArrayList<Passengers> arrayLPassengers) {
		
		data = new Object[arrayLPassengers.size()][6];
		
		for(int i=0; i<this.data.length;i++) {

			data[i][0]=arrayLPassengers.get(i).getPassportNum();
			data[i][1]=arrayLPassengers.get(i).getName();
			data[i][2]=arrayLPassengers.get(i).getLastName();
			data[i][3]=arrayLPassengers.get(i).getEmail();
			data[i][4]=arrayLPassengers.get(i).getBornDate();
			data[i][5]=arrayLPassengers.get(i).getCellphone();


		}
	}
	
	
	public Object[][] getDataMatrixPassengers(){
		return data;
	}
	
	public String getPassengers(ArrayList<Passengers> arrayLPassengers) {
		
		String Passengers = "";

		for(Passengers u:arrayLPassengers) {
			Passengers+=u.toString();
		}
		return Passengers;
	}
	
	
	
	
	
}
