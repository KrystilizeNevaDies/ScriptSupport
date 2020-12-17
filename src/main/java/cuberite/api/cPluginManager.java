package cuberite.api;

import java.util.ArrayList;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

import cuberite.api.hooks.HookManager;
import cuberite.api.hooks.hHOOK_BLOCK_SPREAD;
import cuberite.api.hooks.hHOOK_BLOCK_TO_PICKUPS;
import cuberite.api.hooks.hHOOK_BREWING_COMPLETED;
import cuberite.api.hooks.hHOOK_BREWING_COMPLETING;
import cuberite.api.hooks.hHOOK_CHAT;
import cuberite.api.hooks.hHOOK_CHUNK_AVAILABLE;
import cuberite.api.hooks.hHOOK_CHUNK_GENERATED;
import cuberite.api.hooks.hHOOK_CHUNK_GENERATING;
import cuberite.api.hooks.hHOOK_CHUNK_UNLOADED;
import cuberite.api.hooks.hHOOK_CHUNK_UNLOADING;
import cuberite.api.hooks.hHOOK_COLLECTING_PICKUP;
import cuberite.api.hooks.hHOOK_CRAFTING_NO_RECIPE;
import cuberite.api.hooks.hHOOK_DISCONNECT;
import cuberite.api.hooks.hHOOK_DROPSPENSE;
import cuberite.api.hooks.hHOOK_ENTITY_ADD_EFFECT;
import cuberite.api.hooks.hHOOK_ENTITY_CHANGED_WORLD;
import cuberite.api.hooks.hHOOK_ENTITY_CHANGING_WORLD;
import cuberite.api.hooks.hHOOK_ENTITY_TELEPORT;
import cuberite.api.hooks.hHOOK_EXECUTE_COMMAND;
import cuberite.api.hooks.hHOOK_EXPLODED;
import cuberite.api.hooks.hHOOK_EXPLODING;
import cuberite.api.hooks.hHOOK_HANDSHAKE;
import cuberite.api.hooks.hHOOK_HOPPER_PULLING_ITEM;
import cuberite.api.hooks.hHOOK_HOPPER_PUSHING_ITEM;
import cuberite.api.hooks.hHOOK_KILLED;
import cuberite.api.hooks.hHOOK_KILLING;
import cuberite.api.hooks.hHOOK_LOGIN;
import cuberite.api.hooks.hHOOK_LOGIN_FORGE;
import cuberite.api.hooks.hHOOK_PLAYER_ANIMATION;
import cuberite.api.hooks.hHOOK_PLAYER_BREAKING_BLOCK;
import cuberite.api.hooks.hHOOK_PLAYER_BROKEN_BLOCK;
import cuberite.api.hooks.hHOOK_PLAYER_CROUCHED;
import cuberite.api.hooks.hHOOK_PLAYER_DESTROYED;
import cuberite.api.hooks.hHOOK_PLAYER_EATING;
import cuberite.api.hooks.hHOOK_PLAYER_FISHED;
import cuberite.api.hooks.hHOOK_PLAYER_FISHING;
import cuberite.api.hooks.hHOOK_PLAYER_FOOD_LEVEL_CHANGE;
import cuberite.api.hooks.hHOOK_PLAYER_JOINED;
import cuberite.api.hooks.hHOOK_PLAYER_LEFT_CLICK;
import cuberite.api.hooks.hHOOK_PLAYER_MOVING;
import cuberite.api.hooks.hHOOK_PLAYER_OPENING_WINDOW;
import cuberite.api.hooks.hHOOK_PLAYER_PLACED_BLOCK;
import cuberite.api.hooks.hHOOK_PLAYER_PLACING_BLOCK;
import cuberite.api.hooks.hHOOK_PLAYER_RIGHT_CLICK;
import cuberite.api.hooks.hHOOK_PLAYER_RIGHT_CLICKING_ENTITY;
import cuberite.api.hooks.hHOOK_PLAYER_SHOOTING;
import cuberite.api.hooks.hHOOK_PLAYER_SPAWNED;
import cuberite.api.hooks.hHOOK_PLAYER_TOSSING_ITEM;
import cuberite.api.hooks.hHOOK_PLAYER_USED_BLOCK;
import cuberite.api.hooks.hHOOK_PLAYER_USED_ITEM;
import cuberite.api.hooks.hHOOK_PLAYER_USING_BLOCK;
import cuberite.api.hooks.hHOOK_PLAYER_USING_ITEM;
import cuberite.api.hooks.hHOOK_PLUGINS_LOADED;
import cuberite.api.hooks.hHOOK_PLUGIN_MESSAGE;
import cuberite.api.hooks.hHOOK_POST_CRAFTING;
import cuberite.api.hooks.hHOOK_PRE_CRAFTING;
import cuberite.api.hooks.hHOOK_PROJECTILE_HIT_BLOCK;
import cuberite.api.hooks.hHOOK_PROJECTILE_HIT_ENTITY;
import cuberite.api.hooks.hHOOK_SERVER_PING;
import cuberite.api.hooks.hHOOK_SPAWNED_ENTITY;
import cuberite.api.hooks.hHOOK_SPAWNED_MONSTER;
import cuberite.api.hooks.hHOOK_SPAWNING_ENTITY;
import cuberite.api.hooks.hHOOK_SPAWNING_MONSTER;
import cuberite.api.hooks.hHOOK_TAKE_DAMAGE;
import cuberite.api.hooks.hHOOK_TICK;
import cuberite.api.hooks.hHOOK_UPDATED_SIGN;
import cuberite.api.hooks.hHOOK_UPDATING_SIGN;
import cuberite.api.hooks.hHOOK_WEATHER_CHANGED;
import cuberite.api.hooks.hHOOK_WEATHER_CHANGING;
import cuberite.api.hooks.hHOOK_WORLD_STARTED;
import cuberite.api.hooks.hHOOK_WORLD_TICK;
import lua.plugin.Plugin;
import net.minestom.server.command.CommandProcessor;
import net.minestom.server.command.CommandSender;
import net.minestom.server.entity.Player;

