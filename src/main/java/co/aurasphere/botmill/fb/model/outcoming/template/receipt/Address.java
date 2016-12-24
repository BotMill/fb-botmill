package co.aurasphere.botmill.fb.model.outcoming.template.receipt;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;


/**
 * The Class Address.
 */
public class Address implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The street 1. */
	@NotEmpty
	@SerializedName("street_1")
	private String street1;
	
	/** The street 2. */
	@SerializedName("street_2")
	private String street2;
	
	/** The city. */
	@NotEmpty
	private String city;
	
	/** The postal code. */
	@NotEmpty
	@SerializedName("postal_code")
	private String postalCode;
	
	/** The state. */
	@NotEmpty
	private String state;
	
	/** The country. */
	// TODO message
	@NotEmpty
	@Pattern(regexp="[A-Za-z]{2}", message="{country.pattern.message}")
	private String country;
	
	/**
	 * Gets the street 1.
	 *
	 * @return the street 1
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * Sets the street 1.
	 *
	 * @param street1 the new street 1
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * Gets the street 2.
	 *
	 * @return the street 2
	 */
	public String getStreet2() {
		return street2;
	}

	/**
	 * Sets the street 2.
	 *
	 * @param street2 the new street 2
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the postal code.
	 *
	 * @return the postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the postal code.
	 *
	 * @param postalCode the new postal code
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
}
