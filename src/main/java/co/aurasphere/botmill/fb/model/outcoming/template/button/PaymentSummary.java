package co.aurasphere.botmill.fb.model.outcoming.template.button;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;


/**
 * The Payment Summary Class/Object.
 *
 * @author Alvin Reyes
 * @date 27/Nov/2016
 */
public class PaymentSummary implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The currency. */
	@NotEmpty
	private String currency;

	/** The is test payment. */
	@SerializedName("is_test_payment")
	private boolean isTestPayment = true;

	/** The payment type. */
	@NotEmpty
	@SerializedName("payment_type")
	private PaymentType paymentType;

	/** The merchant name. */
	@NotEmpty
	@SerializedName("merchant_name")
	private String merchantName;

	/** The price list. */
	@NotEmpty
	@SerializedName("price_list")
	private PriceList priceList;

	/** The requested user info. */
	@NotEmpty
	@SerializedName("requested_user_info")
	private RequestedUserInfo requestedUserInfo;

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
	public PriceList getPriceList() {
		return priceList;
	}

	/**
	 * Sets the price list.
	 *
	 * @param priceList
	 *            the new price list
	 */
	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	/**
	 * Gets the requested user info.
	 *
	 * @return the requested user info
	 */
	public RequestedUserInfo getRequestedUserInfo() {
		return requestedUserInfo;
	}

	/**
	 * Sets the requested user info.
	 *
	 * @param requestedUserInfo
	 *            the new requested user info
	 */
	public void setRequestedUserInfo(RequestedUserInfo requestedUserInfo) {
		this.requestedUserInfo = requestedUserInfo;
	}

}
