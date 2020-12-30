package script.plugin.language;

public interface LanguageString extends LanguageObject {
	/**
	 * This interface is required to map strings in a scripting language to 'String's in java
	 */
	
	/**
	 * Gets the java value associated with this string
	 * 
	 * @return java value of script string
	 */
	public String getJavaValue();
}