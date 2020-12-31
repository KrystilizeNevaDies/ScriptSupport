package script.plugin.language;

import java.util.HashMap;
import java.util.Map;

/**
 * The most complicated of all language objects.
 * 
 * This object should be able to be indexed like so
 * 
 * (someObject is an instance of a LanguageJavaBinding in a script)
 * 
 * someObject.someFunction();
 * 
 * as well as
 * 
 * result = someObject.someNumber + 4
 * 
 * Your implementation will also need to be able to track the following attributes:
 * 
 * Whether a java binding is static or not
 * The binary path of the class e.g. (java.util.Function)
 * 
 * 
 * 
 * 
 * @author Krystilize
 * 
 */
public interface LanguageJavaBinding<T extends Class> extends LanguageObject {
	
	public Map<String, LanguageObject> children = new HashMap<String, LanguageObject>();
	
	/**
	 * @return true if the class is static
	 */
	public boolean isStatic();
	
	/**
	 * Gets the java-side class of a script-side class
	 * @return java Class
	 */
	public T getJavaClass();
	
	/**
	 * Gets the java-side path of a script-side class
	 * @return java pathname String
	 */
	public default String getJavaClassPath() {
		return getJavaClass().getName();
	};
	
	/**
	 * sets a child of this class
	 */
	public void setClassChild(String name, LanguageObject obj);
	
	/**
	 * gets a child of this class
	 */
	public void getClassChild(String name, LanguageObject obj);
}