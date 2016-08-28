package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.action.FaceBotActionResponse;
import co.aurasphere.facebot.model.outcoming.action.TypingAction;

/**
 * A builder for a response which contains and performs a {@link TypingAction}.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/sender-actions"
 *      > Facebook's Messenger Platform Sender Actions Documentation</a>
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class ActionResponseBuilder extends FaceBotMockableBuilder {

	/**
	 * The action to perform.
	 */
	private TypingAction action;

	/**
	 * Default constructor. Creates a builder for a response which contains and
	 * performs a {@link TypingAction}.
	 * 
	 * @param action
	 *            the action to perform.
	 */
	ActionResponseBuilder(TypingAction action) {
		this.action = action;
	}

	/**
	 * {@inheritDoc} It returns a {@link FaceBotActionResponse} with the
	 * {@link TypyingAction} to perform.
	 */
	public FaceBotResponse build(MessageEnvelope envelope) {
		User recipient = getRecipient(envelope);
		return new FaceBotActionResponse(recipient, action);
	}

}
