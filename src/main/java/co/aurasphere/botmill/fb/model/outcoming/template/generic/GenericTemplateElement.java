package co.aurasphere.botmill.fb.model.outcoming.template.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import co.aurasphere.botmill.fb.model.outcoming.template.button.Button;

import com.google.gson.annotations.SerializedName;


/**
 * The Class GenericTemplateElement.
 */
// TODO: test with generic template element without buttons and generic template without elements (if possible)
public class GenericTemplateElement implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The title. */
	@Size(max=80)
	@NotBlank
	private String title;
	
	/** The item url. */
	@SerializedName("item_url")
	private String itemUrl;
	
	/** The image url. */
	@SerializedName("image_url")
	private String imageUrl;
	
	/** The subtitle. */
	@Size(max=80)
	private String subtitle;
	
	/** The buttons. */
	@Valid
	@Size(max=3)
	private List<Button> buttons;

	/**
	 * Instantiates a new generic template element.
	 *
	 * @param title the title
	 */
	public GenericTemplateElement(String title){
		this.title = title;
		this.buttons = new ArrayList<Button>();
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the item url.
	 *
	 * @return the item url
	 */
	public String getItemUrl() {
		return itemUrl;
	}

	/**
	 * Sets the item url.
	 *
	 * @param itemUrl the new item url
	 */
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	/**
	 * Gets the image url.
	 *
	 * @return the image url
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Sets the image url.
	 *
	 * @param imageUrl the new image url
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		
	}

	/**
	 * Gets the subtitle.
	 *
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * Sets the subtitle.
	 *
	 * @param subtitle the new subtitle
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * Gets the buttons.
	 *
	 * @return the buttons
	 */
	public List<Button> getButtons() {
		return buttons;
	}

	/**
	 * Sets the buttons.
	 *
	 * @param buttons the new buttons
	 */
	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	/**
	 * Adds the button.
	 *
	 * @param button the button
	 */
	public void addButton(Button button) {
		this.buttons.add(button);
	}
}
