package domain;

public class Tickets {
	
	private int ticketNum;
	private int passportNum;
	private int flightNumber;
	
	public Tickets() {}

	public Tickets(int ticketNum, int passportNum, int flightNumber) {
		super();
		this.ticketNum = ticketNum;
		this.passportNum = passportNum;
		this.flightNumber = flightNumber;
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

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	@Override
	public String toString() {
		return "Tickets [ticketNum=" + ticketNum + ", passportNum=" + passportNum + ", flightNumber=" + flightNumber
				+ "]";
	}
	
	
	
	
	

}
