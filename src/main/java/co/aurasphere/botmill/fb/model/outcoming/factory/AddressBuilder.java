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

import co.aurasphere.botmill.fb.model.outcoming.template.receipt.Address;

/**
 * Builder for an {@link Address}.
 * 
 * @author Donato Rimenti
 * 
 */
public class AddressBuilder {

	/**
	 * The parent builder of this builder.
	 */
	private ReceiptTemplateBuilder parentBuilder;

	/**
	 * The element managed by this builder.
	 */
	private Address address;

	/**
	 * Instantiates a new address builder.
	 *
	 * @param parentBuilder
	 *            the {@link #parentBuilder}.
	 */
	public AddressBuilder(ReceiptTemplateBuilder parentBuilder) {
		this.parentBuilder = parentBuilder;
		this.address = new Address();
	}

	/**
	 * Sets the Street address, line 1. This field is mandatory and it can't be
	 * null or empty.
	 * 
	 * @param street1
	 *            the first line of the street address to set.
	 * @return this builder.
	 */
	public AddressBuilder setStreet1(String street1) {
		this.address.setStreet1(street1);
		return this;
	}

	/**
	 * Sets the Street address, line 2.
	 * 
	 * @param street2
	 *            the second line of the street address to set.
	 * @return this builder.
	 */
	public AddressBuilder setStreet2(String street2) {
		this.address.setStreet2(street2);
		return this;
	}

	/**
	 * Sets the city. This field is mandatory and it can't be null or empty.
	 * 
	 * @param city
	 *            the city to set.
	 * @return this builder.
	 */
	public AddressBuilder setCity(String city) {
		this.address.setCity(city);
		return this;
	}

	/**
	 * Sets the postal code. This field is mandatory and it can't be null or
	 * empty.
	 * 
	 * @param postalCode
	 *            the postal code to set.
	 * @return this builder.
	 */
	public AddressBuilder setPostalCode(String postalCode) {
		this.address.setPostalCode(postalCode);
		return this;
	}

	/**
	 * Sets the state abbreviation or Region/Province (international). This
	 * field is mandatory and it can't be null or empty.
	 * 
	 * @param state
	 *            the state to set.
	 * @return this builder.
	 */
	public AddressBuilder setState(String state) {
		this.address.setState(state);
		return this;
	}

	/**
	 * Sets the two-letter country abbreviation. This field is mandatory and it
	 * can't be null or empty.
	 * 
	 * @param country
	 *            the country to set.
	 * @return this builder.
	 */
	public AddressBuilder setCountry(String country) {
		this.address.setCountry(country);
		return this;
	}

	/**
	 * Builds the current object, adds it to the parent builder and returns the
	 * parent builder.
	 * 
	 * @return the parent builder of this builder.
	 */
	public ReceiptTemplateBuilder endAddress() {
		this.parentBuilder.setAddress(this.address);
		return this.parentBuilder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressBuilder [parentBuilder=" + parentBuilder + ", address="
				+ address + "]";
	}

}
