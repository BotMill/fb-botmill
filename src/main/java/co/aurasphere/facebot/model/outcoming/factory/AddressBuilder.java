package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.outcoming.template.receipt.Address;

/**
 * Builder for an {@link Address}.
 * 
 * @author Donato Rimenti
 * @date Nov 25, 2016
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
	 * Default constructor. Creates a builder for an {@link Address}.
	 * 
	 * @param parentBuilder
	 *            the parent builder of this builder.
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

}
