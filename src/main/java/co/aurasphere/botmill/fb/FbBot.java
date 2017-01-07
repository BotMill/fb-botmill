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
package co.aurasphere.botmill.fb;

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.botmill.fb.actionframe.ActionFrame;
import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;

/**
 * Class that represents a FbBotMill bot. Each bot has a list of
 * {@link FbBotMillEvent}. An event is a callback from Facebook Messenger
 * Platform. There may be different events, according to what your app has
 * registered for (for more info check the link below). At each callback
 * received from Facebook, all registered bots callbacks handler are checked. If
 * any callback condition is verified, then the handleCallback method is called.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      > Facebook Messenger Platform callbacks</a>
 * 
 */
public class FbBot {

	/**
	 * A list of registered {@link FbBotMillEvent} for the current bot.
	 */
	private List<ActionFrame> actionFrameList;

	/**
	 * The policy this bot follows when processing the callback handler list.
	 */
	private FbBotMillPolicy fbBotMillPolicy;

	/**
	 * Instantiates a new FbBot with a default policy of
	 * {@link FbBotMillPolicy#FIRST_ONLY}.
	 */
	public FbBot() {
		this(FbBotMillPolicy.FIRST_ONLY);
	}

	/**
	 * Instantiates a new FbBot.
	 *
	 * @param fbBotMillPolicy
	 *            the {@link #fbBotMillPolicy}.
	 */
	public FbBot(FbBotMillPolicy fbBotMillPolicy) {
		if (fbBotMillPolicy == null) {
			fbBotMillPolicy = FbBotMillPolicy.FIRST_ONLY;
		}
		this.fbBotMillPolicy = fbBotMillPolicy;
		this.actionFrameList = new ArrayList<ActionFrame>();
		FbBotMillContext.getInstance().register(this);
	}

	/**
	 * Adds an {@link ActionFrame} to this bot.
	 * 
	 * @param actionFrame
	 *            the actionFrame to add.
	 */
	public void addActionFrame(ActionFrame actionFrame) {
		this.actionFrameList.add(actionFrame);
	}

	/**
	 * Adds an {@link ActionFrame} to this bot.
	 * 
	 * @param event
	 *            the {@link FbBotMillEvent} to handle.
	 * @param reply
	 *            the {@link AutoReply} which should handle the event.
	 */
	public void addActionFrame(FbBotMillEvent event, AutoReply reply) {
		ActionFrame frame = new ActionFrame(event, reply);
		this.actionFrameList.add(frame);
	}

	/**
	 * Adds an {@link ActionFrame} to this bot with multiple reply.
	 * 
	 * @param event
	 *            the {@link FbBotMillEvent} to handle.
	 * @param replies
	 *            the collection of {@link AutoReply} which should handle the
	 *            event.
	 */
	public void addActionFrame(FbBotMillEvent event, AutoReply... replies) {
		ActionFrame frame = new ActionFrame(event, replies);
		this.actionFrameList.add(frame);
	}

	/**
	 * Checks if there's any registered {@link FbBotMillEvent} for the incoming
	 * callback. If there's any, then the callback is handled. The chain will be
	 * processed according to the {@link FbBotMillPolicy} followed by this bot.
	 * If the policy is {@link FbBotMillPolicy#FIRST_ONLY}, the chain will be
	 * processed until the first callback matches. Otherwise, if the policy is
	 * {@link FbBotMillPolicy#PROCESS_ALL}, all the chain will always be
	 * processed.
	 * 
	 * @param envelope
	 *            the incoming message.
	 */
	public void processMessage(MessageEnvelope envelope) {
		for (ActionFrame f : this.actionFrameList) {
			// If the policy is FIRST_ONLY stop processing the chain at the
			// first trigger.
			if (f.getReplies() != null && f.getReplies().length > 0) {
				if (f.processMultipleReply(envelope) && this.fbBotMillPolicy.equals(FbBotMillPolicy.FIRST_ONLY)) {
					break;
				}
			} else {
				if (f.process(envelope) && this.fbBotMillPolicy.equals(FbBotMillPolicy.FIRST_ONLY)) {
					break;
				}
			}
		}
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
		result = prime * result + ((actionFrameList == null) ? 0 : actionFrameList.hashCode());
		result = prime * result + ((fbBotMillPolicy == null) ? 0 : fbBotMillPolicy.hashCode());
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
		FbBot other = (FbBot) obj;
		if (actionFrameList == null) {
			if (other.actionFrameList != null)
				return false;
		} else if (!actionFrameList.equals(other.actionFrameList))
			return false;
		if (fbBotMillPolicy != other.fbBotMillPolicy)
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
		return "FbBot [actionFrameList=" + actionFrameList + ", policy=" + fbBotMillPolicy + "]";
	}

}
