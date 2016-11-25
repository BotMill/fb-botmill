package co.aurasphere.facebot.util;

/**
 * Utility class that contains the constants used to handle the communication
 * with Facebook.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
 *      />Facebook Messenger Platform documentation</a>
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class FaceBotConstants {

	/**
	 * GET parameter indicating the type of request from Facebook. Used only
	 * during WebHook initial registration.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      />Facebook Messenger Platform documentation</a>
	 */
	public static final String HUB_MODE_PARAMETER = "hub.mode";

	/**
	 * GET parameter indicating the verify token from Facebook. Used only during
	 * WebHook initial registration. Facebook will send a verify token as
	 * defined during configuration phase. The Servlet will check that the token
	 * is the same registered in the FaceBotContext and, if that's the case,
	 * proceed with registration.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      />Facebook Messenger Platform documentation</a>
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
	 *      />Facebook Messenger Platform documentation</a>
	 */
	public static final String HUB_CHALLENGE_PARAMETER = "hub.challenge";

	/**
	 * Hub mode expected from Facebook for WebHook initial registration.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/quickstart"
	 *      />Facebook Messenger Platform documentation</a>
	 */
	public static final String HUB_MODE_SUBSCRIBE = "subscribe";

	/**
	 * Facebook base URL used to POST data.
	 */
	public static final String FACEBOOK_BASE_URL = "https://graph.facebook.com/v2.6/me/";
	
	public static final String FACEBOOK_MESSAGES_URL = "messages?access_token=";
	
	public static final String FACEBOOK_THREAD_SETTINGS_URL = "thread_settings?access_token=";
	
	////////////////////
	public static final int BUTTON_TITLE_MAX_LENGTH = 20;
	
	public static final int PAYLOAD_MAX_LENGTH = 1000;
	
	public static final int QUICK_REPLY_MAX_ELEMENTS = 10;

	public static final int MESSAGE_MAX_LENGTH = 320;
	
	public static final int BUTTONS_MAX_ELEMENTS = 3;

	public static final int GENERIC_TEMPLATE_MAX_ELEMENTS = 10;
	
	public static final int GENERIC_TEMPLATE_TITLE_MAX_LENGHT = 80;

	public static final int GENERIC_TEMPLATE_SUBTITLE_MAX_LENGHT = 80;

	public static final int GREETING_TEXT_MAX_LENGTH = 160;

	public static final int PERSISTENT_BUTTONS_MAX_ELEMENTS = 5;
	
	public static final int PERSISTENT_BUTTON_TITLE_MAX_LENGTH = 30;
	

}
