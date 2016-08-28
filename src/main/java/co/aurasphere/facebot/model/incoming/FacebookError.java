package co.aurasphere.facebot.model.incoming;

import com.google.gson.annotations.SerializedName;

public class FacebookError {
	
	private String message;
	
	private String type;
	
	private String code;
	
	@SerializedName("fbtrace_id")
	private String fbTraceId;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFbTraceId() {
		return fbTraceId;
	}

	public void setFbTraceId(String fbTraceId) {
		this.fbTraceId = fbTraceId;
	}

}
