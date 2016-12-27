package co.aurasphere.botmill.fb.model.threadsettings;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.google.gson.annotations.SerializedName;


/**
 * Base request for a Thread Setting configuration.
 *
 * @author Donato Rimenti
 * @see <a href=
 *      "https://developers.facebook.com/docs/messenger-platform/thread-settings"
 *      >Facebook's Messenger Platform Thread Settings Documentation</a>
 * @date Aug 08, 2016
 */
public abstract class ThreadSettingsBaseRequest implements Serializable {

	/**
	 * The serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The type of setting to change.
	 */
	@NotNull
	@SerializedName("setting_type")
	protected SettingType type;

	/**
	 * Gets the {@link #type}.
	 *
	 * @return the {@link #type}.
	 */
	public SettingType getType() {
		return type;
	}

	/**
	 * Sets the {@link #type}.
	 *
	 * @param type the {@link #type} to set.
	 */
	public void setType(SettingType type) {
		this.type = type;
	}
}
