package cuberite.api.hooks;

import org.luaj.vm2.LuaValue;

import cuberite.api.cWorld;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.instance.InstanceChunkLoadEvent;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public enum hHOOK_CHUNK_AVAILABLE implements Hook {
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
		MinecraftServer.getGlobalEventHandler().addEventCallback(InstanceChunkLoadEvent.class, (event) -> {
			LuaValue[] args = {
				new cWorld(event.getInstance()).luaValue,
				LuaValue.valueOf(event.getChunkX()),
				LuaValue.valueOf(event.getChunkZ()),
			};
			
			call(args);
		});
	}

	@Override
	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		return null;
	}

	///////////////////////////////////////
	// hHOOK_CHUNK_AVAILABLE //
	///////////////////////////////////////
}
