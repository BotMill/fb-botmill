package co.aurasphere.botmill.fb.autoreply;

import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.factory.ReplyFactory;

/**
 * An {@link AutoReply} that replies with the last received message. Mostly used
 * for testing and demo purposes.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class EchoAutoReply extends AutoReply {

	/**
	 * {@inheritDoc} It replies with the last received message.
	 */
	public FbBotMillResponse createResponse(MessageEnvelope envelope) {
		String lastMessage = safeGetMessage(envelope);
		return ReplyFactory.addTextMessageOnly(lastMessage).build(envelope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.facebot.autoreply.AutoReply#toString()
	 */
	@Override
	public String toString() {
		return "EchoAutoReply []";
	}

}
