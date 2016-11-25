package co.aurasphere.facebot.model.threadsettings;

/**
 * Enum for the Thread Setting to modify.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 * 
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public enum SettingType {

	/**
	 * Setting for the Greeting Text message.
	 */
	GREETING,

	/**
	 * Setting for the Get Started Button or the Persistent Menu.
	 */
	CALL_TO_ACTIONS;

}
