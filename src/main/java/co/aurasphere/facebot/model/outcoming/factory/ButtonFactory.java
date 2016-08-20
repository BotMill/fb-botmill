package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.model.outcoming.template.button.Button;
import co.aurasphere.facebot.model.outcoming.template.button.ButtonType;
import co.aurasphere.facebot.model.outcoming.template.button.PostbackButton;
import co.aurasphere.facebot.model.outcoming.template.button.WebUrlButton;
import co.aurasphere.facebot.util.FaceBotConstants;
import co.aurasphere.facebot.validator.FaceBotValidator;

public class ButtonFactory {

	public static Button createUrlButton(String title, String url) {
		FaceBotValidator.shorterThanNotEmpty(title,
				FaceBotConstants.BUTTON_TITLE_MAX_LENGTH, "Title");
		FaceBotValidator.notEmpty(url, "URL");
		return new WebUrlButton(title, url);
	}

	public static Button createPostbackButton(String title, String payload) {
		FaceBotValidator.shorterThanNotEmpty(title,
				FaceBotConstants.BUTTON_TITLE_MAX_LENGTH, "Title");
		FaceBotValidator.shorterThanNotEmpty(payload,
				FaceBotConstants.PAYLOAD_MAX_LENGTH, "Payload");
		return new PostbackButton(title, ButtonType.POSTBACK, payload);
	}

	public static Button createPhoneNumberButton(String title,
			String phoneNumber) {
		FaceBotValidator.shorterThanNotEmpty(title,
				FaceBotConstants.BUTTON_TITLE_MAX_LENGTH, "Title");
		FaceBotValidator.phoneNumberValid(phoneNumber, "Phone number");
		return new PostbackButton(title, ButtonType.PHONE_NUMBER, phoneNumber);
	}
}
