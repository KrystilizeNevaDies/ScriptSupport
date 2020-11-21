package cuberiteAPI;

import java.util.ArrayList;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

import cuberiteAPI.hooks.hHOOK_BLOCK_SPREAD;
import cuberiteAPI.hooks.hHOOK_BLOCK_TO_PICKUPS;
import cuberiteAPI.hooks.hHOOK_BREWING_COMPLETED;
import cuberiteAPI.hooks.hHOOK_BREWING_COMPLETING;
import cuberiteAPI.hooks.hHOOK_CHAT;
import cuberiteAPI.hooks.hHOOK_CHUNK_AVAILABLE;
import cuberiteAPI.hooks.hHOOK_CHUNK_GENERATED;
import cuberiteAPI.hooks.hHOOK_CHUNK_GENERATING;
import cuberiteAPI.hooks.hHOOK_CHUNK_UNLOADED;
import cuberiteAPI.hooks.hHOOK_CHUNK_UNLOADING;
import cuberiteAPI.hooks.hHOOK_COLLECTING_PICKUP;
import cuberiteAPI.hooks.hHOOK_CRAFTING_NO_RECIPE;
import cuberiteAPI.hooks.hHOOK_DISCONNECT;
import cuberiteAPI.hooks.hHOOK_DROPSPENSE;
import cuberiteAPI.hooks.hHOOK_ENTITY_ADD_EFFECT;
import cuberiteAPI.hooks.hHOOK_ENTITY_CHANGED_WORLD;
import cuberiteAPI.hooks.hHOOK_ENTITY_CHANGING_WORLD;
import cuberiteAPI.hooks.hHOOK_ENTITY_TELEPORT;
import cuberiteAPI.hooks.hHOOK_EXECUTE_COMMAND;
import cuberiteAPI.hooks.hHOOK_EXPLODED;
import cuberiteAPI.hooks.hHOOK_EXPLODING;
import cuberiteAPI.hooks.hHOOK_HANDSHAKE;
import cuberiteAPI.hooks.hHOOK_HOPPER_PULLING_ITEM;
import cuberiteAPI.hooks.hHOOK_HOPPER_PUSHING_ITEM;
import cuberiteAPI.hooks.hHOOK_KILLED;
import cuberiteAPI.hooks.hHOOK_KILLING;
import cuberiteAPI.hooks.hHOOK_LOGIN;
import cuberiteAPI.hooks.hHOOK_LOGIN_FORGE;
import cuberiteAPI.hooks.hHOOK_PLAYER_ANIMATION;
import cuberiteAPI.hooks.hHOOK_PLAYER_BREAKING_BLOCK;
import cuberiteAPI.hooks.hHOOK_PLAYER_BROKEN_BLOCK;
import cuberiteAPI.hooks.hHOOK_PLAYER_CROUCHED;
import cuberiteAPI.hooks.hHOOK_PLAYER_DESTROYED;
import cuberiteAPI.hooks.hHOOK_PLAYER_EATING;
import cuberiteAPI.hooks.hHOOK_PLAYER_FISHED;
import cuberiteAPI.hooks.hHOOK_PLAYER_FISHING;
import cuberiteAPI.hooks.hHOOK_PLAYER_FOOD_LEVEL_CHANGE;
import cuberiteAPI.hooks.hHOOK_PLAYER_JOINED;
import cuberiteAPI.hooks.hHOOK_PLAYER_LEFT_CLICK;
import cuberiteAPI.hooks.hHOOK_PLAYER_MOVING;
import cuberiteAPI.hooks.hHOOK_PLAYER_OPENING_WINDOW;
import cuberiteAPI.hooks.hHOOK_PLAYER_PLACED_BLOCK;
import cuberiteAPI.hooks.hHOOK_PLAYER_PLACING_BLOCK;
import cuberiteAPI.hooks.hHOOK_PLAYER_RIGHT_CLICK;
import cuberiteAPI.hooks.hHOOK_PLAYER_RIGHT_CLICKING_ENTITY;
import cuberiteAPI.hooks.hHOOK_PLAYER_SHOOTING;
import cuberiteAPI.hooks.hHOOK_PLAYER_SPAWNED;
import cuberiteAPI.hooks.hHOOK_PLAYER_TOSSING_ITEM;
import cuberiteAPI.hooks.hHOOK_PLAYER_USED_BLOCK;
import cuberiteAPI.hooks.hHOOK_PLAYER_USED_ITEM;
import cuberiteAPI.hooks.hHOOK_PLAYER_USING_BLOCK;
import cuberiteAPI.hooks.hHOOK_PLAYER_USING_ITEM;
import cuberiteAPI.hooks.hHOOK_PLUGINS_LOADED;
import cuberiteAPI.hooks.hHOOK_PLUGIN_MESSAGE;
import cuberiteAPI.hooks.hHOOK_POST_CRAFTING;
import cuberiteAPI.hooks.hHOOK_PRE_CRAFTING;
import cuberiteAPI.hooks.hHOOK_PROJECTILE_HIT_BLOCK;
import cuberiteAPI.hooks.hHOOK_PROJECTILE_HIT_ENTITY;
import cuberiteAPI.hooks.hHOOK_SERVER_PING;
import cuberiteAPI.hooks.hHOOK_SPAWNED_ENTITY;
import cuberiteAPI.hooks.hHOOK_SPAWNED_MONSTER;
import cuberiteAPI.hooks.hHOOK_SPAWNING_ENTITY;
import cuberiteAPI.hooks.hHOOK_SPAWNING_MONSTER;
import cuberiteAPI.hooks.hHOOK_TAKE_DAMAGE;
import cuberiteAPI.hooks.hHOOK_TICK;
import cuberiteAPI.hooks.hHOOK_UPDATED_SIGN;
import cuberiteAPI.hooks.hHOOK_UPDATING_SIGN;
import cuberiteAPI.hooks.hHOOK_WEATHER_CHANGED;
import cuberiteAPI.hooks.hHOOK_WEATHER_CHANGING;
import cuberiteAPI.hooks.hHOOK_WORLD_STARTED;
import cuberiteAPI.hooks.hHOOK_WORLD_TICK;
import cuberitePluginSupport.Plugin;
import net.minestom.server.command.CommandProcessor;
import net.minestom.server.command.CommandSender;
import net.minestom.server.entity.Player;

