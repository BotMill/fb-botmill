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

import java.math.BigDecimal;

import co.aurasphere.botmill.fb.model.outcoming.template.receipt.ReceiptTemplateElement;

/**
 * Builder for a {@link ReceiptTemplateElement}.
 * 
 * @author Donato Rimenti
 * 
 */
public class ReceiptTemplateElementBuilder {

	/**
	 * The parent builder of this builder.
	 */
	private ReceiptTemplateBuilder parentBuilder;

	/**
	 * The element managed by this builder.
	 */
	private ReceiptTemplateElement element;

	/**
	 * Default constructor. Creates a builder for a
	 * {@link ReceiptTemplateElement}.
	 * 
	 * @param title
	 *            the title of the item. This field is mandatory and can't be
	 *            empty or null.
	 * @param parentBuilder
	 *            the parent builder of this builder.
	 */
	ReceiptTemplateElementBuilder(String title,
			ReceiptTemplateBuilder parentBuilder) {
		this.element = new ReceiptTemplateElement();
		this.element.setTitle(title);
		this.parentBuilder = parentBuilder;
	}

	/**
	 * Sets a subtitle for the item.
	 * 
	 * @param subtitle
	 *            the subtitle to set.
	 * @return this builder.
	 */
	public ReceiptTemplateElementBuilder setSubtitle(String subtitle) {
		this.element.setSubtitle(subtitle);
		return this;
	}

	/**
	 * Sets a quantity of item.
	 * 
	 * @param quantity
	 *            the quantity to set.
	 * @return this builder.
	 */
	public ReceiptTemplateElementBuilder setQuantity(int quantity) {
		this.element.setQuantity(quantity);
		return this;
	}

	/**
	 * Sets the item price. This field is mandatory and can't be empty but 0 is
	 * allowed.
	 * 
	 * @param price
	 *            the item price to set.
	 * @return this builder.
	 */
	public ReceiptTemplateElementBuilder setPrice(BigDecimal price) {
		this.element.setPrice(price);
		return this;
	}

	/**
	 * Sets the currency of price.
	 * 
	 * @param currency
	 *            the currency of price to set.
	 * @return this builder.
	 */
	public ReceiptTemplateElementBuilder setCurrency(String currency) {
		this.element.setCurrency(currency);
		return this;
	}

	/**
	 * Sets the image URL of item.
	 * 
	 * @param imageUrl
	 *            the image URL of item to set.
	 * @return this builder.
	 */
	public ReceiptTemplateElementBuilder setImageUrl(String imageUrl) {
		this.element.setImageUrl(imageUrl);
		return this;
	}

	/**
	 * Builds the current object, adds it to the parent builder and returns the
	 * parent builder.
	 * 
	 * @return the parent builder of this builder.
	 */
	public ReceiptTemplateBuilder endElement() {
		this.parentBuilder.addElement(this.element);
		return parentBuilder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReceiptTemplateElementBuilder [parentBuilder=" + parentBuilder
				+ ", element=" + element + "]";
	}

}
