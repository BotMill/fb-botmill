package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.action.FbBotMillActionResponse;
import co.aurasphere.botmill.fb.model.outcoming.action.TypingAction;


/**
 * A builder for a response which contains and performs a {@link TypingAction}.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/sender-actions"
 *      > Facebook's Messenger Platform Sender Actions Documentation</a>
 * 
 */
public class ActionResponseBuilder extends FbBotMillMockableBuilder {

	/**
	 * The action to perform.
	 */
	private TypingAction action;

	/**
	 * Instantiates a new action response builder.
	 *
	 * @param action the {@link #action}.
	 */
	ActionResponseBuilder(TypingAction action) {
		this.action = action;
	}

	/**
	 * {@inheritDoc} It returns a {@link FbBotMillActionResponse} with the
	 * {@link TypingAction} to perform.
	 */
	public FbBotMillResponse build(MessageEnvelope envelope) {
		User recipient = getRecipient(envelope);
		return new FbBotMillActionResponse(recipient, action);
	}

}
