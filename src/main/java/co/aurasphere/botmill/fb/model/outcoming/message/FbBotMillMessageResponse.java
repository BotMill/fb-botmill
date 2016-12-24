package co.aurasphere.botmill.fb.model.outcoming.message;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;

/**
 * A {@link FbBotMillResponse} which replies with a {@link Message}.
 * 
 * @author Donato Rimenti
 * @date Dec 24, 2016
 */
public class FbBotMillMessageResponse extends FbBotMillResponse {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The message associated with this reply.
	 */
	@Valid
	@NotNull
	private Message message;

	/**
	 * Instantiates a new FbBotMillMessageResponse.
	 *
	 * @param recipient the {@link FbBotMillResponse#recipient}.
	 * @param message the {@link #message}.
	 */
	public FbBotMillMessageResponse(User recipient, Message message) {
		this.recipient = recipient;
		this.message = message;
	}

	/**
	 * Gets the {@link #message}.
	 *
	 * @return the {@link #message}.
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * Sets the {@link #message}.
	 *
	 * @param message the {@link #message} to set.
	 */
	public void setMessage(Message message) {
		this.message = message;
	}

}
