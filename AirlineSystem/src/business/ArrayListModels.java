package business;

import java.util.ArrayList;

import domain.Models;

public class ArrayListModels {
	
	private ArrayList<Models> arrayLModels;
	private Object data[][];

	public ArrayListModels() {
		arrayLModels = new ArrayList<Models>();
	}
	
	public void addModel(Models model) {
		arrayLModels.add(model);
	}
	
	public void insertModel(int index, Models model) {
		arrayLModels.add(model);
	}
	
	public void removeModels(int index) {
		arrayLModels.remove(index);
	}
	
	public void removeModel(Models model) {
		arrayLModels.remove(model);
	}
	
	public void replaceModel(int index, Models model) {
		arrayLModels.set(index, model);
	}
	
	public boolean searchModel(Models model) {
		return arrayLModels.contains(model);
	}
	
	public void cleanModel() {
		arrayLModels.clear();
	}
	
	public ArrayList<Models> getArrayListModels(){
		return arrayLModels;
	}
	
	public void setDataMatrixModels(ArrayList<Models> arrayLModels) {
		data = new Object[arrayLModels.size()][5];
		
		for(int i=0; i<this.data.length; i++) {
			data[i][0] = arrayLModels.get(i).getName();
			data[i][1] = arrayLModels.get(i).getBrand();
			data[i][2] = arrayLModels.get(i).getExecSeats();
			data[i][3] = arrayLModels.get(i).getTourSeats();
			data[i][4] = arrayLModels.get(i).getEcoSeats();
		}
	}
	
	public Object[][] getDataMatrixModels(){
		return data;
	}
	
	public String getModels(ArrayList<Models> arrayLModels) {
		String models = " ";
		
		for(Models model: arrayLModels) {
			models += model.toString();
		}
		return models;
	}
}
