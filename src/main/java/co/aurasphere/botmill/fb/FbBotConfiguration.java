package co.aurasphere.botmill.fb;

import co.aurasphere.botmill.core.internal.util.ConfigurationUtils;

public abstract class FbBotConfiguration {

	/** The Constant FB_BOTMILL_PAGE_TOKEN. */
	private static final String FB_BOTMILL_PAGE_TOKEN = "fb.page.token";

	/** The Constant FB_BOTMILL_VALIDATION_TOKEN. */
	private static final String FB_BOTMILL_VALIDATION_TOKEN = "fb.validation.token";

	public FbBotConfiguration() {
		this.buildFbBotConfig();
	}

	/**
	 * Builds the Fb bot config.
	 *
	 * @throws BotMillMissingConfigurationException
	 *             the bot mill missing configuration exception
	 */
	private void buildFbBotConfig() {

		FbBotMillContext.getInstance().setup(
				ConfigurationUtils.getEncryptedConfiguration().getProperty(FB_BOTMILL_PAGE_TOKEN),
				ConfigurationUtils.getEncryptedConfiguration().getProperty(FB_BOTMILL_VALIDATION_TOKEN));

	}
}
