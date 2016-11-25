package co.aurasphere.facebot.model.threadsettings;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Request used for Thread Settings of Text Greeting.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 *      
 * @author Donato
 * @date 08/ago/2016
 */
public class SetGreetingTextRequest extends ThreadSettingRequest{

	private static final long serialVersionUID = 1L;

	@Valid
	@NotNull
	private Greeting greeting;

	public SetGreetingTextRequest(String greeting) {
		this.type = SettingType.GREETING;
		this.greeting = new Greeting(greeting);
	}

	public Greeting getGreeting() {
		return greeting;
	}

	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}
}
