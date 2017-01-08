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

import java.math.BigDecimal;

import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.AirlineItineraryTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.FlightInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.FlightInfoExtended;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.PassengerInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.PassengerSegmentInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.PriceInfo;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.TravelClass;

/**
 * Builder for an Airline Itinerary Template.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/airline-itinerary-template"
 *      > Facebook's Messenger Platform Airline Itinerary Template
 *      Documentation</a>
 * 
 */
public class AirlineItineraryTemplateBuilder extends FlightInfoBuilderDelegator {

	/**
	 * The payload managed by this builder.
	 */
	private AirlineItineraryTemplatePayload payload;

	/**
	 * Default constructor. Creates a builder for an Airline Itinerary Template.
	 * 
	 * @param introMessage
	 *            the message to send before the template. Can't be empty.
	 * @param locale
	 *            the current locale. Can't be empty and must be in format
	 *            [a-z]{2}_[A-Z]{2}. Locale must be in format [a-z]{2}_[A-Z]{2}.
	 *            For more information see<a href=
	 *            "https://developers.facebook.com/docs/internationalization#locales"
	 *            > Facebook's locale support</a>.
	 * @param pnrNumber
	 *            the Passenger Name Record number (Booking Number). It can't be
	 *            empty.
	 * @param totalPrice
	 *            the total price of the itinerary.
	 * @param currency
	 *            the currency for the price. Currency must be a three digit
	 *            ISO-4217-3 code in format [A-Z]{3}. For more information see
	 *            <a href=
	 *            "https://developers.facebook.com/docs/payments/reference/supportedcurrencies"
	 *            > Facebook's currency support</a>
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/airline-itinerary-template"
	 *      > Facebook's Messenger Platform Airline Itinerary Template
	 *      Documentation</a>
	 */
	AirlineItineraryTemplateBuilder(String introMessage, String locale,
			String pnrNumber, BigDecimal totalPrice, String currency) {
		this.payload = new AirlineItineraryTemplatePayload(introMessage,
				locale, pnrNumber, totalPrice, currency);
		this.messageBuilder = new AttachmentMessageBuilder(
				AttachmentType.TEMPLATE, this.payload);
	}

	/**
	 * Sets the tax amount for this itinerary. This field is optional.
	 * 
	 * @param tax
	 *            the tax amount.
	 * @return this builder.
	 */
	public AirlineItineraryTemplateBuilder setTax(BigDecimal tax) {
		this.payload.setTax(tax);
		return this;
	}

	/**
	 * Sets the base price for this itinerary. This field is optional.
	 * 
	 * @param basePrice
	 *            the base price.
	 * @return this builder.
	 */
	public AirlineItineraryTemplateBuilder setBasePrice(BigDecimal basePrice) {
		this.payload.setBasePrice(basePrice);
		return this;
	}

	/**
	 * Adds a {@link PassengerInfo} object to this template. This field is
	 * mandatory for this template. There must be at least one element.
	 * 
	 * @param passengerId
	 *            the passenger ID. It can't be empty.
	 * @param name
	 *            the passenger name. It can't be empty.
	 * @param ticketNumber
	 *            the ticket number. This field is optional.
	 * @return this builder.
	 */
	public AirlineItineraryTemplateBuilder addPassengerInfo(String passengerId,
			String name, String ticketNumber) {
		PassengerInfo passengerInfo = new PassengerInfo(passengerId, name,
				ticketNumber);
		this.payload.addPassengerInfo(passengerInfo);
		return this;
	}

	/**
	 * Adds a {@link PassengerInfo} object to this template. This field is
	 * mandatory for this template. There must be at least one element.
	 * 
	 * @param passengerId
	 *            the passenger ID. It can't be empty.
	 * @param name
	 *            the passenger name. It can't be empty.
	 * @return this builder.
	 */
	public AirlineItineraryTemplateBuilder addPassengerInfo(String passengerId,
			String name) {
		PassengerInfo passengerInfo = new PassengerInfo(passengerId, name);
		this.payload.addPassengerInfo(passengerInfo);
		return this;
	}

