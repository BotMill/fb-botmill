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
package co.aurasphere.botmill.fb.model.outcoming.payload;

import co.aurasphere.botmill.fb.model.base.Attachment;
import co.aurasphere.botmill.fb.model.base.Payload;

import com.google.gson.annotations.SerializedName;

/**
 * A {@link Payload} used for an {@link Attachment}.
 * 
 * @author Donato Rimenti
 * @since 2.0.0
 */
public class AttachmentPayload extends UrlPayload {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/** The attachment id. */
	@SerializedName("attachment_id")
	private String attachmentId;

	/**
	 * Flag that indicates whether this attachment can be reused. Used only with
	 * Facebook's Messenger Upload API.
	 */
	@SerializedName("is_reusable")
	private boolean isReusable;

	
	public AttachmentPayload() {
	}
	
	/**
	 * Instantiates a new AttachmentPayload.
	 *
	 * @param url
	 *            the {@link UrlPayload#url}.
	 */
	public AttachmentPayload(String url) {
		super(url);
	}

	/**
	 * Instantiates a new AttachmentPayload.
	 *
	 * @param url
	 *            the {@link UrlPayload#url}.
	 * @param isReusable
	 *            the {@link #isReusable}.
	 */
	public AttachmentPayload(String url, boolean isReusable) {
		super(url);
		this.isReusable = isReusable;
	}

	/**
	 * Gets the {@link #isReusable}.
	 *
	 * @return the {@link #isReusable}.
	 */
	public boolean isReusable() {
		return isReusable;
	}

	/**
	 * Sets the {@link #isReusable}.
	 *
	 * @param isReusable
	 *            the {@link #isReusable} to set.
	 */
	public void setReusable(boolean isReusable) {
		this.isReusable = isReusable;
	}
	
	

	/**
	 * Gets the attachment id.
	 *
	 * @return the attachment id
	 */
	public String getAttachmentId() {
		return attachmentId;
	}

	/**
	 * Sets the attachment id.
	 *
	 * @param attachmentId the new attachment id
	 */
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.payload.UrlPayload#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isReusable ? 1231 : 1237);
		return result;
	}
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.payload.UrlPayload#equals(java
	 * .lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttachmentPayload other = (AttachmentPayload) obj;
		if (isReusable != other.isReusable)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.model.outcoming.payload.UrlPayload#toString()
	 */
	@Override
	public String toString() {
		return "AttachmentPayload [isReusable=" + isReusable + "]";
	}

}