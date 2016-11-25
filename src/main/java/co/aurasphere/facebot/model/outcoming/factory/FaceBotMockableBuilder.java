package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.test.FaceBotMockMediator;

/**
 * Abstract class for a {@link FaceBotResponseBuilder} that can be populated
 * with a mock recipient for testing.
 * 
 * @author Donato
 * @date 27/ago/2016
 */
public abstract class FaceBotMockableBuilder extends FaceBotResponseBuilder {

	/**
	 * Returns the recipient of the envelope. If
	 * {@link FaceBotMockMediatort#isMockEnabled()} evaluates to true returns a
	 * mock recipient with ID of {@link FaceBotMockMediator#getFacebookMockId()}
	 * , otherwise gets the recipient as the sender of the received envelope to
	 * reply.
	 * 
	 * @param envelope
	 *            the incoming envelope.
	 * @return the recipient.
	 */
	protected User getRecipient(MessageEnvelope envelope) {
		if (FaceBotMockMediator.isMockEnabled()) {
			return new User(FaceBotMockMediator.getFacebookMockId());
		}
		return safeGetSender(envelope);
	}
}
