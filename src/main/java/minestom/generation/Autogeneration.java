package minestom.generation;

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

import script.plugin.api.ScriptAPI;
import script.plugin.api.ScriptSupportAPI;

public class Autogeneration implements ScriptAPI {
	
	private static Map<String, String> classesMap = new HashMap<String, String>();
	
	private static Boolean triedGenerate = false;
	
	public static void Autogenerate() {
		if (!triedGenerate)
		try {
			triedGenerate = true;
			System.out.println("------------------------------");
			System.out.println("STARTING JAVA CLASS GENERATION");
			System.out.println("------------------------------");
			ArrayList<String> classes = new ArrayList<String>();
			Package[] systemPackages = ClassLoader.getSystemClassLoader().getDefinedPackages();
			Package[] platformPackages = ClassLoader.getPlatformClassLoader().getDefinedPackages();
			for (int i = 0; i < systemPackages.length; i++) {
				classes.addAll(getClassNamesFromPackage(systemPackages[i].getName()));
			}
			for (int i = 0; i < platformPackages.length; i++) {
				classes.addAll(getClassNamesFromPackage(platformPackages[i].getName()));
			}
			
			classes.forEach((string) -> {
				if (string.contains(".class")) {
					String key = string;
					String[] split = key.replace(".class", "").split("[/]");
					classesMap.put(split[split.length - 1], string);
				}
			});
			System.out.println("------------------------------");
			System.out.println("FINISHED -> CLASS COUNT: " + classesMap.size());
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
	public void implementAPI() {
		Autogenerate();
		classesMap.forEach((name, path) -> {
			try {
				ScriptSupportAPI.setObject(name, Class.forName(path));
			} catch (ClassNotFoundException e) {
				System.out.println("Class not found: " + path);
			}
		});
	}
}
