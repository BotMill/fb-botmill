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
package co.aurasphere.botmill.fb.test.autoreply;

import co.aurasphere.botmill.core.annotation.Bot;
import co.aurasphere.botmill.fb.FbBot;
import co.aurasphere.botmill.fb.autoreply.LambdaAutoReply;
import co.aurasphere.botmill.fb.autoreply.Reply;
import co.aurasphere.botmill.fb.event.message.MessageEvent;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.model.outcoming.factory.ReplyFactory;


/**
 * Test for a {@link LambdaAutoReply}.
 * 
 * @author Donato Rimenti
 * @author Alvin Reyes
 */
@Bot
public class LambdaAutoReplyTest extends FbBot {
	
	/**
	 * The message to send in order to test this component.
	 */
	private static final String MESSAGE_TO_SEND = "test_lambda_auto_reply";
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.FbBotDefinition#defineBehaviour()
	 */
	@Override
	public void defineBehaviour() {
		
		// This cannot be tested with a real lambda since the project is
		// compiled in 1.5, but this test is equivalent.
		addActionFrame(new MessageEvent(MESSAGE_TO_SEND), new LambdaAutoReply(
				new Reply() {
					public FbBotMillResponse createResponse(
							MessageEnvelope envelope) {
						return ReplyFactory.addTextMessageOnly(MESSAGE_TO_SEND).build(
								envelope);
					}
				}));
	}

}
