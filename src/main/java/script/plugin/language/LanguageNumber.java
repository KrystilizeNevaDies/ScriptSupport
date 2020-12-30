package script.plugin.language;

public interface LanguageNumber extends LanguageObject {
	/**
	 * This interface is required to map Numbers in a scripting language to numbers in java
	 */
	
	/**
	 * Gets the java value associated with this Number
	 * 
	 * @return java value of script number
	 */
	public Number getJavaValue();
	
	
	/**
	 * Creates a new script-side Number
	 */
	public static LanguageNumber of(Number num) {return null;};
}