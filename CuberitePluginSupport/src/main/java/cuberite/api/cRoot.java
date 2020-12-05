package cuberite.api;

import java.lang.management.ManagementFactory;
import java.util.UUID;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

import com.sun.management.OperatingSystemMXBean;

import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;

public class cRoot {

	public static LuaTable luaValue = new cRoot().registerCallbacks();

	class BroadcastChat extends TwoArgFunction {
		/**
		 * CompositeChat cCompositeChat Broadcasts a composite chat message to all
		 * players.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:BroadcastChat is not yet implemented");
			return NIL;
		}
	}

	class BroadcastChatDeath extends TwoArgFunction {
		/**
		 * MessageText string Broadcasts the specified message to all players, with its
		 * message type set to mtDeath. Use for when a player has died.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:BroadcastChatDeath is not yet implemented");
			return NIL;
		}
	}

	class BroadcastChatFailure extends TwoArgFunction {
		/**
		 * MessageText string Broadcasts the specified message to all players, with its
		 * message type set to mtFailure. Use for a command that failed to run because
		 * of insufficient permissions, etc.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:BroadcastChatFailure is not yet implemented");
			return NIL;
		}
	}

	class BroadcastChatFatal extends TwoArgFunction {
		/**
		 * MessageText string Broadcasts the specified message to all players, with its
		 * message type set to mtFatal. Use for a plugin that crashed, or similar.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:BroadcastChatFatal is not yet implemented");
			return NIL;
		}
	}

	class BroadcastChatInfo extends TwoArgFunction {
		/**
		 * MessageText string Broadcasts the specified message to all players, with its
		 * message type set to mtInfo. Use for informational messages, such as command
		 * usage.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:BroadcastChatInfo is not yet implemented");
			return NIL;
		}
	}

	class BroadcastChatJoin extends TwoArgFunction {
		/**
		 * MessageText string Broadcasts the specified message to all players, with its
		 * message type set to mtJoin. Use for players joining the server.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:BroadcastChatJoin is not yet implemented");
			return NIL;
		}
	}

	class BroadcastChatLeave extends TwoArgFunction {
		/**
		 * MessageText string Broadcasts the specified message to all players, with its
		 * message type set to mtLeave. Use for players leaving the server.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:BroadcastChatLeave is not yet implemented");
			return NIL;
		}
	}

	class BroadcastChatSuccess extends TwoArgFunction {
		/**
		 * MessageText string Broadcasts the specified message to all players, with its
		 * message type set to mtSuccess. Use for success messages.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:BroadcastChatSuccess is not yet implemented");
			return NIL;
		}
	}

	class BroadcastChatWarning extends TwoArgFunction {
		/**
		 * MessageText string Broadcasts the specified message to all players, with its
		 * message type set to mtWarning. Use for concerning events, such as plugin
		 * reload etc.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:BroadcastChatWarning is not yet implemented");
			return NIL;
		}
	}

	class DoWithPlayerByUUID extends VarArgFunction {
		/**
		 * PlayerUUID cUUID CallbackFunction function boolean If there is the player
		 * with the uuid, calls the CallbackFunction with the cPlayer parameter
		 * representing the player. The CallbackFunction has the following signature:
		 * function Callback(Player)The function returns false if the player was not
		 * found, or whatever bool value the callback returned if the player was found.
		 */
		public LuaValue call(LuaValue[] args) {
			Player player = MinecraftServer.getConnectionManager()
					.getPlayer(UUID.fromString((args[1].get("ToShortString").call().tojstring())));
			if (player == null) {
				return FALSE;
			} else {
				return args[2].call(new cPlayer(player).luaValue);
			}
		}
	}

	class FindAndDoWithPlayer extends VarArgFunction {
		/**
		 * PlayerName string CallbackFunction function boolean Calls the given callback
		 * function for the player with the name best matching the name string provided.
		 * This function is case-insensitive and will match partial names. Returns false
		 * if player not found or there is ambiguity, true otherwise. The
		 * CallbackFunction has the following signature: function Callback(Player)
		 */
		public LuaValue call(LuaValue[] args) {
			Player player = MinecraftServer.getConnectionManager().getPlayer(args[1].tojstring());
			if (player == null) {
				return FALSE;
			} else {
				return args[2].call(new cPlayer(player).luaValue);
			}
		}
	}

