package co.aurasphere.facebot.model.outcoming.factory;

import java.util.ArrayList;
import java.util.List;

import co.aurasphere.facebot.bean.FaceBotBean;
import co.aurasphere.facebot.model.outcoming.template.button.Button;
import co.aurasphere.facebot.validator.FaceBotValidator;

public abstract class ButtonBuilder extends FaceBotBean {

	protected List<Button> buttons;

	protected void addUrlButtonInternal(String title, String url) {
		if (this.buttons == null) {
			this.buttons = new ArrayList<Button>();
		}
		Button button = ButtonFactory.createUrlButton(title, url);
		this.buttons.add(button);
	}

	private Button phoneNumberButton() {
		// TODO
		return null;
	}

	protected void addPostbackButtonInternal(String title, String payload) {
		if (this.buttons == null) {
			this.buttons = new ArrayList<Button>();
		}
		Button button = ButtonFactory.createPostbackButton(title, payload);
		this.buttons.add(button);
	}

	protected void addButtonInternal(Button button) {
		if (this.buttons == null) {
			this.buttons = new ArrayList<Button>();
		}
		FaceBotValidator.notNull(button, "Button");
		this.buttons.add(button);
	}

}
