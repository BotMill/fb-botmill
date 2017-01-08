[![Build Status](https://travis-ci.org/BotMill/fb-botmill.svg?branch=master)](https://travis-ci.org/BotMill/fb-botmill)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/co.aurasphere.botmill/fb-botmill/badge.svg?style=blue)](https://maven-badges.herokuapp.com/maven-central/co.aurasphere.botmill/fb-botmill)
[![Javadocs](http://www.javadoc.io/badge/co.aurasphere.botmill/fb-botmill.svg)](http://www.javadoc.io/doc/co.aurasphere.botmill/fb-botmill)

# FB-BotMill - Tools to Mill Facebook Bots
FB-BotMill is designed to ease the process of developing, designing and running bots that exist inside Facebook. 

It provides a semantic Java API that can be imported on your Java EE Project to send and receive messages from Facebook so that developers can focus on developing the actual application instead of dealing with Facebook API endpoints.

**<h3>Getting Started</h3>**
The FB-BotMill can be imported as a dependency via Maven.

	<dependency>
	  <groupId>co.aurasphere.botmill</groupId>
	  <artifactId>fb-botmill</artifactId>
	  <version>1.1.0</version>
	</dependency>

Gradle
    
    compile 'co.aurasphere.botmill:fb-botmill:1.1.0'

Grovvy

    @Grapes( 
        @Grab(group='co.aurasphere.botmill', module='fb-botmill', version='1.1.0') 
    )
    
Other ways to import, visit Maven central repo [site](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22fb-botmill%22) 

Once you've imported the API. You need to register the FbBotMillServlet. To do that, create a Servlet project in your IDE and add this to your web.xml:

     <servlet>
		  <servlet-name>myFbBot</servlet-name>
		  <servlet-class>co.aurasphere.botmill.fb.FbBotMillServlet</servlet-class>
		  <init-param>
			  <param-name>bot-definition-class</param-name>
			  <param-value>com.mypackage.MyFbBotDefinitionClass</param-value>
		  </init-param>
		  <load-on-startup>0</load-on-startup>
	  </servlet>
	  <servlet-mapping>
		  <servlet-name>myFbBot</servlet-name>
		  <url-pattern>/myFbBot</url-pattern>
	  </servlet-mapping>

This will register a servlet named myFbBot to the path /myFbBot. The bot-definition-class parameters is a class that implements the FbBotDefinition interface or extends the AbstractFbBot class.

To complete your first bot, all you have to do is write the definition class. This class will describe your bot behavior. Here's an example:

    public class MyFbBotDefinitionClass extends AbstractFbBot {
 
      public void defineBehavior() {
     	// Setting my tokens from Facebook (page token and validation token for webhook).
		FbBotMillContext.java.getInstance().setup("myFacebookPageToken", "myFacebookWebhookValidationToken");

     	// Defining a bot which will reply with "Hello World!" as soon as I write "Hi"
	  	addActionFrame(new MessageEvent("Hi"),
				  new MessageAutoReply("Hello World!"));
      }
    }

Neat! The sample above is the simplest way to get things started, for a more comprehensive guide on how to create your facebook chatbot from scratch, you can follow this [guide](https://github.com/BotMill/fb-botmill/wiki/Developing-with-FB-BotMill). 


**<h3>What's currently supported</h3>**

FB-BotMill supports this Facebook Messenger Platform components:

- Callbacks
	- Message Received
	- Message Delivered
	- Message Read
	- Message Echo
	- Postback
	- Plugin Opt-in
	- Referral
	- Payment
	- Checkout Update
	- Account Linking
- Send API
	- Templates
		- Button Template
		- Generic Template
		- List Template
		- Receipt Template
		- Airline Boarding Pass Template
		- Airline Checkin Template
		- Airline Itinerary Template
		- Airline Flight Update Template
	- Buttons
		- URL Button
		- Postback Button
		- Call Button
		- Share Button
		- Buy Button
		- Log in
		- Log out
	- Quick Replies
		- Generic Quick Reply Payload
		- Location Quick Reply
	- Sender Actions
	- Content Types
		- Text Message
		- Audio Attachment
		- File Attachment
		- Image Attachment
		- Video Attachment
- Thread Settings
	- Get Started Button
	- Greeting Text
	- Persistent Menu
	- Domain whitelisting
- User Profile retrieving
- Web View and Extensions
	
**<h3>Coming next</h3>**

Here's what you can expect coming up in the next updates:

- Payments
- File Attachments

<sub>Copyright (c) 2016-2017 BotMill.io</sub>
