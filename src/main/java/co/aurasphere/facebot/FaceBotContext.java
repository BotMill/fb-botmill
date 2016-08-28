package co.aurasphere.facebot;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that contains all the context information used to handle FaceBots and
 * communicate with Facebook. The context is a singleton.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class FaceBotContext {

	/**
	 * A list of the registered FaceBots in the context. A {@link FaceBot} can't
	 * be used unless it's registered to the context.
	 */
	private List<FaceBot> registeredBots;

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
	 * The current FaceBotContext instance used for the singleton pattern.
	 */
	private static FaceBotContext instance;

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
	 * Default constructor. Initializes the registeredBots list. It's private
	 * and called by {@link #getInstance()} only the first time it's invoked.
	 * The validator is enabled by default.
	 */
	private FaceBotContext() {
		this.registeredBots = new ArrayList<FaceBot>();
		validationEnabled = true;
	}

	/**
	 * Registers a {@link FaceBot} to the FaceBotContext. A FaceBot can't be
	 * used unless it's registered to the FaceBotContext. If the FaceBot is null
	 * an IllegalArgumentException is thrown.
	 * 
	 * @param faceBot
	 *            the FaceBot to register. It can't be null.
	 * @throws IllegalArgumentException
	 *             if the FaceBot is null.
	 */
	public void register(FaceBot faceBot) {
		this.registeredBots.add(faceBot);
	}

	/**
	 * Returns the current instance of the FaceBotContext.
	 * 
	 * @return the current instance of the FaceBotContext.
	 */
	public static FaceBotContext getInstance() {
		if (instance == null) {
			instance = new FaceBotContext();
		}
		return instance;
	}

	/**
	 * Returns the list of the registered FaceBots to this context.
	 * 
	 * @return the list of the registered FaceBots to this context.
	 */
	public List<FaceBot> getRegisteredBots() {
		return registeredBots;
	}

	/**
	 * Returns the validation token for the Facebook webhook. For more
	 * informations read Facebook Messenger Platform documentation.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      />Facebook Messenger Platform documentation</a>
	 * 
	 * @return the validation token for the Facebook webhook.
	 */
	public String getValidationToken() {
		return validationToken;
	}

	/**
	 * Sets the validation token for the Facebook webhook. For more informations
	 * read Facebook Messenger Platform documentation. Deprecated. Use
	 * {@link #setup(String, String)} instead.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      />Facebook Messenger Platform documentation</a>
	 * 
	 * @param validationToken
	 *            the validation token for the Facebook webhook.
	 */
	@Deprecated
	public void setValidationToken(String validationToken) {
		this.validationToken = validationToken;
	}

	/**
	 * Returns the validation token for the Facebook page. For more informations
	 * read Facebook Messenger Platform documentation.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      />Facebook Messenger Platform documentation</a>
	 * 
	 * @return the validation token for the Facebook page.
	 */
	public String getPageToken() {
		return pageToken;
	}

	/**
	 * Sets the validation token for the Facebook page. For more informations
	 * read Facebook Messenger Platform documentation. Deprecated. Use
	 * {@link #setup(String, String)} instead.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      />Facebook Messenger Platform documentation</a>
	 * 
	 * @param pageToken
	 *            the validation token for the Facebook page.
	 */
	@Deprecated
	public void setPageToken(String pageToken) {
		this.pageToken = pageToken;
	}

	/**
	 * Sets whether the validation should be enabled or not. If the validation
	 * is enabled an incorrect message will throw an exception. If not
	 * specified, defaults to true.
	 * 
	 * @return true if the validation is enabled, false otherwise.
	 */
	public boolean isValidationEnabled() {
		return validationEnabled;
	}

	/**
	 * Gets whether the validation should be enabled or not. If the validation
	 * is enabled an incorrect message will throw an exception. If not
	 * specified, defaults to true.
	 * 
	 * @param validationEnabled
	 *            true or false.
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

}
