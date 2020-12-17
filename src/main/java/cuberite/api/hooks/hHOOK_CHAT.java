package cuberite.api.hooks;

import org.luaj.vm2.LuaValue;

import cuberite.api.cPlayer;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerChatEvent;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public enum hHOOK_CHAT implements Hook {
	INSTANCE;

	private LuaValue[] hookList = {};

	@Override
	public LuaValue[] getFunctions() {
		return this.hookList;
	}

	@Override
	public void setFunctions(LuaValue[] newFunctions) {
		this.hookList = newFunctions;
	}

	@Override
	public void start() {
		// Setup hook logic
		MinecraftServer.getGlobalEventHandler().addEventCallback(PlayerChatEvent.class, (event) -> {
			LuaValue cPlayer = new cPlayer(event.getSender()).luaValue;
			LuaValue[] args = { cPlayer, LuaValue.valueOf(event.getMessage()) };
			call(args);

			event.getMessage();
		});
	}

	@Override
	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		return null;
	}

	///////////////////////////////////////
	// hHOOK_CHAT //
	///////////////////////////////////////
}
