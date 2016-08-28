package co.aurasphere.facebot.model.outcoming.payload.template.airline;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.facebot.model.outcoming.payload.template.TemplateBasePayload;

import com.google.gson.annotations.SerializedName;

public class AirlineBaseTemplatePayload extends TemplateBasePayload{

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@SerializedName("intro_message")
	private String introMessage;
	
	@NotEmpty
	@Pattern(regexp="[a-z]{2}_[A-Z]{2}", message="{locale.pattern.message}")
	private String locale;
	
	@Pattern(regexp="#\\d{6}", message="{theme.color.pattern.message}")
	@SerializedName("theme_color")
	private String themeColor;
	
	public AirlineBaseTemplatePayload(String introMessage, String locale) {
		this.introMessage = introMessage;
		this.locale = locale;
	}

	public String getIntroMessage() {
		return introMessage;
	}

	public void setIntroMessage(String introMessage) {
		this.introMessage = introMessage;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getThemeColor() {
		return themeColor;
	}

	public void setThemeColor(String themeColor) {
		this.themeColor = themeColor;
	}
	
}
