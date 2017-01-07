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
package co.aurasphere.botmill.fb.demo;

import static co.aurasphere.botmill.fb.demo.FbBotMillDemoConstants.MOCK_FACEBOOK_ID;
import static co.aurasphere.botmill.fb.demo.FbBotMillDemoConstants.PAGE_TOKEN;
import static co.aurasphere.botmill.fb.demo.FbBotMillDemoConstants.VALIDATION_TOKEN;
import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.demo.behavior.TemplateBehavior;
import co.aurasphere.botmill.fb.support.FbBotMillMockMediator;

/**
 * The Class FbBotMillDemo.
 */
public class FbBotMillDemo {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		// Configuration.
		FbBotMillContext.getInstance().setup(PAGE_TOKEN, VALIDATION_TOKEN);

		// Instantiating the testing framework and starting the interactive
		// test.
		FbBotMillMockMediator mediator = FbBotMillMockMediator.getInstance(MOCK_FACEBOOK_ID,
				TemplateBehavior.class);
		mediator.interactiveTest();
	}

}
