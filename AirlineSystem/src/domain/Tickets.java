package domain;

public class Tickets {
	
	private int ticketNum;
	private int passportNum;
	private int flightNum;
	
	public Tickets() {}

	public Tickets(int ticketNum, int passportNum, int flightNum) {
		super();
		this.ticketNum = ticketNum;
		this.passportNum = passportNum;
		this.flightNum = flightNum;
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

	public int getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}
	
	public String[] getDataName() {
		String[] dataName = {"ticketNum","passportNum","flightNum"};
		return dataName;
	}
	
	
	public String[] getData() {
		String[] data = {String.valueOf(ticketNum),String.valueOf(passportNum),String.valueOf(flightNum)};
		return data;
	}

	@Override
	public String toString() {
		return " Tiquite = " + ticketNum + "\n Pasaporte = " + passportNum + "\n Num. Vuelo = " + flightNum;
	}
	
	
	
	
	

}
