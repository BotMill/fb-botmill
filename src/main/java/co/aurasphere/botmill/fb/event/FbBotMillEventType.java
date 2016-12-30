package co.aurasphere.botmill.fb.event;


/**
 * Enum that represents all the possible callbacks from Facebook's Messenger
 * Platform.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Callbacks Documentation</a>
 * 
 */
public enum FbBotMillEventType {

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
	 * Represents messaging_checkout_updates callback.
	 */
	CHECKOUT_UPDATE,

	/**
	 * Represents messaging_referral callback.
	 */
	REFERRAL,

	/**
	 * Represents messaging_payments callback.
	 */
	PAYMENT,

	/**
	 * Represents any of the previous callbacks. Used as utility event.
	 */
	ANY;

}
