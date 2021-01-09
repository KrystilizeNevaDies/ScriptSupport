package script.plugin.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import script.plugin.Plugin;
import script.plugin.ScriptSupport;
import script.plugin.language.LanguageAPI;
import script.plugin.language.LanguageFunction;
import script.plugin.language.LanguageJavaBinding;
import script.plugin.language.LanguageObject;

public class ScriptSupportAPI {
	
	private static ArrayList<LanguageAPI> langs = ScriptSupport.languageList;
	
	public static void setNumber(Plugin plugin, String name, Number num) {
		langs.forEach((lang) -> {
			lang.setGlobal(plugin, name, lang.numberOf(num));
		});
	};
	
	public static void setString(Plugin plugin, String name, String str) {
		langs.forEach((lang) -> {
			lang.setGlobal(plugin, name, lang.stringOf(str));
		});
	};
	
	public static void setBoolean(Plugin plugin, String name, boolean num) {
		langs.forEach((lang) -> {
			lang.setGlobal(plugin, name, lang.booleanOf(num));
		});
	}
	
	public static void setObject(Plugin plugin, String name, Object obj) {
		langs.forEach((lang) -> {
			lang.setGlobal(plugin, name, lang.objectOf(obj));
		});
	}
	
	public static void setFunction(Plugin plugin, String name, Function<ArrayList<LanguageObject>, ArrayList<LanguageObject>> func) {
		langs.forEach((lang) -> {
			lang.setGlobal(plugin, name, lang.functionOf(func));
		});
	};
	
	public static void setClass(Plugin plugin, String name, Class<?> clz) {
		langs.forEach((lang) -> {
			// Create a script binding
			LanguageJavaBinding clazz = lang.classOf(clz);
			
			// Add the sub classes
			addChildren(clazz, lang);
			
			// Set the global
			lang.setGlobal(plugin, name, clazz);
		});
	}
	
	public static void addChildren(LanguageJavaBinding clz, LanguageAPI lang) {
		
		Class<?> clazz = (Class<?>) clz.getJavaClass();
		
		// Add constructors
		Constructor<?>[] constructors = clazz.getConstructors();
		for (int i = 0; i < constructors.length; i++) {
			Constructor<?> constructor = constructors[i];
			clz.setChild("Constructor" + i, lang.functionOf((ArrayList<LanguageObject> list) -> {
				
				ArrayList<LanguageObject> objectList = new ArrayList<LanguageObject>();
				
				try {
					objectList.add(lang.objectOf(constructor.newInstance(list.toArray())));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
				
				return objectList;
			}));
		}
		
		// Add methods
		Method[] methods = clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			clz.setChild(method.getName(), lang.functionOf((ArrayList<LanguageObject> list) -> {
				
				ArrayList<LanguageObject> objectList = new ArrayList<LanguageObject>();
				
				ArrayList<Object> objects = new ArrayList<Object>();
				
				list.forEach((binding) -> {
					LanguageAPI api = binding.getAPI();
					
					objects.add(api.getJavaValue(binding));
				});
				
				Object[] array = objects.toArray();
				
				try {
					
					Object returnValue = method.invoke(clz.getJavaValue(), array);
					
					if (returnValue != null)
					objectList.add(lang.getScriptValue(returnValue));
					
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					if (e instanceof IllegalArgumentException) {
						System.out.println("Arguments are not correct for method: " + method.getName());
						
						Parameter[] params = method.getParameters();
						
						System.out.println("Method params: " + params.length);
						System.out.println("Given params: " + array.length);
						
						for (int j = 0; (j < params.length) || (j < array.length); j++) {
							try {
							System.out.println(array[j].getClass().getName() + "|" + params[j].getType().getName());
							} catch (Throwable t) {}
						}
					}
					e.printStackTrace();
				}
				
				return objectList;
			}));
			
		}
		
		// Add Fields
		Field[] fields = clazz.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			try {
				Object value = field.get(clz.getJavaValue());
				if (value != clz.getJavaValue())
					clz.setChild(field.getName(), lang.getScriptValue(value));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// e.printStackTrace();
			}
		}
		
		// Add classes
		Class<?>[] classes = clazz.getClasses();
		for (int i = 0; i < classes.length; i++) {
			Class<?> someClazz = classes[i];
			clz.setChild(someClazz.getName(), lang.functionOf((ArrayList<LanguageObject> list) -> {
				
				ArrayList<LanguageObject> objectList = new ArrayList<LanguageObject>();
				
				try {
					// Create new language binding
					LanguageJavaBinding binding = lang.classOf(someClazz);
					
					// Add the subclasses
					addChildren(binding, lang);
					
					// Add to returns list
					objectList.add(binding);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
				
				return objectList;
			}));
		}
	}
	
	public static List<List<Object>> callCallback(Plugin plugin, String name, Boolean isRequired, Object... args) {
		List<List<Object>> returnValue = new ArrayList<List<Object>>();
		langs.forEach((lang) -> {
			 
			LanguageObject obj = lang.getGlobal(plugin, name);
			
			if (obj instanceof LanguageFunction) {
				
				ArrayList<Object> list = new ArrayList<Object>();
				ArrayList<LanguageObject> argsList = new ArrayList<LanguageObject>();
				for (int i = 0; i < args.length; i++) {
					argsList.add(lang.getScriptValue(args[i]));
				}
				
				List<LanguageObject> returns = ((LanguageFunction) obj).callFunction(argsList);
				returns.forEach((value) -> {
					System.out.println(value.getClass());
					list.add(lang.getJavaValue(value));
				});
				
				returnValue.add(list);
			} else if (isRequired) {
				new Throwable(name + " callback was not found in language: " + lang.toString());
			}
			
		});
		return returnValue;
	}
}
