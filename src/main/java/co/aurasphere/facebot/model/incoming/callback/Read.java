package co.aurasphere.facebot.model.incoming.callback;

import java.io.Serializable;

public class Read implements Serializable{

	private static final long serialVersionUID = 1L;

	private String watermark;
	
	private String seq;

	public String getWatermark() {
		return watermark;
	}

	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}
}
