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
package co.aurasphere.botmill.fb.internal.util.network;

import co.aurasphere.botmill.fb.FbBotMillContext;

/**
 * Utility class that contains the constants used to handle the network
 * communication with Facebook.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/quickstart">
 *      Facebook's Messenger Platform Documentation</a>
 * 
 */
public class FbBotMillNetworkConstants {

	/**
	 * Instantiates a new FbBotMillNetworkConstants.
	 */
	private FbBotMillNetworkConstants() {
	}

	/**
	 * GET parameter indicating the type of request from Facebook. Used only
	 * during WebHook initial registration.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      > Facebook's Messenger Platform Documentation</a>
	 */
	public static final String HUB_MODE_PARAMETER = "hub.mode";

	/**
	 * GET parameter indicating the verify token from Facebook. Used only during
	 * WebHook initial registration. Facebook will send a verify token as
	 * defined during configuration phase. The Servlet will check that the token
	 * is the same registered in the {@link FbBotMillContext} and, if that's the
	 * case, proceed with registration.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      > Facebook's Messenger Platform Documentation</a>
	 */
	public static final String HUB_VERIFY_TOKEN_PARAMETER = "hub.verify_token";

	/**
	 * GET parameter indicating the hub challenge from Facebook. Used only
	 * during WebHook initial registration. Facebook will send an hub challenge
	 * as defined during configuration phase and expects the app to reply with
	 * the same challenge to complete the WebHook registration.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      > Facebook's Messenger Platform Documentation</a>
	 */
	public static final String HUB_CHALLENGE_PARAMETER = "hub.challenge";

	/**
	 * Hub mode expected from Facebook for WebHook initial registration.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      > Facebook's Messenger Platform Documentation</a>
	 */
	public static final String HUB_MODE_SUBSCRIBE = "subscribe";

	/**
	 * Facebook's base URL used to POST data.
	 */
	public static final String FACEBOOK_BASE_URL = "https://graph.facebook.com/v2.7/";

	/**
	 * Facebook's REST path for the Send API.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference"
	 *      > Facebook's Messenger Send API Documentation</a>
	 */
	public static final String FACEBOOK_MESSAGES_URL = "me/messages?access_token=";

	/**
	 * Facebook's REST path for the Thread Settings API.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
	 *      > Facebook's Messenger Thread Settings Documentation</a>
	 */
	public static final String FACEBOOK_THREAD_SETTINGS_URL = "me/thread_settings?access_token=";

	/**
	 * Facebook's GET parameters for the User Profile API.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/user-profile"
	 *      >Facebook's Messenger User Profile API Documentation</a>
	 */
	public static final String USER_PROFILE_FIELDS = "?fields=first_name,last_name,profile_pic,locale,timezone,gender&access_token=";

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillNetworkConstants []";
	}

}
