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
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.action.TypingAction;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.UpdateType;

/**
 * Static class that allows the creation of a {@link FbBotMillResponse}.
 * 
 * @author Donato Rimenti
 */
public class ReplyFactory {

	/**
	 * Instantiates a new ReplyFactory.
	 */
	private ReplyFactory() {
	}

	/**
	 * Adds a {@link TypingAction} to the response.
	 *
	 * @param action
	 *            the action to add. Can't be null.
	 * @return a builder for that action.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/sender-actions"
	 *      > Facebook's Messenger Platform Sender Actions Documentation</a>
	 */
	public static ActionResponseBuilder addTypingAction(TypingAction action) {
		return new ActionResponseBuilder(action);
	}

	/**
	 * Adds a Button Template to the response.
	 *
	 * @param message
	 *            the message of the Button Template.
	 * @return a builder for the template.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/button-template"
	 *      > Facebook's Messenger Platform Button Template Documentation</a>
	 */
	public static ButtonTemplateBuilder addButtonTemplate(String message) {
		return new ButtonTemplateBuilder(message);
	}

	/**
	 * Adds a Generic Template to the response.
	 *
	 * @return a builder for the template.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/generic-template"
	 *      > Facebook's Messenger Platform Generic Template Documentation</a>
	 */
	public static GenericTemplateBuilder addGenericTemplate() {
		return new GenericTemplateBuilder();
	}

	/**
	 * Adds a List Template to the response.
	 *
	 * @return a builder for the template.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/list-template"
	 *      > Facebook's Messenger Platform List Template Documentation</a>
	 */
	public static ListTemplateBuilder addListTemplate() {
		return new ListTemplateBuilder();
	}

	/**
	 * Creates a response which contains only a text message.
	 *
	 * @param message
	 *            the message to create.
	 * @return a builder for the response.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/text-message"
	 *      > Facebook's Messenger Platform Text Message Documentation</a>
	 */
	public static TextMessageBuilder addTextMessageOnly(String message) {
		return new TextMessageBuilder(message);
	}

	/**
	 * Adds an image attachment to the response.
	 *
	 * @param url
	 *            the url of the image to attach.
	 * @return a builder for the response.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/image-attachment"
	 *      > Facebook's Messenger Platform Image Attachment Documentation</a>
	 */
	public static AttachmentMessageBuilder addImageAttachment(String url) {
		return new AttachmentMessageBuilder(AttachmentType.IMAGE, url);
	}

	/**
	 * Adds an audio attachment to the response.
	 *
	 * @param url
	 *            the url of the audio to attach.
	 * @return a builder for the response.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/audio-attachment"
	 *      > Facebook's Messenger Platform Audio Attachment Documentation</a>
	 */
	public static AttachmentMessageBuilder addAudioAttachment(String url) {
		return new AttachmentMessageBuilder(AttachmentType.AUDIO, url);
	}

	/**
	 * Adds a video attachment to the response.
	 *
	 * @param url
	 *            the url of the video to attach.
	 * @return a builder for the response.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/video-attachment"
	 *      > Facebook's Messenger Platform Video Attachment Documentation</a>
	 */
	public static AttachmentMessageBuilder addVideoAttachment(String url) {
		return new AttachmentMessageBuilder(AttachmentType.VIDEO, url);
	}

	/**
	 * Adds a file attachment to the response.
	 *
	 * @param url
	 *            the url of the file to attach.
	 * @return a builder for the response.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/file-attachment"
	 *      > Facebook's Messenger Platform File Attachment Documentation</a>
	 */
	public static AttachmentMessageBuilder addFileAttachment(String url) {
		return new AttachmentMessageBuilder(AttachmentType.FILE, url);
	}

	/**
	 * Adds a Receipt Template to the response.
	 *
	 * @param recipientName
	 *            the recipient's name.
	 * @param orderNumber
	 *            the order number.Must be unique for each user.
	 * @param currency
	 *            the currency for the price. It can't be empty. The currency
	 *            must be a three digit ISO-4217-3 code in format [A-Z]{3}. For
	 *            more information see <a href=
	 *            "https://developers.facebook.com/docs/payments/reference/supportedcurrencies"
	 *            > Facebook's currency support</a>
	 * @param paymentMethod
	 *            the payment method details. This can be a custom string. ex:
	 *            "Visa 1234". You may insert an arbitrary string here but we
	 *            recommend providing enough information for the person to
	 *            decipher which payment method and account they used (e.g., the
	 *            name of the payment method and partial account number).
	 * @return a builder for the response.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/receipt-template"
	 *      > Facebook's Messenger Receipt Template Documentation</a>
	 */
	public static ReceiptTemplateBuilder addAirlineItineraryTemplate(
			String recipientName, String orderNumber, String currency,
			String paymentMethod) {
		return new ReceiptTemplateBuilder(recipientName, orderNumber, currency,
				paymentMethod);
	}

