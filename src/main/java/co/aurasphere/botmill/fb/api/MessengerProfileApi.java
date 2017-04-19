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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.core.BotDefinition;
import co.aurasphere.botmill.fb.internal.util.network.FbBotMillNetworkController;
import co.aurasphere.botmill.fb.model.api.messengerprofile.DeleteMessengerProfileRequest;
import co.aurasphere.botmill.fb.model.api.messengerprofile.Greeting;
import co.aurasphere.botmill.fb.model.api.messengerprofile.HomeUrl;
import co.aurasphere.botmill.fb.model.api.messengerprofile.HomeUrlRequest;
import co.aurasphere.botmill.fb.model.api.messengerprofile.SetAccountLinkingUrlRequest;
import co.aurasphere.botmill.fb.model.api.messengerprofile.SetGetStartedButtonRequest;
import co.aurasphere.botmill.fb.model.api.messengerprofile.SetGreetingTextRequest;
import co.aurasphere.botmill.fb.model.api.messengerprofile.SetWhitelistedDomainsRequest;
import co.aurasphere.botmill.fb.model.api.messengerprofile.persistentmenu.PersistentMenu;
import co.aurasphere.botmill.fb.model.api.messengerprofile.persistentmenu.PersistentMenuRequest;

/**
 * Class which handles the configuration of the Facebook Messenger Platform
 * Messenger Profile (for more informations, see the link below). The methods of
 * this class needs to be called only once and thus shouldn't be put on the
 * class that implements {@link BotDefinition}. The best way of handling the
 * configuration would be defining your own class with a main method and put the
 * call on it.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/get-started-button"
 *      >Facebook's Messenger Profile Documentation</a>
 */
public class MessengerProfileApi {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(MessengerProfileApi.class);

	/**
	 * Instantiates a new MessengerProfileApi.
	 */
	private MessengerProfileApi() {
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
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/get-started-button"
	 *      >Facebook's Messenger Platform Get Started Button Documentation</a>
	 */
	public static void setGetStartedButton(String payload) {
		if (payload == null || "".equals(payload)) {
			logger.error("FbBotMill validation error: Get Started Button payload can't be null or empty!");
			return;
		}
		SetGetStartedButtonRequest request = new SetGetStartedButtonRequest(payload);
		FbBotMillNetworkController.postMessengerProfile(request);
	}

	/**
	 * Removes the current Get Started Button.
	 * 
	 * @see #setGetStartedButton(String)
	 */
	public static void deleteGetStartedButton() {
		DeleteMessengerProfileRequest request = new DeleteMessengerProfileRequest("get_started");
		FbBotMillNetworkController.deleteMessengerProfile(request);
	}

	/**
	 * Sets the greeting message for the bot. The Greeting Text is only rendered
	 * the first time the user interacts with a the Page on Messenger.
	 *
	 * @param message
	 *            the greeting message to show.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/greeting-text"
	 *      >Facebook's Messenger Platform Greeting Text Documentation</a>
	 */
	public static void setGreetingMessage(String message) {
		SetGreetingTextRequest request = new SetGreetingTextRequest(message);
		FbBotMillNetworkController.postMessengerProfile(request);
	}

	/**
	 * Sets the greeting message for the bot. The Greeting Text is only rendered
	 * the first time the user interacts with a the Page on Messenger.
	 *
	 * @param message
	 *            the greeting messages to show.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/greeting-text"
	 *      >Facebook's Messenger Platform Greeting Text Documentation</a>
	 */
	public static void setGreetingMessage(List<Greeting> message) {
		SetGreetingTextRequest request = new SetGreetingTextRequest(message);
		FbBotMillNetworkController.postMessengerProfile(request);
	}

	/**
	 * Removes the current Greeting Message.
	 * 
	 * @see #setGreetingMessage(String)
	 */
	public static void deleteGreetingMessage() {
		DeleteMessengerProfileRequest request = new DeleteMessengerProfileRequest("greeting");
		FbBotMillNetworkController.deleteMessengerProfile(request);
	}

	/**
	 * Adds a list of domains that needs to be whitelisted.
	 *
	 * @param whitelistedDomains
	 *            the list of domains to whitelist.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/domain-whitelisting"
	 *      >Facebook's Messenger Platform Domain Whitelisting Documentation</a>
	 */
	public static void setWhitelistedDomains(List<String> whitelistedDomains) {
		SetWhitelistedDomainsRequest request = new SetWhitelistedDomainsRequest(whitelistedDomains);
		FbBotMillNetworkController.postMessengerProfile(request);
	}

	/**
	 * Removes the list of domains that are currently whitelisted.
	 *
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/domain-whitelisting"
	 *      >Facebook's Messenger Platform Domain Whitelisting Documentation</a>
	 */
	public static void deleteWhitelistedDomains() {
		DeleteMessengerProfileRequest request = new DeleteMessengerProfileRequest("whitelisted_domains");
		FbBotMillNetworkController.deleteMessengerProfile(request);
	}

	/**
	 * Adds an URL used for account linking.
	 *
	 * @param accountLinkingUrl
	 *            the URL for the account linking.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/account-linking-url"
	 *      >Facebook's Messenger Platform Account Linking URL Documentation</a>
	 */
	public static void setAccountLinkingUrl(String accountLinkingUrl) {
		SetAccountLinkingUrlRequest request = new SetAccountLinkingUrlRequest(accountLinkingUrl);
		FbBotMillNetworkController.postMessengerProfile(request);
	}

	/**
	 * Removes the URL used for account linking.
	 *
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/account-linking-url"
	 *      >Facebook's Messenger Platform Account Linking URL Documentation</a>
	 */
	public static void deleteAccountLinkingUrl() {
		DeleteMessengerProfileRequest request = new DeleteMessengerProfileRequest("account_linking_url");
		FbBotMillNetworkController.deleteMessengerProfile(request);
	}

	/**
	 * Sets the persistent menus.
	 *
	 * @param persistentMenu
	 *            the new persistent menus
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/persistent-menu">
	 *      Facebook's Messenger Platform Persistent Menu Documentation</a>
	 */
	public static void setPersistentMenus(List<PersistentMenu> persistentMenu) {
		PersistentMenuRequest persistentMenuRequest = new PersistentMenuRequest();
		persistentMenuRequest.addAllPersistentMenu(persistentMenu);
		FbBotMillNetworkController.postMessengerProfile(persistentMenuRequest);
	}

	/**
	 * Removes the Persistent Menus.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/persistent-menu">
	 *      Facebook's Messenger Platform Persistent Menu Documentation</a>
	 */
	public static void deletePersistentMenus() {
		DeleteMessengerProfileRequest request = new DeleteMessengerProfileRequest("persistent_menu");
		FbBotMillNetworkController.deleteMessengerProfile(request);
	}

	/**
	 * This sets the home url of the Bot
	 * 
	 * @param homeUrl
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/home-url/v2.9">
	 *      Chat Extension Home URL</a>
	 */
	public static void setHomeUrl(HomeUrl homeUrl) {
		HomeUrlRequest homeUrlRequest = new HomeUrlRequest();
		homeUrlRequest.setHomeUrl(homeUrl);
		FbBotMillNetworkController.postMessengerProfile(homeUrlRequest);

	}

	/**
	 * Removes the home url.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/home-url/v2.9">
	 *      Chat Extension Home URL</a>
	 */
	public static void deleteHomeUrl() {
		DeleteMessengerProfileRequest request = new DeleteMessengerProfileRequest("home_url");
		FbBotMillNetworkController.deleteMessengerProfile(request);

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