	/**
	 * Adds a {@link PassengerInfo} object to this template. This field is
	 * mandatory for this template. There must be at least one element.
	 *
	 * @param passengerInfo
	 *            the passenger info
	 * @return this builder.
	 */
	public AirlineItineraryTemplateBuilder addPassengerInfo(
			PassengerInfo passengerInfo) {
		this.payload.addPassengerInfo(passengerInfo);
		return this;
	}

	/**
	 * Adds a {@link PassengerSegmentInfo} object to this template. This field
	 * is mandatory for this template. There must be at least one element.
	 *
	 * @param segmentId
	 *            used to identify a flight segment. It can't be empty and must
	 *            be unique within the itinerary.
	 * @param passengerId
	 *            the passengerId of {@link PassengerInfo} object. It can't be
	 *            empty and it must match an actual passenger.
	 * @param seat
	 *            the seat number for the passenger. It can't be empty.
	 * @param seatType
	 *            the seat type for the passenger (e.g. Economy comfort). It
	 *            can't be empty.
	 * @return the passenger segment info builder
	 */
	public PassengerSegmentInfoBuilder addPassengerSegmentInfo(
			String segmentId, String passengerId, String seat, String seatType) {
		return new PassengerSegmentInfoBuilder(this, segmentId, passengerId,
				seat, seatType);
	}

	/**
	 * Adds a {@link PassengerSegmentInfo} object to this template. This field
	 * is mandatory for this template. There must be at least one element.
	 * 
	 * @param segmentInfo
	 *            the segment info to add.
	 * @return this builder.
	 */
	public AirlineItineraryTemplateBuilder addPassengerSegmentInfo(
			PassengerSegmentInfo segmentInfo) {
		this.payload.addPassengerSegmentInfo(segmentInfo);
		return this;
	}

	/**
	 * Adds a {@link PriceInfo} object to this template. This field is optional.
	 * There can be at most 4 price info objects per template.
	 * 
	 * @param title
	 *            the price info title. It can't be empty.
	 * @param amount
	 *            the price amount.
	 * @return this builder.
	 */
	public AirlineItineraryTemplateBuilder addPriceInfo(String title,
			BigDecimal amount) {
		PriceInfo priceInfo = new PriceInfo(title, amount);
		this.payload.addPriceInfo(priceInfo);
		return this;
	}

	/**
	 * Adds a {@link PriceInfo} object to this template. This field is optional.
	 * There can be at most 4 price info objects per template.
	 * 
	 * @param title
	 *            the price info title. It can't be empty.
	 * @param amount
	 *            the price amount.
	 * @param currency
	 *            the pricing currency. This field is optional. Currency must be
	 *            a three digit ISO-4217-3 code in format [A-Z]{3}. For more
	 *            information see<a href=
	 *            "https://developers.facebook.com/docs/payments/reference/supportedcurrencies"
	 *            > Facebook's currency support</a>
	 * @return this builder.
	 */
	public AirlineItineraryTemplateBuilder addPriceInfo(String title,
			BigDecimal amount, String currency) {
		PriceInfo priceInfo = new PriceInfo(title, amount, currency);
		this.payload.addPriceInfo(priceInfo);
		return this;
	}

	/**
	 * Adds a {@link PriceInfo} object to this template. This field is optional.
	 * There can be at most 4 price info objects per template.
	 * 
	 * @param priceInfo
	 *            the price info object to add.
	 * @return this builder.
	 */
	public AirlineItineraryTemplateBuilder addPriceInfo(PriceInfo priceInfo) {
		this.payload.addPriceInfo(priceInfo);
		return this;
	}

