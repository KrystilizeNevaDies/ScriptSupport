package cuberiteAPI;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

public class cPlugin {
	
	///////////////////////////////////////////////////////
	//                      Java API                     //
	///////////////////////////////////////////////////////
	
	private String name;
	
	private String folderName;
	
	private Double version;
	
	private ePluginStatus status;
	
	private String error;
	
	public LuaValue luaValue;
	
	public cPlugin(String folder, Globals globals) {
		status = ePluginStatus.psDisabled;
		name = folder;
		folderName = folder;
		version = 0.0;
		luaValue = LuaValue.tableOf(); 
		registerCallbacks();
		status = ePluginStatus.psLoaded;
	}
	
	public String GetName() {
		return name;
	}
	

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
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
			return LuaValue.valueOf(folderName);
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
			return LuaValue.valueOf(error);
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
			return LuaValue.valueOf(System.getProperty("user.dir") + "\\CuberitePlugins\\" + folderName + "\\");
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
			return LuaValue.valueOf(name);
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
			return LuaValue.valueOf(ePluginStatus.getID(status));
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
			return LuaValue.valueOf(version);
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
			return LuaValue.valueOf(status == ePluginStatus.psLoaded);
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
			if (value.isstring()) {
				name = value.tojstring();
			} else {
				System.out.println("Error in cPlugin:SetName() - Arg 2 is not a string");
			}
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
			if (value.isnumber()) {
				version = value.todouble();
			} else {
				System.out.println("Error in cPlugin:SetVersion() - Arg 2 is not a number");
			}
			return null;
		}
	}
	
	private void registerCallbacks() {
		
		luaValue.set("GetFolderName", 	new GetFolderName());
		luaValue.set("GetLoadError", 	new GetLoadError());
		luaValue.set("GetLocalFolder",	new GetLocalFolder());
		luaValue.set("GetName", 		new GetName());
		luaValue.set("GetStatus", 		new GetStatus());
		luaValue.set("GetVersion", 		new GetVersion());
		luaValue.set("IsLoaded", 		new  IsLoaded());
		luaValue.set("SetName", 		new SetName());
		luaValue.set("SetVersion", 		new SetVersion());
	}
}