public class cPluginManager {
	
	private Plugin plugin;
	
	class AddHook extends ThreeArgFunction {
		/**
		 * HookType	PluginHook
		 * Callback	function
		 * (STATIC) Informs the plugin manager that it should call the specified function when the specified hook event occurs. If a function is not specified, a default global function name is looked up, based on the hook type
		 */
		public LuaValue call(LuaValue v1, LuaValue v2, LuaValue v3) {
			// if call is static
			int hook;
			LuaValue function;
			
			if (v1.equals(plugin.globals.get("cPluginManager"))) {
				hook = v2.toint();
				function = v3;
			} else {
				hook = v1.toint();
				function = v2;
			}
			
			if (function.isfunction())
				addHook(hook, function);
			else
				System.out.println("ERROR: cPluginManager: AddHook(" + hook + ", " + function + "): function is not a function");
			
			return LuaValue.NIL;
		}
	}
	
	class BindCommand extends VarArgFunction {
		/**
		 * Command	string
		 * Permission	string
		 * Callback	function
		 * HelpString	string
		 * boolean
		 * Binds an in-game command with the specified callback function, permission and help string. By common convention, providing an empty string for HelpString will hide the command from the /help display. Returns true if successful, logs to console and returns no value on error. The callback uses the following signature:
		 * function(Split, Player)The Split parameter contains an array-table of the words that the player has sent, Player is the cPlayer object representing the player who sent the command. If the callback returns true, the command is assumed to have executed successfully; in all other cases the server sends a warning to the player that the command is unknown (this is so that subcommands can be implemented).
		 */
		public LuaValue call(LuaValue[] array, Varargs varargs) {
			// Construct command
			String name = array[0].tojstring();
			String perm = array[1].tojstring();
			LuaValue func = array[2];
			String help = array[3].tojstring();
			
			// Create command
			new PlayerCommand(name, perm, func, help);
			
			return LuaValue.TRUE;
		}
	}
	
