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
package co.aurasphere.botmill.fb.model.api.messengerprofile.persistentmenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.button.ButtonType;


/**
 * The Class CallToAction.
 * 
 * This is the persistent menu call to action object. Holds
 * a list of Call to action menu (based on Postback button).
 */
public class CallToActionNested extends Button implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The title. */
	private String title;

	/** The call to actions. */
	@SerializedName("call_to_actions")
	private List<Button> callToActions;
	
	/**
	 * Instantiates a new call to action.
	 *
	 * @param title the title
	 */
	public CallToActionNested(String title) {
		this.title = title;
		this.type = ButtonType.NESTED;
		this.callToActions = new ArrayList<Button>();
	}
	
	/**
	 * Instantiates a new call to action.
	 *
	 * @param title the title
	 * @param type the type
	 */
	public CallToActionNested(String title, ButtonType type) {
		this.title = title;
		this.type = ButtonType.NESTED;
		this.callToActions = new ArrayList<Button>();
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public void setType(ButtonType type) {
		super.setType(type);
	}
	
	@Override
	public ButtonType getType() {
		return super.getType();
	}
	
	
	/**
	 * Gets the call to actions.
	 *
	 * @return the call to actions
	 */
	public List<Button> getCallToActions() {
		return callToActions;
	}
	
	/**
	 * Sets the call to actions.
	 *
	 * @param callToActions the new call to actions
	 */
	public void setCallToActions(List<Button> callToActions) {
		this.callToActions = callToActions;
	}
	
	/**
	 * Sets the call to action buttons.
	 *
	 * @param callToActions the new call to action buttons
	 */
	public void setCallToActionButtons(List<Button> callToActions) {
		this.callToActions = callToActions;
	}
	
	/**
	 * Adds the call to action button.
	 *
	 * @param postBackButton the post back button
	 */
	public void addCallToActionButton(Button postBackButton) {
		this.callToActions.add(postBackButton);
	}
	
}
