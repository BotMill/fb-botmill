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

import java.util.regex.Pattern;

import co.aurasphere.botmill.fb.bean.FbBotMillBean;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;

/**
 * Base class for a {@link FbBotMillEvent} that triggers when a pattern is
 * matched.
 * 
 * @author Donato Rimenti
 * 
 */
public abstract class BasePatternEvent extends FbBotMillBean implements
		FbBotMillEvent {

	/**
	 * The expected pattern to match in order to trigger this event.
	 */
	public Pattern expectedPattern;

	/**
	 * Instantiates a new BasePatternEvent.
	 *
	 * @param expectedPattern
	 *            the {@link #expectedPattern}.
	 */
	protected BasePatternEvent(Pattern expectedPattern) {
		this.expectedPattern = expectedPattern;
	}

	/**
	 * Instantiates a new BasePatternEvent.
	 *
	 * @param expectedPattern
	 *            the {@link #expectedPattern}.
	 */
	protected BasePatternEvent(String expectedPattern) {
		this.expectedPattern = Pattern.compile(expectedPattern);
	}

	/**
	 * Verify pattern match.
	 *
	 * @param text
	 *            the string that we match against the {@link #expectedPattern}
	 *            object.
	 * @return true, if successful
	 */
	protected boolean verifyPatternMatch(String text) {
		if (this.expectedPattern == null) {
			return false;
		}
		return this.expectedPattern.matcher(text).matches();
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
		result = prime * result
				+ ((expectedPattern == null) ? 0 : expectedPattern.hashCode());
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
		BasePatternEvent other = (BasePatternEvent) obj;
		if (expectedPattern == null) {
			if (other.expectedPattern != null)
				return false;
		} else if (!expectedPattern.equals(other.expectedPattern))
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
		return "BasePatternEvent [expectedPattern=" + expectedPattern + "]";
	}

}
