package domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class PrintTicket {

	private int ticketNum, passportNum, cellphone, year, execSeats, tourSeats, ecoSeats, totalAmount;
	private String name, lastName, email, bornDate, nameAirline, country, registerOfAircft;
	private String airline;
	private String model;
	private LocalDate dateTicketPurchase, departureDate, arrivalDate;
	private LocalTime hourTicketPurchase, departureHour, arrivalHour;

	public PrintTicket() {
	}

	public PrintTicket(int ticketNum, int passportNum, int cellphone, int year, int execSeats, int tourSeats,
			int ecoSeats, int totalAmount, String name, String lastName, String email, String bornDate,
			String nameAirline, String country, String registerOfAircft, String airline, String model,
			LocalDate dateTicketPurchase, LocalDate departureDate, LocalDate arrivalDate, LocalTime hourTicketPurchase,
			LocalTime departureHour, LocalTime arrivalHour) {
		super();
		this.ticketNum = ticketNum;
		this.passportNum = passportNum;
		this.cellphone = cellphone;
		this.year = year;
		this.execSeats = execSeats;
		this.tourSeats = tourSeats;
		this.ecoSeats = ecoSeats;
		this.totalAmount = totalAmount;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.bornDate = bornDate;
		this.nameAirline = nameAirline;
		this.country = country;
		this.registerOfAircft = registerOfAircft;
		this.airline = airline;
		this.model = model;
		this.dateTicketPurchase = dateTicketPurchase;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.hourTicketPurchase = hourTicketPurchase;
		this.departureHour = departureHour;
		this.arrivalHour = arrivalHour;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public int getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(int passportNum) {
		this.passportNum = passportNum;
	}

	public int getCellphone() {
		return cellphone;
	}

	public void setCellphone(int cellphone) {
		this.cellphone = cellphone;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	public String getNameAirline() {
		return nameAirline;
	}

	public void setNameAirline(String nameAirline) {
		this.nameAirline = nameAirline;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public LocalDate getDateTicketPurchase() {
		return dateTicketPurchase;
	}

	public void setDateTicketPurchase(LocalDate dateTicketPurchase) {
		this.dateTicketPurchase = dateTicketPurchase;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalTime getHourTicketPurchase() {
		return hourTicketPurchase;
	}

	public void setHourTicketPurchase(LocalTime hourTicketPurchase) {
		this.hourTicketPurchase = hourTicketPurchase;
	}

	public LocalTime getDepartureHour() {
		return departureHour;
	}

	public void setDepartureHour(LocalTime departureHour) {
		this.departureHour = departureHour;
	}

	public LocalTime getArrivalHour() {
		return arrivalHour;
	}

	public void setArrivalHour(LocalTime arrivalHour) {
		this.arrivalHour = arrivalHour;
	}

	public String[] getDataName() {
		String[] dataName = { "ticketNum", "passportNum", "name", "lastName", "bornDate", "email", "cellphone",
				"dateTicketPurchase", "hourTicketPurchase", "nameAirline", "country", "registerOfAircft", "airline",
				"model", "year", "departureCity", "departureDate", "departureHour", "arrivalCity", "arrivalDate",
				"arrivalHour", "execSeats", "tourSeats", "ecoSeats", "totalAmount" };
		return dataName;
	}

	public String[] getData() {
		String[] data = { String.valueOf(ticketNum), String.valueOf(passportNum), name, lastName, email, bornDate,
				String.valueOf(cellphone), String.valueOf(dateTicketPurchase), String.valueOf(hourTicketPurchase),
				nameAirline, country, registerOfAircft, airline, model, String.valueOf(year),
				String.valueOf(departureDate), String.valueOf(departureHour), String.valueOf(arrivalDate),
				String.valueOf(arrivalHour), String.valueOf(execSeats), String.valueOf(tourSeats),
				String.valueOf(ecoSeats), String.valueOf(totalAmount) };
		return data;
	}

	@Override
	public String toString() {
		return "PrintTicket [ticketNum=" + ticketNum + ", passportNum=" + passportNum + ", cellphone=" + cellphone
				+ ", year=" + year + ", execSeats=" + execSeats + ", tourSeats=" + tourSeats + ", ecoSeats=" + ecoSeats
				+ ", totalAmount=" + totalAmount + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", bornDate=" + bornDate + ", nameAirline=" + nameAirline + ", country=" + country
				+ ", registerOfAircft=" + registerOfAircft + ", airline=" + airline + ", model=" + model
				+ ", dateTicketPurchase=" + dateTicketPurchase + ", departureDate=" + departureDate + ", arrivalDate="
				+ arrivalDate + ", hourTicketPurchase=" + hourTicketPurchase + ", departureHour=" + departureHour
				+ ", arrivalHour=" + arrivalHour + "]";
	}

}
