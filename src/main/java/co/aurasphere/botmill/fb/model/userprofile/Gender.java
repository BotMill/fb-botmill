package co.aurasphere.botmill.fb.model.userprofile;

import com.google.gson.annotations.SerializedName;


/**
 * Enumeration used for the deserialization of the gender in the user profile.
 * 
 * @author Donato Rimenti
 * 
 */
public enum Gender {

	/**
	 * The male gender.
	 */
	@SerializedName("male")
	MALE,

	/**
	 * The female gender.
	 */
	@SerializedName("female")
	FEMALE;

}
