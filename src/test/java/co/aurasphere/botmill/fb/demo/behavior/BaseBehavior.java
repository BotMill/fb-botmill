package co.aurasphere.botmill.fb.demo.behavior;

import co.aurasphere.botmill.fb.AbstractFbBot;
import co.aurasphere.botmill.fb.FbBot;
import co.aurasphere.botmill.fb.FbBotMillPolicy;

/**
 * The Class BaseBehavior.
 */
public abstract class BaseBehavior extends AbstractFbBot {
	
	/**
	 * 
	 */
	public BaseBehavior() {
		this.fbBot = new FbBot(FbBotMillPolicy.FIRST_ONLY);
	}

}
