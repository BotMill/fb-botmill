package co.aurasphere.botmill.fb.model.outcoming.payload.template;

import javax.validation.constraints.NotNull;

import co.aurasphere.botmill.fb.model.base.Payload;
import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;

import com.google.gson.annotations.SerializedName;


/**
 * A {@link Payload} which contains a Template.
 * 
 * @author Donato Rimenti
 * 
 */
public class TemplateBasePayload implements Payload {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The type of the template content.
	 */
	@NotNull
	@SerializedName("template_type")
	protected PayloadType templateType;

	/**
	 * Gets the {@link #templateType}.
	 *
	 * @return the {@link #templateType}.
	 */
	public PayloadType getTemplateType() {
		return templateType;
	}

	/**
	 * Sets the {@link #templateType}.
	 *
	 * @param templateType the {@link #templateType} to set.
	 */
	public void setTemplateType(PayloadType templateType) {
		this.templateType = templateType;
	}
	
}