	class BindConsoleCommand extends VarArgFunction {
		/**
		 * Command	string
		 * Callback	function
		 * HelpString	string
		 * boolean
		 * (STATIC) Binds a console command with the specified callback function and help string. By common convention, providing an empty string for HelpString will hide the command from the "help" console command. Returns true if successful, logs to console and returns no value on error. The callback uses the following signature:
		 * function(Split)The Split parameter contains an array-table of the words that the admin has typed. If the callback returns true, the command is assumed to have executed successfully; in all other cases the server issues a warning to the console that the command is unknown (this is so that subcommands can be implemented).
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class CallPlugin extends VarArgFunction {
		/**
		 * PluginName	string
		 * FunctionName	string
		 * FunctionArgs...	...
		 * FunctionRets	...
		 * (STATIC) Calls the specified function in the specified plugin, passing all the given arguments to it. If it succeeds, it returns all the values returned by that function. If it fails, returns no value at all. Note that only strings, numbers, bools, nils, API classes and simple tables can be used for parameters and return values; functions cannot be copied across plugins.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class DoWithPlugin extends VarArgFunction {
		/**
		 * PluginName	string
		 * CallbackFn	function
		 * boolean
		 * (STATIC) Calls the CallbackFn for the specified plugin, if found. A plugin can be found even if it is currently unloaded, disabled or errored, the callback should check the plugin status. If the plugin is not found, this function returns false, otherwise it returns the bool value that the callback has returned. The CallbackFn has the following signature:
		 * function (Plugin)
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class ExecuteCommand extends VarArgFunction {
		/**
		 * Player	cPlayer
		 * CommandStr	string
		 * CommandResult	CommandResult
		 * Executes the command as if given by the specified Player. Checks permissions.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class ExecuteConsoleCommand extends VarArgFunction {
		/**
		 * CommandStr	string
		 * boolean
		 * string
		 * Executes the console command as if given by the admin on the console. If the command is successfully executed, returns true and the text that would be output to the console normally. On error it returns false and an error message.
		 * FindPlugins			OBSOLETE, use RefreshPluginList() instead
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class ForEachCommand extends VarArgFunction {
		/**
		 * CallbackFn	function
		 * boolean
		 * Calls the CallbackFn function for each command that has been bound using BindCommand(). The CallbackFn has the following signature:
		 * function(Command, Permission, HelpString)If the callback returns true, the enumeration is aborted and this API function returns false; if it returns false or no value, the enumeration continues with the next command, and the API function returns true.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class ForEachConsoleCommand extends VarArgFunction {
		/**
		 * CallbackFn	function
		 * boolean
		 * Calls the CallbackFn function for each command that has been bound using BindConsoleCommand(). The CallbackFn has the following signature:
		 * function (Command, HelpString)If the callback returns true, the enumeration is aborted and this API function returns false; if it returns false or no value, the enumeration continues with the next command, and the API function returns true.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class ForEachPlugin extends VarArgFunction {
		/**
		 * CallbackFn	function
		 * boolean
		 * Calls the CallbackFn function for each plugin that is currently discovered by Cuberite (including disabled, unloaded and errrored plugins). The CallbackFn has the following signature:
		 * function (Plugin)If the callback returns true, the enumeration is aborted and this API function returns false; if it returns false or no value, the enumeration continues with the next command, and the API function returns true.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class ForceExecuteCommand extends VarArgFunction {
		/**
		 * Player	cPlayer
		 * CommandStr	string
		 * CommandResult	CommandResult
		 * Same as ExecuteCommand, but doesn't check permissions
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class Get extends VarArgFunction {
		/**	
		 * cPluginManager
		 * (STATIC) Returns the single instance of the plugin manager
		 */
		public LuaValue call(LuaValue value) {
			return value;
		}
	}
	
