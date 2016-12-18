# FaceBot
A simple Java framework for building event-driven bots on Facebook's Messenger Platform.

The goal of FaceBot is making the Facebook's Messenger Platform easier: with FaceBot, you only need less than 5 lines of code to set up your own Messenger bot! 

**<h3>Premise</h3>**

This tutorial will assume that you have already setup a Facebook page and application and you have a page token and a webhook validation token. If you don't, you can follow this link to Facebook's tutorial: https://developers.facebook.com/docs/messenger-platform/quickstart

**<h3>QuickStart</h3>**

First of all, you need to register the FaceBotServlet. To do that, create a Servlet project in your IDE and add this to your web.xml:

    <servlet>
		  <servlet-name>myFaceBot</servlet-name>
		  <servlet-class>co.aurasphere.facebot.FaceBotServlet</servlet-class>
		  <init-param>
			  <param-name>bot-definition-class</param-name>
			  <param-value>com.mypackage.MyFaceBotDefinitionClass</param-value>
		  </init-param>
		  <load-on-startup>0</load-on-startup>
	  </servlet>
	  <servlet-mapping>
		  <servlet-name>myFaceBot</servlet-name>
		  <url-pattern>/myFaceBot</url-pattern>
	  </servlet-mapping>

This will register a servlet named myFaceBot to the path /myFaceBot. The bot-definition-class parameters is a class that implements the FaceBotDefinition interface or extends the AbstractFaceBot class.

To complete your first bot, all you have to do is write the definition class. This class will describe your bot behavior. Here's an example:

    public class MyFaceBotBehavior extends AbstractFaceBot {
  
      public void defineBehavior() {
     	// Setting my tokens from Facebook (page token and validation token for webhook).
		FaceBotContext.getInstance().setup("myFacebookPageToken", "myFacebookWebhookValidationToken");

     	// Defining a bot which will reply with "Hello World!" as soon as I write "Hi"
	  	addActionFrame(new MessageEvent("Hi"),
				  new MessageAutoReply("Hello World!"));
      }
    }

For more information on other callbacks, framework features or how to create a different kind of reply, check out the official wiki.

This project is a work in progress and any contribute is appreciated.

**<h3>What's currently supported</h3>**

FaceBot supports this Facebook Messenger Platform components:

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
	- Quick Replies
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
- User Profile retrieving
	
**<h3>Coming next</h3>**

Here's what you can expect coming up in the next updates:

- More documentation
- More examples
- Support for Webview & Extesions
- Thread settings for Domain Whitelisting, Account Linking and Payment
- Possibility of attaching files instead of using links
- Support for Log In and Log Out buttons

Please notice that this list isn't ordered. If you don't find a feature you need in the list or you want me to give priority over one, just send me an e-mail.

<sub>Copyright (c) 2016 Donato Rimenti</sub>
