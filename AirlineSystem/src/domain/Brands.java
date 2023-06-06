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

	@Override
	public String toString() {
		return "Brands [name=" + name + "]";
	}
	
	
	

}
