package co.aurasphere.facebot.model.outcoming;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.facebot.model.base.User;

/**
 * Object that represents a FaceBot response.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public abstract class FaceBotResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The recipient of the message.
	 */
	@Valid
	@NotNull
	protected User recipient;

	/**
	 * Gets the recipient of the message.
	 * 
	 * @return an {@link User} object that represents the recipient.
	 */
	public User getRecipient() {
		return recipient;
	}

	/**
	 * Sets the recipient of the message.
	 * 
	 * @param recipient
	 *            an {@link User} object that represents the recipient.
	 */
	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

}
