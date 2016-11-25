package co.aurasphere.facebot.autoreply;

import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.factory.ReplyFactory;

/**
 * An {@link AutoReply} that replies with a specified message.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class MessageAutoReply extends AutoReply {

	/**
	 * The reply message.
	 */
	private String replyMessage;

	/**
	 * Default constructor.
	 * 
	 * @param replyMessage
	 *            the reply message. It can't be null or empty.
	 */
	public MessageAutoReply(String replyMessage) {
		this.replyMessage = replyMessage;
	}

	/**
	 * {@inheritDoc} It replies with the message specified in the constructor.
	 */
	public FaceBotResponse createResponse(MessageEnvelope envelope) {
		return ReplyFactory.addTextMessageOnly(replyMessage).build(envelope);
	}

}
