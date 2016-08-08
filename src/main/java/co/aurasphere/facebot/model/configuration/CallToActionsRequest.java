package co.aurasphere.facebot.model.configuration;

import java.util.List;

import co.aurasphere.facebot.model.outcoming.template.button.Button;

import com.google.gson.annotations.SerializedName;

/**
 * Request used for Thread Settings of Get Started Button and Persistent Menu.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 *      
 * @author Donato
 * @date 08/ago/2016
 */
public class CallToActionsRequest extends ThreadSettingRequest {

	private static final long serialVersionUID = 1L;

	@SerializedName("thread_state")
	private ThreadState threadState;

	@SerializedName("call_to_actions")
	private List<Button> callToActions;

	public CallToActionsRequest(ThreadState threadState,
			List<Button> callToActions) {
		this.type = SettingType.CALL_TO_ACTIONS;
		this.threadState = threadState;
		this.callToActions = callToActions;
	}

	public ThreadState getThreadState() {
		return threadState;
	}

	public void setThreadState(ThreadState threadState) {
		this.threadState = threadState;
	}

	public List<Button> getCallToActions() {
		return callToActions;
	}

	public void setCallToActions(List<Button> callToActions) {
		this.callToActions = callToActions;
	}

}
