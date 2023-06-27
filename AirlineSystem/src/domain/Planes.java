package domain;

public class Planes {
	
	private String registerOfAircft;
	private String airline;
	private String model;
	private int year;
	
	public Planes() {}

	public Planes(String registerOfAircft, String airline, String model, int year) {
		super();
		this.registerOfAircft = registerOfAircft;
		this.airline = airline;
		this.model = model;
		this.year = year;
	}

	public String getRegisterOfAircft() {
		return registerOfAircft;
	}

	public void setRegisterOfAircft(String registerOfAircft) {
		this.registerOfAircft = registerOfAircft;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String[] getDataName() {
		String[] dataName = {"registerOfAircft","airline","model","year"};
		return dataName;
	}
	
	
	public String[] getData() {
		String[] data = {registerOfAircft,airline,model,String.valueOf(year)};
		return data;
	}

	@Override
	public String toString() {
		return "Planes [registerOfAircft=" + registerOfAircft + ", airline=" + airline + ", model=" + model + ", year=" + year + "]";
	}
	
	
	

}