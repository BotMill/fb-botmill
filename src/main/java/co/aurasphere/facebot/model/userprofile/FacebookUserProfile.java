package co.aurasphere.facebot.model.userprofile;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class FacebookUserProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@SerializedName("first_name")
	private String firstName;
	
	@SerializedName("last_name")
	private String lastName;
	
	@SerializedName("profile_pic")
	private String profilePic;
	
	private String locale;
	
	private int timezone;
	
	private Gender gender;
	
	@SerializedName("is_payment_enabled")
	private boolean isPaymentEnabled;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public int getTimezone() {
		return timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isPaymentEnabled() {
		return isPaymentEnabled;
	}

	public void setPaymentEnabled(boolean isPaymentEnabled) {
		this.isPaymentEnabled = isPaymentEnabled;
	}
	
	

}
