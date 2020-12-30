package script.plugin.language;

public interface LanguageBoolean extends LanguageObject {
	/**
	 * This interface is required to map booleans in a scripting language to 'Boolean's in java
	 */
	
	/**
	 * Gets the java value associated with this Boolean
	 * 
	 * @return java value of script Boolean
	 */
	public Boolean getJavaValue();
}