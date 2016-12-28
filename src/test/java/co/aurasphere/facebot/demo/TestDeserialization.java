/**
 * 
 */
package co.aurasphere.facebot.demo;

import co.aurasphere.botmill.fb.internal.util.json.JsonUtils;
import co.aurasphere.botmill.fb.model.base.Payload;
import co.aurasphere.botmill.fb.model.incoming.MessageEnvelope;
import co.aurasphere.botmill.fb.model.outcoming.payload.UrlPayload;

/**
 * @author Donato Rimenti
 * @date Dec 27, 2016
 */
public class TestDeserialization {
	
	public static void main(String[] args) {
		String json = "{\"sender\":{\"id\":\"USER_ID\"},\"recipient\":{\"id\":\"PAGE_ID\"},\"timestamp\":1458692752478,\"message\":{\"mid\":\"mid.1458696618141:b4ef9d19ec21086067\",\"seq\":51,\"attachments\":[{\"type\":\"image\",\"payload\":{\"url\":\"IMAGE_URL\"}}]}}";
		MessageEnvelope envelope = JsonUtils.fromJson(json, MessageEnvelope.class);
		Payload payload = envelope.getMessage().getAttachments().get(0).getPayload();
		
		UrlPayload actualPayload = (UrlPayload) payload;
		
		System.out.println(actualPayload.getUrl());
	}

}
