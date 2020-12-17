package lua.plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import net.minestom.server.extensions.Extension;

public class LuaPluginSupport extends Extension {

	public static Map<UUID, Plugin> loadedPlugins = new HashMap<UUID, Plugin>();

	private ArrayList<Consumer<Plugin>> finishers = new ArrayList<Consumer<Plugin>>();
	
	// Minestom addAPI(Autogeneration::Autogenerate);

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
					
					// Call API implementations
					finishers.forEach((consumer) -> {consumer.accept(plugin);});
					
					loadedPlugins.put(plugin.uuid, plugin);
					
				} catch (IOException e) {
					System.out.println("ERROR in lua plugin '" + directory.getName() + "'");
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
	
	public void addAPI(Consumer<Plugin> consumer) {
		finishers.add(consumer);
	}
	
	@Override
	public void terminate() {
		// TODO Auto-generated method stub
		
	}
}