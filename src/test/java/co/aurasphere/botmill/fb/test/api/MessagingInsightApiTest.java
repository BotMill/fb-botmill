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
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.core.internal.util.ConfigurationUtils;
import co.aurasphere.botmill.fb.api.MessagingInsightApi;
import co.aurasphere.botmill.fb.model.api.messaginginsight.DailyUniqueActiveThreadCounts;
import co.aurasphere.botmill.fb.model.api.messaginginsight.DailyUniqueConversationCounts;

/**
 * Test for {@link MessagingInsightApi}.
 * 
 * @author Donato Rimenti
 * @since 2.0.0
 */
public class MessagingInsightApiTest {

	/**
	 * The logger.
	 */
	private final static Logger logger = LoggerFactory
			.getLogger(MessagingInsightApiTest.class);
	
	/**
	 * Setup the tests.
	 */
	@Before
	public void setup() {
		ConfigurationUtils.loadEncryptedConfigurationProperties(); // loads the annotated encryption class.
		ConfigurationUtils.loadBotDefinitions(); // loads the annotated bot.
	}

	/**
	 * Tests the {@link MessagingInsightApi#getDailyUniqueActiveThreadCounts()}
	 * method.
	 */
//	@Test
	public void testGetDailyUniqueActiveThreadCounts() {
		DailyUniqueActiveThreadCounts response = MessagingInsightApi
				.getDailyUniqueActiveThreadCounts();
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getData());
		logger.info(
				"Succesfully got daily unique active thread counts. Response : {}",
				response);
	}

	/**
	 * Tests the {@link MessagingInsightApi#getDailyUniqueConversationCounts()}
	 * method.
	 */
//	@Test
	public void testGetDailyUniqueConversationCounts() {
		DailyUniqueConversationCounts response = MessagingInsightApi
				.getDailyUniqueConversationCounts();
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getData());
		logger.info(
				"Succesfully got daily unique conversation counts. Response : {}",
				response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessagingInsightApiTest []";
	}

}
