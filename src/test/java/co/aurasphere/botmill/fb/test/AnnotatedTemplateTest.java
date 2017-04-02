package co.aurasphere.botmill.fb.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import co.aurasphere.botmill.core.internal.util.ConfigurationUtils;
import co.aurasphere.botmill.fb.internal.util.json.FbBotMillJsonUtils;
import co.aurasphere.botmill.fb.model.base.AttachmentType;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.handler.IncomingToOutgoingMessageHandler;
import co.aurasphere.botmill.fb.model.upload.UploadAttachmentResponse;
import co.aurasphere.botmill.fb.upload.FbBotMillUploadApi;

/**
 * This is a Test Class to test the Fully Annotated Template
 * @author Alvin Reyes
 *
 */
public class AnnotatedTemplateTest {

	
	@Before
	public void setup() {
		ConfigurationUtils.loadEncryptedConfigurationProperties(); // loads the annotated encryption class.
		ConfigurationUtils.loadBotDefinitions(); // loads the annotated bot.
	}
	
	@Test
	public void testAnnotatedBot() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1423903854504468\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"Hi!\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	

	@Test
	public void testAnnotatedListTemplateBot() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1423903854504468\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"list template\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	@Test
	public void testAnnotatedButtonTemplateBot() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1423903854504468\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"button template\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	@Test
	public void testAnnotatedQuickReplyTemplateBot() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1423903854504468\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"quick replies\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	@Test
	public void testAnnotatedReceiptTemplateBot() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1423903854504468\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"receipt template\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	@Test
	public void testBuyButton() {
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1423903854504468\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"buy button\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		IncomingToOutgoingMessageHandler.getInstance().process(envelope);
		assertNotNull(envelope);
	}
	
	public static void main(String[] args) {
		ConfigurationUtils.loadEncryptedConfigurationProperties(); // loads the annotated encryption class.
		ConfigurationUtils.loadBotDefinitions(); // loads the annotated bot.
		for(int i=0;i<100;i++) {
			new Thread(new Runnable() {
				String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1423903854504468\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"Hi!\"}}";
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
