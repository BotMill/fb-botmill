package co.aurasphere.botmill.fb.model.threadsettings.payment;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PaymentSettings {

	@SerializedName("payment_privacy_url")
	private String privacyUrl;

	@SerializedName("payment_public_key")
	private String publicKey;

	@SerializedName("setting_type")
	private String settingType;

	@SerializedName("payment_dev_mode_action")
	private PaymentDevModeAction paymentDevModeAction;

	@SerializedName("payment_testers")
	private List<String> paymentTesters;

	public String getPrivacyUrl() {
		return privacyUrl;
	}

	public PaymentSettings setPrivacyUrl(String privacyUrl) {
		this.privacyUrl = privacyUrl;
		return this;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public PaymentSettings setPublicKey(String publicKey) {
		this.publicKey = publicKey;
		return this;
	}

	public String getSettingType() {
		return settingType;
	}

	public PaymentSettings setSettingType(String settingType) {
		this.settingType = settingType;
		return this;
	}

	public PaymentDevModeAction getPaymentDevModeAction() {
		return paymentDevModeAction;
	}

	public PaymentSettings setPaymentDevModeAction(PaymentDevModeAction paymentDevModeAction) {
		this.paymentDevModeAction = paymentDevModeAction;
		return this;
	}

	public List<String> getPaymentTesters() {
		return paymentTesters;
	}

	public PaymentSettings setPaymentTesters(List<String> paymentTesters) {
		this.paymentTesters = paymentTesters;
		return this;
	}

}
