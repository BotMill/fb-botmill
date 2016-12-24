package co.aurasphere.botmill.fb.model.outcoming.template.button;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;


/**
 * The Buy Button Class/Object.
 *
 * @author Alvin Reyes
 * @date 27/Nov/2016
 */
public class BuyButton extends Button{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The payload. */
	@Size(max = 1000)
	@NotEmpty
	private String payload;
	
	/** The payment summary. */
	@NotNull
	@SerializedName("payment_summary")
	private PaymentSummary paymentSummary;
	
	/**
	 * Instantiates a new buy button.
	 *
	 * @param type the type
	 * @param title the title
	 * @param payload the payload
	 * @param paymentSummary the payment summary
	 */
	public BuyButton(ButtonType type, String title, String payload, PaymentSummary paymentSummary) {
		this.title = title;
		this.type = type;
		this.payload = payload;
		this.paymentSummary = paymentSummary;
	}

	/**
	 * Gets the payload.
	 *
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * Sets the payload.
	 *
	 * @param payload the new payload
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/**
	 * Gets the payment summary.
	 *
	 * @return the payment summary
	 */
	public PaymentSummary getPaymentSummary() {
		return paymentSummary;
	}

	/**
	 * Sets the payment summary.
	 *
	 * @param paymentSummary the new payment summary
	 */
	public void setPaymentSummary(PaymentSummary paymentSummary) {
		this.paymentSummary = paymentSummary;
	}
	
	


}
