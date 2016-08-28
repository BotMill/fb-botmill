package co.aurasphere.facebot.autoreply;

import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.action.TypingAction;
import co.aurasphere.facebot.model.outcoming.factory.ReplyFactory;

/**
 * An {@link AutoReply} that replies with a {@link TypingAction}.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class ActionAutoReply extends AutoReply {

	/**
	 * The action to perform.
	 */
	private TypingAction action;

	/**
	 * Object constructor.
	 * 
	 * @param action
	 *            the action to perform. Can't be null.
	 */
	public ActionAutoReply(TypingAction action) {
		this.action = action;
	}

	/**
	 * {@inheritDoc} Replies with a {@link TypingAction}.
	 */
	@Override
	public FaceBotResponse createResponse(MessageEnvelope envelope) {
		return ReplyFactory.addTypingAction(action).build(envelope);
	}

}
