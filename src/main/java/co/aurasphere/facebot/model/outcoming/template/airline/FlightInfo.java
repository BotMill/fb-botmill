package co.aurasphere.facebot.model.outcoming.template.airline;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

public class FlightInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@SerializedName("flight_number")
	private String flightNumber;

	@Valid
	@NotNull
	@SerializedName("departure_airport")
	private Airport departureAirport;
	
	@Valid
	@NotNull
	@SerializedName("arrival_airport")
	private Airport arrivalAirport;
	
	@Valid
	@NotNull
	@SerializedName("flight_schedule")
	private FlightSchedule flightSchedule;
	
	public FlightInfo(String flightNumber){
		this.flightNumber = flightNumber;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}
	
	
}
