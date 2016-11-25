package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.outcoming.template.button.Button;
import co.aurasphere.facebot.model.outcoming.template.button.ButtonType;
import co.aurasphere.facebot.model.outcoming.template.button.PostbackButton;
import co.aurasphere.facebot.model.outcoming.template.button.WebUrlButton;

/**
 * Factory class for building {@link Button} objects.
 * 
 * @author Donato
 * @date 26/ago/2016
 */
public class ButtonFactory {

	/**
	 * Creates a button which redirects to an URL when clicked.
	 * 
	 * @param title
	 *            the button label.
	 * @param url
	 *            the URL to whom redirect when clicked.
	 * @return a {@link WebUrlButton}.
	 */
	public static Button createUrlButton(String title, String url) {
		return new WebUrlButton(title, url);
	}

	/**
	 * Creates a button which sends a payload back when clicked.
	 * 
	 * @param title
	 *            the button label.
	 * @param payload
	 *            the payload to send back when clicked.
	 * @return a {@link PostbackButton}.
	 */
	public static Button createPostbackButton(String title, String payload) {
		return new PostbackButton(title, ButtonType.POSTBACK, payload);
	}

	/**
	 * Creates a button with a phone number.
	 * 
	 * @param title
	 *            the button label.
	 * @param phoneNumber
	 *            a phone number. Must be in the format '+' prefix followed by
	 *            the country code, area code and local number.
	 * @return a {@link PostbackButton}.
	 */
	public static Button createPhoneNumberButton(String title,
			String phoneNumber) {
		return new PostbackButton(title, ButtonType.PHONE_NUMBER, phoneNumber);
	}
}
