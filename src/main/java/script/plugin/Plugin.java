package script.plugin;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.UUID;

public class Plugin {


	public UUID uuid;
	
	public String name;

	public Plugin(File directory) throws IOException {
		
		// Set UUID & Name
		uuid = UUID.randomUUID();
		name = directory.getName();

		// Read all scripts
		File[] listOfFiles = directory.listFiles();
		
		// Iterate over scripts
		for (File file : listOfFiles)
			if (file.isFile()) {
				// Read script
				String script = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
				
				// Run script loading for each api
				ScriptSupport.languageList.forEach((api) -> {
					// Check if file is a valid script file
					if (api.isScript(file, script))
						// Load script file
						api.loadScript(file, script);
				});
			}
		
	}

	public static boolean initialize(Plugin plugin) {
		ArrayList<Boolean> returnValues = new ArrayList<Boolean>();
		ScriptSupport.languageList.forEach((api) -> {
			if (api.initializePlugin(plugin))
				returnValues.add(true);
		});
		ScriptSupport.apiList.forEach((api) -> {
			api.implementAPI();
		});
		return returnValues.size() > 0;
	}
}
