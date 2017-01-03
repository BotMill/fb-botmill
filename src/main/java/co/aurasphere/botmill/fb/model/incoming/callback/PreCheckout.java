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

import co.aurasphere.botmill.fb.model.incoming.callback.payment.PaymentAmount;
import co.aurasphere.botmill.fb.model.outcoming.template.button.BuyButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.RequestedUserInfo;

import com.google.gson.annotations.SerializedName;

/**
 * Model for a pre-checkout callback. <br>
 * <br>
 * This callback will occur when a user clicks on Pay in the payment dialog, but
 * before the user's card is charged.<br>
 * <br>
 * This allows you to do any processing on your end before charging user's card.
 * You could check inventory levels or for price changes before accepting the
 * payment.<br>
 * <br>
 * Subscribe to this callback by selecting the messaging_pre_checkouts option
 * when <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 * >setting up</a> your webhook. If your app does not subscribe to this event,
 * after the user clicks on Pay we will process the payment directly.<br>
 * <br>
 * The event is only called for payments triggered via {@link BuyButton}, and
 * not for those triggered via webview.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/pre-checkout"
 *      >Facebook's Messenger Platform Pre-Checkout Callback Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Webhook Setup Documentation</a>
 * 
 */
public class PreCheckout implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metadata defined in the {@link BuyButton}.
	 */
	private String payload;

	/**
	 * Information that was requested from the user by the {@link BuyButton}.
	 */
	@SerializedName("requested_user_info")
	private RequestedUserInfo requestedUserInfo;

	/**
	 * Total amount of transaction.
	 */
	private PaymentAmount amount;

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
	 * @param payload
	 *            the {@link #payload} to set.
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/**
	 * Gets the {@link #requestedUserInfo}.
	 *
	 * @return the {@link #requestedUserInfo}.
	 */
	public RequestedUserInfo getRequestedUserInfo() {
		return requestedUserInfo;
	}

	/**
	 * Sets the {@link #requestedUserInfo}.
	 *
	 * @param requestedUserInfo
	 *            the {@link #requestedUserInfo} to set.
	 */
	public void setRequestedUserInfo(RequestedUserInfo requestedUserInfo) {
		this.requestedUserInfo = requestedUserInfo;
	}

	/**
	 * Gets the {@link #amount}.
	 *
	 * @return the {@link #amount}.
	 */
	public PaymentAmount getAmount() {
		return amount;
	}

	/**
	 * Sets the {@link #amount}.
	 *
	 * @param amount
	 *            the {@link #amount} to set.
	 */
	public void setAmount(PaymentAmount amount) {
		this.amount = amount;
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
		result = prime * result + ((payload == null) ? 0 : payload.hashCode());
		result = prime
				* result
				+ ((requestedUserInfo == null) ? 0 : requestedUserInfo
						.hashCode());
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
		PreCheckout other = (PreCheckout) obj;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		if (requestedUserInfo == null) {
			if (other.requestedUserInfo != null)
				return false;
		} else if (!requestedUserInfo.equals(other.requestedUserInfo))
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
		return "PreCheckout [payload=" + payload + ", requestedUserInfo="
				+ requestedUserInfo + "]";
	}
}
