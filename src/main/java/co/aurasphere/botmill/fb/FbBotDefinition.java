package co.aurasphere.botmill.fb;

/**
 * An interface that represents the base configuration of a {@link FbBot}. To
 * configure your bot, you will need a class that implements this interface. The
 * class that implements this interface should then registered into your web.xml
 * as an init-param for the {@link FbBotMillServlet}.
 * 
 * @author Donato Rimenti
 * 
 */
public interface FbBotDefinition {

	/**
	 * Method used for the configuration of the bots. This method should
	 * accomplish the following things:
	 * <ul>
	 * <li>register your webhook validation token and your page validation token
	 * using {@link FbBotMillContext#setup(String, String)}</li>
	 * <li>instantiate and define one or more {@link FbBot}</li>
	 * </ul>
	 */
	public void defineBehavior();

}
