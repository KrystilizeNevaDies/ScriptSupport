package cuberite.api.hooks;


import org.luaj.vm2.LuaValue;

import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerDisconnectEvent;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public enum hHOOK_DISCONNECT implements Hook {
	INSTANCE;

	private LuaValue[] hookList = {};

	@Override public LuaValue[] getFunctions() {return this.hookList;}

	@Override public void setFunctions(LuaValue[] newFunctions) {this.hookList = newFunctions;}

	public void start() {
		// Setup hook logic
		MinecraftServer.getConnectionManager().addPlayerInitialization((player) -> {
			player.addEventCallback(PlayerDisconnectEvent.class, (event) -> {
				// TODO: Client, Reason
			});
		});
	}

	@Override
	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	

	///////////////////////////////////////
	// hHOOK_DISCONNECT //
	///////////////////////////////////////
}
