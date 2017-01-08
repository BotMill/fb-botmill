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

import com.google.gson.annotations.SerializedName;

/**
 * Model for a message echo callback. <br>
 * <br>
 * This callback will occur when a message has been sent by your page. You may
 * receive text messsages or messages with attachments (image, video, audio,
 * template or fallback). The payload will also include an optional custom
 * metadata sent by the sender, and the corresponding app_id. You can subscribe
 * to this callback by selecting the message_echoes field when <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 * >setting up</a> your webhook. <br>
 * <br>
 * Multiple types of messages are supported:
 * 
 * <pre>
 * - Text message 
 * - Message with image, audio, video or file attachment 
 * - Message with template attachment 
 * - Message with fallback attachment (any unrecognized or unsupported attachment)
 * </pre>
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/message-echo"
 *      >Facebook's Messenger Platform Message Echo Callback Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Webhook Setup Documentation</a>
 */
public class EchoMessage extends IncomingMessage {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Indicates the message sent from the page itself.
	 */
	@SerializedName("is_echo")
	private boolean isEcho;

	/**
	 * ID of the app from which the message was sent.
	 */
	@SerializedName("app_id")
	private String appId;

	/**
	 * Custom string passed to the Send API as the metadata field.
	 */
	private String metadata;

	/**
	 * Message ID.
	 */
	private String mid;

	/**
	 * Sequence number.
	 */
	private String seq;

	/**
	 * Checks if is echo.
	 *
	 * @return the {@link #isEcho}.
	 */
	public boolean isEcho() {
		return isEcho;
	}

	/**
	 * Sets the {@link #isEcho}.
	 *
	 * @param isEcho
	 *            the {@link #isEcho} to set.
	 */
	public void setIsEcho(boolean isEcho) {
		this.isEcho = isEcho;
	}

	/**
	 * Gets the {@link #appId}.
	 *
	 * @return the {@link #appId}.
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * Sets the {@link #appId}.
	 *
	 * @param appId
	 *            the {@link #appId} to set.
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * Gets the {@link #metadata}.
	 *
	 * @return the {@link #metadata}.
	 */
	public String getMetadata() {
		return metadata;
	}

	/**
	 * Sets the {@link #metadata}.
	 *
	 * @param metadata
	 *            the {@link #metadata} to set.
	 */
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	/**
	 * Gets the {@link #mid}.
	 *
	 * @return the {@link #mid}.
	 */
	public String getMid() {
		return mid;
	}

	/**
	 * Sets the {@link #mid}.
	 *
	 * @param mid
	 *            the {@link #mid} to set.
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}

	/**
	 * Gets the {@link #seq}.
	 *
	 * @return the {@link #seq}.
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * Sets the {@link #seq}.
	 *
	 * @param seq
	 *            the {@link #seq} to set.
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.incoming.callback.IncomingMessage#hashCode
	 * ()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result + (isEcho ? 1231 : 1237);
		result = prime * result
				+ ((metadata == null) ? 0 : metadata.hashCode());
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		result = prime * result + ((seq == null) ? 0 : seq.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.incoming.callback.IncomingMessage#equals
	 * (java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EchoMessage other = (EchoMessage) obj;
		if (appId == null) {
			if (other.appId != null)
				return false;
		} else if (!appId.equals(other.appId))
			return false;
		if (isEcho != other.isEcho)
			return false;
		if (metadata == null) {
			if (other.metadata != null)
				return false;
		} else if (!metadata.equals(other.metadata))
			return false;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		if (seq == null) {
			if (other.seq != null)
				return false;
		} else if (!seq.equals(other.seq))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.incoming.callback.IncomingMessage#toString
	 * ()
	 */
	@Override
	public String toString() {
		return "EchoMessage [isEcho=" + isEcho + ", appId=" + appId
				+ ", metadata=" + metadata + ", mid=" + mid + ", seq=" + seq
				+ ", text=" + text + ", attachments=" + attachments
				+ ", quickReply=" + quickReply + "]";
	}

}
