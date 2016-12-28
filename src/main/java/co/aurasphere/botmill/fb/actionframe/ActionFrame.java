package co.aurasphere.botmill.fb.actionframe;

import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


// TODO: Auto-generated Javadoc
/**
 * Class that represents a {@link FbBotMillEvent} and the {@link AutoReply} to it.
 * 
 * @author Donato Rimenti
 * @date Dec 18, 2016
 */
public class ActionFrame {

	/**
	 * The event of this frame that will trigger the reply.
	 */
	private FbBotMillEvent event;

	/**
	 * The reply of this frame to send if the event is triggered.
	 */
	private AutoReply reply;
	
	/**
	 * The replies of this frame to send if the event is triggered.
	 */
	private AutoReply[] replies;

	/**
	 * Gets the reply.
	 *
	 * @return the reply
	 */
	public AutoReply getReply() {
		return reply;
	}

	/**
	 * Gets the replies.
	 *
	 * @return the replies
	 */
	public AutoReply[] getReplies() {
		return replies;
	}

	/**
	 * Instantiates a new action frame.
	 *
	 * @param event
	 *            the {@link #event}.
	 * @param reply
	 *            the {@link #reply}.
	 */
	public ActionFrame(FbBotMillEvent event, AutoReply reply) {
		this.event = event;
		this.reply = reply;
	}
	
	/**
	 * Instantiates a new action frame with multiple / collection replies.
	 *
	 * @param event            the {@link #event}.
	 * @param replies            the list of {@link #reply}.
	 */
	public ActionFrame(FbBotMillEvent event, AutoReply... replies) {
		this.event = event;
		this.replies = replies;
	}

	/**
	 * Executes the reply if the event is triggered.
	 *
	 * @param envelope
	 *            the incoming message.
	 * @return true, if the event has been triggered.
	 */
	public boolean process(MessageEnvelope envelope) {
		if (this.event == null) {
			return false;
		}
		boolean triggered = this.event.verifyEventCondition(envelope);
		if (triggered) {
			beforeReply(envelope);
			if (this.reply != null) {
				this.reply.reply(envelope);
			}
			afterReply(envelope);
		}
		return triggered;
	}
	
	/**
	 * Executes multiple replies when multiple autoreply is set.
	 * @param envelope
	 *            the incoming message.
	 * @return true, if the event has been triggered.
	 */
	public boolean processMultipleReply(MessageEnvelope envelope) {
		if (this.event == null) {
			return false;
		}
		boolean triggered = this.event.verifyEventCondition(envelope);
		if (triggered) {
			beforeReply(envelope);
			if (this.replies != null) {
				for(AutoReply reply: replies) {
					reply.reply(envelope);
				}
			}
			afterReply(envelope);
		}
		return triggered;
	}

	/**
	 * Convenience method executed before the reply is sent to the user. Default
	 * implementation does nothing, but you can override it with your desired
	 * behavior.
	 * 
	 * @param envelope
	 *            the incoming message.
	 */
	public void beforeReply(MessageEnvelope envelope) {
	};

	/**
	 * Convenience method executed after the reply is sent to the user. Default
	 * implementation does nothing, but you can override it with your desired
	 * behavior.
	 * 
	 * @param envelope
	 *            the incoming message.
	 */
	public void afterReply(MessageEnvelope envelope) {
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
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((reply == null) ? 0 : reply.hashCode());
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
		ActionFrame other = (ActionFrame) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (reply == null) {
			if (other.reply != null)
				return false;
		} else if (!reply.equals(other.reply))
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
		return "ActionFrame [event=" + event + ", reply=" + reply + "]";
	};

}
