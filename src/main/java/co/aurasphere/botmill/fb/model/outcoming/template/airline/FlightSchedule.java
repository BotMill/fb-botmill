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
import java.util.Calendar;

import javax.validation.constraints.NotNull;

import com.google.gson.annotations.SerializedName;

/**
 * The Class FlightSchedule.
 */
public class FlightSchedule implements Serializable {

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
	 * @param departureTime
	 *            the departure time
	 * @param arrivalTime
	 *            the arrival time
	 */
	public FlightSchedule(Calendar departureTime, Calendar arrivalTime) {
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	/**
	 * Instantiates a new flight schedule.
	 *
	 * @param departureTime
	 *            the departure time
	 * @param arrivalTime
	 *            the arrival time
	 * @param boardingTime
	 *            the boarding time
	 */
	public FlightSchedule(Calendar departureTime, Calendar arrivalTime,
			Calendar boardingTime) {
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
	 * @param boardingTime
	 *            the new boarding time
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
	 * @param departureTime
	 *            the new departure time
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
	 * @param arrivalTime
	 *            the new arrival time
	 */
	public void setArrivalTime(Calendar arrivalTime) {
		this.arrivalTime = arrivalTime;
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
				+ ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result
				+ ((boardingTime == null) ? 0 : boardingTime.hashCode());
		result = prime * result
				+ ((departureTime == null) ? 0 : departureTime.hashCode());
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
		FlightSchedule other = (FlightSchedule) obj;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (boardingTime == null) {
			if (other.boardingTime != null)
				return false;
		} else if (!boardingTime.equals(other.boardingTime))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
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
		return "FlightSchedule [boardingTime=" + boardingTime
				+ ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + "]";
	}

}
