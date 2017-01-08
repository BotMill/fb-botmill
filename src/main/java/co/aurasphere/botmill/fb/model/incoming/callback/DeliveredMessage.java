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

/**
 * Model for a delivered message callback. <br>
 * <br>
 * This callback will occur when a message a page has sent has been delivered.
 * You can subscribe to this callback by selecting the message_deliveries field
 * when <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 * >setting up</a> your webhook.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/message-delivered"
 *      >Facebook's Messenger Platform Delivery Callback Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Webhook Setup Documentation</a>
 * 
 */
public class DeliveredMessage implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Messages IDs. <br>
	 * <br>
	 * Both mids and {@link #watermark} fields are used to determine which
	 * messages were delivered. watermark is always present and mids is
	 * sometimes present. mids provides delivery receipts on a per-message basis
	 * but may not be present (due to backward compatibility reasons with older
	 * Messenger clients). watermark is always present and is a timestamp
	 * indicating that all messages with a timestamp before watermark were
	 * delivered.
	 */
	private List<String> mids;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
	/**
	 * All messages before this timestamp where seen.<br>
	 * <br>
	 * Both {@link #mids} and watermark fields are used to determine which
	 * messages were delivered. watermark is always present and mids is
	 * sometimes present. mids provides delivery receipts on a per-message basis
	 * but may not be present (due to backward compatibility reasons with older
	 * Messenger clients). watermark is always present and is a timestamp
	 * indicating that all messages with a timestamp before watermark were
	 * delivered.
	 */
	private String watermark;

	/**
	 * Sequence number.
	 */
	private String seq;

	/**
	 * Gets the {@link #mids}.
	 *
	 * @return the {@link #mids}.
	 */
	public List<String> getMids() {
		return mids;
	}

	/**
	 * Sets the {@link #mids}.
	 *
	 * @param mids
	 *            the {@link #mids} to set.
	 */
	public void setMids(List<String> mids) {
		this.mids = mids;
	}

	/**
	 * Gets the {@link #watermark}.
	 *
	 * @return the {@link #watermark}.
	 */
	public String getWatermark() {
		return watermark;
	}

	/**
	 * Sets the {@link #watermark}.
	 *
	 * @param watermark
	 *            the {@link #watermark} to set.
	 */
	public void setWatermark(String watermark) {
		this.watermark = watermark;
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
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mids == null) ? 0 : mids.hashCode());
		result = prime * result + ((seq == null) ? 0 : seq.hashCode());
		result = prime * result
				+ ((watermark == null) ? 0 : watermark.hashCode());
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
		DeliveredMessage other = (DeliveredMessage) obj;
		if (mids == null) {
			if (other.mids != null)
				return false;
		} else if (!mids.equals(other.mids))
			return false;
		if (seq == null) {
			if (other.seq != null)
				return false;
		} else if (!seq.equals(other.seq))
			return false;
		if (watermark == null) {
			if (other.watermark != null)
				return false;
		} else if (!watermark.equals(other.watermark))
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
		return "DeliveredMessage [mids=" + mids + ", watermark=" + watermark
				+ ", seq=" + seq + "]";
	}
}