public class cPluginManager {

	private Plugin plugin;

	class AddHook extends ThreeArgFunction {
		/**
		 * HookType PluginHook Callback function (STATIC) Informs the plugin manager
		 * that it should call the specified function when the specified hook event
		 * occurs. If a function is not specified, a default global function name is
		 * looked up, based on the hook type
		 */
		@Override
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
				System.out.println(
						"ERROR: cPluginManager: AddHook(" + hook + ", " + function + "): function is not a function");

			return NIL;
		}
	}

	class BindCommand extends VarArgFunction {
		/**
		 * Command string Permission string Callback function HelpString string boolean
		 * Binds an in-game command with the specified callback function, permission and
		 * help string. By common convention, providing an empty string for HelpString
		 * will hide the command from the /help display. Returns true if successful,
		 * logs to console and returns no value on error. The callback uses the
		 * following signature: function(Split, Player)The Split parameter contains an
		 * array-table of the words that the player has sent, Player is the cPlayer
		 * object representing the player who sent the command. If the callback returns
		 * true, the command is assumed to have executed successfully; in all other
		 * cases the server sends a warning to the player that the command is unknown
		 * (this is so that subcommands can be implemented).
		 */
		public LuaValue call(LuaValue[] array, Varargs varargs) {
			// Construct command
			String name = array[0].tojstring();
			String perm = array[1].tojstring();
			LuaValue func = array[2];
			String help = array[3].tojstring();

			// Create command
			new PlayerCommand(name, perm, func, help);

			return TRUE;
		}
	}

	class BindConsoleCommand extends VarArgFunction {
		/**
		 * Command string Callback function HelpString string boolean (STATIC) Binds a
		 * console command with the specified callback function and help string. By
		 * common convention, providing an empty string for HelpString will hide the
		 * command from the "help" console command. Returns true if successful, logs to
		 * console and returns no value on error. The callback uses the following
		 * signature: function(Split)The Split parameter contains an array-table of the
		 * words that the admin has typed. If the callback returns true, the command is
		 * assumed to have executed successfully; in all other cases the server issues a
		 * warning to the console that the command is unknown (this is so that
		 * subcommands can be implemented).
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("BindConsoleCommand is not yet implemented");
			return NIL;
		}
	}

	class CallPlugin extends VarArgFunction {
		/**
		 * PluginName string FunctionName string FunctionArgs... ... FunctionRets ...
		 * (STATIC) Calls the specified function in the specified plugin, passing all
		 * the given arguments to it. If it succeeds, it returns all the values returned
		 * by that function. If it fails, returns no value at all. Note that only
		 * strings, numbers, bools, nils, API classes and simple tables can be used for
		 * parameters and return values; functions cannot be copied across plugins.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("CallPlugin is not yet implemented");
			return NIL;
		}
	}

	class DoWithPlugin extends VarArgFunction {
		/**
		 * PluginName string CallbackFn function boolean (STATIC) Calls the CallbackFn
		 * for the specified plugin, if found. A plugin can be found even if it is
		 * currently unloaded, disabled or errored, the callback should check the plugin
		 * status. If the plugin is not found, this function returns false, otherwise it
		 * returns the bool value that the callback has returned. The CallbackFn has the
		 * following signature: function (Plugin)
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("DoWithPlugin is not yet implemented");
			return NIL;
		}
	}

	class ExecuteCommand extends VarArgFunction {
		/**
		 * Player cPlayer CommandStr string CommandResult CommandResult Executes the
		 * command as if given by the specified Player. Checks permissions.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ExecuteCommand is not yet implemented");
			return NIL;
		}
	}

	class ExecuteConsoleCommand extends VarArgFunction {
		/**
		 * CommandStr string boolean string Executes the console command as if given by
		 * the admin on the console. If the command is successfully executed, returns
		 * true and the text that would be output to the console normally. On error it
		 * returns false and an error message. FindPlugins OBSOLETE, use
		 * RefreshPluginList() instead
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ExecuteConsoleCommand is not yet implemented");
			return NIL;
		}
	}

	class ForEachCommand extends VarArgFunction {
		/**
		 * CallbackFn function boolean Calls the CallbackFn function for each command
		 * that has been bound using BindCommand(). The CallbackFn has the following
		 * signature: function(Command, Permission, HelpString)If the callback returns
		 * true, the enumeration is aborted and this API function returns false; if it
		 * returns false or no value, the enumeration continues with the next command,
		 * and the API function returns true.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ForEachCommand is not yet implemented");
			return NIL;
		}
	}

	class ForEachConsoleCommand extends VarArgFunction {
		/**
		 * CallbackFn function boolean Calls the CallbackFn function for each command
		 * that has been bound using BindConsoleCommand(). The CallbackFn has the
		 * following signature: function (Command, HelpString)If the callback returns
		 * true, the enumeration is aborted and this API function returns false; if it
		 * returns false or no value, the enumeration continues with the next command,
		 * and the API function returns true.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ForEachConsoleCommand is not yet implemented");
			return NIL;
		}
	}

	class ForEachPlugin extends VarArgFunction {
		/**
		 * CallbackFn function boolean Calls the CallbackFn function for each plugin
		 * that is currently discovered by Cuberite (including disabled, unloaded and
		 * errrored plugins). The CallbackFn has the following signature: function
		 * (Plugin)If the callback returns true, the enumeration is aborted and this API
		 * function returns false; if it returns false or no value, the enumeration
		 * continues with the next command, and the API function returns true.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ForEachPlugin is not yet implemented");
			return NIL;
		}
	}

	class ForceExecuteCommand extends VarArgFunction {
		/**
		 * Player cPlayer CommandStr string CommandResult CommandResult Same as
		 * ExecuteCommand, but doesn't check permissions
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ForceExecuteCommand is not yet implemented");
			return NIL;
		}
	}

	class Get extends VarArgFunction {
		/**
		 * cPluginManager (STATIC) Returns the single instance of the plugin manager
		 */
		@Override
		public LuaValue call(LuaValue value) {
			return value;
		}
	}

	class GetAllPlugins extends VarArgFunction {
		/**
		 * table Returns a table (dictionary) of all plugins, [name => value], where
		 * value is a valid cPlugin if the plugin is loaded, or the bool value false if
		 * the plugin is not loaded.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("GetAllPlugins is not yet implemented");
			return NIL;
		}
	}

	class GetCommandPermission extends VarArgFunction {
		/**
		 * Command string Permission string Returns the permission needed for executing
		 * the specified command
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("GetCommandPermission is not yet implemented");
			return NIL;
		}
	}

	class GetCurrentPlugin extends VarArgFunction {
		/**
		 * cPlugin Returns the cPlugin object for the calling plugin. This is the same
		 * object that the Initialize function receives as the argument.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("GetCurrentPlugin is not yet implemented");
			return NIL;
		}
	}

	class GetNumLoadedPlugins extends VarArgFunction {
		/**
		 * number Returns the number of loaded plugins (psLoaded only)
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("GetNumLoadedPlugins is not yet implemented");
			return NIL;
		}
	}

	class GetNumPlugins extends VarArgFunction {
		/**
		 * number Returns the number of plugins, including the disabled, errored,
		 * unloaded and not-found ones
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("GetNumPlugins is not yet implemented");
			return NIL;
		}
	}

	class GetPlugin extends VarArgFunction {
		/**
		 * PluginName string cPlugin (DEPRECATED, UNSAFE) Returns a plugin handle of the
		 * specified plugin, or nil if such plugin is not loaded. Note thatdue to
		 * multithreading the handle is not guaranteed to be safe for use when stored -
		 * a single-plugin reload may have been triggered in the mean time for the
		 * requested plugin.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("GetPlugin is not yet implemented");
			return NIL;
		}
	}

	class GetPluginFolderName extends VarArgFunction {
		/**
		 * PluginName string string Returns the name of the folder from which the plugin
		 * was loaded (without the "Plugins" part). Used as a plugin's display name.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("GetPluginFolderName is not yet implemented");
			return NIL;
		}
	}

	class GetPluginsPath extends VarArgFunction {
		/**
		 * string (STATIC) Returns the path where the individual plugin folders are
		 * located. Doesn't include the path separator at the end of the returned
		 * string.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("GetPluginsPath is not yet implemented");
			return valueOf("");
		}
	}

	class IsCommandBound extends VarArgFunction {
		/**
		 * Command string boolean Returns true if in-game Command is already bound (by
		 * any plugin)
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("IsCommandBound is not yet implemented");
			return NIL;
		}
	}

	class IsConsoleCommandBound extends VarArgFunction {
		/**
		 * Command string boolean Returns true if console Command is already bound (by
		 * any plugin)
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("IsConsoleCommandBound is not yet implemented");
			return NIL;
		}
	}

	class IsPluginLoaded extends VarArgFunction {
		/**
		 * PluginName string Returns true if the specified plugin is loaded.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("IsPluginLoaded is not yet implemented");
			return NIL;
		}
	}

	class LoadPlugin extends VarArgFunction {
		/**
		 * PluginFolder string (DEPRECATED) Loads a plugin from the specified folder.
		 * NOTE: Loading plugins may be an unsafe operation and may result in a deadlock
		 * or a crash. This API is deprecated and might be removed.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("LoadPlugin is not yet implemented");
			return NIL;
		}
	}

	class LogStackTrace extends VarArgFunction {
		/**
		 * (STATIC) Logs a current stack trace of the Lua engine to the server console
		 * log. Same format as is used when the plugin fails.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("LogStackTrace is not yet implemented");
			return NIL;
		}
	}

	class RefreshPluginList extends VarArgFunction {
		/**
		 * Refreshes the list of plugins to include all folders inside the Plugins
		 * folder (potentially new disabled plugins)
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("RefreshPluginList is not yet implemented");
			return NIL;
		}
	}

	class ReloadPlugin extends VarArgFunction {
		/**
		 * PluginName string Queues the specified plugin to be reloaded. To avoid
		 * deadlocks, the reloading happens in the main tick thread asynchronously.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ReloadPlugin is not yet implemented");
			return NIL;
		}
	}

	class ReloadPlugins extends VarArgFunction {
		/**
		 * Reloads all active plugins
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ReloadPlugins is not yet implemented");
			return NIL;
		}
	}

	class UnloadPlugin extends VarArgFunction {
		/**
		 * PluginName string Queues the specified plugin to be unloaded. To avoid
		 * deadlocks, the unloading happens in the main tick thread asynchronously.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("UnloadPlugin is not yet implemented");
			return NIL;
		}
	}

	class ToString extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			String output = "cPluginManager()";
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

	public static void addHook(int hook, LuaValue function) {

		switch (hook) {
		case 0:
			HookManager.addHook(hHOOK_BLOCK_SPREAD.INSTANCE, function);
			break;
		case 1:
			HookManager.addHook(hHOOK_BLOCK_TO_PICKUPS.INSTANCE, function);
			break;
		case 2:
			HookManager.addHook(hHOOK_BREWING_COMPLETED.INSTANCE, function);
			break;
		case 3:
			HookManager.addHook(hHOOK_BREWING_COMPLETING.INSTANCE, function);
			break;
		case 4:
			HookManager.addHook(hHOOK_CHAT.INSTANCE, function);
			break;
		case 5:
			HookManager.addHook(hHOOK_CHUNK_AVAILABLE.INSTANCE, function);
			break;
		case 6:
			HookManager.addHook(hHOOK_CHUNK_GENERATED.INSTANCE, function);
			break;
		case 7:
			HookManager.addHook(hHOOK_CHUNK_GENERATING.INSTANCE, function);
			break;
		case 8:
			HookManager.addHook(hHOOK_CHUNK_UNLOADED.INSTANCE, function);
			break;
		case 9:
			HookManager.addHook(hHOOK_CHUNK_UNLOADING.INSTANCE, function);
			break;
		case 10:
			HookManager.addHook(hHOOK_COLLECTING_PICKUP.INSTANCE, function);
			break;
		case 11:
			HookManager.addHook(hHOOK_CRAFTING_NO_RECIPE.INSTANCE, function);
			break;
		case 12:
			HookManager.addHook(hHOOK_DISCONNECT.INSTANCE, function);
			break;
		case 13:
			HookManager.addHook(hHOOK_DROPSPENSE.INSTANCE, function);
			break;
		case 14:
			HookManager.addHook(hHOOK_ENTITY_ADD_EFFECT.INSTANCE, function);
			break;
		case 15:
			HookManager.addHook(hHOOK_ENTITY_CHANGED_WORLD.INSTANCE, function);
			break;
		case 16:
			HookManager.addHook(hHOOK_ENTITY_CHANGING_WORLD.INSTANCE, function);
			break;
		case 17:
			HookManager.addHook(hHOOK_ENTITY_TELEPORT.INSTANCE, function);
			break;
		case 18:
			HookManager.addHook(hHOOK_EXECUTE_COMMAND.INSTANCE, function);
			break;
		case 19:
			HookManager.addHook(hHOOK_EXPLODED.INSTANCE, function);
			break;
		case 20:
			HookManager.addHook(hHOOK_EXPLODING.INSTANCE, function);
			break;
		case 21:
			HookManager.addHook(hHOOK_HANDSHAKE.INSTANCE, function);
			break;
		case 22:
			HookManager.addHook(hHOOK_HOPPER_PULLING_ITEM.INSTANCE, function);
			break;
		case 23:
			HookManager.addHook(hHOOK_HOPPER_PUSHING_ITEM.INSTANCE, function);
			break;
		case 24:
			HookManager.addHook(hHOOK_KILLED.INSTANCE, function);
			break;
		case 25:
			HookManager.addHook(hHOOK_KILLING.INSTANCE, function);
			break;
		case 26:
			HookManager.addHook(hHOOK_LOGIN.INSTANCE, function);
			break;
		case 27:
			HookManager.addHook(hHOOK_LOGIN_FORGE.INSTANCE, function);
			break;
		case 28:
			HookManager.addHook(hHOOK_PLAYER_ANIMATION.INSTANCE, function);
			break;
		case 29:
			HookManager.addHook(hHOOK_PLAYER_BREAKING_BLOCK.INSTANCE, function);
			break;
		case 30:
			HookManager.addHook(hHOOK_PLAYER_BROKEN_BLOCK.INSTANCE, function);
			break;
		case 31:
			HookManager.addHook(hHOOK_PLAYER_CROUCHED.INSTANCE, function);
			break;
		case 32:
			HookManager.addHook(hHOOK_PLAYER_DESTROYED.INSTANCE, function);
			break;
		case 33:
			HookManager.addHook(hHOOK_PLAYER_EATING.INSTANCE, function);
			break;
		case 34:
			HookManager.addHook(hHOOK_PLAYER_FISHED.INSTANCE, function);
			break;
		case 35:
			HookManager.addHook(hHOOK_PLAYER_FISHING.INSTANCE, function);
			break;
		case 36:
			HookManager.addHook(hHOOK_PLAYER_FOOD_LEVEL_CHANGE.INSTANCE, function);
			break;
		case 37:
			HookManager.addHook(hHOOK_PLAYER_JOINED.INSTANCE, function);
			break;
		case 38:
			HookManager.addHook(hHOOK_PLAYER_LEFT_CLICK.INSTANCE, function);
			break;
		case 39:
			HookManager.addHook(hHOOK_PLAYER_MOVING.INSTANCE, function);
			break;
		case 40:
			HookManager.addHook(hHOOK_PLAYER_OPENING_WINDOW.INSTANCE, function);
			break;
		case 41:
			HookManager.addHook(hHOOK_PLAYER_PLACED_BLOCK.INSTANCE, function);
			break;
		case 42:
			HookManager.addHook(hHOOK_PLAYER_PLACING_BLOCK.INSTANCE, function);
			break;
		case 43:
			HookManager.addHook(hHOOK_PLAYER_RIGHT_CLICK.INSTANCE, function);
			break;
		case 44:
			HookManager.addHook(hHOOK_PLAYER_RIGHT_CLICKING_ENTITY.INSTANCE, function);
			break;
		case 45:
			HookManager.addHook(hHOOK_PLAYER_SHOOTING.INSTANCE, function);
			break;
		case 46:
			HookManager.addHook(hHOOK_PLAYER_SPAWNED.INSTANCE, function);
			break;
		case 47:
			HookManager.addHook(hHOOK_PLAYER_TOSSING_ITEM.INSTANCE, function);
			break;
		case 48:
			HookManager.addHook(hHOOK_PLAYER_USED_BLOCK.INSTANCE, function);
			break;
		case 49:
			HookManager.addHook(hHOOK_PLAYER_USED_ITEM.INSTANCE, function);
			break;
		case 50:
			HookManager.addHook(hHOOK_PLAYER_USING_BLOCK.INSTANCE, function);
			break;
		case 51:
			HookManager.addHook(hHOOK_PLAYER_USING_ITEM.INSTANCE, function);
			break;
		case 52:
			HookManager.addHook(hHOOK_PLUGINS_LOADED.INSTANCE, function);
			break;
		case 53:
			HookManager.addHook(hHOOK_PLUGIN_MESSAGE.INSTANCE, function);
			break;
		case 54:
			HookManager.addHook(hHOOK_POST_CRAFTING.INSTANCE, function);
			break;
		case 55:
			HookManager.addHook(hHOOK_PRE_CRAFTING.INSTANCE, function);
			break;
		case 56:
			HookManager.addHook(hHOOK_PROJECTILE_HIT_BLOCK.INSTANCE, function);
			break;
		case 57:
			HookManager.addHook(hHOOK_PROJECTILE_HIT_ENTITY.INSTANCE, function);
			break;
		case 58:
			HookManager.addHook(hHOOK_SERVER_PING.INSTANCE, function);
			break;
		case 59:
			HookManager.addHook(hHOOK_SPAWNED_ENTITY.INSTANCE, function);
			break;
		case 60:
			HookManager.addHook(hHOOK_SPAWNED_MONSTER.INSTANCE, function);
			break;
		case 61:
			HookManager.addHook(hHOOK_SPAWNING_ENTITY.INSTANCE, function);
			break;
		case 62:
			HookManager.addHook(hHOOK_SPAWNING_MONSTER.INSTANCE, function);
			break;
		case 63:
			HookManager.addHook(hHOOK_TAKE_DAMAGE.INSTANCE, function);
			break;
		case 64:
			HookManager.addHook(hHOOK_TICK.INSTANCE, function);
			break;
		case 65:
			HookManager.addHook(hHOOK_UPDATED_SIGN.INSTANCE, function);
			break;
		case 66:
			HookManager.addHook(hHOOK_UPDATING_SIGN.INSTANCE, function);
			break;
		case 67:
			HookManager.addHook(hHOOK_WEATHER_CHANGED.INSTANCE, function);
			break;
		case 68:
			HookManager.addHook(hHOOK_WEATHER_CHANGING.INSTANCE, function);
			break;
		case 69:
			HookManager.addHook(hHOOK_WORLD_STARTED.INSTANCE, function);
			break;
		case 70:
			HookManager.addHook(hHOOK_WORLD_TICK.INSTANCE, function);
			break;
		}
	}

	public cPluginManager(Plugin somePlugin, Globals luaTable) {
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

		// metatable
		LuaValue metatable = LuaValue.tableOf();

		metatable.set("__tostring", new ToString());
		metatable.set("__concat", new Concat());

		luaValue.setmetatable(metatable);

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
			return new String[] {};
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
			LuaTable split = LuaValue.tableOf();
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