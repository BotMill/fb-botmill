package co.aurasphere.botmill.fb.model.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import co.aurasphere.botmill.fb.event.FbBotMillEventType;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface BotMillController {
	FbBotMillEventType eventType() default FbBotMillEventType.MESSAGE;
	String text() default "";
	String pattern() default "";
	String payload() default "";
	String quickpayload() default "";
	String quickpayloadpattern() default "";
	String postback() default "";
	String postbackpattern() default "";
	boolean casesensitive() default false;
}
