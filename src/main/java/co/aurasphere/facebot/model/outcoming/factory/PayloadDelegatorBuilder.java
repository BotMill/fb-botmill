package co.aurasphere.facebot.model.outcoming.factory;

import co.aurasphere.facebot.bean.FaceBotBean;
import co.aurasphere.facebot.model.outcoming.payload.Payload;

public abstract class PayloadDelegatorBuilder extends FaceBotBean implements FaceBotResponseBuilder{

	protected Payload payload;
	
	public void setPayload(Payload payload){
		this.payload = payload;
	}
	
}
