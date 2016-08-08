package co.aurasphere.facebot.model.outcoming;

import java.io.Serializable;

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
	protected User recipient;

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

}
