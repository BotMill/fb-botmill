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
package co.aurasphere.botmill.fb.event.postback;

import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.base.BaseStringEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;

/**
 * An {@link FbBotMillEvent} that triggers whenever the users sends a a payload
 * back by pressing a button or similar that matches an exact String.
 * 
 * @author Donato Rimenti
 * 
 */
public class PostbackEvent extends BaseStringEvent {

	/**
	 * Instantiates a new PostbackEvent.
	 *
	 * @param expectedPayload
	 *            the {@link BaseStringEvent#expectedString}.
	 * @param caseSensitive
	 *            the {@link BaseStringEvent#caseSensitive}.
	 */
	public PostbackEvent(String expectedPayload, boolean caseSensitive) {
		super(expectedPayload, caseSensitive);
	}

	/**
	 * Instantiates a new PostbackEvent.
	 *
	 * @param expectedPayload
	 *            the {@link BaseStringEvent#expectedString}.
	 */
	public PostbackEvent(String expectedPayload) {
		super(expectedPayload);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.event.FbBotMillEvent#verifyEventCondition(co.
	 * aurasphere.botmill.fb.model.incoming.MessageEnvelope)
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String payload = safeGetPostbackPayload(envelope);
		return verifyStringMatch(payload);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.event.base.BaseStringEvent#toString()
	 */
	@Override
	public String toString() {
		return "PostbackEvent [expectedString=" + expectedString
				+ ", caseSensitive=" + caseSensitive + "]";
	}

}
