package script.plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.minestom.server.extensions.Extension;
import script.plugin.language.LanguageAPI;

public class ScriptSupport extends Extension {

	public static Map<UUID, Plugin> loadedPlugins = new HashMap<UUID, Plugin>();

	public static ArrayList<LanguageAPI> apiList = new ArrayList<LanguageAPI>();

	@Override
	public void initialize() {
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
					System.out.println("ERROR in plugin '" + directory.getName() + "'");
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void postInitialize() {
		// Initialize plugins
		loadedPlugins.forEach((uuid, somePlugin) -> {
			if (!Plugin.initialize(somePlugin)) {
				System.out.println("Initialize returned non-true in plugin: " + somePlugin.name);
			};
		});
	}
	
	public void addAPI(LanguageAPI api) {
		apiList.add(api);
	}
	
	@Override
	public void terminate() {
		
	}
}