package co.aurasphere.botmill.fb.model.outcoming.factory;

import java.util.ArrayList;

import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.message.FbBotMillMessageResponse;
import co.aurasphere.botmill.fb.model.outcoming.message.Message;
import co.aurasphere.botmill.fb.model.outcoming.message.TextMessage;
import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;


/**
 * A builder for a message that contains only a plain text message.
 * 
 * @author Donato Rimenti
 * 
 */
public class TextMessageBuilder extends MessageBaseBuilder {

	/**
	 * The message of the response.
	 */
	private String messageText;

	/**
	 * Default constructor. Creates a builder for a message that contains only a
	 * plain text message.
	 * 
	 * @param messageText
	 *            the text of the message.
	 */
	TextMessageBuilder(String messageText) {
		this.messageText = messageText;
	}

	/**
	 * Adds a {@link QuickReply} to the current object.
	 *
	 * @param title            the quick reply button label. It can't be empty.
	 * @param payload            the payload sent back when the button is pressed. It can't be
	 *            empty.
	 * @return this builder.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 */
	public TextMessageBuilder addQuickReply(String title, String payload) {
		if(this.quickReplies == null){
			this.quickReplies = new ArrayList<QuickReply>();
		}
		this.quickReplies.add(new QuickReply(title, payload));
		return this;
	}

	/**
	 * Adds a {@link QuickReply} to the current object.
	 *
	 * @param reply            a quick reply object.
	 * @return this builder.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 */
	public TextMessageBuilder addQuickReply(QuickReply reply) {
		if(this.quickReplies == null){
			this.quickReplies = new ArrayList<QuickReply>();
		}
		this.quickReplies.add(reply);
		return this;
	}
	
	/**
	 * 
	 * Adds a Location {@link QuickReply} to the current object.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 * 
	 * @param locationMessage
	 *            the location text
	 * @return this builder.
	 */
	public TextMessageBuilder addQuickLocationReply(String locationMessage) {
		if (this.quickReplies == null) {
			this.quickReplies = new ArrayList<QuickReply>();
		}
		this.quickReplies.add(new QuickReply(locationMessage));
		return this;
	}

	/**
	 * {@inheritDoc} Returns a response containing a plain text message.
	 */
	public FbBotMillResponse build(MessageEnvelope envelope) {
		User recipient = getRecipient(envelope);
		Message message = new TextMessage(messageText);
		message.setQuickReplies(quickReplies);
		return new FbBotMillMessageResponse(recipient, message);
	}

}
