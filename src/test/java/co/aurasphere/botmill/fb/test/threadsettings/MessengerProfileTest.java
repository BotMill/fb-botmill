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
package co.aurasphere.botmill.fb.test.threadsettings;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import co.aurasphere.botmill.fb.messengerprofile.FbBotMillMessengerProfileConfiguration;
import co.aurasphere.botmill.fb.model.messengerprofile.Greeting;
import co.aurasphere.botmill.fb.test.BaseFbBotMillNetworkTest;

/**
 * Test class for the {@link FbBotMillMessengerProfileConfiguration}.
 * 
 * @author Donato Rimenti
 */
public class MessengerProfileTest extends BaseFbBotMillNetworkTest {

	@Override
	public void defineBehaviour() {
		// TODO Auto-generated method stub
		super.defineBehaviour();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.test.BaseFbBotMillTest#testImplementation()
	 */
	@Override
	protected void testImplementation() throws Exception {
		testGetStartedButtonMessengerProfile();
		testGreetingTextMessengerProfile();
		testAccountWhitelistingMessengerProfile();
		testAccountLinkingUrlMessengerProfile();
	}

	/**
	 * Tests the Get Started Button Messenger Profile.
	 */
	private void testGetStartedButtonMessengerProfile() {
		FbBotMillMessengerProfileConfiguration.setGetStartedButton("TEST_GET_STARTED_BUTTON");
		FbBotMillMessengerProfileConfiguration.deleteGetStartedButton();
	}
	
	/**
	 * Tests the Greeting Text Messenger Profile.
	 */
	private void testGreetingTextMessengerProfile() {
		FbBotMillMessengerProfileConfiguration.setGreetingMessage("TEST_GREETING_MESSAGE");
		FbBotMillMessengerProfileConfiguration.deleteGreetingMessage();
		
		List<Greeting> greetings = new ArrayList<Greeting>();
		greetings.add(new Greeting("TEST_GREETING_US", Locale.US));
		greetings.add(new Greeting("TEST_GREETING_IT", Locale.ITALY));
		FbBotMillMessengerProfileConfiguration.setGreetingMessage(greetings);
	}
	
	/**
	 * Tests the Account Whitelisting Messenger Profile.
	 */
	private void testAccountWhitelistingMessengerProfile() {
		List<String> whitelistedDomains = new ArrayList<String>();
		whitelistedDomains.add("www.google.it");
		whitelistedDomains.add("www.aurasphere.co");
		FbBotMillMessengerProfileConfiguration.setWhitelistedDomains(whitelistedDomains);
	
		FbBotMillMessengerProfileConfiguration.deleteWhitelistedDomains();
	}
	
	/**
	 * Tests the Account Linking URL Messenger Profile.
	 */
	private void testAccountLinkingUrlMessengerProfile(){
		FbBotMillMessengerProfileConfiguration.setAccountLinkingUrl("www.aurasphere.co");
		FbBotMillMessengerProfileConfiguration.deleteAccountLinkingUrl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.test.BaseFbBotMillTest#skipTest()
	 */
	@Override
	protected boolean skipTest() {
		return false;
	}

}
