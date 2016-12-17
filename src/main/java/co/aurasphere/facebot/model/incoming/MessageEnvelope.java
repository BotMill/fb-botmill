package co.aurasphere.facebot.model.incoming;

import java.io.Serializable;

import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.incoming.callback.AccountLinking;
import co.aurasphere.facebot.model.incoming.callback.CheckoutUpdate;
import co.aurasphere.facebot.model.incoming.callback.Delivery;
import co.aurasphere.facebot.model.incoming.callback.IncomingMessageBody;
import co.aurasphere.facebot.model.incoming.callback.Optin;
import co.aurasphere.facebot.model.incoming.callback.Postback;
import co.aurasphere.facebot.model.incoming.callback.Read;
import co.aurasphere.facebot.model.incoming.callback.Referral;
import co.aurasphere.facebot.model.incoming.callback.payment.Payment;

import com.google.gson.annotations.SerializedName;

/**
 * A generic incoming message envelope.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class MessageEnvelope implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * The message sender.
	 */
	private User sender;
	
	/**
	 * The message recipient.
	 */
	private User recipient;
	
	/**
	 * The message timestamp.
	 */
	private String timestamp;
	
	/**
	 * Message content for message and message_echoes callback.
	 */
	private IncomingMessageBody message;
	
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
	private Delivery delivery;
	
	/**
	 * Read object for message_reads callback.
	 */
	private Read read;
	
	/**
	 * Referral object for messaging_referral callback.
	 */
	private Referral referral;
	
	/**
	 * Payment object for messaging_payments  callback.
	 */
	private Payment payment;
	
	@SerializedName("checkout_update")
	private CheckoutUpdate checkoutUpdate;
	
	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public IncomingMessageBody getMessage() {
		return message;
	}

	public void setMessage(IncomingMessageBody message) {
		this.message = message;
	}

	public Postback getPostback() {
		return postback;
	}

	public void setPostback(Postback postback) {
		this.postback = postback;
	}

	public Optin getOptin() {
		return optin;
	}

	public void setOptin(Optin optin) {
		this.optin = optin;
	}

	public AccountLinking getAccountLinking() {
		return accountLinking;
	}

	public void setAccountLinking(AccountLinking accountLinking) {
		this.accountLinking = accountLinking;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Read getRead() {
		return read;
	}

	public void setRead(Read read) {
		this.read = read;
	}

	public Referral getReferral() {
		return referral;
	}

	public void setReferral(Referral referral) {
		this.referral = referral;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public CheckoutUpdate getCheckoutUpdate() {
		return checkoutUpdate;
	}

	public void setCheckoutUpdate(CheckoutUpdate checkoutUpdate) {
		this.checkoutUpdate = checkoutUpdate;
	}

}
