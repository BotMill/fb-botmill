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
package co.aurasphere.botmill.fb;

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.botmill.fb.support.FbBotMillMonitor;

/**
 * Class that contains all the context information used to handle bots and
 * communicate with Facebook. The context is a singleton.
 * 
 * @author Donato Rimenti
 * 
 */
public class FbBotMillContext {

	/**
	 * A list of the registered bots in the context. A {@link FbBot} can't be
	 * used unless it's registered to the context.
	 */
	private List<FbBot> registeredBots;

	/**
	 * The validation token used for the Facebook webhook. For more informations
	 * read Facebook Messenger Platform documentation.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      />Facebook Messenger Platform documentation</a>
	 * 
	 */
	private String validationToken;

	/**
	 * The current instance.
	 */
	private static FbBotMillContext instance;

	/**
	 * The page token used by Facebook for authentication. For more informations
	 * read Facebook Messenger Platform documentation.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      />Facebook Messenger Platform documentation</a>
	 * 
	 */
	private String pageToken;

	/**
	 * Boolean that indicates whether the validator is enabled or not.
	 */
	private boolean validationEnabled;

	/**
	 * A list of the registered monitors in the context.
	 * 
	 * @since 1.1.0
	 */
	private List<FbBotMillMonitor> registeredMonitors;

	/**
	 * Instantiates a new FbBotMillContext. The validator is enabled by default.
	 */
	private FbBotMillContext() {
		this.registeredBots = new ArrayList<FbBot>();
		this.validationEnabled = true;
		this.registeredMonitors = new ArrayList<FbBotMillMonitor>();
	}

	/**
	 * Registers a {@link FbBot} to the context. A bot can't be used unless it's
	 * registered to the context.
	 * 
	 * @param fbBot
	 *            the bot to register.
	 */
	void register(FbBot fbBot) {
		if (fbBot != null) {
			this.registeredBots.add(fbBot);
		}
	}

	/**
	 * Gets the current instance of FbBotMillContext.
	 *
	 * @return the current instance of FbBotMillContext.
	 */
	public static FbBotMillContext getInstance() {
		if (instance == null) {
			instance = new FbBotMillContext();
		}
		return instance;
	}

	/**
	 * Gets the {@link #registeredBots}.
	 *
	 * @return the {@link #registeredBots}.
	 */
	public List<FbBot> getRegisteredBots() {
		return this.registeredBots;
	}

	/**
	 * Gets the {@link #validationToken}.
	 *
	 * @return the {@link #validationToken}.
	 */
	public String getValidationToken() {
		return this.validationToken;
	}

	/**
	 * Sets the {@link #validationToken}. This method is deprecated. Use
	 * {@link #setup(String, String)} instead.
	 *
	 * @param validationToken
	 *            the {@link #validationToken} to set.
	 */
	@Deprecated
	public void setValidationToken(String validationToken) {
		this.validationToken = validationToken;
	}

	/**
	 * Gets the {@link #pageToken}.
	 *
	 * @return the {@link #pageToken}.
	 */
	public String getPageToken() {
		return this.pageToken;
	}

	/**
	 * Sets the {@link #pageToken}. This method is deprecated. Use
	 * {@link #setup(String, String)} instead.
	 *
	 * @param pageToken
	 *            the {@link #pageToken} to set.
	 */
	@Deprecated
	public void setPageToken(String pageToken) {
		this.pageToken = pageToken;
	}

	/**
	 * Checks if is validation enabled.
	 *
	 * @return true, if is validation enabled
	 */
	public boolean isValidationEnabled() {
		return this.validationEnabled;
	}

	/**
	 * Sets the {@link #validationEnabled}.
	 *
	 * @param validationEnabled
	 *            the {@link #validationEnabled} to set.
	 */
	public void setValidationEnabled(boolean validationEnabled) {
		this.validationEnabled = validationEnabled;
	}

	/**
	 * Convenience method for quickly setting up the FbBotMill environment.
	 * 
	 * @param pageToken
	 *            the validation token for the Facebook page.
	 * @param validationToken
	 *            the validation token for the Facebook webhook.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart">
	 *      Facebook Messenger Platform documentation</a>
	 */
	public void setup(String pageToken, String validationToken) {
		this.pageToken = pageToken;
		this.validationToken = validationToken;
	}

	/**
	 * Registers a monitor to the context. A monitor needs to be
	 * registered to this context in order to be used.
	 * 
	 * @param monitor
	 *            the monitor to be registered.
	 * @since 1.1.0
	 */
	public void registerMonitor(FbBotMillMonitor monitor) {
		this.registeredMonitors.add(monitor);
	}

	/**
	 * Gets the list of registered monitors to this context.
	 * 
	 * @return a list of registered monitors to this context.
	 * @since 1.1.0
	 */
	public List<FbBotMillMonitor> getRegisteredMonitors() {
		return this.registeredMonitors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillContext [registeredBots=" + registeredBots
				+ ", validationToken=" + validationToken + ", pageToken="
				+ pageToken + ", validationEnabled=" + validationEnabled + "]";
	}

}
