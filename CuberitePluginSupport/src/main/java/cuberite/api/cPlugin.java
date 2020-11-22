package cuberite.api;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

public class cPlugin {
	
	///////////////////////////////////////////////////////
	//                      Java API                     //
	///////////////////////////////////////////////////////
	
	public LuaValue luaValue;
	
	public cPlugin(String folder, Globals globals) {
		luaValue = LuaValue.tableOf();
		luaValue.set("Status", LuaValue.valueOf(ePluginStatus.psDisabled));
		luaValue.set("Name", LuaValue.valueOf(folder));
		luaValue.set("FolderName", LuaValue.valueOf(folder));
		luaValue.set("Version", LuaValue.valueOf(0.0));
		registerCallbacks();
		luaValue.set("Status", LuaValue.valueOf(ePluginStatus.psLoaded));
	}
	
	
	///////////////////////////////////////////////////////
	//                       Lua API                     //
	///////////////////////////////////////////////////////
	
	/**
	 * LuaAPI
	 * cPlugin:GetFolderName()
	 * 
	 * Returns the name of the folder where the plugin's files are. (APIDump)
	 * 
	 * @author Krystilize
	 *
	 */
	class GetFolderName extends OneArgFunction {
		public LuaValue call(LuaValue plugin) {
			return plugin.get("FolderName");
		}
	}
	
	/**
	 * LuaAPI
	 * cPlugin:GetLoadError()
	 * 
	 * If the plugin failed to load, returns the error message for the failure.
	 * 
	 * @author Krystilize
	 *
	 */
	class GetLoadError extends OneArgFunction {
		public LuaValue call(LuaValue plugin) {
			return plugin.get("Error");
		}
	}

	/**
	 * LuaAPI
	 * cPlugin:GetLocalFolder()
	 * 
	 * Returns the path where the plugin's files are. (Plugins/APIDump)
	 * 
	 * @author Krystilize
	 *
	 */
	class GetLocalFolder extends OneArgFunction {
		public LuaValue call(LuaValue plugin) {
			return LuaValue.valueOf(System.getProperty("user.dir") + "\\CuberitePlugins\\" + plugin.get("FolderName").toString() + "\\");
		}
	}
	
	/**
	 * LuaAPI
	 * cPlugin:GetName()
	 * 
	 * Returns the name of the plugin
	 * 
	 * @author Krystilize
	 *
	 */
	class GetName extends OneArgFunction {
		public LuaValue call(LuaValue plugin) {
			return plugin.get("Name");
		}
	}

	/**
	 * LuaAPI
	 * cPlugin:GetStatus()
	 * 
	 * Returns the status of the plugin (loaded, disabled, unloaded, error, not found)
	 * 
	 * @author Krystilize
	 *
	 */
	class GetStatus extends OneArgFunction {
		public LuaValue call(LuaValue plugin) {
			return plugin.get("Status");
		}
	}

	/**
	 * LuaAPI
	 * cPlugin:GetVersion()
	 * 
	 * Returns the version of the plugin.
	 * 
	 * @author Krystilize
	 *
	 */
	class GetVersion extends OneArgFunction {
		public LuaValue call(LuaValue plugin) {
			return plugin.get("Version");
		}
	}

	/**
	 * LuaAPI
	 * cPlugin:IsLoaded()
	 * 
	 * @author Krystilize
	 *
	 */
	class IsLoaded extends OneArgFunction {
		public LuaValue call(LuaValue plugin) {
			return LuaValue.valueOf(plugin.get("Status").toint() == ePluginStatus.psLoaded);
		}
	}

	/**
	 * LuaAPI
	 * cPlugin:SetName()
	 * 
	 * Sets the API name of the Plugin that is used by cPluginManager:CallPlugin() to identify the plugin.
	 * 
	 * @author Krystilize
	 *
	 */
	class SetName extends TwoArgFunction {
		public LuaValue call(LuaValue plugin, LuaValue value) {
			plugin.set("Name", value);
			return LuaValue.NIL;
		}
	}

	/**
	 * LuaAPI
	 * cPlugin:SetVersion()
	 * 
	 * Sets the API version of the plugin. Currently unused.
	 * 
	 * @author Krystilize
	 *
	 */
	class SetVersion extends TwoArgFunction {
		public LuaValue call(LuaValue plugin, LuaValue value) {
			plugin.set("Version", value);
			return LuaValue.NIL;
		}
	}
	
	private void registerCallbacks() {
		
		luaValue.set("GetFolderName", 	new GetFolderName());
		luaValue.set("GetLoadError", 	new GetLoadError());
		luaValue.set("GetLocalFolder",	new GetLocalFolder());
		luaValue.set("GetName", 		new GetName());
		luaValue.set("GetStatus", 		new GetStatus());
		luaValue.set("GetVersion", 		new GetVersion());
		luaValue.set("IsLoaded", 		new IsLoaded());
		luaValue.set("SetName", 		new SetName());
		luaValue.set("SetVersion", 		new SetVersion());
	}
}
