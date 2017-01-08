/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
	 * @param title
	 *            the quick reply button label. It can't be empty.
	 * @param payload
	 *            the payload sent back when the button is pressed. It can't be
	 *            empty.
	 * @return this builder.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 */
	public TextMessageBuilder addQuickReply(String title, String payload) {
		if (this.quickReplies == null) {
			this.quickReplies = new ArrayList<QuickReply>();
		}
		this.quickReplies.add(new QuickReply(title, payload));
		return this;
	}

	/**
	 * Adds a {@link QuickReply} to the current object.
	 *
	 * @param reply
	 *            a quick reply object.
	 * @return this builder.
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/quick-replies"
	 *      > Facebook's Messenger Platform Quick Replies Documentation</a>
	 */
	public TextMessageBuilder addQuickReply(QuickReply reply) {
		if (this.quickReplies == null) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.factory.MessageBaseBuilder#toString
	 * ()
	 */
	@Override
	public String toString() {
		return "TextMessageBuilder [messageText=" + messageText
				+ ", quickReplies=" + quickReplies + "]";
	}

}
