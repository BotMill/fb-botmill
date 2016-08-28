package co.aurasphere.facebot.model.outcoming.template.airline;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

public class PassengerInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@SerializedName("passenger_id")
	private String passengerId;
	
	@SerializedName("ticket_number")
	private String ticketNumber;
	
	@NotEmpty
	private String name;

	public PassengerInfo(String passengerId, String name) {
		this.passengerId = passengerId;
		this.name = name;
	}

	public PassengerInfo(String passengerId, String name, String ticketNumber) {
		this(passengerId, name);
		this.ticketNumber = ticketNumber;
	}

	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
