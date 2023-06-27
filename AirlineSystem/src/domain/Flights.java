package domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flights {

    private int flightNum, amountOfExecSeat, amountOfEcoSeat, amountOfTourSeat;
    private String departureCity, arrivalCity, plane;
    private LocalDate departureDate, arrivalDate;
    private LocalTime departureHour, arrivalHour;

    public Flights() {
    }

    public Flights(int flightNum, String departureCity, LocalDate departureDate, LocalTime departureHour,
                   String arrivalCity, LocalDate arrivalDate, LocalTime arrivalHour, String plane,
                   int amountOfExecSeat, int amountOfTourSeat, int amountOfEcoSeat) {
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(LocalTime departureHour) {
        this.departureHour = departureHour;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(LocalTime arrivalHour) {
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

    public String[] getDataName() {
        String[] dataName = { "flightNum", "departureCity", "departureDate", "departureHour", "plane", "arrivalCity",
                "arrivalDate", "arrivalHour", "amountOfExecSeat", "amountOfTourSeat", "amountOfEcoSeat" };
        return dataName;
    }

    public String[] getData() {
        String[] data = { String.valueOf(flightNum), departureCity, String.valueOf(departureDate),
                String.valueOf(departureHour), plane, arrivalCity, String.valueOf(arrivalDate),
                String.valueOf(arrivalHour), String.valueOf(amountOfExecSeat), String.valueOf(amountOfTourSeat),
                String.valueOf(amountOfEcoSeat) };
        return data;
    }

    // ToString
    @Override
    public String toString() {
        return "Numero de vuelo = " + flightNum + "\n Ciudad de salida = " + departureCity +
                "\n Fecha de salida = " + departureDate + "\n Hora de salida = " + departureHour +
                "\n Ciudad de llegada = " + arrivalCity + "\n Fecha de llegada = " + arrivalDate +
                "\n Hora de llegada = " + arrivalHour + "\n Avion = " + plane +
                "\n Cant.As Ejecutivos = " + amountOfExecSeat + "\n Cant.As Turistas = " + amountOfTourSeat +
                "\n Cant.As Economicos = " + amountOfEcoSeat;
    }
}
