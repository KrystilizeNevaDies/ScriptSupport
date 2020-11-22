package cuberite.api.hooks;

import java.util.ArrayList;

import org.luaj.vm2.LuaValue;

import cuberite.api.cPlayer;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerChatEvent;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public enum hHOOK_CHAT implements Hook {
	INSTANCE;

	private ArrayList<LuaValue> hookList = new ArrayList<LuaValue>();

	public void add(LuaValue function) {
		hookList.add(function);
	}

	public void start() {
		// Setup hook logic
		MinecraftServer.getConnectionManager().addPlayerInitialization((player) -> {
			player.addEventCallback(PlayerChatEvent.class, (event) -> {
				LuaValue cPlayer = new cPlayer(event.getSender()).luaValue;
				LuaValue[] args = {cPlayer, LuaValue.valueOf(event.getMessage())};
				call(args);
				
				event.getMessage();
			});
		});
	}

	@Override
	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	///////////////////////////////////////
	// hHOOK_CHAT //
	///////////////////////////////////////
}
