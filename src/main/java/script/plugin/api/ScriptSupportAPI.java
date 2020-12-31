package script.plugin.api;

import java.util.ArrayList;
import java.util.List;

import script.plugin.ScriptSupport;
import script.plugin.language.LanguageAPI;
import script.plugin.language.LanguageBoolean;
import script.plugin.language.LanguageFunction;
import script.plugin.language.LanguageNumber;
import script.plugin.language.LanguageObject;
import script.plugin.language.LanguageString;

public class ScriptSupportAPI {
	
	private static ArrayList<LanguageAPI> langs = ScriptSupport.languageList;
	
	public static void setNumber(String name, Number num) {
		langs.forEach((lang) -> {
			lang.setGlobal(name, lang.numberOf(num));
		});
	};
	
	public static void setString(String name, String str) {
		langs.forEach((lang) -> {
			lang.setGlobal(name, lang.stringOf(str));
		});
	};
	
	public static void setBoolean(String name, boolean num) {
		langs.forEach((lang) -> {
			lang.setGlobal(name, lang.booleanOf(num));
		});
	}
	
	public static void setObject(String name, Object obj) {
		langs.forEach((lang) -> {
			lang.setGlobal(name, lang.objectOf(obj));
		});
	}
	
	public static List<ArrayList<Object>> callCallback(String name, Object... args) {
		List<ArrayList<Object>> returnValue = new ArrayList<ArrayList<Object>>();
		langs.forEach((lang) -> {
			LanguageObject obj = lang.getGlobal(name);
			if (obj instanceof LanguageFunction) {
				ArrayList<Object> list = new ArrayList<Object>(); 
				List<LanguageObject> returns = ((LanguageFunction) obj).callFunction(args);
				returns.forEach((value) -> {
					list.add(getJavaValue(value));
				});
				returnValue.add(list);
			}
		});
		return returnValue;
	}
	
	public static Object getJavaValue(LanguageObject obj) {
		if (obj instanceof LanguageNumber) {return ((LanguageNumber) obj).getJavaValue();};
		if (obj instanceof LanguageString) {return ((LanguageString) obj).getJavaValue();};
		if (obj instanceof LanguageBoolean) {return ((LanguageBoolean) obj).getJavaValue();};
		return null;
	}
}
