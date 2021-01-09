package minestom.generation;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import script.plugin.ScriptSupport;
import script.plugin.api.ScriptAPI;
import script.plugin.api.ScriptSupportAPI;

public class Autogeneration implements ScriptAPI {
	
	public static Autogeneration INSTANCE = new Autogeneration();
	
	private static Boolean triedGenerate = false;
	
	public static void Autogenerate(ScriptSupport main) {
		if (!triedGenerate)
		try {
			triedGenerate = true;
			System.out.println("------------------------------");
			System.out.println("STARTING JAVA CLASS GENERATION");
			System.out.println("------------------------------");
			ArrayList<String> classes = new ArrayList<String>();
			
			// Add Minestom Classes
			classes.addAll(getClassNamesFromPackage("net.minestom"));
			
			// Add Java Classes
			classes.addAll(getClassNamesFromPackage("java"));
			
			
			
			classes.forEach((className) -> {
				if (className.contains(".class")) {
					
					String smallClassName = className.replace(".class", "");
					
					String[] splitClassName = smallClassName.split("[/]");
					
					String name = splitClassName[splitClassName.length - 1].replace("$", "_");
					
					// Debug
					// System.out.println(className + "|" + name);
					
					ScriptSupport.loadedPlugins.forEach((uuid, plugin) -> {
						try {
							ScriptSupportAPI.setClass(plugin, name, Class.forName(smallClassName.replace("/", ".")));
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					});
				}
			});
			System.out.println("------------------------------");
			System.out.println("FINISHED -> CLASS COUNT: " + classes.size());
			System.out.println("------------------------------");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getClassNamesFromPackage(String packageName) throws IOException, URISyntaxException {
	    ArrayList<String> names = new ArrayList<String>();

	    packageName = packageName.replace(".", "/");
	    URL packageURL = Thread.currentThread().getContextClassLoader().getResource(packageName);
	    
	    if (packageURL == null) {
	    	packageURL = ClassLoader.getPlatformClassLoader().getResource(packageName);
	    }
	    
	    if (packageURL == null) {
	    	packageURL = ClassLoader.getSystemClassLoader().getResource(packageName);
	    }
	    
	    if (packageURL != null)
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

	@Override
	public void implementAPI(ScriptSupport main) {
		System.out.println("implementing minestom classes into scripts...");
		Autogenerate(main);
	}
}
