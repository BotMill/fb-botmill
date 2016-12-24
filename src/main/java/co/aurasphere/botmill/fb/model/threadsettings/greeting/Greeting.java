package co.aurasphere.botmill.fb.model.threadsettings.greeting;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.internal.util.validation.FbBotMillValidationConstants;

/**
 * Object which represents a Greeting Text for Thread Settings.
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public class Greeting implements Serializable {

	/**
	 * Placeholder for the user first name. This placeholder will be dinamically
	 * changed with the current user first name.
	 */
	public static final String USER_FIRST_NAME = "{{user_first_name}}";

	/**
	 * Placeholder for the user last name. This placeholder will be dinamically
	 * changed with the current user last name.
	 */
	public static final String USER_LAST_NAME = "{{user_last_name}}";

	/**
	 * Placeholder for the user full name. This placeholder will be dinamically
	 * changed with the current user full name.
	 */
	public static final String USER_FULL_NAME = "{{user_full_name}}";

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The message that will be shown to the user. This message can include the
	 * user name. To do that, add to the String the following placeholders
	 * constants from this class:
	 * 
	 * <pre>
	 * - {@link #USER_FIRST_NAME} 
	 * - {@link #USER_LAST_NAME} 
	 * - {@link #USER_FULL_NAME}
	 * </pre>
	 * 
	 * This message can be at most
	 * {@value FbBotMillValidationConstants#THREAD_SETTINGS_GREETING_MESSAGE_MAX_LENGTH}
	 * characters long. The placeholders for the last and full name use 18
	 * characters, meanwhile the first name uses 19 characters.
	 */
	@Size(max = FbBotMillValidationConstants.THREAD_SETTINGS_GREETING_MESSAGE_MAX_LENGTH)
	@NotEmpty
	private String text;

	/**
	 * Instantiates a new greeting.
	 *
	 * @param text
	 *            the {@link #text}.
	 */
	public Greeting(String text) {
		this.text = text;
	}

	/**
	 * Gets the {@link #text}.
	 *
	 * @return the {@link #text}.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the {@link #text}.
	 *
	 * @param text
	 *            the {@link #text} to set.
	 */
	public void setText(String text) {
		this.text = text;
	}

}
