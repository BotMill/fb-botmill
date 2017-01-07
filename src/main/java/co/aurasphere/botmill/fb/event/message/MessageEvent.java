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
package co.aurasphere.botmill.fb.event.message;

import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.base.BaseStringEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;

/**
 * An {@link FbBotMillEvent} that triggers whenever the users sends a text
 * message that matches an exact String.
 * 
 * @author Donato Rimenti
 */
public class MessageEvent extends BaseStringEvent {

	/**
	 * Instantiates a new MessageEvent.
	 *
	 * @param expectedMessage
	 *            the {@link BaseStringEvent#expectedString}.
	 * @param caseSensitive
	 *            the {@link BaseStringEvent#caseSensitive}.
	 */
	public MessageEvent(String expectedMessage, boolean caseSensitive) {
		super(expectedMessage, caseSensitive);
	}

	/**
	 * Instantiates a new MessageEvent.
	 *
	 * @param expectedMessage
	 *            the {@link BaseStringEvent#expectedString}.
	 */
	public MessageEvent(String expectedMessage) {
		super(expectedMessage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.event.FbBotMillEvent#verifyEventCondition(co.
	 * aurasphere.botmill.fb.model.incoming.MessageEnvelope)
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String message = safeGetMessage(envelope);
		return verifyStringMatch(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.event.base.BaseStringEvent#toString()
	 */
	@Override
	public String toString() {
		return "MessageEvent [expectedString=" + expectedString
				+ ", caseSensitive=" + caseSensitive + "]";
	}

}
