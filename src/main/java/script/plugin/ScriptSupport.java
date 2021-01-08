package script.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import minestom.generation.Autogeneration;
import net.minestom.server.extensions.Extension;
import script.plugin.api.ScriptAPI;
import script.plugin.api.ScriptSupportAPI;
import script.plugin.language.LanguageAPI;

public class ScriptSupport extends Extension {

	public static Map<UUID, Plugin> loadedPlugins = new HashMap<UUID, Plugin>();

	public static ArrayList<ScriptAPI> apiList = new ArrayList<ScriptAPI>();
	public static ArrayList<LanguageAPI> languageList = new ArrayList<LanguageAPI>();

	private static Boolean debug = true;
	
	@Override
	public void preInitialize() {
		this.addAPI(Autogeneration::Autogenerate);
	}
	
	@Override
	public void initialize() {
		
		log("Starting plugin loading");
		
		// Get list of files in plugins folder
		File folder = new File("ScriptPlugins");
		File[] listOfFiles = folder.listFiles();

		// Iterate over files
		for (File directory : listOfFiles) {
			if (directory.isDirectory()) {
				log("Loading ScriptPlugins/" + directory.getName() + " as Plugin");
				// Create new plugin and add it to the plugin list
				Plugin plugin = new Plugin(directory);
				
				loadedPlugins.put(plugin.uuid, plugin);
			}
		}
		
		// Initialize plugins
		loadedPlugins.forEach((uuid, somePlugin) -> {
			
			// Load plugin
			if (!Plugin.initialize(somePlugin)) {
				System.out.println("Initialize returned non-true in plugin: " + somePlugin.name);
			};
		});
		
		// Implement APIs
		apiList.forEach((api) -> {
			api.implementAPI(this);
		});
	}
	
	@Override
	public void postInitialize() {
		loadedPlugins.forEach((uuid, plugin) -> {
			// read scripts
			plugin.readScripts(plugin);
			
			// Run the "Initialize" callback
			ScriptSupportAPI.callCallback(plugin, "Initialize", true, System.currentTimeMillis());
			
			
		});
	}
	
	public void addAPI(ScriptAPI api) {
		
		if (api == null) System.out.println("Script API is null");
		
		apiList.add(api);
	}
	
	public void addLanguage(LanguageAPI api) {
		languageList.add(api);
	}
	
	@Override
	public void terminate() {
		
	}
	
	public void log(String str) {
		if (debug) System.out.println("DEBUG: " + str);
	}
}