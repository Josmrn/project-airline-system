package domain;

public class Passengers {
	
	private int passportNum;
	private String name,lastName,email,bornDate;
	private int cellphone;
	
	public Passengers() {}
	
	public Passengers(int passportNum, String name, String lastName, String email, String bornDate, int cellphone) {
		super();
		this.passportNum = passportNum;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.bornDate = bornDate;
		this.cellphone = cellphone;
	}

	public int getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(int passportNum) {
		this.passportNum = passportNum;
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

	public int getCellphone() {
		return cellphone;
	}

	public void setCellphone(int cellphone) {
		this.cellphone = cellphone;
	}

	@Override
	public String toString() {
		return "Passengers [passportNum=" + passportNum + ", name=" + name + ", lastName=" + lastName + ", email="
				+ email + ", bornDate=" + bornDate + ", cellphone=" + cellphone + "]";
	}
	
	

}
