package co.aurasphere.botmill.fb.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import co.aurasphere.botmill.core.internal.util.ConfigurationUtils;
import co.aurasphere.botmill.fb.internal.util.json.FbBotMillJsonUtils;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.incoming.handler.IncomingToOutgoingMessageHandler;

/**
 * This is a Test Class to test the Fully Annotated Template
 * @author Alvin
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
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1423903854504468\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"Hi\"}}";
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
}
