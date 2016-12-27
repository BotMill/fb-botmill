# FB-BotMill
A simple Java framework for building event-driven bots on Facebook's Messenger Platform.

The goal of FB-BotMill is making the Facebook's Messenger Platform easier: with FB-BotMill, you only need less than 5 lines of code to set up your own Messenger bot! 

**<h3>Premise</h3>**

This tutorial will assume that you have already setup a Facebook page and application and you have a page token and a webhook validation token. If you don't, you can follow this link to Facebook's tutorial: https://developers.facebook.com/docs/messenger-platform/quickstart

**<h3>QuickStart</h3>**

First of all, you need to register the FbBotMillServlet. To do that, create a Servlet project in your IDE and add this to your web.xml:

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

    public class MyFbBotBehavior extends AbstractFbBot {
 
      public void defineBehavior() {
     	// Setting my tokens from Facebook (page token and validation token for webhook).
		FbBotMillContext.java.getInstance().setup("myFacebookPageToken", "myFacebookWebhookValidationToken");

     	// Defining a bot which will reply with "Hello World!" as soon as I write "Hi"
	  	addActionFrame(new MessageEvent("Hi"),
				  new MessageAutoReply("Hello World!"));
      }
    }

For more information on other callbacks, framework features or how to create a different kind of reply, check out the official wiki.

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
	
**<h3>Coming next</h3>**

Here's what you can expect coming up in the next updates:

- More documentation
- More examples
- Support for Webview & Extesions
- Thread settings for Domain Whitelisting, Account Linking and Payment
- Possibility of attaching files instead of using links


<sub>Copyright (c) 2016 Donato Rimenti, Alvin Reyes</sub>
