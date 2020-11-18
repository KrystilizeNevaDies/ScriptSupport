package cuberiteAPI;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

public class cPlugin {
	
	///////////////////////////////////////////////////////
	//                      Java API                     //
	///////////////////////////////////////////////////////
	
	private String name;
	
	private String folderName;
	
	private String error;
	
	public LuaValue luaValue;
	
	public cPlugin(String folder, Globals globals) {
		name = folder;
		folderName = folder;
		luaValue = registerCallbacks();
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
		public LuaValue call(LuaValue value) {
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
		public LuaValue call(LuaValue value) {
			return null;
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
		public LuaValue call(LuaValue value) {
			return LuaValue.valueOf(System.getProperty("user.dir") + "\\CuberitePlugins\\" + folderName + "\\");
		}
	}
	
	class GetName extends OneArgFunction {
		public LuaValue call(LuaValue value) {
			return null;
			//Returns the name of the plugin.
		}
	}

	/**
	 * LuaAPI
	 * cPlugin:GetFolderName()
	 * 
	 * @author Krystilize
	 *
	 */
	class GetStatus extends OneArgFunction {
		public LuaValue call(LuaValue value) {
			return null;
			//Returns the status of the plugin (loaded, disabled, unloaded, error, not found)
		}
	}

	/**
	 * LuaAPI
	 * cPlugin:GetFolderName()
	 * 
	 * @author Krystilize
	 *
	 */
	class GetVersion extends OneArgFunction {
		public LuaValue call(LuaValue value) {
			return null;
			//Returns the version of the plugin.
		}
	}

	/**
	 * LuaAPI
	 * cPlugin:GetFolderName()
	 * 
	 * @author Krystilize
	 *
	 */
	class  IsLoaded extends OneArgFunction {
		public LuaValue call(LuaValue value) {
			return null;
			//
		}
	}

	/**
	 * LuaAPI
	 * cPlugin:GetFolderName()
	 * 
	 * @author Krystilize
	 *
	 */
	class SetName extends OneArgFunction {
		public LuaValue call(LuaValue value) {
			return null;
			//Sets the API name of the Plugin that is used by cPluginManager:CallPlugin() to identify the plugin.
		}
	}

	/**
	 * LuaAPI
	 * cPlugin:GetFolderName()
	 * 
	 * @author Krystilize
	 *
	 */
	class SetVersion extends OneArgFunction {
		public LuaValue call(LuaValue value) {
			return null;
			//Sets the API version of the plugin. Currently unused.
		}
	}
	
	private LuaValue registerCallbacks() {
		LuaValue output = LuaValue.tableOf();
		
		output.set("GetFolderName", new GetFolderName());
		output.set("GetFolderName", new GetFolderName());
		output.set("GetFolderName", new GetFolderName());
		output.set("GetLoadError", 	new GetLoadError());
		output.set("GetLocalFolder",new GetLocalFolder());
		output.set("GetName", 		new GetName());
		output.set("GetStatus", 	new GetStatus());
		output.set("GetVersion", 	new GetVersion());
		output.set(" IsLoaded", 	new  IsLoaded());
		output.set("SetName", 		new SetName());
		output.set("SetVersion", 	new SetVersion());
		
		return output;
	}
}
