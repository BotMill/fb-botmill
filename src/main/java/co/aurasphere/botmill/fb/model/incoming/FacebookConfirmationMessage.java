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
package co.aurasphere.botmill.fb.model.incoming;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Model for a confirmation message from Facebook. This will be received back
 * whenever the bot sends a message/reply.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public class FacebookConfirmationMessage implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The recipient id.
	 */
	@SerializedName("recipient_id")
	private String recipientId;

	/**
	 * The message id.
	 */
	@SerializedName("message_id")
	private String messageId;

	/**
	 * The result.
	 */
	private String result;

	/**
	 * Gets the {@link #recipientId}.
	 *
	 * @return the {@link #recipientId}.
	 */
	public String getRecipientId() {
		return recipientId;
	}

	/**
	 * Sets the {@link #recipientId}.
	 *
	 * @param recipientId
	 *            the {@link #recipientId} to set.
	 */
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	/**
	 * Gets the {@link #messageId}.
	 *
	 * @return the {@link #messageId}.
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * Sets the {@link #messageId}.
	 *
	 * @param messageId
	 *            the {@link #messageId} to set.
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * Gets the {@link #result}.
	 *
	 * @return the {@link #result}.
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Sets the {@link #result}.
	 *
	 * @param result
	 *            the {@link #result} to set.
	 */
	public void setResult(String result) {
		this.result = result;
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
				+ ((messageId == null) ? 0 : messageId.hashCode());
		result = prime * result
				+ ((recipientId == null) ? 0 : recipientId.hashCode());
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
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
		FacebookConfirmationMessage other = (FacebookConfirmationMessage) obj;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		if (recipientId == null) {
			if (other.recipientId != null)
				return false;
		} else if (!recipientId.equals(other.recipientId))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
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
		return "FacebookConfirmationMessage [recipientId=" + recipientId
				+ ", messageId=" + messageId + ", result=" + result + "]";
	}

}