	class GetAllPlugins extends VarArgFunction {
		/**	
		 * table
		 * Returns a table (dictionary) of all plugins, [name => value], where value is a valid cPlugin if the plugin is loaded, or the bool value false if the plugin is not loaded.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class GetCommandPermission extends VarArgFunction {
		/**
		 * Command	string
		 * Permission	string
		 * Returns the permission needed for executing the specified command
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class GetCurrentPlugin extends VarArgFunction {
		/**	
		 * cPlugin
		 * Returns the cPlugin object for the calling plugin. This is the same object that the Initialize function receives as the argument.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class GetNumLoadedPlugins extends VarArgFunction {
		/**	
		 * number
		 * Returns the number of loaded plugins (psLoaded only)
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class GetNumPlugins extends VarArgFunction {
		/**	
		 * number
		 * Returns the number of plugins, including the disabled, errored, unloaded and not-found ones
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class GetPlugin extends VarArgFunction {
		/**
		 * PluginName	string
		 * cPlugin
		 * (DEPRECATED, UNSAFE) Returns a plugin handle of the specified plugin, or nil if such plugin is not loaded. Note thatdue to multithreading the handle is not guaranteed to be safe for use when stored - a single-plugin reload may have been triggered in the mean time for the requested plugin.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class GetPluginFolderName extends VarArgFunction {
		/**
		 * PluginName	string
		 * string
		 * Returns the name of the folder from which the plugin was loaded (without the "Plugins" part). Used as a plugin's display name.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class GetPluginsPath extends VarArgFunction {
		/**	
		 * string
		 * (STATIC) Returns the path where the individual plugin folders are located. Doesn't include the path separator at the end of the returned string.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class IsCommandBound extends VarArgFunction {
		/**
		 * Command	string
		 * boolean
		 * Returns true if in-game Command is already bound (by any plugin)
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class IsConsoleCommandBound extends VarArgFunction {
		/**
		 * Command	string
		 * boolean
		 * Returns true if console Command is already bound (by any plugin)
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class IsPluginLoaded extends VarArgFunction {
		/**
		 * PluginName	string
		 * Returns true if the specified plugin is loaded.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class LoadPlugin extends VarArgFunction {
		/**
		 * PluginFolder	string
		 * (DEPRECATED) Loads a plugin from the specified folder. NOTE: Loading plugins may be an unsafe operation and may result in a deadlock or a crash. This API is deprecated and might be removed.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class LogStackTrace extends VarArgFunction {
		/**		(STATIC) Logs a current stack trace of the Lua engine to the server console log. Same format as is used when the plugin fails.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class RefreshPluginList extends VarArgFunction {
		/**		Refreshes the list of plugins to include all folders inside the Plugins folder (potentially new disabled plugins)
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class ReloadPlugin extends VarArgFunction {
		/**
		 * PluginName	string
		 * Queues the specified plugin to be reloaded. To avoid deadlocks, the reloading happens in the main tick thread asynchronously.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class ReloadPlugins extends VarArgFunction {
		/**		Reloads all active plugins
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	class UnloadPlugin extends VarArgFunction {
		/**
		 * PluginName	string
		 * Queues the specified plugin to be unloaded. To avoid deadlocks, the unloading happens in the main tick thread asynchronously.
		 */
		public LuaValue call(LuaValue value) {
			System.out.println("This is not yet implemented");
			return LuaValue.NIL;
		}
	}
	
