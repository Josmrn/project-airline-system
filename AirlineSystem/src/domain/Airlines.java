package domain;

public class Airlines {
	
	private String name,country;
	
	public Airlines() {}
	
	public Airlines(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Airlines [name=" + name + ", country=" + country + "]";
	}
	

}
