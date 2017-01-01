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
package co.aurasphere.botmill.fb.model.outcoming.message;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;


/**
 * A {@link FbBotMillResponse} which replies with a {@link Message}.
 * 
 * @author Donato Rimenti
 * 
 */
public class FbBotMillMessageResponse extends FbBotMillResponse {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The message associated with this reply.
	 */
	@Valid
	@NotNull
	private Message message;

	/**
	 * Instantiates a new FbBotMillMessageResponse.
	 *
	 * @param recipient the {@link FbBotMillResponse#recipient}.
	 * @param message the {@link #message}.
	 */
	public FbBotMillMessageResponse(User recipient, Message message) {
		this.recipient = recipient;
		this.message = message;
	}

	/**
	 * Gets the {@link #message}.
	 *
	 * @return the {@link #message}.
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * Sets the {@link #message}.
	 *
	 * @param message the {@link #message} to set.
	 */
	public void setMessage(Message message) {
		this.message = message;
	}

}
