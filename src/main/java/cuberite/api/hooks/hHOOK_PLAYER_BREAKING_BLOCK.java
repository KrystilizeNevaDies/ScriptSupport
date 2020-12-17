package cuberite.api.hooks;

import org.luaj.vm2.LuaValue;

import cuberite.api.Vector3d;
import cuberite.api.cPlayer;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerBlockBreakEvent;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public enum hHOOK_PLAYER_BREAKING_BLOCK implements Hook {
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
			player.addEventCallback(PlayerBlockBreakEvent.class, (event) -> {
				LuaValue[] args = { new cPlayer(player).luaValue,
						new Vector3d(event.getBlockPosition()).getLuaValue() };
				if (call(args).equals(LuaValue.TRUE)) {
					event.setCancelled(true);
				} else {
					player.scheduleNextTick((entity) -> {
						hHOOK_PLAYER_BROKEN_BLOCK.INSTANCE.doEvent(args);
					});
				}
				/**
				 * TODO: BlockFace number Face of the block upon which the player is acting. One
				 * of the BLOCK_FACE_ constants BlockType BLOCKTYPE The block type of the block
				 * being broken BlockMeta NIBBLETYPE The block meta of the block being broken
				 */
			});
		});
	}

	///////////////////////////////////////
	// hHOOK_PLAYER_BREAKING_BLOCK //
	///////////////////////////////////////
}
