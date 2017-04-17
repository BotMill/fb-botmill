package co.aurasphere.botmill.fb.test.encryption;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import co.aurasphere.botmill.core.annotation.BotEncryption;
import co.aurasphere.botmill.core.internal.util.ConfigurationUtils;

@BotEncryption
public class DefaultEncryption {
	public DefaultEncryption() {
		StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
		enc.setPassword("password"); // can be sourced out
		ConfigurationUtils.loadEncryptedConfigurationFile(enc, "botmill.properties");
	}
}
