package co.aurasphere.facebot.demo;

import co.aurasphere.facebot.FaceBotContext;
import co.aurasphere.facebot.demo.behavior.AirplaneBehavior;
import co.aurasphere.facebot.demo.behavior.TemplateBehavior;
import co.aurasphere.facebot.test.support.FbBotMillMockMediator;
import static co.aurasphere.facebot.demo.FaceBotDemoConstants.*;

public class FaceBotDemo {
	
	public static void main(String[] args) {
		
		// Configuration.
		FbBotMillContext.getInstance().setup(PAGE_TOKEN, VALIDATION_TOKEN);
		
		// Instantiating the testing framework and starting the interactive test.
		FbBotMillMockMediator mediator = FbBotMillMockMediator.getInstance(MOCK_FACEBOOK_ID, TemplateBehavior.class, AirplaneBehavior.class);
		mediator.interactiveTest();
	}

}
