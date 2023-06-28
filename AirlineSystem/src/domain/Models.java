package domain;

public class Models{
	
	private String name;
	private String brand;
	private int execSeats,tourSeats,ecoSeats;
	
	public Models() {}

	public Models(String name, String brand, int execSeats, int tourSeats, int ecoSeats) {
		super();
		this.name = name;
		this.brand = brand;
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
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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
		String[] dataName = {"name","brand","execSeats","tourSeats", "ecoSeats"};
		return dataName;
	}
	
	
	public String[] getData() {
		String[] data = {name, brand, String.valueOf(execSeats), String.valueOf(tourSeats), String.valueOf(ecoSeats)};
		return data;
	}

	@Override
	public String toString() {
		return "Modelo = " + name + "\n Marca = " + brand + "\n Asientos Ejecutivos = " + execSeats 
				+ "\n Asientos Turista = " + tourSeats + "\n Asientos Economicos = " + ecoSeats;
	}
	
	
	
}