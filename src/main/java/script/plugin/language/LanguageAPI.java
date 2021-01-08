package script.plugin.language;

import java.io.File;
import java.util.ArrayList;
import java.util.function.Function;

import script.plugin.Plugin;

/**
 * Handguide to creating a language API
 * 
 * To make a language API, you will need to find a java library that implements yuour language.
 * 
 * It needs to have the following requirements:
 * 
 * Types of objects:
 * Only real requirement is numbers.
 * 
 * Callbacks:
 * your java library will need to be able to call specified code blocks (with args) from java.
 * 
 * For example, using the LuaJ Library that implements lua:
 * 
 * (Lua)
 * 
 * function TestFunction(str)
 *     print("Hello " .. str)
 * end
 * 
 * (Java)
 * 
 * globals.get("TestFunction").call("World!");
 * 
 * (Returns)
 * 
 * Hello World!
 * 
 * Once your library has been chosen, you will need to implement the {@link LanguageAPI} (This file!)
 * 
 * Once that is implemented, you may start implementing all five main object types:
 * 
 * {@link LanguageBoolean}
 * {@link LanguageString}
 * {@link LanguageNumber}
 * {@link LanguageJavaBinding}
 * {@link LanguageFunction}
 * 
 * If you have any questions, message Krystilize#7980 on discord
 * 
 * @author Krystilize
 *
 */
public interface LanguageAPI {
	
	/**
	 * Setup your API for a plugin
	 * 
	 * This is called for all plugins in the postInitialize phase
	 */
	public Boolean initializePlugin(Plugin plugin);
	
	/**
	 * Determine if {@link LanguageAPI#LoadScript(File, String)} should be ran on a file
	 */
	public Boolean isScript(File file, String fileContents);
	
	/**
	 * Load a script file and process it's language's syntax 
	 */
	public void loadScript(Plugin plugin, File file, String fileContents);
	
	
	/**	
	 * Sets a global variable script-side
	 */
	public void setGlobal(Plugin plugin, String name, LanguageObject obj);
	
	/**	
	 * Gets a global variable script-side
	 */
	public LanguageObject getGlobal(Plugin plugin, String name);
	
	/**
	 * Creates a new script-side string
	 */
	public LanguageString stringOf(String str);
	
	/**
	 * Creates a new script-side number
	 */
	public LanguageNumber numberOf(Number num);
	
	/**
	 * Creates a new script-side boolean
	 */
	public LanguageBoolean booleanOf(Boolean bool);
	
	/**
	 * Creates a new script-side function binding to a java side function
	 */
	public LanguageFunction functionOf(Function<ArrayList<LanguageObject>, ArrayList<LanguageObject>> func);
	
	/**
	 * Creates a new script-side java object binding
	 */
	public LanguageObject objectOf(Object obj);
	
	/**
	 * Creates a new script-side java object binding
	 */
	public LanguageJavaBinding classOf(Class<?> clazz);
	
	/**
	 * Converts a java value to a script-side equivalent
	 * 
	 * @param object to be converted
	 * @return java value
	 */
	@SuppressWarnings("unchecked")
	public default LanguageObject getScriptValue(Object obj) {
		
		if (obj instanceof String) return stringOf((String) obj);
		if (Number.class.isAssignableFrom(obj.getClass())) return numberOf((Number) obj);
		if (Boolean.class.isAssignableFrom(obj.getClass())) return booleanOf((Boolean) obj);
		if (obj instanceof Function<?, ?>) return functionOf((Function<ArrayList<LanguageObject>, ArrayList<LanguageObject>>) obj);
		return objectOf(obj);
	}
	
	/**
	 * Converts a script-side value to its java equivalent
	 * @param script object to be converted
	 * @return java object
	 */
	public default Object getJavaValue(LanguageObject object) {
		if (object instanceof LanguageNumber) {return ((LanguageNumber) object).getJavaValue();};
		if (object instanceof LanguageString) {return ((LanguageString) object).getJavaValue();};
		if (object instanceof LanguageBoolean) {return ((LanguageBoolean) object).getJavaValue();};
		if (object instanceof LanguageFunction) {return ((LanguageFunction) object).getJavaValue();};
		if (object instanceof LanguageJavaBinding) {return ((LanguageJavaBinding) object).getJavaValue();};
		return null;
	}
}
