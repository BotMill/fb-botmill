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
import java.util.List;

/**
 * Represents a received callback from Facebook's Messenger Platform.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#format"
 *      >Facebook's Messenger Platform Common Format Documentation</a>
 * 
 */
public class MessengerCallbackEntry implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Page ID of page.
	 */
	private String id;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
	/**
	 * Time of update (epoch time in milliseconds).
	 */
	private String time;

	/**
	 * A list of {@link MessageEnvelope} that contains all the callback details.
	 */
	private List<MessageEnvelope> messaging;

	/**
	 * Gets the {@link #id}.
	 *
	 * @return the {@link #id}.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the {@link #id}.
	 *
	 * @param id
	 *            the {@link #id} to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the {@link #time}.
	 *
	 * @return the {@link #time}.
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Sets the {@link #time}.
	 *
	 * @param time
	 *            the {@link #time} to set.
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * Gets the {@link #messaging}.
	 *
	 * @return the {@link #messaging}.
	 */
	public List<MessageEnvelope> getMessaging() {
		return messaging;
	}

	/**
	 * Sets the {@link #messaging}.
	 *
	 * @param messaging
	 *            the {@link #messaging} to set.
	 */
	public void setMessaging(List<MessageEnvelope> messaging) {
		this.messaging = messaging;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((messaging == null) ? 0 : messaging.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		MessengerCallbackEntry other = (MessengerCallbackEntry) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (messaging == null) {
			if (other.messaging != null)
				return false;
		} else if (!messaging.equals(other.messaging))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
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
		return "MessengerCallbackEntry [id=" + id + ", time=" + time
				+ ", messaging=" + messaging + "]";
	}
}
