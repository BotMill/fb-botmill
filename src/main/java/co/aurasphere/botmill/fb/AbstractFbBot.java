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

import co.aurasphere.botmill.fb.actionframe.ActionFrame;
import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;

/**
 * Base {@link FbBotDefinition} implementation that takes care of the
 * {@link FbBot} handling.
 * 
 * @author Donato Rimenti
 * 
 */
public abstract class AbstractFbBot implements FbBotDefinition {

	/**
	 * The {@link FbBot} object handled by this class.
	 */
	protected FbBot fbBot;

	/**
	 * Base constructor. Instantiates a {@link FbBot} and registers it to the
	 * context.
	 */
	public AbstractFbBot() {
		this.fbBot = new FbBot();
	}

	/**
	 * Adds an {@link ActionFrame} to the current bot.
	 * 
	 * @param actionFrame
	 *            the ActionFrame to add.
	 */
	protected void addActionFrame(ActionFrame actionFrame) {
		fbBot.addActionFrame(actionFrame);
	}

	/**
	 * Adds an {@link ActionFrame} to the current bot.
	 * 
	 * @param event
	 *            the {@link FbBotMillEvent} that triggers the ActionFrame.
	 * @param reply
	 *            the {@link AutoReply} to return when the event is triggered.
	 */
	protected void addActionFrame(FbBotMillEvent event, AutoReply reply) {
		fbBot.addActionFrame(event, reply);
	}

	/**
	 * Adds an {@link ActionFrame} to the current bot.
	 * 
	 * @param event
	 *            the {@link FbBotMillEvent} that triggers the ActionFrame.
	 * @param replies
	 *            the list of {@link AutoReply} to return when the event is
	 *            triggered.
	 */
	protected void addActionFrame(FbBotMillEvent event, AutoReply... replies) {
		fbBot.addActionFrame(event, replies);
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
		result = prime * result + ((fbBot == null) ? 0 : fbBot.hashCode());
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
		AbstractFbBot other = (AbstractFbBot) obj;
		if (fbBot == null) {
			if (other.fbBot != null)
				return false;
		} else if (!fbBot.equals(other.fbBot))
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
		return "AbstractFbBot [fbBot=" + fbBot + "]";
	}

}
