package co.aurasphere.botmill.fb.model.outcoming.template.button;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * The PriceList Class/Object.
 *
 * @author Alvin Reyes
 * 
 */
public class PriceList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The label. */
	@NotNull
	private String label;

	/** The amount. */
	@NotNull
	private String amount;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	

}
