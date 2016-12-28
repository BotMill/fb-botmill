package co.aurasphere.botmill.fb.model.outcoming.template.button;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.annotations.SerializedName;

/**
 * The Buy Button Class/Object.
 *
 * @author Alvin Reyes
 * @date Nov 27, 2016
 */
public class BuyButton extends Button {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The payload. */
	@Size(max = 1000)
	@NotBlank
	private String payload;

	/** The payment summary. */
	@Valid
	@NotNull
	@SerializedName("payment_summary")
	private PaymentSummary paymentSummary;
	
	/**
	 * The button title.
	 */
	@Size(max=20)
	@NotBlank
	protected String title;

	/**
	 * Instantiates a new buy button.
	 *
	 * @param type
	 *            the type
	 * @param payload
	 *            the payload
	 * @param paymentSummary
	 *            the payment summary
	 */
	public BuyButton(ButtonType type, String payload, PaymentSummary paymentSummary) {
	// TODO: buy button title must be buy
		this.title = "buy";
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
	 * @param payload
	 *            the new payload
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
	 * @param paymentSummary
	 *            the new payment summary
	 */
	public void setPaymentSummary(PaymentSummary paymentSummary) {
		this.paymentSummary = paymentSummary;
	}
	

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
