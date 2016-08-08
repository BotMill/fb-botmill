package co.aurasphere.facebot.model.incoming;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a received callback from Facebook's Messenger Platform.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class MessengerCallbackEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The entry id.
	 */
	private String id;

	/**
	 * The entry timestamp.
	 */
	private String time;

	/**
	 * A list of {@link MessageEnvelope} that contains all the callback details.
	 */
	private List<MessageEnvelope> messaging;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<MessageEnvelope> getMessaging() {
		return messaging;
	}

	public void setMessaging(List<MessageEnvelope> messaging) {
		this.messaging = messaging;
	}
}
