package co.aurasphere.botmill.fb.model.threadsettings;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.internal.util.validation.FbBotMillValidationConstants;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;

import com.google.gson.annotations.SerializedName;

/**
 * Request used for Thread Settings of Get Started Button and Persistent Menu.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 *      
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public class CallToActionsRequest extends ThreadSettingsBaseRequest {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Facebook Thread State. 
	 */
	@NotNull
	@SerializedName("thread_state")
	private ThreadState threadState;

	/**
	 * The list of buttons used by this Thread Setting.
	 */
	@Valid
	@Size(max=FbBotMillValidationConstants.THREAD_SETTINGS_BUTTONS_MAX_ELEMENTS)
	@NotEmpty
	@SerializedName("call_to_actions")
	private List<Button> callToActions;

	/**
	 * Instantiates a new call to actions request.
	 *
	 * @param threadState the {@link #threadState}.
	 * @param callToActions the {@link #callToActions}.
	 */
	public CallToActionsRequest(ThreadState threadState,
			List<Button> callToActions) {
		this.type = SettingType.CALL_TO_ACTIONS;
		this.threadState = threadState;
		this.callToActions = callToActions;
	}

	/**
	 * Gets the {@link #threadState}.
	 *
	 * @return the {@link #threadState}.
	 */
	public ThreadState getThreadState() {
		return threadState;
	}

	/**
	 * Sets the {@link #threadState}.
	 *
	 * @param threadState the {@link #threadState} to set.
	 */
	public void setThreadState(ThreadState threadState) {
		this.threadState = threadState;
	}

	/**
	 * Gets the {@link #callToActions}.
	 *
	 * @return the {@link #callToActions}.
	 */
	public List<Button> getCallToActions() {
		return callToActions;
	}

	/**
	 * Sets the {@link #callToActions}.
	 *
	 * @param callToActions the {@link #callToActions} to set.
	 */
	public void setCallToActions(List<Button> callToActions) {
		this.callToActions = callToActions;
	}

}
