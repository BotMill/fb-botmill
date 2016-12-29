# FB-BotMill - Tools to Mill Facebook Bots
FB-BotMill is designed to ease the process of developing, designing and running bots that exist inside Facebook. 

It provides a semantic Java API that can be imported on your Java EE Project to send and receive messages from Facebook so that developers can focus on developing the actual application instead of dealing with Facebook API endpoints.

**<h3>Getting Started</h3>**
The FB-BotMill can be imported as a dependency via Maven.

	<dependency>
	  <groupId>co.aurasphere.botmill</groupId>
	  <artifactId>fb-botmill</artifactId>
	  <version>1.0.0</version>
	</dependency>

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

**<h3>Creating a behaviour class</h3>**
To complete your first bot, all you have to do is write the definition class. This class will describe your bot behavior. Here's an example:

	public class MyBotBehaviour extends AbstractFbBot {
		public void defineBehavior() {
			addActionFrame(new MessageEvent("text message"), new MessageAutoReply("simple text message"));
		}
	}

The example above will basically create an event that will catch a response with text = "text message". A Reply object is then called to respond to this text message.

There are several types of events and reply that can be used.

**<h3>Examples</h3>**

# Developing with FB-BotMill

Table of Contents
* [Sending Messages](#sending-messages)
* [Receiving Messages](#receiving-messages)
* [Advance Topics](#advance-topics)

**<h3>Sending Messages</h3>**
**<h3>Receiving Messages</h3>**
**<h3>Advance Topics</h3>**

For more information on other callbacks, framework features or how to create a different kind of reply, check out the official wiki.

<sub>Copyright (c) 2017 Donato Rimenti, Alvin Reyes</sub>
