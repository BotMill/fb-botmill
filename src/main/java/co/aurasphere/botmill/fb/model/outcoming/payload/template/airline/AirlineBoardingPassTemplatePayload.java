package co.aurasphere.botmill.fb.model.outcoming.payload.template.airline;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.botmill.fb.model.outcoming.payload.PayloadType;
import co.aurasphere.botmill.fb.model.outcoming.template.airline.BoardingPass;

import com.google.gson.annotations.SerializedName;


/**
 * The Class AirlineBoardingPassTemplatePayload.
 */
public class AirlineBoardingPassTemplatePayload extends AirlineBaseTemplatePayload{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The boarding pass. */
	@NotEmpty
	@SerializedName("boarding_pass")
	private List<BoardingPass> boardingPass; 
	
	/**
	 * Instantiates a new airline boarding pass template payload.
	 *
	 * @param introMessage the intro message
	 * @param locale the locale
	 */
	public AirlineBoardingPassTemplatePayload(String introMessage, String locale){
		super(introMessage, locale);
		this.boardingPass = new ArrayList<BoardingPass>();
		this.templateType = PayloadType.AIRLINE_BOARDINGPASS;
	}

	/**
	 * Instantiates a new AirlineBoardingPassTemplatePayload.
	 */
	public AirlineBoardingPassTemplatePayload() {
	}

	/**
	 * Gets the boarding pass.
	 *
	 * @return the boarding pass
	 */
	public List<BoardingPass> getBoardingPass() {
		return boardingPass;
	}

	/**
	 * Sets the boarding pass.
	 *
	 * @param boardingPass the new boarding pass
	 */
	public void setBoardingPass(List<BoardingPass> boardingPass) {
		this.boardingPass = boardingPass;
	}

	/**
	 * Adds the boarding pass.
	 *
	 * @param boardingPass the boarding pass
	 */
	public void addBoardingPass(BoardingPass boardingPass) {
		this.boardingPass.add(boardingPass);
	}

}
