package lua.plugin;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

public class Plugin {

	// create new globals for each new plugin
	public Globals globals = JsePlatform.standardGlobals();

	public UUID uuid;
	
	public String name;

	public Plugin(File directory) throws IOException {
		
		// Set UUID & Name
		uuid = UUID.randomUUID();
		name = directory.getName();
		
		globals.set("PluginUUID", uuid.toString());

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

	public static Boolean initialize(Plugin plugin) {

		// Get Initialize function
		LuaValue output = plugin.globals.get("Initialize");

		// Call function and return value
		LuaValue functionOutput = output.call(CoerceJavaToLua.coerce(plugin));

		return functionOutput.equals(LuaValue.TRUE);
	}
}
