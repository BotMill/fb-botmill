package co.aurasphere.facebot.model.outcoming.template.button;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

/**
 * The Buy Button Class/Object
 * 
 * @author Alvin Reyes
 * @date 27/Nov/2016
 * 
 */
public class BuyButton extends Button{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Size(max = 1000)
	@NotEmpty
	private String payload;
	
	@NotNull
	@SerializedName("payment_summary")
	private PaymentSummary paymentSummary;
	
	public BuyButton(ButtonType type, String title, String payload, PaymentSummary paymentSummary) {
		this.title = title;
		this.type = type;
		this.payload = payload;
		this.paymentSummary = paymentSummary;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public PaymentSummary getPaymentSummary() {
		return paymentSummary;
	}

	public void setPaymentSummary(PaymentSummary paymentSummary) {
		this.paymentSummary = paymentSummary;
	}
	
	


}
