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
package co.aurasphere.botmill.fb.model.incoming.callback.payment;

import java.io.Serializable;

import co.aurasphere.botmill.fb.model.outcoming.template.button.BuyButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.RequestedUserInfo;

import com.google.gson.annotations.SerializedName;

/**
 * Model for the Payment Callback. <br>
 * <br>
 * This callback occurs when a persons taps the pay button from the checkout
 * dialog rendered by the {@link BuyButton}. It contains the requested user
 * information as well as payment credentials. Depends on the payment provider
 * you use, the payment credential will differ. <br>
 * <br>
 * You must subscribe to this callback by selecting the messaging_payments field
 * when setting up your webhook.
 * 
 * <h1>Stripe/Paypal</h1>
 * 
 * After user click on pay, user will be charged directly and the payment will
 * be send to your Stripe/Paypal account. This webhook event will be called once
 * the process succeed. All the requested user information that user entered in
 * the payment dialog will be passed back in the webhook event. The charge_id
 * from Paypal/Stripe will be passed to you for tracking the payment. You need
 * to return HTTP status of 200 once you finished processing the event. <br>
 * <br>
 * If the payment is a test payment, we will not charge the card but will send a
 * result with dummy fb_payment_id/charge_id to you. You can do test payment
 * with Stripe/Paypal only if your page has payment permission for now. Refers
 * to <a href=
 * "https://developers.facebook.com/docs/messenger-platform/complete-guide/payments#test_payments"
 * >How to Test Payment</a> for details. <br>
 * 
 * <h1>Tokenized Payment</h1>
 * 
 * If you are using tokenized payment, when user click on pay, we will send you
 * a single-use Discover virtual card provisioned by PayPal. The card credential
 * will be encrypted by the public key you provided in previous steps. You can
 * then decrypt the tokenized card by following the <a href=
 * "https://developers.facebook.com/docs/messenger-platform/complete-guide/payments#decrypting"
 * >detail steps here</a>. After you successfully decoded the credential, you
 * can then integrate with your preferred payment provider to charge the card.
 * You need to return HTTP status of 200 once you finished processing the event. <br>
 * If the payment is a test payment, you will get a dummy tokenized card back
 * with the following dummy information (card_number: 4111111111111111, cvv:
 * 123, expiry month: 11, expiry year: 2020). You can test tokenized payment
 * even if your page/app has not been accepted to beta program. Refers to <a
 * href=
 * "https://developers.facebook.com/docs/messenger-platform/complete-guide/payments#test_payments"
 * >How to Test Payment</a> for details. <br>
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/payment"
 *      >Facebook's Messenger Platform Payment Callback Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/buy-button"
 *      >Facebook's Messenger Platform Buy Button Documentation</a>
 * 
 */
public class Payment implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metadata defined in the Buy Button.
	 */
	private String payload;

	/**
	 * Information that was requested from the user by the Buy Button.
	 */
	@SerializedName("requested_user_info")
	private RequestedUserInfo requestedUserInfo;

	/**
	 * Payment credentials.
	 */
	@SerializedName("payment_credential")
	private PaymentCredential paymentCredential;

	/**
	 * Total amount of transaction.
	 */
	private PaymentAmount amount;

	/**
	 * The option_id of the selected shipping option sent via the <a href=
	 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference/checkout-update"
	 * >checkout update callback</a>. Only applicable for flexible payments.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/checkout-update"
	 *      >Facebook's Messenger Platform Checkout Update Callback
	 *      Documentation</a>
	 */
	@SerializedName("shipping_option_id")
	private String shippingOptionId;

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
	 * Gets the {@link #paymentCredential}.
	 *
	 * @return the {@link #paymentCredential}.
	 */
	public PaymentCredential getPaymentCredential() {
		return paymentCredential;
	}

	/**
	 * Sets the {@link #paymentCredential}.
	 *
	 * @param paymentCredential
	 *            the {@link #paymentCredential} to set.
	 */
	public void setPaymentCredential(PaymentCredential paymentCredential) {
		this.paymentCredential = paymentCredential;
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

	/**
	 * Gets the {@link #shippingOptionId}.
	 *
	 * @return the {@link #shippingOptionId}.
	 */
	public String getShippingOptionId() {
		return shippingOptionId;
	}

	/**
	 * Sets the {@link #shippingOptionId}.
	 *
	 * @param shippingOptionId
	 *            the {@link #shippingOptionId} to set.
	 */
	public void setShippingOptionId(String shippingOptionId) {
		this.shippingOptionId = shippingOptionId;
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
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((payload == null) ? 0 : payload.hashCode());
		result = prime
				* result
				+ ((paymentCredential == null) ? 0 : paymentCredential
						.hashCode());
		result = prime
				* result
				+ ((requestedUserInfo == null) ? 0 : requestedUserInfo
						.hashCode());
		result = prime
				* result
				+ ((shippingOptionId == null) ? 0 : shippingOptionId.hashCode());
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
		Payment other = (Payment) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		if (paymentCredential == null) {
			if (other.paymentCredential != null)
				return false;
		} else if (!paymentCredential.equals(other.paymentCredential))
			return false;
		if (requestedUserInfo != other.requestedUserInfo)
			return false;
		if (shippingOptionId == null) {
			if (other.shippingOptionId != null)
				return false;
		} else if (!shippingOptionId.equals(other.shippingOptionId))
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
		return "Payment [payload=" + payload + ", requestedUserInfo="
				+ requestedUserInfo + ", paymentCredential="
				+ paymentCredential + ", amount=" + amount
				+ ", shippingOptionId=" + shippingOptionId + "]";
	}

}
