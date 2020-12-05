package cuberite.api;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

public class cPlugin {

	///////////////////////////////////////////////////////
	// Java API //
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
	// Lua API //
	///////////////////////////////////////////////////////

	/**
	 * LuaAPI cPlugin:GetFolderName()
	 * 
	 * Returns the name of the folder where the plugin's files are. (APIDump)
	 * 
	 * @author Krystilize
	 *
	 */
	class GetFolderName extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			return plugin.get("FolderName");
		}
	}

	/**
	 * LuaAPI cPlugin:GetLoadError()
	 * 
	 * If the plugin failed to load, returns the error message for the failure.
	 * 
	 * @author Krystilize
	 *
	 */
	class GetLoadError extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			return plugin.get("Error");
		}
	}

	/**
	 * LuaAPI cPlugin:GetLocalFolder()
	 * 
	 * Returns the path where the plugin's files are. (Plugins/APIDump)
	 * 
	 * @author Krystilize
	 *
	 */
	class GetLocalFolder extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			return LuaValue.valueOf(System.getProperty("user.dir") + "\\CuberitePlugins\\"
					+ plugin.get("FolderName").toString() + "\\");
		}
	}

	/**
	 * LuaAPI cPlugin:GetName()
	 * 
	 * Returns the name of the plugin
	 * 
	 * @author Krystilize
	 *
	 */
	class GetName extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			return plugin.get("Name");
		}
	}

	/**
	 * LuaAPI cPlugin:GetStatus()
	 * 
	 * Returns the status of the plugin (loaded, disabled, unloaded, error, not
	 * found)
	 * 
	 * @author Krystilize
	 *
	 */
	class GetStatus extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			return plugin.get("Status");
		}
	}

	/**
	 * LuaAPI cPlugin:GetVersion()
	 * 
	 * Returns the version of the plugin.
	 * 
	 * @author Krystilize
	 *
	 */
	class GetVersion extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			return plugin.get("Version");
		}
	}

	/**
	 * LuaAPI cPlugin:IsLoaded()
	 * 
	 * @author Krystilize
	 *
	 */
	class IsLoaded extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			return LuaValue.valueOf(plugin.get("Status").toint() == ePluginStatus.psLoaded);
		}
	}

	/**
	 * LuaAPI cPlugin:SetName()
	 * 
	 * Sets the API name of the Plugin that is used by cPluginManager:CallPlugin()
	 * to identify the plugin.
	 * 
	 * @author Krystilize
	 *
	 */
	class SetName extends TwoArgFunction {
		@Override
		public LuaValue call(LuaValue plugin, LuaValue value) {
			plugin.set("Name", value);
			return LuaValue.NIL;
		}
	}

	/**
	 * LuaAPI cPlugin:SetVersion()
	 * 
	 * Sets the API version of the plugin. Currently unused.
	 * 
	 * @author Krystilize
	 *
	 */
	class SetVersion extends TwoArgFunction {
		@Override
		public LuaValue call(LuaValue plugin, LuaValue value) {
			plugin.set("Version", value);
			return LuaValue.NIL;
		}
	}

	class ToString extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			String output = "cPlugin(" + plugin.get("Name").tojstring() + ", " + plugin.get("Version").tojstring()
					+ ")";
			return LuaValue.valueOf(output);
		}
	}

	static class Concat extends TwoArgFunction {
		@Override
		public LuaValue call(LuaValue valueA, LuaValue valueB) {
			String stringA = valueA.tojstring();
			String stringB = valueB.tojstring();
			LuaValue functionA = valueA.getmetatable().get("__tostring");
			LuaValue functionB = valueB.getmetatable().get("__tostring");

			if (functionA.isfunction()) {
				stringA = functionA.call(valueA).tojstring();
			}

			if (functionB.isfunction()) {
				stringB = functionB.call(valueB).tojstring();
			}

			return LuaValue.valueOf(stringA.concat(stringB));
		}
	}

	private void registerCallbacks() {

		luaValue.set("GetFolderName", new GetFolderName());
		luaValue.set("GetLoadError", new GetLoadError());
		luaValue.set("GetLocalFolder", new GetLocalFolder());
		luaValue.set("GetName", new GetName());
		luaValue.set("GetStatus", new GetStatus());
		luaValue.set("GetVersion", new GetVersion());
		luaValue.set("IsLoaded", new IsLoaded());
		luaValue.set("SetName", new SetName());
		luaValue.set("SetVersion", new SetVersion());

		// metatable
		LuaValue metatable = LuaValue.tableOf();

		metatable.set("__tostring", new ToString());
		metatable.set("__concat", new Concat());

		luaValue.setmetatable(metatable);

	}
}
