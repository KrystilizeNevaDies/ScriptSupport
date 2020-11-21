package cuberitePluginSupport;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cuberiteAPI.hooks.HookManager;
import net.minestom.server.extensions.Extension;

public class CuberitePluginSupport extends Extension {

	public static Map<UUID, Plugin> loadedPlugins = new HashMap<UUID, Plugin>();
	
	@Override
	public void preInitialize() {
		System.out.println("Loading Cuberite Plugins");
		
		// Prepare API (Other Extensions Should Prepare Their Api Here Too)
		HookManager.registerHooks();
		
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
		// Get list of files in plugins folder
		File folder = new File("CuberitePlugins");
		File[] listOfFiles = folder.listFiles();
		
		// Iterate over files
		for (File directory : listOfFiles) {
		    if (directory.isDirectory()) {
		        try {
		        	// Create new plugin and add it to the plugin list
		        	Plugin plugin = new Plugin(directory);
		        	
		        	loadedPlugins.put(plugin.uuid, plugin);
				} catch (IOException e) {
					System.out.println("ERROR in cuberite plugin '" + directory.getName() + "'");
					e.printStackTrace();
				}
		    }
		}
	}
	
	@Override
	public void postInitialize() {
		initializePlugins();
	}
	
	public void initializePlugins() {
		loadedPlugins.forEach((uuid, somePlugin) -> {
			if (!Plugin.initialize(somePlugin)) {
				System.out.println("Initialize failed in plugin: " + somePlugin.cPluginObject.luaValue.get("Name").toString());
			};
		});
	}

	@Override
	public void terminate() {
		// TODO Auto-generated method stub
		
	}
}