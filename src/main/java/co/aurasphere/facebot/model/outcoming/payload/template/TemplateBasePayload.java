package co.aurasphere.facebot.model.outcoming.payload.template;

import javax.validation.constraints.NotNull;

import co.aurasphere.facebot.model.outcoming.payload.Payload;
import co.aurasphere.facebot.model.outcoming.payload.PayloadType;

import com.google.gson.annotations.SerializedName;

public class TemplateBasePayload implements Payload{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@SerializedName("template_type")
	protected PayloadType templateType;

	public PayloadType getTemplateType() {
		return templateType;
	}

	public void setTemplateType(PayloadType templateType) {
		this.templateType = templateType;
	}
	
	
}
