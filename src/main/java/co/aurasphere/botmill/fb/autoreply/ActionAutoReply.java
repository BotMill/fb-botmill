package co.aurasphere.botmill.fb.autoreply;

import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.action.TypingAction;
import co.aurasphere.botmill.fb.model.outcoming.factory.ReplyFactory;


/**
 * An {@link AutoReply} that replies with a {@link TypingAction}.
 * 
 * @author Donato Rimenti
 * 
 */
public class ActionAutoReply extends AutoReply {

	/**
	 * The {@link TypingAction} to perform.
	 */
	private TypingAction typingAction;

	/**
	 * Instantiates a new action auto reply.
	 *
	 * @param typingAction the {@link #typingAction}.
	 */
	public ActionAutoReply(TypingAction typingAction) {
		this.typingAction = typingAction;
	}

	/**
	 * {@inheritDoc} Replies with a {@link TypingAction}.
	 */
	@Override
	public FbBotMillResponse createResponse(MessageEnvelope envelope) {
		return ReplyFactory.addTypingAction(this.typingAction).build(envelope);
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
		result = prime * result + ((typingAction == null) ? 0 : typingAction.hashCode());
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
		ActionAutoReply other = (ActionAutoReply) obj;
		if (typingAction != other.typingAction)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActionAutoReply [action=" + typingAction + "]";
	}

}