	class ForEachPlayer extends TwoArgFunction {
		/**
		 * CallbackFunction function boolean Calls the given callback function for each
		 * player. The callback function has the following signature: function
		 * Callback(cPlayer)
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			MinecraftServer.getConnectionManager().getOnlinePlayers().forEach((player) -> {
				value.call(new cPlayer(player).luaValue);
			});
			return NIL;
		}
	}

	class ForEachWorld extends TwoArgFunction {
		/**
		 * CallbackFunction function boolean Calls the given callback function for each
		 * world. The callback function has the following signature: function
		 * Callback(cWorld). Returns false if a callback aborts, otherwise true.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			MinecraftServer.getInstanceManager().getInstances().forEach((instance) -> {
				value.call(new cWorld(instance).luaValue);
			});
			return NIL;
		}
	}

	class Get extends OneArgFunction {
		/**
		 * cRoot (STATIC) Returns the one and only cRoot object.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot) {
			return luaRoot;
		}
	}

	class GetBrewingRecipe extends TwoArgFunction {
		/**
		 * Bottle cItem Ingredient cItem cItem (STATIC) Returns the result item, if a
		 * recipe has been found to brew the Ingredient into Bottle. If no recipe is
		 * found, returns no value.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetBrewingRecipe is not yet implemented");
			return NIL;
		}
	}

	class GetBuildCommitID extends TwoArgFunction {
		/**
		 * string (STATIC) For official builds (Travis CI / Jenkins) it returns the
		 * exact commit hash used for the build. For unofficial local builds, returns
		 * the approximate commit hash (since the true one cannot be determined),
		 * formatted as "approx: <CommitHash>".
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetBuildCommitID is not yet implemented");
			return NIL;
		}
	}

	class GetBuildDateTime extends TwoArgFunction {
		/**
		 * string (STATIC) For official builds (Travic CI / Jenkins) it returns the date
		 * and time of the build. For unofficial local builds, returns the approximate
		 * datetime of the commit (since the true one cannot be determined), formatted
		 * as "approx: <DateTime-iso8601>".
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetBuildDateTime is not yet implemented");
			return NIL;
		}
	}

	class GetBuildID extends TwoArgFunction {
		/**
		 * string (STATIC) For official builds (Travis CI / Jenkins) it returns the
		 * unique ID of the build, as recognized by the build system. For unofficial
		 * local builds, returns the string "Unknown".
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetBuildID is not yet implemented");
			return NIL;
		}
	}

	class GetBuildSeriesName extends TwoArgFunction {
		/**
		 * string (STATIC) For official builds (Travis CI / Jenkins) it returns the
		 * series name of the build (for example "Cuberite Windows x64 Master"). For
		 * unofficial local builds, returns the string "local build".
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetBuildSeriesName is not yet implemented");
			return NIL;
		}
	}

	class GetCraftingRecipes extends TwoArgFunction {
		/**
		 * cCraftingRecipe Returns the CraftingRecipes object
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetCraftingRecipes is not yet implemented");
			return NIL;
		}
	}

	class GetDefaultWorld extends TwoArgFunction {
		/**
		 * cWorld Returns the world object from the default world.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetDefaultWorld is not yet implemented");
			return NIL;
		}
	}

	class GetFurnaceFuelBurnTime extends TwoArgFunction {
		/**
		 * Fuel cItem number (STATIC) Returns the number of ticks for how long the item
		 * would fuel a furnace. Returns zero if not a fuel.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetFurnaceFuelBurnTime is not yet implemented");
			return NIL;
		}
	}

	class GetFurnaceRecipe extends TwoArgFunction {
		/**
		 * InItem cItem OutItem cItem NumTicks number InItem cItem (STATIC) Returns the
		 * furnace recipe for smelting the specified input. If a recipe is found,
		 * returns the smelted result, the number of ticks required for the smelting
		 * operation, and the input consumed (note that Cuberite supports smelting M
		 * items into N items and different smelting rates). If no recipe is found,
		 * returns no value.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetFurnaceRecipe is not yet implemented");
			return NIL;
		}
	}

	class GetPhysicalRAMUsage extends TwoArgFunction {
		/**
		 * number (STATIC) Returns the amount of physical RAM that the entire Cuberite
		 * process is using, in KiB. Negative if the OS doesn't support this query.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			return valueOf(((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean())
					.getTotalPhysicalMemorySize());
		}
	}

	class GetPluginManager extends TwoArgFunction {
		/**
		 * cPluginManager Returns the cPluginManager object.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetPluginManager is not yet implemented");
			return NIL;
		}
	}

	class GetProtocolVersionTextFromInt extends TwoArgFunction {
		/**
		 * ProtocolVersionNumber number string (STATIC) Returns the Minecraft client
		 * version from the given Protocol version number. If there is no version found,
		 * it returns 'Unknown protocol (Number)'
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetProtocolVersionTextFromInt is not yet implemented");
			return NIL;
		}
	}

	class GetServer extends TwoArgFunction {
		/**
		 * cServer Returns the cServer object.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetServer is not yet implemented");
			return NIL;
		}
	}

	class GetServerUpTime extends TwoArgFunction {
		/**
		 * number Returns the uptime of the server in seconds.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			return valueOf(ManagementFactory.getRuntimeMXBean().getUptime());
		}
	}

	class GetTotalChunkCount extends TwoArgFunction {
		/**
		 * number Returns the amount of loaded chunks.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetTotalChunkCount is not yet implemented");
			return NIL;
		}
	}

	class GetVirtualRAMUsage extends TwoArgFunction {
		/**
		 * number (STATIC) Returns the amount of virtual RAM that the entire Cuberite
		 * process is using, in KiB. Negative if the OS doesn't support this query.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetVirtualRAMUsage is not yet implemented");
			return NIL;
		}
	}

	class GetWebAdmin extends TwoArgFunction {
		/**
		 * cWebAdmin Returns the cWebAdmin object.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetWebAdmin is not yet implemented");
			return NIL;
		}
	}

	class GetWorld extends TwoArgFunction {
		/**
		 * WorldName string cWorld Returns the cWorld object of the given world. It
		 * returns nil if there is no world with the given name.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:GetWorld is not yet implemented");
			return NIL;
		}
	}

	class QueueExecuteConsoleCommand extends TwoArgFunction {
		/**
		 * Message string Queues a console command for execution through the cServer
		 * class. The command will be executed in the tick thread. The command's output
		 * will be sent to console.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:QueueExecuteConsoleCommand is not yet implemented");
			return NIL;
		}
	}

	class SaveAllChunks extends TwoArgFunction {
		/**
		 * Saves all the chunks in all the worlds. Note that the saving is queued on
		 * each world's tick thread and this functions returns before the chunks are
		 * actually saved.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:SaveAllChunks is not yet implemented");
			return NIL;
		}
	}

	class SetSavingEnabled extends TwoArgFunction {
		/**
		 * SavingEnabled boolean Sets whether saving chunk data is enabled for all
		 * worlds. If disabled, dirty chunks will stay in memory forever, which can
		 * cause performance and stability issues.
		 */
		@Override
		public LuaValue call(LuaValue luaRoot, LuaValue value) {
			System.out.println("cRoot:SetSavingEnabled is not yet implemented");
			return NIL;
		}
	}

