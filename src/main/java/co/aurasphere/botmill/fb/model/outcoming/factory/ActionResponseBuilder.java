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
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.action.FbBotMillActionResponse;
import co.aurasphere.botmill.fb.model.outcoming.action.TypingAction;

/**
 * A builder for a response which contains and performs a {@link TypingAction}.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/send-api-reference/sender-actions"
 *      > Facebook's Messenger Platform Sender Actions Documentation</a>
 * 
 */
public class ActionResponseBuilder extends FbBotMillMockableBuilder {

	/**
	 * The action to perform.
	 */
	private TypingAction action;

	/**
	 * Instantiates a new action response builder.
	 *
	 * @param action
	 *            the {@link #action}.
	 */
	ActionResponseBuilder(TypingAction action) {
		this.action = action;
	}

	/**
	 * {@inheritDoc} It returns a {@link FbBotMillActionResponse} with the
	 * {@link TypingAction} to perform.
	 */
	public FbBotMillResponse build(MessageEnvelope envelope) {
		User recipient = getRecipient(envelope);
		return new FbBotMillActionResponse(recipient, action);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.bean.FbBotMillBean#toString()
	 */
	@Override
	public String toString() {
		return "ActionResponseBuilder [action=" + action + "]";
	}

}
