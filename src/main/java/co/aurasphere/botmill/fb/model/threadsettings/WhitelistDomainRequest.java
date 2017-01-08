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
package co.aurasphere.botmill.fb.model.threadsettings;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

/**
 * The Class WhitelistDomainRequest.
 */
public class WhitelistDomainRequest extends ThreadSettingsBaseRequest {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The domain action type. */
	@NotNull
	@SerializedName("domain_action_type")
	private DomainActionType domainActionType;

	/** The white listed domains. */
	@Valid
	@Size(max = 5)
	@NotEmpty
	@SerializedName("whitelisted_domains")
	private List<String> whiteListedDomains;

	/**
	 * Instantiates a new whitelist domain request.
	 */
	public WhitelistDomainRequest() {
		this.whiteListedDomains = new ArrayList<String>();
		this.domainActionType = DomainActionType.ADD;
		this.type = SettingType.DOMAIN_WHITELISTING;
	}

	/**
	 * Instantiates a new whitelist domain request.
	 *
	 * @param whiteListedDomains
	 *            the white listed domains
	 */
	public WhitelistDomainRequest(List<String> whiteListedDomains) {
		this.whiteListedDomains = whiteListedDomains;
		this.domainActionType = DomainActionType.ADD;
		this.type = SettingType.DOMAIN_WHITELISTING;
	}

	/**
	 * Instantiates a new whitelist domain request.
	 *
	 * @param whiteListedDomains
	 *            the white listed domains
	 * @param domainActionType
	 *            the domain action type
	 */
	public WhitelistDomainRequest(List<String> whiteListedDomains,
			DomainActionType domainActionType) {
		this.whiteListedDomains = whiteListedDomains;
		this.domainActionType = domainActionType;
		this.type = SettingType.DOMAIN_WHITELISTING;
	}

	/**
	 * Gets the domain action type.
	 *
	 * @return the domain action type
	 */
	public DomainActionType getDomainActionType() {
		return domainActionType;
	}

	/**
	 * Sets the domain action type.
	 *
	 * @param domainActionType
	 *            the new domain action type
	 */
	public void setDomainActionType(DomainActionType domainActionType) {
		this.domainActionType = domainActionType;
	}

	/**
	 * Gets the white listed domains.
	 *
	 * @return the white listed domains
	 */
	public List<String> getWhiteListedDomains() {
		return whiteListedDomains;
	}

	/**
	 * Sets the white listed domains.
	 *
	 * @param whiteListedDomains
	 *            the new white listed domains
	 */
	public void setWhiteListedDomains(List<String> whiteListedDomains) {
		this.whiteListedDomains = whiteListedDomains;
	}

	/**
	 * Adds the white listed domain.
	 *
	 * @param domain
	 *            the domain
	 */
	public void addWhiteListedDomain(String domain) {
		this.whiteListedDomains.add(domain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.threadsettings.ThreadSettingsBaseRequest
	 * #hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((domainActionType == null) ? 0 : domainActionType.hashCode());
		result = prime
				* result
				+ ((whiteListedDomains == null) ? 0 : whiteListedDomains
						.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.threadsettings.ThreadSettingsBaseRequest
	 * #equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		WhitelistDomainRequest other = (WhitelistDomainRequest) obj;
		if (domainActionType != other.domainActionType)
			return false;
		if (whiteListedDomains == null) {
			if (other.whiteListedDomains != null)
				return false;
		} else if (!whiteListedDomains.equals(other.whiteListedDomains))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.threadsettings.ThreadSettingsBaseRequest
	 * #toString()
	 */
	@Override
	public String toString() {
		return "WhitelistDomainRequest [domainActionType=" + domainActionType
				+ ", whiteListedDomains=" + whiteListedDomains + ", type="
				+ type + "]";
	}

}