	class ToString extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			String output = "cRoot()";
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

	private LuaTable registerCallbacks() {
		LuaTable value = LuaValue.tableOf();

		value.set("BroadcastChat", new BroadcastChat());
		value.set("BroadcastChatDeath", new BroadcastChatDeath());
		value.set("BroadcastChatFailure", new BroadcastChatFailure());
		value.set("BroadcastChatFatal", new BroadcastChatFatal());
		value.set("BroadcastChatInfo", new BroadcastChatInfo());
		value.set("BroadcastChatJoin", new BroadcastChatJoin());
		value.set("BroadcastChatLeave", new BroadcastChatLeave());
		value.set("BroadcastChatSuccess", new BroadcastChatSuccess());
		value.set("BroadcastChatWarning", new BroadcastChatWarning());
		value.set("DoWithPlayerByUUID", new DoWithPlayerByUUID());
		value.set("FindAndDoWithPlayer", new FindAndDoWithPlayer());
		value.set("ForEachPlayer", new ForEachPlayer());
		value.set("ForEachWorld", new ForEachWorld());
		value.set("Get", new Get());
		value.set("GetBrewingRecipe", new GetBrewingRecipe());
		value.set("GetBuildCommitID", new GetBuildCommitID());
		value.set("GetBuildDateTime", new GetBuildDateTime());
		value.set("GetBuildID", new GetBuildID());
		value.set("GetBuildSeriesName", new GetBuildSeriesName());
		value.set("GetCraftingRecipes", new GetCraftingRecipes());
		value.set("GetDefaultWorld", new GetDefaultWorld());
		value.set("GetFurnaceFuelBurnTime", new GetFurnaceFuelBurnTime());
		value.set("GetFurnaceRecipe", new GetFurnaceRecipe());
		value.set("GetPhysicalRAMUsage", new GetPhysicalRAMUsage());
		value.set("GetPluginManager", new GetPluginManager());
		value.set("GetProtocolVersionTextFromInt", new GetProtocolVersionTextFromInt());
		value.set("GetServer", new GetServer());
		value.set("GetServerUpTime", new GetServerUpTime());
		value.set("GetTotalChunkCount", new GetTotalChunkCount());
		value.set("GetVirtualRAMUsage", new GetVirtualRAMUsage());
		value.set("GetWebAdmin", new GetWebAdmin());
		value.set("GetWorld", new GetWorld());
		value.set("QueueExecuteConsoleCommand", new QueueExecuteConsoleCommand());
		value.set("SaveAllChunks", new SaveAllChunks());
		value.set("SetSavingEnabled", new SetSavingEnabled());

		// metatable
		LuaValue metatable = LuaValue.tableOf();

		metatable.set("__tostring", new ToString());
		metatable.set("__concat", new Concat());

		value.setmetatable(metatable);

		return value;
	}
}