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
 * The base model of the Facebook's Messenger Platform callback. Used to model
 * all the received callbacks.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#format"
 *      >Facebook's Messenger Platform Common Format Documentation</a>
 * 
 */
public class MessengerCallback implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
	/**
	 * The type of callback. This always evaluates to "page".
	 */
	private String object;

	/**
	 * A list of {@link MessengerCallbackEntry} for the current callback
	 * containing event data.
	 */
	private List<MessengerCallbackEntry> entry;

	/**
	 * Gets the {@link #object}.
	 *
	 * @return the {@link #object}.
	 */
	public String getObject() {
		return object;
	}

	/**
	 * Sets the {@link #object}.
	 *
	 * @param object
	 *            the {@link #object} to set.
	 */
	public void setObject(String object) {
		this.object = object;
	}

	/**
	 * Gets the {@link #entry}.
	 *
	 * @return the {@link #entry}.
	 */
	public List<MessengerCallbackEntry> getEntry() {
		return entry;
	}

	/**
	 * Sets the {@link #entry}.
	 *
	 * @param entry
	 *            the {@link #entry} to set.
	 */
	public void setEntry(List<MessengerCallbackEntry> entry) {
		this.entry = entry;
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
		result = prime * result + ((entry == null) ? 0 : entry.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
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
		MessengerCallback other = (MessengerCallback) obj;
		if (entry == null) {
			if (other.entry != null)
				return false;
		} else if (!entry.equals(other.entry))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
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
		return "MessengerCallback [object=" + object + ", entry=" + entry + "]";
	}
}
