package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.payload.template.airline.AirlineBoardingPassTemplatePayload;
import co.aurasphere.facebot.model.outcoming.quickreply.QuickReply;
import co.aurasphere.facebot.model.outcoming.template.airline.BoardingPass;

/**
 * A builder for an Airline Boarding Pass Template.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/airline-boardingpass-template"
 *      > Facebook's Messenger Platform Airline Boarding Pass Template
 *      Documentation</a>
 * 
 * @author Donato
 * @date 25/ago/2016
 */
public class AirlineBoardingPassTemplateBuilder extends
		AirlineBaseTemplateBuilder {

	/**
	 * The payload of the current builder.
	 */
	private AirlineBoardingPassTemplatePayload payload;

	/**
	 * Default constructor. Creates a builder for an Airline Boarding Pass
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
	 *            
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/airline-boardingpass-template"
	 *      > Facebook's Messenger Platform Airline Boarding Pass Template
	 *      Documentation</a>
	 */
	AirlineBoardingPassTemplateBuilder(String introMessage, String locale) {
		this.payload = new AirlineBoardingPassTemplatePayload(introMessage,
				locale);
		this.messageBuilder = new AttachmentMessageBuilder(
				AttachmentType.TEMPLATE, this.payload);
	}

	/**
	 * Adds a {@link BoardingPass} object to this template. This field is
	 * mandatory for this template and should contain at least one element.
	 * 
	 * @param passengerName
	 *            the passenger name. It can't be empty.
	 * @param pnrNumber
	 *            the Passenger Name Record number (Booking Number). It can't be
	 *            empty.
	 * @param logoImageUrl
	 *            the URL of the logo. It can't be empty.
	 * @param aboveBarCodeImageUrl
	 *            the URL of the image to be shown above the bar code in the
	 *            center of the pass. It can't be empty.
	 * @return a builder for a {@link BoardingPass} object.
	 */
	public BoardingPassBuilder addBoardingPass(String passengerName,
			String pnrNumber, String logoImageUrl, String aboveBarCodeImageUrl) {
		return new BoardingPassBuilder(this, passengerName, pnrNumber,
				logoImageUrl, aboveBarCodeImageUrl);
	}

	/**
	 * Adds a {@link BoardingPass} object to this template. This field is
	 * mandatory for this template and should contain at least one element.
	 * 
	 * @param boardingPass
	 *            the boarding pass object to add. It can't be null.
	 * @return this builder.
	 */
	public AirlineBoardingPassTemplateBuilder addBoardingPass(
			BoardingPass boardingPass) {
		this.payload.addBoardingPass(boardingPass);
		return this;
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
	public AirlineBoardingPassTemplateBuilder setThemeColor(String themeColor) {
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
	public AirlineBoardingPassTemplateBuilder addQuickReply(String title,
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
	public AirlineBoardingPassTemplateBuilder addQuickReply(QuickReply reply) {
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
