package co.aurasphere.facebot.model.outcoming.template.button;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * The PriceList Class/Object
 * 
 * @author Alvin Reyes
 * @date 27/Nov/2016
 * 
 */
public class PriceList implements Serializable{

	/** The label. */
	@NotNull
	private String label;
	
	/** The amount. */
	@NotNull
	private String amount;
	
	
}
