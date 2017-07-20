[![Build Status](https://travis-ci.org/BotMill/fb-botmill.svg?branch=master)](https://travis-ci.org/BotMill/fb-botmill)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/co.aurasphere.botmill/fb-botmill/badge.svg?style=blue)](https://maven-badges.herokuapp.com/maven-central/co.aurasphere.botmill/fb-botmill)
[![Javadocs](http://www.javadoc.io/badge/co.aurasphere.botmill/fb-botmill.svg)](http://www.javadoc.io/doc/co.aurasphere.botmill/fb-botmill)
[![Gitter](https://badges.gitter.im/BotMill/fb-botmill.svg)](https://gitter.im/BotMill/fb-botmill?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

# FB-BotMill - Awesome Framework to Build Facebook Bots
FB-BotMill is designed to ease the process of developing, designing and running bots that exist inside Facebook. 

It provides a semantic Java API that can be imported on your Java EE Project to send and receive messages from Facebook so that developers can focus on developing the actual application instead of dealing with Facebook API endpoints.

**<h3>Getting Started</h3>**
The FB-BotMill can be imported as a dependency via Maven.

	<dependency>
	  <groupId>co.aurasphere.botmill</groupId>
	  <artifactId>fb-botmill</artifactId>
	  <version>2.0.0-RC3</version>
	</dependency>

Gradle
    
    compile 'co.aurasphere.botmill:fb-botmill:2.0.0-RC3'

Groovy

    @Grapes( 
        @Grab(group='co.aurasphere.botmill', module='fb-botmill', version='2.0.0-RC3') 
    )
    
Other ways to import, visit Maven central repo [site](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22fb-botmill%22) 

**<h3>Creating your first Facebook ChatBot with Fb-BotMill</h3>**
Once you've imported the API. You need to register the FbBotMillServlet. To do that, add the following to your web.xml.

```xml
<servlet>
	<servlet-name>myFbBot</servlet-name>
	<servlet-class>co.aurasphere.botmill.fb.FbBotMillServlet</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>myFbBot</servlet-name>
	<url-pattern>/myFbBot</url-pattern>
</servlet-mapping>
```

Take note of the **url mapping** since this will be used on your webhook configuration in Facebook.  

**<h4>Creating your Bot Definition.</h4>**
The Bot Definition is the heart of your Facebook ChatBot. This is where we put all other chatbot event handlers and responses.

**1st: Setup the page token and validation token.**
Create botmill.properties file in your classpath and add the your tokens.

```properties
fb.page.token=<PAGE_TOKEN>
fb.validation.token=<VALIDATION_TOKEN>
```

Note that you can encrypt the properties file using our built in jaspyt-based encryption. Go to our Wiki here on how to setup your encrypted **botmill.properties** file.

**2nd: Setup your Encryption class.**
We strictly push the use of Jaspyt to encrypt the tokens, for this, we need to make sure you create your own Jaspyt Encryption class. To do this, create the following on your project.

```java
@BotEncryption
public class DefaultEncryption {
	public DefaultEncryption() {
		StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
		enc.setPassword("password"); // can be sourced out
		ConfigurationUtils.loadEncryptedConfigurationFile(enc, "botmill.properties");
	}
}
```

The password is up to you and can be sourced anywhere (via https or ftp). The key thing here is that this text is what will Jaspyt use to decrypt your botmill.properties file. 

```java
...
enc.setPassword("https://mydomain.com/encryptionpassword/password.txt"); // can be sourced out
..
```
Once you've done this, we need to use the botmill-crypto-util project to create the encrypted version of your page token and validation token. Download the botmill-crypto-util [here] (https://oss.sonatype.org/content/repositories/snapshots/co/aurasphere/botmill/botmill-crypto-util/0.0.1-SNAPSHOT/botmill-crypto-util-0.0.1-20170228.035750-1-jar-with-dependencies.jar) and run the following command:

java -jar botmill-crypto-util-0.0.1-20170228.035750-1-jar-with-dependencies.jar enc <page_token> <password>
java -jar botmill-crypto-util-0.0.1-20170228.035750-1-jar-with-dependencies.jar enc <validation_token> <password>

This will spit out the encrypted version of your text file. Modify your botmill.properties with these values but make sure to put it inside the ENC(***)

```properties
fb.page.token=ENC(<ENCRYPTED_PAGE_TOKEN>)
fb.validation.token=ENC(<ENCRYPTED_VALIDATION_TOKEN>)
```

Redeploy and you're good to go.

**3rd: Setup your BotConfiguration**
The BotConfiguration class will take care of the one time processes that needs to happen (persistent menus, facebook api authentication etc). Create a FbBotConfiguration below and put all your initial configuration (one time config) on the constructor. This will also initialize the fb authentication.
 
```java
@BotConfiguration
public class MyBotConfiguration extends FbBotConfiguration {

    public MyBotConfiguration() {
    
		MessengerProfileApi.setGetStartedButton("get_started");
		MessengerProfileApi.setGreetingMessage("Hello!");
		
		List<PersistentMenu> persistentMenus = new ArrayList<PersistentMenu>();
		PersistentMenu persistentMenu = new PersistentMenu("default", false);
		
		persistentMenu.addCallToAction(ButtonFactory.createPostbackButton("Menu 1", "menu1"));
		persistentMenu.addCallToAction(ButtonFactory.createPostbackButton("Menu 2", "menu2"));
		
		CallToActionNested theNestedMenu = new CallToActionNested("Menu 3 Nested");
		theServices.addCallToActionButton(ButtonFactory.createPostbackButton("Nested1", "nested1"));
		theServices.addCallToActionButton(ButtonFactory.createPostbackButton("Nested2", "nested2"));
		theServices.addCallToActionButton(ButtonFactory.createPostbackButton("Nested3", "nested3"));
		persistentMenu.addCallToAction(theNestedMenu);
		
		persistentMenus.add(persistentMenu);
		
		MessengerProfileApi.setPersistentMenus(persistentMenus);
		
		HomeUrl homeUrl = new HomeUrl();
		homeUrl.setInTest(true);
		homeUrl.setUrl("https://extensionlink.co");
		homeUrl.setWebviewHeightRatio(WebViewHeightRatioType.TALL);
		homeUrl.setWebviewShareButton(WebViewShareButton.SHOW);
		
		MessengerProfileApi.setHomeUrl(homeUrl);
		
    }
    
}
```
 
**4th: Setup the FbBot Class/Classes.**
Our framework makes it easy and straightforward to define a Facebook Bot Behaviour by tagging classes as behaviour objects. 


```java
@Bot
public class MyBotClass extends FbBot {
	
	@FbBotMillController(eventType=FbBotMillEventType.MESSAGE, text="Hi",caseSensitive = true)
	public void sendMessage(MessageEnvelope envelope) {
		reply(new MessageAutoReply("Hello World!"));
	}
}

@Bot(state = BotBeanState.PROTOTYPE) // creates a new instance per call
public class MyBotClass1 extends FbBot {
	
	@FbBotMillController(eventType=FbBotMillEventType.MESSAGE, text="Hi",caseSensitive = true)
	public void sendMessage(MessageEnvelope envelope) {
		reply(new MessageAutoReply("Hello World on BotClass1"));
	}
}

@Bot(state = BotBeanState.SINGLETON) // uses the same reference/instance (this is the default).
public class MyBotClass2 extends FbBot {
	
	@FbBotMillController(eventType=FbBotMillEventType.MESSAGE, text="Hi",caseSensitive = true)
	public void sendMessage(MessageEnvelope envelope) {
		reply(new MessageAutoReply("Hello World on BotClass2"));
	}
}
```

**catch a pattern and respond with a quick reply**

```java
@FbBotMillController(eventType = FbBotMillEventType.MESSAGE_PATTERN, pattern = "(?i:hi)|(?i:hello)|(?i:hey)|(?i:good day)|(?i:home)")
public void replyWithQuickReply(MessageEnvelope envelope) {
	reply(new AutoReply() {
		@Override
		public FbBotMillResponse createResponse(MessageEnvelope envelope) {
			return ReplyFactory.addTextMessageOnly("Text message with quick replies")
					.addQuickReply("Quick reply 1", "Payload for quick reply 1").build(envelope);
		}
	});
}
```

**or respond with a button**
```java
@FbBotMillController(eventType = FbBotMillEventType.MESSAGE_PATTERN, pattern = "(?i:hi)|(?i:hello)|(?i:hey)|(?i:good day)|(?i:home)")
public void replyWithButtonTemplate(MessageEnvelope envelope) {
	reply(new AutoReply() {
		@Override
		public FbBotMillResponse createResponse(MessageEnvelope envelope) {
			return ReplyFactory.addButtonTemplate("Test button template")
					.addPostbackButton("postback button", "postback button payload")
					.addPhoneNumberButton("phone number button", "+123456789")
					.addUrlButton("web url button", "https://github.com/BotMill/fb-botmill").build(envelope);
		}
	});
}
```

Visit our docs for a complete list of EventTypes and Response.

**Key components in building your ChatBot**
- @Bot - annotating a class with @Bot will mark the class as a Facebook ChatBot behaviour. 
- @BotEncryption - use to create an isolated java class to handle encryption.
- @BotConfiguration - use to create an isolated java class to handle one time processes that needs to happen before any bots are created.
- @FbBotMillInit - can be use to annotate a method and invoke it prior to any @FbBotMillController annotated methods. 
- @FbBotMillController - Use to create a method that catches specific user-driven event (such as user entering a message, selecting a quick reply etc. 
- FbBot.reply() - allows the developers to create a response based on the @FbBotMillController event. For the list of all events and reply, go to our Wiki page [here](https://github.com/BotMill/fb-botmill/wiki/Code-Snippets)
- FbBot.botMillSession() - allows you to store and access data. __Note that you need to setup a mongodb connection to make this work, mongodb connection configuration can also be set via botmill.properties__. For more information about this, visit our [BotMillSession guide here]https://github.com/BotMill/fb-botmill/wiki/Developing-with-FB-BotMill). 


<h3>Contribution</h3>
We'd love to get more people involve in the project. We're looking for enthusiastic maintainers that can put our framework on another level and we'd love to hear your ideas about it. Feel free to Chat with us via Gitter to get started!

<sub>Copyright (c) 2016-2017 BotMill.io</sub>
