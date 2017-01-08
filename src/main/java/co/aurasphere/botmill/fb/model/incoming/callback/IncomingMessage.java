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
package co.aurasphere.botmill.fb.model.incoming.callback;

import java.io.Serializable;
import java.util.List;

import co.aurasphere.botmill.fb.model.base.Attachment;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;

import com.google.gson.annotations.SerializedName;

/**
 * Base class for an incoming message in a {@link MessageEnvelope}.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public abstract class IncomingMessage implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Text message.
	 */
	protected String text;

	/**
	 * Attachments of the message.
	 */
	protected List<Attachment> attachments;

	/**
	 * Optional custom data provided by the sending app.
	 */
	@SerializedName("quick_reply")
	protected QuickReply quickReply;

	/**
	 * Gets the {@link #text}.
	 *
	 * @return the {@link #text}.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the {@link #text}.
	 *
	 * @param text
	 *            the {@link #text} to set.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the {@link #attachments}.
	 *
	 * @return the {@link #attachments}.
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}

	/**
	 * Sets the {@link #attachments}.
	 *
	 * @param attachments
	 *            the {@link #attachments} to set.
	 */
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	/**
	 * Gets the {@link #quickReply}.
	 *
	 * @return the {@link #quickReply}.
	 */
	public QuickReply getQuickReply() {
		return quickReply;
	}

	/**
	 * Sets the {@link #quickReply}.
	 *
	 * @param quickReply
	 *            the {@link #quickReply} to set.
	 */
	public void setQuickReply(QuickReply quickReply) {
		this.quickReply = quickReply;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attachments == null) ? 0 : attachments.hashCode());
		result = prime * result
				+ ((quickReply == null) ? 0 : quickReply.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncomingMessage other = (IncomingMessage) obj;
		if (attachments == null) {
			if (other.attachments != null)
				return false;
		} else if (!attachments.equals(other.attachments))
			return false;
		if (quickReply == null) {
			if (other.quickReply != null)
				return false;
		} else if (!quickReply.equals(other.quickReply))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IncomingMessage [text=" + text + ", attachments=" + attachments
				+ ", quickReply=" + quickReply + "]";
	}

}
