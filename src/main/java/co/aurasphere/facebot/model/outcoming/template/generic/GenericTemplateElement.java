package co.aurasphere.facebot.model.outcoming.template.generic;

import java.io.Serializable;
import java.util.List;

import co.aurasphere.facebot.model.outcoming.template.button.Button;

import com.google.gson.annotations.SerializedName;

public class GenericTemplateElement implements Serializable{

	private static final long serialVersionUID = 1L;

	private String title;
	
	@SerializedName("item_url")
	private String itemUrl;
	
	@SerializedName("image_url")
	private String imageUrl;
	
	private String subtitle;
	
	private List<Button> buttons;

	public GenericTemplateElement(String title){
		this.title = title;
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
}
