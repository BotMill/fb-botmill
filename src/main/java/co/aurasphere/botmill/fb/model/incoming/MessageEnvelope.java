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
package co.aurasphere.botmill.fb.model.incoming;

import java.io.Serializable;

import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.incoming.callback.AccountLinking;
import co.aurasphere.botmill.fb.model.incoming.callback.CheckoutUpdate;
import co.aurasphere.botmill.fb.model.incoming.callback.DeliveredMessage;
import co.aurasphere.botmill.fb.model.incoming.callback.IncomingMessage;
import co.aurasphere.botmill.fb.model.incoming.callback.Optin;
import co.aurasphere.botmill.fb.model.incoming.callback.Postback;
import co.aurasphere.botmill.fb.model.incoming.callback.PreCheckout;
import co.aurasphere.botmill.fb.model.incoming.callback.Read;
import co.aurasphere.botmill.fb.model.incoming.callback.Referral;
import co.aurasphere.botmill.fb.model.incoming.callback.payment.Payment;

import com.google.gson.annotations.SerializedName;

/**
 * A generic incoming message envelope.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#format"
 *      >Facebook's Messenger Platform Common Format Documentation</a>
 * 
 */
public class MessageEnvelope implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The message sender.
	 */
	private User sender;

	/**
	 * The message recipient.
	 */
	private User recipient;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
	/**
	 * The message timestamp.
	 */
	private String timestamp;

	/**
	 * Message content for message and message_echoes callback.
	 */
	private IncomingMessage message;

	/**
	 * Postback object for messaging_postbacks callback.
	 */
	private Postback postback;

	/**
	 * Optin object for messaging_optins callback.
	 */
	private Optin optin;

	/**
	 * Object for Account Linking callback.
	 */
	@SerializedName("account_linking")
	private AccountLinking accountLinking;

	/**
	 * Delivery object for message_deliveries callback.
	 */
	private DeliveredMessage delivery;

	/**
	 * Read object for message_reads callback.
	 */
	private Read read;

	/**
	 * Referral object for messaging_referral callback.
	 */
	private Referral referral;

	/**
	 * Payment object for messaging_payments callback.
	 */
	private Payment payment;

	/**
	 * Checkout update object for messaging_checkout_updates callback.
	 */
	@SerializedName("checkout_update")
	private CheckoutUpdate checkoutUpdate;

	/**
	 * Pre-Checkout update object for messaging_pre_checkouts callback.
	 */
	@SerializedName("pre_checkout")
	private PreCheckout preCheckout;

	/**
	 * Gets the {@link #sender}.
	 *
	 * @return the {@link #sender}.
	 */
	public User getSender() {
		return sender;
	}

	/**
	 * Sets the {@link #sender}.
	 *
	 * @param sender
	 *            the {@link #sender} to set.
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}

	/**
	 * Gets the {@link #recipient}.
	 *
	 * @return the {@link #recipient}.
	 */
	public User getRecipient() {
		return recipient;
	}

	/**
	 * Sets the {@link #recipient}.
	 *
	 * @param recipient
	 *            the {@link #recipient} to set.
	 */
	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	/**
	 * Gets the {@link #timestamp}.
	 *
	 * @return the {@link #timestamp}.
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the {@link #timestamp}.
	 *
	 * @param timestamp
	 *            the {@link #timestamp} to set.
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the {@link #message}.
	 *
	 * @return the {@link #message}.
	 */
	public IncomingMessage getMessage() {
		return message;
	}

	/**
	 * Sets the {@link #message}.
	 *
	 * @param message
	 *            the {@link #message} to set.
	 */
	public void setMessage(IncomingMessage message) {
		this.message = message;
	}

	/**
	 * Gets the {@link #postback}.
	 *
	 * @return the {@link #postback}.
	 */
	public Postback getPostback() {
		return postback;
	}

	/**
	 * Sets the {@link #postback}.
	 *
	 * @param postback
	 *            the {@link #postback} to set.
	 */
	public void setPostback(Postback postback) {
		this.postback = postback;
	}

	/**
	 * Gets the {@link #optin}.
	 *
	 * @return the {@link #optin}.
	 */
	public Optin getOptin() {
		return optin;
	}

	/**
	 * Sets the {@link #optin}.
	 *
	 * @param optin
	 *            the {@link #optin} to set.
	 */
	public void setOptin(Optin optin) {
		this.optin = optin;
	}

	/**
	 * Gets the {@link #accountLinking}.
	 *
	 * @return the {@link #accountLinking}.
	 */
	public AccountLinking getAccountLinking() {
		return accountLinking;
	}

	/**
	 * Sets the {@link #accountLinking}.
	 *
	 * @param accountLinking
	 *            the {@link #accountLinking} to set.
	 */
	public void setAccountLinking(AccountLinking accountLinking) {
		this.accountLinking = accountLinking;
	}

	/**
	 * Gets the {@link #delivery}.
	 *
	 * @return the {@link #delivery}.
	 */
	public DeliveredMessage getDelivery() {
		return delivery;
	}

	/**
	 * Sets the {@link #delivery}.
	 *
	 * @param delivery
	 *            the {@link #delivery} to set.
	 */
	public void setDelivery(DeliveredMessage delivery) {
		this.delivery = delivery;
	}

	/**
	 * Gets the {@link #read}.
	 *
	 * @return the {@link #read}.
	 */
	public Read getRead() {
		return read;
	}

	/**
	 * Sets the {@link #read}.
	 *
	 * @param read
	 *            the {@link #read} to set.
	 */
	public void setRead(Read read) {
		this.read = read;
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
	 * @param referral
	 *            the {@link #referral} to set.
	 */
	public void setReferral(Referral referral) {
		this.referral = referral;
	}

	/**
	 * Gets the {@link #payment}.
	 *
	 * @return the {@link #payment}.
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * Sets the {@link #payment}.
	 *
	 * @param payment
	 *            the {@link #payment} to set.
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * Gets the {@link #checkoutUpdate}.
	 *
	 * @return the {@link #checkoutUpdate}.
	 */
	public CheckoutUpdate getCheckoutUpdate() {
		return checkoutUpdate;
	}

	/**
	 * Sets the {@link #checkoutUpdate}.
	 *
	 * @param checkoutUpdate
	 *            the {@link #checkoutUpdate} to set.
	 */
	public void setCheckoutUpdate(CheckoutUpdate checkoutUpdate) {
		this.checkoutUpdate = checkoutUpdate;
	}

	/**
	 * Gets the {@link #preCheckout}.
	 *
	 * @return the {@link #preCheckout}.
	 */
	public PreCheckout getPreCheckout() {
		return preCheckout;
	}

	/**
	 * Sets the {@link #preCheckout}.
	 *
	 * @param preCheckout
	 *            the {@link #preCheckout} to set.
	 */
	public void setPreCheckout(PreCheckout preCheckout) {
		this.preCheckout = preCheckout;
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
		result = prime * result
				+ ((accountLinking == null) ? 0 : accountLinking.hashCode());
		result = prime * result
				+ ((checkoutUpdate == null) ? 0 : checkoutUpdate.hashCode());
		result = prime * result
				+ ((delivery == null) ? 0 : delivery.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((optin == null) ? 0 : optin.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result
				+ ((postback == null) ? 0 : postback.hashCode());
		result = prime * result
				+ ((preCheckout == null) ? 0 : preCheckout.hashCode());
		result = prime * result + ((read == null) ? 0 : read.hashCode());
		result = prime * result
				+ ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result
				+ ((referral == null) ? 0 : referral.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
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
		MessageEnvelope other = (MessageEnvelope) obj;
		if (accountLinking == null) {
			if (other.accountLinking != null)
				return false;
		} else if (!accountLinking.equals(other.accountLinking))
			return false;
		if (checkoutUpdate == null) {
			if (other.checkoutUpdate != null)
				return false;
		} else if (!checkoutUpdate.equals(other.checkoutUpdate))
			return false;
		if (delivery == null) {
			if (other.delivery != null)
				return false;
		} else if (!delivery.equals(other.delivery))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (optin == null) {
			if (other.optin != null)
				return false;
		} else if (!optin.equals(other.optin))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (postback == null) {
			if (other.postback != null)
				return false;
		} else if (!postback.equals(other.postback))
			return false;
		if (preCheckout == null) {
			if (other.preCheckout != null)
				return false;
		} else if (!preCheckout.equals(other.preCheckout))
			return false;
		if (read == null) {
			if (other.read != null)
				return false;
		} else if (!read.equals(other.read))
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (referral == null) {
			if (other.referral != null)
				return false;
		} else if (!referral.equals(other.referral))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
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
		return "MessageEnvelope [sender=" + sender + ", recipient=" + recipient
				+ ", timestamp=" + timestamp + ", message=" + message
				+ ", postback=" + postback + ", optin=" + optin
				+ ", accountLinking=" + accountLinking + ", delivery="
				+ delivery + ", read=" + read + ", referral=" + referral
				+ ", payment=" + payment + ", checkoutUpdate=" + checkoutUpdate
				+ ", preCheckout=" + preCheckout + "]";
	}

}
