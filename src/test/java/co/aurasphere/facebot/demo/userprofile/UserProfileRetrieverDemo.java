package co.aurasphere.facebot.demo.userprofile;

import static co.aurasphere.facebot.demo.FaceBotDemoConstants.MOCK_FACEBOOK_ID;
import static co.aurasphere.facebot.demo.FaceBotDemoConstants.PAGE_TOKEN;
import static co.aurasphere.facebot.demo.FaceBotDemoConstants.VALIDATION_TOKEN;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.facebot.FaceBotContext;
import co.aurasphere.facebot.model.userprofile.FacebookUserProfile;
import co.aurasphere.facebot.userprofile.FaceBotUserProfileRetriever;

public class UserProfileRetrieverDemo {
	
	private static final Logger logger = LoggerFactory.getLogger(UserProfileRetrieverDemo.class);
	
	public static void main(String[] args) {
		FaceBotContext.getInstance().setup(PAGE_TOKEN, VALIDATION_TOKEN);
		FacebookUserProfile user = FaceBotUserProfileRetriever.getUser(MOCK_FACEBOOK_ID);
		logger.info("----------- Retrieved user -----------");
		logger.info("Name: " + user.getFirstName());
		logger.info("Surname: " + user.getLastName());
		logger.info("Locale: " + user.getLocale());
		logger.info("Profile pic: " + user.getProfilePic());
		logger.info("Timezone: " + user.getTimezone());
		logger.info("Gender: " + user.getGender());
	}

}
