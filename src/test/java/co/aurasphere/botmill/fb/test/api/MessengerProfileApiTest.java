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
package co.aurasphere.botmill.fb.test.api;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import co.aurasphere.botmill.fb.api.MessengerProfileApi;
import co.aurasphere.botmill.fb.model.api.messengerprofile.Greeting;
import co.aurasphere.botmill.fb.model.api.messengerprofile.persistentmenu.CallToActionNested;
import co.aurasphere.botmill.fb.model.api.messengerprofile.persistentmenu.PersistentMenu;
import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;

/**
 * Test class for the {@link MessengerProfileApi}.
 * 
 * @author Donato Rimenti
 * @author Alvin Reyes
 */
public class MessengerProfileApiTest {

	/**
	 * Tests the Get Started Button Messenger Profile.
	 */
//	@Test
	public void testGetStartedButtonMessengerProfile() {
		MessengerProfileApi.setGetStartedButton("TEST_GET_STARTED_BUTTON");
		MessengerProfileApi.deleteGetStartedButton();
	}

	/**
	 * Tests the Greeting Text Messenger Profile.
	 */
//	@Test
	public void testGreetingTextMessengerProfile() {
		MessengerProfileApi.setGreetingMessage("TEST_GREETING_MESSAGE");
		MessengerProfileApi.deleteGreetingMessage();

		List<Greeting> greetings = new ArrayList<Greeting>();
		greetings.add(new Greeting("TEST_GREETING_US", Locale.US));
		greetings.add(new Greeting("TEST_GREETING_IT", Locale.ITALY));
		MessengerProfileApi.setGreetingMessage(greetings);
	}

	/**
	 * Tests the Account Whitelisting Messenger Profile.
	 */
//	@Test
	public void testAccountWhitelistingMessengerProfile() {
		List<String> whitelistedDomains = new ArrayList<String>();
		whitelistedDomains.add("www.google.it");
		whitelistedDomains.add("www.aurasphere.co");
		MessengerProfileApi.setWhitelistedDomains(whitelistedDomains);

		MessengerProfileApi.deleteWhitelistedDomains();
	}

	/**
	 * Tests the Account Linking URL Messenger Profile.
	 */
//	@Test
	public void testAccountLinkingUrlMessengerProfile() {
		MessengerProfileApi.setAccountLinkingUrl("www.aurasphere.co");
		MessengerProfileApi.deleteAccountLinkingUrl();
	}

	/**
	 * Test persistent menu.
	 */
//	@Test
	public void testPersistentMenu() {

		MessengerProfileApi.setGetStartedButton("get_started");
		MessengerProfileApi.setGreetingMessage("Greetings!");

		List<PersistentMenu> persistentMenus = new ArrayList<PersistentMenu>();
		PersistentMenu p = new PersistentMenu("default", false);

		CallToActionNested c1 = new CallToActionNested("Title1");
		c1.addCallToActionButton(ButtonFactory.createPostbackButton("hello",
				"hey1"));
		c1.addCallToActionButton(ButtonFactory.createPostbackButton("hello",
				"hey2"));

		p.addCallToAction(c1);
		p.addCallToAction(ButtonFactory.createPostbackButton("hello", "hey1"));
		p.addCallToAction(ButtonFactory.createUrlButton("asas",
				"http://alvinpreyes.com"));

		persistentMenus.add(p);

		MessengerProfileApi.setPersistentMenus(persistentMenus);
		assertNotNull(persistentMenus);
	}

}
