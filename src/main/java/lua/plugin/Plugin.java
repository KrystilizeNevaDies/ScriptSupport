package lua.plugin;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import cuberite.api.cGlobals;
import cuberite.api.cPlugin;

public class Plugin {

	// create new globals for each new plugin
	public Globals globals = JsePlatform.standardGlobals();

	public cPlugin cPluginObject;

	public UUID uuid;

	public Plugin(File directory) throws IOException {
		
		// Set UUID
		uuid = UUID.randomUUID();
		globals.set("PluginUUID", uuid.toString());

		// Create cPlugin
		cPluginObject = new cPlugin(directory.getName(), globals);

		// Read all scripts
		File[] listOfFiles = directory.listFiles();

		// Iterate over scripts
		for (File file : listOfFiles)
			if (file.getName().endsWith(".lua") && file.isFile()) {
				// Read script
				String script = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

				// Load Script
				LuaValue output = globals.load(new StringReader(script), file.getName());

				// Call script
				output.call();
			}
		
	}
	
	public static void implementAPI(Plugin plugin) {
		// Add Globals
		cGlobals.initialize(plugin, plugin.globals);
	}

	public static Boolean initialize(Plugin plugin) {

		// Get Initialize function
		LuaValue output = plugin.globals.get(LuaValue.valueOf("Initialize"));

		// Call function and return value
		LuaValue functionOutput = output.call(plugin.cPluginObject.luaValue);

		return functionOutput.equals(LuaValue.TRUE);
	}
}
