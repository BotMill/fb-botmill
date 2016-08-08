package co.aurasphere.facebot.model.outcoming.payload;

import java.util.List;

import co.aurasphere.facebot.model.outcoming.template.button.Button;

public class ButtonTemplatePayload extends TemplateBasePayload{

	private static final long serialVersionUID = 1L;

	private String text;

	private List<Button> buttons;
	
	public ButtonTemplatePayload(List<Button> buttons, String text){
		this.text = text;
		this.buttons = buttons;
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
}
