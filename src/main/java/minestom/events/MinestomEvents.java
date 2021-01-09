package minestom.events;

import java.util.ArrayList;

import net.minestom.server.MinecraftServer;
import net.minestom.server.event.Event;
import script.plugin.ScriptSupport;
import script.plugin.api.ScriptAPI;
import script.plugin.api.ScriptSupportAPI;
import script.plugin.language.LanguageAPI;
import script.plugin.language.LanguageFunction;
import script.plugin.language.LanguageJavaBinding;
import script.plugin.language.LanguageObject;

public class MinestomEvents implements ScriptAPI {
	
	public static MinestomEvents INSTANCE = new MinestomEvents();
	
	@Override
	public void implementAPI(ScriptSupport main) {
		ScriptSupport.loadedPlugins.forEach((uuid, plugin) -> {
			
			ScriptSupportAPI.setFunction(plugin, "AddEventCallback", (args) -> {
				
				@SuppressWarnings("unchecked")
				Class<? extends Event> event = (Class<? extends Event>) ((LanguageJavaBinding) args.get(0)).getJavaValue();
				
				MinecraftServer.getGlobalEventHandler().addEventCallback(event, (someEvent) -> {
					
					LanguageFunction func = ((LanguageFunction) args.get(1));
					
					ArrayList<LanguageObject> newArgs = new ArrayList<LanguageObject>(); 
					
					LanguageAPI lang = func.getAPI();
					
					LanguageJavaBinding value = (LanguageJavaBinding) lang.getScriptValue(someEvent);
					
					ScriptSupportAPI.addChildren(value, lang);
					
					newArgs.add(value);
					
					func.callFunction(newArgs);
				});
				
				return new ArrayList<LanguageObject>();
			});
		});

	}
}
