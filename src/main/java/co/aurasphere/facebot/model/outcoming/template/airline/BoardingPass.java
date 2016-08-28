package co.aurasphere.facebot.model.outcoming.template.airline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.SerializedName;

public class BoardingPass implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@SerializedName("passenger_name")
	private String passengerName;

	@NotEmpty
	@SerializedName("pnr_number")
	private String pnrNumber;
	
	@SerializedName("travel_class")
	private TravelClass travelClass;
	
	private String seat;
	
	@Size(max=5)
	@SerializedName("auxiliary_fields")
	private List<Field> auxiliaryFields;
	
	@Size(max=5)
	@SerializedName("secondary_fields")
	private List<Field> secondaryFields;
	
	@NotEmpty
	@SerializedName("logo_image_url")
	private String logoImageUrl;
	
	@SerializedName("header_image_url")
	private String headerImageUrl;
	
	@SerializedName("header_text_field")
	private String headerTextField;
	
	@SerializedName("qr_code")
	private String qrCode;
	
	@SerializedName("barcode_image_url")
	private String barcodeImageUrl;
	
	@NotEmpty
	@SerializedName("above_bar_code_image_url")
	private String aboveBarCodeImageUrl;
	
	@Valid
	@NotNull
	@SerializedName("flight_info")
	private FlightInfo flightInfo;
	
	public BoardingPass(String passengerName, String pnrNumber, String logoImageUrl, String aboveBarCodeImageUrl){
		this.passengerName = passengerName;
		this.pnrNumber = pnrNumber;
		this.logoImageUrl = logoImageUrl;
		this.aboveBarCodeImageUrl = aboveBarCodeImageUrl;
		this.auxiliaryFields = new ArrayList<Field>();
		this.secondaryFields = new ArrayList<Field>();
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public TravelClass getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(TravelClass travelClass) {
		this.travelClass = travelClass;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public List<Field> getAuxiliaryFields() {
		return auxiliaryFields;
	}

	public void setAuxiliaryFields(List<Field> auxiliaryFields) {
		this.auxiliaryFields = auxiliaryFields;
	}

	public List<Field> getSecondaryFields() {
		return secondaryFields;
	}

	public void setSecondaryFields(List<Field> secondaryFields) {
		this.secondaryFields = secondaryFields;
	}

	public String getLogoImageUrl() {
		return logoImageUrl;
	}

	public void setLogoImageUrl(String logoImageUrl) {
		this.logoImageUrl = logoImageUrl;
	}

	public String getHeaderImageUrl() {
		return headerImageUrl;
	}

	public void setHeaderImageUrl(String headerImageUrl) {
		this.headerImageUrl = headerImageUrl;
	}

	public String getHeaderTextField() {
		return headerTextField;
	}

	public void setHeaderTextField(String headerTextField) {
		this.headerTextField = headerTextField;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getBarcodeImageUrl() {
		return barcodeImageUrl;
	}

	public void setBarcodeImageUrl(String barcodeImageUrl) {
		this.barcodeImageUrl = barcodeImageUrl;
	}

	public String getAboveBarCodeImageUrl() {
		return aboveBarCodeImageUrl;
	}

	public void setAboveBarCodeImageUrl(String aboveBarCodeImageUrl) {
		this.aboveBarCodeImageUrl = aboveBarCodeImageUrl;
	}

	public FlightInfo getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(FlightInfo flightInfo) {
		this.flightInfo = flightInfo;
	}

	public void addAuxiliaryField(Field field) {
		this.auxiliaryFields.add(field);
	}
	
	public void addSecondaryField(Field field) {
		this.secondaryFields.add(field);
	}
}
