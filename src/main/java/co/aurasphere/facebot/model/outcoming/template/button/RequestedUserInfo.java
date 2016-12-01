package co.aurasphere.facebot.model.outcoming.template.button;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

/**
 * The RequestedUserInfo Class/Object
 * 
 * @author Alvin Reyes
 * @date 27/Nov/2016
 * 
 */
public class RequestedUserInfo implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The shipping address. */
	@SerializedName("shipping_address")
	private String shippingAddress;

	/** The contact name. */
	@NotEmpty
	@SerializedName("contact_name")
	private String contactName;

	/** The contact phont. */
	@SerializedName("contact_phone")
	private String contactPhont;
	
	/** The contact email. */
	@SerializedName("contact_email")
	private String contactEmail;

	/**
	 * Gets the shipping address.
	 *
	 * @return the shipping address
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * Sets the shipping address.
	 *
	 * @param shippingAddress the new shipping address
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * Gets the contact name.
	 *
	 * @return the contact name
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * Sets the contact name.
	 *
	 * @param contactName the new contact name
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * Gets the contact phont.
	 *
	 * @return the contact phont
	 */
	public String getContactPhont() {
		return contactPhont;
	}

	/**
	 * Sets the contact phont.
	 *
	 * @param contactPhont the new contact phont
	 */
	public void setContactPhont(String contactPhont) {
		this.contactPhont = contactPhont;
	}

	/**
	 * Gets the contact email.
	 *
	 * @return the contact email
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * Sets the contact email.
	 *
	 * @param contactEmail the new contact email
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	
	
}
