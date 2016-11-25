package co.aurasphere.facebot.bean;

import co.aurasphere.facebot.event.FaceBotEventType;
import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.incoming.callback.EchoMessage;
import co.aurasphere.facebot.model.incoming.callback.IncomingMessageBody;
import co.aurasphere.facebot.model.outcoming.message.Message;

/**
 * Base FaceBot bean which contains utility methods for handling an envelope.
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class FaceBotBean {

	/**
	 * Retrieves a text message from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the text message if found or an empty String otherwise. It never
	 *         returns null.
	 */
	protected String safeGetMessage(MessageEnvelope envelope) {
		if (envelope != null && envelope.getMessage() != null
				&& envelope.getMessage().getText() != null) {
			return envelope.getMessage().getText();
		}
		return "";
	}

	/**
	 * Retrieves a text message from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the message envelope if found or an empty String otherwise. It
	 *         never returns null.
	 */
	protected String safeGetPostbackPayload(MessageEnvelope envelope) {
		if (envelope != null && envelope.getPostback() != null
				&& envelope.getPostback().getPayload() != null) {
			return envelope.getPostback().getPayload();
		}
		return "";
	}

	/**
	 * Retrieves the recipient ID from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the recipient ID if found or an empty String otherwise. It never
	 *         returns null.
	 */
	protected String safeGetRecipientId(MessageEnvelope envelope) {
		if (envelope != null && envelope.getRecipient() != null
				&& envelope.getRecipient().getId() != null) {
			return envelope.getRecipient().getId();
		}
		return "";
	}

	/**
	 * Retrieves the sender ID from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return the sender ID if found or an empty String otherwise. It never
	 *         returns null.
	 */
	protected String safeGetSenderId(MessageEnvelope envelope) {
		if (envelope != null && envelope.getSender() != null
				&& envelope.getSender().getId() != null) {
			return envelope.getSender().getId();
		}
		return "";
	}

	/**
	 * Retrieves the recipient from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return a {@link User} containing the recipient if found, empty
	 *         otherwise. It never returns null.
	 */
	protected User safeGetRecipient(MessageEnvelope envelope) {
		if (envelope != null && envelope.getRecipient() != null
				&& envelope.getRecipient().getId() != null) {
			return envelope.getRecipient();
		}
		return new User();
	}

	/**
	 * Retrieves the sender from an envelope. It never returns null.
	 * 
	 * @param envelope
	 *            the message envelope.
	 * @return a {@link User} containing the sender if found, empty otherwise.
	 *         It never returns null.
	 */
	protected User safeGetSender(MessageEnvelope envelope) {
		if (envelope != null && envelope.getSender() != null
				&& envelope.getSender().getId() != null) {
			return envelope.getSender();
		}
		return new User();
	}
	
	/**
	 * Returns the kind of callback received for the current envelope.
	 * 
	 * @param envelope
	 *            the envelope to inspect.
	 * @return a {@link FaceBotEventType} representing the current callback
	 *         type.
	 */
	protected FaceBotEventType eventKind(MessageEnvelope envelope) {
		Message message = envelope.getMessage();
		if (message != null) {
			if (message instanceof IncomingMessageBody) {
				return FaceBotEventType.MESSAGE;
			}
			if (message instanceof EchoMessage) {
				return FaceBotEventType.ECHO;
			}
		}
		if (envelope.getPostback() != null) {
			return FaceBotEventType.POSTBACK;
		}
		if (envelope.getDelivery() != null) {
			return FaceBotEventType.DELIVERY;
		}
		if (envelope.getRead() != null) {
			return FaceBotEventType.READ;
		}
		if (envelope.getAccountLinking() != null) {
			return FaceBotEventType.ACCOUNT_LINKING;
		}
		if (envelope.getOptin() != null) {
			return FaceBotEventType.AUTHENTICATION;
		}
		return FaceBotEventType.ANY;
	}

}
