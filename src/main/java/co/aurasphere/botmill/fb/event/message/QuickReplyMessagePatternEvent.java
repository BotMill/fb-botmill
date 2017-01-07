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

import java.util.regex.Pattern;

import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.event.base.BasePatternEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;

/**
 * An {@link FbBotMillEvent} that processes all the incoming callbacks that
 * contains a text message which matches against a defined pattern from
 * Facebook's Messenger Platform.
 * 
 * @author Alvin Reyes
 */
public class QuickReplyMessagePatternEvent extends BasePatternEvent {

	/**
	 * Instantiates a new quick reply message event pattern.
	 *
	 * @param expectedPattern
	 *            the expected pattern
	 * @see BasePatternEvent#BasePatternEvent(Pattern)
	 */
	public QuickReplyMessagePatternEvent(Pattern expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * Instantiates a new quick reply message event pattern.
	 *
	 * @param expectedPattern
	 *            the expected pattern
	 * @see BasePatternEvent#BasePatternEvent(String)
	 */
	public QuickReplyMessagePatternEvent(String expectedPattern) {
		super(expectedPattern);
	}

	/**
	 * Verify event condition.
	 *
	 * @param envelope
	 *            the envelope
	 * @return true if the text message received from the callback matches the
	 *         expected pattern, false otherwise.
	 */
	public final boolean verifyEventCondition(MessageEnvelope envelope) {
		String message = safeGetQuickReplyPayload(envelope);
		return expectedPattern.matcher(message).matches();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.event.base.BasePatternEvent#toString()
	 */
	@Override
	public String toString() {
		return "QuickReplyMessagePatternEvent [expectedPattern="
				+ expectedPattern + "]";
	}
}
