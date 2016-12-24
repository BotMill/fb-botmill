package co.aurasphere.botmill.fb.model.incoming.callback;

import java.io.Serializable;


/**
 * Model for a read message callback. <br/>
 * <br/>
 * This callback will occur when a message a page has sent has been read by the
 * user. You can subscribe to this callback by selecting the message_reads field
 * when <a href=
 * "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 * >setting up</a> your webhook.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference/message-read"
 *      >Facebook's Messenger Platform Read Message Callback Documentation</a>
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/webhook-reference#setup"
 *      >Facebook's Messenger Platform Webhook Setup Documentation</a>
 * @date Dec 24, 2016
 */
public class Read implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * All messages that were sent before this timestamp were read. The
	 * watermark field is used to determine which messages were read. It
	 * represents a timestamp indicating that all messages with a timestamp
	 * before watermark were read by the recipient.
	 */
	private String watermark;

	/**
	 * Sequence number.
	 */
	private String seq;

	/**
	 * Gets the {@link #watermark}.
	 *
	 * @return the {@link #watermark}.
	 */
	public String getWatermark() {
		return watermark;
	}

	/**
	 * Sets the {@link #watermark}.
	 *
	 * @param watermark the {@link #watermark} to set.
	 */
	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

	/**
	 * Gets the {@link #seq}.
	 *
	 * @return the {@link #seq}.
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * Sets the {@link #seq}.
	 *
	 * @param seq the {@link #seq} to set.
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
}
