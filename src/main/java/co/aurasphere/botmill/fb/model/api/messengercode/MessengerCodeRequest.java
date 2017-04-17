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
package co.aurasphere.botmill.fb.model.api.messengercode;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import co.aurasphere.botmill.fb.api.MessengerCodeApi;

import com.google.gson.annotations.SerializedName;

/**
 * Request class for {@link MessengerCodeApi#getMessengerCode}.
 * 
 * @author Donato Rimenti
 * @since 2.0.0
 */
public class MessengerCodeRequest implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Must be "standard".
	 */
	@NotNull
	private MessengerCodeType type;

	/**
	 * The size, in pixels, for the image you are requesting. Supported range:
	 * 100-2000 px, defaults to 1000px.
	 */
	@Range(min = 100, max = 2000)
	@SerializedName("image_size")
	private int imageSize;

	/**
	 * Instantiates a new MessengerCodeRequest.
	 */
	public MessengerCodeRequest() {
		// Default imageSize.
		this.imageSize = 1000;
		this.type = MessengerCodeType.STANDARD;
	}

	/**
	 * Instantiates a new MessengerCodeRequest.
	 *
	 * @param imageSize
	 *            the {@link #imageSize}.
	 */
	public MessengerCodeRequest(int imageSize) {
		this();
		this.imageSize = imageSize;
	}

	/**
	 * Gets the {@link #type}.
	 *
	 * @return the {@link #type}.
	 */
	public MessengerCodeType getType() {
		return type;
	}

	/**
	 * Sets the {@link #type}.
	 *
	 * @param type
	 *            the {@link #type} to set.
	 */
	public void setType(MessengerCodeType type) {
		this.type = type;
	}

	/**
	 * Gets the {@link #imageSize}.
	 *
	 * @return the {@link #imageSize}.
	 */
	public int getImageSize() {
		return imageSize;
	}

	/**
	 * Sets the {@link #imageSize}.
	 *
	 * @param imageSize
	 *            the {@link #imageSize} to set.
	 */
	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
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
		result = prime * result + imageSize;
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
		MessengerCodeRequest other = (MessengerCodeRequest) obj;
		if (imageSize != other.imageSize)
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
		return "MessengerCodeRequest [imageSize=" + imageSize + "]";
	}

}
