package co.aurasphere.facebot;

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.facebot.actionframe.ActionFrame;
import co.aurasphere.facebot.autoreply.AutoReply;
import co.aurasphere.facebot.event.FaceBotEvent;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;

/**
 * Class that represents a FaceBot. Each FaceBot has a list of
 * {@link FaceBotEvent}. An event is a callback from Facebook Messenger
 * Platform. There may be different events, according to what your app has
 * registered for (for more info check the link below). At each callback
 * received from Facebook, all registered FaceBots callbacks handler are
 * checked. If any callback condition is verified, then the handleCallback
 * method is called.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      > Facebook Messenger Platform callbacks</a>
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class FaceBot {

	/**
	 * A list of registered {@link FaceBotEvent} for the current FaceBot.
	 */
	private List<ActionFrame> actionFrameList;

	/**
	 * The policy this bot follows when processing the callback handler list.
	 */
	private FaceBotPolicy policy;

	/**
	 * Base constructor. Initializes the callback handler list and the policy to
	 * a default value of {@link FaceBotPolicy#FIRST_ONLY} and registers this
	 * bot on the FaceBotContext.
	 */
	public FaceBot() {
		this(FaceBotPolicy.FIRST_ONLY);
	}

	/**
	 * Constructor which initializes the callback handler list and the policy to
	 * a default value of and registers this bot on the FaceBotContext.
	 *
	 * @param policy
	 *            the policy this FaceBot will use when processing the callback
	 *            chain.
	 */
	public FaceBot(FaceBotPolicy policy) {
		if (policy == null) {
			policy = FaceBotPolicy.FIRST_ONLY;
		}
		this.policy = policy;
		this.actionFrameList = new ArrayList<ActionFrame>();
		FaceBotContext.getInstance().register(this);
	}

	/**
	 * Adds an {@link ActionFrame} to this FaceBot.
	 * 
	 * @param actionFrame
	 *            the actionFrame to add.
	 */
	public void addActionFrame(ActionFrame actionFrame) {
		actionFrameList.add(actionFrame);
	}

	/**
	 * Adds an {@link ActionFrame} to this FaceBot.
	 * 
	 * @param event
	 *            the {@link FaceBotEvent} to handle.
	 * @param reply
	 *            the {@link AutoReply} which should handle the event.
	 */
	public void addActionFrame(FaceBotEvent event, AutoReply reply) {
		ActionFrame frame = new ActionFrame(event, reply);
		actionFrameList.add(frame);
	}

	/**
	 * Checks if there's any registered {@link FaceBotEvent} for the incoming
	 * callback. If there's any, then the callback is handled. The chain will be
	 * processed according to the {@link FaceBotPolicy} followed by this
	 * FaceBot. If the policy is {@link FaceBotPolicy#FIRST_ONLY}, the chain
	 * will be processed until the first callback matches. Otherwise, if the
	 * policy is {@link FaceBotPolicy#PROCESS_ALL}, all the chain will always be
	 * processed.
	 * 
	 * @param envelope
	 *            the incoming message.
	 */
	public void processMessage(MessageEnvelope envelope) {
		for (ActionFrame f : actionFrameList) {
			// If the policy is FIRST_ONLY stop processing the chain at the
			// first trigger.
			if (f.process(envelope) && policy.equals(FaceBotPolicy.FIRST_ONLY)) {
				break;
			}
		}
	}

}
