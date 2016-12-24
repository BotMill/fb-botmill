package co.aurasphere.botmill.fb;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that contains all the context information used to handle FaceBots and
 * communicate with Facebook. The context is a singleton.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class FbBotMillContext {

	/**
	 * A list of the registered FaceBots in the context. A {@link FbBot} can't
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
	 * The current FaceBotContext instance.
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
	 * Instantiates a new FaceBotContext. The validator is enabled by default.
	 */
	private FbBotMillContext() {
		this.registeredBots = new ArrayList<FbBot>();
		this.validationEnabled = true;
	}

	/**
	 * Registers a {@link FbBot} to the FaceBotContext. A FaceBot can't be
	 * used unless it's registered to the FaceBotContext.
	 * 
	 * @param faceBot
	 *            the FaceBot to register.
	 */
	void register(FbBot faceBot) {
		if (faceBot != null) {
			this.registeredBots.add(faceBot);
		}
	}

	/**
	 * Gets the current instance of FaceBotContext.
	 *
	 * @return the current instance of FaceBotContext.
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
	 * Convenience method for quickly setting up the FaceBot environment.
	 * 
	 * @param pageToken
	 *            the validation token for the Facebook page.
	 * @param validationToken
	 *            the validation token for the Facebook webhook.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      />Facebook Messenger Platform documentation</a>
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
		return "FaceBotContext [registeredBots=" + registeredBots
				+ ", validationToken=" + validationToken + ", pageToken="
				+ pageToken + ", validationEnabled=" + validationEnabled + "]";
	}

}
