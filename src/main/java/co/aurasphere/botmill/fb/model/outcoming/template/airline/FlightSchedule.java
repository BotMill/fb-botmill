package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;
import java.util.Calendar;

import javax.validation.constraints.NotNull;

import com.google.gson.annotations.SerializedName;


/**
 * The Class FlightSchedule.
 */
public class FlightSchedule implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The boarding time. */
	@SerializedName("boarding_time")
	private Calendar boardingTime;
	
	/** The departure time. */
	@NotNull
	@SerializedName("departure_time")
	private Calendar departureTime;
	
	/** The arrival time. */
	@NotNull
	@SerializedName("arrival_time")
	private Calendar arrivalTime;
	
	/**
	 * Instantiates a new flight schedule.
	 *
	 * @param departureTime the departure time
	 * @param arrivalTime the arrival time
	 */
	public FlightSchedule(Calendar departureTime, Calendar arrivalTime){
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	
	/**
	 * Instantiates a new flight schedule.
	 *
	 * @param departureTime the departure time
	 * @param arrivalTime the arrival time
	 * @param boardingTime the boarding time
	 */
	public FlightSchedule(Calendar departureTime, Calendar arrivalTime, Calendar boardingTime){
		this(departureTime, arrivalTime);
		this.boardingTime = boardingTime;
	}

	/**
	 * Gets the boarding time.
	 *
	 * @return the boarding time
	 */
	public Calendar getBoardingTime() {
		return boardingTime;
	}

	/**
	 * Sets the boarding time.
	 *
	 * @param boardingTime the new boarding time
	 */
	public void setBoardingTime(Calendar boardingTime) {
		this.boardingTime = boardingTime;
	}

	/**
	 * Gets the departure time.
	 *
	 * @return the departure time
	 */
	public Calendar getDepartureTime() {
		return departureTime;
	}

	/**
	 * Sets the departure time.
	 *
	 * @param departureTime the new departure time
	 */
	public void setDepartureTime(Calendar departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * Gets the arrival time.
	 *
	 * @return the arrival time
	 */
	public Calendar getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * Sets the arrival time.
	 *
	 * @param arrivalTime the new arrival time
	 */
	public void setArrivalTime(Calendar arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
}
