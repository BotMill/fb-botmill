package co.aurasphere.facebot.event;

/**
 * Enum that represents all the possible callbacks from Facebook's Messenger
 * Platform.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Callbacks Documentation</a>
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public enum FaceBotEventType {

	/**
	 * Represents message callback.
	 */
	MESSAGE,

	/**
	 * Represents messaging_postback callback.
	 */
	POSTBACK,

	/**
	 * Represents messaging_optins callback.
	 */
	AUTHENTICATION,

	/**
	 * Represents an account linking callback. There's no defined event for this
	 * on Messenger Platform.
	 */
	ACCOUNT_LINKING,

	/**
	 * Represents message_deliveries callback.
	 */
	DELIVERY,

	/**
	 * Represents message_reads callback.
	 */
	READ,

	/**
	 * Represents message_echoes callback.
	 */
	ECHO,

	/**
	 * Represents any of the previous callbacks. Used as utility event.
	 */
	ANY;

}
