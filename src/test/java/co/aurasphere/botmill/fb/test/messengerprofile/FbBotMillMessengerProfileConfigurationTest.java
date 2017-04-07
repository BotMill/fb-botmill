package co.aurasphere.botmill.fb.test.messengerprofile;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.messengerprofile.FbBotMillMessengerProfileConfiguration;
import co.aurasphere.botmill.fb.model.messengerprofile.persistentmenu.CallToActionNested;
import co.aurasphere.botmill.fb.model.messengerprofile.persistentmenu.PersistentMenu;
import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;
import co.aurasphere.botmill.fb.model.outcoming.template.button.ButtonType;


/**
 * The Class FbBotMillMessengerProfileConfigurationTest.
 */
public class FbBotMillMessengerProfileConfigurationTest {
	
	/**
	 * Test persistent menu.
	 */
	@Test
	public void testPersistentMenu() {

		FbBotMillMessengerProfileConfiguration.setGetStartedButton("get_started");
		FbBotMillMessengerProfileConfiguration.setGreetingMessage("Greetings!");

		List<PersistentMenu> persistentMenus = new ArrayList<PersistentMenu>();
		PersistentMenu p = new PersistentMenu("default", false);

		CallToActionNested c1 = new CallToActionNested("Title1");
		c1.addCallToActionButton(ButtonFactory.createPostbackButton("hello", "hey1"));
		c1.addCallToActionButton(ButtonFactory.createPostbackButton("hello", "hey2"));

		p.addCallToAction(c1);
		p.addCallToAction(ButtonFactory.createPostbackButton("hello", "hey1"));
		p.addCallToAction(ButtonFactory.createUrlButton("asas", "http://alvinpreyes.com"));

		persistentMenus.add(p);

		FbBotMillMessengerProfileConfiguration.setPersistentMenus(persistentMenus);
		assertNotNull(persistentMenus);
	}
}
