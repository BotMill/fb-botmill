package co.aurasphere.botmill.fb.model.incoming.callback;

import java.io.Serializable;

/**
 * Model for a postback callback. <br/>
 * <br/>
 * Postbacks occur when a Postback button, Get Started button, Persistent menu
 * or Structured Message is tapped. The payload field in the callback is defined
 * on the button. You can subscribe to this callback by selecting the
 * messaging_postbacks field when <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 * >setting up</a> your webhook.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/postback"
 *      >Facebook's Messenger Platform Postback Callback Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Webhook Setup Documentation</a>
 * 
 * @author Donato Rimenti
 * @date Dec 24, 2016
 */
public class Postback implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Payload parameter that was defined with the button.
	 */
	private String payload;

	/**
	 * 
	 Comes only with Get Started postback and if an optional ref param was
	 * passed from the entry point, such as <a href=
	 * "https://developers.facebook.com/docs/messenger-platform/referral-params"
	 * >m.me link</a>.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/referral-params"
	 *      >Facebook's Messenger Platform m.me links Documentation</a>
	 */
	private Referral referral;

	/**
	 * Gets the {@link #payload}.
	 *
	 * @return the {@link #payload}.
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * Sets the {@link #payload}.
	 *
	 * @param payload the {@link #payload} to set.
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/**
	 * Gets the {@link #referral}.
	 *
	 * @return the {@link #referral}.
	 */
	public Referral getReferral() {
		return referral;
	}

	/**
	 * Sets the {@link #referral}.
	 *
	 * @param referral the {@link #referral} to set.
	 */
	public void setReferral(Referral referral) {
		this.referral = referral;
	}
}
