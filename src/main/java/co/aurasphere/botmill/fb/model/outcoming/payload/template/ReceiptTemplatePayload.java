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
//TODO test with empty lists. if they don't work, use lazy initialization
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
	@Pattern(regexp="[A-Z]{3}", message="{currency.pattern.message}")
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
	public ReceiptTemplatePayload(){
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
	 * @param recipientName the new recipient name
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
	 * @param merchantName the new merchant name
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
	 * @param orderNumber the new order number
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
	 * @param currency the new currency
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
	 * @param paymentMethod the new payment method
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
	 * @param timestamp the new timestamp
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
	 * @param orderUrl the new order url
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
	 * @param elements the new elements
	 */
	public void setElements(List<ReceiptTemplateElement> elements) {
		this.elements = elements;
	}

	/**
	 * Adds the element.
	 *
	 * @param element the element
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
	 * @param address the new address
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
	 * @param summary the new summary
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
	 * @param adjustments the new adjustments
	 */
	public void setAdjustments(List<Adjustment> adjustments) {
		this.adjustments = adjustments;
	}
	
	/**
	 * Adds the adjustment.
	 *
	 * @param adjustment the adjustment
	 */
	public void addAdjustment(Adjustment adjustment) {
		this.adjustments.add(adjustment);
	}

}
