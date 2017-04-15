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
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.api.MessengerProfileApi;

import com.google.gson.annotations.SerializedName;


/**
 * Request for
 * {@link MessengerProfileApi#setWhitelistedDomains(List)}
 * method.
 * 
 * @author Donato Rimenti
 */
public class SetWhitelistedDomainsRequest implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A list of domains being used. All domains must be valid. Up to 10 domains
	 * allowed.
	 */
	// TODO: max as a constant in FbValidation
	@NotEmpty
	@Size(max = 10)
	@SerializedName("whitelisted_domains")
	private List<String> whitelistedDomains;

	/**
	 * Instantiates a new SetWhitelistedDomainsRequest.
	 */
	public SetWhitelistedDomainsRequest() {
		this.whitelistedDomains = new ArrayList<String>();
	}

	/**
	 * Instantiates a new SetWhitelistedDomainsRequest.
	 *
	 * @param whitelistedDomains
	 *            the {@link #whitelistedDomains}.
	 */
	public SetWhitelistedDomainsRequest(List<String> whitelistedDomains) {
		this.whitelistedDomains = whitelistedDomains;
	}

	/**
	 * Gets the {@link #whitelistedDomains}.
	 *
	 * @return the {@link #whitelistedDomains}.
	 */
	public List<String> getWhitelistedDomains() {
		return whitelistedDomains;
	}

	/**
	 * Sets the {@link #whitelistedDomains}.
	 *
	 * @param whitelistedDomains
	 *            the {@link #whitelistedDomains} to set.
	 */
	public void setWhitelistedDomains(List<String> whitelistedDomains) {
		this.whitelistedDomains = whitelistedDomains;
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
				+ ((whitelistedDomains == null) ? 0 : whitelistedDomains
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
		SetWhitelistedDomainsRequest other = (SetWhitelistedDomainsRequest) obj;
		if (whitelistedDomains == null) {
			if (other.whitelistedDomains != null)
				return false;
		} else if (!whitelistedDomains.equals(other.whitelistedDomains))
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
		return "SetWhitelistedDomainsRequest [whitelistedDomains="
				+ whitelistedDomains + "]";
	}

}
