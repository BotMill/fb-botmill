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
package co.aurasphere.botmill.fb.model.api.messengerprofile;

import java.io.Serializable;
import java.util.Locale;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import co.aurasphere.botmill.fb.internal.util.validation.FbBotMillValidationConstants;


/**
 * Greeting object used by the {@link SetGreetingTextRequest}.
 * 
 * @author Donato Rimenti
 */
public class Greeting implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Placeholder for the user first name. This placeholder will be dinamically
	 * changed with the current user first name.
	 */
	public static final String USER_FIRST_NAME = "{{user_first_name}}";

	/**
	 * Placeholder for the user last name. This placeholder will be dinamically
	 * changed with the current user last name.
	 */
	public static final String USER_LAST_NAME = "{{user_last_name}}";

	/**
	 * Placeholder for the user full name. This placeholder will be dinamically
	 * changed with the current user full name.
	 */
	public static final String USER_FULL_NAME = "{{user_full_name}}";

	/**
	 * Locale of the greeting text. We will show this greeting text when user
	 * locale matches the provided locale. You must at least specify greeting
	 * text for the default locale. This is the text we will fall back to if we
	 * don't find another matching the user's locale. See the list of supported
	 * locales.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/messenger-profile/supported-locales"
	 *      >List of Facebook's supported locales</a>
	 */
	@NotBlank
	private String locale;

	/**
	 * The greeting text for the specific locale. It must be UTF-8 and has a 160
	 * character limit.
	 */
	@NotBlank
	@Size(max = FbBotMillValidationConstants.GREETING_TEXT_MAX_LENGTH)
	private String text;

	/**
	 * Instantiates a new Greeting.
	 */
	public Greeting() {
		this.locale = "default";
	}

	/**
	 * Instantiates a new Greeting.
	 *
	 * @param text
	 *            the {@link #text}.
	 */
	public Greeting(String text) {
		this();
		this.text = text;
	}

	/**
	 * Instantiates a new Greeting.
	 *
	 * @param text
	 *            the {@link #text}.
	 * @param locale
	 *            the {@link #locale}.
	 */
	public Greeting(String text, String locale) {
		this.locale = locale;
		this.text = text;
	}

	/**
	 * Instantiates a new Greeting.
	 *
	 * @param text
	 *            the {@link #text}.
	 * @param locale
	 *            the {@link #locale}.
	 */
	public Greeting(String text, Locale locale) {
		this(text, locale.toString().toLowerCase());
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
	 * Gets the {@link #text}.
	 *
	 * @return the {@link #text}.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the {@link #text}.
	 *
	 * @param text
	 *            the {@link #text} to set.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Greeting other = (Greeting) obj;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Greeting [locale=" + locale + ", text=" + text + "]";
	}

}
