package domain;

public class Models{
	
	private String model;
	private String nameBrands;
	private int execSeats,tourSeats,ecoSeats;
	
	public Models() {}

	public Models(String nameBrands, String model, int execSeats, int tourSeats, int ecoSeats) {
		super();
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
	
	public String getNameBrands() {
		return nameBrands;
	}

	public void setNameBrands(String nameBrands) {
		this.nameBrands = nameBrands;
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
	
	public String[] getDataName() {
		String[] dataName = {"model","nameBrands","	execSeats","tourSeats", "ecoSeats"};
		return dataName;
	}
	
	
	public String[] getData() {
		String[] data = {model, getNameBrands(), String.valueOf(execSeats), String.valueOf(tourSeats), String.valueOf(ecoSeats)};
		return data;
	}

	@Override
	public String toString() {
		return "Modelo = " + model + "Marca = " + nameBrands + "Asientos Ejecutivos = " + execSeats 
				+ "Asientos Turista = " + tourSeats + "Asientos Economicos = " + ecoSeats;
	}
	
	
	
}