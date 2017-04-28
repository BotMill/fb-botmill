/*
 * MIT License
 *
 * Copyright (c) 2016 BotMill.io
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.botmill.fb.model.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import co.aurasphere.botmill.fb.event.FbBotMillEventType;


/**
 * The Interface FbBotMillController.
 * 
 * @author Alvin P. Reyes
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface FbBotMillController {
	
	/**
	 * Event type.
	 *
	 * @return the fb bot mill event type
	 */
	FbBotMillEventType eventType() default FbBotMillEventType.MESSAGE;
	
	/**
	 * Text.
	 *
	 * @return the string
	 */
	String text() default "";
	
	/**
	 * Pattern.
	 *
	 * @return the string
	 */
	String pattern() default "";
	
	/**
	 * Payload.
	 *
	 * @return the string
	 */
	String payload() default "";
	
	/**
	 * Quick reply payload.
	 *
	 * @return the string
	 */
	String quickReplyPayload() default "";
	
	/**
	 * Quick replt payload pattern.
	 *
	 * @return the string
	 */
	String quickReplyPayloadPattern() default "";
	
	/**
	 * Postback.
	 *
	 * @return the string
	 */
	String postback() default "";
	
	/**
	 * Postback pattern.
	 *
	 * @return the string
	 */
	String postbackPattern() default "";
	
	/**
	 * Case sensitive.
	 *
	 * @return true, if successful
	 */
	boolean caseSensitive() default false;

	/**
	 * Meta.
	 *
	 * @return the string
	 */
	String meta() default ""; // random text to indicate the purpose.
	
	
	boolean skipAuthorization() default false;

}
