package co.aurasphere.botmill.fb.model.threadsettings;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Request used for Thread Settings of Text Greeting.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 * 
 * @author Alvin Reyes
 * @date 08/Oct/2016
 */
public class SetGreetingTextRequest extends ThreadSettingsBaseRequest {

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
