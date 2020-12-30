package script.plugin.language;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface LanguageFunction extends LanguageObject {
	/**
	 * This interface is required to handle script side functions for calling
	 */
	
	/**
	 * Gets the java value associated with this function
	 * 
	 * @return java value of script function
	 */
	public Consumer<ArrayList<LanguageObject>> getJavaValue();
	
	/**
	 * Calls this script-side function and gets it's return value(s)
	 */
	public List<LanguageObject> callFunction(Object... javaObjects);
}
