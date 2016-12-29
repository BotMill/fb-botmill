package co.aurasphere.botmill.fb.internal.util.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to skip the Gson deserialization of a field.
 * 
 * @author Donato Rimenti
 * @date Dec 29, 2016
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SkipDeserialization {

}
