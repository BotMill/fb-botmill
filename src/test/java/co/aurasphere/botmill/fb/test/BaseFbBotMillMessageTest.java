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

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import co.aurasphere.botmill.fb.model.incoming.FacebookConfirmationMessage;

/**
 * Base class for testing every FbBotMill component that requires a user to send
 * a message to the bot.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public abstract class BaseFbBotMillMessageTest extends BaseFbBotMillNetworkTest {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.test.BaseFbBotMillTest#testImplementation()
	 */
	protected void testImplementation() throws Exception {
		// Retrieves the expected replies from the bot.
		String[] messagesToSend = getMessagesToSend();

		if (messagesToSend != null) {
			for (String message : messagesToSend) {
				logger.debug(
						"Testing the bot by sending message [{}] in test class [{}]",
						message, this.getClass().getSimpleName());
				this.mockMediator.sendTextMessage(message);
				Object response = monitor.get();

				Assert.assertNotNull(response);
				Assert.assertThat(response, CoreMatchers
						.instanceOf(FacebookConfirmationMessage.class));
			}
		}
	}

	/**
	 * Methods that returns the messages that needs to be sent to the bot in
	 * order to test it.
	 *
	 * @return an array of messages that needs to be sent to the bot in order to
	 *         test it.
	 */
	protected abstract String[] getMessagesToSend();

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.AbstractFbBot#toString()
	 */
	@Override
	public String toString() {
		return "BaseFbBotMillMessageTest [mockMediator=" + mockMediator
				+ ", monitor=" + monitor + ", mockId=" + mockId
				+ ", pageToken=" + pageToken + ", webhookToken=" + webhookToken
				+ ", fbBot=" + fbBot + "]";
	}
}
