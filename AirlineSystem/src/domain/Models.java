package domain;

public class Models {
	
	private String name;
	private Models Model;
	private int execSeats,tourSeats,ecoSeats;
	
	public Models() {}

	public Models(String name, Models model, int execSeats, int tourSeats, int ecoSeats) {
		super();
		this.name = name;
		Model = model;
		this.execSeats = execSeats;
		this.tourSeats = tourSeats;
		this.ecoSeats = ecoSeats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Models getModel() {
		return Model;
	}

	public void setModel(Models model) {
		Model = model;
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
		return "Models [name=" + name + ", Model=" + Model + ", execSeats=" + execSeats + ", tourSeats=" + tourSeats
				+ ", ecoSeats=" + ecoSeats + "]";
	}
	
	
	
}
