package domain;

public class Planes {
	
	private String tuition;
	private Airlines airline;
	private Models model;
	private int year;
	
	public Planes() {}

	public Planes(String tuition, Airlines airline, Models model, int year) {
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

	public Airlines getAirline() {
		return airline;
	}

	public void setAirline(Airlines airline) {
		this.airline = airline;
	}

	public Models getModel() {
		return model;
	}

	public void setModel(Models model) {
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
