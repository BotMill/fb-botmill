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
package co.aurasphere.botmill.fb.internal.util.validation;

/**
 * Utility class that contains the constants used for FbBotMill internal
 * validations.
 * 
 * @author Donato Rimenti
 */
public class FbBotMillValidationConstants {

	/**
	 * Instantiates a new FbBotMillValidationConstants.
	 */
	// TODO: fix javadoc
	private FbBotMillValidationConstants() {
	}

	/** The Constant BUTTON_TITLE_MAX_LENGTH. */
	public static final int BUTTON_TITLE_MAX_LENGTH = 20;

	/** The Constant PAYLOAD_MAX_LENGTH. */
	public static final int PAYLOAD_MAX_LENGTH = 1000;

	/** The Constant QUICK_REPLY_MAX_ELEMENTS. */
	public static final int QUICK_REPLY_MAX_ELEMENTS = 10;

	/** The Constant MESSAGE_MAX_LENGTH. */
	public static final int MESSAGE_MAX_LENGTH = 320;

	/** The Constant BUTTONS_MAX_ELEMENTS. */
	public static final int BUTTONS_MAX_ELEMENTS = 3;

	/** The Constant GENERIC_TEMPLATE_MAX_ELEMENTS. */
	public static final int GENERIC_TEMPLATE_MAX_ELEMENTS = 10;

	/** The Constant GENERIC_TEMPLATE_TITLE_MAX_LENGHT. */
	public static final int GENERIC_TEMPLATE_TITLE_MAX_LENGHT = 80;

	/** The Constant GENERIC_TEMPLATE_SUBTITLE_MAX_LENGHT. */
	public static final int GENERIC_TEMPLATE_SUBTITLE_MAX_LENGHT = 80;

	/** The Constant GREETING_TEXT_MAX_LENGTH. */
	public static final int GREETING_TEXT_MAX_LENGTH = 160;

	/** The Constant PERSISTENT_BUTTONS_MAX_ELEMENTS. */
	public static final int PERSISTENT_BUTTONS_MAX_ELEMENTS = 5;

	/** The Constant PERSISTENT_BUTTON_TITLE_MAX_LENGTH. */
	public static final int PERSISTENT_BUTTON_TITLE_MAX_LENGTH = 30;

	public static final int LIST_TEMPLATE_MAX_BUTTONS = 1;

	public static final int LIST_TEMPLATE_MAX_ELEMENTS = 4;

	public static final int LIST_TEMPLATE_MIN_ELEMENTS = 2;

	/**
	 * Thread Settings max length of buttons lists.
	 */
	public static final int THREAD_SETTINGS_BUTTONS_MAX_ELEMENTS = 5;

	/**
	 * Thread Settings max length of greeting text message.
	 */
	public static final int THREAD_SETTINGS_GREETING_MESSAGE_MAX_LENGTH = 160;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillValidationConstants []";
	}

}
