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
package co.aurasphere.botmill.fb.model.outcoming.template.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;

import com.google.gson.annotations.SerializedName;


/**
 * The Class ListTemplateElement.
 * 
 * @author Alvin Reyes
 * 
 * 
 */
public class ListTemplateElement implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The title. */
	@Size(max = 80)
	@NotBlank
	private String title;

	/** The image url. */
	@SerializedName("image_url")
	private String imageUrl;

	/** The subtitle. */
	@Size(max = 80)
	private String subtitle;

	/** The buttons. */
	@Valid
	@Size(max = 3)
	private List<Button> buttons;
	
	/** The default action. */
	@SerializedName("default_action")
	private DefaultAction defaultAction;

	/**
	 * Gets the default action.
	 *
	 * @return the default action
	 */
	public DefaultAction getDefaultAction() {
		return defaultAction;
	}

	/**
	 * Sets the default action.
	 *
	 * @param defaultAction the new default action
	 * @return the list template element
	 */
	public ListTemplateElement setDefaultAction(DefaultAction defaultAction) {
		this.defaultAction = defaultAction;
		return this;
	}

	/**
	 * Instantiates a new list template element.
	 *
	 * @param title the title
	 */
	public ListTemplateElement(String title) {
		this.title = title;
		this.buttons = new ArrayList<Button>();
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
	 * @return the list template element
	 */
	public ListTemplateElement setTitle(String title) {
		this.title = title;
		return this;
	}

	/**
	 * Gets the image url.
	 *
	 * @return the image url
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Sets the image url.
	 *
	 * @param imageUrl the new image url
	 * @return the list template element
	 */
	public ListTemplateElement setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;

	}

	/**
	 * Gets the subtitle.
	 *
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * Sets the subtitle.
	 *
	 * @param subtitle the new subtitle
	 * @return the list template element
	 */
	public ListTemplateElement setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}

	/**
	 * Gets the buttons.
	 *
	 * @return the buttons
	 */
	public List<Button> getButtons() {
		return buttons;
	}

	/**
	 * Sets the buttons.
	 *
	 * @param buttons the new buttons
	 * @return the list template element
	 */
	public ListTemplateElement setButtons(List<Button> buttons) {
		this.buttons = buttons;
		return this;
	}

	/**
	 * Adds the button.
	 *
	 * @param button the button
	 * @return the list template element
	 */
	public ListTemplateElement addButton(Button button) {
		this.buttons.add(button);
		return this;
	}
}
