package co.aurasphere.facebot.model.outcoming.factory;

import java.util.ArrayList;

import co.aurasphere.facebot.model.base.Attachment;
import co.aurasphere.facebot.model.base.AttachmentType;
import co.aurasphere.facebot.model.base.User;
import co.aurasphere.facebot.model.incoming.MessageEnvelope;
import co.aurasphere.facebot.model.outcoming.FaceBotResponse;
import co.aurasphere.facebot.model.outcoming.message.AttachmentMessage;
import co.aurasphere.facebot.model.outcoming.message.FaceBotMessageResponse;
import co.aurasphere.facebot.model.outcoming.message.Message;
import co.aurasphere.facebot.model.outcoming.payload.Payload;
import co.aurasphere.facebot.model.outcoming.payload.UrlPayload;
import co.aurasphere.facebot.model.outcoming.quickreply.QuickReply;

/**
 * Builder for a {@link Message} that contains an {@link Attachment}.
 * 
 * @author Donato
 * @date 26/ago/2016
 */
public class AttachmentMessageBuilder extends MessageBaseBuilder {

	/**
	 * The attachment of the current builder.
	 */
	private Attachment attachment;

	/**
	 * Creates a builder for a {@link Message} that contains an
	 * {@link Attachment}.
	 * 
	 * @param type
	 *            the attachment type.
	 * @param url
	 *            the url of the attachment content.
	 */
	AttachmentMessageBuilder(AttachmentType type, String url) {
		UrlPayload payload = new UrlPayload(url);
		this.attachment = new Attachment(type, payload);
	}

	/**
	 * Creates a builder for a {@link Message} that contains an
	 * {@link Attachment}.
	 * 
	 * @param type
	 *            the attachment type.
	 * @param payload
	 *            the attachment {@link Payload}.
	 */
	AttachmentMessageBuilder(AttachmentType type, Payload payload) {
		this.attachment = new Attachment(type, payload);
	}
	
	/**
	 * Adds a {@link QuickReply} to the current object.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 * 
	 * @param title
	 *            the quick reply button label. It can't be empty.
	 * @param payload
	 *            the payload sent back when the button is pressed. It can't be
	 *            empty.
	 * @return this builder.
	 */
	public AttachmentMessageBuilder addQuickReply(String title, String payload) {
		if(this.quickReplies == null){
			this.quickReplies = new ArrayList<QuickReply>();
		}
		this.quickReplies.add(new QuickReply(title, payload));
		return this;
	}

	/**
	 * Adds a {@link QuickReply} to the current object.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 * 
	 * @param reply
	 *            a quick reply object.
	 * @return this builder.
	 */
	public AttachmentMessageBuilder addQuickReply(QuickReply reply) {
		if(this.quickReplies == null){
			this.quickReplies = new ArrayList<QuickReply>();
		}
		this.quickReplies.add(reply);
		return this;
	}

	/**
	 * {@inheritDoc} Returns a response containing an {@link Attachment}.
	 */
	public FaceBotResponse build(MessageEnvelope envelope) {
		User recipient = getRecipient(envelope);
		Message message = new AttachmentMessage(attachment);
		message.setQuickReplies(quickReplies);
		return new FaceBotMessageResponse(recipient, message);
	}

}
