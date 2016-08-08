package co.aurasphere.facebot.model.outcoming.payload;

public class UrlPayload extends Payload {

	private static final long serialVersionUID = 1L;

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
