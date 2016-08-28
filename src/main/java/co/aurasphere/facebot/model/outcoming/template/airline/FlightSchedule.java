package co.aurasphere.facebot.model.outcoming.template.airline;

import java.io.Serializable;
import java.util.Calendar;

import javax.validation.constraints.NotNull;

import com.google.gson.annotations.SerializedName;

public class FlightSchedule implements Serializable{

	private static final long serialVersionUID = 1L;

	@SerializedName("boarding_time")
	private Calendar boardingTime;
	
	@NotNull
	@SerializedName("departure_time")
	private Calendar departureTime;
	
	@NotNull
	@SerializedName("arrival_time")
	private Calendar arrivalTime;
	
	public FlightSchedule(Calendar departureTime, Calendar arrivalTime){
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	
	public FlightSchedule(Calendar departureTime, Calendar arrivalTime, Calendar boardingTime){
		this(departureTime, arrivalTime);
		this.boardingTime = boardingTime;
	}

	public Calendar getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(Calendar boardingTime) {
		this.boardingTime = boardingTime;
	}

	public Calendar getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Calendar departureTime) {
		this.departureTime = departureTime;
	}

	public Calendar getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Calendar arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
}
