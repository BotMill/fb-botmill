package co.aurasphere.botmill.fb.demo;

import static co.aurasphere.botmill.fb.demo.FbBotMillDemoConstants.*;

import co.aurasphere.botmill.fb.demo.behavior.AirplaneBehavior;
import co.aurasphere.botmill.fb.demo.behavior.NumberTriviaBehaviour;
import co.aurasphere.botmill.fb.demo.behavior.TemplateBehavior;
import co.aurasphere.botmill.fb.demo.behavior.ThubBotBehavior;
import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.test.support.FbBotMillMockMediator;


/**
 * The Class FbBotMillDemo.
 */
public class FbBotMillDemo {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		// Configuration.
		FbBotMillContext.getInstance().setup(PAGE_TOKEN, VALIDATION_TOKEN);
		
		// Instantiating the testing framework and starting the interactive test.
		FbBotMillMockMediator mediator = FbBotMillMockMediator.getInstance(MOCK_FACEBOOK_ID, ThubBotBehavior.class, AirplaneBehavior.class);
		mediator.interactiveTest();
	}

}
