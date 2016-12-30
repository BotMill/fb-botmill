package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.test.support.FbBotMillMockMediator;


/**
 * Abstract class for a {@link FbBotMillResponseBuilder} that can be populated
 * with a mock recipient for testing.
 * 
 * @author Donato Rimenti
 * 
 */
public abstract class FbBotMillMockableBuilder extends FbBotMillResponseBuilder {

	/**
	 * Returns the recipient of the envelope. If
	 * {@link FbBotMillMockMediator#isMockEnabled()} evaluates to true returns a
	 * mock recipient with ID of {@link FbBotMillMockMediator#getFacebookMockId()}
	 * , otherwise gets the recipient as the sender of the received envelope to
	 * reply.
	 * 
	 * @param envelope
	 *            the incoming envelope.
	 * @return the recipient.
	 */
	protected User getRecipient(MessageEnvelope envelope) {
		if (FbBotMillMockMediator.isMockEnabled()) {
			return new User(FbBotMillMockMediator.getFacebookMockId());
		}
		return safeGetSender(envelope);
	}
}
