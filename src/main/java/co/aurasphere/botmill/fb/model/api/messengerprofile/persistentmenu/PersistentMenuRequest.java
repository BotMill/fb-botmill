/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.botmill.fb.model.api.messengerprofile.persistentmenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


/**
 * The Class PersistentMenuRequest.
 * 
 * The Persistent Menu Request is the main object we sent thru our post request which will
 * create the necessary JSON structured data to create the persistent menu of the bots
 * 
 * @author Alvin P. Reyes
 *
 */
public class PersistentMenuRequest implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The persistent menu. */
	@SerializedName("persistent_menu")
	private List<PersistentMenu> persistentMenu;

	
	/**
	 * Instantiates a new persistent menu request.
	 */
	public PersistentMenuRequest() {
		this.persistentMenu = new ArrayList<PersistentMenu>();
	}
	
	/**
	 * Gets the persistent menu.
	 *
	 * @return the persistent menu
	 */
	public List<PersistentMenu> getPersistentMenu() {
		return persistentMenu;
	}

	/**
	 * Sets the persistent menu.
	 *
	 * @param persistentMenu the new persistent menu
	 */
	public void setPersistentMenu(List<PersistentMenu> persistentMenu) {
		this.persistentMenu = persistentMenu;
	}
	
	/**
	 * Adds the persistent menu.
	 *
	 * @param persistentMenu the persistent menu
	 */
	public void addPersistentMenu(PersistentMenu persistentMenu) {
		this.persistentMenu.add(persistentMenu);
	}
	
	/**
	 * Adds the all persistent menu.
	 *
	 * @param persistentMenus the persistent menus
	 */
	public void addAllPersistentMenu(List<PersistentMenu> persistentMenus) {
		this.persistentMenu.addAll(persistentMenus);
	}	
	
}
