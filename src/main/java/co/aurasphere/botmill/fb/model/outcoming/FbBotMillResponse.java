package co.aurasphere.botmill.fb.model.outcoming;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.base.User;

/**
 * Object that represents a FbBotMill response.
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public abstract class FbBotMillResponse implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The recipient of the message.
	 */
	@Valid
	@NotNull
	protected User recipient;

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
	 * @param recipient the {@link #recipient} to set.
	 */
	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

}
