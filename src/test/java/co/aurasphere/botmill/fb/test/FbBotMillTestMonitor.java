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

import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;

import co.aurasphere.botmill.fb.model.incoming.FacebookConfirmationMessage;
import co.aurasphere.botmill.fb.model.incoming.FacebookErrorMessage;
import co.aurasphere.botmill.fb.model.incoming.MessengerCallback;
import co.aurasphere.botmill.fb.model.outcoming.FbBotMillResponse;
import co.aurasphere.botmill.fb.support.FbBotMillMonitor;

/**
 * A custom monitor implementation used to check if any error happens during
 * tests.
 * 
 * @author Donato Rimenti
 * @since 1.1.0
 */
public class FbBotMillTestMonitor implements FbBotMillMonitor {

	/**
	 * A latch used to synchronize this monitor with the testing facility.
	 */
	private CountDownLatch latch;

	/**
	 * The result object returned by the monitor.
	 */
	private Object result;

	/**
	 * Instantiates a new FbBotMillTestMonitor.
	 */
	public FbBotMillTestMonitor() {
		reset();
	}

	/**
	 * Resets this monitor.
	 */
	private void reset() {
		result = null;
		latch = new CountDownLatch(1);
	}

	/**
	 * Gets the result of the computation. The main purpose of this method is to
	 * synchronize the underlying asynchronous processor. This is done using a
	 * {@link CountDownLatch}.
	 * 
	 * @return the result of the computation.
	 * @throws Exception
	 *             a generic exception.
	 */
	public Object get() throws Exception {
		latch.await();
		Object result = this.result;
		reset();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.support.FbBotMillNetworkMonitor#onResponse(co
	 * .aurasphere.botmill.fb.model.incoming.MessengerCallback)
	 */
	public void onConfirmation(FacebookConfirmationMessage data) {
		latch.countDown();
		result = data;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.support.FbBotMillNetworkMonitor#onError(co.
	 * aurasphere.botmill.fb.model.incoming.FacebookErrorMessage)
	 */
	public void onError(FacebookErrorMessage error) {
		latch.countDown();
		result = error;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.support.FbBotMillNetworkMonitor#onPostReceived
	 * (javax.servlet.http.HttpServletRequest,
	 * co.aurasphere.botmill.fb.model.incoming.MessengerCallback)
	 */
	public void onPostReceived(HttpServletRequest request,
			MessengerCallback data) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.support.FbBotMillNetworkMonitor#onGetReceived
	 * (javax.servlet.http.HttpServletRequest)
	 */
	public void onGetReceived(HttpServletRequest request) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.botmill.fb.support.FbBotMillMonitor#onValidationError(co
	 * .aurasphere.botmill.fb.model.outcoming.FbBotMillResponse, java.util.Set)
	 */
	public void onValidationError(FbBotMillResponse response,
			Set<ConstraintViolation<FbBotMillResponse>> constraintViolations) {
		latch.countDown();
		result = constraintViolations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FbBotMillTestMonitor [latch=" + latch + ", result=" + result
				+ "]";
	}

}
