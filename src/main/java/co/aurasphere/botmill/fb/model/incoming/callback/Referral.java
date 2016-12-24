package co.aurasphere.botmill.fb.model.incoming.callback;

import java.io.Serializable;

/**
 * Model for the Referral Callback. <br/>
 * <br/>
 * This callback will occur when an m.me link is used with a referral param and
 * only in a case this user already has a thread with this bot (for new threads
 * see <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference/postback-received"
 * >Postback Event</a>). See also the full guide on <a href=
 * "https://developers.facebook.com/docs/messenger-platform/referral-params"
 * >m.me links</a>. <br/>
 * <br/>
 * To start receiving these events you need to subscribe to messaging_referral
 * in the webhook settings for your app. <br/>
 * <br/>
 * An m.me link with an an added parameter looks like this:
 * http://m.me/mybot?ref=myparam. The value of the ref parameter will be passed
 * to the server via webhook.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/referral"
 *      > Facebook's Messenger Platform Referral Callback Documentation</a>
 * @author Donato Rimenti
 * @date Dec 4, 2016
 */
public class Referral implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The arbitrary data that was originally passed in the ref param added to
	 * the m.me link.
	 */
	private String ref;

	// TODO: https://github.com/Aurasphere/facebot/issues/19
	/**
	 * The source of this referral. Currently, the only possible value is
	 * “SHORTLINK”.
	 */
	private String source;

	// TODO: https://github.com/Aurasphere/facebot/issues/19
	/**
	 * The identifier for the referral. For referrals coming from m.me links, it
	 * will always be "OPEN_THREAD".
	 */
	private String type;

	/**
	 * Gets the {@link #ref}.
	 *
	 * @return the {@link #ref}.
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * Sets the {@link #ref}.
	 *
	 * @param ref
	 *            the {@link #ref} to set.
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}

	/**
	 * Gets the {@link #source}.
	 *
	 * @return the {@link #source}.
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Sets the {@link #source}.
	 *
	 * @param source
	 *            the {@link #source} to set.
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * Gets the {@link #type}.
	 *
	 * @return the {@link #type}.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the {@link #type}.
	 *
	 * @param type
	 *            the {@link #type} to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

}
