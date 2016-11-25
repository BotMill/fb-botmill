package co.aurasphere.facebot.model.threadsettings;

/**
 * Enum that represents the Thread Setting to configure.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 * 
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public enum ThreadState {

	/**
	 * Used for the Get Started Button.
	 */
	NEW_THREAD, 
	
	/**
	 * Used for the Persistent Menu.
	 */
	EXISTING_THREAD;
}
