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

import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.AirlineBoardingPassTemplatePayload;
import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.BoardingPass;

/**
 * A builder for an Airline Boarding Pass Template.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/airline-boardingpass-template"
 *      > Facebook's Messenger Platform Airline Boarding Pass Template
 *      Documentation</a>
 * 
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
	 * @param title
	 *            the quick reply button label. It can't be empty.
	 * @param payload
	 *            the payload sent back when the button is pressed. It can't be
	 *            empty.
	 * @return this builder.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 */
	public AirlineBoardingPassTemplateBuilder addQuickReply(String title,
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
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 */
	public AirlineBoardingPassTemplateBuilder addQuickReply(QuickReply reply) {
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
		return "AirlineBoardingPassTemplateBuilder [payload=" + payload
				+ ", messageBuilder=" + messageBuilder + "]";
	}

}
