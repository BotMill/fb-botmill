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
import co.aurasphere.botmill.fb.model.incoming.callback.Optin;
import co.aurasphere.botmill.fb.model.incoming.callback.Postback;
import co.aurasphere.botmill.fb.model.incoming.callback.Read;
import co.aurasphere.botmill.fb.model.incoming.callback.ReceivedMessage;
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
	private ReceivedMessage message;

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
	public ReceivedMessage getMessage() {
		return message;
	}

	/**
	 * Sets the {@link #message}.
	 *
	 * @param message
	 *            the {@link #message} to set.
	 */
	public void setMessage(ReceivedMessage message) {
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

}
