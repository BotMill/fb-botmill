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
package co.aurasphere.botmill.fb.event.base;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;

/**
 * Base class for a {@link FbBotMillEvent} that triggers when an exact text is
 * matched, case sensitive or not.
 * 
 * @author Donato Rimenti
 */
public abstract class BaseStringEvent extends FbBotMillBean implements
		FbBotMillEvent {

	/**
	 * The text to be matched in order to trigger this event.
	 */
	protected String expectedString;

	/**
	 * Whether the match should be case sensitive or not.
	 */
	protected boolean caseSensitive;

	/**
	 * Instantiates a new BaseStringEvent.
	 *
	 * @param expectedString
	 *            the {@link #expectedString}.
	 * @param caseSensitive
	 *            the {@link #caseSensitive}.
	 */
	public BaseStringEvent(String expectedString, boolean caseSensitive) {
		if (caseSensitive == false && expectedString != null) {
			this.expectedString = expectedString.toLowerCase();
		}
		this.caseSensitive = caseSensitive;
	}

	/**
	 * Instantiates a new BaseStringEvent.
	 *
	 * @param expectedString
	 *            the {@link #expectedString}.
	 */
	public BaseStringEvent(String expectedString) {
		this.expectedString = expectedString;
		this.caseSensitive = true;
	}

	/**
	 * Verify string match.
	 *
	 * @param text
	 *            the string used to check if it matches the event string.
	 * @return true, if successful
	 */
	protected boolean verifyStringMatch(String text) {
		if (text == null) {
			return false;
		}
		if (!this.caseSensitive) {
			text = text.toLowerCase();
		}
		return text.equals(this.expectedString);
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
		result = prime * result + (caseSensitive ? 1231 : 1237);
		result = prime * result
				+ ((expectedString == null) ? 0 : expectedString.hashCode());
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
		BaseStringEvent other = (BaseStringEvent) obj;
		if (caseSensitive != other.caseSensitive)
			return false;
		if (expectedString == null) {
			if (other.expectedString != null)
				return false;
		} else if (!expectedString.equals(other.expectedString))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.bean.FbBotMillBean#toString()
	 */
	@Override
	public String toString() {
		return "BaseStringEvent [expectedString=" + expectedString
				+ ", caseSensitive=" + caseSensitive + "]";
	}
}
