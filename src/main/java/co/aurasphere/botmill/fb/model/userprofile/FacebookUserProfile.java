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
package co.aurasphere.botmill.fb.model.userprofile;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Model for the User Profile API. <br>
 * <br>
 * The profile API can be used to query more information about the user, and
 * personalize the experience further. This API is only available after the user
 * initiated the conversation by sending a message or by interacting with a
 * <a href=
 * "https://developers.facebook.com/docs/messenger-platform/plugin-reference" >
 * Web Plugin</a>. <br>
 * <br>
 * If the conversation was initiated by using a phone number (customer
 * matching]), you will only be able to use this API after the user replied to
 * your message. <br>
 * <br>
 * The information at this API is only available after a person has sent a
 * message to your bot or clicked the "Send to Messenger" plugin. If you call
 * the API before these actions, then you will receive an empty result. You will
 * also receive an empty result if a person has revoked platform permissions on
 * Facebook.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/user-profile" >
 *      Facebook's Messenger User Profile Reference Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/plugin-reference"
 *      > Facebook's Messenger Platform Plugin Reference Documentation</a>
 * 
 */
public class FacebookUserProfile implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * First name.
	 */
	@SerializedName("first_name")
	private String firstName;

	/**
	 * Last name.
	 */
	@SerializedName("last_name")
	private String lastName;

	/**
	 * Profile picture.
	 */
	@SerializedName("profile_pic")
	private String profilePic;

	/**
	 * Locale of the user on Facebook.
	 */
	private String locale;

	/**
	 * Timezone, number relative to GMT.
	 */
	private int timezone;

	/**
	 * Gender.
	 */
	private Gender gender;

	/**
	 * Is the user eligible to receive messenger platform payment messages.
	 */
	@SerializedName("is_payment_enabled")
	private boolean isPaymentEnabled;

	/**
	 * Gets the {@link #firstName}.
	 *
	 * @return the {@link #firstName}.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the {@link #firstName}.
	 *
	 * @param firstName
	 *            the {@link #firstName} to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the {@link #lastName}.
	 *
	 * @return the {@link #lastName}.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the {@link #lastName}.
	 *
	 * @param lastName
	 *            the {@link #lastName} to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the {@link #profilePic}.
	 *
	 * @return the {@link #profilePic}.
	 */
	public String getProfilePic() {
		return profilePic;
	}

	/**
	 * Sets the {@link #profilePic}.
	 *
	 * @param profilePic
	 *            the {@link #profilePic} to set.
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	/**
	 * Gets the {@link #locale}.
	 *
	 * @return the {@link #locale}.
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Sets the {@link #locale}.
	 *
	 * @param locale
	 *            the {@link #locale} to set.
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * Gets the {@link #timezone}.
	 *
	 * @return the {@link #timezone}.
	 */
	public int getTimezone() {
		return timezone;
	}

	/**
	 * Sets the {@link #timezone}.
	 *
	 * @param timezone
	 *            the {@link #timezone} to set.
	 */
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	/**
	 * Gets the {@link #gender}.
	 *
	 * @return the {@link #gender}.
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the {@link #gender}.
	 *
	 * @param gender
	 *            the {@link #gender} to set.
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Checks if is payment enabled.
	 *
	 * @return the {#isPaymentEnabled}.
	 */
	public boolean isPaymentEnabled() {
		return isPaymentEnabled;
	}

	/**
	 * Sets the {@link #isPaymentEnabled}.
	 *
	 * @param isPaymentEnabled
	 *            the {@link #isPaymentEnabled} to set.
	 */
	public void setPaymentEnabled(boolean isPaymentEnabled) {
		this.isPaymentEnabled = isPaymentEnabled;
	}

}
