package co.aurasphere.facebot.autoreply;

import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.factory.ReplyFactory;

/**
 * An {@link AutoReply} that replies with the last received message. Mostly used
 * for testing and demo purposes.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class EchoAutoReply extends AutoReply {

	/**
	 * {@inheritDoc} It replies with the last received message.
	 */
	public FaceBotResponse createResponse(MessageEnvelope envelope) {
		String lastMessage = safeGetMessage(envelope);
		return ReplyFactory.addTextMessageOnly(lastMessage).build(envelope);
	}

}
