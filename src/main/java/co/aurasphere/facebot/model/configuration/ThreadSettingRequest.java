package co.aurasphere.facebot.model.configuration;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Base request for a Thread Setting configuration.
 * 
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 * 
 * @author Donato
 * @date 08/ago/2016
 */
public abstract class ThreadSettingRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The type of setting to change.
	 */
	@SerializedName("setting_type")
	protected SettingType type;

	public SettingType getType() {
		return type;
	}

	public void setType(SettingType type) {
		this.type = type;
	}
}
