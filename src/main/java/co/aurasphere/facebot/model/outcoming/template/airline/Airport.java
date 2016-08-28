package co.aurasphere.facebot.model.outcoming.template.airline;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

public class Airport implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@SerializedName("airport_code")
	private String airportCode;
	
	@NotEmpty
	private String city;
	
	private String terminal;
	
	private String gate;
	
	public Airport(String airportCode, String city){
		this.airportCode = airportCode;
		this.city = city;
	}

	public Airport(String airportCode, String city, String gate,
			String terminal) {
		this(airportCode, city);
		this.gate = gate;
		this.terminal = terminal;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}
}
