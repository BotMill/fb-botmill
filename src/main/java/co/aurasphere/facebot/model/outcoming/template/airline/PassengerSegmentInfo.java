package co.aurasphere.facebot.model.outcoming.template.airline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

public class PassengerSegmentInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@SerializedName("segment_id")
	private String segmentId; 
	
	@NotEmpty
	@SerializedName("passenger_id")
	private String passengerId;
	
	@NotEmpty
	private String seat;
	
	@NotEmpty
	@SerializedName("seat_type")
	private String seatType;
	
	@Valid
	@Size(max=4)
	@NotEmpty
	@SerializedName("product_info")
	private List<ProductInfo> productInfo;
	
	public PassengerSegmentInfo(String segmentId, String passengerId, String seat, String seatType){
		this.productInfo = new ArrayList<ProductInfo>();
		this.segmentId = segmentId;
		this.passengerId = passengerId;
		this.seat = seat;
		this.seatType = seatType;
	}

	public String getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}

	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}
	
	public void addProductInfo(ProductInfo productInfo) {
		this.productInfo.add(productInfo);
	}

}
