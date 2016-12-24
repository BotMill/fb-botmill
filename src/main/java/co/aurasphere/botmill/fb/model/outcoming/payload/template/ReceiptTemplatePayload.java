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

//TODO test con le liste vuote. Se spaccano, si inizializzano lazy.
public class ReceiptTemplatePayload extends TemplateBasePayload {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@SerializedName("recipient_name")
	private String recipientName;
	
	@SerializedName("merchant_name")
	private String merchantName;

	// TODO: unique, document
	@NotBlank
	@SerializedName("order_number")
	private String orderNumber;
	
	@NotBlank
	@Pattern(regexp="[A-Z]{3}", message="{currency.pattern.message}")
	private String currency;
	
	@NotBlank
	@SerializedName("payment_method")
	private String paymentMethod;
	
	private String timestamp;
	
	@SerializedName("order_url")
	private String orderUrl;
	
	// TODO: sort not guaranteed, document
	@Size(max = 100)
	private List<ReceiptTemplateElement> elements;
	
	private Address address;
	
	@Valid
	@NotNull
	private Summary summary;
	
	private List<Adjustment> adjustments;

	public ReceiptTemplatePayload(){
		this.templateType = PayloadType.RECEIPT;
		this.elements = new ArrayList<ReceiptTemplateElement>();
		this.adjustments = new ArrayList<Adjustment>();
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getOrderUrl() {
		return orderUrl;
	}

	public void setOrderUrl(String orderUrl) {
		this.orderUrl = orderUrl;
	}

	public List<ReceiptTemplateElement> getElements() {
		return elements;
	}

	public void setElements(List<ReceiptTemplateElement> elements) {
		this.elements = elements;
	}

	public void addElement(ReceiptTemplateElement element) {
		this.elements.add(element);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	public List<Adjustment> getAdjustments() {
		return adjustments;
	}

	public void setAdjustments(List<Adjustment> adjustments) {
		this.adjustments = adjustments;
	}
	
	public void addAdjustment(Adjustment adjustment) {
		this.adjustments.add(adjustment);
	}

}
