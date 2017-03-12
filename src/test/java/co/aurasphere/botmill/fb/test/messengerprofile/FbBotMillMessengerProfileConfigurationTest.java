package co.aurasphere.botmill.fb.test.messengerprofile;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.fb.internal.util.network.FbBotMillNetworkController;
import co.aurasphere.botmill.fb.model.messengerprofile.FbBotMillMessengerProfileConfiguration;
import co.aurasphere.botmill.fb.model.messengerprofile.persistentmenu.CallToAction;
import co.aurasphere.botmill.fb.model.messengerprofile.persistentmenu.PersistentMenu;
import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.button.ButtonType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.BuyButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PaymentSummary;
import co.aurasphere.botmill.fb.model.outcoming.template.button.PostbackButton;
import co.aurasphere.botmill.fb.model.outcoming.template.button.WebUrlButton;
import co.aurasphere.botmill.fb.model.threadsettings.CallToActionsRequest;
import co.aurasphere.botmill.fb.model.threadsettings.DomainActionType;
import co.aurasphere.botmill.fb.model.threadsettings.ThreadState;
import co.aurasphere.botmill.fb.model.threadsettings.WhitelistDomainRequest;
import co.aurasphere.botmill.fb.model.threadsettings.greeting.SetGreetingTextRequest;
import co.aurasphere.botmill.fb.model.threadsettings.payment.PaymentDevModeAction;
import co.aurasphere.botmill.fb.model.threadsettings.payment.PaymentSettings;
import co.aurasphere.botmill.fb.threadsettings.FbBotMillThreadSettingsConfiguration;

public class FbBotMillMessengerProfileConfigurationTest {
	
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
	}
}
