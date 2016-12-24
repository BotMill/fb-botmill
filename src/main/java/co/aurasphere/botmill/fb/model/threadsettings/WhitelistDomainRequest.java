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
	 * @param whiteListedDomains the white listed domains
	 */
	public WhitelistDomainRequest(List<String> whiteListedDomains) {
		this.whiteListedDomains= whiteListedDomains;
		this.domainActionType = DomainActionType.ADD;
		this.type = SettingType.DOMAIN_WHITELISTING;
	}
	
	/**
	 * Instantiates a new whitelist domain request.
	 *
	 * @param whiteListedDomains the white listed domains
	 * @param domainActionType the domain action type
	 */
	public WhitelistDomainRequest(List<String> whiteListedDomains, DomainActionType domainActionType) {
		this.whiteListedDomains= whiteListedDomains;
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
	 * @param domainActionType the new domain action type
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
	 * @param whiteListedDomains the new white listed domains
	 */
	public void setWhiteListedDomains(List<String> whiteListedDomains) {
		this.whiteListedDomains = whiteListedDomains;
	}
	
	/**
	 * Adds the white listed domain.
	 *
	 * @param domain the domain
	 * @return the whitelist domain request
	 */
	public WhitelistDomainRequest addWhiteListedDomain(String domain) {
		this.whiteListedDomains.add(domain);
		return this;
	}
	

}
