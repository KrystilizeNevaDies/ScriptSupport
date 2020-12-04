package cuberite.api.hooks;


import org.luaj.vm2.LuaValue;

import cuberite.api.cPlayer;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerCommandEvent;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public enum hHOOK_EXECUTE_COMMAND implements Hook {
	INSTANCE;

	private LuaValue[] hookList = {};

	@Override public LuaValue[] getFunctions() {return this.hookList;}

	@Override public void setFunctions(LuaValue[] newFunctions) {this.hookList = newFunctions;}

	public void start() {
		// Setup hook logic
		MinecraftServer.getConnectionManager().addPlayerInitialization((player) -> {
			player.addEventCallback(PlayerCommandEvent.class, (event) -> {
				String command = event.getCommand();
				
				String[] stringSplit = command.split("");
				
				LuaValue[] split = {};
				
				for (int i = 0; i < stringSplit.length; i++) {
					split[i] = LuaValue.valueOf(stringSplit[i]);
				}
				
				LuaValue[] args = {
					new cPlayer(player).luaValue,
					LuaValue.tableOf(split),
					LuaValue.valueOf(command)
				};
				
				call(args);
			});
		});
	}

	@Override
	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	

	///////////////////////////////////////
	// hHOOK_EXECUTE_COMMAND //
	///////////////////////////////////////
}
