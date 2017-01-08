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
package co.aurasphere.botmill.fb.model.incoming.callback.payment;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Object that represents a payment credentials for a {@link Payment} callback.
 * 
 * @author Donato Rimenti
 * 
 */
public class PaymentCredential implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

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
	 * Gets the {@link #providerType}.
	 *
	 * @return the {@link #providerType}.
	 */
	public ProviderType getProviderType() {
		return providerType;
	}

	/**
	 * Sets the {@link #providerType}.
	 *
	 * @param providerType
	 *            the {@link #providerType} to set.
	 */
	public void setProviderType(ProviderType providerType) {
		this.providerType = providerType;
	}

	/**
	 * Gets the {@link #chargeId}.
	 *
	 * @return the {@link #chargeId}.
	 */
	public String getChargeId() {
		return chargeId;
	}

	/**
	 * Sets the {@link #chargeId}.
	 *
	 * @param chargeId
	 *            the {@link #chargeId} to set.
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
	 * @param tokenizedCard
	 *            the {@link #tokenizedCard} to set.
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
	 * @param tokenizedCvv
	 *            the {@link #tokenizedCvv} to set.
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
	 * @param tokenExpiryMonth
	 *            the {@link #tokenExpiryMonth} to set.
	 */
	public void setTokenExpiryMonth(String tokenExpiryMonth) {
		this.tokenExpiryMonth = tokenExpiryMonth;
	}

	/**
	 * Gets the {@link #tokenExpiryYear}.
	 *
	 * @return the {@link #tokenExpiryYear}.
	 */
	public String getTokenExpiryYear() {
		return tokenExpiryYear;
	}

	/**
	 * Sets the {@link #tokenExpiryYear}.
	 *
	 * @param tokenExpiryYear
	 *            the {@link #tokenExpiryYear} to set.
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
	 * @param fbPaymentId
	 *            the {@link #fbPaymentId} to set.
	 */
	public void setFbPaymentId(String fbPaymentId) {
		this.fbPaymentId = fbPaymentId;
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
		result = prime * result
				+ ((chargeId == null) ? 0 : chargeId.hashCode());
		result = prime * result
				+ ((fbPaymentId == null) ? 0 : fbPaymentId.hashCode());
		result = prime * result
				+ ((providerType == null) ? 0 : providerType.hashCode());
		result = prime
				* result
				+ ((tokenExpiryMonth == null) ? 0 : tokenExpiryMonth.hashCode());
		result = prime * result
				+ ((tokenExpiryYear == null) ? 0 : tokenExpiryYear.hashCode());
		result = prime * result
				+ ((tokenizedCard == null) ? 0 : tokenizedCard.hashCode());
		result = prime * result
				+ ((tokenizedCvv == null) ? 0 : tokenizedCvv.hashCode());
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
		PaymentCredential other = (PaymentCredential) obj;
		if (chargeId == null) {
			if (other.chargeId != null)
				return false;
		} else if (!chargeId.equals(other.chargeId))
			return false;
		if (fbPaymentId == null) {
			if (other.fbPaymentId != null)
				return false;
		} else if (!fbPaymentId.equals(other.fbPaymentId))
			return false;
		if (providerType != other.providerType)
			return false;
		if (tokenExpiryMonth == null) {
			if (other.tokenExpiryMonth != null)
				return false;
		} else if (!tokenExpiryMonth.equals(other.tokenExpiryMonth))
			return false;
		if (tokenExpiryYear == null) {
			if (other.tokenExpiryYear != null)
				return false;
		} else if (!tokenExpiryYear.equals(other.tokenExpiryYear))
			return false;
		if (tokenizedCard == null) {
			if (other.tokenizedCard != null)
				return false;
		} else if (!tokenizedCard.equals(other.tokenizedCard))
			return false;
		if (tokenizedCvv == null) {
			if (other.tokenizedCvv != null)
				return false;
		} else if (!tokenizedCvv.equals(other.tokenizedCvv))
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
		return "PaymentCredential [providerType=" + providerType
				+ ", chargeId=" + chargeId + ", tokenizedCard=" + tokenizedCard
				+ ", tokenizedCvv=" + tokenizedCvv + ", tokenExpiryMonth="
				+ tokenExpiryMonth + ", tokenExpiryYear=" + tokenExpiryYear
				+ ", fbPaymentId=" + fbPaymentId + "]";
	}

}