	public static void addHook(int hook, LuaValue function) {
		
		
		try { // Errors may be present
			
			switch (hook) {
				case 0: hHOOK_BLOCK_SPREAD.INSTANCE.add(function);
				case 1: hHOOK_BLOCK_TO_PICKUPS.INSTANCE.add(function);
				case 2: hHOOK_BREWING_COMPLETED.INSTANCE.add(function);
				case 3: hHOOK_BREWING_COMPLETING.INSTANCE.add(function);
				case 4: hHOOK_CHAT.INSTANCE.add(function);
				case 5: hHOOK_CHUNK_AVAILABLE.INSTANCE.add(function);
				case 6: hHOOK_CHUNK_GENERATED.INSTANCE.add(function);
				case 7: hHOOK_CHUNK_GENERATING.INSTANCE.add(function);
				case 8: hHOOK_CHUNK_UNLOADED.INSTANCE.add(function);
				case 9: hHOOK_CHUNK_UNLOADING.INSTANCE.add(function);
				case 10: hHOOK_COLLECTING_PICKUP.INSTANCE.add(function);
				case 11: hHOOK_CRAFTING_NO_RECIPE.INSTANCE.add(function);
				case 12: hHOOK_DISCONNECT.INSTANCE.add(function);
				case 13: hHOOK_DROPSPENSE.INSTANCE.add(function);
				case 14: hHOOK_ENTITY_ADD_EFFECT.INSTANCE.add(function);
				case 15: hHOOK_ENTITY_CHANGED_WORLD.INSTANCE.add(function);
				case 16: hHOOK_ENTITY_CHANGING_WORLD.INSTANCE.add(function);
				case 17: hHOOK_ENTITY_TELEPORT.INSTANCE.add(function);
				case 18: hHOOK_EXECUTE_COMMAND.INSTANCE.add(function);
				case 19: hHOOK_EXPLODED.INSTANCE.add(function);
				case 20: hHOOK_EXPLODING.INSTANCE.add(function);
				case 21: hHOOK_HANDSHAKE.INSTANCE.add(function);
				case 22: hHOOK_HOPPER_PULLING_ITEM.INSTANCE.add(function);
				case 23: hHOOK_HOPPER_PUSHING_ITEM.INSTANCE.add(function);
				case 24: hHOOK_KILLED.INSTANCE.add(function);
				case 25: hHOOK_KILLING.INSTANCE.add(function);
				case 26: hHOOK_LOGIN.INSTANCE.add(function);
				case 27: hHOOK_LOGIN_FORGE.INSTANCE.add(function);
				case 28: hHOOK_PLAYER_ANIMATION.INSTANCE.add(function);
				case 29: hHOOK_PLAYER_BREAKING_BLOCK.INSTANCE.add(function);
				case 30: hHOOK_PLAYER_BROKEN_BLOCK.INSTANCE.add(function);
				case 31: hHOOK_PLAYER_CROUCHED.INSTANCE.add(function);
				case 32: hHOOK_PLAYER_DESTROYED.INSTANCE.add(function);
				case 33: hHOOK_PLAYER_EATING.INSTANCE.add(function);
				case 34: hHOOK_PLAYER_FISHED.INSTANCE.add(function);
				case 35: hHOOK_PLAYER_FISHING.INSTANCE.add(function);
				case 36: hHOOK_PLAYER_FOOD_LEVEL_CHANGE.INSTANCE.add(function);
				case 37: hHOOK_PLAYER_JOINED.INSTANCE.add(function);
				case 38: hHOOK_PLAYER_LEFT_CLICK.INSTANCE.add(function);
				case 39: hHOOK_PLAYER_MOVING.INSTANCE.add(function);
				case 40: hHOOK_PLAYER_OPENING_WINDOW.INSTANCE.add(function);
				case 41: hHOOK_PLAYER_PLACED_BLOCK.INSTANCE.add(function);
				case 42: hHOOK_PLAYER_PLACING_BLOCK.INSTANCE.add(function);
				case 43: hHOOK_PLAYER_RIGHT_CLICK.INSTANCE.add(function);
				case 44: hHOOK_PLAYER_RIGHT_CLICKING_ENTITY.INSTANCE.add(function);
				case 45: hHOOK_PLAYER_SHOOTING.INSTANCE.add(function);
				case 46: hHOOK_PLAYER_SPAWNED.INSTANCE.add(function);
				case 47: hHOOK_PLAYER_TOSSING_ITEM.INSTANCE.add(function);
				case 48: hHOOK_PLAYER_USED_BLOCK.INSTANCE.add(function);
				case 49: hHOOK_PLAYER_USED_ITEM.INSTANCE.add(function);
				case 50: hHOOK_PLAYER_USING_BLOCK.INSTANCE.add(function);
				case 51: hHOOK_PLAYER_USING_ITEM.INSTANCE.add(function);
				case 52: hHOOK_PLUGINS_LOADED.INSTANCE.add(function);
				case 53: hHOOK_PLUGIN_MESSAGE.INSTANCE.add(function);
				case 54: hHOOK_POST_CRAFTING.INSTANCE.add(function);
				case 55: hHOOK_PRE_CRAFTING.INSTANCE.add(function);
				case 56: hHOOK_PROJECTILE_HIT_BLOCK.INSTANCE.add(function);
				case 57: hHOOK_PROJECTILE_HIT_ENTITY.INSTANCE.add(function);
				case 58: hHOOK_SERVER_PING.INSTANCE.add(function);
				case 59: hHOOK_SPAWNED_ENTITY.INSTANCE.add(function);
				case 60: hHOOK_SPAWNED_MONSTER.INSTANCE.add(function);
				case 61: hHOOK_SPAWNING_ENTITY.INSTANCE.add(function);
				case 62: hHOOK_SPAWNING_MONSTER.INSTANCE.add(function);
				case 63: hHOOK_TAKE_DAMAGE.INSTANCE.add(function);
				case 64: hHOOK_TICK.INSTANCE.add(function);
				case 65: hHOOK_UPDATED_SIGN.INSTANCE.add(function);
				case 66: hHOOK_UPDATING_SIGN.INSTANCE.add(function);
				case 67: hHOOK_WEATHER_CHANGED.INSTANCE.add(function);
				case 68: hHOOK_WEATHER_CHANGING.INSTANCE.add(function);
				case 69: hHOOK_WORLD_STARTED.INSTANCE.add(function);
				case 70: hHOOK_WORLD_TICK.INSTANCE.add(function);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public cPluginManager(Plugin somePlugin, LuaValue luaTable) {
		LuaValue luaValue = LuaValue.tableOf();
		
		this.plugin = somePlugin;
		
		luaValue.set("AddHook", new AddHook());
		luaValue.set("BindCommand", new BindCommand());
		luaValue.set("BindConsoleCommand", new BindConsoleCommand());
		luaValue.set("CallPlugin", new CallPlugin());
		luaValue.set("DoWithPlugin", new DoWithPlugin());
		luaValue.set("ExecuteCommand", new ExecuteCommand());
		luaValue.set("ExecuteConsoleCommand", new ExecuteConsoleCommand());
		luaValue.set("ForEachCommand", new ForEachCommand());
		luaValue.set("ForEachConsoleCommand", new ForEachConsoleCommand());
		luaValue.set("ForEachPlugin", new ForEachPlugin());
		luaValue.set("ForceExecuteCommand", new ForceExecuteCommand());
		luaValue.set("Get", new Get());
		luaValue.set("GetAllPlugins", new GetAllPlugins());
		luaValue.set("GetCommandPermission", new GetCommandPermission());
		luaValue.set("GetCurrentPlugin", new GetCurrentPlugin());
		luaValue.set("GetNumLoadedPlugins", new GetNumLoadedPlugins());
		luaValue.set("GetNumPlugins", new GetNumPlugins());
		luaValue.set("GetPlugin", new GetPlugin());
		luaValue.set("GetPluginFolderName", new GetPluginFolderName());
		luaValue.set("GetPluginsPath", new GetPluginsPath());
		luaValue.set("IsCommandBound", new IsCommandBound());
		luaValue.set("IsConsoleCommandBound", new IsConsoleCommandBound());
		luaValue.set("IsPluginLoaded", new IsPluginLoaded());
		luaValue.set("LoadPlugin", new LoadPlugin());
		luaValue.set("LogStackTrace", new LogStackTrace());
		luaValue.set("RefreshPluginList", new RefreshPluginList());
		luaValue.set("ReloadPlugin", new ReloadPlugin());
		luaValue.set("ReloadPlugins", new ReloadPlugins());
		luaValue.set("UnloadPlugin", new UnloadPlugin());
		
		luaValue.set("HOOK_BLOCK_SPREAD", LuaValue.valueOf(0));
		luaValue.set("HOOK_BLOCK_TO_PICKUPS", LuaValue.valueOf(1));
		luaValue.set("HOOK_BREWING_COMPLETED", LuaValue.valueOf(2));
		luaValue.set("HOOK_BREWING_COMPLETING", LuaValue.valueOf(3));
		luaValue.set("HOOK_CHAT", LuaValue.valueOf(4));
		luaValue.set("HOOK_CHUNK_AVAILABLE", LuaValue.valueOf(5));
		luaValue.set("HOOK_CHUNK_GENERATED", LuaValue.valueOf(6));
		luaValue.set("HOOK_CHUNK_GENERATING", LuaValue.valueOf(7));
		luaValue.set("HOOK_CHUNK_UNLOADED", LuaValue.valueOf(8));
		luaValue.set("HOOK_CHUNK_UNLOADING", LuaValue.valueOf(9));
		luaValue.set("HOOK_COLLECTING_PICKUP", LuaValue.valueOf(10));
		luaValue.set("HOOK_CRAFTING_NO_RECIPE", LuaValue.valueOf(11));
		luaValue.set("HOOK_DISCONNECT", LuaValue.valueOf(12));
		luaValue.set("HOOK_DROPSPENSE", LuaValue.valueOf(13));
		luaValue.set("HOOK_ENTITY_ADD_EFFECT", LuaValue.valueOf(14));
		luaValue.set("HOOK_ENTITY_CHANGED_WORLD", LuaValue.valueOf(15));
		luaValue.set("HOOK_ENTITY_CHANGING_WORLD", LuaValue.valueOf(16));
		luaValue.set("HOOK_ENTITY_TELEPORT", LuaValue.valueOf(17));
		luaValue.set("HOOK_EXECUTE_COMMAND", LuaValue.valueOf(18));
		luaValue.set("HOOK_EXPLODED", LuaValue.valueOf(19));
		luaValue.set("HOOK_EXPLODING", LuaValue.valueOf(20));
		luaValue.set("HOOK_HANDSHAKE", LuaValue.valueOf(21));
		luaValue.set("HOOK_HOPPER_PULLING_ITEM", LuaValue.valueOf(22));
		luaValue.set("HOOK_HOPPER_PUSHING_ITEM", LuaValue.valueOf(23));
		luaValue.set("HOOK_KILLED", LuaValue.valueOf(24));
		luaValue.set("HOOK_KILLING", LuaValue.valueOf(25));
		luaValue.set("HOOK_LOGIN", LuaValue.valueOf(26));
		luaValue.set("HOOK_LOGIN_FORGE", LuaValue.valueOf(27));
		luaValue.set("HOOK_PLAYER_ANIMATION", LuaValue.valueOf(28));
		luaValue.set("HOOK_PLAYER_BREAKING_BLOCK", LuaValue.valueOf(29));
		luaValue.set("HOOK_PLAYER_BROKEN_BLOCK", LuaValue.valueOf(30));
		luaValue.set("HOOK_PLAYER_CROUCHED", LuaValue.valueOf(31));
		luaValue.set("HOOK_PLAYER_DESTROYED", LuaValue.valueOf(32));
		luaValue.set("HOOK_PLAYER_EATING", LuaValue.valueOf(33));
		luaValue.set("HOOK_PLAYER_FISHED", LuaValue.valueOf(34));
		luaValue.set("HOOK_PLAYER_FISHING", LuaValue.valueOf(35));
		luaValue.set("HOOK_PLAYER_FOOD_LEVEL_CHANGE", LuaValue.valueOf(36));
		luaValue.set("HOOK_PLAYER_JOINED", LuaValue.valueOf(37));
		luaValue.set("HOOK_PLAYER_LEFT_CLICK", LuaValue.valueOf(38));
		luaValue.set("HOOK_PLAYER_MOVING", LuaValue.valueOf(39));
		luaValue.set("HOOK_PLAYER_OPENING_WINDOW", LuaValue.valueOf(40));
		luaValue.set("HOOK_PLAYER_PLACED_BLOCK", LuaValue.valueOf(41));
		luaValue.set("HOOK_PLAYER_PLACING_BLOCK", LuaValue.valueOf(42));
		luaValue.set("HOOK_PLAYER_RIGHT_CLICK", LuaValue.valueOf(43));
		luaValue.set("HOOK_PLAYER_RIGHT_CLICKING_ENTITY", LuaValue.valueOf(44));
		luaValue.set("HOOK_PLAYER_SHOOTING", LuaValue.valueOf(45));
		luaValue.set("HOOK_PLAYER_SPAWNED", LuaValue.valueOf(46));
		luaValue.set("HOOK_PLAYER_TOSSING_ITEM", LuaValue.valueOf(47));
		luaValue.set("HOOK_PLAYER_USED_BLOCK", LuaValue.valueOf(48));
		luaValue.set("HOOK_PLAYER_USED_ITEM", LuaValue.valueOf(49));
		luaValue.set("HOOK_PLAYER_USING_BLOCK", LuaValue.valueOf(50));
		luaValue.set("HOOK_PLAYER_USING_ITEM", LuaValue.valueOf(51));
		luaValue.set("HOOK_PLUGINS_LOADED", LuaValue.valueOf(52));
		luaValue.set("HOOK_PLUGIN_MESSAGE", LuaValue.valueOf(53));
		luaValue.set("HOOK_POST_CRAFTING", LuaValue.valueOf(54));
		luaValue.set("HOOK_PRE_CRAFTING", LuaValue.valueOf(55));
		luaValue.set("HOOK_PROJECTILE_HIT_BLOCK", LuaValue.valueOf(56));
		luaValue.set("HOOK_PROJECTILE_HIT_ENTITY", LuaValue.valueOf(57));
		luaValue.set("HOOK_SERVER_PING", LuaValue.valueOf(58));
		luaValue.set("HOOK_SPAWNED_ENTITY", LuaValue.valueOf(59));
		luaValue.set("HOOK_SPAWNED_MONSTER", LuaValue.valueOf(60));
		luaValue.set("HOOK_SPAWNING_ENTITY", LuaValue.valueOf(61));
		luaValue.set("HOOK_SPAWNING_MONSTER", LuaValue.valueOf(62));
		luaValue.set("HOOK_TAKE_DAMAGE", LuaValue.valueOf(63));
		luaValue.set("HOOK_TICK", LuaValue.valueOf(64));
		luaValue.set("HOOK_UPDATED_SIGN", LuaValue.valueOf(65));
		luaValue.set("HOOK_UPDATING_SIGN", LuaValue.valueOf(66));
		luaValue.set("HOOK_WEATHER_CHANGED", LuaValue.valueOf(67));
		luaValue.set("HOOK_WEATHER_CHANGING", LuaValue.valueOf(68));
		luaValue.set("HOOK_WORLD_STARTED", LuaValue.valueOf(69));
		luaValue.set("HOOK_WORLD_TICK", LuaValue.valueOf(70));
		
		plugin.globals.set("cPluginManager", luaValue);
		
	}

	private class PlayerCommand implements CommandProcessor {
		
		
		
		
		private String name;
		private String perm;
		private LuaValue callback;
		private String help;
		

		PlayerCommand(String cmdName, String cmdPerm, LuaValue cmdCallback, String cmdHelp) {
			name = cmdName;
			perm = cmdPerm;
			callback = cmdCallback;
			help = cmdHelp;
		}
		
	    @Override
	    public String getCommandName() {
	        return name;
	    }

	    @Override
	    public String[] getAliases() {
	        return new String[]{};
	    }

	    @Override
	    public boolean enableWritingTracking() {
	        return false;
	    }

		@Override
		public boolean process(CommandSender sender, String command, String[] args) {
			if (sender.isConsole()) {
				return false;
			}
			// Create table of args
			LuaTable split = LuaTable.tableOf();
			split.add(LuaValue.valueOf(command));
			
			for (int i = 0; i < args.length; i++) {
				split.add(LuaValue.valueOf(args[i]));
			}
			
			// Call the callback
			if (callback.call(split, new cPlayer(sender.asPlayer()).luaValue).equals(LuaValue.FALSE)) {
				sender.sendMessage("Unknown command.");
			}
			
			return true;
		}

		@Override
		public boolean hasAccess(Player player) {
			// TODO: research and found how this is corectly done in cuberite
			ArrayList<String> perms = player.getData().get("Permissions");
			return perms.contains(perm);
		}
		
		@SuppressWarnings("unused")
		public String getHelp() {
			return help;
		}
		
	}
}