package co.aurasphere.facebot.util;

import java.util.List;

import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.incoming.MessengerCallback;

/**
 * A class of utilities used to manipulate the Facebook Messenger Platform
 * model.
 * 
 * @author Donato
 * @date 31/lug/2016
 */
public class EnvelopeUtils {

	/**
	 * Retrieves the last envelope from a messenger callback. With each callback,
	 * Facebook Messenger Platform will send back all the conversation with that
	 * user. This method is used to retrieve only the last message.
	 * 
	 * @param callback
	 *            the messenger callback.
	 * @return the last message from the user if found, null otherwise.
	 */
	public static MessageEnvelope getLastEnvelope(MessengerCallback callback) {
		if (callback != null && callback.getEntry() != null
				&& callback.getEntry().get(0) != null
				&& callback.getEntry().get(0).getMessaging() != null) {
			List<MessageEnvelope> messageList = callback.getEntry().get(0)
					.getMessaging();
			// The last message is the last element of the message list.
			return messageList.get(messageList.size() - 1);
		}
		return null;
	}

}
