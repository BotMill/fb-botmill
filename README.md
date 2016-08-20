# FaceBot
A simple Java framework for building event-driven bots on Facebook's Messenger Platform.

The goal of FaceBot is making the Facebook's Messenger Platform easier: with FaceBot, you only need less than 5 lines of code to set up your own Messenger bot! 

<b><h3>Premise</h3></b>

This tutorial will assume that you have already setup a Facebook page and application and you have a page token and a webhook validation token. If you don't, you can follow this link to Facebook's tutorial: https://developers.facebook.com/docs/messenger-platform/quickstart

<b><h3>QuickStart</h3></b>

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

This will register a servlet named myFaceBot to the path /myFaceBot. The bot-definition-class parameters is a class that implements the FaceBotDefinition interface.

To complete your first bot, all you have to do is write the definition class. This class will describe your bot behavior. Here's an example:

    public class MyFaceBotBehavior implements FaceBotDefinition {
  
      public void defineBehavior() {
      // Setting my tokens from Facebook.
		  FaceBotContext.getInstance().setPageToken("myFacebookPageToken");
		  FaceBotContext.getInstance().setValidationToken("myFacebookWebhookValidationToken");

      // Defining a bot which will reply with "Hello World!" as soon as I write "Hi"
	  	FaceBot bot = new FaceBot();
		  bot.addActionFrame(new MessageEvent("Hi"),
				  new MessageAutoReply("Hello World!"));
      }
    }

For more information on other callbacks, framework features or how to create a different kind of reply, check out the official wiki.

This project is a work in progress and any contribute is appreciated.

<sub>Copyright (c) 2016 Donato Rimenti</sub>
