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
package co.aurasphere.botmill.fb.test.upload;

import org.springframework.util.Assert;

import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.upload.UploadAttachmentResponse;
import co.aurasphere.botmill.fb.test.BaseFbBotMillMessageTest;
import co.aurasphere.botmill.fb.test.BaseFbBotMillNetworkTest;
import co.aurasphere.botmill.fb.upload.FbBotMillUploadApi;

/**
 * Test for the {@link FbBotMillUploadApi} class.
 * 
 * @author Donato Rimenti
 * @since 2.0.0
 */
public class UploadApiTest extends BaseFbBotMillNetworkTest {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.test.BaseFbBotMillNetworkTest#skipTest()
	 */
	@Override
	protected boolean skipTest() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.test.BaseFbBotMillNetworkTest#testImplementation
	 * ()
	 */
	@Override
	protected void testImplementation() throws Exception {
		UploadAttachmentResponse response = FbBotMillUploadApi
				.uploadAttachment(
						AttachmentType.IMAGE,
						"http://vignette2.wikia.nocookie.net/nickelodeon/images/2/27/Spongebob_PNG.png/revision/latest?cb=20120702055752");
		String attachmentId = response.getAttachmentId();
		Assert.notNull(attachmentId);
		logger.info("Succesfully posted attachment with Upload Api (ID: [{}])", attachmentId);
	}

}
