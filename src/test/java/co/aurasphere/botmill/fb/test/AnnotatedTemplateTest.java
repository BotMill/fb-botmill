package co.aurasphere.botmill.fb.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import co.aurasphere.botmill.core.BotDefinition;
import co.aurasphere.botmill.core.internal.util.ConfigurationUtils;
import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.internal.util.json.FbBotMillJsonUtils;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.handler.IncomingToOutgoingMessageHandler;
import co.aurasphere.botmill.fb.test.autoreply.template.AnnotatedTemplatedBehaviourTest;

/**
 * This is a Test Class to test the Fully Annotated Template
 * @author Alvin Reyes
 *
 */
public class AnnotatedTemplateTest {

	@Before
	public void setup() {
		Assume.assumeTrue(isConfigurationExist());
		FbBotMillContext.getInstance().setup(System.getenv("fb.page.token"), System.getenv("fb.validation.token"));
		
		//	Load the Bot manually.
		List<BotDefinition> botDefs = new ArrayList<BotDefinition>();
		botDefs.add(new AnnotatedTemplatedBehaviourTest());
		ConfigurationUtils.setBotDefinitionInstance(botDefs);
	}
	
	@Test
	public void testAnnotatedBot() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1226565047419159\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"Hi!\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	@Test
	public void testImageBot() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1226565047419159\"},\"timestamp\":1491360469304,\"message\":{\"mid\":\"mid.$cAACFqTvPOHVhbUgZOFbO_0AFXqVh\",\"seq\":854986,\"attachments\":[{\"type\":\"image\",\"payload\":{\"url\":\"https:\\/\\/scontent.xx.fbcdn.net\\/v\\/t34.0-12\\/17742285_136721643528794_1945065811_n.gif?_nc_ad=z-m&oh=97198065e4ede9bd09330764a7bfb62f&oe=58E6A075\"}}]}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	

	@Test
	public void testAnnotatedListTemplateBot() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1226565047419159\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"list template\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	@Test
	public void testAnnotatedButtonTemplateBot() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1226565047419159\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"button template\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	@Test
	public void testAnnotatedQuickReplyTemplateBot() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1226565047419159\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"quick replies\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	@Test
	public void testAnnotatedReusableImage() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1226565047419159\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"reuse image\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	@Test
	public void testAnnotatedReusableVideo() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1226565047419159\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"reuse video\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	@Test
	public void testAnnotatedReceiptTemplateBot() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1226565047419159\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"receipt template\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	@Test
	public void testBuyButton() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1226565047419159\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"buy button\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	private boolean isConfigurationExist() {
		if(System.getenv("fb.page.token") != null && System.getenv("fb.validation.token") != null) {
			return true;
		}
		return false;
	}

	
	public static void main(String[] args) {
		StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
		enc.setPassword("password"); // can be sourced out
		ConfigurationUtils.loadEncryptedConfigurationFile(enc, "botmill.properties");
		
		List<BotDefinition> botDef = new ArrayList<BotDefinition>();
		botDef.add(new AnnotatedTemplatedBehaviourTest());
		ConfigurationUtils.loadBotConfig();
		ConfigurationUtils.setBotDefinitionInstance(botDef);
		
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1226565047419159\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"Hi!\"}}";
				MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
				@Override
				public void run() {
					try {
						IncomingToOutgoingMessageHandler.getInstance().process(envelope);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	
	
	
}
