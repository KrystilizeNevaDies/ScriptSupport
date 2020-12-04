package cuberite.api.hooks;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

import cuberite.api.Vector3i;
import cuberite.api.cGlobals;
import cuberite.api.cPlayer;
import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.client.ClientPlayPacket;
import net.minestom.server.network.packet.client.play.ClientPlayerDiggingPacket;

public enum hHOOK_PLAYER_LEFT_CLICK implements Hook {
	INSTANCE;
	
	private LuaValue[] hookList = {};
	
	///////////////////////////////////////
	// hHOOK_PLAYER_LEFT_CLICK //
	///////////////////////////////////////

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		ClientPlayerDiggingPacket clientPacket = (ClientPlayerDiggingPacket) packet;
		LuaValue[] args = {new cPlayer(player).luaValue, Vector3i.from(clientPacket.blockPosition), cGlobals.BLOCK_FACE(clientPacket.blockFace), LuaValue.valueOf(clientPacket.status.ordinal())};
		Varargs result = call(args);
		
		return result.arg1().equals(LuaValue.TRUE);
	}

	@Override public LuaValue[] getFunctions() {return this.hookList;}

	@Override public void setFunctions(LuaValue[] newFunctions) {this.hookList = newFunctions;}
}
