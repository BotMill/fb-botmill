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
package co.aurasphere.botmill.fb.model.outcoming.action;

import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;

import com.google.gson.annotations.SerializedName;

/**
 * A {@link FbBotMillResponse} which replies with a {@link TypingAction}.
 * 
 * @author Donato Rimenti
 * 
 */
public class FbBotMillActionResponse extends FbBotMillResponse {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The typing action to send.
	 */
	@NotNull
	@SerializedName("sender_action")
	private TypingAction action;

	/**
	 * Instantiates a new fb bot mill action response.
	 *
	 * @param recipient
	 *            the {@link FbBotMillResponse#recipient}.
	 * @param action
	 *            the {@link #action}.
	 */
	public FbBotMillActionResponse(User recipient, TypingAction action) {
		this.recipient = recipient;
		this.action = action;
	}

	/**
	 * Gets the {@link #action}.
	 *
	 * @return the {@link #action}.
	 */
	public TypingAction getAction() {
		return action;
	}

	/**
	 * Sets the {@link #action}.
	 *
	 * @param action
	 *            the {@link #action} to set.
	 */
	public void setAction(TypingAction action) {
		this.action = action;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse#equals(java
	 * .lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FbBotMillActionResponse other = (FbBotMillActionResponse) obj;
		if (action != other.action)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillActionResponse [action=" + action + ", recipient="
				+ recipient + "]";
	}

}
