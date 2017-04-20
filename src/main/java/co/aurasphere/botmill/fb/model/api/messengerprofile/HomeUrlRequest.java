package co.aurasphere.botmill.fb.model.api.messengerprofile;

import com.google.gson.annotations.SerializedName;

public class HomeUrlRequest {

	@SerializedName("home_url")
	private HomeUrl homeUrl;

	public HomeUrl getHomeUrl() {
		return homeUrl;
	}

	public void setHomeUrl(HomeUrl homeUrl) {
		this.homeUrl = homeUrl;
	}
	
	
}
