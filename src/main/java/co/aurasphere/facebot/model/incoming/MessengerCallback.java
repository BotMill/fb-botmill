package co.aurasphere.facebot.model.incoming;

import java.io.Serializable;
import java.util.List;

/**
 * The base model of the Facebook's Messenger Platform callback. Used to model all
 * the received callbacks.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public class MessengerCallback implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The type of callback. This always evaluates to "page".
	 */
	private String object;

	/**
	 * A list of {@link MessengerCallbackEntry} for the current callback.
	 */
	private List<MessengerCallbackEntry> entry;

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public List<MessengerCallbackEntry> getEntry() {
		return entry;
	}

	public void setEntry(List<MessengerCallbackEntry> entry) {
		this.entry = entry;
	}
}
