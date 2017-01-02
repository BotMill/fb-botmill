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
package co.aurasphere.botmill.fb.model.outcoming.message;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.base.Attachment;

/**
 * A {@link Message} which contains an {@link Attachment}.
 * 
 * @author Donato Rimenti
 * 
 */
public class AttachmentMessage extends Message {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The attachment associated with this message.
	 */
	@Valid
	@NotNull
	private Attachment attachment;

	/**
	 * Instantiates a new attachment message.
	 *
	 * @param attachment
	 *            the {@link #attachment}.
	 */
	public AttachmentMessage(Attachment attachment) {
		this.attachment = attachment;
	}

	/**
	 * Gets the {@link #attachment}.
	 *
	 * @return the {@link #attachment}.
	 */
	public Attachment getAttachment() {
		return attachment;
	}

	/**
	 * Sets the {@link #attachment}.
	 *
	 * @param attachment
	 *            the {@link #attachment} to set.
	 */
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

}
