package co.aurasphere.facebot.demo;

import co.aurasphere.facebot.FaceBotContext;
import co.aurasphere.facebot.demo.behavior.AirplaneBehavior;
import co.aurasphere.facebot.demo.behavior.TemplateBehavior;
import co.aurasphere.facebot.test.FaceBotMockMediator;
import static co.aurasphere.facebot.demo.FaceBotDemoConstants.*;

public class FaceBotDemo {
	
	public static void main(String[] args) {
		
		// Configuration.
		FaceBotContext.getInstance().setup(PAGE_TOKEN, VALIDATION_TOKEN);
		
		// Instantiating the testing framework and starting the interactive test.
		FaceBotMockMediator mediator = FaceBotMockMediator.getInstance(MOCK_FACEBOOK_ID, TemplateBehavior.class, AirplaneBehavior.class);
		mediator.interactiveTest();
	}

}
