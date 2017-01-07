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
 * 
 */
package co.aurasphere.botmill.fb.model.threadsettings.payment;

import java.util.List;

import co.aurasphere.botmill.fb.model.threadsettings.SettingType;
import co.aurasphere.botmill.fb.model.threadsettings.ThreadSettingsBaseRequest;

import com.google.gson.annotations.SerializedName;

/**
 * Model class for the Payment Thread Settings.
 * 
 * @author Alvin Reyes
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/payment"
 *      >Facebook's Messenger Platform Payment Thread Settings Documentation</a>
 */
public class PaymentSettings extends ThreadSettingsBaseRequest {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Valid URL for the payment privacy. The payment_privacy_url will appear in
	 * the payment dialogs and people will be able to view these terms.
	 */
	@SerializedName("payment_privacy_url")
	private String privacyUrl;

	/**
	 * Your PGP Public Key (4096 bit RSA). The payment_public_key is used to
	 * encrypt sensitive payment data sent to you.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/payments-reference#encryption_key"
	 *      >Facebook's encryption guide</a>
	 */
	@SerializedName("payment_public_key")
	private String publicKey;

	/**
	 * ADD/REMOVE dev mode test users.
	 */
	@SerializedName("payment_dev_mode_action")
	private PaymentDevModeAction paymentDevModeAction;

	/**
	 * A list of page scoped user id to be added as payment testers.
	 */
	@SerializedName("payment_testers")
	private List<String> paymentTesters;

	/**
	 * Instantiates a new PaymentSettings.
	 */
	public PaymentSettings() {
		this.type = SettingType.PAYMENT;
	}

	/**
	 * Gets the {@link #privacyUrl}.
	 *
	 * @return the {@link #privacyUrl}.
	 */
	public String getPrivacyUrl() {
		return privacyUrl;
	}

	/**
	 * Sets the {@link #privacyUrl}.
	 *
	 * @param privacyUrl
	 *            the {@link #privacyUrl} to set.
	 */
	public void setPrivacyUrl(String privacyUrl) {
		this.privacyUrl = privacyUrl;
	}

	/**
	 * Gets the {@link #publicKey}.
	 *
	 * @return the {@link #publicKey}.
	 */
	public String getPublicKey() {
		return publicKey;
	}

	/**
	 * Sets the {@link #publicKey}.
	 *
	 * @param publicKey
	 *            the {@link #publicKey} to set.
	 */
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	/**
	 * Gets the {@link #paymentDevModeAction}.
	 *
	 * @return the {@link #paymentDevModeAction}.
	 */
	public PaymentDevModeAction getPaymentDevModeAction() {
		return paymentDevModeAction;
	}

	/**
	 * Sets the {@link #paymentDevModeAction}.
	 *
	 * @param paymentDevModeAction
	 *            the {@link #paymentDevModeAction} to set.
	 */
	public void setPaymentDevModeAction(
			PaymentDevModeAction paymentDevModeAction) {
		this.paymentDevModeAction = paymentDevModeAction;
	}

	/**
	 * Gets the {@link #paymentTesters}.
	 *
	 * @return the {@link #paymentTesters}.
	 */
	public List<String> getPaymentTesters() {
		return paymentTesters;
	}

	/**
	 * Sets the {@link #paymentTesters}.
	 *
	 * @param paymentTesters
	 *            the {@link #paymentTesters} to set.
	 */
	public void setPaymentTesters(List<String> paymentTesters) {
		this.paymentTesters = paymentTesters;
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
				+ ((paymentDevModeAction == null) ? 0 : paymentDevModeAction
						.hashCode());
		result = prime * result
				+ ((paymentTesters == null) ? 0 : paymentTesters.hashCode());
		result = prime * result
				+ ((privacyUrl == null) ? 0 : privacyUrl.hashCode());
		result = prime * result
				+ ((publicKey == null) ? 0 : publicKey.hashCode());
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
		PaymentSettings other = (PaymentSettings) obj;
		if (paymentDevModeAction != other.paymentDevModeAction)
			return false;
		if (paymentTesters == null) {
			if (other.paymentTesters != null)
				return false;
		} else if (!paymentTesters.equals(other.paymentTesters))
			return false;
		if (privacyUrl == null) {
			if (other.privacyUrl != null)
				return false;
		} else if (!privacyUrl.equals(other.privacyUrl))
			return false;
		if (publicKey == null) {
			if (other.publicKey != null)
				return false;
		} else if (!publicKey.equals(other.publicKey))
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
		return "PaymentSettings [privacyUrl=" + privacyUrl + ", publicKey="
				+ publicKey + ", paymentDevModeAction=" + paymentDevModeAction
				+ ", paymentTesters=" + paymentTesters + ", type=" + type + "]";
	}

}
