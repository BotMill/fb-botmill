package co.aurasphere.botmill.fb;


/**
 * An interface that represents the base configuration of a {@link FbBot}. To
 * configure your bot, you will need a class that implements this interface. The
 * class that implements this interface should then registered into your web.xml
 * as an init-param for the {@link FbBotMillServlet}.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public interface FbBotDefinition {

	/**
	 * Method used for the configuration of the FaceBots. This method should
	 * accomplish the following things:
	 * <ul>
	 * <li>register your webhook validation token to the {@link FbBotMillContext}
	 * using {@link FbBotMillContext#setValidationToken(String)}</li>
	 * <li>register your page validation token to the FaceBotContext using
	 * {@link FbBotMillContext#setPageToken(String)}</li>
	 * <li>instantiate and define one or more {@link FbBot}</li>
	 * </ul>
	 */
	public void defineBehavior();

}
