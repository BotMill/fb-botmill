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
package co.aurasphere.botmill.fb.model.outcoming.template.receipt;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Summary.
 */
// TODO: two decimal digits with "." as separator
public class Summary implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The subtotal. */
	private BigDecimal subtotal;

	/** The shipping cost. */
	@SerializedName("shipping_cost")
	private BigDecimal shippingCost;

	/** The total tax. */
	@SerializedName("total_tax")
	private BigDecimal totalTax;

	/** The total cost. */
	@SerializedName("total_cost")
	private BigDecimal totalCost;

	/**
	 * Instantiates a new summary.
	 */
	public Summary() {
	}

	/**
	 * Instantiates a new summary.
	 *
	 * @param subtotal
	 *            the subtotal
	 * @param shippingCost
	 *            the shipping cost
	 * @param totalTax
	 *            the total tax
	 * @param totalCost
	 *            the total cost
	 */
	public Summary(BigDecimal subtotal, BigDecimal shippingCost, BigDecimal totalTax, BigDecimal totalCost) {
		this.subtotal = subtotal;
		this.shippingCost = shippingCost;
		this.totalTax = totalTax;
		this.totalCost = totalCost;
	}

	/**
	 * Gets the subtotal.
	 *
	 * @return the subtotal
	 */
	public BigDecimal getSubtotal() {
		return subtotal;
	}

	/**
	 * Sets the subtotal.
	 *
	 * @param subtotal
	 *            the new subtotal
	 */
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * Gets the shipping cost.
	 *
	 * @return the shipping cost
	 */
	public BigDecimal getShippingCost() {
		return shippingCost;
	}

	/**
	 * Sets the shipping cost.
	 *
	 * @param shippingCost
	 *            the new shipping cost
	 */
	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}

	/**
	 * Gets the total tax.
	 *
	 * @return the total tax
	 */
	public BigDecimal getTotalTax() {
		return totalTax;
	}

	/**
	 * Sets the total tax.
	 *
	 * @param totalTax
	 *            the new total tax
	 */
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * Gets the total cost.
	 *
	 * @return the total cost
	 */
	public BigDecimal getTotalCost() {
		return totalCost;
	}

	/**
	 * Sets the total cost.
	 *
	 * @param totalCost
	 *            the new total cost
	 */
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

}
