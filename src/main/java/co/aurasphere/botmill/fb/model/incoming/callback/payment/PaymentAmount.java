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
package co.aurasphere.botmill.fb.model.incoming.callback.payment;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Object that represents the total amount of a transaction for a
 * {@link Payment} callback.
 * 
 * @author Donato Rimenti
 * 
 */
public class PaymentAmount implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Currency of the amount.
	 */
	private String currency;

	// TODO: https://github.com/BotMill/fb-botmill/issues/19
	/**
	 * Total amount.
	 */
	private BigDecimal amount;

	/**
	 * Gets the {@link #currency}.
	 *
	 * @return the {@link #currency}.
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the {@link #currency}.
	 *
	 * @param currency
	 *            the {@link #currency} to set.
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the {@link #amount}.
	 *
	 * @return the {@link #amount}.
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Sets the {@link #amount}.
	 *
	 * @param amount
	 *            the {@link #amount} to set.
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
