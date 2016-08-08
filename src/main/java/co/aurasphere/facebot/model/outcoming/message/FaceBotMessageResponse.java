package co.aurasphere.facebot.model.outcoming.message;

import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.validator.FaceBotValidator;

public class FaceBotMessageResponse extends FaceBotResponse{

	private static final long serialVersionUID = 1L;

	private Message message;

	public FaceBotMessageResponse(User recipient, Message message) {
		FaceBotValidator.notNull(message, "Message");
		this.recipient = recipient;
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
