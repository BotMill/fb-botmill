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
package co.aurasphere.botmill.fb.test.incoming.callback;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.MessengerCallback;

/**
 * Base class for testing every FbBotMill callback.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public class BaseFbBotMillCallbackTest {

	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(BaseFbBotMillCallbackTest.class);

	/**
	 * Logs the testing class.
	 */
	@Before
	public void before() {
		logger.info("Starting unit tests in class [{}].", this.getClass()
				.getSimpleName());
	}

	/**
	 * Logs the testing class.
	 */
	@After
	public void after() {
		logger.info("Completed unit tests for class [{}].", this.getClass()
				.getSimpleName());
	}

	/**
	 * Checks that each callback field for the common format is not null.
	 * 
	 * @param callback
	 *            the callback to check.
	 * @return the {@link MessageEnvelope} of this callback.
	 */
	protected MessageEnvelope checkCallbackWellFormed(MessengerCallback callback) {
		Assert.assertNotNull(callback);
		Assert.assertNotNull(callback.getObject());
		Assert.assertNotNull(callback.getEntry());
		Assert.assertNotNull(callback.getEntry().get(0));
		Assert.assertNotNull(callback.getEntry().get(0).getId());
		Assert.assertNotNull(callback.getEntry().get(0).getTime());
		Assert.assertNotNull(callback.getEntry().get(0).getMessaging());
		Assert.assertNotNull(callback.getEntry().get(0).getMessaging().get(0));
		Assert.assertNotNull(callback.getEntry().get(0).getMessaging().get(0));

		return callback.getEntry().get(0).getMessaging().get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseFbBotMillCallbackTest []";
	}

}
