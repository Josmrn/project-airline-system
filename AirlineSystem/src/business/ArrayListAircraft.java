package business;

import java.util.ArrayList;

import domain.Planes;

public class ArrayListAircraft {
	
	private ArrayList<Planes> arrayLAircraft;
	private Object data[][];

	public ArrayListAircraft() {
		arrayLAircraft = new ArrayList<Planes>();
	}
	
	public void addAircraft(Planes p) {
		arrayLAircraft.add(p);
	}
	
	public void insertAircraft(int index, Planes p) {
		arrayLAircraft.add(index, p);
	}
	
	public void removeAircrafts(int index) {
		arrayLAircraft.remove(index);
	}
	
	public void removePlanes(Planes p) {
		arrayLAircraft.remove(p);
	}
	
	public void replaceAircraft(int index, Planes p) {
		arrayLAircraft.set(index, p);
	}
	
	public boolean searchAircraft(Planes p) {
		return arrayLAircraft.contains(p);
	}
	
	public void cleanArrayListAircraft() {
		arrayLAircraft.clear();
	}
	
	public ArrayList<Planes> getArrayListAircraft(){
		return arrayLAircraft;
	}

	public void setDataMatrixAircraft(ArrayList<Planes> arrayLAircraft) {
		
		data = new Object[arrayLAircraft.size()][4];
		
		for(int i=0; i<this.data.length; i++) {
			data[i][0]=arrayLAircraft.get(i).getRegisterOfAircft();
			data[i][1]=arrayLAircraft.get(i).getYear();
			data[i][2]=arrayLAircraft.get(i).getAirline();
			data[i][3]=arrayLAircraft.get(i).getModel();
		}
	}
}
