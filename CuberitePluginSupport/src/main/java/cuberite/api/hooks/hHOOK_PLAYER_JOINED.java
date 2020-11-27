package cuberite.api.hooks;


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

	private LuaValue[] hookList = {};

	@Override public LuaValue[] getFunctions() {return this.hookList;}

	@Override public void setFunctions(LuaValue[] newFunctions) {this.hookList = newFunctions;}

	public void start() {
		// Setup hook logic
		MinecraftServer.getConnectionManager().addPlayerInitialization((player) -> {
			player.addEventCallback(PlayerLoginEvent.class, (event) -> {
				LuaValue cPlayer = new cPlayer(event.getPlayer()).luaValue;
				LuaValue[] args = {cPlayer};
				call(args, getFunctions());
			});
		});
	}

	///////////////////////////////////////
	// hHOOK_PLAYER_JOINED //
	///////////////////////////////////////
}
