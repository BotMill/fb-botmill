package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.button.ButtonType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.BuyButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.LoginButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.LogoutButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PaymentSummary;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PostbackButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.ShareButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.WebUrlButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.WebViewHeightRatioType;
import co.aurasphere.botmill.fb.model.outcoming.template.list.DefaultAction;


/**
 * Factory class for building {@link Button} objects.
 * 
 * @author Donato Rimenti
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
	 * Creates a default action button (based on Web URL) for list template.
	 * 
	 * @param url
	 *            the redirect URL.
	 * @return a {@link DefaultAction}.
	 */
	public static DefaultAction createDefaultActionButton(String url) {
		return new DefaultAction(ButtonType.WEB_URL, url);
	}

	/**
	 * Creates a web view button.
	 *
	 * @param title            the button label.
	 * @param url            the URL to whom redirect when clicked.
	 * @param ratioType            the web view ratio type.
	 * @return the button
	 */
	public static Button createWebViewButton(String title, String url,
			WebViewHeightRatioType ratioType) {
		return new WebUrlButton(title, url, ratioType);
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

	/**
	 * Creates a default action (which is based off from Url Button) which
	 * redirects to an URL when clicked.
	 * 
	 * @return a {@link Button}.
	 */
	public static Button createShareButton() {
		return new ShareButton(ButtonType.ELEMENT_SHARE);
	}

	/**
	 * Creates a new Button object.
	 *
	 * @param type            the button type
	 * @param title            the label of the button
	 * @param payload            the payload data
	 * @param paymentSummary            the payment summary that will be displayed.
	 * @return a {@link Button}
	 */
	public static Button createBuyButton(ButtonType type, String title,
			String payload, PaymentSummary paymentSummary) {
		return new BuyButton(ButtonType.PAYMENT, title, payload, paymentSummary);
	}

	/**
	 * Creates a login button (which is based off from Url Button) which
	 * redirects to an URL when clicked.
	 * 
	 * @param url
	 *            the url on which the user will be authenticated.
	 * @return a {@link Button}
	 */
	public static Button createLoginButton(String url) {
		return new LoginButton(ButtonType.ACCOUNT_LINK, url);
	}

	/**
	 * Creates a logout button which redirects to an URL when clicked.
	 * 
	 * @return a {@link Button}.
	 */
	public static Button createLogoutButton() {
		return new LogoutButton(ButtonType.ACCOUNT_UNLINK);
	}
}
