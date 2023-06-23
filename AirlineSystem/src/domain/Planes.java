package domain;

public class Planes {
	
	private String tuition;
	private String airline;
	private String model;
	private int year;
	
	public Planes() {}

	public Planes(String tuition, String airline, String model, int year) {
		super();
		this.tuition = tuition;
		this.airline = airline;
		this.model = model;
		this.year = year;
	}

	public String getTuition() {
		return tuition;
	}

	public void setTuition(String tuition) {
		this.tuition = tuition;
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

	@Override
	public String toString() {
		return "Planes [tuition=" + tuition + ", airline=" + airline + ", model=" + model + ", year=" + year + "]";
	}
	
	
	

}
