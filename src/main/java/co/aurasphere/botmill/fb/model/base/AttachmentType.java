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
package co.aurasphere.botmill.fb.model.base;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for attachment types.
 * 
 * @author Donato Rimenti
 * 
 */
public enum AttachmentType implements Serializable {

	/**
	 * Image file attachment.
	 */
	@SerializedName("image") IMAGE,

	/**
	 * Audio file attachment.
	 */
	@SerializedName("audio") AUDIO,

	/**
	 * Video file attachment.
	 */
	@SerializedName("video") VIDEO,

	/**
	 * Generic file attachment.
	 */
	@SerializedName("file") FILE,

	/**
	 * Location object attachment.
	 */
	@SerializedName("location") LOCATION,

	/**
	 * Template attachment. Only used in replies.
	 */
	@SerializedName("template") TEMPLATE,

	/**
	 * Legacy attachment. This attachment type should not be used. Only used in
	 * incoming messages.
	 */
	@SerializedName("fallback") FALLBACK;
}
