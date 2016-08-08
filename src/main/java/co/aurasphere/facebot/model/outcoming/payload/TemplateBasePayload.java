package co.aurasphere.facebot.model.outcoming.payload;

import com.google.gson.annotations.SerializedName;

public class TemplateBasePayload extends Payload{

	private static final long serialVersionUID = 1L;
	
	@SerializedName("template_type")
	protected PayloadType templateType;

	public PayloadType getTemplateType() {
		return templateType;
	}

	public void setTemplateType(PayloadType templateType) {
		this.templateType = templateType;
	}
	
	
}
