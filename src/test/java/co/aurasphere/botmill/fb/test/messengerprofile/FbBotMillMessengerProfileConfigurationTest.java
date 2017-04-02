package co.aurasphere.botmill.fb.test.messengerprofile;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import co.aurasphere.botmill.fb.messengerprofile.FbBotMillMessengerProfileConfiguration;
import co.aurasphere.botmill.fb.model.messengerprofile.persistentmenu.CallToAction;
import co.aurasphere.botmill.fb.model.messengerprofile.persistentmenu.PersistentMenu;
import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;


/**
 * The Class FbBotMillMessengerProfileConfigurationTest.
 */
public class FbBotMillMessengerProfileConfigurationTest {
	
	/**
	 * Test persistent menu.
	 */
	@Test
	public void testPersistentMenu() {
		
		List<PersistentMenu> persistentMenus = new ArrayList<PersistentMenu>();
		
		//	Create a persistent menu
		PersistentMenu p = new PersistentMenu("default", true);
		
		CallToAction c1 = new CallToAction("Title1");
		c1.addCallToActionButton(ButtonFactory.createPostbackButton("hello", "hey1"));
		c1.addCallToActionButton(ButtonFactory.createPostbackButton("hello", "hey2"));
		
		
		CallToAction c2 = new CallToAction("Title2");
		c2.addCallToActionButton(ButtonFactory.createPostbackButton("hello", "hey3"));
		c2.addCallToActionButton(ButtonFactory.createPostbackButton("hello", "hey4"));
		
		p.addCallToAction(c1);
		p.addCallToAction(c2);
		
		persistentMenus.add(p);
		
		FbBotMillMessengerProfileConfiguration.setPersistentMenus(persistentMenus);
		
		assertNotNull(persistentMenus);
	}
}
