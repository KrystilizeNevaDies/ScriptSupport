package cuberitePluginSupport;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jme.JmePlatform;

import cuberiteAPI.cGlobals;
import cuberiteAPI.cPlugin;
import cuberiteAPI.cPluginManager;

public class Plugin {
	
	// create new globals for each new plugin
	public Globals globals = JmePlatform.standardGlobals();
	
	public cPlugin cPluginObject;
	
	public UUID uuid;
	
	public Plugin(File directory) throws IOException {
		
		// Set UUID
		uuid = UUID.randomUUID();
		globals.set("PluginUUID", uuid.toString());
		
		// Create cPlugin
		cPluginObject = new cPlugin(directory.getName(), globals);
		
		// Add Globals
		cGlobals.initialize(this, globals);
		
		// Create cPluginManager
		new cPluginManager(this, globals);
		
		// Read all scripts
		File[] listOfFiles = directory.listFiles();

		// Iterate over scripts
		for (File file : listOfFiles)
		if (file.getName().contains(".lua") && file.isFile()) {
			// Read script
			String script = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
			
			// Load Script
			LuaValue output = globals.load(new StringReader(script), "main.lua");
			
			// Call script
			output.call();
		}
	}
	
	public static Boolean initialize(Plugin somePlugin) {
		
		// Get Initialize function
		LuaValue output = somePlugin.globals.get(LuaValue.valueOf("Initialize"));
		
		// Call function and return value
		LuaValue functionOutput = output.call(somePlugin.cPluginObject.luaValue);
		
		return functionOutput.equals(LuaValue.TRUE);
	}
}
