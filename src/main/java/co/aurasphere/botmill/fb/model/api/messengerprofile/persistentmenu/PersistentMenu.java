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


/**
 * The Class PersistentMenu.
 * 
 * The persistent menu object holds all the objects necessary to create
 * a persistent menu. This includes Call To Action buttons and the ability
 * to disable the composer input.
 */
public class PersistentMenu implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The locale. */
	private String locale;
	
	/** The composer input disabled. */
	@SerializedName("composer_input_disabled")
	private boolean composerInputDisabled;
	
	/** The call to actions. */
	@SerializedName("call_to_actions")
	private List<Button> callToActions;
	
	/** The type. */
	private String type;
	
	/** The title. */
	private String title;
	
	/** The url. */
	private String url;
	
	/** The web view height ratio. */
	@SerializedName("webview_height_ratio")
	private String webViewHeightRatio;
	
	/**
	 * Instantiates a new persistent menu.
	 */
	public PersistentMenu() {}
	
	/**
	 * Instantiates a new persistent menu.
	 *
	 * @param locale the locale
	 * @param composerInputDisabled the composer input disabled
	 */
	public PersistentMenu(String locale, boolean composerInputDisabled) {
		this.locale = locale;
		this.composerInputDisabled = composerInputDisabled;
		this.callToActions = new ArrayList<Button>();
	}
	
	/**
	 * Instantiates a new persistent menu.
	 *
	 * @param locale the locale
	 * @param callToActions the call to actions
	 */
	public PersistentMenu(String locale, List<Button> callToActions) {
		this.locale = locale;
		this.callToActions = callToActions;
	}
	
	/**
	 * Instantiates a new persistent menu.
	 *
	 * @param locale the locale
	 * @param composerInputDisabled the composer input disabled
	 * @param callToActions the call to actions
	 */
	public PersistentMenu(String locale,boolean composerInputDisabled, List<Button> callToActions) {
		this.composerInputDisabled = composerInputDisabled;
		this.locale = locale;
		this.callToActions = callToActions;
	}
	
	
	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}
	
	/**
	 * Sets the locale.
	 *
	 * @param locale the new locale
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	/**
	 * Gets the composer input disabled.
	 *
	 * @return the composer input disabled
	 */
	public boolean getComposerInputDisabled() {
		return composerInputDisabled;
	}
	
	/**
	 * Sets the composer input disabled.
	 *
	 * @param composerInputDisabled the new composer input disabled
	 */
	public void setComposerInputDisabled(boolean composerInputDisabled) {
		this.composerInputDisabled = composerInputDisabled;
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
	 * Adds the call to action.
	 *
	 * @param callToAction the call to action
	 */
	public void addCallToAction(Button callToAction) {
		this.callToActions.add(callToAction);
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
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
	
	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Gets the web view height ratio.
	 *
	 * @return the web view height ratio
	 */
	public String getWebViewHeightRatio() {
		return webViewHeightRatio;
	}
	
	/**
	 * Sets the web view height ratio.
	 *
	 * @param webViewHeightRatio the new web view height ratio
	 */
	public void setWebViewHeightRatio(String webViewHeightRatio) {
		this.webViewHeightRatio = webViewHeightRatio;
	}
	
	
	
}
