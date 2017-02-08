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
package co.aurasphere.botmill.fb.demo.threadsettings;

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.threadsettings.FbBotMillThreadSettingsConfiguration;
import static co.aurasphere.botmill.fb.demo.FbBotMillDemoData.*;

/**
 * Demo of configuring the Thread Settings.
 * 
 * @author Donato Rimenti
 * 
 */
public class ThreadSettingsDemoConfiguration {

	/**
	 * Sets up a greeting message, a persistent menu list and a get started
	 * button.
	 * 
	 * @param args
	 *            should be null.
	 */
	public static void main(String[] args) {
		// Configuration.
		FbBotMillContext.getInstance().setup(getFbPageToken(), getFbValidationToken());

		// Creates a list of persistent buttons.
		List<Button> buttons = new ArrayList<Button>();
		buttons.add(ButtonFactory.createPostbackButton("Postback Button", "PPB Payload"));
		buttons.add(ButtonFactory.createUrlButton("URL Button", "http://www.aurasphere.co"));

		// Sets the thread settings.
		FbBotMillThreadSettingsConfiguration.setGreetingMessage("Hi, welcome to FbBotMill!");
		FbBotMillThreadSettingsConfiguration.setGetStartedButton("Get Started Button Payload");
		FbBotMillThreadSettingsConfiguration.setPersistentMenu(buttons);
	}

}
