package co.aurasphere.facebot.model.outcoming.payload.template.airline;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

public abstract class AirlineBasePnrNumberTemplatePayload extends AirlineBaseTemplatePayload{

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@SerializedName("pnr_number")
	private String pnrNumber;
	
	public AirlineBasePnrNumberTemplatePayload(String introMessage, String locale, String pnrNumber){
		super(introMessage, locale);
		this.pnrNumber = pnrNumber;
	}

	public String getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

}
