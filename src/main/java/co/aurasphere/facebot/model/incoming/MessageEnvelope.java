package co.aurasphere.facebot.model.incoming;

import java.io.Serializable;

import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.incoming.callback.AccountLinking;
import co.aurasphere.facebot.model.incoming.callback.Delivery;
import co.aurasphere.facebot.model.incoming.callback.IncomingMessageBody;
import co.aurasphere.facebot.model.incoming.callback.Optin;
import co.aurasphere.facebot.model.incoming.callback.Postback;
import co.aurasphere.facebot.model.incoming.callback.Read;

import com.google.gson.annotations.SerializedName;

/**
 * A generic incoming message envelope.
 * 
 * @author Donato
 * @date 31/lug/2016
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
	 * message and message_echoes callback content.
	 */
	private IncomingMessageBody message;
	
	/**
	 * messaging_postbacks callback content.
	 */
	private Postback postback;
	
	/**
	 * messaging_optins callback content.
	 */
	private Optin optin;
	
	/**
	 * Account linking callback content.
	 */
	@SerializedName("account_linking")
	private AccountLinking accountLinking;
	
	/**
	 * message_deliveries callback content.
	 */
	private Delivery delivery;
	
	/**
	 * message_reads callback content.
	 */
	private Read read;
	
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

}
