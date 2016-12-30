package co.aurasphere.botmill.fb.model.outcoming.action;

import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;

import com.google.gson.annotations.SerializedName;


/**
 * A {@link FbBotMillResponse} which replies with a {@link TypingAction}.
 * 
 * @author Donato Rimenti
 * 
 */
public class FbBotMillActionResponse extends FbBotMillResponse {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The typing action to send.
	 */
	@NotNull
	@SerializedName("sender_action")
	private TypingAction action;

	/**
	 * Instantiates a new fb bot mill action response.
	 *
	 * @param recipient the {@link FbBotMillResponse#recipient}.
	 * @param action the {@link #action}.
	 */
	public FbBotMillActionResponse(User recipient, TypingAction action) {
		this.recipient = recipient;
		this.action = action;
	}

	/**
	 * Gets the {@link #action}.
	 *
	 * @return the {@link #action}.
	 */
	public TypingAction getAction() {
		return action;
	}

	/**
	 * Sets the {@link #action}.
	 *
	 * @param action the {@link #action} to set.
	 */
	public void setAction(TypingAction action) {
		this.action = action;
	}

}
