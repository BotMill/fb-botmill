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
 * The Class PassengerInfo.
 */
public class PassengerInfo implements Serializable {

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
	 * @param passengerId
	 *            the passenger id
	 * @param name
	 *            the name
	 */
	public PassengerInfo(String passengerId, String name) {
		this.passengerId = passengerId;
		this.name = name;
	}

	/**
	 * Instantiates a new passenger info.
	 *
	 * @param passengerId
	 *            the passenger id
	 * @param name
	 *            the name
	 * @param ticketNumber
	 *            the ticket number
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
	 * @param passengerId
	 *            the new passenger id
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
	 * @param ticketNumber
	 *            the new ticket number
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
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((passengerId == null) ? 0 : passengerId.hashCode());
		result = prime * result
				+ ((ticketNumber == null) ? 0 : ticketNumber.hashCode());
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
		PassengerInfo other = (PassengerInfo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passengerId == null) {
			if (other.passengerId != null)
				return false;
		} else if (!passengerId.equals(other.passengerId))
			return false;
		if (ticketNumber == null) {
			if (other.ticketNumber != null)
				return false;
		} else if (!ticketNumber.equals(other.ticketNumber))
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
		return "PassengerInfo [passengerId=" + passengerId + ", ticketNumber="
				+ ticketNumber + ", name=" + name + "]";
	}
}
