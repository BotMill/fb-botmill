package co.aurasphere.facebot.model.outcoming.payload.template.airline;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.facebot.model.outcoming.payload.PayloadType;
import co.aurasphere.facebot.model.outcoming.template.airline.BoardingPass;

import com.google.gson.annotations.SerializedName;

public class AirlineBoardingPassTemplatePayload extends AirlineBaseTemplatePayload{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@SerializedName("boarding_pass")
	private List<BoardingPass> boardingPass; 
	
	public AirlineBoardingPassTemplatePayload(String introMessage, String locale){
		super(introMessage, locale);
		this.boardingPass = new ArrayList<BoardingPass>();
		this.templateType = PayloadType.AIRLINE_BOARDINGPASS;
	}

	public List<BoardingPass> getBoardingPass() {
		return boardingPass;
	}

	public void setBoardingPass(List<BoardingPass> boardingPass) {
		this.boardingPass = boardingPass;
	}

	public void addBoardingPass(BoardingPass boardingPass) {
		this.boardingPass.add(boardingPass);
	}

}
