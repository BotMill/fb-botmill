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

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.annotations.SerializedName;

/**
 * The Class FlightInfoExtended.
 */
public class FlightInfoExtended extends FlightInfo {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The connection id. */
	@NotBlank
	@SerializedName("connection_id")
	private String connectionId;

	/** The segment id. */
	@NotBlank
	@SerializedName("segment_id")
	private String segmentId;

	/** The aircraft type. */
	@SerializedName("aircraft_type")
	private String aircraftType;

	/** The travel class. */
	@NotNull
	@SerializedName("travel_class")
	private TravelClass travelClass;

	/**
	 * Instantiates a new flight info extended.
	 *
	 * @param flightNumber
	 *            the flight number
	 * @param connectionId
	 *            the connection id
	 * @param segmentId
	 *            the segment id
	 * @param travelClass
	 *            the travel class
	 */
	public FlightInfoExtended(String flightNumber, String connectionId, String segmentId, TravelClass travelClass) {
		super(flightNumber);
		this.connectionId = connectionId;
		this.segmentId = segmentId;
		this.travelClass = travelClass;
	}

	/**
	 * Gets the connection id.
	 *
	 * @return the connection id
	 */
	public String getConnectionId() {
		return connectionId;
	}

	/**
	 * Sets the connection id.
	 *
	 * @param connectionId
	 *            the new connection id
	 */
	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	/**
	 * Gets the segment id.
	 *
	 * @return the segment id
	 */
	public String getSegmentId() {
		return segmentId;
	}

	/**
	 * Sets the segment id.
	 *
	 * @param segmentId
	 *            the new segment id
	 */
	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}

	/**
	 * Gets the aircraft type.
	 *
	 * @return the aircraft type
	 */
	public String getAircraftType() {
		return aircraftType;
	}

	/**
	 * Sets the aircraft type.
	 *
	 * @param aircraftType
	 *            the new aircraft type
	 */
	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	/**
	 * Gets the travel class.
	 *
	 * @return the travel class
	 */
	public TravelClass getTravelClass() {
		return travelClass;
	}

	/**
	 * Sets the travel class.
	 *
	 * @param travelClass
	 *            the new travel class
	 */
	public void setTravelClass(TravelClass travelClass) {
		this.travelClass = travelClass;
	}
}
