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
package co.aurasphere.botmill.fb.model.outcoming.factory;

import java.util.Calendar;

import co.aurasphere.botmill.fb.model.outcoming.template.airline.Airport;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.FlightInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.FlightInfoExtended;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.FlightSchedule;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.PassengerSegmentInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.TravelClass;

/**
 * Builder for a {@link FlightInfoExtended} object.
 * 
 * @author Donato Rimenti
 * 
 */
public class FlightInfoExtendedBuilder {

	/**
	 * The parent builder of this one. Used to return to the parent once the
	 * build is finished calling {@link #endFlightInfo()}.
	 */
	private AirlineItineraryTemplateBuilder parentBuilder;

	/**
	 * The object managed by this builder.
	 */
	private FlightInfoExtended flightInfo;

	/**
	 * Default constructor. Creates a builder for a {@link FlightInfoExtended}
	 * object.
	 * 
	 * @param parentBuilder
	 *            the parent builder of this one. It can't be null.
	 * @param flightNumber
	 *            the flight number. It can't be empty.
	 * @param connectionId
	 *            used to group segments of a connection together. It can't be
	 *            empty.
	 * @param segmentId
	 *            segmentId of {@link PassengerSegmentInfo} object. It can't be
	 *            empty.
	 * @param travelClass
	 *            the travel class. It can't be null.
	 */
	FlightInfoExtendedBuilder(AirlineItineraryTemplateBuilder parentBuilder,
			String flightNumber, String connectionId, String segmentId,
			TravelClass travelClass) {
		this.flightInfo = new FlightInfoExtended(flightNumber, connectionId,
				segmentId, travelClass);
		this.parentBuilder = parentBuilder;
	}

	/**
	 * Sets the departure {@link Airport} for the current
	 * {@link FlightInfoExtended} object. This field is mandatory for this
	 * object and can't be null.
	 * 
	 * @param airportCode
	 *            the airport code. It can't be empty.
	 * @param city
	 *            the city name. The city will be displayed over the airport
	 *            code in the template. It can't be empty.
	 * @param gate
	 *            the airport gate. This field is optional.
	 * @param terminal
	 *            the airport terminal. This field is optional.
	 * @return this builder.
	 */
	public FlightInfoExtendedBuilder setDepartureAirport(String airportCode,
			String city, String gate, String terminal) {
		Airport departureAirport = new Airport(airportCode, city, gate,
				terminal);
		this.flightInfo.setDepartureAirport(departureAirport);
		return this;
	}

	/**
	 * Sets the departure {@link Airport} for the current
	 * {@link FlightInfoExtended} object. This field is mandatory for this
	 * object and can't be null.
	 * 
	 * @param airportCode
	 *            the airport code. It can't be empty.
	 * @param city
	 *            the city name. The city will be displayed over the airport
	 *            code in the template. It can't be empty.
	 * @return this builder.
	 */
	public FlightInfoExtendedBuilder setDepartureAirport(String airportCode,
			String city) {
		Airport departureAirport = new Airport(airportCode, city);
		this.flightInfo.setDepartureAirport(departureAirport);
		return this;
	}

	/**
	 * Sets the departure {@link Airport} for the current
	 * {@link FlightInfoExtended} object. This field is mandatory for this
	 * object and can't be null.
	 * 
	 * @param airport
	 *            the departure airport. It can't be null.
	 * @return this builder.
	 */
	public FlightInfoExtendedBuilder setDepartureAirport(Airport airport) {
		this.flightInfo.setDepartureAirport(airport);
		return this;
	}

	/**
	 * Sets the arrival {@link Airport} for the current
	 * {@link FlightInfoExtended} object. This field is mandatory for this
	 * object and can't be null.
	 * 
	 * @param airportCode
	 *            the airport code. It can't be empty.
	 * @param city
	 *            the city name. The city will be displayed over the airport
	 *            code in the template. It can't be empty.
	 * @param gate
	 *            the airport gate. This field is optional.
	 * @param terminal
	 *            the airport terminal. This field is optional.
	 * @return this builder.
	 */
	public FlightInfoExtendedBuilder setArrivalAirport(String airportCode,
			String city, String gate, String terminal) {
		Airport arrivalAirport = new Airport(airportCode, city, gate, terminal);
		this.flightInfo.setArrivalAirport(arrivalAirport);
		return this;
	}

