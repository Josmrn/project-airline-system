package domain;

public class Brands {
	
	private String nameBrands;
	
	public Brands() {}

	public Brands(String nameBrands) {
		super();
		this.nameBrands = nameBrands;
	}

	public String getNameBrands() {
		return nameBrands;
	}

	public void setName(String nameBrands) {
		this.nameBrands = nameBrands;
	}
	
	public String[] getDataName() {
		String[] dataName = {"nameBrands"};
		return dataName;
		
	}
	
	public String[] getData() {
		String[] data = {nameBrands};
		return data;
	}

	@Override
	public String toString() {
		return  "Nombre de la Marca" + nameBrands;
	}
	
	
	

}
