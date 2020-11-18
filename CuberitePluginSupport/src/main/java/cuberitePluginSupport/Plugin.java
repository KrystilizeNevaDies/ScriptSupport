package cuberitePluginSupport;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jme.JmePlatform;

import cuberiteAPI.cGlobals;
import cuberiteAPI.cPlugin;

public class Plugin {
	
	// create new globals for each new plugin
	private Globals globals = JmePlatform.standardGlobals();
	
	public cPlugin cPluginObject;
	
	public Plugin(File directory) throws IOException {
		
		// Create cPlugin
		cPluginObject = new cPlugin(directory.getName(), globals);
		
		// Add Globals
		cGlobals.initialize(this, globals);
		
		// Read all scripts
		File[] listOfFiles = directory.listFiles();

		// Iterate over scripts
		for (File file : listOfFiles) {
			if (file.getName().contains(".lua")) {
				// Read script
				String script = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
				
				// Load Script
				LuaValue output = globals.load(new StringReader(script), "main.lua");
				
				// Call script
				output.call();
			}
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
