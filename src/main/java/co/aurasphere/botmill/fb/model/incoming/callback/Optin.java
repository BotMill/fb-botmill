package co.aurasphere.botmill.fb.model.incoming.callback;

import java.io.Serializable;


/**
 * Model for a plugin opt-in callback. <br/>
 * <br/>
 * This callback will occur when the <a href=
 * "https://developers.facebook.com/docs/messenger-platform/plugin-reference/send-to-messenger"
 * >Send-to-Messenger</a> plugin has been tapped. The optin.ref parameter is set
 * by the data-ref field on the "Send to Messenger" plugin. This field can be
 * used by the developer to associate a click event on the plugin with a
 * callback. You can subscribe to this callback by selecting the
 * messaging_optins field when <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 * >setting up</a> your webhook.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/optins"
 *      >Facebook's Messenger Platform Plugin Opt-in Callback Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/plugin-reference/send-to-messenger"
 *      >Facebook's Messenger Platform Send-to-Messenger Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Webhook Setup Documentation</a>
 * @date Dec 22, 2016
 */
public class Optin implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Data-ref parameter that was defined with the entry point.
	 */
	private String ref;

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
	 * @param ref the {@link #ref} to set.
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}

}
