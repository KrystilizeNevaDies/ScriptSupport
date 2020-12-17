package minestom.api;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.CoerceLuaToJava;

import lua.plugin.Plugin;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.Event;
import net.minestom.server.event.player.PlayerLoginEvent;

public class Autogeneration {
	
	private static Map<String, Class<?>> classesMap = new HashMap<String, Class<?>>();
	
	private static Boolean hasGenerated = false;
	
	public static void Autogenerate(Plugin plugin) {
		
		Globals globals = plugin.globals;
		
		globals.set("RegisterEvent", new RegisterEvent());
		
		LuaTable metaTable = LuaTable.tableOf();
		
		metaTable.set("__index", new IndexFunction(globals));
		
		globals.setmetatable(metaTable);
		
		if (!hasGenerated)
		try {
			System.out.println("------------------------------");
			System.out.println("STARTING JAVA CLASS GENERATION");
			System.out.println("------------------------------");
			ArrayList<String> classes = new ArrayList<String>();
			Package[] packages = ClassLoader.getSystemClassLoader().getDefinedPackages();
			for (int i = 0; i < packages.length; i++) {
				classes.addAll(getClassNamesFromPackage(packages[i].getName()));
			}
			
			classes.forEach((string) -> {
				if (string.endsWith("class")) {
					string = string.replace(".class", "");
					string = string.replace("/", ".");
					try {
						Class<?> someClass = Class.forName(string);
						String name = someClass.getSimpleName();
			
						if (!name.equals("")) {
							classesMap.put(name, someClass);
						}
						
						// System.out.println("Generated class: " + name); 
						
					} catch (Throwable e) {
						// System.out.println("Class not found: " + string);
					}
				}
			});
			System.out.println("------------------------------");
			System.out.println("FINISHED -> CLASS COUNT: " + classesMap.size());
			System.out.println("------------------------------");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	
	static class IndexFunction extends TwoArgFunction {
		private Globals globals;
		
		IndexFunction(Globals globals) {
			this.globals = globals;
		}
		
		@Override
		public LuaValue call(LuaValue table, LuaValue key) {
			LuaValue value = table.rawget(key);
			if (!value.equals(NIL)) {
				return value;
			} else if (classesMap.containsKey(key.tojstring())) {
				return ClassBinding.get(classesMap.get(key.tojstring()), globals);
			} else {
				System.out.println("Couldn't index '" + key.tojstring() + "' in _G");
				return NIL;
			}
		}
	}
	
	static class RegisterEvent extends TwoArgFunction {
		@SuppressWarnings("unchecked")
		@Override
		public LuaValue call(LuaValue value, LuaValue func) {
			
			Object javaObject = CoerceLuaToJava.coerce(value, Class.class);
			
			Class<? extends Event> clazz = (Class<? extends Event>) javaObject;
			
			System.out.println(clazz.getSimpleName());
			
			MinecraftServer.getGlobalEventHandler().addEventCallback(PlayerLoginEvent.class, (event) -> {
				System.out.println("Event got called");
				func.call(CoerceJavaToLua.coerce(event));
			});
			
			
			return NIL;
		}
	}
	
	
	public static ArrayList<String> getClassNamesFromPackage(String packageName) throws IOException, URISyntaxException {
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    URL packageURL;
	    ArrayList<String> names = new ArrayList<String>();

	    packageName = packageName.replace(".", "/");
	    packageURL = classLoader.getResource(packageName);

	    if (packageURL.getProtocol().equals("jar")) {
	        String jarFileName;
	        JarFile jf;
	        Enumeration <JarEntry> jarEntries;
	        String entryName;

	        // build jar file name, then loop through zipped entries
	        jarFileName = URLDecoder.decode(packageURL.getFile(), "UTF-8");
	        jarFileName = jarFileName.substring(5, jarFileName.indexOf("!"));
	        jf = new JarFile(jarFileName);
	        jarEntries = jf.entries();
	        while (jarEntries.hasMoreElements()) {
	            entryName = jarEntries.nextElement().getName();
	            if (entryName.startsWith(packageName) && entryName.length() > packageName.length() + 5) {
	                names.add(entryName);
	            }
	        }
	        
	        jf.close();

	        // loop through files in classpath
	    } else {
	        URI uri = new URI(packageURL.toString());
	        File folder = new File(uri.getPath());
	        // won't work with path which contains blank (%20)
	        // File folder = new File(packageURL.getFile()); 
	        File[] contenuti = folder.listFiles();
	        String entryName;
	        for (File actual: contenuti) {
	            entryName = actual.getName();
	            if (entryName.lastIndexOf('.') != -1)
	            	entryName = entryName.substring(0, entryName.lastIndexOf('.'));
	            names.add(entryName);
	        }
	    }
	    return names;
	}
}
