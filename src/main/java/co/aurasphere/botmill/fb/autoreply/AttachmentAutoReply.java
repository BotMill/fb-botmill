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
package co.aurasphere.botmill.fb.autoreply;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.fb.exception.FbBotMillIllegalAttachmentException;
import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.factory.ReplyFactory;

/**
 * An {@link AutoReply} that replies with a file, video, image or audio
 * attachment.
 * 
 * @author Donato Rimenti
 * 
 */
public class AttachmentAutoReply extends AutoReply {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(AttachmentAutoReply.class);

	/**
	 * The attachment type. This can only be {@link AttachmentType#FILE},
	 * {@link AttachmentType#AUDIO}, {@link AttachmentType#IMAGE} or
	 * {@link AttachmentType#VIDEO}.
	 */
	private AttachmentType attachmentType;

	/**
	 * The URL pointing to the attachment.
	 */
	private String url;

	/**
	 * Instantiates a new attachment auto reply.
	 *
	 * @param attachmentType
	 *            the {@link #attachmentType}.
	 * @param url
	 *            the {@link #url}.
	 */
	public AttachmentAutoReply(AttachmentType attachmentType, String url) {
		this.attachmentType = attachmentType;
		this.url = url;
	}

	/**
	 * {@inheritDoc} Replies with an attachment.
	 */
	@Override
	public FbBotMillResponse createResponse(MessageEnvelope envelope) {
		FbBotMillResponse response = null;

		switch (attachmentType) {
		case FILE:
			response = ReplyFactory.addFileAttachment(url).build(envelope);
			break;
		case IMAGE:
			response = ReplyFactory.addImageAttachment(url).build(envelope);
			break;
		case AUDIO:
			response = ReplyFactory.addAudioAttachment(url).build(envelope);
			break;
		case VIDEO:
			response = ReplyFactory.addVideoAttachment(url).build(envelope);
			break;
		default:
			String message = "Illegal attachment of type [ " + attachmentType.name() + " ] for AttachmentAutoReply";
			logger.error(message);
			throw new FbBotMillIllegalAttachmentException(message);
		}
		return response;
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
		result = prime * result + ((attachmentType == null) ? 0 : attachmentType.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		AttachmentAutoReply other = (AttachmentAutoReply) obj;
		if (attachmentType != other.attachmentType)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
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
		return "AttachmentAutoReply [attachmentType=" + attachmentType + ", url=" + url + "]";
	}

}
