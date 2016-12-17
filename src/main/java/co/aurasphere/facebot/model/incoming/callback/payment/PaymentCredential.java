package co.aurasphere.facebot.model.incoming.callback.payment;

import com.google.gson.annotations.SerializedName;

/**
 * Object that represents a payment credentials.
 * 
 * @author Donato Rimenti
 * @date Dec 4, 2016
 */
public class PaymentCredential {

	/**
	 * Payment provider type (one of stripe/paypal/token).
	 */
	@SerializedName("provider_type")
	private ProviderType providerType;

	/**
	 * Payment provider charge id (for stripe/paypal, null for tokenization),
	 * for a test_payment, the charge id will be test_charge_id_12345.
	 */
	@SerializedName("charge_id")
	private String chargeId;

	/**
	 * PGP-signed tokenized charge card (null for stripe/paypal).
	 */
	@SerializedName("tokenized_card")
	private String tokenizedCard;

	/**
	 * PGP-signed CVV number (null for stripe/paypal).
	 */
	@SerializedName("tokenized_cvv")
	private String tokenizedCvv;

	/**
	 * Expiry month (null for stripe/paypal).
	 */
	@SerializedName("token_expiry_month")
	private String tokenExpiryMonth;

	/**
	 * Expiry year (null for stripe/paypal).
	 */
	@SerializedName("token_expiry_year")
	private String tokenExpiryYear;

	/**
	 * A facebook issued payment id for tracking. If it is a test payment, the
	 * id will be test_payment_id_12345.
	 */
	@SerializedName("fb_payment_id")
	private String fbPaymentId;

	/**
	 * Gets the payment provider type (one of stripe/paypal/token).
	 * 
	 * @return the payment provider type.
	 */
	public ProviderType getProviderType() {
		return providerType;
	}

	/**
	 * Sets the {@link #providerType}.
	 *
	 * @param providerType the {@link #providerType} to set.
	 */
	public void setProviderType(ProviderType providerType) {
		this.providerType = providerType;
	}

	/**
	 * Gets the {@link #chargeId}.
	 *
	 * @return {@link #chargeId}
	 */
	public String getChargeId() {
		return chargeId;
	}

	/**
	 * Sets the {@link #chargeId}.
	 *
	 * @param chargeId {@link #chargeId}
	 */
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	/**
	 * Gets the {@link #tokenizedCard}.
	 *
	 * @return the {@link #tokenizedCard}.
	 */
	public String getTokenizedCard() {
		return tokenizedCard;
	}

	/**
	 * Sets the {@link #tokenizedCard}.
	 *
	 * @param tokenizedCard the {@link #tokenizedCard} to set.
	 */
	public void setTokenizedCard(String tokenizedCard) {
		this.tokenizedCard = tokenizedCard;
	}

	/**
	 * Gets the {@link #tokenizedCvv}.
	 *
	 * @return the {@link #tokenizedCvv}.
	 */
	public String getTokenizedCvv() {
		return tokenizedCvv;
	}

	/**
	 * Sets the {@link #tokenizedCvv}.
	 *
	 * @param tokenizedCvv the {@link #tokenizedCvv} to set.
	 */
	public void setTokenizedCvv(String tokenizedCvv) {
		this.tokenizedCvv = tokenizedCvv;
	}

	/**
	 * Gets the {@link #tokenExpiryMonth}.
	 *
	 * @return the {@link #tokenExpiryMonth}.
	 */
	public String getTokenExpiryMonth() {
		return tokenExpiryMonth;
	}

	/**
	 * Sets the {@link #tokenExpiryMonth}.
	 *
	 * @param tokenExpiryMonth the {@link #tokenExpiryMonth} to set.
	 */
	public void setTokenExpiryMonth(String tokenExpiryMonth) {
		this.tokenExpiryMonth = tokenExpiryMonth;
	}

	/**
	 * Gets the token expiry year.
	 *
	 * @return the token expiry year
	 */
	public String getTokenExpiryYear() {
		return tokenExpiryYear;
	}

	/**
	 * Sets the {@link #tokenExpiryYear}.
	 *
	 * @param tokenExpiryYear the {@link #tokenExpiryYear} to set.
	 */
	public void setTokenExpiryYear(String tokenExpiryYear) {
		this.tokenExpiryYear = tokenExpiryYear;
	}

	/**
	 * Gets the {@link #fbPaymentId}.
	 *
	 * @return the {@link #fbPaymentId}.
	 */
	public String getFbPaymentId() {
		return fbPaymentId;
	}

	/**
	 * Sets the {@link #fbPaymentId}.
	 *
	 * @param fbPaymentId the {@link #fbPaymentId} to set.
	 */
	public void setFbPaymentId(String fbPaymentId) {
		this.fbPaymentId = fbPaymentId;
	}

}
