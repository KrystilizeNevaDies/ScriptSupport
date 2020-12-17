package cuberite.api;

import java.util.HashMap;
import java.util.Map;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

import net.minestom.server.entity.Player;

public class cClientHandle {
	private static Map<Player, LuaTable> handles = new HashMap<Player, LuaTable>();

	public LuaTable luaValue;

	private Player player;

	class GenerateOfflineUUID extends OneArgFunction {
		/**
		 * 
		 * Username string
		 * 
		 * string (STATIC) Generates an UUID based on the player name provided. This is
		 * used for the offline (non-auth) mode, when there's no UUID source. Each
		 * username generates a unique and constant UUID, so that when the player
		 * reconnects with the same name, their UUID is the same. Returns a 32-char UUID
		 * (no dashes).
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			return LuaValue.valueOf(player.getUuid().toString());
		}
	}

	class GetClientBrand extends OneArgFunction {
		/**
		 * 
		 * string Returns the brand that the client has sent in their MC Brand plugin
		 * message.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("GetClientBrand is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class GetForgeMods extends OneArgFunction {
		/**
		 * 
		 * table Returns the Forge mods installed on the client.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("GetForgeMods is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class GetIPString extends OneArgFunction {
		/**
		 * 
		 * string Returns the IP address of the connection, as a string. Only the
		 * address part is returned, without the port number.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			return LuaValue.valueOf(player.getPlayerConnection().getRemoteAddress().toString());
		}
	}

	class GetLocale extends OneArgFunction {
		/**
		 * 
		 * Locale string Returns the locale string that the client sends as part of the
		 * protocol handshake. Can be used to provide localized strings.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("GetLocale is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class GetPing extends OneArgFunction {
		/**
		 * 
		 * number Returns the ping time, in ms
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			return LuaValue.valueOf(player.getLatency());
		}
	}

	class GetPlayer extends OneArgFunction {
		/**
		 * 
		 * cPlayer Returns the player object connected to this client. Note that this
		 * may be nil, for example if the player object is not yet spawned.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			return new cPlayer(player).luaValue;
		}
	}

	class GetProtocolVersion extends OneArgFunction {
		/**
		 * 
		 * number Returns the protocol version number of the protocol that the client is
		 * talking. Returns zero if the protocol version is not (yet) known.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("GetProtocolVersion is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class GetRequestedViewDistance extends OneArgFunction {
		/**
		 * 
		 * number Returns the view distance that the player request, not the used view
		 * distance.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("GetRequestedViewDistance is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class GetUUID extends OneArgFunction {
		/**
		 * 
		 * cUUID Returns the authentication-based UUID of the client. This UUID should
		 * be used to identify the player when persisting any player-related data.
		 * Returns a 32-char UUID (no dashes)
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			return new cUUID(player.getUuid()).luaValue;
		}
	}

	class GetUniqueID extends OneArgFunction {
		/**
		 * 
		 * number Returns the UniqueID of the client used to identify the client in the
		 * server
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			return LuaValue.valueOf(player.getUuid().hashCode());
		}
	}

	class GetUsername extends OneArgFunction {
		/**
		 * 
		 * string Returns the username that the client has provided
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			return LuaValue.valueOf(player.getUsername());
		}
	}

	class GetViewDistance extends OneArgFunction {
		/**
		 * 
		 * number Returns the viewdistance (number of chunks loaded for the player in
		 * each direction)
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("GetViewDistance is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class HasPluginChannel extends OneArgFunction {
		/**
		 * 
		 * ChannelName string
		 * 
		 * boolean Returns true if the client has registered to receive messages on the
		 * specified plugin channel.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("HasPluginChannel is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class IsForgeClient extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the client is modded with Forge.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("IsForgeClient is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class IsUUIDOnline extends OneArgFunction {
		/**
		 * 
		 * UUID cUUID
		 * 
		 * boolean (STATIC) Returns true if the UUID is generated by online auth, false
		 * if it is an offline-generated UUID. We use Version-3 UUIDs for offline UUIDs,
		 * online UUIDs are Version-4, thus we can tell them apart. Accepts both 32-char
		 * and 36-char UUIDs (with and without dashes).
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			return LuaValue.valueOf(player.isOnline());
		}
	}

	class Kick extends TwoArgFunction {
		/**
		 * 
		 * Reason string Kicks the user with the specified reason
		 */
		@Override
		public LuaValue call(LuaValue handle, LuaValue message) {
			player.kick(message.tojstring());
			return LuaValue.NIL;
		}
	}

