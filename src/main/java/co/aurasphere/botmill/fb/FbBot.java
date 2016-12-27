package co.aurasphere.botmill.fb;

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.botmill.fb.actionframe.ActionFrame;
import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;


/**
 * Class that represents a FaceBot. Each FaceBot has a list of
 * {@link FbBotMillEvent}. An event is a callback from Facebook Messenger
 * Platform. There may be different events, according to what your app has
 * registered for (for more info check the link below). At each callback
 * received from Facebook, all registered FaceBots callbacks handler are
 * checked. If any callback condition is verified, then the handleCallback
 * method is called.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      > Facebook Messenger Platform callbacks</a>
 * @date Jul 31, 2016
 */
public class FbBot {

	/**
	 * A list of registered {@link FbBotMillEvent} for the current FaceBot.
	 */
	private List<ActionFrame> actionFrameList;

	/**
	 * The policy this bot follows when processing the callback handler list.
	 */
	private FbBotMillPolicy faceBotPolicy;

	/**
	 * Instantiates a new FaceBot with a default policy of
	 * {@link FbBotMillPolicy#FIRST_ONLY}.
	 */
	public FbBot() {
		this(FbBotMillPolicy.FIRST_ONLY);
	}

	/**
	 * Instantiates a new FaceBot.
	 *
	 * @param faceBotPolicy
	 *            the {@link #faceBotPolicy}.
	 */
	public FbBot(FbBotMillPolicy faceBotPolicy) {
		if (faceBotPolicy == null) {
			faceBotPolicy = FbBotMillPolicy.FIRST_ONLY;
		}
		this.faceBotPolicy = faceBotPolicy;
		this.actionFrameList = new ArrayList<ActionFrame>();
		FbBotMillContext.getInstance().register(this);
	}

	/**
	 * Adds an {@link ActionFrame} to this FaceBot.
	 * 
	 * @param actionFrame
	 *            the actionFrame to add.
	 */
	public void addActionFrame(ActionFrame actionFrame) {
		this.actionFrameList.add(actionFrame);
	}

	/**
	 * Adds an {@link ActionFrame} to this FaceBot.
	 * 
	 * @param event
	 *            the {@link FbBotMillEvent} to handle.
	 * @param reply
	 *            the {@link AutoReply} which should handle the event.
	 */
	public void addActionFrame(FbBotMillEvent event, AutoReply reply) {
		ActionFrame frame = new ActionFrame(event, reply);
		this.actionFrameList.add(frame);
	}

	/**
	 * Checks if there's any registered {@link FbBotMillEvent} for the incoming
	 * callback. If there's any, then the callback is handled. The chain will be
	 * processed according to the {@link FbBotMillPolicy} followed by this
	 * FaceBot. If the policy is {@link FbBotMillPolicy#FIRST_ONLY}, the chain
	 * will be processed until the first callback matches. Otherwise, if the
	 * policy is {@link FbBotMillPolicy#PROCESS_ALL}, all the chain will always be
	 * processed.
	 * 
	 * @param envelope
	 *            the incoming message.
	 */
	public void processMessage(MessageEnvelope envelope) {
		for (ActionFrame f : this.actionFrameList) {
			// If the policy is FIRST_ONLY stop processing the chain at the
			// first trigger.
			if (f.process(envelope)
					&& !this.faceBotPolicy.equals(FbBotMillPolicy.FIRST_ONLY)) {
				break;
			}
		}
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
				+ ((actionFrameList == null) ? 0 : actionFrameList.hashCode());
		result = prime * result
				+ ((faceBotPolicy == null) ? 0 : faceBotPolicy.hashCode());
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
		FbBot other = (FbBot) obj;
		if (actionFrameList == null) {
			if (other.actionFrameList != null)
				return false;
		} else if (!actionFrameList.equals(other.actionFrameList))
			return false;
		if (faceBotPolicy != other.faceBotPolicy)
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
		return "FaceBot [actionFrameList=" + actionFrameList + ", policy="
				+ faceBotPolicy + "]";
	}

}
