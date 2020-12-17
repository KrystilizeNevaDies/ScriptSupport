package lua.plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import cuberite.api.hooks.HookManager;
import minestom.api.Autogeneration;
import net.minestom.server.extensions.Extension;

public class LuaPluginSupport extends Extension {

	public static Map<UUID, Plugin> loadedPlugins = new HashMap<UUID, Plugin>();

	private ArrayList<Consumer<Plugin>> finishers = new ArrayList<Consumer<Plugin>>();
	
	@Override
	public void preInitialize() {
		System.out.println("Loading Cuberite Plugins");

		HookManager.registerHooks();
		
		// Prepare API (Other Extensions Should Prepare Their Api Here Too)
		
		// Cuberite
		addAPI(Plugin::implementAPI);
		
		// Minestom
		addAPI(Autogeneration::Autogenerate);
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
		initializePlugins();
	}

	public void initializePlugins() {
		loadedPlugins.forEach((uuid, somePlugin) -> {
			if (!Plugin.initialize(somePlugin)) {
				System.out.println("Initialize failed in plugin: " + somePlugin.cPluginObject.luaValue.get("Name").toString());
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