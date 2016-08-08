package co.aurasphere.facebot.model.outcoming.action;

import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.validator.FaceBotValidator;

import com.google.gson.annotations.SerializedName;

/**
 * A {@link FaceBotResponse} which replies with a {@link TypingAction}.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class FaceBotActionResponse extends FaceBotResponse {

	private static final long serialVersionUID = 1L;

	@SerializedName("sender_action")
	private TypingAction action;

	public FaceBotActionResponse(User recipient, TypingAction action) {
		FaceBotValidator.notNull(action, "Typing Action");
		this.recipient = recipient;
		this.action = action;
	}

	public TypingAction getAction() {
		return action;
	}

	public void setAction(TypingAction action) {
		this.action = action;
	}

}
