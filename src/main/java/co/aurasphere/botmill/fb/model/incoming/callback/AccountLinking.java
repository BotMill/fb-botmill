/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.botmill.fb.model.incoming.callback;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Model for an account linking callback. <br>
 * <br>
 * This callback will occur when the <a href=
 * "https://developers.facebook.com/docs/messenger-platform/account-linking/link-account"
 * >Linked Account</a> or <a href=
 * "https://developers.facebook.com/docs/messenger-platform/account-linking/unlink-account"
 * >Unlink Account</a> call-to-action have been tapped. The status parameter is
 * set to inform you whether the user linked or unlinked their account. The
 * authorization_code is a pass-through parameter. allowing you to match the
 * business user entity to the page-scoped ID (PSID) of the sender.
 *
 * @author Donato Rimenti
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
 * 
 */
public class AccountLinking implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((authorizationCode == null) ? 0 : authorizationCode
						.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountLinking other = (AccountLinking) obj;
		if (authorizationCode == null) {
			if (other.authorizationCode != null)
				return false;
		} else if (!authorizationCode.equals(other.authorizationCode))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountLinking [status=" + status + ", authorizationCode="
				+ authorizationCode + "]";
	}
}
