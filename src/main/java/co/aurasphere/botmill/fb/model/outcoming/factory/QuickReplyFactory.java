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

import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;

/**
 * Factory class for building {@link QuickReply} objects.
 * 
 * @author Alvin Reyes
 */
public class QuickReplyFactory {

	/**
	 * Instantiates a new QuickReplyFactory.
	 */
	private QuickReplyFactory() {
	}

	/**
	 * Creates a {@link QuickReply}.
	 * 
	 * @param title
	 *            the {@link QuickReply#title}.
	 * @param payload
	 *            the {@link QuickReply#payload}.
	 * @return a {@link QuickReply} object.
	 */
	public static QuickReply createQuickReply(String title, String payload) {
		return new QuickReply(title, payload);
	}

	/**
	 * Creates a {@link QuickReply} with a location.
	 * 
	 * @param location
	 *            the {@link QuickReply#title}.
	 * @return a {@link QuickReply} object.
	 */
	public static QuickReply createQuickReplyLocation(String location) {
		return new QuickReply(location);
	}

	/**
	 * Creates a {@link QuickReply} with a location.
	 * 
	 * @param title
	 *            the {@link QuickReply#title}.
	 * @param payload
	 *            the {@link QuickReply#payload}.
	 * @param imageUrl
	 *            the {@link QuickReply#imageUrl}.
	 * @return a {@link QuickReply} object.
	 */
	public static QuickReply createQuickReplyLocation(String title,
			String payload, String imageUrl) {
		return new QuickReply(title, payload, imageUrl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuickReplyFactory []";
	}

}
