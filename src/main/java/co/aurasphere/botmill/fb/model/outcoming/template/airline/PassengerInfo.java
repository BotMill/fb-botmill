package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.annotations.SerializedName;


/**
 * The Class PassengerInfo.
 */
public class PassengerInfo implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The passenger id. */
	@NotBlank
	@SerializedName("passenger_id")
	private String passengerId;
	
	/** The ticket number. */
	@SerializedName("ticket_number")
	private String ticketNumber;
	
	/** The name. */
	@NotBlank
	private String name;

	/**
	 * Instantiates a new passenger info.
	 *
	 * @param passengerId the passenger id
	 * @param name the name
	 */
	public PassengerInfo(String passengerId, String name) {
		this.passengerId = passengerId;
		this.name = name;
	}

	/**
	 * Instantiates a new passenger info.
	 *
	 * @param passengerId the passenger id
	 * @param name the name
	 * @param ticketNumber the ticket number
	 */
	public PassengerInfo(String passengerId, String name, String ticketNumber) {
		this(passengerId, name);
		this.ticketNumber = ticketNumber;
	}

	/**
	 * Gets the passenger id.
	 *
	 * @return the passenger id
	 */
	public String getPassengerId() {
		return passengerId;
	}

	/**
	 * Sets the passenger id.
	 *
	 * @param passengerId the new passenger id
	 */
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	/**
	 * Gets the ticket number.
	 *
	 * @return the ticket number
	 */
	public String getTicketNumber() {
		return ticketNumber;
	}

	/**
	 * Sets the ticket number.
	 *
	 * @param ticketNumber the new ticket number
	 */
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
