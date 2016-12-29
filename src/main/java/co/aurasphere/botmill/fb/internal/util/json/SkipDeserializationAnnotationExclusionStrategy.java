package co.aurasphere.botmill.fb.internal.util.json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * ExclusionStrategy for skipping the Gson deserialization of fields annotated
 * with {@link SkipDeserialization}.
 * 
 * @author Donato Rimenti
 * @date Dec 29, 2016
 */
final class SkipDeserializationAnnotationExclusionStrategy implements
		ExclusionStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gson.ExclusionStrategy#shouldSkipField(com.google.gson.
	 * FieldAttributes)
	 */
	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(SkipDeserialization.class) != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gson.ExclusionStrategy#shouldSkipClass(java.lang.Class)
	 */
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}
}