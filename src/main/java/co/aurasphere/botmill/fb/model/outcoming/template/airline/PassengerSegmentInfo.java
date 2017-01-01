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
package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;


/**
 * The Class PassengerSegmentInfo.
 */
public class PassengerSegmentInfo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The segment id. */
	@NotBlank
	@SerializedName("segment_id")
	private String segmentId; 
	
	/** The passenger id. */
	@NotBlank
	@SerializedName("passenger_id")
	private String passengerId;
	
	/** The seat. */
	@NotBlank
	private String seat;
	
	/** The seat type. */
	@NotBlank
	@SerializedName("seat_type")
	private String seatType;
	
	/** The product info. */
	@Valid
	@Size(max=4)
	@NotEmpty
	@SerializedName("product_info")
	private List<ProductInfo> productInfo;
	
	/**
	 * Instantiates a new passenger segment info.
	 *
	 * @param segmentId the segment id
	 * @param passengerId the passenger id
	 * @param seat the seat
	 * @param seatType the seat type
	 */
	public PassengerSegmentInfo(String segmentId, String passengerId, String seat, String seatType){
		this.productInfo = new ArrayList<ProductInfo>();
		this.segmentId = segmentId;
		this.passengerId = passengerId;
		this.seat = seat;
		this.seatType = seatType;
	}

	/**
	 * Gets the segment id.
	 *
	 * @return the segment id
	 */
	public String getSegmentId() {
		return segmentId;
	}

	/**
	 * Sets the segment id.
	 *
	 * @param segmentId the new segment id
	 */
	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}

	/**
	 * Gets the passenger id.
	 *
	 * @return the passenger id
	 */
	public String getPassengerId() {
		return passengerId;
	}

	/**
	 * Sets the passenger id.
	 *
	 * @param passengerId the new passenger id
	 */
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	/**
	 * Gets the seat.
	 *
	 * @return the seat
	 */
	public String getSeat() {
		return seat;
	}

	/**
	 * Sets the seat.
	 *
	 * @param seat the new seat
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}

	/**
	 * Gets the seat type.
	 *
	 * @return the seat type
	 */
	public String getSeatType() {
		return seatType;
	}

	/**
	 * Sets the seat type.
	 *
	 * @param seatType the new seat type
	 */
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	/**
	 * Gets the product info.
	 *
	 * @return the product info
	 */
	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}

	/**
	 * Sets the product info.
	 *
	 * @param productInfo the new product info
	 */
	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}
	
	/**
	 * Adds the product info.
	 *
	 * @param productInfo the product info
	 */
	public void addProductInfo(ProductInfo productInfo) {
		this.productInfo.add(productInfo);
	}

}
