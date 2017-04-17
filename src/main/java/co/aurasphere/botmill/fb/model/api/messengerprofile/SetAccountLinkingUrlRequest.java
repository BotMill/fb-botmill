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
package co.aurasphere.botmill.fb.model.api.messengerprofile;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import co.aurasphere.botmill.fb.api.MessengerProfileApi;

import com.google.gson.annotations.SerializedName;


/**
 * Request for
 * {@link MessengerProfileApi#setAccountLinkingUrl(String)}
 * method.
 * 
 * @author Donato Rimenti
 */
public class SetAccountLinkingUrlRequest implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Authentication callback URL. Must use https protocol.
	 */
	@NotBlank
	@SerializedName("account_linking_url")
	private String accountLinkingUrl;

	/**
	 * Instantiates a new SetAccountLinkingUrl.
	 */
	public SetAccountLinkingUrlRequest() {
	}

	/**
	 * Instantiates a new SetAccountLinkingUrl.
	 *
	 * @param accountLinkingUrl
	 *            the {@link #accountLinkingUrl}.
	 */
	public SetAccountLinkingUrlRequest(String accountLinkingUrl) {
		this.accountLinkingUrl = accountLinkingUrl;
	}

	/**
	 * Gets the {@link #accountLinkingUrl}.
	 *
	 * @return the {@link #accountLinkingUrl}.
	 */
	public String getAccountLinkingUrl() {
		return accountLinkingUrl;
	}

	/**
	 * Sets the {@link #accountLinkingUrl}.
	 *
	 * @param accountLinkingUrl
	 *            the {@link #accountLinkingUrl} to set.
	 */
	public void setAccountLinkingUrl(String accountLinkingUrl) {
		this.accountLinkingUrl = accountLinkingUrl;
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
		result = prime
				* result
				+ ((accountLinkingUrl == null) ? 0 : accountLinkingUrl
						.hashCode());
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
		SetAccountLinkingUrlRequest other = (SetAccountLinkingUrlRequest) obj;
		if (accountLinkingUrl == null) {
			if (other.accountLinkingUrl != null)
				return false;
		} else if (!accountLinkingUrl.equals(other.accountLinkingUrl))
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
		return "SetAccountLinkingUrl [accountLinkingUrl=" + accountLinkingUrl
				+ "]";
	}

}
