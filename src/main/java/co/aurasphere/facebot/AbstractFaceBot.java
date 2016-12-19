package co.aurasphere.facebot;

import java.util.List;

import co.aurasphere.facebot.actionframe.ActionFrame;
import co.aurasphere.facebot.autoreply.AutoReply;
import co.aurasphere.facebot.event.FaceBotEvent;

/**
 * Base {@link FaceBotDefinition} implementation that takes care of the
 * {@link FaceBot} handling.
 * 
 * @author Donato Rimenti
 * @date Sep 25, 2016
 */
public abstract class AbstractFaceBot implements FaceBotDefinition {

	/**
	 * The {@link FaceBot} object handled by this class.
	 */
	protected FaceBot faceBot;

	/**
	 * Base constructor. Instantiates a {@link FaceBot} and registers it to the
	 * context.
	 */
	public AbstractFaceBot() {
		this.faceBot = new FaceBot();
	}

	/**
	 * Adds an {@link ActionFrame} to the current FaceBot.
	 * 
	 * @param actionFrame the ActionFrame to add.
	 */
	protected void addActionFrame(ActionFrame actionFrame) {
		faceBot.addActionFrame(actionFrame);
	}

	/**
	 * Adds an {@link ActionFrame} to the current FaceBot.
	 * 
	 * @param event the {@link FaceBotEvent} that triggers the ActionFrame.
	 * @param reply the {@link AutoReply} to return when the event is triggered.
	 */
	protected void addActionFrame(FaceBotEvent event, AutoReply reply) {
		faceBot.addActionFrame(event, reply);
	}
	
	/**
	 * Adds an {@link ActionFrame} to the current FaceBot.
	 * 
	 * @param event the {@link FaceBotEvent} that triggers the ActionFrame.
	 * @param replies the list of {@link AutoReply} to return when the event is triggered.
	 */
	protected void addActionFrame(FaceBotEvent event, List<AutoReply> replies) {
		for(AutoReply reply:replies) {
			faceBot.addActionFrame(event, reply);
		}
	}
	
	/**
	 * Adds an {@link ActionFrame} to the current FaceBot.
	 * 
	 * @param event the {@link FaceBotEvent} that triggers the ActionFrame.
	 * @param replies the list of {@link AutoReply} to return when the event is triggered.
	 */
	protected void addActionFrame(FaceBotEvent event, AutoReply... replies) {
		for(AutoReply reply:replies) {
			faceBot.addActionFrame(event, reply);
		}
	}

}
