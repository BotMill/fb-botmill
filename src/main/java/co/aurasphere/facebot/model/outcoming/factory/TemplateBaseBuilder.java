package co.aurasphere.facebot.model.outcoming.factory;

/**
 * Base class for {@link FaceBotMockableBuilder} that builds a template.
 * 
 * @author Donato Rimenti
 * @date Aug 27, 2016
 */
public abstract class TemplateBaseBuilder extends FaceBotMockableBuilder {

	/**
	 * The delegated builder for a message containing a template.
	 */
	protected AttachmentMessageBuilder messageBuilder;

}
