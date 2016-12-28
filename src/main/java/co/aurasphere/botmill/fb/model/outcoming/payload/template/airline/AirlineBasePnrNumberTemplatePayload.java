package co.aurasphere.botmill.fb.model.outcoming.payload.template.airline;

import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.annotations.SerializedName;

/**
 * The Class AirlineBasePnrNumberTemplatePayload.
 */
public abstract class AirlineBasePnrNumberTemplatePayload extends
		AirlineBaseTemplatePayload {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pnr number. */
	@NotBlank
	@SerializedName("pnr_number")
	private String pnrNumber;

	/**
	 * Instantiates a new airline base pnr number template payload.
	 *
	 * @param introMessage
	 *            the intro message
	 * @param locale
	 *            the locale
	 * @param pnrNumber
	 *            the pnr number
	 */
	public AirlineBasePnrNumberTemplatePayload(String introMessage,
			String locale, String pnrNumber) {
		super(introMessage, locale);
		this.pnrNumber = pnrNumber;
	}

	/**
	 * Instantiates a new AirlineBasePnrNumberTemplatePayload.
	 */
	public AirlineBasePnrNumberTemplatePayload() {
	}

	/**
	 * Gets the pnr number.
	 *
	 * @return the pnr number
	 */
	public String getPnrNumber() {
		return pnrNumber;
	}

	/**
	 * Sets the pnr number.
	 *
	 * @param pnrNumber
	 *            the new pnr number
	 */
	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

}
