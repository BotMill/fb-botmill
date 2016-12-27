package co.aurasphere.botmill.fb.model.outcoming.template.receipt;

import java.io.Serializable;
import java.math.BigDecimal;

public class Adjustment implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	
	private BigDecimal amount;
	
	public Adjustment(){}
	
	public Adjustment(String name, BigDecimal amount){
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
