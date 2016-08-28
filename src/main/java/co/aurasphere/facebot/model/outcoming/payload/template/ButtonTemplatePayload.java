package co.aurasphere.facebot.model.outcoming.payload.template;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.facebot.model.outcoming.payload.PayloadType;
import co.aurasphere.facebot.model.outcoming.template.button.Button;

public class ButtonTemplatePayload extends TemplateBasePayload{

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String text;

	@Valid
	@Size(max=3)
	@NotEmpty
	private List<Button> buttons;
	
	public ButtonTemplatePayload(String text){
		this.text = text;
		this.buttons = new ArrayList<Button>();
		this.templateType = PayloadType.BUTTON;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	public void addButton(Button button) {
		this.buttons.add(button);
	}
}
