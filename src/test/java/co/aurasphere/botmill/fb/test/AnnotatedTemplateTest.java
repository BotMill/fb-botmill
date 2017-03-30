package co.aurasphere.botmill.fb.test;

import static org.junit.Assert.assertNotNull;

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

	@Test
	public void testAnnotatedBot() {
		//String json = "{\"sender\":{\"id\":\"1152902104831488\"},\"recipient\":{\"id\":\"1209810882431614\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"Hi\"}}";
		//String json = "{\"sender\":{\"id\":\"1152902104831488\"},\"recipient\":{\"id\":\"1209810882431614\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"Hi\"}}";
		String json = "{\"sender\":{\"id\":\"1158621824216736\"},\"recipient\":{\"id\":\"1423903854504468\"},\"timestamp\":1490832021661,\"message\":{\"mid\":\"mid.$cAAUPCFn4ymdhTcignVbHH3rzpKd_\",\"seq\":844819,\"text\":\"Hi\"}}";
		MessageEnvelope envelope = FbBotMillJsonUtils.fromJson(json, MessageEnvelope.class);
		ConfigurationUtils.loadEncryptedConfigurationProperties(); // loads the annotated encryption class.
		ConfigurationUtils.loadBotDefinitions(); // loads the annotated bot.
		IncomingToOutgoingMessageHandler.createHandler().process(envelope);
		
		assertNotNull(envelope);
	}
}
