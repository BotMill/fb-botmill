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
package co.aurasphere.botmill.fb.api;

import co.aurasphere.botmill.fb.internal.util.network.FbBotMillNetworkController;
import co.aurasphere.botmill.fb.model.api.messengercode.MessengerCode;
import co.aurasphere.botmill.fb.model.api.messengercode.MessengerCodeRequest;

/**
 * Base class for handling Messenger Code API.
 * 
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/messenger-code"
 *      >Facebook's Messenger Code API Reference.</a>
 * @since 2.0.0
 */
public class MessengerCodeApi {

	/**
	 * Instantiates a new MessengerCodeApi.
	 */
	private MessengerCodeApi() {
	}

	/**
	 * Gets a messenger code(Facebook's Messenger QR Code).
	 * 
	 * @param request
	 *            the size of the code to retrieve.
	 * @return a {@link MessengerCode}.
	 */
	public static MessengerCode getMessengerCode(MessengerCodeRequest request) {
		return FbBotMillNetworkController.postMessengerCode(request);
	}

	/**
	 * Gets a messenger code(Facebook's Messenger QR Code).
	 * 
	 * @param imageSize
	 *            the size of the code to retrieve.
	 * @return a {@link MessengerCode}.
	 */
	public static MessengerCode getMessengerCode(int imageSize) {
		MessengerCodeRequest request = new MessengerCodeRequest(imageSize);
		return getMessengerCode(request);
	}

	/**
	 * Gets a messenger code(Facebook's Messenger QR Code) with default size
	 * (1000 px).
	 * 
	 * @return a {@link MessengerCode}.
	 */
	public static MessengerCode getMessengerCode() {
		MessengerCodeRequest request = new MessengerCodeRequest();
		return getMessengerCode(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessengerCodeApi []";
	}

}
