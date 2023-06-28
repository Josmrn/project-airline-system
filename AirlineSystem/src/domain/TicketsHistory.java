package domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class TicketsHistory {
	
	private int passportNum,cellphone,ticketNum,year;
	private String name,lastName,email,bornDate,nameAirline,country,registerOfAircft,airline,model,execSeats,tourSeats,ecoSeats;
	private LocalDate ticketPurchDate,departureDate, arrivalDate;
	private LocalTime ticketPurchHour,departureHour, arrivalHour;
	
	public TicketsHistory() {}
	
	public TicketsHistory(int passportNum, int cellphone, int ticketNum, int year, String name, String lastName,
			String email, String bornDate, String nameAirline, String country, String registerOfAircft, String airline,
			String model, String execSeats, String tourSeats, String ecoSeats, LocalDate ticketPurchDate,
			LocalDate departureDate, LocalDate arrivalDate, LocalTime ticketPurchHour, LocalTime departureHour,
			LocalTime arrivalHour) {
		super();
		this.passportNum = passportNum;
		this.cellphone = cellphone;
		this.ticketNum = ticketNum;
		this.year = year;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.bornDate = bornDate;
		this.nameAirline = nameAirline;
		this.country = country;
		this.registerOfAircft = registerOfAircft;
		this.airline = airline;
		this.model = model;
		this.execSeats = execSeats;
		this.tourSeats = tourSeats;
		this.ecoSeats = ecoSeats;
		this.ticketPurchDate = ticketPurchDate;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.ticketPurchHour = ticketPurchHour;
		this.departureHour = departureHour;
		this.arrivalHour = arrivalHour;
	}

	@Override
	public String toString() {
		return "TicketsHistory [passportNum=" + passportNum + ", cellphone=" + cellphone + ", ticketNum=" + ticketNum
				+ ", year=" + year + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", bornDate="
				+ bornDate + ", nameAirline=" + nameAirline + ", country=" + country + ", registerOfAircft="
				+ registerOfAircft + ", airline=" + airline + ", model=" + model + ", execSeats=" + execSeats
				+ ", tourSeats=" + tourSeats + ", ecoSeats=" + ecoSeats + ", ticketPurchDate=" + ticketPurchDate
				+ ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", ticketPurchHour="
				+ ticketPurchHour + ", departureHour=" + departureHour + ", arrivalHour=" + arrivalHour + "]";
	}
}
