package business;

import java.util.ArrayList;
import domain.Users;


public class ArrayListUsers {

	private ArrayList<Users> arrayLUsers;
	private Object data[][];
	
	public ArrayListUsers() {
		
		arrayLUsers = new ArrayList<Users>();
	}
	
	public void addUser(Users u) {
		arrayLUsers.add(u);
	}
	
	public void insertUser(int index, Users u) {
		
		arrayLUsers.add(index, u);
	}
	
	public void removeUser(int index) {
		
		arrayLUsers.remove(index);
	}
	
	public void removePerson(Users u) {
		
		arrayLUsers.remove(u);
	}
	
	public void replaceUser(int index, Users u) {
		
		arrayLUsers.set(index, u);
	}
	
	public boolean searchUser(Users u) {
		
		return arrayLUsers.contains(u);
	}
	
	public void cleanArrayListUsers() {
		
		arrayLUsers.clear();
	}
	
	public ArrayList<Users> getArrayListUsers(){
		
		return arrayLUsers;
	}
	
	//La matrix de datos de usuario ingresados
	public void setDataMatrixUsers(ArrayList<Users> arrayLUsers) {
		
		data = new Object[arrayLUsers.size()][5];
		
		for(int i=0; i<this.data.length;i++) {

			data[i][0]=arrayLUsers.get(i).getUser();
			data[i][1]=arrayLUsers.get(i).getPassword();
			data[i][2]=arrayLUsers.get(i).getTypeUser();
			data[i][3]=arrayLUsers.get(i).getState();
		}
	}
	
	
	public Object[][] getDataMatrixUsers(){
		return data;
	}
	
	
	public String getUsers(ArrayList<Users> arrayLUsers) {
		
		String users = "";
		
		for(Users u:arrayLUsers) {
			users+=u.toString();
		}
		return users;
	}
	
	
	
}
