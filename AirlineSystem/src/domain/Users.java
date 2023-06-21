package domain;

public class Users {
	
	private String user;
	private String password;
	private String typeUser;
	private String state;
	
	public Users() {}
	
	public Users(String user, String password, String typeUser, String state) {
		super();
		this.user = user;
		this.password = password;
		this.typeUser = typeUser;
		this.state = state;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String[] getDataName() {
		String[] dataName = {"user","password","typeUser","state"};
		return dataName;
		
	}
	
	public String getDataNameUser() {
		String dataName = "user";
		return dataName;
		
	}
	
	
	public String[] getData() {
		String[] data = {user,password,typeUser,state};
		return data;
	}

	@Override
	public String toString() {
		return "Usuario: " + user + "\n Contraseña: " + password + "Tipo de Usuario: " + typeUser + "\n Estado: " + state;
	}
	
	

}
