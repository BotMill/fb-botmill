package co.aurasphere.botmill.fb.model.incoming;

import java.io.Serializable;
import java.util.List;


/**
 * Represents a received callback from Facebook's Messenger Platform.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#format"
 *      >Facebook's Messenger Platform Common Format Documentation</a>
 * @date Aug 08, 2016
 */
public class MessengerCallbackEntry implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Page ID of page.
	 */
	private String id;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
	/**
	 * Time of update (epoch time in milliseconds).
	 */
	private String time;

	/**
	 * A list of {@link MessageEnvelope} that contains all the callback details.
	 */
	private List<MessageEnvelope> messaging;

	/**
	 * Gets the {@link #id}.
	 *
	 * @return the {@link #id}.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the {@link #id}.
	 *
	 * @param id
	 *            the {@link #id} to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the {@link #time}.
	 *
	 * @return the {@link #time}.
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Sets the {@link #time}.
	 *
	 * @param time
	 *            the {@link #time} to set.
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * Gets the {@link #messaging}.
	 *
	 * @return the {@link #messaging}.
	 */
	public List<MessageEnvelope> getMessaging() {
		return messaging;
	}

	/**
	 * Sets the {@link #messaging}.
	 *
	 * @param messaging
	 *            the {@link #messaging} to set.
	 */
	public void setMessaging(List<MessageEnvelope> messaging) {
		this.messaging = messaging;
	}
}
