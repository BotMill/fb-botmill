package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;


/**
 * The Class Airport.
 */
public class Airport implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The airport code. */
	@NotEmpty
	@SerializedName("airport_code")
	private String airportCode;
	
	/** The city. */
	@NotEmpty
	private String city;
	
	/** The terminal. */
	private String terminal;
	
	/** The gate. */
	private String gate;
	
	/**
	 * Instantiates a new airport.
	 *
	 * @param airportCode the airport code
	 * @param city the city
	 */
	public Airport(String airportCode, String city){
		this.airportCode = airportCode;
		this.city = city;
	}

	/**
	 * Instantiates a new airport.
	 *
	 * @param airportCode the airport code
	 * @param city the city
	 * @param gate the gate
	 * @param terminal the terminal
	 */
	public Airport(String airportCode, String city, String gate,
			String terminal) {
		this(airportCode, city);
		this.gate = gate;
		this.terminal = terminal;
	}

	/**
	 * Gets the airport code.
	 *
	 * @return the airport code
	 */
	public String getAirportCode() {
		return airportCode;
	}

	/**
	 * Sets the airport code.
	 *
	 * @param airportCode the new airport code
	 */
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the terminal.
	 *
	 * @return the terminal
	 */
	public String getTerminal() {
		return terminal;
	}

	/**
	 * Sets the terminal.
	 *
	 * @param terminal the new terminal
	 */
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	/**
	 * Gets the gate.
	 *
	 * @return the gate
	 */
	public String getGate() {
		return gate;
	}

	/**
	 * Sets the gate.
	 *
	 * @param gate the new gate
	 */
	public void setGate(String gate) {
		this.gate = gate;
	}
}
