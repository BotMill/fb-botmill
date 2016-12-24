package co.aurasphere.botmill.fb.model.threadsettings;


/**
 * Enum that represents the Facebook Thread state.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 * @date Aug 08, 2016
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
