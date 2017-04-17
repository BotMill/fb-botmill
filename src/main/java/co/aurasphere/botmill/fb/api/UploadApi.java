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
package co.aurasphere.botmill.fb.api;

import co.aurasphere.botmill.fb.internal.util.network.FbBotMillNetworkController;
import co.aurasphere.botmill.fb.model.api.upload.UploadAttachmentResponse;
import co.aurasphere.botmill.fb.model.base.Attachment;
import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.outcoming.message.AttachmentMessage;
import co.aurasphere.botmill.fb.model.outcoming.message.FbBotMillMessageResponse;
import co.aurasphere.botmill.fb.model.outcoming.payload.AttachmentPayload;


/**
 * Class for handling the Facebook's Messenger Upload API.
 * 
 * @author Donato Rimenti
 * @since 2.0.0
 */
public class UploadApi {

	/**
	 * Instantiates a new UploadApi.
	 */
	private UploadApi() {
	}

	/**
	 * Method to upload an attachment to Facebook's server in order to use it
	 * later. Requires the pages_messaging permission.
	 * 
	 * @param attachmentType
	 *            the type of attachment to upload to Facebook. Please notice
	 *            that currently Facebook supports only image, audio, video and
	 *            file attachments.
	 * @param attachmentUrl
	 *            the URL of the attachment to upload to Facebook.
	 * @return nonexpiring ID for the attachment.
	 */
	public static UploadAttachmentResponse uploadAttachment(
			AttachmentType attachmentType, String attachmentUrl) {
		AttachmentPayload payload = new AttachmentPayload(attachmentUrl, true);
		Attachment attachment = new Attachment(attachmentType, payload);
		AttachmentMessage message = new AttachmentMessage(attachment);
		FbBotMillMessageResponse toSend = new FbBotMillMessageResponse(null, message);
		return FbBotMillNetworkController.postUploadAttachment(toSend);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillUploadApi []";
	}

}
