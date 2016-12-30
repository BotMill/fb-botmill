package co.aurasphere.botmill.fb;

import java.util.ArrayList;
import java.util.List;


/**
 * Class that contains all the context information used to handle bots and
 * communicate with Facebook. The context is a singleton.
 * 
 * @author Donato Rimenti
 * 
 */
public class FbBotMillContext {

	/**
	 * A list of the registered bots in the context. A {@link FbBot} can't
	 * be used unless it's registered to the context.
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
	 * Instantiates a new FbBotMillContext. The validator is enabled by default.
	 */
	private FbBotMillContext() {
		this.registeredBots = new ArrayList<FbBot>();
		this.validationEnabled = true;
	}

	/**
	 * Registers a {@link FbBot} to the context. A bot can't be
	 * used unless it's registered to the context.
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
	 * @see <a href="https://developers.facebook.com/docs/messenger-platform/quickstart">Facebook Messenger Platform documentation</a>
	 */
	public void setup(String pageToken, String validationToken) {
		this.pageToken = pageToken;
		this.validationToken = validationToken;
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
