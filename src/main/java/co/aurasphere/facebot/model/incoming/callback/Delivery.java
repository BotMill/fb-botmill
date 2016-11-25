package co.aurasphere.facebot.model.incoming.callback;

import java.io.Serializable;
import java.util.List;

/**
 * Object which represents a message_deliveries callback.
 * 
 * @author Donato Rimenti
 * @date Aug 08, 2016
 */
public class Delivery implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Messages IDs.
	 */
	private List<String> mids;
	
	/**
	 * All messages before this timestamp where seen.
	 */
	private String watermark;
	
	/**
	 * Sequence number.
	 */
	private String seq;

	public List<String> getMids() {
		return mids;
	}

	public void setMids(List<String> mids) {
		this.mids = mids;
	}

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
