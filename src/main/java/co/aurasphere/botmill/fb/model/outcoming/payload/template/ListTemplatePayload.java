package co.aurasphere.botmill.fb.model.outcoming.payload.template;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;
import co.aurasphere.botmill.fb.model.outcoming.template.list.ListTemplateElement;
import co.aurasphere.botmill.fb.model.outcoming.template.list.TopElementStyle;

import com.google.gson.annotations.SerializedName;


/**
 * The ListTemplatePayload.
 * @author Alvin Reyes
 * @date 22/Nov/2016
 * 
 */
public class ListTemplatePayload extends TemplateBasePayload {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The elements. */
	@Valid
	@Size(max = 10)
	@NotEmpty
	private List<ListTemplateElement> elements;
	
	/** The buttons. */
	@Valid
	@Size(max = 1)
	@NotEmpty
	private List<Button> buttons;

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
	 */
	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	/** The top element style. */
	@SerializedName("top_element_style")
	private TopElementStyle topElementStyle;

	/**
	 * Gets the top element style.
	 *
	 * @return the top element style
	 */
	public TopElementStyle getTopElementStyle() {
		return topElementStyle;
	}

	/**
	 * Sets the top element style.
	 *
	 * @param topElementStyle the new top element style
	 */
	public void setTopElementStyle(TopElementStyle topElementStyle) {
		this.topElementStyle = topElementStyle;
	}

	/**
	 * Instantiates a new list template payload.
	 */
	public ListTemplatePayload() {
		this.templateType = PayloadType.LIST;
		this.elements = new ArrayList<ListTemplateElement>();
		this.buttons = new ArrayList<Button>();
	}

	/**
	 * Instantiates a new list template payload.
	 *
	 * @param elements the elements
	 */
	public ListTemplatePayload(List<ListTemplateElement> elements) {
		this();
		this.elements = elements;
	}
	
	/**
	 * Instantiates a new list template payload.
	 *
	 * @param elements the elements
	 * @param buttons the buttons
	 */
	public ListTemplatePayload(List<ListTemplateElement> elements, List<Button> buttons) {
		this();
		this.elements = elements;
		this.buttons = buttons;
	}

	/**
	 * Gets the elements.
	 *
	 * @return the elements
	 */
	public List<ListTemplateElement> getElements() {
		return elements;
	}

	/**
	 * Sets the elements.
	 *
	 * @param elements the new elements
	 */
	public void setElements(List<ListTemplateElement> elements) {
		this.elements = elements;
	}

	/**
	 * Adds the element.
	 *
	 * @param element the element
	 */
	public void addElement(ListTemplateElement element) {
		this.elements.add(element);
	}
	
	/**
	 * Adds the button.
	 *
	 * @param button the button
	 */
	public void addButton(Button button) {
		this.buttons.add(button);
	}
}
