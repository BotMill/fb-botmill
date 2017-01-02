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

import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.action.TypingAction;
import co.aurasphere.botmill.fb.model.outcoming.factory.ReplyFactory;

/**
 * An {@link AutoReply} that replies with a {@link TypingAction}.
 * 
 * @author Donato Rimenti
 * 
 */
public class ActionAutoReply extends AutoReply {

	/**
	 * The {@link TypingAction} to perform.
	 */
	private TypingAction typingAction;

	/**
	 * Instantiates a new action auto reply.
	 *
	 * @param typingAction
	 *            the {@link #typingAction}.
	 */
	public ActionAutoReply(TypingAction typingAction) {
		this.typingAction = typingAction;
	}

	/**
	 * {@inheritDoc} Replies with a {@link TypingAction}.
	 */
	@Override
	public FbBotMillResponse createResponse(MessageEnvelope envelope) {
		return ReplyFactory.addTypingAction(this.typingAction).build(envelope);
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
		result = prime * result + ((typingAction == null) ? 0 : typingAction.hashCode());
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
		ActionAutoReply other = (ActionAutoReply) obj;
		if (typingAction != other.typingAction)
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
		return "ActionAutoReply [action=" + typingAction + "]";
	}

}
