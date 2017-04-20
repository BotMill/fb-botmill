package co.aurasphere.botmill.fb.test.autoreply.template;

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.botmill.core.annotation.BotConfiguration;
import co.aurasphere.botmill.fb.FbBotConfiguration;
import co.aurasphere.botmill.fb.api.MessengerProfileApi;
import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;

@BotConfiguration
public class AnnotatedTemplatedBehaviourConigTest extends FbBotConfiguration {

	public AnnotatedTemplatedBehaviourConigTest() {
		List<Button> buttons = new ArrayList<Button>();
		buttons.add(ButtonFactory.createPostbackButton("Postback Button", "PPB Payload"));
		buttons.add(ButtonFactory.createUrlButton("URL Button", "http://www.aurasphere.co"));

		// Sets the thread settings.
		MessengerProfileApi.setGetStartedButton("get_started");
		MessengerProfileApi.setGreetingMessage("hello");
	}
}
