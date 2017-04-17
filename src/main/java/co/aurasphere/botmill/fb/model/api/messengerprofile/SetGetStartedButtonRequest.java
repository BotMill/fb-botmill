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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.api.MessengerProfileApi;

import com.google.gson.annotations.SerializedName;


/**
 * Request for
 * {@link MessengerProfileApi#setGetStartedButton(String)}
 * method.
 * 
 * @author Donato Rimenti
 */
public class SetGetStartedButtonRequest implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Object which contains the payload to be sent back when the Get Started
	 * Button is pressed.
	 */
	@Valid
	@NotNull
	@SerializedName("get_started")
	private GetStarted getStarted;
	
	/**
	 * Instantiates a new GetStartedRequest.
	 */
	public SetGetStartedButtonRequest() {
	}
	
	/**
	 * Instantiates a new GetStartedRequest.
	 *
	 * @param payload the {@link GetStarted#payload}.
	 */
	public SetGetStartedButtonRequest(String payload) {
		this.getStarted = new GetStarted(payload);
	}

	/**
	 * Gets the {@link #getStarted}.
	 *
	 * @return the {@link #getStarted}.
	 */
	public GetStarted getGetStarted() {
		return getStarted;
	}

	/**
	 * Sets the {@link #getStarted}.
	 *
	 * @param getStarted
	 *            the {@link #getStarted} to set.
	 */
	public void setGetStarted(GetStarted getStarted) {
		this.getStarted = getStarted;
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
		result = prime * result
				+ ((getStarted == null) ? 0 : getStarted.hashCode());
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
		SetGetStartedButtonRequest other = (SetGetStartedButtonRequest) obj;
		if (getStarted == null) {
			if (other.getStarted != null)
				return false;
		} else if (!getStarted.equals(other.getStarted))
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
		return "GetStartedRequest []";
	}

}