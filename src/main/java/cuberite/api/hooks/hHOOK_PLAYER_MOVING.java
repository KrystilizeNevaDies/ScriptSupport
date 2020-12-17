package cuberite.api.hooks;

import org.luaj.vm2.LuaValue;

import cuberite.api.Vector3d;
import cuberite.api.cPlayer;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.entity.EntityVelocityEvent;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public enum hHOOK_PLAYER_MOVING implements Hook {
	INSTANCE;

	@Override
	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		// TODO Auto-generated method stub
		return null;
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
		MinecraftServer.getConnectionManager().addPlayerInitialization((player) -> {
			player.addEventCallback(EntityVelocityEvent.class, (event) -> {
				LuaValue[] args = {
					new cPlayer(player).luaValue,
					new Vector3d(player.getPosition()).getLuaValue(),
					new Vector3d(player.getPosition().clone().add(event.getVelocity().toPosition())).getLuaValue(),
					LuaValue.valueOf(player.isOnGround())
				};
				
				event.setCancelled(call(args).arg1().equals(LuaValue.TRUE));
				
			});
		});

	}

	///////////////////////////////////////
	// hHOOK_PLAYER_MOVING //
	///////////////////////////////////////
}
