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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.annotations.SerializedName;

/**
 * The Buy Button Class/Object.
 *
 * @author Alvin Reyes
 * 
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
	@Size(max = 20)
	@NotBlank
	protected String title;

	/**
	 * Instantiates a new buy button.
	 * 
	 * @param payload
	 *            the payload
	 */
	public BuyButton(String payload) {
		// Buy button title must be buy
		this.title = "buy";
		this.type = ButtonType.PAYMENT;
		this.payload = payload;
	}

	/**
	 * Instantiates a new buy button.
	 *
	 * @param payload
	 *            the payload
	 * @param paymentSummary
	 *            the payment summary
	 */
	public BuyButton(String payload, PaymentSummary paymentSummary) {
		this(payload);
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
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.template.button.Button#hashCode
	 * ()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((payload == null) ? 0 : payload.hashCode());
		result = prime * result
				+ ((paymentSummary == null) ? 0 : paymentSummary.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.template.button.Button#equals
	 * (java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuyButton other = (BuyButton) obj;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		if (paymentSummary == null) {
			if (other.paymentSummary != null)
				return false;
		} else if (!paymentSummary.equals(other.paymentSummary))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.template.button.Button#toString
	 * ()
	 */
	@Override
	public String toString() {
		return "BuyButton [payload=" + payload + ", paymentSummary="
				+ paymentSummary + ", title=" + title + ", type=" + type + "]";
	}

}
