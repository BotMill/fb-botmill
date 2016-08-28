package co.aurasphere.facebot.model.outcoming.payload;

import org.hibernate.validator.constraints.NotEmpty;

public class UrlPayload implements Payload {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String url;
	
	public UrlPayload(String url){
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
