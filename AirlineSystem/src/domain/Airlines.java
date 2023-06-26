package domain;

public class Airlines {
	
	private String nameAirline,country;
	
	public Airlines() {}
	
	public Airlines(String nameAirline, String country) {
		super();
		this.nameAirline = nameAirline;
		this.country = country;
	}

	public String getNameAirline() {
		return nameAirline;
	}
	public void setNameAirlne(String nameAirline) {
		this.nameAirline = nameAirline;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String[] getDataName() {
		String[] dataName = {"nameAirline","country"};
		return dataName;
	}
	
	
	public String[] getData() {
		String[] data = {nameAirline,country};
		return data;
	}

	@Override
	public String toString() {
		return nameAirline + country;
	}
	

}
