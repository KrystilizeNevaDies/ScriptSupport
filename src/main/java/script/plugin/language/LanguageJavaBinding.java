package script.plugin.language;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface LanguageJavaBinding extends LanguageObject {
	
	static Map<UUID, Object> javaObjects = new HashMap<UUID, Object>();
	
	/**
	 * Binds a java-side object to a script-side object
	 * 
	 * Value:
	 * Number, String, Boolean
	 * 
	 * Object:
	 * Any other object types
	 * 
	 * Binding: 
	 * A link between a script component and a java component or vice versa
	 */
	public default void bindObject(String globalName, Object object) {
		UUID uuid = UUID.randomUUID();
		javaObjects.put(uuid, object);
		LanguageString string = getAPI().stringOf(uuid.toString());
		getAPI().setGlobal(globalName, string);
	};
	
	/**
	 * Gets the java-side object of a script-side object binding
	 * 
	 * Value:
	 * Number, String, Boolean
	 * 
	 * Object:
	 * Any other object types
	 * 
	 * Binding: 
	 * A link between a script component and a java component or vice versa
	 */
	public default Object getJavaObject(LanguageString name) {
		UUID uuid = UUID.fromString(name.getJavaValue());
		return javaObjects.get(uuid);
	};
}
