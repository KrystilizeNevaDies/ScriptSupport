package cuberite.api.hooks;

import java.util.HashMap;
import java.util.Map;

import org.luaj.vm2.LuaValue;

import net.minestom.server.MinecraftServer;
import net.minestom.server.network.packet.client.ClientPlayPacket;
import net.minestom.server.network.packet.client.play.ClientAnimationPacket;
import net.minestom.server.network.packet.client.play.ClientPlayerDiggingPacket;

public class HookManager {

	public static void registerHooks() {
		// Packet mappings:
		Map<Class<? extends ClientPlayPacket>, Hook> mappings = new HashMap<Class<? extends ClientPlayPacket>, Hook>();

		hHOOK_BLOCK_SPREAD.INSTANCE.start();
		hHOOK_BLOCK_TO_PICKUPS.INSTANCE.start();
		hHOOK_BREWING_COMPLETED.INSTANCE.start();
		hHOOK_BREWING_COMPLETING.INSTANCE.start();
		hHOOK_CHAT.INSTANCE.start();
		hHOOK_CHUNK_AVAILABLE.INSTANCE.start();
		hHOOK_CHUNK_GENERATED.INSTANCE.start();
		hHOOK_CHUNK_GENERATING.INSTANCE.start();
		hHOOK_CHUNK_UNLOADED.INSTANCE.start();
		hHOOK_CHUNK_UNLOADING.INSTANCE.start();
		hHOOK_COLLECTING_PICKUP.INSTANCE.start();
		hHOOK_CRAFTING_NO_RECIPE.INSTANCE.start();
		hHOOK_DISCONNECT.INSTANCE.start();
		hHOOK_DROPSPENSE.INSTANCE.start();
		hHOOK_ENTITY_ADD_EFFECT.INSTANCE.start();
		hHOOK_ENTITY_CHANGED_WORLD.INSTANCE.start();
		hHOOK_ENTITY_CHANGING_WORLD.INSTANCE.start();
		hHOOK_ENTITY_TELEPORT.INSTANCE.start();
		hHOOK_EXECUTE_COMMAND.INSTANCE.start();
		hHOOK_EXPLODED.INSTANCE.start();
		hHOOK_EXPLODING.INSTANCE.start();
		hHOOK_HANDSHAKE.INSTANCE.start();
		hHOOK_HOPPER_PULLING_ITEM.INSTANCE.start();
		hHOOK_HOPPER_PUSHING_ITEM.INSTANCE.start();
		hHOOK_KILLED.INSTANCE.start();
		hHOOK_KILLING.INSTANCE.start();
		hHOOK_LOGIN.INSTANCE.start();
		hHOOK_LOGIN_FORGE.INSTANCE.start();
		hHOOK_PLAYER_ANIMATION.INSTANCE.start();
		mappings.put(ClientAnimationPacket.class, hHOOK_PLAYER_ANIMATION.INSTANCE);
		
		hHOOK_PLAYER_BREAKING_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_BROKEN_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_CROUCHED.INSTANCE.start();
		hHOOK_PLAYER_DESTROYED.INSTANCE.start();
		hHOOK_PLAYER_EATING.INSTANCE.start();
		hHOOK_PLAYER_FISHED.INSTANCE.start();
		hHOOK_PLAYER_FISHING.INSTANCE.start();
		hHOOK_PLAYER_FOOD_LEVEL_CHANGE.INSTANCE.start();
		hHOOK_PLAYER_JOINED.INSTANCE.start();

		hHOOK_PLAYER_LEFT_CLICK.INSTANCE.start();
		mappings.put(ClientPlayerDiggingPacket.class, hHOOK_PLAYER_LEFT_CLICK.INSTANCE);

		hHOOK_PLAYER_MOVING.INSTANCE.start();
		hHOOK_PLAYER_OPENING_WINDOW.INSTANCE.start();
		hHOOK_PLAYER_PLACED_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_PLACING_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_RIGHT_CLICK.INSTANCE.start();
		hHOOK_PLAYER_RIGHT_CLICKING_ENTITY.INSTANCE.start();
		hHOOK_PLAYER_SHOOTING.INSTANCE.start();
		hHOOK_PLAYER_SPAWNED.INSTANCE.start();
		hHOOK_PLAYER_TOSSING_ITEM.INSTANCE.start();
		hHOOK_PLAYER_USED_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_USED_ITEM.INSTANCE.start();
		hHOOK_PLAYER_USING_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_USING_ITEM.INSTANCE.start();
		hHOOK_PLUGINS_LOADED.INSTANCE.start();
		hHOOK_PLUGIN_MESSAGE.INSTANCE.start();
		hHOOK_POST_CRAFTING.INSTANCE.start();
		hHOOK_PRE_CRAFTING.INSTANCE.start();
		hHOOK_PROJECTILE_HIT_BLOCK.INSTANCE.start();
		hHOOK_PROJECTILE_HIT_ENTITY.INSTANCE.start();
		hHOOK_SERVER_PING.INSTANCE.start();
		hHOOK_SPAWNED_ENTITY.INSTANCE.start();
		hHOOK_SPAWNED_MONSTER.INSTANCE.start();
		hHOOK_SPAWNING_ENTITY.INSTANCE.start();
		hHOOK_SPAWNING_MONSTER.INSTANCE.start();
		hHOOK_TAKE_DAMAGE.INSTANCE.start();
		hHOOK_TICK.INSTANCE.start();
		hHOOK_UPDATED_SIGN.INSTANCE.start();
		hHOOK_UPDATING_SIGN.INSTANCE.start();
		hHOOK_WEATHER_CHANGED.INSTANCE.start();
		hHOOK_WEATHER_CHANGING.INSTANCE.start();
		hHOOK_WORLD_STARTED.INSTANCE.start();
		hHOOK_WORLD_TICK.INSTANCE.start();

		// Packets
		MinecraftServer.getConnectionManager().onPacketReceive((player, packetController, packet) -> {
			// Listen to all received packet
			// System.out.println(packet.getClass().getSimpleName());

			if (mappings.containsKey(packet.getClass())) {
				Boolean shouldCancel = mappings.get(packet.getClass()).packetEvent(packet, player);
				packetController.setCancel(shouldCancel);
			}
		});

	}

	public static void addHook(Hook hook, LuaValue function) {
		hook.setFunctions(add(function, hook.getFunctions()));
	}

	public static void removeHook(Hook hook, LuaValue function) {
		hook.setFunctions(remove(function, hook.getFunctions()));
	}

	private static LuaValue[] add(LuaValue value, LuaValue[] arr) {
		// create a new array of size n+1
		LuaValue[] newarr = new LuaValue[arr.length + 1];

		// insert the elements from
		// the old array into the new array
		// insert all elements till n
		// then insert x at n+1
		for (int i = 0; i < arr.length; i++)
			newarr[i] = arr[i];

		newarr[arr.length] = value;

		return newarr;
	}

	private static LuaValue[] remove(LuaValue value, LuaValue[] arr) {
		int n = 0;
		// create a new array of size n-1
		LuaValue[] newarr = new LuaValue[arr.length - 1];

		// insert the elements from
		// the old array into the new array
		// insert all elements till n
		for (int i = 0; i < arr.length; i++)
			if (newarr[i] != value) {
				newarr[i] = arr[n];
				n++;
			}

		return newarr;
	}

}