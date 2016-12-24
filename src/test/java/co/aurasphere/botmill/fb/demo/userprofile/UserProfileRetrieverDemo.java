package co.aurasphere.botmill.fb.demo.userprofile;

import static co.aurasphere.botmill.fb.demo.FbBotMillDemoConstants.MOCK_FACEBOOK_ID;
import static co.aurasphere.botmill.fb.demo.FbBotMillDemoConstants.PAGE_TOKEN;
import static co.aurasphere.botmill.fb.demo.FbBotMillDemoConstants.VALIDATION_TOKEN;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.aurasphere.botmill.fb.FbBotMillContext;
import co.aurasphere.botmill.fb.model.userprofile.FacebookUserProfile;
import co.aurasphere.botmill.fb.userprofile.FbBotMillUserProfileRetriever;

public class UserProfileRetrieverDemo {
	
	private static final Logger logger = LoggerFactory.getLogger(UserProfileRetrieverDemo.class);
	
	public static void main(String[] args) {
		FbBotMillContext.getInstance().setup(PAGE_TOKEN, VALIDATION_TOKEN);
		FacebookUserProfile user = FbBotMillUserProfileRetriever.getUser(MOCK_FACEBOOK_ID);
		logger.info("----------- Retrieved user -----------");
		logger.info("Name: " + user.getFirstName());
		logger.info("Surname: " + user.getLastName());
		logger.info("Locale: " + user.getLocale());
		logger.info("Profile pic: " + user.getProfilePic());
		logger.info("Timezone: " + user.getTimezone());
		logger.info("Gender: " + user.getGender());
	}

}
