package business;

import java.util.ArrayList;

import domain.Brands;

public class ArrayListBrands {
	
	private ArrayList<Brands> arrayLBrands;
	private Object data[][];

	public ArrayListBrands() {
		arrayLBrands = new ArrayList<Brands>();
	}
	
	public void addBrand(Brands brands) {
		arrayLBrands.add(brands);
	}
	
	public void insertBrand(int index, Brands brands) {
		arrayLBrands.add(index, brands);
	}
	
	public void removeBrands(int index) {
		arrayLBrands.remove(index);
	}
	
	public void removeBrand(Brands brands) {
		arrayLBrands.remove(brands);
	}
	
	public void replaceBrands(int index, Brands brands) {
		arrayLBrands.set(index, brands);
	}
	
	public boolean searchBrands(int index, Brands brands) {
		return arrayLBrands.contains(brands);
	}
	
	public void cleanArrayListBrands() {
		arrayLBrands.clear();
	}
	
	public ArrayList<Brands> getArrayListBrands(){
		return arrayLBrands;
	}
	
	public void setDataMatrixBrands(ArrayList<Brands> arrayLBrands) {
		data = new Object[arrayLBrands.size()][1];
		
		for(int i=0; i<this.data.length; i++) {
			data[i][0] = arrayLBrands.get(i).getNameBrands();
		}
	}
	
	public Object[][] getDataMatrixBrands(){
		return data;
	}
	
	public String getBrands(ArrayList<Brands> arrayLBrands) {
		String brand = "";
		
		for(Brands brands: arrayLBrands) {
			brand += brands.toString();
		}
		return brand;
	}
}
