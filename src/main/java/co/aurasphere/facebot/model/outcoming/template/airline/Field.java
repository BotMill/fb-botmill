package co.aurasphere.facebot.model.outcoming.template.airline;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class Field implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String label;
	
	@NotEmpty
	private String value;
	
	public Field(String label, String value){
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
