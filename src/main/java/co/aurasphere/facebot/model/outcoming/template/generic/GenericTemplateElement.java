package co.aurasphere.facebot.model.outcoming.template.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import co.aurasphere.facebot.model.outcoming.template.button.Button;

import com.google.gson.annotations.SerializedName;

public class GenericTemplateElement implements Serializable{

	private static final long serialVersionUID = 1L;

	@Size(max=80)
	@NotEmpty
	private String title;
	
	@SerializedName("item_url")
	private String itemUrl;
	
	@SerializedName("image_url")
	private String imageUrl;
	
	@Size(max=80)
	private String subtitle;
	
	@Valid
	@Size(max=3)
	private List<Button> buttons;

	public GenericTemplateElement(String title){
		this.title = title;
		this.buttons = new ArrayList<Button>();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	public void addButton(Button button) {
		this.buttons.add(button);
	}
}
