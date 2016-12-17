package co.aurasphere.facebot.model.incoming.callback;

/**
 * Model for the Referral Callback.
 * 
 * This callback will occur when an m.me link is used with a referral param and
 * only in a case this user already has a thread with this bot (for new threads
 * see <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference/postback-received"
 * >Postback Event</a>). See also the full guide on <a href=
 * "https://developers.facebook.com/docs/messenger-platform/referral-params"
 * >m.me links</a>.
 * 
 * To start receiving these events you need to subscribe to messaging_referral
 * in the webhook settings for your app.
 * 
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
public class Referral {
	
	private String ref;
	
	private String source;
	
	private String type;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
