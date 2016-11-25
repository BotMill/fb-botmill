package co.aurasphere.facebot.actionframe;

import co.aurasphere.facebot.autoreply.AutoReply;
import co.aurasphere.facebot.event.FaceBotEvent;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;

public class ActionFrame {

	private FaceBotEvent event;

	private AutoReply reply;

	public ActionFrame(FaceBotEvent event, AutoReply reply) {
		this.event = event;
		this.reply = reply;
	}

	public boolean process(MessageEnvelope envelope) {
		if (event == null) {
			return false;
		}
		boolean triggered = event.verifyEventCondition(envelope);
		if (triggered) {
			beforeReply(envelope);
			if (reply != null) {
				reply.reply(envelope);
			}
			afterReply(envelope);
		}
		return triggered;
	}

	/**
	 * Executed before the reply is sent to the user.
	 * 
	 * @param envelope the incoming message.
	 */
	public void beforeReply(MessageEnvelope envelope) {
	};

	/**
	 * Executed after the reply is sent to the user.
	 * 
	 * @param envelope the incoming message.
	 */
	public void afterReply(MessageEnvelope envelope) {
	};

}
