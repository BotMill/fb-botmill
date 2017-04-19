package co.aurasphere.botmill.fb.model.api.messengerprofile;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import co.aurasphere.botmill.fb.model.outcoming.template.button.WebViewHeightRatioType;
import co.aurasphere.botmill.fb.model.outcoming.template.button.WebViewShareButton;

public class HomeUrl implements Serializable {

	private static final long serialVersionUID = 1L;

	private String url;
	@SerializedName("webview_height_ratio")
	private WebViewHeightRatioType webviewHeightRatio;
	@SerializedName("webview_share_button")
	private WebViewShareButton webviewShareButton;
	@SerializedName("in_test")
	private boolean inTest;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public WebViewHeightRatioType getWebviewHeightRatio() {
		return webviewHeightRatio;
	}

	public void setWebviewHeightRatio(WebViewHeightRatioType webviewHeightRatio) {
		this.webviewHeightRatio = webviewHeightRatio;
	}

	public WebViewShareButton getWebviewShareButton() {
		return webviewShareButton;
	}

	public void setWebviewShareButton(WebViewShareButton webviewShareButton) {
		this.webviewShareButton = webviewShareButton;
	}

	public boolean isInTest() {
		return inTest;
	}

	public void setInTest(boolean inTest) {
		this.inTest = inTest;
	}

}
