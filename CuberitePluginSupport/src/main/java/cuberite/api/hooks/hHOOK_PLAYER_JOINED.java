package cuberite.api.hooks;

import java.util.ArrayList;

import org.luaj.vm2.LuaValue;

import cuberite.api.cPlayer;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerLoginEvent;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public enum hHOOK_PLAYER_JOINED implements Hook {
	INSTANCE;

	@Override
	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<LuaValue> hookList = new ArrayList<LuaValue>();

	public void add(LuaValue function) {
		hookList.add(function);
	}

	public void start() {
		// Setup hook logic
		MinecraftServer.getConnectionManager().addPlayerInitialization((player) -> {
			player.addEventCallback(PlayerLoginEvent.class, (event) -> {
				LuaValue cPlayer = new cPlayer(event.getPlayer()).luaValue;
				LuaValue[] args = {cPlayer};
				call(args);
			});
		});
	}

	///////////////////////////////////////
	// hHOOK_PLAYER_JOINED //
	///////////////////////////////////////
}
