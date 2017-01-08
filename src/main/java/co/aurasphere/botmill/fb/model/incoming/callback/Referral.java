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

/**
 * Model for the Referral Callback. <br>
 * <br>
 * This callback will occur when an m.me link is used with a referral param and
 * only in a case this user already has a thread with this bot (for new threads
 * see <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference/postback-received"
 * >Postback Event</a>). See also the full guide on <a href=
 * "https://developers.facebook.com/docs/messenger-platform/referral-params" >m.
 * me links</a>. <br>
 * <br>
 * To start receiving these events you need to subscribe to messaging_referral
 * in the webhook settings for your app. <br>
 * <br>
 * An m.me link with an an added parameter looks like this:
 * http://m.me/mybot?ref=myparam. The value of the ref parameter will be passed
 * to the server via webhook.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/referral"
 *      > Facebook's Messenger Platform Referral Callback Documentation</a>
 * 
 */
public class Referral implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The arbitrary data that was originally passed in the ref param added to
	 * the m.me link.
	 */
	private String ref;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
	/**
	 * The source of this referral. Currently, the only possible value is
	 * "SHORTLINK".
	 */
	private String source;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
	/**
	 * The identifier for the referral. For referrals coming from m.me links, it
	 * will always be "OPEN_THREAD".
	 */
	private String type;

	/**
	 * Gets the {@link #ref}.
	 *
	 * @return the {@link #ref}.
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * Sets the {@link #ref}.
	 *
	 * @param ref
	 *            the {@link #ref} to set.
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}

	/**
	 * Gets the {@link #source}.
	 *
	 * @return the {@link #source}.
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Sets the {@link #source}.
	 *
	 * @param source
	 *            the {@link #source} to set.
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * Gets the {@link #type}.
	 *
	 * @return the {@link #type}.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the {@link #type}.
	 *
	 * @param type
	 *            the {@link #type} to set.
	 */
	public void setType(String type) {
		this.type = type;
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
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Referral other = (Referral) obj;
		if (ref == null) {
			if (other.ref != null)
				return false;
		} else if (!ref.equals(other.ref))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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
		return "Referral [ref=" + ref + ", source=" + source + ", type=" + type
				+ "]";
	}

}
