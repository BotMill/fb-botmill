package co.aurasphere.botmill.fb.demo.threadsettings;

import static co.aurasphere.botmill.fb.demo.FbBotMillDemoConstants.*;

import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.threadsettings.FbBotMillThreadSettingsConfiguration;


/**
 * Demo of resetting the Thread Settings configuration.
 * 
 * @author Donato Rimenti
 * 
 */
public class ThreadSettingsDemoReset {

	/**
	 * Resets the Get Started Button and the Persistent Menu.
	 * 
	 * @param args
	 *            should be empty.
	 */
	public static void main(String[] args) {
		// Configuration.
		FbBotMillContext.getInstance().setup(PAGE_TOKEN, VALIDATION_TOKEN);
		
		FbBotMillThreadSettingsConfiguration.deleteGetStartedButton();
		FbBotMillThreadSettingsConfiguration.deletePersistentMenu();
	}
}
