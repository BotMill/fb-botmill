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
 */
public class ButtonFactory {

	/**
	 * Instantiates a new ButtonFactory.
	 */
	private ButtonFactory() {
	}

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
		return new DefaultAction(url);
	}

	/**
	 * Creates a web view button.
	 *
	 * @param title
	 *            the button label.
	 * @param url
	 *            the URL to whom redirect when clicked.
	 * @param ratioType
	 *            the web view ratio type.
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
		return new ShareButton();
	}

	/**
	 * Creates a new {@link BuyButton} object.
	 *
	 * @param payload
	 *            the payload data
	 * @param paymentSummary
	 *            the payment summary that will be displayed.
	 * @return a {@link Button}
	 */
	public static Button createBuyButton(String payload,
			PaymentSummary paymentSummary) {
		return new BuyButton(payload, paymentSummary);
	}

	/**
	 * Creates a new {@link BuyButton} object.
	 *
	 * @param payload
	 *            the payload data.
	 * @return a builder for the {@link BuyButton}.
	 */
	public static BuyButtonBuilder createBuyButton(String payload) {
		return new BuyButtonBuilder(payload);
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
		return new LoginButton(url);
	}

	/**
	 * Creates a logout button which redirects to an URL when clicked.
	 * 
	 * @return a {@link Button}.
	 */
	public static Button createLogoutButton() {
		return new LogoutButton();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ButtonFactory []";
	}
}
