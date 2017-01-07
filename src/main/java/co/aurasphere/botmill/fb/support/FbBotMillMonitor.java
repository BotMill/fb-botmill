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
package co.aurasphere.botmill.fb.support;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;

import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.FbBotMillServlet;
import co.aurasphere.botmill.fb.model.incoming.FacebookErrorMessage;
import co.aurasphere.botmill.fb.model.incoming.MessengerCallback;
import co.aurasphere.botmill.fb.model.incoming.FacebookConfirmationMessage;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;

/**
 * Base interface for monitoring raw data from BotMill framework and Facebook
 * Messenger Platform. These interface methods will be called as a callback each
 * time the FbBotMill receives data from the network or other similar events
 * occurs. In order to use these callbacks, you will need to implement this
 * interface and register it to the FbBotMillContext using the method
 * {@link FbBotMillContext#registerMonitor(FbBotMillMonitor)}.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public interface FbBotMillMonitor {

	/**
	 * Callback processed each time the bot sends data and gets a reply back
	 * from the Facebook's server.
	 * 
	 * @param data
	 *            the Facebook response to the last AutoReply the bot sent.
	 */
	public void onConfirmation(FacebookConfirmationMessage data);

	/**
	 * Callback processed each time the bot sends data and gets an error back
	 * from the Facebook's server.
	 * 
	 * @param error
	 *            the Facebook error.
	 */
	public void onError(FacebookErrorMessage error);

	/**
	 * Callback processed each time the {@link FbBotMillServlet} receives an
	 * HTTP POST request. Please, notice that this method will be called
	 * <b>after</b> the bots have processed it. This is because the method's
	 * purpose is data monitoring, analysis and statistics. Since the operations
	 * involved in this process may be heavy, in order to let the bots return a
	 * response to the user quickly, this callback is postponed.
	 * 
	 * @param request
	 *            the incoming raw servlet request.
	 * @param data
	 *            the Facebook incoming data.
	 */
	public void onPostReceived(HttpServletRequest request,
			MessengerCallback data);

	/**
	 * Callback processed each time the {@link FbBotMillServlet} receives an
	 * HTTP GET request. Please, notice that this method will be called
	 * <b>after</b> the bots have processed it. This is because the method's
	 * purpose is data monitoring, analysis and statistics. Since the operations
	 * involved in this process may be heavy, in order to let the bots return a
	 * response to the user quickly, this callback is postponed.
	 * 
	 * @param request
	 *            the incoming raw servlet request.
	 */
	public void onGetReceived(HttpServletRequest request);

	/**
	 * Callback processed each time there is a validation error on the response
	 * produced by the bots.
	 * 
	 * @param response
	 *            the invalid response produced by the bot.
	 * @param constraintViolations
	 *            the constraint violations for the current response.
	 */
	public void onValidationError(FbBotMillResponse response,
			Set<ConstraintViolation<FbBotMillResponse>> constraintViolations);

}
