package co.aurasphere.botmill.fb.autoreply;

import org.hibernate.validator.constraints.NotBlank;

import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.factory.ReplyFactory;


/**
 * An {@link AutoReply} that replies with a specified message.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class MessageAutoReply extends AutoReply {

	/**
	 * The reply message. It can't be blank.
	 */
	@NotBlank
	private String replyMessage;

	/**
	 * Instantiates a new message auto reply.
	 *
	 * @param replyMessage
	 *            the {@link #replyMessage}.
	 */
	public MessageAutoReply(String replyMessage) {
		this.replyMessage = replyMessage;
	}

	/**
	 * {@inheritDoc} It replies with the message specified in the constructor.
	 */
	public FbBotMillResponse createResponse(MessageEnvelope envelope) {
		return ReplyFactory.addTextMessageOnly(this.replyMessage).build(
				envelope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((replyMessage == null) ? 0 : replyMessage.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageAutoReply other = (MessageAutoReply) obj;
		if (replyMessage == null) {
			if (other.replyMessage != null)
				return false;
		} else if (!replyMessage.equals(other.replyMessage))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see co.aurasphere.botmill.fb.autoreply.AutoReply#toString()
	 */
	@Override
	public String toString() {
		return "MessageAutoReply [replyMessage=" + replyMessage + "]";
	}

}
