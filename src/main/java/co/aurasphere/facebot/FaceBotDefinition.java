package co.aurasphere.facebot;


/**
 * An interface that represents the base configuration of a {@link FaceBot}. To
 * configure your bot, you will need a class that implements this interface. The
 * class that implements this interface should then registered into your web.xml
 * as an init-param for the {@link FaceBotServlet}.
 * 
 * @author Donato Rimenti
 * @date Jul 31, 2016
 */
public interface FaceBotDefinition {

	/**
	 * Method used for the configuration of the FaceBots. This method should
	 * accomplish the following things:
	 * <ul>
	 * <li>register your webhook validation token to the {@link FaceBotContext}
	 * using {@link FaceBotContext#setValidationToken(String)}</li>
	 * <li>register your page validation token to the FaceBotContext using
	 * {@link FaceBotContext#setPageToken(String)}</li>
	 * <li>instantiate and define one or more {@link FaceBot}</li>
	 * </ul>
	 */
	public void defineBehavior();

}
