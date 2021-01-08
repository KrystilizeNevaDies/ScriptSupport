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
	
	public File directory;

	public Plugin(File directory) {
		
		// Set UUID & Name
		uuid = UUID.randomUUID();
		name = directory.getName();
		this.directory = directory;
	}
	
	public void readScripts(Plugin plugin) {
		// Read all scripts
		File[] listOfFiles = directory.listFiles();

		// Iterate over scripts
		for (File file : listOfFiles)
			if (file.isFile()) {
				try {
					String script = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
					// Run script loading for each api
					ScriptSupport.languageList.forEach((api) -> {
						// Check if file is a valid script file
						if (api.isScript(file, script))
							// Load script file
							api.loadScript(plugin, file, script);
					});
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	public static boolean initialize(Plugin plugin) {
		if (plugin == null) System.out.println("Plugin is null");
		ArrayList<Boolean> returnValues = new ArrayList<Boolean>();
		ScriptSupport.languageList.forEach((api) -> {
			returnValues.add(api.initializePlugin(plugin));
		});
		return returnValues.size() > 0;
	}
}
