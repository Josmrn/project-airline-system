 package business;

import java.util.ArrayList;

import domain.Flights;

public class ArrayListFlight {
	
	private ArrayList<Flights> arrayLFlights;
	private Object data[][];

	public ArrayListFlight() {
		arrayLFlights = new ArrayList<Flights>();
	}
	
	public void addFlight(Flights f) {
		arrayLFlights.add(f);
	}
	
	public void insertFlight(int index, Flights f) {
		arrayLFlights.add(index, f);
	}
	
	public void removeFlights(int index) {
		arrayLFlights.remove(index);
	}
	
	public void removeFlight(Flights f) {
		arrayLFlights.remove(f);
	}
	
	public void replaceFlight(int index, Flights f) {
		arrayLFlights.set(index, f);
	}
	
	public boolean searchFlight(Flights f) {
		return arrayLFlights.contains(f);
	}
	
	public void cleanArrayListFlight() {
		arrayLFlights.clear();
	}
	
	public ArrayList<Flights> getArrayListFlights(){
		return arrayLFlights;
	}
	
	//La matrix de datos de usuario ingresados
	public void setDataMatrixFlight(ArrayList<Flights> arrayLFlights) {
		
		data = new Object[arrayLFlights.size()][9];
		
		for(int i=0; i<this.data.length;i++) {

			data[i][0] = arrayLFlights.get(i).getDepartureCity();
			data[i][1] = arrayLFlights.get(i).getDepartureDate();
			data[i][2] = arrayLFlights.get(i).getDepartureHour();
			data[i][3] = arrayLFlights.get(i).getArrivalCity();
			data[i][4] = arrayLFlights.get(i).getArrivalDate();
			data[i][5] = arrayLFlights.get(i).getArrivalHour();
			data[i][6] = arrayLFlights.get(i).getAmountOfExecSeat();
			data[i][8] = arrayLFlights.get(i).getAmountOfTourSeat();
			data[i][9] = arrayLFlights.get(i).getAmountOfEcoSeat();
		}
	}
	
	
	public Object[][] getDataMatrixFlights(){
		return data;
	}
	
	public String getFlights(ArrayList<Flights> arrayLFlight) {
		
		String flight = "";

		for(Flights f: arrayLFlight) {
			flight += f.toString();
		}
		return flight;
	}

}
