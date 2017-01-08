/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 * 
 * 
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
	@Size(max = FbBotMillValidationConstants.THREAD_SETTINGS_BUTTONS_MAX_ELEMENTS)
	@NotEmpty
	@SerializedName("call_to_actions")
	private List<Button> callToActions;

	/**
	 * Instantiates a new call to actions request.
	 *
	 * @param threadState
	 *            the {@link #threadState}.
	 * @param callToActions
	 *            the {@link #callToActions}.
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
	 * @param threadState
	 *            the {@link #threadState} to set.
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
	 * @param callToActions
	 *            the {@link #callToActions} to set.
	 */
	public void setCallToActions(List<Button> callToActions) {
		this.callToActions = callToActions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((callToActions == null) ? 0 : callToActions.hashCode());
		result = prime * result
				+ ((threadState == null) ? 0 : threadState.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CallToActionsRequest other = (CallToActionsRequest) obj;
		if (callToActions == null) {
			if (other.callToActions != null)
				return false;
		} else if (!callToActions.equals(other.callToActions))
			return false;
		if (threadState != other.threadState)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CallToActionsRequest [threadState=" + threadState
				+ ", callToActions=" + callToActions + ", type=" + type + "]";
	}

}
