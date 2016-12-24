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

	private static final long serialVersionUID = 1L;

	@Valid
	@Size(max = 10)
	@NotEmpty
	private List<ListTemplateElement> elements;
	
	@Valid
	@Size(max = 1)
	@NotEmpty
	private List<Button> buttons;

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	@SerializedName("top_element_style")
	private TopElementStyle topElementStyle;

	public TopElementStyle getTopElementStyle() {
		return topElementStyle;
	}

	public void setTopElementStyle(TopElementStyle topElementStyle) {
		this.topElementStyle = topElementStyle;
	}

	public ListTemplatePayload() {
		this.templateType = PayloadType.LIST;
		this.elements = new ArrayList<ListTemplateElement>();
		this.buttons = new ArrayList<Button>();
	}

	public ListTemplatePayload(List<ListTemplateElement> elements) {
		this();
		this.elements = elements;
	}
	
	public ListTemplatePayload(List<ListTemplateElement> elements, List<Button> buttons) {
		this();
		this.elements = elements;
		this.buttons = buttons;
	}

	public List<ListTemplateElement> getElements() {
		return elements;
	}

	public void setElements(List<ListTemplateElement> elements) {
		this.elements = elements;
	}

	public void addElement(ListTemplateElement element) {
		this.elements.add(element);
	}
	
	public void addButton(Button button) {
		this.buttons.add(button);
	}
}
