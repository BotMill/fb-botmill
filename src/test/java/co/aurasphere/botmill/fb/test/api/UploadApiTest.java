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
package co.aurasphere.botmill.fb.test.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import co.aurasphere.botmill.core.internal.util.ConfigurationUtils;
import co.aurasphere.botmill.fb.api.UploadApi;
import co.aurasphere.botmill.fb.model.api.UploadAttachmentResponse;
import co.aurasphere.botmill.fb.model.base.AttachmentType;


/**
 * Test for the {@link UploadApi} class.
 * 
 * @author Donato Rimenti
 * @since 2.0.0
 */
public class UploadApiTest {
	
	private final static Logger logger = LoggerFactory.getLogger(UploadApiTest.class);
	
//	@Before
	public void setup() {
		ConfigurationUtils.loadEncryptedConfigurationProperties(); // loads the annotated encryption class.
		ConfigurationUtils.loadBotDefinitions(); // loads the annotated bot.
	}

//	@Test
	public void test() {
		UploadAttachmentResponse response = UploadApi
				.uploadAttachment(
						AttachmentType.IMAGE,
						"http://vignette2.wikia.nocookie.net/nickelodeon/images/2/27/Spongebob_PNG.png/revision/latest?cb=20120702055752");
		String attachmentId = response.getAttachmentId();
		Assert.notNull(attachmentId);
		logger.info("Succesfully posted attachment with Upload Api (ID: [{}])", attachmentId);
	}

}
