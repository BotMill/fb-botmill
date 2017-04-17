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
package co.aurasphere.botmill.fb.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.core.BotDefinition;
import co.aurasphere.botmill.fb.internal.util.network.FbBotMillNetworkController;
import co.aurasphere.botmill.fb.model.api.threadsettings.CallToActionsRequest;
import co.aurasphere.botmill.fb.model.api.threadsettings.DomainActionType;
import co.aurasphere.botmill.fb.model.api.threadsettings.ThreadState;
import co.aurasphere.botmill.fb.model.api.threadsettings.WhitelistDomainRequest;
import co.aurasphere.botmill.fb.model.api.threadsettings.greeting.SetGreetingTextRequest;
import co.aurasphere.botmill.fb.model.api.threadsettings.payment.PaymentDevModeAction;
import co.aurasphere.botmill.fb.model.api.threadsettings.payment.PaymentSettings;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.button.ButtonType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.BuyButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PaymentSummary;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PostbackButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.WebUrlButton;

/**
 * Class which handles the configuration of the Facebook Messenger Platform
 * Thread Settings (for more informations, see the link below). The methods of
 * this class needs to be called only once and thus shouldn't be put on the
 * class that implements {@link BotDefinition}. The best way of handling the
 * configuration would be defining your own class with a main method and put the
 * call on it.
 *
 * @author Donato Rimenti
 * @author Alvin Reyes
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Thread Settings Documentation</a>
 * @deprecated Use {@link MessengerProfileApi} instead.
 */
