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
package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.base.User;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.support.FbBotMillMockMediator;

/**
 * Abstract class for a {@link FbBotMillResponseBuilder} that can be populated
 * with a mock recipient for testing.
 * 
 * @author Donato Rimenti
 * 
 */
public abstract class FbBotMillMockableBuilder extends FbBotMillResponseBuilder {

	/**
	 * Returns the recipient of the envelope. If
	 * {@link FbBotMillMockMediator#isMockEnabled()} evaluates to true returns a
	 * mock recipient with ID of
	 * {@link FbBotMillMockMediator#getFacebookMockId()} , otherwise gets the
	 * recipient as the sender of the received envelope to reply.
	 * 
	 * @param envelope
	 *            the incoming envelope.
	 * @return the recipient.
	 */
	protected User getRecipient(MessageEnvelope envelope) {
		if (FbBotMillMockMediator.isMockEnabled()) {
			return new User(FbBotMillMockMediator.getFacebookMockId());
		}
		return safeGetSender(envelope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.bean.FbBotMillBean#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillMockableBuilder []";
	}
}
