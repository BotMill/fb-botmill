/**
 * 
 */
package co.aurasphere.facebot.model.incoming.callback;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * An object that represents the shipping address, used by the
 * {@link CheckoutUpdate} class.
 * 
 * @author Donato Rimenti
 * @date Dec 17, 2016
 */
public class ShippingAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID of shipping address.
	 */
	private String id;

	/**
	 * Shipping address country.
	 */
	private String country;

	/**
	 * Shipping address city.
	 */
	private String city;

	/**
	 * Shipping address street, first line.
	 */
	private String street1;

	/**
	 * Shipping address street, second line.
	 */
	private String street2;

	/**
	 * Shipping address state.
	 */
	private String state;

	/**
	 * Shipping address postal code.
	 */
	@SerializedName("postal_code")
	private String postalCode;

	/**
	 * Gets the {@link #id}.
	 *
	 * @return the {@link #id}.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the {@link #id}.
	 *
	 * @param id
	 *            the {@link #id} to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the {@link #country}.
	 *
	 * @return the {@link #country}.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the {@link #country}.
	 *
	 * @param country
	 *            the {@link #country} to set.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the {@link #city}.
	 *
	 * @return the {@link #city}.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the {@link #city}.
	 *
	 * @param city
	 *            the {@link #city} to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the {@link #street1}.
	 *
	 * @return the {@link #street1}.
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * Sets the {@link #street1}.
	 *
	 * @param street1
	 *            the {@link #street1} to set.
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * Gets the {@link #street2}.
	 *
	 * @return the {@link #street2}.
	 */
	public String getStreet2() {
		return street2;
	}

	/**
	 * Sets the {@link #street2}.
	 *
	 * @param street2
	 *            the {@link #street2} to set.
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	/**
	 * Gets the {@link #state}.
	 *
	 * @return the {@link #state}.
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the {@link #state}.
	 *
	 * @param state
	 *            the {@link #state} to set.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the {@link #postalCode}.
	 *
	 * @return the {@link #postalCode}.
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the {@link #postalCode}.
	 *
	 * @param postalCode
	 *            the {@link #postalCode} to set.
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
