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
import co.aurasphere.botmill.fb.model.outcoming.template.button.PriceLabel;
import co.aurasphere.botmill.fb.model.outcoming.template.button.RequestedUserInfo;

/**
 * Builder for a {@link BuyButton}'s {@link PaymentSummary}.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public class PaymentSummaryBuilder {

	/**
	 * The {@link PaymentSummary} created with this builder.
	 */
	private PaymentSummary paymentSummary;

	/**
	 * The parent builder of this builder.
	 */
	private BuyButtonBuilder parentBuilder;

	/**
	 * Instantiates a new PaymentSummaryBuilder.
	 *
	 * @param currency
	 *            the {@link PaymentSummary#currency}.
	 * @param paymentType
	 *            the {@link PaymentSummary#paymentType}.
	 * @param merchantName
	 *            the {@link PaymentSummary#merchantName}.
	 * @param parentBuilder
	 *            the {@link #parentBuilder}.
	 */
	public PaymentSummaryBuilder(String currency, PaymentType paymentType,
			String merchantName, BuyButtonBuilder parentBuilder) {
		this.parentBuilder = parentBuilder;
		this.paymentSummary = new PaymentSummary();
		this.paymentSummary.setCurrency(currency);
		this.paymentSummary.setPaymentType(paymentType);
		this.paymentSummary.setMerchantName(merchantName);
	}

	/**
	 * Sets the {@link PaymentSummary#isTestPayment}.
	 * 
	 * @param isTestPayment
	 *            the {@link PaymentSummary#isTestPayment} to set.
	 * @return this builder.
	 */
	public PaymentSummaryBuilder setTestPayment(boolean isTestPayment) {
		this.paymentSummary.setTestPayment(isTestPayment);
		return this;
	}

	/**
	 * Adds a {@link PriceLabel} to the {@link PaymentSummary}.
	 * 
	 * @param label
	 *            the {@link PriceLabel#label}.
	 * @param amount
	 *            the {@link PriceLabel#amount}.
	 * @return this builder.
	 */
	public PaymentSummaryBuilder addPriceLabel(String label, String amount) {
		PriceLabel priceLabel = new PriceLabel(label, amount);
		return addPriceLabel(priceLabel);
	}

	/**
	 * Adds a {@link PriceLabel} to the {@link PaymentSummary}.
	 * 
	 * @param priceLabel
	 *            the {@link PriceLabel} to add to the
	 *            {@link PaymentSummary#priceList}.
	 * @return this builder.
	 */
	public PaymentSummaryBuilder addPriceLabel(PriceLabel priceLabel) {
		this.paymentSummary.addPriceLabel(priceLabel);
		return this;
	}

	/**
	 * Adds a {@link RequestedUserInfo} to the {@link PaymentSummary}.
	 * 
	 * @param requestedUserInfo
	 *            the {@link RequestedUserInfo} to add to the
	 *            {@link PaymentSummary#requestedUserInfo}.
	 * @return this builder.
	 */
	public PaymentSummaryBuilder addRequestedUserInfo(
			RequestedUserInfo requestedUserInfo) {
		this.paymentSummary.addRequestedUserInfo(requestedUserInfo);
		return this;
	}

	/**
	 * Builds the {@link BuyButton}.
	 * 
	 * @return the {@link BuyButtonBuilder#buyButton}.
	 */
	public BuyButton build() {
		this.parentBuilder.setPaymentSummary(paymentSummary);
		return parentBuilder.build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaymentSummaryBuilder [paymentSummary=" + paymentSummary
				+ ", parentBuilder=" + parentBuilder + "]";
	}

}
