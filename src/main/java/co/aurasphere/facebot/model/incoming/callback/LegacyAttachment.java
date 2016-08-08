package co.aurasphere.facebot.model.incoming.callback;

import co.aurasphere.facebot.model.base.Attachment;

public class LegacyAttachment extends Attachment {

	private static final long serialVersionUID = 1L;
	
	private String title;
	
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
