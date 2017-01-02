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
package co.aurasphere.botmill.fb.autoreply;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.internal.util.network.NetworkUtils;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;

/**
 * A class that represents an automatic reply to an event. AutoReply are used in
 * conjuction with {@link FbBotMillEvent} in order to handle an Facebook's
 * Messenger Platform callback automatically, using the delegation design
 * pattern.
 * 
 * @author Donato Rimenti
 * 
 */
public abstract class AutoReply extends FbBotMillBean {

	/**
	 * Method which defines the reply flow.
	 * 
	 * @param envelope
	 *            the current callback message
	 */
	public void reply(MessageEnvelope envelope) {
		FbBotMillResponse response = createResponse(envelope);
		if (response != null) {
			// If the response is valid, replies to it.
			if (validate(response)) {
				NetworkUtils.postJsonMessage(response);
			}
		}
	}

	/**
	 * Method which defines the response to send back as a response to the
	 * current message.
	 * 
	 * @param envelope
	 *            the current message.
	 * @return a {@link FbBotMillResponse} which contains the response to the
	 *         current message.
	 */
	public abstract FbBotMillResponse createResponse(MessageEnvelope envelope);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AutoReply []";
	}

}
