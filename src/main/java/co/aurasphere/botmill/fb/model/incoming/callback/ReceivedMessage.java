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

/**
 * Model for a received message callback. <br>
 * <br>
 * This callback will occur when a message has been sent to your page. You may
 * receive text messages or messages with attachments (image, audio, video, file
 * or location). Callbacks contain a seq number which can be used to know the
 * sequence of a message in a conversation. Messages are always sent in order. <br>
 * <br>
 * You can subscribe to this callback by selecting the message field when <a
 * href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 * >setting up</a> your webhook.
 * 
 * @author Donato Rimenti
 */
public class ReceivedMessage extends IncomingMessage {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message ID.
	 */
	private String mid;

	/**
	 * Message sequence number.
	 */
	private String seq;

	/**
	 * Text of message.
	 */
	private String text;

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
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		result = prime * result + ((seq == null) ? 0 : seq.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		ReceivedMessage other = (ReceivedMessage) obj;
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
	 * @see
	 * co.aurasphere.botmill.fb.model.incoming.callback.IncomingMessage#toString
	 * ()
	 */
	@Override
	public String toString() {
		return "ReceivedMessage [mid=" + mid + ", seq=" + seq + ", text="
				+ text + ", attachments=" + attachments + ", quickReply="
				+ quickReply + "]";
	}

}
