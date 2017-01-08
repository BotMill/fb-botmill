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

import co.aurasphere.botmill.fb.model.base.Attachment;
import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.base.Payload;
import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.message.AttachmentMessage;
import co.aurasphere.botmill.fb.model.outcoming.message.FbBotMillMessageResponse;
import co.aurasphere.botmill.fb.model.outcoming.message.Message;
import co.aurasphere.botmill.fb.model.outcoming.payload.UrlPayload;
import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;

/**
 * Builder for a {@link Message} that contains an {@link Attachment}.
 * 
 * @author Donato Rimenti
 * 
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
	public AttachmentMessageBuilder addQuickReply(String title, String payload) {
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
	public AttachmentMessageBuilder addQuickReply(QuickReply reply) {
		if (this.quickReplies == null) {
			this.quickReplies = new ArrayList<QuickReply>();
		}
		this.quickReplies.add(reply);
		return this;
	}

	/**
	 * {@inheritDoc} Returns a response containing an {@link Attachment}.
	 */
	public FbBotMillResponse build(MessageEnvelope envelope) {
		User recipient = getRecipient(envelope);
		Message message = new AttachmentMessage(attachment);
		message.setQuickReplies(quickReplies);
		return new FbBotMillMessageResponse(recipient, message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.bean.FbBotMillBean#toString()
	 */
	@Override
	public String toString() {
		return "AttachmentMessageBuilder [attachment=" + attachment
				+ ", quickReplies=" + quickReplies + "]";
	}

}
