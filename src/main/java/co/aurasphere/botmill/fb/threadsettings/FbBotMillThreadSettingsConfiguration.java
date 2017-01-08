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
package co.aurasphere.botmill.fb.threadsettings;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.fb.FbBotDefinition;
import co.aurasphere.botmill.fb.internal.util.network.NetworkUtils;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PostbackButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.WebUrlButton;
import co.aurasphere.botmill.fb.model.threadsettings.CallToActionsRequest;
import co.aurasphere.botmill.fb.model.threadsettings.DomainActionType;
import co.aurasphere.botmill.fb.model.threadsettings.ThreadState;
import co.aurasphere.botmill.fb.model.threadsettings.WhitelistDomainRequest;
import co.aurasphere.botmill.fb.model.threadsettings.greeting.SetGreetingTextRequest;
import co.aurasphere.botmill.fb.model.threadsettings.payment.PaymentSettings;

/**
 * Class which handles the configuration of the Facebook Messenger Platform
 * Thread Settings (for more informations, see the link below). The methods of
 * this class needs to be called only once and thus shouldn't be put on the
 * class that implements {@link FbBotDefinition}. The best way of handling the
 * configuration would be defining your own class with a main method and put the
 * call on it.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Thread Settings Documentation</a>
 */
public class FbBotMillThreadSettingsConfiguration {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(FbBotMillThreadSettingsConfiguration.class);

	/**
	 * Instantiates a new FbBotMillThreadSettingsConfiguration.
	 */
	private FbBotMillThreadSettingsConfiguration() {
	}

	/**
	 * This method is used to add any payment settings needed.
	 * 
	 * @param paymentSettings
	 *            the payment settings object.
	 * 
	 * @see <a
	 *      href="https://developers.facebook.com/docs/messenger-platform/thread-settings/payment"
	 *      >Payments settings</a>
	 */
	public static void addPaymentSettings(PaymentSettings paymentSettings) {
		if (paymentSettings == null) {
			logger.error("FbBotMill validation error: Payment Settings can't be null or empty!");
			return;
		}
		NetworkUtils.postThreadSetting(paymentSettings);
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
		if (message == null || message.isEmpty()) {
			logger.error("FbBotMill validation error: Greeting message can't be null or empty!");
			return;
		}
		SetGreetingTextRequest request = new SetGreetingTextRequest(message);
		NetworkUtils.postThreadSetting(request);
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
		if (payload == null || payload.isEmpty()) {
			logger.error("FbBotMill validation error: Get Started Button payload can't be null or empty!");
			return;
		}
		Button button = new PostbackButton(null, null, payload);
		List<Button> buttonList = new ArrayList<Button>();
		buttonList.add(button);
		CallToActionsRequest request = new CallToActionsRequest(
				ThreadState.NEW_THREAD, buttonList);
		NetworkUtils.postThreadSetting(request);
	}

	/**
	 * Removes the current Get Started Button.
	 * 
	 * @see #setGetStartedButton(String)
	 */
	public static void deleteGetStartedButton() {
		CallToActionsRequest request = new CallToActionsRequest(
				ThreadState.NEW_THREAD, null);
		NetworkUtils.delete(request);
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
		NetworkUtils.postThreadSetting(request);
	}

	/**
	 * Removes the current Persistent Menu.
	 * 
	 * @see #setPersistentMenu(List)
	 * 
	 */
	public static void deletePersistentMenu() {
		CallToActionsRequest request = new CallToActionsRequest(
				ThreadState.EXISTING_THREAD, null);
		NetworkUtils.delete(request);
	}

	/**
	 * Add a list of domains that needs to be "white listed".
	 *
	 * @param whiteListDomains
	 *            the list of domains in String.
	 */
	public static void setWhiteListDomains(List<String> whiteListDomains) {
		WhitelistDomainRequest request = new WhitelistDomainRequest(
				whiteListDomains);
		NetworkUtils.postThreadSetting(request);
	}

	/**
	 * Add a single domain on the list of domains that needs to be
	 * "white listed".
	 *
	 * @param domain
	 *            the domain that needs to be "white listed"
	 */
	public static void addWhiteListDomain(String domain) {
		WhitelistDomainRequest request = new WhitelistDomainRequest();
		request.addWhiteListedDomain(domain);
		NetworkUtils.postThreadSetting(request);
	}

	/**
	 * Removes a list of domains that are currently "white listed".
	 *
	 * @param whiteListDomains
	 *            the list of domains that needs to be removed.
	 */
	public static void deleteWhiteListDomains(List<String> whiteListDomains) {
		WhitelistDomainRequest request = new WhitelistDomainRequest(
				whiteListDomains, DomainActionType.REMOVE);
		NetworkUtils.postThreadSetting(request);
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
