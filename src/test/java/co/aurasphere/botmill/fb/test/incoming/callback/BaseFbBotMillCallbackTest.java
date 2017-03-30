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

import java.util.List;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.MessengerCallback;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.button.ButtonType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PostbackButton;


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

	/**
	 * Checks that an object is not null and an instance of class T.
	 *
	 * @param <T> the generic type
	 * @param object            the object to check.
	 * @param T            the expected type of T.
	 * @return a casted object of type T.
	 */
	@SuppressWarnings("unchecked")
	protected <T> T assertInstanceOf(Object object, Class<T> T) {
		Assert.assertNotNull(object);
		Assert.assertThat(object, IsInstanceOf.instanceOf(T));
		return (T) object;
	}

	/**
	 * Checks that a {@link PostbackButton} is well formed.
	 * 
	 * @param button
	 *            the button to check.
	 * @param title
	 *            the button title.
	 * @param payload
	 *            the button payload.
	 */
	protected void checkPostbackButtonWellFormed(Button button, String title,
			String payload) {
		PostbackButton pButton = assertInstanceOf(button, PostbackButton.class);
		Assert.assertEquals(ButtonType.POSTBACK, pButton.getType());
		Assert.assertEquals(title, pButton.getTitle());
		Assert.assertEquals(payload, pButton.getPayload());
	}

	/**
	 * Checks that a list is not null and has a fixed size.
	 *
	 * @param size the size of the list.
	 * @param list the list to check.
	 */
	@SuppressWarnings("rawtypes")
	protected void assertListOfSize(int size, List list) {
		Assert.assertNotNull(list);
		Assert.assertEquals(size, list.size());
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
