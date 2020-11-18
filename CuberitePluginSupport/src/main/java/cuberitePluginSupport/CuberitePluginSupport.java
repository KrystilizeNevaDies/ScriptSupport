package cuberitePluginSupport;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.minestom.server.extensions.Extension;

public class CuberitePluginSupport extends Extension {

	public static ArrayList<Plugin> loadedPlugins = new ArrayList<Plugin>();
	
	@Override
	public void preInitialize() {
		
		System.out.println("Loading Cuberite Plugins");
		
		// Get list of files in plugins folder
		File folder = new File("CuberitePlugins");
		File[] listOfFiles = folder.listFiles();
		
		// Iterate over files
		for (File directory : listOfFiles) {
		    if (directory.isDirectory()) {
		        try {
		        	// Create new plugin and add it to the plugin list
		        	loadedPlugins.add(new Plugin(directory));
				} catch (IOException e) {
					System.out.println("ERROR in cuberite plugin '" + directory.getName() + "'");
					e.printStackTrace();
				}
		    }
		}
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void postInitialize() {
		initializePlugins();
	}
	
	public void initializePlugins() {
		loadedPlugins.forEach(somePlugin -> {
			if (!Plugin.initialize(somePlugin)) {
				System.out.println("Initialize failed in plugin: " + somePlugin.cPluginObject.GetName());
			};
		});
	}

	@Override
	public void terminate() {
		// TODO Auto-generated method stub
		
	}
}