	/**
	 * Adds an Airline Itinerary Template to the response.
	 *
	 * @param introMessage
	 *            the message to send before the template. It can't be empty.
	 * @param locale
	 *            the current locale. It can't be empty and must be in format
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
	 *            the currency for the price. It can't be empty. The currency
	 *            must be a three digit ISO-4217-3 code in format [A-Z]{3}. For
	 *            more information see <a href=
	 *            "https://developers.facebook.com/docs/payments/reference/supportedcurrencies"
	 *            > Facebook's currency support</a>
	 * @return a builder for the response.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/airline-itinerary-template"
	 *      > Facebook's Messenger Platform Airline Itinerary Template
	 *      Documentation</a>
	 */
	public static AirlineItineraryTemplateBuilder addAirlineItineraryTemplate(
			String introMessage, String locale, String pnrNumber,
			BigDecimal totalPrice, String currency) {
		return new AirlineItineraryTemplateBuilder(introMessage, locale,
				pnrNumber, totalPrice, currency);
	}

	/**
	 * Adds an Airline Checkin Template to the response.
	 *
	 * @param introMessage
	 *            the message to send before the template. It can't be empty.
	 * @param locale
	 *            the current locale. It can't be empty and must be in format
	 *            [a-z]{2}_[A-Z]{2}. Locale must be in format [a-z]{2}_[A-Z]{2}.
	 *            For more information see<a href=
	 *            "https://developers.facebook.com/docs/internationalization#locales"
	 *            > Facebook's locale support</a>.
	 * @param pnrNumber
	 *            the Passenger Name Record number (Booking Number). It can't be
	 *            empty.
	 * @param checkinUrl
	 *            the url for the checkin. It can't be empty.
	 * @return a builder for the response.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/airline-checkin-template"
	 *      > Facebook's Messenger Platform Airline Checkin Template
	 *      Documentation</a>
	 */
	public static AirlineCheckinTemplateBuilder addAirlineCheckinTemplate(
			String introMessage, String locale, String pnrNumber,
			String checkinUrl) {
		return new AirlineCheckinTemplateBuilder(introMessage, locale,
				pnrNumber, checkinUrl);
	}

	/**
	 * Adds an Airline Boarding Pass Template to the response.
	 *
	 * @param introMessage
	 *            the message to send before the template. It can't be empty.
	 * @param locale
	 *            the current locale. It can't be empty and must be in format
	 *            [a-z]{2}_[A-Z]{2}. Locale must be in format [a-z]{2}_[A-Z]{2}.
	 *            For more information see<a href=
	 *            "https://developers.facebook.com/docs/internationalization#locales"
	 *            > Facebook's locale support</a>.
	 * @return a builder for the response.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/airline-boardingpass-template"
	 *      > Facebook's Messenger Platform Airline Boarding Pass Template
	 *      Documentation</a>
	 */
	public static AirlineBoardingPassTemplateBuilder addAirlineBoardingPassTemplate(
			String introMessage, String locale) {
		return new AirlineBoardingPassTemplateBuilder(introMessage, locale);
	}

	/**
	 * Adds an Airline Flight Update Template to the response.
	 *
	 * @param introMessage
	 *            the message to send before the template. It can't be empty.
	 * @param locale
	 *            the current locale. It can't be empty and must be in format
	 *            [a-z]{2}_[A-Z]{2}. Locale must be in format [a-z]{2}_[A-Z]{2}.
	 *            For more information see<a href=
	 *            "https://developers.facebook.com/docs/internationalization#locales"
	 *            > Facebook's locale support</a>.
	 * @param pnrNumber
	 *            the Passenger Name Record number (Booking Number). It can't be
	 *            empty.
	 * @param updateType
	 *            an {@link UpdateType} object that represents the kind of
	 *            status update of the flight. It can't be null.
	 * @return a builder for the response.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/airline-update-template"
	 *      > Facebook's Messenger Platform Airline Flight Update Template
	 *      Documentation</a>
	 */
	public static AirlineFlightUpdateTemplateBuilder addAirlineFlightUpdateTemplate(
			String introMessage, String locale, String pnrNumber,
			UpdateType updateType) {
		return new AirlineFlightUpdateTemplateBuilder(introMessage, locale,
				pnrNumber, updateType);
	}

	/**
	 * Adds a Receipt Template to the response.
	 *
	 * @param recipientName
	 *            the recipient name. It can't be empty.
	 * @param orderNumber
	 *            the order number. It can't be empty and it must be unique for
	 *            each user.
	 * @param currency
	 *            the currency for order. It can't be empty.
	 * @param paymentMethod
	 *            the payment method details. This can be a custom string. ex:
	 *            "Visa 1234". You may insert an arbitrary string here but we
	 *            recommend providing enough information for the person to
	 *            decipher which payment method and account they used (e.g., the
	 *            name of the payment method and partial account number). It
	 *            can't be empty.
	 * @return a builder for the response.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/receipt-template"
	 *      > Facebook's Messenger Platform Receipt Template Documentation</a>
	 */
	public static ReceiptTemplateBuilder addReceiptTemplate(
			String recipientName, String orderNumber, String currency,
			String paymentMethod) {
		return new ReceiptTemplateBuilder(recipientName, orderNumber, currency,
				paymentMethod);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReplyFactory []";
	}

}
