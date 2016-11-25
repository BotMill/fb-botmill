package co.aurasphere.facebot.demo.threadsettings;

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.facebot.FaceBotContext;
import co.aurasphere.facebot.model.outcoming.factory.ButtonFactory;
import co.aurasphere.facebot.model.outcoming.template.button.Button;
import co.aurasphere.facebot.threadsettings.FaceBotThreadSettingsConfiguration;
import static co.aurasphere.facebot.demo.FaceBotDemoConstants.*;

/**
 * Demo of configuring the Thread Settings.
 * 
 * @author Donato
 * @date 28/ago/2016
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
		FaceBotContext.getInstance().setup(PAGE_TOKEN, VALIDATION_TOKEN);

		// Creates a list of persistent buttons.
		List<Button> buttons = new ArrayList<Button>();
		buttons.add(ButtonFactory.createPostbackButton(
				"Postback Button", "PPB Payload"));
		buttons.add(ButtonFactory.createUrlButton("URL Button",
				"http://www.aurasphere.co"));

		// Sets the thread settings.
		FaceBotThreadSettingsConfiguration
				.setGreetingMessage("Hi, welcome to FaceBot!");
		FaceBotThreadSettingsConfiguration
				.setGetStartedButton("Get Started Button Payload");
		FaceBotThreadSettingsConfiguration.setPersistentMenu(buttons);
	}

}
