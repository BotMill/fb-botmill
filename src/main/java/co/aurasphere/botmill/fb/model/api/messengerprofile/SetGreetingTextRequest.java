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
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.api.MessengerProfileApi;


/**
 * Request for {@link MessengerProfileApi#setGreetingMessage(List)}
 * method.
 * 
 * @author Donato Rimenti
 */
public class SetGreetingTextRequest implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A list of locale-greeting messages to set.
	 */
	@Valid
	@NotEmpty
	private List<Greeting> greeting;

	/**
	 * Instantiates a new GreetingTextRequest.
	 */
	public SetGreetingTextRequest() {
		this.greeting = new ArrayList<Greeting>();
	}

	/**
	 * Instantiates a new GreetingTextRequest.
	 *
	 * @param greeting
	 *            the {@link #greeting}.
	 */
	public SetGreetingTextRequest(List<Greeting> greeting) {
		this.greeting = greeting;
	}

	/**
	 * Instantiates a new sets the greeting text request.
	 *
	 * @param message the message
	 */
	public SetGreetingTextRequest(String message) {
		this();
		greeting.add(new Greeting(message));
	}

	/**
	 * Gets the {@link #greeting}.
	 *
	 * @return the {@link #greeting}.
	 */
	public List<Greeting> getGreeting() {
		return greeting;
	}

	/**
	 * Sets the {@link #greeting}.
	 *
	 * @param greeting
	 *            the {@link #greeting} to set.
	 */
	public void setGreeting(List<Greeting> greeting) {
		this.greeting = greeting;
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
				+ ((greeting == null) ? 0 : greeting.hashCode());
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GreetingTextRequest [greeting=" + greeting + "]";
	}

}