package co.aurasphere.botmill.fb.model.incoming;

import java.io.Serializable;
import java.util.List;


/**
 * The base model of the Facebook's Messenger Platform callback. Used to model
 * all the received callbacks.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#format"
 *      >Facebook's Messenger Platform Common Format Documentation</a>
 * 
 */
public class MessengerCallback implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
	/**
	 * The type of callback. This always evaluates to "page".
	 */
	private String object;

	/**
	 * A list of {@link MessengerCallbackEntry} for the current callback
	 * containing event data.
	 */
	private List<MessengerCallbackEntry> entry;

	/**
	 * Gets the {@link #object}.
	 *
	 * @return the {@link #object}.
	 */
	public String getObject() {
		return object;
	}

	/**
	 * Sets the {@link #object}.
	 *
	 * @param object
	 *            the {@link #object} to set.
	 */
	public void setObject(String object) {
		this.object = object;
	}

	/**
	 * Gets the {@link #entry}.
	 *
	 * @return the {@link #entry}.
	 */
	public List<MessengerCallbackEntry> getEntry() {
		return entry;
	}

	/**
	 * Sets the {@link #entry}.
	 *
	 * @param entry
	 *            the {@link #entry} to set.
	 */
	public void setEntry(List<MessengerCallbackEntry> entry) {
		this.entry = entry;
	}
}
