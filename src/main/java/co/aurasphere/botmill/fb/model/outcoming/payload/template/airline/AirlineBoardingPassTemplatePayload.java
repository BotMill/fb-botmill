/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
public class AirlineBoardingPassTemplatePayload extends
		AirlineBaseTemplatePayload {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The boarding pass. */
	@NotEmpty
	@SerializedName("boarding_pass")
	private List<BoardingPass> boardingPass;

	/**
	 * Instantiates a new airline boarding pass template payload.
	 *
	 * @param introMessage
	 *            the intro message
	 * @param locale
	 *            the locale
	 */
	public AirlineBoardingPassTemplatePayload(String introMessage, String locale) {
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
	 * @param boardingPass
	 *            the new boarding pass
	 */
	public void setBoardingPass(List<BoardingPass> boardingPass) {
		this.boardingPass = boardingPass;
	}

	/**
	 * Adds the boarding pass.
	 *
	 * @param boardingPass
	 *            the boarding pass
	 */
	public void addBoardingPass(BoardingPass boardingPass) {
		this.boardingPass.add(boardingPass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.
	 * AirlineBaseTemplatePayload#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((boardingPass == null) ? 0 : boardingPass.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.
	 * AirlineBaseTemplatePayload#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirlineBoardingPassTemplatePayload other = (AirlineBoardingPassTemplatePayload) obj;
		if (boardingPass == null) {
			if (other.boardingPass != null)
				return false;
		} else if (!boardingPass.equals(other.boardingPass))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.botmill.fb.model.outcoming.payload.template.airline.
	 * AirlineBaseTemplatePayload#toString()
	 */
	@Override
	public String toString() {
		return "AirlineBoardingPassTemplatePayload [boardingPass="
				+ boardingPass + ", templateType=" + templateType + "]";
	}

}
