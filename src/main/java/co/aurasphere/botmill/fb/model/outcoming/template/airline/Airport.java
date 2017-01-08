/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Airport.
 */
public class Airport implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The airport code. */
	@NotBlank
	@SerializedName("airport_code")
	private String airportCode;

	/** The city. */
	@NotBlank
	private String city;

	/** The terminal. */
	private String terminal;

	/** The gate. */
	private String gate;

	/**
	 * Instantiates a new airport.
	 *
	 * @param airportCode
	 *            the airport code
	 * @param city
	 *            the city
	 */
	public Airport(String airportCode, String city) {
		this.airportCode = airportCode;
		this.city = city;
	}

	/**
	 * Instantiates a new airport.
	 *
	 * @param airportCode
	 *            the airport code
	 * @param city
	 *            the city
	 * @param gate
	 *            the gate
	 * @param terminal
	 *            the terminal
	 */
	public Airport(String airportCode, String city, String gate, String terminal) {
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
	 * @param airportCode
	 *            the new airport code
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
	 * @param city
	 *            the new city
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
	 * @param terminal
	 *            the new terminal
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
	 * @param gate
	 *            the new gate
	 */
	public void setGate(String gate) {
		this.gate = gate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((airportCode == null) ? 0 : airportCode.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((gate == null) ? 0 : gate.hashCode());
		result = prime * result
				+ ((terminal == null) ? 0 : terminal.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		if (airportCode == null) {
			if (other.airportCode != null)
				return false;
		} else if (!airportCode.equals(other.airportCode))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (gate == null) {
			if (other.gate != null)
				return false;
		} else if (!gate.equals(other.gate))
			return false;
		if (terminal == null) {
			if (other.terminal != null)
				return false;
		} else if (!terminal.equals(other.terminal))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", city=" + city
				+ ", terminal=" + terminal + ", gate=" + gate + "]";
	}
}
