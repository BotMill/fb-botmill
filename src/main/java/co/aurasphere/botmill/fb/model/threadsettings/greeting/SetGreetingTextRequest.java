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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.threadsettings.SettingType;
import co.aurasphere.botmill.fb.model.threadsettings.ThreadSettingsBaseRequest;

/**
 * Request used for Thread Settings of Text Greeting.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 */
public class SetGreetingTextRequest extends ThreadSettingsBaseRequest {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Greeting text.
	 */
	@Valid
	@NotNull
	private Greeting greeting;

	/**
	 * Instantiates a new set greeting text request.
	 *
	 * @param greeting
	 *            the {@link #greeting}.
	 */
	public SetGreetingTextRequest(String greeting) {
		this.type = SettingType.GREETING;
		this.greeting = new Greeting(greeting);
	}

	/**
	 * Gets the {@link #greeting}.
	 *
	 * @return the {@link #greeting}.
	 */
	public Greeting getGreeting() {
		return greeting;
	}

	/**
	 * Sets the {@link #greeting}.
	 *
	 * @param greeting
	 *            the {@link #greeting} to set.
	 */
	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.threadsettings.ThreadSettingsBaseRequest
	 * #hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((greeting == null) ? 0 : greeting.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.threadsettings.ThreadSettingsBaseRequest
	 * #equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SetGreetingTextRequest other = (SetGreetingTextRequest) obj;
		if (greeting == null) {
			if (other.greeting != null)
				return false;
		} else if (!greeting.equals(other.greeting))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.threadsettings.ThreadSettingsBaseRequest
	 * #toString()
	 */
	@Override
	public String toString() {
		return "SetGreetingTextRequest [greeting=" + greeting + ", type="
				+ type + "]";
	}
}
