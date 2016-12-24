package co.aurasphere.botmill.fb;

import java.util.List;

import co.aurasphere.botmill.fb.actionframe.ActionFrame;
import co.aurasphere.botmill.fb.autoreply.AutoReply;
import co.aurasphere.botmill.fb.event.FbBotMillEvent;

 
/**
 * Base {@link FbBotDefinition} implementation that takes care of the
 * {@link FbBot} handling.
 * 
 * @author Donato Rimenti
 * @date Sep 25, 2016
 */
public abstract class AbstractFbBot implements FbBotDefinition {

	/**
	 * The {@link FbBot} object handled by this class.
	 */
	protected FbBot fbBot;

	/**
	 * Base constructor. Instantiates a {@link FbBot} and registers it to the
	 * context.
	 */
	public AbstractFbBot() {
		this.fbBot = new FbBot();
	}

	/**
	 * Adds an {@link ActionFrame} to the current FaceBot.
	 * 
	 * @param actionFrame
	 *            the ActionFrame to add.
	 */
	protected void addActionFrame(ActionFrame actionFrame) {
		fbBot.addActionFrame(actionFrame);
	}

	/**
	 * Adds an {@link ActionFrame} to the current FaceBot.
	 * 
	 * @param event
	 *            the {@link FbBotMillEvent} that triggers the ActionFrame.
	 * @param reply
	 *            the {@link AutoReply} to return when the event is triggered.
	 */
	protected void addActionFrame(FbBotMillEvent event, AutoReply reply) {
		fbBot.addActionFrame(event, reply);
	}
	
	/**
	 * Adds an {@link ActionFrame} to the current FaceBot.
	 * 
	 * @param event the {@link FbBotMillEvent} that triggers the ActionFrame.
	 * @param replies the list of {@link AutoReply} to return when the event is triggered.
	 */
	protected void addActionFrame(FbBotMillEvent event, List<AutoReply> replies) {
		for(AutoReply reply:replies) {
			fbBot.addActionFrame(event, reply);
		}
	}
	
	/**
	 * Adds an {@link ActionFrame} to the current FaceBot.
	 * 
	 * @param event the {@link FbBotMillEvent} that triggers the ActionFrame.
	 * @param replies the list of {@link AutoReply} to return when the event is triggered.
	 */
	protected void addActionFrame(FbBotMillEvent event, AutoReply... replies) {
		for(AutoReply reply:replies) {
			fbBot.addActionFrame(event, reply);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fbBot == null) ? 0 : fbBot.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractFbBot other = (AbstractFbBot) obj;
		if (fbBot == null) {
			if (other.fbBot != null)
				return false;
		} else if (!fbBot.equals(other.fbBot))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractFaceBot [faceBot=" + fbBot + "]";
	}

}
