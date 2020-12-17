package cuberite.api.hooks;

import org.luaj.vm2.LuaValue;

import cuberite.api.cPlayer;
import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.client.ClientPlayPacket;
import net.minestom.server.network.packet.client.play.ClientAnimationPacket;

public enum hHOOK_PLAYER_ANIMATION implements Hook {
	INSTANCE;

	@Override
	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		ClientAnimationPacket clientPacket = (ClientAnimationPacket) packet;
		
		LuaValue[] args = {
				new cPlayer(player).luaValue,
				LuaValue.valueOf(clientPacket.hand.ordinal())
			};
			
			call(args);
		
		return false;
	}

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

	}

	///////////////////////////////////////
	// hHOOK_PLAYER_ANIMATION //
	///////////////////////////////////////
}
