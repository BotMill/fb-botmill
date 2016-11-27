package co.aurasphere.facebot.demo;

import static co.aurasphere.facebot.demo.FaceBotDemoConstants.MOCK_FACEBOOK_ID;
import static co.aurasphere.facebot.demo.FaceBotDemoConstants.PAGE_TOKEN;
import static co.aurasphere.facebot.demo.FaceBotDemoConstants.VALIDATION_TOKEN;
import co.aurasphere.facebot.FaceBotContext;
import co.aurasphere.facebot.demo.behavior.AirplaneBehavior;
import co.aurasphere.facebot.demo.behavior.TemplateBehavior;
import co.aurasphere.facebot.test.FaceBotMockMediator;

public class FaceBotDemo {
	
	public static void main(String[] args) {
		
		// Configuration.
		FaceBotContext.getInstance().setup(PAGE_TOKEN, VALIDATION_TOKEN);
		
		// Instantiating the testing framework and starting the interactive test.
		FaceBotMockMediator mediator = FaceBotMockMediator.getInstance(MOCK_FACEBOOK_ID, TemplateBehavior.class, AirplaneBehavior.class);
		mediator.interactiveTest();
	}

}
