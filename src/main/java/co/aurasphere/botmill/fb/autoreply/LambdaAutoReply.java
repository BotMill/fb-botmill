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
package co.aurasphere.botmill.fb.autoreply;

import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;


/**
 * An {@link AutoReply} whose reply is defined by a Java 8 Lambda function.
 * 
 * @author Donato Rimenti
 * @since 1.2.0
 */
public class LambdaAutoReply extends AutoReply {

	/**
	 * A lambda which represents how to reply to this message.
	 */
	private Reply lambda;

	/**
	 * Instantiates a new LambdaAutoReply.
	 *
	 * @param lambda
	 *            the {@link #lambda}.
	 */
	public LambdaAutoReply(Reply lambda) {
		this.lambda = lambda;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.autoreply.AutoReply#createResponse(co.aurasphere
	 * .botmill.fb.model.incoming.MessageEnvelope)
	 */
	@Override
	public FbBotMillResponse createResponse(MessageEnvelope envelope) {
		return lambda.createResponse(envelope);
	}

}
