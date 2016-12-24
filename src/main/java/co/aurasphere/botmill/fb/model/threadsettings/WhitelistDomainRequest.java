package co.aurasphere.botmill.fb.model.threadsettings;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

public class WhitelistDomainRequest extends ThreadSettingsBaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@SerializedName("domain_action_type")
	private DomainActionType domainActionType;

	@Valid
	@Size(max = 5)
	@NotEmpty
	@SerializedName("whitelisted_domains")
	private List<String> whiteListedDomains;
	
	public WhitelistDomainRequest() {
		this.whiteListedDomains = new ArrayList<String>();
		this.domainActionType = DomainActionType.ADD;
		this.type = SettingType.DOMAIN_WHITELISTING;
	}
	
	public WhitelistDomainRequest(List<String> whiteListedDomains) {
		this.whiteListedDomains= whiteListedDomains;
		this.domainActionType = DomainActionType.ADD;
		this.type = SettingType.DOMAIN_WHITELISTING;
	}
	
	public WhitelistDomainRequest(List<String> whiteListedDomains, DomainActionType domainActionType) {
		this.whiteListedDomains= whiteListedDomains;
		this.domainActionType = domainActionType;
		this.type = SettingType.DOMAIN_WHITELISTING;
	}
	
	public DomainActionType getDomainActionType() {
		return domainActionType;
	}

	public void setDomainActionType(DomainActionType domainActionType) {
		this.domainActionType = domainActionType;
	}

	public List<String> getWhiteListedDomains() {
		return whiteListedDomains;
	}

	public void setWhiteListedDomains(List<String> whiteListedDomains) {
		this.whiteListedDomains = whiteListedDomains;
	}
	
	public WhitelistDomainRequest addWhiteListedDomain(String domain) {
		this.whiteListedDomains.add(domain);
		return this;
	}
	

}
