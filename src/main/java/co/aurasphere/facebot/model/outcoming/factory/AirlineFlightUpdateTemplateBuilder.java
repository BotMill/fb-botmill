package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.payload.template.airline.AirlineFlightUpdateTemplatePayload;
import co.aurasphere.facebot.model.outcoming.quickreply.QuickReply;
import co.aurasphere.facebot.model.outcoming.template.airline.FlightInfo;
import co.aurasphere.facebot.model.outcoming.template.airline.UpdateType;

/**
 * Builder for an Airline Flight Update Template.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/airline-itinerary-template"
 *      > Facebook's Messenger Platform Airline Itinerary Template
 *      Documentation</a>
 * 
 * @author Donato
 * @date 25/ago/2016
 */
public class AirlineFlightUpdateTemplateBuilder extends
		FlightInfoBuilderDelegator {

	/**
	 * The payload managed by this builder.
	 */
	private AirlineFlightUpdateTemplatePayload payload;

	/**
	 * Default constructor. Creates a builder for an Airline Flight Update
	 * Template.
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
	 * @param updateType
	 *            an {@link UpdateType} object that represents the kind of
	 *            status update of the flight. Can't be null.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/airline-update-template"
	 *      > Facebook's Messenger Platform Airline Flight Update Template
	 *      Documentation</a>
	 */
	AirlineFlightUpdateTemplateBuilder(String introMessage, String locale,
			String pnrNumber, UpdateType updateType) {
		this.payload = new AirlineFlightUpdateTemplatePayload(introMessage,
				locale, pnrNumber, updateType);
		this.messageBuilder = new AttachmentMessageBuilder(
				AttachmentType.TEMPLATE, this.payload);
	}

	/**
	 * Adds a {@link FlightInfo} object to this template. This object is
	 * mandatory and can't be null for Airline templates.
	 * 
	 * @param flightNumber
	 *            the flight number.
	 * @return a builder for the {@link FlightInfo} object.
	 */
	public FlightInfoBuilder<AirlineFlightUpdateTemplateBuilder> addFlightInfo(
			String flightNumber) {
		return new FlightInfoBuilder<AirlineFlightUpdateTemplateBuilder>(this,
				flightNumber);
	}

	/**
	 * Adds a {@link FlightInfo} object to this template. This object is
	 * mandatory and can't be null for Airline templates. Used only by delegated
	 * classes. Should not be called directly. Use
	 * {@link #addFlightInfo(String)} instead.
	 * 
	 * @param flightInfo
	 *            the {@link FlightInfo} object to add.
	 */
	@Override
	@Deprecated
	void addFlightInfo(FlightInfo flightInfo) {
		this.payload.setUpdateFlightInfo(flightInfo);
	}

	/**
	 * Sets the theme color for this template. This field is optional. If not
	 * specified, the template will use Facebook's default theme (light blue).
	 * 
	 * @param themeColor
	 *            the color for this template. The Color must be a valid RGB
	 *            color in the format #RRGGBB.
	 * 
	 * @return this builder.
	 */
	public AirlineFlightUpdateTemplateBuilder setThemeColor(String themeColor) {
		this.payload.setThemeColor(themeColor);
		return this;
	}

	/**
	 * Adds a {@link QuickReply} to the current object.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 * 
	 * @param title
	 *            the quick reply button label. It can't be empty.
	 * @param payload
	 *            the payload sent back when the button is pressed. It can't be
	 *            empty.
	 * @return this builder.
	 */
	public AirlineFlightUpdateTemplateBuilder addQuickReply(String title,
			String payload) {
		this.messageBuilder.addQuickReply(title, payload);
		return this;
	}

	/**
	 * Adds a {@link QuickReply} to the current object.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 * 
	 * @param reply
	 *            a quick reply object.
	 * @return this builder.
	 */
	public AirlineFlightUpdateTemplateBuilder addQuickReply(QuickReply reply) {
		this.messageBuilder.addQuickReply(reply);
		return this;
	}

	/**
	 * Builds the {@link FaceBotResponse} that the FaceBot should return. The
	 * template builders, like this, delegate an
	 * {@link AttachmentMessageBuilder} to build the message.
	 * 
	 * @param envelope
	 *            a {@link MessageEnvelope} object representing the incoming
	 *            message.
	 * @return the {@link FaceBotResponse} of this FaceBot.
	 */
	@Override
	public FaceBotResponse build(MessageEnvelope envelope) {
		return this.messageBuilder.build(envelope);
	}

}
