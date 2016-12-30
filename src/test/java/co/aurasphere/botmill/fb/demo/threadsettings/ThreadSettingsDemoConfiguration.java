package co.aurasphere.botmill.fb.demo.threadsettings;

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.model.outcoming.factory.ButtonFactory;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.threadsettings.FbBotMillThreadSettingsConfiguration;
import static co.aurasphere.botmill.fb.demo.FbBotMillDemoConstants.*;


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
		FbBotMillContext.getInstance().setup(PAGE_TOKEN, VALIDATION_TOKEN);

		// Creates a list of persistent buttons.
		List<Button> buttons = new ArrayList<Button>();
		buttons.add(ButtonFactory.createPostbackButton(
				"Postback Button", "PPB Payload"));
		buttons.add(ButtonFactory.createUrlButton("URL Button",
				"http://www.aurasphere.co"));

		// Sets the thread settings.
		FbBotMillThreadSettingsConfiguration
				.setGreetingMessage("Hi, welcome to FbBotMill!");
		FbBotMillThreadSettingsConfiguration
				.setGetStartedButton("Get Started Button Payload");
		FbBotMillThreadSettingsConfiguration.setPersistentMenu(buttons);
	}

}
