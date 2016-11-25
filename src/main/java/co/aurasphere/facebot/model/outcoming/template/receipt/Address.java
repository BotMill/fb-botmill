package co.aurasphere.facebot.model.outcoming.template.receipt;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@SerializedName("street_1")
	private String street1;
	
	@SerializedName("street_2")
	private String street2;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	@SerializedName("postal_code")
	private String postalCode;
	
	@NotEmpty
	private String state;
	
	// TODO message
	@NotEmpty
	@Pattern(regexp="[A-Za-z]{2}", message="{country.pattern.message}")
	private String country;
	
	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
