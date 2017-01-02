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
package co.aurasphere.botmill.fb.model.outcoming.quickreply;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.annotations.SerializedName;

/**
 * The Class QuickReply.
 */
public class QuickReply implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The content type. */
	@NotNull
	@SerializedName("content_type")
	private QuickReplyType contentType;

	/** The image url. */
	@SerializedName("image_url")
	private String imageUrl;

	/** The title. */
	@Size(max = 20)
	@NotBlank
	private String title;

	/** The payload. */
	@Size(max = 1000)
	private String payload;

	/**
	 * Instantiates a new quick reply.
	 *
	 * @param title
	 *            the title of the quick reply payload
	 * @param payload
	 *            the payload itself
	 */
	public QuickReply(String title, String payload) {
		this.contentType = QuickReplyType.TEXT;
		this.title = title;
		this.payload = payload;
	}

	/**
	 * Instantiates a new quick reply with the following parameters.
	 * 
	 * @param title
	 *            the title of the quick reply payload
	 * @param payload
	 *            the payload itself
	 * @param imageUrl
	 *            the url of the image that needs to be shown along within this
	 *            quick reply
	 */
	public QuickReply(String title, String payload, String imageUrl) {
		this.contentType = QuickReplyType.TEXT;
		this.title = title;
		this.payload = payload;
		this.imageUrl = imageUrl;
	}

	/**
	 * Instantiates a new location quick reply.
	 * 
	 * @param locationMessage
	 *            the location text
	 */
	public QuickReply(String locationMessage) {
		this.contentType = QuickReplyType.LOCATION;
		this.title = locationMessage;
	}

	/**
	 * Gets the payload.
	 *
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * Sets the payload.
	 *
	 * @param payload
	 *            the new payload
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public QuickReplyType getContentType() {
		return contentType;
	}

	/**
	 * Sets the content type.
	 *
	 * @param contentType
	 *            the new content type
	 */
	public void setContentType(QuickReplyType contentType) {
		this.contentType = contentType;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the image url.
	 *
	 * @return the image url
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Sets the image url.
	 *
	 * @param imageUrl
	 *            the new image url
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
