package co.aurasphere.botmill.fb.model.outcoming.template.airline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;


/**
 * The Class PassengerSegmentInfo.
 */
public class PassengerSegmentInfo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The segment id. */
	@NotEmpty
	@SerializedName("segment_id")
	private String segmentId; 
	
	/** The passenger id. */
	@NotEmpty
	@SerializedName("passenger_id")
	private String passengerId;
	
	/** The seat. */
	@NotEmpty
	private String seat;
	
	/** The seat type. */
	@NotEmpty
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
