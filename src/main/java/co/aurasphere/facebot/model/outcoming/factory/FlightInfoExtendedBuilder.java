package co.aurasphere.facebot.model.outcoming.factory;

import java.util.Calendar;

import co.aurasphere.facebot.model.outcoming.template.airline.Airport;
import co.aurasphere.facebot.model.outcoming.template.airline.FlightInfo;
import co.aurasphere.facebot.model.outcoming.template.airline.FlightInfoExtended;
import co.aurasphere.facebot.model.outcoming.template.airline.FlightSchedule;
import co.aurasphere.facebot.model.outcoming.template.airline.PassengerSegmentInfo;
import co.aurasphere.facebot.model.outcoming.template.airline.TravelClass;

/**
 * Builder for a {@link FlightInfoExtended} object.
 * 
 * @author Donato
 * @date 25/ago/2016
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
	 * Sets the {@FlightSchedule} object for the current
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
	 * Sets the {@FlightSchedule} object for the current
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
	 * Sets the {@FlightSchedule} object for the current
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

}
