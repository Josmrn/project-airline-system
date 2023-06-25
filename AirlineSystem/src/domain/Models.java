package domain;

public class Models extends Brands{
	
	private String model;
	private int execSeats,tourSeats,ecoSeats;
	
	public Models() {}

	public Models(String nameBrands, String model, int execSeats, int tourSeats, int ecoSeats) {
		super(nameBrands);
		this.model = model;
		this.execSeats = execSeats;
		this.tourSeats = tourSeats;
		this.ecoSeats = ecoSeats;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getExecSeats() {
		return execSeats;
	}

	public void setExecSeats(int execSeats) {
		this.execSeats = execSeats;
	}

	public int getTourSeats() {
		return tourSeats;
	}

	public void setTourSeats(int tourSeats) {
		this.tourSeats = tourSeats;
	}

	public int getEcoSeats() {
		return ecoSeats;
	}

	public void setEcoSeats(int ecoSeats) {
		this.ecoSeats = ecoSeats;
	}

	@Override
	public String toString() {
		return model + getNameBrands() + execSeats + tourSeats + ecoSeats;
	}
	
	
	
}