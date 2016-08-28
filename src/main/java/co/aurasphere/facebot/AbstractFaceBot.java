package co.aurasphere.facebot;

import co.aurasphere.facebot.actionframe.ActionFrame;
import co.aurasphere.facebot.autoreply.AutoReply;
import co.aurasphere.facebot.event.FaceBotEvent;

public abstract class AbstractFaceBot implements FaceBotDefinition{
	
	protected FaceBot faceBot;
	
	public AbstractFaceBot(){
		this.faceBot = new FaceBot();
	}
	
	protected void addActionFrame(ActionFrame actionFrame){
		faceBot.addActionFrame(actionFrame);
	}
	
	protected void addActionFrame(FaceBotEvent event, AutoReply reply){
		faceBot.addActionFrame(event, reply);
	}

}