@Deprecated
public class ThreadSettingsApi {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ThreadSettingsApi.class);

	/**
	 * Instantiates a new ThreadSettingsApi.
	 */
	private ThreadSettingsApi() {
	}

	/**
	 * This method is used to add any payment settings needed.
	 * 
	 * @param paymentSettings
	 *            the payment settings object.
	 * @see <a
	 *      href="https://developers.facebook.com/docs/messenger-platform/thread-settings/payment"
	 *      >Payments settings</a>
	 */
	public static void addPaymentSettings(PaymentSettings paymentSettings) {
		if (paymentSettings == null) {
			logger.error("FbBotMill validation error: Payment Settings can't be null or empty!");
			return;
		}
		FbBotMillNetworkController.postThreadSetting(paymentSettings);
	}

	/**
	 * Sets the greeting message for the bot. The Greeting Text is only rendered
	 * the first time the user interacts with a the Page on Messenger.
	 *
	 * @param message
	 *            the greeting message to show.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/greeting-text"
	 *      >Facebook's Greeting Text Documentation</a>
	 */
	public static void setGreetingMessage(String message) {
		if (message == null || "".equals(message)) {
			logger.error("FbBotMill validation error: Greeting message can't be null or empty!");
			return;
		}
		SetGreetingTextRequest request = new SetGreetingTextRequest(message);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Sets the Get Started Button for the bot. The Get Started button is only
	 * rendered the first time the user interacts with a the Page on Messenger.
	 * When this button is tapped, the defined payload will be sent back with a
	 * postback received callback.
	 *
	 * @param payload
	 *            the payload to return when the button is tapped.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/get-started-button"
	 *      >Facebook's Get Started Button Documentation</a>
	 */
	public static void setGetStartedButton(String payload) {
		if (payload == null || "".equals(payload)) {
			logger.error("FbBotMill validation error: Get Started Button payload can't be null or empty!");
			return;
		}
		Button button = new PostbackButton(null, ButtonType.POSTBACK, payload);
		List<Button> buttonList = new ArrayList<Button>();
		buttonList.add(button);
		CallToActionsRequest request = new CallToActionsRequest(
				ThreadState.NEW_THREAD, buttonList);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Removes the current Get Started Button.
	 * 
	 * @see #setGetStartedButton(String)
	 */
	public static void deleteGetStartedButton() {
		CallToActionsRequest request = new CallToActionsRequest(
				ThreadState.NEW_THREAD, null);
		FbBotMillNetworkController.deleteThreadSetting(request);
	}

	/**
	 * Sets a Persistent Menu of buttons which is always available to the user.
	 * This menu should contain top-level actions that users can enact at any
	 * point. Having a persistent menu easily communicates the basic
	 * capabilities of your bot for first-time and returning users. The menu can
	 * be invoked by a user, by tapping on the 3-caret icon on the left of the
	 * composer.
	 *
	 * @param buttons
	 *            a list of {@link Button} (max 5 elements) to use as menu. The
	 *            buttons can only be {@link PostbackButton} or
	 *            {@link WebUrlButton}. Phone buttons are not supported.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/persistent-menu"
	 *      >Facebook's Persistent Menu Documentation</a>
	 */
	public static void setPersistentMenu(List<Button> buttons) {
		if (buttons == null || buttons.isEmpty() || buttons.size() > 5) {
			logger.error("FbBotMill validation error: Persistent Menu Buttons can't be null or empty and must be less than 5!");
			return;
		}
		CallToActionsRequest request = new CallToActionsRequest(
				ThreadState.EXISTING_THREAD, buttons);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Removes the current Persistent Menu.
	 * 
	 * @see #setPersistentMenu(List)
	 */
	public static void deletePersistentMenu() {
		CallToActionsRequest request = new CallToActionsRequest(
				ThreadState.EXISTING_THREAD, null);
		FbBotMillNetworkController.deleteThreadSetting(request);
	}

	/**
	 * Adds a list of domains that needs to be "white listed".
	 *
	 * @param whiteListDomains
	 *            the list of domains in String.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/domain-whitelisting"
	 *      >Facebook's Messenger Platform Domain Whitelisting Thread Settings
	 *      Documentation</a>
	 */
	public static void setWhiteListDomains(List<String> whiteListDomains) {
		WhitelistDomainRequest request = new WhitelistDomainRequest(
				whiteListDomains, DomainActionType.ADD);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Adds a single domain on the list of domains that needs to be
	 * "white listed".
	 *
	 * @param domain
	 *            the domain that needs to be "white listed".
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/domain-whitelisting"
	 *      >Facebook's Messenger Platform Domain Whitelisting Thread Settings
	 *      Documentation</a>
	 */
	public static void addWhiteListDomain(String domain) {
		WhitelistDomainRequest request = new WhitelistDomainRequest();
		request.addWhiteListedDomain(domain);
		request.setDomainActionType(DomainActionType.ADD);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Removes a single domain on the list of domains that needs to be
	 * "white listed".
	 *
	 * @param domain
	 *            the domain that needs to be removed.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/domain-whitelisting"
	 *      >Facebook's Messenger Platform Domain Whitelisting Thread Settings
	 *      Documentation</a>
	 */
	public static void deleteWhiteListDomain(String domain) {
		WhitelistDomainRequest request = new WhitelistDomainRequest();
		request.addWhiteListedDomain(domain);
		request.setDomainActionType(DomainActionType.REMOVE);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Removes a list of domains that are currently "white listed".
	 *
	 * @param whiteListDomains
	 *            the list of domains that needs to be removed.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/domain-whitelisting"
	 *      >Facebook's Messenger Platform Domain Whitelisting Thread Settings
	 *      Documentation</a>
	 */
	public static void deleteWhiteListDomains(List<String> whiteListDomains) {
		WhitelistDomainRequest request = new WhitelistDomainRequest(
				whiteListDomains, DomainActionType.REMOVE);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Adds a list of testers for payments. You can add payment test users so
	 * that their credit card won't be charged during your development. Once
	 * added, it will impact both Buy Button and Webview Extension integrations,
	 * any payment send to these users will be a dummy charge. If you are only
	 * testing {@link BuyButton}, consider using the
	 * {@link PaymentSummary#setTestPayment(boolean)} flag which is simpler for
	 * testing.
	 *
	 * @param paymentTestersIds
	 *            the testers app-scoped IDs to add to the testers list.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/payment"
	 *      >Facebook's Messenger Platform Payments Thread Settings
	 *      Documentation</a>
	 * @since 1.2.0
	 */
	public static void addPaymentsTesters(List<String> paymentTestersIds) {
		PaymentSettings request = new PaymentSettings();
		request.setPaymentTesters(paymentTestersIds);
		request.setPaymentDevModeAction(PaymentDevModeAction.ADD);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Adds a single tester for payments. You can add payment test users so that
	 * their credit card won't be charged during your development. Once added,
	 * it will impact both Buy Button and Webview Extension integrations, any
	 * payment send to these users will be a dummy charge. If you are only
	 * testing {@link BuyButton}, consider using the
	 * {@link PaymentSummary#setTestPayment(boolean)} flag which is simpler for
	 * testing.
	 *
	 * @param paymentTesterId
	 *            the tester app-scoped ID to add to the testers list.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/payment"
	 *      >Facebook's Messenger Platform Payments Thread Settings
	 *      Documentation</a>
	 * @since 1.2.0
	 */
	public static void addPaymentsTester(String paymentTesterId) {
		PaymentSettings request = new PaymentSettings();
		List<String> paymentTestersIds = new ArrayList<String>();
		request.setPaymentTesters(paymentTestersIds);
		request.setPaymentDevModeAction(PaymentDevModeAction.ADD);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Removes a single tester for payments. You can add payment test users so
	 * that their credit card won't be charged during your development. Once
	 * added, it will impact both Buy Button and Webview Extension integrations,
	 * any payment send to these users will be a dummy charge. If you are only
	 * testing {@link BuyButton}, consider using the
	 * {@link PaymentSummary#setTestPayment(boolean)} flag which is simpler for
	 * testing.
	 *
	 * @param paymentTesterId
	 *            the tester app-scoped ID to remove from the testers list.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/payment"
	 *      >Facebook's Messenger Platform Payments Thread Settings
	 *      Documentation</a>
	 * @since 1.2.0
	 */
	public static void removePaymentsTester(String paymentTesterId) {
		PaymentSettings request = new PaymentSettings();
		List<String> paymentTestersIds = new ArrayList<String>();
		request.setPaymentTesters(paymentTestersIds);
		request.setPaymentDevModeAction(PaymentDevModeAction.REMOVE);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Removes a list of testers for payments. You can add payment test users so
	 * that their credit card won't be charged during your development. Once
	 * added, it will impact both Buy Button and Webview Extension integrations,
	 * any payment send to these users will be a dummy charge. If you are only
	 * testing {@link BuyButton}, consider using the
	 * {@link PaymentSummary#setTestPayment(boolean)} flag which is simpler for
	 * testing.
	 *
	 * @param paymentTestersIds
	 *            the testers app-scoped IDs to remove from the testers list.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/payment"
	 *      >Facebook's Messenger Platform Payments Thread Settings
	 *      Documentation</a>
	 * @since 1.2.0
	 */
	public static void removePaymentsTesters(List<String> paymentTestersIds) {
		PaymentSettings request = new PaymentSettings();
		request.setPaymentTesters(paymentTestersIds);
		request.setPaymentDevModeAction(PaymentDevModeAction.REMOVE);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Sets the payment public key. The payment_public_key is used to encrypt
	 * sensitive payment data sent to you.
	 *
	 * @param publicKey
	 *            the public key to set.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/payment"
	 *      >Facebook's Messenger Platform Payments Thread Settings
	 *      Documentation</a>
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/payments-reference#encryption_key"
	 *      >Facebook's Messenger Platform Creating Encryption Documentation</a>
	 * @since 1.2.0
	 */
	public static void setPaymentsPublicKey(String publicKey) {
		PaymentSettings request = new PaymentSettings();
		request.setPrivacyUrl(publicKey);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/**
	 * Sets the payment privacy Url. The payment_privacy_url will appear in
	 * Facebook's payment dialogs and people will be able to view these terms.
	 *
	 * @param privacyUrl
	 *            the privacy Url to set.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/payment"
	 *      >Facebook's Messenger Platform Payments Thread Settings
	 *      Documentation</a>
	 * @since 1.2.0
	 */
	public static void setPaymentsPrivacyUrl(String privacyUrl) {
		PaymentSettings request = new PaymentSettings();
		request.setPrivacyUrl(privacyUrl);
		FbBotMillNetworkController.postThreadSetting(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillThreadSettingsConfiguration []";
	}

}
