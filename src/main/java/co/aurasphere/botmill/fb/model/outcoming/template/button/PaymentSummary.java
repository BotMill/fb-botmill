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
package co.aurasphere.botmill.fb.model.outcoming.template.button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

/**
 * The Payment Summary Class/Object.
 *
 * @author Alvin Reyes
 * 
 */
public class PaymentSummary implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The currency. */
	@NotBlank
	private String currency;

	/** The is test payment. */
	@SerializedName("is_test_payment")
	private boolean isTestPayment;

	/** The payment type. */
	@NotNull
	@SerializedName("payment_type")
	private PaymentType paymentType;

	/** The merchant name. */
	@NotBlank
	@SerializedName("merchant_name")
	private String merchantName;

	/** The price list. */
	@Valid
	@NotEmpty
	@SerializedName("price_list")
	private List<PriceLabel> priceList;

	/** The requested user info. */
	@Valid
	@NotNull
	@SerializedName("requested_user_info")
	private List<RequestedUserInfo> requestedUserInfo;

	public PaymentSummary() {
		this.priceList = new ArrayList<PriceLabel>();
		this.requestedUserInfo = new ArrayList<RequestedUserInfo>();
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency
	 *            the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Checks if is test payment.
	 *
	 * @return true, if is test payment
	 */
	public boolean isTestPayment() {
		return isTestPayment;
	}

	/**
	 * Sets the test payment.
	 *
	 * @param isTestPayment
	 *            the new test payment
	 */
	public void setTestPayment(boolean isTestPayment) {
		this.isTestPayment = isTestPayment;
	}

	/**
	 * Gets the payment type.
	 *
	 * @return the payment type
	 */
	public PaymentType getPaymentType() {
		return paymentType;
	}

	/**
	 * Sets the payment type.
	 *
	 * @param paymentType
	 *            the new payment type
	 */
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * Gets the merchant name.
	 *
	 * @return the merchant name
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * Sets the merchant name.
	 *
	 * @param merchantName
	 *            the new merchant name
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * Gets the price list.
	 *
	 * @return the price list
	 */
	public List<PriceLabel> getPriceList() {
		return priceList;
	}

	/**
	 * Sets the price list.
	 *
	 * @param priceList
	 *            the new price list
	 */
	public void setPriceList(List<PriceLabel> priceList) {
		this.priceList = priceList;
	}

	public void addPriceLabel(PriceLabel priceLabel) {
		this.priceList.add(priceLabel);
	}

	/**
	 * Gets the requested user info.
	 *
	 * @return the requested user info
	 */
	public List<RequestedUserInfo> getRequestedUserInfo() {
		return requestedUserInfo;
	}

	/**
	 * Sets the requested user info.
	 *
	 * @param requestedUserInfo
	 *            the new requested user info
	 */
	public void setRequestedUserInfo(List<RequestedUserInfo> requestedUserInfo) {
		this.requestedUserInfo = requestedUserInfo;
	}

	/**
	 * Adds the requested user info.
	 *
	 * @param requestedUserInfo
	 *            the requested user info to add
	 */
	public void addRequestedUserInfo(RequestedUserInfo requestedUserInfo) {
		this.requestedUserInfo.add(requestedUserInfo);
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
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + (isTestPayment ? 1231 : 1237);
		result = prime * result
				+ ((merchantName == null) ? 0 : merchantName.hashCode());
		result = prime * result
				+ ((paymentType == null) ? 0 : paymentType.hashCode());
		result = prime * result
				+ ((priceList == null) ? 0 : priceList.hashCode());
		result = prime
				* result
				+ ((requestedUserInfo == null) ? 0 : requestedUserInfo
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
		PaymentSummary other = (PaymentSummary) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (isTestPayment != other.isTestPayment)
			return false;
		if (merchantName == null) {
			if (other.merchantName != null)
				return false;
		} else if (!merchantName.equals(other.merchantName))
			return false;
		if (paymentType != other.paymentType)
			return false;
		if (priceList == null) {
			if (other.priceList != null)
				return false;
		} else if (!priceList.equals(other.priceList))
			return false;
		if (requestedUserInfo == null) {
			if (other.requestedUserInfo != null)
				return false;
		} else if (!requestedUserInfo.equals(other.requestedUserInfo))
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
		return "PaymentSummary [currency=" + currency + ", isTestPayment="
				+ isTestPayment + ", paymentType=" + paymentType
				+ ", merchantName=" + merchantName + ", priceList=" + priceList
				+ ", requestedUserInfo=" + requestedUserInfo + "]";
	}

}
