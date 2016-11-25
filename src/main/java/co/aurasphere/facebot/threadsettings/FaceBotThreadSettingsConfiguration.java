package co.aurasphere.facebot.threadsettings;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.facebot.FaceBotDefinition;
import co.aurasphere.facebot.bean.FaceBotNetworkAwareBean;
import co.aurasphere.facebot.model.outcoming.template.button.Button;
import co.aurasphere.facebot.model.outcoming.template.button.PostbackButton;
import co.aurasphere.facebot.model.outcoming.template.button.WebUrlButton;
import co.aurasphere.facebot.model.threadsettings.CallToActionsRequest;
import co.aurasphere.facebot.model.threadsettings.SetGreetingTextRequest;
import co.aurasphere.facebot.model.threadsettings.ThreadState;

/**
 * Class which handles the configuration of the Facebook Messenger Platform
 * Thread Settings (for more informations, see the link below). The methods of
 * this class needs to be called only once and thus shouldn't be put on the
 * class that implements {@link FaceBotDefinition}. The best way of handling the
 * configuration would be defining your own class with a main method and put the
 * call on it.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Thread Settings Documentation</a>
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public class FaceBotThreadSettingsConfiguration extends FaceBotNetworkAwareBean {

	private static final Logger logger = LoggerFactory
			.getLogger(FaceBotThreadSettingsConfiguration.class);

	/**
	 * Sets the greeting message for the bot. The Greeting Text is only rendered
	 * the first time the user interacts with a the Page on Messenger.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/greeting-text"
	 *      >Facebook's Greeting Text Documentation</a>
	 * 
	 * @param message
	 *            the greeting message to show.
	 */
	public static void setGreetingMessage(String message) {
		if (message == null || message.isEmpty()) {
			logger.error("FaceBot validation error: Greeting message can't be null or empty!");
			return;
		}
		SetGreetingTextRequest request = new SetGreetingTextRequest(message);
		StringEntity jsonRequest = toJson(request);
		postThreadSetting(jsonRequest);
	}

	/**
	 * Sets the Get Started Button for the bot. The Get Started button is only
	 * rendered the first time the user interacts with a the Page on Messenger.
	 * When this button is tapped, the defined payload will be sent back with a
	 * postback received callback.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/get-started-button"
	 *      >Facebook's Get Started Button Documentation</a>
	 * 
	 * @param payload
	 *            the payload to return when the button is tapped.
	 */
	public static void setGetStartedButton(String payload) {
		if (payload == null || payload.isEmpty()) {
			logger.error("FaceBot validation error: Get Started Button payload can't be null or empty!");
			return;
		}
		Button button = new PostbackButton(null, null, payload);
		List<Button> buttonList = new ArrayList<Button>();
		buttonList.add(button);
		CallToActionsRequest request = new CallToActionsRequest(
				ThreadState.NEW_THREAD, buttonList);
		StringEntity jsonRequest = toJson(request);
		postThreadSetting(jsonRequest);
	}

	/**
	 * Removes the current Get Started Button.
	 * 
	 * @see {@link #setGetStartedButton(String)}
	 * 
	 */
	public static void deleteGetStartedButton() {
		CallToActionsRequest request = new CallToActionsRequest(
				ThreadState.NEW_THREAD, null);
		StringEntity jsonRequest = toJson(request);
		delete(jsonRequest);
	}

	/**
	 * Sets a Persistent Menu of buttons which is always available to the user.
	 * This menu should contain top-level actions that users can enact at any
	 * point. Having a persistent menu easily communicates the basic
	 * capabilities of your bot for first-time and returning users. The menu can
	 * be invoked by a user, by tapping on the 3-caret icon on the left of the
	 * composer.
	 * 
	 * @see <a href=
	 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings/persistent-menu"
	 *      >Facebook's Persistent Menu Documentation</a>
	 * 
	 * @param buttons
	 *            a list of {@link Button} (max 5 elements) to use as menu. The
	 *            buttons can only be {@link PostbackButton} or
	 *            {@link WebUrlButton}. Phone buttons are not supported.
	 */
	public static void setPersistentMenu(List<Button> buttons) {
		if (buttons == null || buttons.isEmpty() || buttons.size() > 5) {
			logger.error("FaceBot validation error: Persistent Menu Buttons can't be null or empty and must be less than 5!");
			return;
		}
		CallToActionsRequest request = new CallToActionsRequest(
				ThreadState.EXISTING_THREAD, buttons);
		StringEntity jsonRequest = toJson(request);
		postThreadSetting(jsonRequest);
	}

	/**
	 * Removes the current Persistent Menu.
	 * 
	 * @see {@link #setPersistentMenu(List)}
	 * 
	 */
	public static void deletePersistentMenu() {
		CallToActionsRequest request = new CallToActionsRequest(
				ThreadState.EXISTING_THREAD, null);
		StringEntity jsonRequest = toJson(request);
		delete(jsonRequest);
	}

}
