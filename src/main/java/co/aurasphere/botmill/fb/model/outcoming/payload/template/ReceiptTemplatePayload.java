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
package co.aurasphere.botmill.fb.model.outcoming.payload.template;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.template.receipt.Address;
import co.aurasphere.botmill.fb.model.outcoming.template.receipt.Adjustment;
import co.aurasphere.botmill.fb.model.outcoming.template.receipt.ReceiptTemplateElement;
import co.aurasphere.botmill.fb.model.outcoming.template.receipt.Summary;

import com.google.gson.annotations.SerializedName;

/**
 * The Class ReceiptTemplatePayload.
 */
// TODO test with empty lists. if they don't work, use lazy initialization
public class ReceiptTemplatePayload extends TemplateBasePayload {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The recipient name. */
	@NotBlank
	@SerializedName("recipient_name")
	private String recipientName;

	/** The merchant name. */
	@SerializedName("merchant_name")
	private String merchantName;

	/** The order number. */
	// TODO: unique, document
	@NotBlank
	@SerializedName("order_number")
	private String orderNumber;

	/** The currency. */
	@NotBlank
	@Pattern(regexp = "[A-Z]{3}", message = "{currency.pattern.message}")
	private String currency;

	/** The payment method. */
	@NotBlank
	@SerializedName("payment_method")
	private String paymentMethod;

	/** The timestamp. */
	private String timestamp;

	/** The order url. */
	@SerializedName("order_url")
	private String orderUrl;

	/** The elements. */
	// TODO: sort not guaranteed, document
	@Size(max = 100)
	private List<ReceiptTemplateElement> elements;

	/** The address. */
	private Address address;

	/** The summary. */
	@Valid
	@NotNull
	private Summary summary;

	/** The adjustments. */
	private List<Adjustment> adjustments;

	/**
	 * Instantiates a new receipt template payload.
	 */
	public ReceiptTemplatePayload() {
		this.templateType = PayloadType.RECEIPT;
		this.elements = new ArrayList<ReceiptTemplateElement>();
		this.adjustments = new ArrayList<Adjustment>();
	}

	/**
	 * Gets the recipient name.
	 *
	 * @return the recipient name
	 */
	public String getRecipientName() {
		return recipientName;
	}

	/**
	 * Sets the recipient name.
	 *
	 * @param recipientName
	 *            the new recipient name
	 */
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
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
	 * Gets the order number.
	 *
	 * @return the order number
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * Sets the order number.
	 *
	 * @param orderNumber
	 *            the new order number
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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
	 * Gets the payment method.
	 *
	 * @return the payment method
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Sets the payment method.
	 *
	 * @param paymentMethod
	 *            the new payment method
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp
	 *            the new timestamp
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the order url.
	 *
	 * @return the order url
	 */
	public String getOrderUrl() {
		return orderUrl;
	}

	/**
	 * Sets the order url.
	 *
	 * @param orderUrl
	 *            the new order url
	 */
	public void setOrderUrl(String orderUrl) {
		this.orderUrl = orderUrl;
	}

	/**
	 * Gets the elements.
	 *
	 * @return the elements
	 */
	public List<ReceiptTemplateElement> getElements() {
		return elements;
	}

	/**
	 * Sets the elements.
	 *
	 * @param elements
	 *            the new elements
	 */
	public void setElements(List<ReceiptTemplateElement> elements) {
		this.elements = elements;
	}

	/**
	 * Adds the element.
	 *
	 * @param element
	 *            the element
	 */
	public void addElement(ReceiptTemplateElement element) {
		this.elements.add(element);
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address
	 *            the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets the summary.
	 *
	 * @return the summary
	 */
	public Summary getSummary() {
		return summary;
	}

	/**
	 * Sets the summary.
	 *
	 * @param summary
	 *            the new summary
	 */
	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	/**
	 * Gets the adjustments.
	 *
	 * @return the adjustments
	 */
	public List<Adjustment> getAdjustments() {
		return adjustments;
	}

	/**
	 * Sets the adjustments.
	 *
	 * @param adjustments
	 *            the new adjustments
	 */
	public void setAdjustments(List<Adjustment> adjustments) {
		this.adjustments = adjustments;
	}

	/**
	 * Adds the adjustment.
	 *
	 * @param adjustment
	 *            the adjustment
	 */
	public void addAdjustment(Adjustment adjustment) {
		this.adjustments.add(adjustment);
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((adjustments == null) ? 0 : adjustments.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((elements == null) ? 0 : elements.hashCode());
		result = prime * result
				+ ((merchantName == null) ? 0 : merchantName.hashCode());
		result = prime * result
				+ ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result
				+ ((orderUrl == null) ? 0 : orderUrl.hashCode());
		result = prime * result
				+ ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result
				+ ((recipientName == null) ? 0 : recipientName.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
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
		ReceiptTemplatePayload other = (ReceiptTemplatePayload) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (adjustments == null) {
			if (other.adjustments != null)
				return false;
		} else if (!adjustments.equals(other.adjustments))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		if (merchantName == null) {
			if (other.merchantName != null)
				return false;
		} else if (!merchantName.equals(other.merchantName))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (orderUrl == null) {
			if (other.orderUrl != null)
				return false;
		} else if (!orderUrl.equals(other.orderUrl))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		if (recipientName == null) {
			if (other.recipientName != null)
				return false;
		} else if (!recipientName.equals(other.recipientName))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
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
		return "ReceiptTemplatePayload [recipientName=" + recipientName
				+ ", merchantName=" + merchantName + ", orderNumber="
				+ orderNumber + ", currency=" + currency + ", paymentMethod="
				+ paymentMethod + ", timestamp=" + timestamp + ", orderUrl="
				+ orderUrl + ", elements=" + elements + ", address=" + address
				+ ", summary=" + summary + ", adjustments=" + adjustments
				+ ", templateType=" + templateType + "]";
	}

}
