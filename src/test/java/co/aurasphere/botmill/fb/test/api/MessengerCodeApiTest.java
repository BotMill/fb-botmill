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

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.api.MessengerCodeApi;
import co.aurasphere.botmill.fb.model.api.messengercode.MessengerCode;
import co.aurasphere.botmill.fb.model.api.messengercode.MessengerCodeRequest;

/**
 * Test for the {@link MessengerCodeApi} class.
 * 
 * @author Donato Rimenti
 * @since 2.0.0
 */
public class MessengerCodeApiTest {
	
	private final static Logger logger = LoggerFactory.getLogger(MessengerCodeApiTest.class);
	
	@Before
	public void setup() {
		Assume.assumeTrue(isConfigurationExist());
		FbBotMillContext.getInstance().setup(System.getenv("fb.page.token"), System.getenv("fb.validation.token"));
	}

	@Test
	public void testMessengerCodeApi() {
		
		MessengerCode response = MessengerCodeApi.getMessengerCode();
		checkResponse(response);
		
		// Tests different cases.
		response = MessengerCodeApi.getMessengerCode(100);
		checkResponse(response);
		
		response = MessengerCodeApi.getMessengerCode(1000);
		checkResponse(response);
		
		response = MessengerCodeApi.getMessengerCode(new MessengerCodeRequest(2000));
		checkResponse(response);
	
	}
	
	private boolean isConfigurationExist() {
		if(System.getenv("fb.page.token") != null && System.getenv("fb.validation.token") != null) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if the response is valid.
	 * 
	 * @param response
	 *            the MessengerCode to check.
	 */
	private void checkResponse(MessengerCode response) {
		Assert.assertNotNull(response);
		String uri = response.getUri();
		Assert.assertNotNull(uri);
		Assert.assertNotEquals("", uri);
		logger.info(
				"Succesfully got a Messenger code from Facebook (uri: [{}])",
				uri);
	}
}