	class SendBlockChange extends OneArgFunction {
		/**
		 * 
		 * Block Vector3i BlockType number BlockMeta number Sends a BlockChange packet
		 * to the client. This can be used to create fake blocks only for that player.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendBlockChange is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SendEntityAnimation extends OneArgFunction {
		/**
		 * 
		 * Entity cEntity AnimationNumber number Sends the specified animation of the
		 * specified entity to the client. The AnimationNumber is protocol-specific.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendEntityAnimation is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SendHideTitle extends OneArgFunction {
		/**
		 * 
		 * Hides the title. This makes the title and subtitle disappear, but if you call
		 * SendTitleTimes() the same title and subtitle will appear again.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendHideTitle is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SendPluginMessage extends OneArgFunction {
		/**
		 * 
		 * Channel string Message string Sends the plugin message on the specified
		 * channel.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendPluginMessage is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SendResetTitle extends OneArgFunction {
		/**
		 * 
		 * Resets and hides the title but not the subtitle.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendResetTitle is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SendSetRawSubTitle extends OneArgFunction {
		/**
		 * 
		 * SubTitle string Sends the raw subtitle to the client. Doesn't make the client
		 * display it yet, use SendTitleTimes() to show both the title and the subtitle.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendSetRawSubTitle is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SendSetRawTitle extends OneArgFunction {
		/**
		 * 
		 * Title string Sends the raw title to the client. Doesn't make the client
		 * display it yet, use SendTitleTimes() to show both the title and the subtitle.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendSetRawTitle is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SendSetSubTitle extends OneArgFunction {
		/**
		 * 
		 * SubTitle cCompositeChat Sends the subtitle to the client. Doesn't make the
		 * client display it yet, use SendTitleTimes() to show both the title and the
		 * subtitle.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendSetSubTitle is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SendSetTitle extends OneArgFunction {
		/**
		 * 
		 * Title cCompositeChat Sends the title to the client. Doesn't make the client
		 * display it yet, use SendTitleTimes() to show both the title and the subtitle.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendSetTitle is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SendSoundEffect extends OneArgFunction {
		/**
		 * 
		 * SoundName string X number Y number Z number Volume number Pitch number Sends
		 * a sound effect request to the client. The sound is played at the specified
		 * coords, with the specified volume (a float, 1.0 is full volume, can be more)
		 * and pitch (0-255, 63 is 100%) (DEPRECATED, use vector-parametered version
		 * instead)
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendSoundEffect is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SendTimeUpdate extends OneArgFunction {
		/**
		 * 
		 * WorldAge number TimeOfDay number DoDaylightCycle boolean Sends the specified
		 * time update to the client. WorldAge is the total age of the world, in ticks.
		 * TimeOfDay is the current day's time, in ticks (0 - 24000). DoDaylightCycle is
		 * a bool that specifies whether the client should automatically move the sun
		 * (true) or keep it in the same place (false).
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendTimeUpdate is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SendTitleTimes extends OneArgFunction {
		/**
		 * 
		 * FadeInTicks number DisplayTicks number FadeOutTicks number Sends the request
		 * to display the title and subtitle, previously set with SendSetTitle,
		 * SendSetRawTitle, SendSetSubTitle and SendSetRawSubTitle, to the client.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SendTitleTimes is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SetClientBrand extends OneArgFunction {
		/**
		 * 
		 * ClientBrand string Sets the value of the client's brand. Normally this value
		 * is received from the client by a MC Brand plugin message, this function lets
		 * plugins overwrite the value.
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SetClientBrand is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SetLocale extends OneArgFunction {
		/**
		 * 
		 * Locale string Sets the locale that Cuberite keeps on record. Initially the
		 * locale is initialized in protocol handshake, this function allows plugins to
		 * override the stored value (but only server-side and only until the user
		 * disconnects).
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SetLocale is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SetUsername extends OneArgFunction {
		/**
		 * 
		 * Name string Sets the username
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SetUsername is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class SetViewDistance extends OneArgFunction {
		/**
		 * 
		 * ViewDistance number Sets the viewdistance (number of chunks loaded for the
		 * player in each direction)
		 */
		@Override
		public LuaValue call(LuaValue handle) {
			System.out.println("SetViewDistance is not yet implemented");
			return LuaValue.NIL;
		}
	}

	class ToString extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue vector) {
			String output = "cClientHandle(" + player.getUsername() + ")";
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

	/**
	 * Static Initialization
	 * 
	 * @param globals
	 */
	public cClientHandle(Globals globals) {

		luaValue = LuaValue.tableOf();

		luaValue.set("GenerateOfflineUUID", new GenerateOfflineUUID());

		// Implement Constants
		luaValue.set("MAX_VIEW_DISTANCE", LuaValue.valueOf(32)); // The maximum value of the view distance
		luaValue.set("MIN_VIEW_DISTANCE", LuaValue.valueOf(1)); // The minimum value of the view distance

		globals.set("cClientHandle", luaValue);
	}

	/**
	 * Dynamic Initialization
	 * 
	 * @param somePlayer
	 */
	public cClientHandle(Player somePlayer) {
		player = somePlayer;

		// Check if player already exists
		if (handles.containsKey(somePlayer)) {
			this.luaValue = handles.get(somePlayer);
			return;
		}

		// metatable

		luaValue = LuaValue.tableOf();

		// Implement methods

		// metatable
		LuaValue metatable = LuaValue.tableOf();

		metatable.set("__tostring", new ToString());
		metatable.set("__concat", new Concat());

		luaValue.setmetatable(metatable);

		handles.put(somePlayer, luaValue);

	}

}