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
package co.aurasphere.botmill.fb.model.threadsettings.greeting;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import co.aurasphere.botmill.fb.internal.util.validation.FbBotMillValidationConstants;

/**
 * Object which represents a Greeting Text for Thread Settings.
 * 
 * @author Donato Rimenti
 * 
 */
public class Greeting implements Serializable {

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
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The message that will be shown to the user. This message can include the
	 * user name. To do that, add to the String the following placeholders
	 * constants from this class:
	 * 
	 * <pre>
	 * - {@link #USER_FIRST_NAME} 
	 * - {@link #USER_LAST_NAME} 
	 * - {@link #USER_FULL_NAME}
	 * </pre>
	 * 
	 * This message can be at most
	 * {@value FbBotMillValidationConstants#THREAD_SETTINGS_GREETING_MESSAGE_MAX_LENGTH}
	 * characters long. The placeholders for the last and full name use 18
	 * characters, meanwhile the first name uses 19 characters.
	 */
	@Size(max = FbBotMillValidationConstants.THREAD_SETTINGS_GREETING_MESSAGE_MAX_LENGTH)
	@NotBlank
	private String text;

	/**
	 * Instantiates a new greeting.
	 *
	 * @param text
	 *            the {@link #text}.
	 */
	public Greeting(String text) {
		this.text = text;
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
		return "Greeting [text=" + text + "]";
	}

}
