package domain;

import java.util.Arrays;

public class Flights {
	
	private int flightNum,amountOfExecSeat,amountOfEcoSeat,amountOfTourSeat;
	private String departureCity,arrivalCity,plane;
	private int[] departureDate,departureHour,arrivalDate,arrivalHour;
	
	
	public Flights() {}

	public Flights(int flightNum, String departureCity, int[] departureDate, int[] departureHour, String arrivalCity,
			int[] arrivalDate, int[] arrivalHour, String plane, int amountOfExecSeat, int amountOfTourSeat,
			int amountOfEcoSeat) {
		super();
		this.flightNum = flightNum;
		this.departureCity = departureCity;
		this.departureDate = departureDate;
		this.departureHour = departureHour;
		this.arrivalCity = arrivalCity;
		this.arrivalDate = arrivalDate;
		this.arrivalHour = arrivalHour;
		this.plane = plane;
		this.amountOfExecSeat = amountOfExecSeat;
		this.amountOfTourSeat = amountOfTourSeat;
		this.amountOfEcoSeat = amountOfEcoSeat;
	}
	
	//Getters y Setters
	public int getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public int[] getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(int[] departureDate) {
		this.departureDate = departureDate;
	}

	public int[] getDepartureHour() {
		return departureHour;
	}

	public void setDepartureHour(int[] departureHour) {
		this.departureHour = departureHour;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public int[] getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(int[] arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int[] getArrivalHour() {
		return arrivalHour;
	}

	public void setArrivalHour(int[] arrivalHour) {
		this.arrivalHour = arrivalHour;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	public int getAmountOfExecSeat() {
		return amountOfExecSeat;
	}

	public void setAmountOfExecSeat(int amountOfExecSeat) {
		this.amountOfExecSeat = amountOfExecSeat;
	}

	public int getAmountOfTourSeat() {
		return amountOfTourSeat;
	}

	public void setAmountOfTourSeat(int amountOfTourSeat) {
		this.amountOfTourSeat = amountOfTourSeat;
	}

	public int getAmountOfEcoSeat() {
		return amountOfEcoSeat;
	}

	public void setAmountOfEcoSeat(int amountOfEcoSeat) {
		this.amountOfEcoSeat = amountOfEcoSeat;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Flights [flightNum=" + flightNum + ", departureCity=" + departureCity + ", departureDate="
				+ Arrays.toString(departureDate) + ", departureHour=" + Arrays.toString(departureHour)
				+ ", arrivalCity=" + arrivalCity + ", arrivalDate=" + Arrays.toString(arrivalDate) + ", arrivalHour="
				+ Arrays.toString(arrivalHour) + ", plane=" + plane + ", amountOfExecSeat=" + amountOfExecSeat
				+ ", amountOfTourSeat=" + amountOfTourSeat + ", amountOfEcoSeat=" + amountOfEcoSeat + "]";
	}
	
	
	
	
	
}