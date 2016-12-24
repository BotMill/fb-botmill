package co.aurasphere.botmill.fb.model.incoming.callback;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Model for an account linking callback. <br/>
 * <br/>
 * This callback will occur when the <a href=
 * "https://developers.facebook.com/docs/messenger-platform/account-linking/link-account"
 * >Linked Account</a> or <a href=
 * "https://developers.facebook.com/docs/messenger-platform/account-linking/unlink-account"
 * >Unlink Account</a> call-to-action have been tapped. The status parameter is
 * set to inform you whether the user linked or unlinked their account. The
 * authorization_code is a pass-through parameter. allowing you to match the
 * business user entity to the page-scoped ID (PSID) of the sender.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/account-linking"
 *      >Facebook's Messenger Platform Account Linking Callback
 *      Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/account-linking"
 *      >Facebook's Messenger Platform Account Linking Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/account-linking/link-account"
 *      >Facebook's Messenger Platform Link Account Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/account-linking/unlink-account"
 *      >Facebook's Messenger Platform Unlink Account Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Webhook Setup Documentation</a>
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public class AccountLinking implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	// TODO: https://github.com/Aurasphere/facebot/issues/19
	/**
	 * May be linked or unlinked.
	 */
	private String status;

	/**
	 * Value of pass-through authorization_code provided in the Linking Account
	 * flow. This is only available when status is linked.
	 */
	@SerializedName("authorization_code")
	private String authorizationCode;

	/**
	 * Gets the {@link #status}.
	 *
	 * @return the {@link #status}.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the {@link #status}.
	 *
	 * @param status
	 *            the {@link #status} to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the {@link #authorizationCode}.
	 *
	 * @return the {@link #authorizationCode}.
	 */
	public String getAuthorizationCode() {
		return authorizationCode;
	}

	/**
	 * Sets the {@link #authorizationCode}.
	 *
	 * @param authorizationCode
	 *            the {@link #authorizationCode} to set.
	 */
	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}
}