	/**
	 * Adds a {@link FlightInfoExtended} object to this template. This object is
	 * mandatory and can't be null for Airline templates. There can be multiple
	 * flight info object but there must be at least one.
	 * 
	 * @param flightNumber
	 *            the flight number. It can't be empty.
	 * @param connectionId
	 *            the connection ID, used to group together segments. It can't
	 *            be empty.
	 * @param segmentId
	 *            the segment ID. It must match the segment ID.
	 * @param travelClass
	 *            the travel class. It can't be null.
	 * @return a builder for the {@link FlightInfoExtended} object.
	 */
	public FlightInfoExtendedBuilder addFlightInfo(String flightNumber,
			String connectionId, String segmentId, TravelClass travelClass) {
		return new FlightInfoExtendedBuilder(this, flightNumber, connectionId,
				segmentId, travelClass);
	}

	/**
	 * Adds a {@link FlightInfoExtended} object to this template. This object is
	 * mandatory and can't be null for Airline templates. There can be multiple
	 * flight info object but there must be at least one.
	 * 
	 * @param flightInfo
	 *            the flight info to add.
	 * @return this builder.
	 */
	public AirlineItineraryTemplateBuilder addFlightInfo(
			FlightInfoExtended flightInfo) {
		this.payload.addFlightInfo(flightInfo);
		return this;
	}

	/**
	 * Adds a {@link FlightInfo} object to this template. This object is
	 * mandatory and can't be null for Airline templates. Used only by delegated
	 * classes. Should not be called directly. Use
	 * {@link #addFlightInfo(FlightInfoExtended)} instead.
	 * 
	 * @param flightInfo
	 *            the {@link FlightInfo} object to add.
	 */
	@Override
	@Deprecated
	void addFlightInfo(FlightInfo flightInfo) {
		addFlightInfo(flightInfo);
	}

	/**
	 * Sets the theme color for this template. This field is optional. If not
	 * specified, the template will use Facebook's default theme (light blue).
	 * 
	 * @param themeColor
	 *            the color for this template. The Color must be a valid RGB
	 *            color in the format #RRGGBB.
	 * @return this builder.
	 */
	public AirlineItineraryTemplateBuilder setThemeColor(String themeColor) {
		this.payload.setThemeColor(themeColor);
		return this;
	}

	/**
	 * Adds a {@link QuickReply} to the current object.
	 *
	 * @param title
	 *            the quick reply button label. It can't be empty.
	 * @param payload
	 *            the payload sent back when the button is pressed. It can't be
	 *            empty.
	 * @return this builder.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      >Facebook's Messenger Platform Quick Replies Documentation</a>
	 */
	public AirlineItineraryTemplateBuilder addQuickReply(String title,
			String payload) {
		this.messageBuilder.addQuickReply(title, payload);
		return this;
	}

	/**
	 * Adds a {@link QuickReply} to the current object.
	 *
	 * @param reply
	 *            a quick reply object.
	 * @return this builder.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      >Facebook's Messenger Platform Quick Replies Documentation</a>
	 */
	public AirlineItineraryTemplateBuilder addQuickReply(QuickReply reply) {
		this.messageBuilder.addQuickReply(reply);
		return this;
	}

	/**
	 * Builds the {@link FbBotMillResponse} that the bot should return. The
	 * template builders, like this, delegate an
	 * {@link AttachmentMessageBuilder} to build the message.
	 * 
	 * @param envelope
	 *            a {@link MessageEnvelope} object representing the incoming
	 *            message.
	 * @return the {@link FbBotMillResponse} of this bot.
	 */
	@Override
	public FbBotMillResponse build(MessageEnvelope envelope) {
		return this.messageBuilder.build(envelope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.factory.AirlineBaseTemplateBuilder
	 * #toString()
	 */
	@Override
	public String toString() {
		return "AirlineItineraryTemplateBuilder [payload=" + payload
				+ ", messageBuilder=" + messageBuilder + "]";
	}

}
