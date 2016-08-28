package co.aurasphere.facebot.model.outcoming.message;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;

public class FaceBotMessageResponse extends FaceBotResponse{

	private static final long serialVersionUID = 1L;

	@Valid
	@NotNull
	private Message message;

	public FaceBotMessageResponse(User recipient, Message message) {
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