	/**
	 * Sets the arrival {@link Airport} for the current
	 * {@link FlightInfoExtended} object. This field is mandatory for this
	 * object and can't be null.
	 * 
	 * @param airportCode
	 *            the airport code. It can't be empty.
	 * @param city
	 *            the city name. The city will be displayed over the airport
	 *            code in the template. It can't be empty.
	 * @return this builder.
	 */
	public FlightInfoExtendedBuilder setArrivalAirport(String airportCode,
			String city) {
		Airport arrivalAirport = new Airport(airportCode, city);
		this.flightInfo.setArrivalAirport(arrivalAirport);
		return this;
	}

	/**
	 * Sets the arrival {@link Airport} for the current
	 * {@link FlightInfoExtended} object. This field is mandatory for this
	 * object and can't be null.
	 * 
	 * @param airport
	 *            the arrival airport. It can't be null.
	 * @return this builder.
	 */
	public FlightInfoExtendedBuilder setArrivalAirport(Airport airport) {
		this.flightInfo.setArrivalAirport(airport);
		return this;
	}

	/**
	 * Sets the {@link FlightSchedule} object for the current
	 * {@link FlightInfoExtended} object. This field is mandatory for this
	 * object and can't be null.
	 * 
	 * @param departureTime
	 *            the departure time. It can't be null.
	 * @param arrivalTime
	 *            the arrival time. It can't be null.
	 * @return this builder.
	 */
	public FlightInfoExtendedBuilder setFlightSchedule(Calendar departureTime,
			Calendar arrivalTime) {
		FlightSchedule flightSchedule = new FlightSchedule(departureTime,
				arrivalTime);
		this.flightInfo.setFlightSchedule(flightSchedule);
		return this;
	}

	/**
	 * Sets the {@link FlightSchedule} object for the current
	 * {@link FlightInfoExtended} object. This field is mandatory for this
	 * object and can't be null.
	 * 
	 * @param departureTime
	 *            the departure time. It can't be null.
	 * @param arrivalTime
	 *            the arrival time. It can't be null.
	 * @param boardingTime
	 *            the boarding time. This field is optional.
	 * @return this builder.
	 */
	public FlightInfoExtendedBuilder setFlightSchedule(Calendar departureTime,
			Calendar arrivalTime, Calendar boardingTime) {
		FlightSchedule flightSchedule = new FlightSchedule(departureTime,
				arrivalTime, boardingTime);
		this.flightInfo.setFlightSchedule(flightSchedule);
		return this;
	}

	/**
	 * Sets the {@link FlightSchedule} object for the current
	 * {@link FlightInfoExtended} object. This field is mandatory for this
	 * object and can't be null.
	 * 
	 * @param flightSchedule
	 *            the flight schedule to set. It can't be null.
	 * @return this builder.
	 */
	public FlightInfoExtendedBuilder setFlightSchedule(
			FlightSchedule flightSchedule) {
		this.flightInfo.setFlightSchedule(flightSchedule);
		return this;
	}

	/**
	 * Sets the aircraft type for the current {@link FlightInfo} object. This
	 * field is optional.
	 * 
	 * @param aircraftType
	 *            the aircraft type.
	 * @return this builder.
	 */
	public FlightInfoExtendedBuilder setAircraftType(String aircraftType) {
		this.flightInfo.setAircraftType(aircraftType);
		return this;
	}

	/**
	 * Builds the current object, adds it to the parent builder and returns the
	 * parent builder.
	 * 
	 * @return the parent builder of this builder.
	 */
	public AirlineItineraryTemplateBuilder endFlightInfo() {
		parentBuilder.addFlightInfo(flightInfo);
		return parentBuilder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FlightInfoExtendedBuilder [parentBuilder=" + parentBuilder
				+ ", flightInfo=" + flightInfo + "]";
	}

}
