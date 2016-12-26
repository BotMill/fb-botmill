package co.aurasphere.botmill.fb.model.outcoming.factory;

import co.aurasphere.botmill.fb.model.outcoming.quickreply.QuickReply;

public class QuickReplyFactory {
	
	public static QuickReply addQuickReply(String title, String payload) {
		return new QuickReply(title, payload);
	}
	
	public static QuickReply addQuickReplyLocation(String location) {
		return new QuickReply(location);
	}
	
	public static QuickReply addQuickReplyLocation(String title, String payload, String imageUrl) {
		return new QuickReply(title, payload, imageUrl);
	}

}
