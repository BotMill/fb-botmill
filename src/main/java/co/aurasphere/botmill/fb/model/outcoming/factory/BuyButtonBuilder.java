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
package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.outcoming.template.button.BuyButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PaymentSummary;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PaymentType;

/**
 * Builder for a {@link BuyButton}.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public class BuyButtonBuilder {

	/**
	 * The {@link BuyButton} created with this builder.
	 */
	private BuyButton buyButton;

	/**
	 * Instantiates a new BuyButtonBuilder.
	 *
	 * @param payload
	 *            the {@link BuyButton#payload}.
	 */
	BuyButtonBuilder(String payload) {
		this.buyButton = new BuyButton(payload);
	}

	/**
	 * Sets the {@link PaymentSummary} for the current {@link BuyButton}.
	 * 
	 * @param paymentSummary
	 *            the {@link BuyButton#paymentSummary}.
	 * @return this builder.
	 */
	public BuyButtonBuilder setPaymentSummary(PaymentSummary paymentSummary) {
		this.buyButton.setPaymentSummary(paymentSummary);
		return this;
	}

	/**
	 * Sets the {@link PaymentSummary} for the current {@link BuyButton}.
	 * 
	 * @param currency
	 *            the {@link PaymentSummary#currency}.
	 * @param paymentType
	 *            the {@link PaymentSummary#paymentType}.
	 * @param merchantName
	 *            the {@link PaymentSummary#merchantName}.
	 * @return this builder.
	 */
	public PaymentSummaryBuilder setPaymentSummary(String currency,
			PaymentType paymentType, String merchantName) {
		return new PaymentSummaryBuilder(currency, paymentType, merchantName,
				this);
	}

	/**
	 * Builds the {@link BuyButton}.
	 * 
	 * @return the {@link #buyButton}.
	 */
	public BuyButton build() {
		return this.buyButton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BuyButtonBuilder [buyButton=" + buyButton + "]";
	}

}
