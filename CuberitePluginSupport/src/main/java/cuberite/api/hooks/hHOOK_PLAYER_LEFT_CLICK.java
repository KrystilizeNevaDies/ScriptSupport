package cuberite.api.hooks;

import org.luaj.vm2.LuaValue;

import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.client.ClientPlayPacket;
import net.minestom.server.network.packet.client.play.ClientAnimationPacket;

public enum hHOOK_PLAYER_LEFT_CLICK implements Hook {
	INSTANCE;

	///////////////////////////////////////
	// hHOOK_PLAYER_LEFT_CLICK //
	///////////////////////////////////////

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		ClientAnimationPacket clientPacket = (ClientAnimationPacket) packet;
		LuaValue[] args = {LuaValue.valueOf(clientPacket.hand.ordinal())};
		return call(args).arg1().equals(LuaValue.TRUE);
	}
}
