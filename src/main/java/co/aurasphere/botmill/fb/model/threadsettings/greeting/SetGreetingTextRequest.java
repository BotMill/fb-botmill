package co.aurasphere.botmill.fb.model.threadsettings.greeting;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.threadsettings.SettingType;
import co.aurasphere.botmill.fb.model.threadsettings.ThreadSettingsBaseRequest;


/**
 * Request used for Thread Settings of Text Greeting.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 *      
 * 
 */
public class SetGreetingTextRequest extends ThreadSettingsBaseRequest {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Greeting text.
	 */
	@Valid
	@NotNull
	private Greeting greeting;

	/**
	 * Instantiates a new set greeting text request.
	 *
	 * @param greeting the {@link #greeting}.
	 */
	public SetGreetingTextRequest(String greeting) {
		this.type = SettingType.GREETING;
		this.greeting = new Greeting(greeting);
	}

	/**
	 * Gets the {@link #greeting}.
	 *
	 * @return the {@link #greeting}.
	 */
	public Greeting getGreeting() {
		return greeting;
	}

	/**
	 * Sets the {@link #greeting}.
	 *
	 * @param greeting the {@link #greeting} to set.
	 */
	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}
}
