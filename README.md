# FB-BotMill - Tools to Mill Facebook Bots
FB-BotMill is designed to ease the process of developing, designing and running bots that exist inside Facebook. 

It provides a semantic Java API that can be imported on your Java EE Project to send and receive messages from Facebook so that developers can focus on developing the actual application instead of dealing with Facebook API endpoints.

**<h3>Getting Started</h3>**
The FB-BotMill can be imported as a dependency

Maven

	<dependency>
	  <groupId>co.aurasphere.botmill</groupId>
	  <artifactId>fb-botmill</artifactId>
	  <version>1.0.0</version>
	</dependency>

Gradle

	compile 'co.aurasphere.botmill:fb-botmill:1.0.0'

Apache Bldr

	'co.aurasphere.botmill:fb-botmill:jar:1.0.0'
	
	
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

**<h3>Examples</h3>**

* [TechnoWebhub Software Development](https://www.facebook.com/twebhub/?fref=ts)
* [SpotPrints Inc.](https://www.facebook.com/spotprints00/?ref=settings)
* [SimplyLocate App](https://www.facebook.com/SimplyLocate-1209810882431614/?fref=ts)
* [Trivia.Bot](https://www.facebook.com/TriviaBot-338552286519777/)

# Developing with FB-BotMill

Table of Contents
* [Setting up](#setting-up)
* [Sending Messages](#sending-messages)
* [Receiving Messages](#receiving-messages)

**<h3>Sending Messages</h3>**
The core of our framework plays around using builder patterns. When sending a message, it is important to keep in mind that whenever we receive a response from the user, we need to build a response object for it.

Here is an example of how you can create a text message response given a user input.

	public FbBotMillResponse createResponse(MessageEnvelope envelope) {
		String greetingMessage = "Hey There! ";
		return ReplyFactory.addTextMessageOnly(greetingMessage).build(envelope);
	}
					
Aside from sending a simple text, you can also respond differently.

	public FbBotMillResponse createResponse(MessageEnvelope envelope) {
		return ReplyFactory.addGenericTemplate().addElement("Welcome to TechnoWebHub")
			.addUrlButton("Go to Our Website", "http://www.technowebhub.com")
			.setImage("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTCau2xKug5qTlyXnwQDubIJDeBWvFy0YXPJmobXnMNwInJLDbj")
			.addPostbackButton("Start Chatting", "chat")
			.addShareButton()
			.setSubtitle("Systems Development Company, How would like to check our services?")
			.endElement().build(envelope);
	}
	
Go to our [snippets page](https://github.com/BotMill/fb-botmill/wiki/Code-Snippets) for the complete list of Reply/Response type.


**<h3>Receiving Messages</h3>**
Either it's rule based or ml-based, receiving a message will be match to a configured Event.

There are different types of Events that can be use to catch a user input. The most basic one would be to match it against a specific string.

	addActionFrame(new MessageEvent("text message"), new MessageAutoReply("simple text message"));

You can also match it against a Regular Expression.

	addActionFrame(new PostbackPatternEvent(Pattern.compile("(?i:chat)")), new AutoReply() {
		@Override
		public FbBotMillResponse createResponse(MessageEnvelope envelope) {
			return ReplyFactory.addTextMessageOnly("Sure!").build(envelope);
		}
	});
	
A postback.

	addActionFrame(new PostbackPatternEvent(Pattern.compile("(?i:services)")), new AutoReply() {
		@Override
		public FbBotMillResponse createResponse(MessageEnvelope envelope) {
			return ReplyFactory.addTypingAction(TypingAction.TYPING_ON).build(envelope);
		}
	});
	
	addActionFrame(new PostbackEvent("inquire_softdev", false), new AutoReply() {
		@Override
		public FbBotMillResponse createResponse(MessageEnvelope envelope) {
			return ReplyFactory.addTextMessageOnly("Hold on tight, One of our Sales Development will be with you shortly!")
				.build(envelope);
		}
	});
		

And even a catch all event.

	addActionFrame(new AnyEvent(), new AutoReply() {
		@Override
		public FbBotMillResponse createResponse(MessageEnvelope envelope) {
			if(safeGetMessage(envelope).equals("")) {return null;}
			return ReplyFactory.addTextMessageOnly("I didn't get that, you can type in: products, service or bot demo").build(envelope);
		}
	});
		
Go to our [snippets page](https://github.com/BotMill/fb-botmill/wiki/Code-Snippets) for the complete list of Events.

For more information on other callbacks, framework features or how to create a different kind of reply, check out the official wiki.

# Contribution

[Contribution Guide](https://github.com/BotMill/fb-botmill/blob/master/CONTRIBUTING.md)

<sub>Copyright (c) 2017 Donato Rimenti, Alvin Reyes</sub>
