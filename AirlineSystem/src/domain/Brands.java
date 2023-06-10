package domain;

public class Brands {
	
	private String name;
	
	public Brands() {}

	public Brands(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String[] getDataName() {
		String[] dataName = {"name"};
		return dataName;
		
	}
	
	public String[] getData() {
		String[] data = {name};
		return data;
	}

	@Override
	public String toString() {
		return "Brands [name=" + name + "]";
	}
	
	
	

}
