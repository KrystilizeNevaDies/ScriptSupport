package script.plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import minestom.generation.Autogeneration;
import net.minestom.server.extensions.Extension;
import script.plugin.api.ScriptAPI;
import script.plugin.language.LanguageAPI;

public class ScriptSupport extends Extension {

	public static Map<UUID, Plugin> loadedPlugins = new HashMap<UUID, Plugin>();

	public static ArrayList<ScriptAPI> apiList = new ArrayList<ScriptAPI>();
	public static ArrayList<LanguageAPI> languageList = new ArrayList<LanguageAPI>();

	@Override
	public void preInitialize() {
		this.addAPI(Autogeneration::Autogenerate);
	}
	
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
	
	public void addAPI(ScriptAPI api) {
		apiList.add(api);
	}
	
	public void addLanguage(LanguageAPI api) {
		languageList.add(api);
	}
	
	@Override
	public void terminate() {
		
	}
}