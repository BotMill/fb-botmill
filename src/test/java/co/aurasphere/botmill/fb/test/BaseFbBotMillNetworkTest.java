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
package co.aurasphere.botmill.fb.test;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.fb.AbstractFbBot;
import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.support.FbBotMillMockMediator;

/**
 * Base class for testing every FbBotMill component that requires Facebook
 * communication.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public abstract class BaseFbBotMillNetworkTest extends AbstractFbBot {

	/**
	 * The logger.
	 */
	protected static final Logger logger = LoggerFactory
			.getLogger(BaseFbBotMillNetworkTest.class);

	/**
	 * The name of the environment property for the Facebook's app-scoped user
	 * ID used as a recipient for the bot.
	 */
	protected static final String FB_BOTMILL_MOCK_ID_PROPERTY = "MOCK_FACEBOOK_ID";

	/**
	 * The name of the environment property for the Facebook's page token.
	 */
	protected static final String FB_BOTMILL_PAGE_TOKEN_PROPERTY = "PAGE_TOKEN";

	/**
	 * The name of the environment property for the Facebook's Messenger
	 * Platform Webhook validation token.
	 */
	protected static final String FB_BOTMILL_WEBHOOK_TOKEN_PROPERTY = "VALIDATION_TOKEN";

	/**
	 * A global variable used to skip all the tests.
	 */
	protected static boolean skipAllTests = false;

	/**
	 * The mock mediator instance used to send messages.
	 */
	protected FbBotMillMockMediator mockMediator;

	/**
	 * A custom monitor used to check if there was any error in the request.
	 */
	protected FbBotMillTestMonitor monitor;

	/**
	 * An app-scoped Facebook's user ID used as a message recipient for the bot.
	 */
	protected String mockId;

	/**
	 * The Facebook's page token.
	 */
	protected String pageToken;

	/**
	 * The Facebook's Messenger Platform Webhook validation token.
	 */
	protected String webhookToken;

	/**
	 * Method that sets up the testing envirnoment. It gets the Facebook
	 * parameters needed through environment variables with values
	 * {@value #FB_BOTMILL_MOCK_ID_PROPERTY},
	 * {@value #FB_BOTMILL_PAGE_TOKEN_PROPERTY} and
	 * {@value #FB_BOTMILL_WEBHOOK_TOKEN_PROPERTY}. If any of these environment
	 * variables is missing, then all the tests are skipping. This is done in
	 * order to prevent the test failures due to the lack of this variables to
	 * prevent user builds.
	 */
	@Before
	public void setup() {
		// If the tests are already being skipped, no need to check the
		// properties.
		if (skipAllTests) {
			return;
		}

		mockId = System.getenv(FB_BOTMILL_MOCK_ID_PROPERTY);
		pageToken = System.getenv(FB_BOTMILL_PAGE_TOKEN_PROPERTY);
		webhookToken = System.getenv(FB_BOTMILL_WEBHOOK_TOKEN_PROPERTY);

		// If one or more properties are null, the tests will be skipped.
		if (isEmpty(mockId) || isEmpty(pageToken) || isEmpty(webhookToken)) {
			logger.warn(
					"One of the testing environment variables is missing. Tests will be skipped. Variables missing: [{}={}], [{}={}], [{}={}].",
					FB_BOTMILL_MOCK_ID_PROPERTY, isEmpty(mockId),
					FB_BOTMILL_PAGE_TOKEN_PROPERTY, isEmpty(pageToken),
					FB_BOTMILL_WEBHOOK_TOKEN_PROPERTY, isEmpty(webhookToken));
			skipAllTests = true;
		} else if (this.mockMediator == null) {
			FbBotMillContext.getInstance().setup(pageToken, webhookToken);
			this.mockMediator = FbBotMillMockMediator.getInstance(mockId, this);
			monitor = new FbBotMillTestMonitor();
			FbBotMillContext.getInstance().registerMonitor(monitor);
		}
	}

	/**
	 * Main test method. It checks whether the tests are being globally or
	 * locally skipped and if not it then delegates the current class
	 * implementation of the method {@link #testImplementation()}.
	 * 
	 * @throws Exception
	 *             a generic exception.
	 */
	@Test
	public void test() throws Exception {
		Assume.assumeFalse(skipAllTests);
		Assume.assumeFalse(skipTest());
		testImplementation();
	}

	/**
	 * Method which defines if this test should be skipped.
	 * 
	 * @return true if this test should be skipped, false otherwise.
	 */
	protected abstract boolean skipTest();

	/**
	 * Method which defines the test logic.
	 * 
	 * @throws Exception
	 *             a generic exception.
	 */
	protected abstract void testImplementation() throws Exception;

	/**
	 * Utility method used to check if a String is null or empty.
	 * 
	 * @param string
	 *            the String to check.
	 * @return true if the String is null or empty, false otherwise.
	 */
	private static boolean isEmpty(String string) {
		return string == null || string.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.AbstractFbBot#toString()
	 */
	@Override
	public String toString() {
		return "BaseFbBotMillNetworkTest [mockMediator=" + mockMediator
				+ ", monitor=" + monitor + ", mockId=" + mockId
				+ ", pageToken=" + pageToken + ", webhookToken=" + webhookToken
				+ ", fbBot=" + fbBot + "]";
	}
}
