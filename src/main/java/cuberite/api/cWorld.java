package cuberite.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

import net.minestom.server.MinecraftServer;
import net.minestom.server.chat.ChatColor;
import net.minestom.server.chat.ColoredText;
import net.minestom.server.entity.Entity;
import net.minestom.server.entity.EntityType;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;
import net.minestom.server.network.packet.server.play.SpawnEntityPacket;
import net.minestom.server.particle.Particle;
import net.minestom.server.particle.ParticleCreator;
import net.minestom.server.sound.Sound;
import net.minestom.server.sound.SoundCategory;
import net.minestom.server.utils.BlockPosition;
import net.minestom.server.utils.Position;
import net.minestom.server.utils.time.TimeUnit;
import net.minestom.server.world.biomes.Biome;

public class cWorld {

	///////////////////////////////////////////////////////
	// Java API //
	///////////////////////////////////////////////////////

	private static Map<Instance, LuaTable> instances = new HashMap<Instance, LuaTable>();

	public LuaTable luaValue;

	public Instance instance;

	///////////////////////////////////////////////////////
	// Lua API //
	///////////////////////////////////////////////////////

	static class AreCommandBlocksEnabled extends OneArgFunction {
		/**
		 * boolean Returns whether command blocks are enabled on the (entire) server
		 */
		@Override
		public LuaValue call(LuaValue world) {
			return FALSE;
		}
	}

	class BroadcastBlockAction extends VarArgFunction {
		/**
		 * 
		 * Position Vector3i ActionByte1 number ActionByte2 number BlockType number
		 * ExcludeClient cClientHandle Broadcasts the BlockAction packet to all clients
		 * who have the appropriate chunk loaded (except ExcludeClient). The contents of
		 * the packet are specified by the parameters for the call, the blocktype
		 * needn't match the actual block that is present in the world data at the
		 * specified location. (DEPRECATED)
		 */
		public LuaValue call(LuaValue[] args, Varargs varargs) {
			BlockPosition position = new BlockPosition(args[1].get("x").toint(), args[1].get("y").toint(),
					args[1].get("z").toint());
			instance.sendBlockAction(position, args[2].tobyte(), args[2].tobyte());
			return NIL;
		}
	}

	class BroadcastChat extends TwoArgFunction {
		/**
		 * 
		 * Message string ExcludeClient cClientHandle Sends the Message to all players
		 * in this world, except the optional ExcludeClient. No formatting is done by
		 * the server.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue message) {
			instance.getPlayers().forEach((player) -> {
				player.sendMessage(message.tojstring());
			});
			return NIL;
		}
	}

	class BroadcastChatDeath extends TwoArgFunction {
		/**
		 * 
		 * Message string ExcludeClient cClientHandle Prepends Gray [DEATH] / colours
		 * entire text (depending on ShouldUseChatPrefixes()) and broadcasts message.
		 * For when a player dies.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue message) {
			instance.getPlayers().forEach((player) -> {
				player.sendMessage(ColoredText.of(ChatColor.GRAY, "[DEATH] ".concat(message.tojstring())));
			});
			return NIL;
		}
	}

	class BroadcastChatFailure extends TwoArgFunction {
		/**
		 * 
		 * Message string ExcludeClient cClientHandle Prepends Rose [INFO] / colours
		 * entire text (depending on ShouldUseChatPrefixes()) and broadcasts message.
		 * For a command that failed to run because of insufficient permissions, etc.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue message) {
			instance.getPlayers().forEach((player) -> {
				player.sendMessage(ColoredText.of(ChatColor.RED, "[INFO] ".concat(message.tojstring())));
			});
			return NIL;
		}
	}

	class BroadcastChatFatal extends TwoArgFunction {
		/**
		 * 
		 * Message string ExcludeClient cClientHandle Prepends Red [FATAL] / colours
		 * entire text (depending on ShouldUseChatPrefixes()) and broadcasts message.
		 * For a plugin that crashed, or similar.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue message) {
			instance.getPlayers().forEach((player) -> {
				player.sendMessage(ColoredText.of(ChatColor.RED, "[FATAL] ".concat(message.tojstring())));
			});
			return NIL;
		}
	}

	class BroadcastChatInfo extends TwoArgFunction {
		/**
		 * 
		 * Message string ExcludeClient cClientHandle Prepends Yellow [INFO] / colours
		 * entire text (depending on ShouldUseChatPrefixes()) and broadcasts message.
		 * For informational messages, such as command usage.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue message) {
			instance.getPlayers().forEach((player) -> {
				player.sendMessage(ColoredText.of(ChatColor.YELLOW, "[INFO] ".concat(message.tojstring())));
			});
			return NIL;
		}
	}

	class BroadcastChatSuccess extends TwoArgFunction {
		/**
		 * 
		 * Message string ExcludeClient cClientHandle Prepends Green [INFO] / colours
		 * entire text (depending on ShouldUseChatPrefixes()) and broadcasts message.
		 * For success messages.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue message) {
			instance.getPlayers().forEach((player) -> {
				player.sendMessage(ColoredText.of(ChatColor.BRIGHT_GREEN, "[INFO] ".concat(message.tojstring())));
			});
			return NIL;
		}
	}

	class BroadcastChatWarning extends TwoArgFunction {
		/**
		 * 
		 * Message string ExcludeClient cClientHandle Prepends Rose [WARN] / colours
		 * entire text (depending on ShouldUseChatPrefixes()) and broadcasts message.
		 * For concerning events, such as plugin reload etc.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue message) {
			instance.getPlayers().forEach((player) -> {
				player.sendMessage(ColoredText.of(ChatColor.RED, "[WARN] ".concat(message.tojstring())));
			});
			return NIL;
		}
	}

	class BroadcastEntityAnimation extends OneArgFunction {
		/**
		 * 
		 * TargetEntity cEntity Animation number ExcludeClient cClientHandle Sends an
		 * animation of an entity to all clienthandles (except ExcludeClient if given)
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("BroadcastEntityAnimation is not yet implemented.");
			return NIL;
		}
	}

	class BroadcastParticleEffect extends VarArgFunction {
		/**
		 * 
		 * ParticleName string SourcePosition Vector3f Offset Vector3f ParticleData
		 * number ParticleAmount number ExcludeClient cClientHandle Spawns the specified
		 * particles to all players in the world exept the optional ExeptClient. A list
		 * of available particles by thinkofdeath can be found Here
		 */
		public LuaValue call(LuaValue[] args) {
			instance.getPlayers().forEach((player) -> {
				player.sendPacketToViewersAndSelf(
						ParticleCreator.createParticlePacket(Particle.valueOf(args[0].tojstring()),
								args[1].get("x").tofloat(), args[1].get("y").tofloat(), args[1].get("z").tofloat(),
								args[2].get("x").tofloat(), args[2].get("y").tofloat(), args[2].get("z").tofloat(), 1));
			});
			return NIL;
		}
	}

	class BroadcastSoundEffect extends VarArgFunction {
		/**
		 * 
		 * SoundName string Position Vector3d Volume number Pitch number ExcludeClient
		 * cClientHandle Sends the specified sound effect to all players in this world,
		 * except the optional ExceptClient
		 */
		public LuaValue call(LuaValue[] args) {
			instance.getPlayers().forEach((player) -> {
				player.playSound(Sound.valueOf(args[0].tojstring()), SoundCategory.MASTER, args[1].get("x").toint(),
						args[1].get("y").toint(), args[1].get("z").toint(), args[2].tofloat(), args[3].tofloat());
			});
			return NIL;
		}
	}

	class BroadcastSoundParticleEffect extends OneArgFunction {
		/**
		 * 
		 * EffectID number SourcePosition Vector3i EffectData string ExcludeClient
		 * cClientHandle Sends the specified effect to all players in this world, except
		 * the optional ExceptClient
		 */
		@Override
		public LuaValue call(LuaValue world) {
			// TODO: Should i do this?
			System.out.println("BroadcastSoundParticleEffect is not yet implemented.");
			return NIL;
		}
	}

	class CastThunderbolt extends TwoArgFunction {
		/**
		 * 
		 * Position Vector3i Creates a thunderbolt at the specified coords
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue coords) {
			SpawnEntityPacket spawnEntityPacket = new SpawnEntityPacket();
			spawnEntityPacket.entityId = Entity.generateId();
			spawnEntityPacket.uuid = UUID.randomUUID();
			spawnEntityPacket.type = EntityType.LIGHTNING_BOLT.getId();
			spawnEntityPacket.position = new Position(coords.get("x").toint(), coords.get("y").toint(),
					coords.get("z").toint());

			instance.getPlayers().forEach((player) -> {
				player.getPlayerConnection().sendPacket(spawnEntityPacket);
			});

			return NIL;
		}
	}

	class ChangeWeather extends OneArgFunction {
		/**
		 * 
		 * Forces the weather to change in the next game tick. Weather is changed
		 * according to the normal rules: wSunny <-> wRain <-> wStorm
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ChangeWeather is not yet implemented.");
			return NIL;
		}
	}

	class ChunkStay extends OneArgFunction {
		/**
		 * 
		 * ChunkCoordTable table OnChunkAvailable function OnAllChunksAvailable function
		 * Queues the specified chunks to be loaded or generated and calls the specified
		 * callbacks once they are loaded. ChunkCoordTable is an arra-table of chunk
		 * coords, each coord being a table of 2 numbers: { {Chunk1x, Chunk1z},
		 * {Chunk2x, Chunk2z}, ...}. When any of those chunks are made available
		 * (including being available at the start of this call), the OnChunkAvailable()
		 * callback is called. When all the chunks are available, the
		 * OnAllChunksAvailable() callback is called. The function signatures are:
		 * function OnChunkAvailable(ChunkX, ChunkZ) function OnAllChunksAvailable()All
		 * return values from the callbacks are ignored.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ChunkStay is not yet implemented.");
			return NIL;
		}
	}

	class CreateProjectile extends VarArgFunction {
		/**
		 * 
		 * Position Vector3d ProjectileKind eKind Creator cEntity Originating Item cItem
		 * Speed Vector3d Creates a new projectile of the specified kind at the
		 * specified coords. The projectile's creator is set to Creator (may be nil).
		 * The item that created the projectile entity, commonly the player's currently
		 * equipped item, is used at present for fireworks to correctly set their entity
		 * metadata. It is not used for any other projectile. Optional speed indicates
		 * the initial speed for the projectile.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("CreateProjectile is not yet implemented.");
			return NIL;
		}
	}

	class DigBlock extends ThreeArgFunction {
		/**
		 * 
		 * BlockPosition Vector3i Digger cEntity boolean Replaces the specified block
		 * with air, without dropping the usual pickups for the block. Wakes up the
		 * simulators for the block and its neighbors. The optional Digger parameter
		 * specifies the entity who dug the block, usually a player. Returns true on
		 * success, or false if the chunk is not loaded or invalid coords. See also
		 * DropBlockAsPickups() for the version that drops pickups.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue vector, LuaValue entity) {
			try {
				instance.setBlock(new Vector3i(vector).toBlockPosition(), Block.AIR);
				return TRUE;
			} catch (Exception e) {
				return FALSE;
			}
		}
	}

	class DoExplosionAt extends OneArgFunction {
		/**
		 * 
		 * Force number Position Vector3d CanCauseFire boolean Source eExplosionSource
		 * SourceData any Creates an explosion of the specified relative force in the
		 * specified position. If CanCauseFire is set, the explosion will set blocks on
		 * fire, too. The Source parameter specifies the source of the explosion, one of
		 * the esXXX constants. The SourceData parameter is specific to each source
		 * type, usually it provides more info about the source.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoExplosionAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithBeaconAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a beacon at
		 * the specified coords, calls the CallbackFunction with the cBeaconEntity
		 * parameter representing the beacon. The CallbackFunction has the following
		 * signature: function Callback(BeaconEntity)The function returns false if there
		 * is no beacon, or if there is, it returns the bool value that the callback has
		 * returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithBeaconAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithBedAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a bed at the
		 * specified coords, calls the CallbackFunction with the cBedEntity parameter
		 * representing the bed. The CallbackFunction has the following signature:
		 * function Callback(cBedEntity)The function returns false if there is no bed,
		 * or if there is, it returns the bool value that the callback has returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithBedAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithBlockEntityAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a block
		 * entity at the specified coords, calls the CallbackFunction with the
		 * cBlockEntity parameter representing the block entity. The CallbackFunction
		 * has the following signature: function Callback(BlockEntity)The function
		 * returns false if there is no block entity, or if there is, it returns the
		 * bool value that the callback has returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithBlockEntityAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithBrewingstandAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a
		 * brewingstand at the specified coords, calls the CallbackFunction with the
		 * cBrewingstandEntity parameter representing the brewingstand. The
		 * CallbackFunction has the following signature: function
		 * Callback(cBrewingstandEntity)The function returns false if there is no
		 * brewingstand, or if there is, it returns the bool value that the callback has
		 * returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithBrewingstandAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithChestAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a chest at
		 * the specified coords, calls the CallbackFunction with the cChestEntity
		 * parameter representing the chest. The CallbackFunction has the following
		 * signature: function Callback(ChestEntity)The function returns false if there
		 * is no chest, or if there is, it returns the bool value that the callback has
		 * returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithChestAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithCommandBlockAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a command
		 * block at the specified coords, calls the CallbackFunction with the
		 * cCommandBlockEntity parameter representing the command block. The
		 * CallbackFunction has the following signature: function
		 * Callback(CommandBlockEntity)The function returns false if there is no command
		 * block, or if there is, it returns the bool value that the callback has
		 * returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithCommandBlockAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithDispenserAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a dispenser
		 * at the specified coords, calls the CallbackFunction with the cDispenserEntity
		 * parameter representing the dispenser. The CallbackFunction has the following
		 * signature: function Callback(DispenserEntity)The function returns false if
		 * there is no dispenser, or if there is, it returns the bool value that the
		 * callback has returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithDispenserAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithDropSpenserAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a dropper or
		 * a dispenser at the specified coords, calls the CallbackFunction with the
		 * cDropSpenserEntity parameter representing the dropper or dispenser. The
		 * CallbackFunction has the following signature: function
		 * Callback(DropSpenserEntity)Note that this can be used to access both
		 * dispensers and droppers in a similar way. The function returns false if there
		 * is neither dispenser nor dropper, or if there is, it returns the bool value
		 * that the callback has returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithDropSpenserAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithDropperAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a dropper at
		 * the specified coords, calls the CallbackFunction with the cDropperEntity
		 * parameter representing the dropper. The CallbackFunction has the following
		 * signature: function Callback(DropperEntity)The function returns false if
		 * there is no dropper, or if there is, it returns the bool value that the
		 * callback has returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithDropperAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithEntityByID extends OneArgFunction {
		/**
		 * 
		 * EntityID number CallbackFunction function boolean If an entity with the
		 * specified ID exists, calls the callback with the cEntity parameter
		 * representing the entity. The CallbackFunction has the following signature:
		 * function Callback(Entity)The function returns false if the entity was not
		 * found, and it returns the same bool value that the callback has returned if
		 * the entity was found.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithEntityByID is not yet implemented.");
			return NIL;
		}
	}

	class DoWithFlowerPotAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a flower pot
		 * at the specified coords, calls the CallbackFunction with the cFlowerPotEntity
		 * parameter representing the flower pot. The CallbackFunction has the following
		 * signature: function Callback(FlowerPotEntity)The function returns false if
		 * there is no flower pot, or if there is, it returns the bool value that the
		 * callback has returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithFlowerPotAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithFurnaceAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a furnace at
		 * the specified coords, calls the CallbackFunction with the cFurnaceEntity
		 * parameter representing the furnace. The CallbackFunction has the following
		 * signature: function Callback(FurnaceEntity)The function returns false if
		 * there is no furnace, or if there is, it returns the bool value that the
		 * callback has returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithFurnaceAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithHopperAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a hopper at
		 * the specified coords, calls the CallbackFunction with the cHopperEntity
		 * parameter representing the hopper. The CallbackFunction has the following
		 * signature: function Callback(cHopperEntity)The function returns false if
		 * there is no hopper, or if there is, it returns the bool value that the
		 * callback has returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithHopperAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithMobHeadAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a mob head at
		 * the specified coords, calls the CallbackFunction with the cMobHeadEntity
		 * parameter representing the furnace. The CallbackFunction has the following
		 * signature: function Callback(MobHeadEntity)The function returns false if
		 * there is no mob head, or if there is, it returns the bool value that the
		 * callback has returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithMobHeadAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithNearestPlayer extends OneArgFunction {
		/**
		 * 
		 * Position Vector3d RangeLimit number CallbackFunction function
		 * CheckLineOfSight boolean IgnoreSpectator boolean boolean Calls the specified
		 * callback function with the player nearest to the specified position as its
		 * parameter, if they are still within the range limit. The CallbackFunction has
		 * the following signature: function Callback(Player)The function returns false
		 * if the player was not found, or whatever bool value the callback returned if
		 * the player was found.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithNearestPlayer is not yet implemented.");
			return NIL;
		}
	}

	class DoWithNoteBlockAt extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i CallbackFunction function boolean If there is a note block
		 * at the specified coords, calls the CallbackFunction with the cNoteEntity
		 * parameter representing the note block. The CallbackFunction has the following
		 * signature: function Callback(NoteEntity)The function returns false if there
		 * is no note block, or if there is, it returns the bool value that the callback
		 * has returned.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithNoteBlockAt is not yet implemented.");
			return NIL;
		}
	}

	class DoWithPlayer extends ThreeArgFunction {
		/**
		 * 
		 * PlayerName string CallbackFunction function boolean If there is a player of
		 * the specified name (exact match), calls the CallbackFunction with the cPlayer
		 * parameter representing the player. The CallbackFunction has the following
		 * signature: function Callback(Player)The function returns false if the player
		 * was not found, or whatever bool value the callback returned if the player was
		 * found.
		 * 
		 * @return
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue name, LuaValue func) {
			Object[] players = instance.getPlayers().toArray();

			for (int i = 0; i < players.length; i++) {
				Player player = (Player) players[i];
				if (player.getUsername() == name.tojstring()) {
					return func.call(new cPlayer(player).luaValue);
				}
			}

			return FALSE;
		}
	}

	class DoWithPlayerByUUID extends OneArgFunction {
		/**
		 * 
		 * PlayerUUID cUUID CallbackFunction function boolean If there is the player
		 * with the uuid, calls the CallbackFunction with the cPlayer parameter
		 * representing the player. The CallbackFunction has the following signature:
		 * function Callback(Player)The function returns false if the player was not
		 * found, or whatever bool value the callback returned if the player was found.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("DoWithPlayerByUUID is not yet implemented.");
			return NIL;
		}
	}

	class DropBlockAsPickups extends VarArgFunction {
		/**
		 * 
		 * BlockPosition Vector3i Digger cEntity Tool cItem IsSuccess boolean Digs up
		 * the specified block and spawns the appropriate pickups for it. The optional
		 * Digger parameter specifies the entity who dug the block, usually a player.
		 * The optional Tool parameter specifies the tool used to dig the block, not
		 * present means an empty hand. Returns true on success, false if the chunk is
		 * not present. See also DigBlock() for the pickup-less version.
		 */
		public LuaValue call(LuaValue[] args) {
			instance.breakBlock(null, new Vector3i(args[1]).toBlockPosition());
			return NIL;
		}
	}

	class FastSetBlock extends VarArgFunction {
		/**
		 * 
		 * BlockCoords Vector3i BlockType number BlockMeta number Sets the block at the
		 * specified coords, without waking up the simulators or replacing the block
		 * entities for the previous block type. Do not use if the block being replaced
		 * has a block entity tied to it!
		 */
		public LuaValue call(LuaValue[] args) {
			instance.setBlock(new Vector3i(args[1]).toBlockPosition(), Block.values()[args[2].toint()]);
			return NIL;
		}
	}

	class FindAndDoWithPlayer extends ThreeArgFunction {
		/**
		 * 
		 * PlayerName string CallbackFunction function boolean Calls the given callback
		 * function for the player with the name best matching the name string provided.
		 * This function is case-insensitive and will match partial names. Returns false
		 * if player not found or there is ambiguity, true otherwise. The
		 * CallbackFunction has the following signature: function Callback(Player)
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue playerName, LuaValue callbackFunction) {
			Object[] players = instance.getPlayers().toArray();

			for (int i = 0; i < players.length; i++) {
				Player player = (Player) players[i];
				if (player.getUsername() == playerName.tojstring()) {
					callbackFunction.call(new cPlayer(player).luaValue);
					return TRUE;
				}
			}

			return FALSE;
		}
	}

	class ForEachBlockEntityInChunk extends OneArgFunction {
		/**
		 * 
		 * ChunkX number ChunkZ number CallbackFunction function boolean Calls the
		 * specified callback for each block entity in the chunk. Returns true if all
		 * block entities in the chunk have been processed (including when there are
		 * zero block entities), or false if the callback has aborted the enumeration by
		 * returning true. The CallbackFunction has the following signature: function
		 * Callback(BlockEntity)The callback should return false or no value to continue
		 * with the next block entity, or true to abort the enumeration.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ForEachBlockEntityInChunk is not yet implemented.");
			return NIL;
		}
	}

	class ForEachBrewingstandInChunk extends OneArgFunction {
		/**
		 * 
		 * ChunkX number ChunkZ number CallbackFunction function boolean Calls the
		 * specified callback for each brewingstand in the chunk. Returns true if all
		 * brewingstands in the chunk have been processed (including when there are zero
		 * brewingstands), or false if the callback has aborted the enumeration by
		 * returning true. The CallbackFunction has the following signature: function
		 * Callback(cBrewingstandEntity)The callback should return false or no value to
		 * continue with the next brewingstand, or true to abort the enumeration.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ForEachBrewingstandInChunk is not yet implemented.");
			return NIL;
		}
	}

	class ForEachChestInChunk extends OneArgFunction {
		/**
		 * 
		 * ChunkX number ChunkZ number CallbackFunction function boolean Calls the
		 * specified callback for each chest in the chunk. Returns true if all chests in
		 * the chunk have been processed (including when there are zero chests), or
		 * false if the callback has aborted the enumeration by returning true. The
		 * CallbackFunction has the following signature: function
		 * Callback(ChestEntity)The callback should return false or no value to continue
		 * with the next chest, or true to abort the enumeration.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ForEachChestInChunk is not yet implemented.");
			return NIL;
		}
	}

	class ForEachEntity extends OneArgFunction {
		/**
		 * 
		 * CallbackFunction function boolean Calls the specified callback for each
		 * entity in the loaded world. Returns true if all the entities have been
		 * processed (including when there are zero entities), or false if the callback
		 * function has aborted the enumeration by returning true. The callback function
		 * has the following signature: function Callback(Entity)The callback should
		 * return false or no value to continue with the next entity, or true to abort
		 * the enumeration.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ForEachEntity is not yet implemented.");
			return NIL;
		}
	}

	class ForEachEntityInBox extends OneArgFunction {
		/**
		 * 
		 * Box cBoundingBox CallbackFunction function boolean Calls the specified
		 * callback for each entity in the specified bounding box. Returns true if all
		 * the entities have been processed (including when there are zero entities), or
		 * false if the callback function has aborted the enumeration by returning true.
		 * If any chunk within the bounding box is not valid, it is silently skipped
		 * without any notification. The callback function has the following signature:
		 * function Callback(Entity)The callback should return false or no value to
		 * continue with the next entity, or true to abort the enumeration.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ForEachEntityInBox is not yet implemented.");
			return NIL;
		}
	}

	class ForEachEntityInChunk extends OneArgFunction {
		/**
		 * 
		 * ChunkX number ChunkZ number CallbackFunction function boolean Calls the
		 * specified callback for each entity in the specified chunk. Returns true if
		 * all the entities have been processed (including when there are zero
		 * entities), or false if the chunk is not loaded or the callback function has
		 * aborted the enumeration by returning true. The callback function has the
		 * following signature: function Callback(Entity)The callback should return
		 * false or no value to continue with the next entity, or true to abort the
		 * enumeration.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ForEachEntityInChunk is not yet implemented.");
			return NIL;
		}
	}

	class ForEachFurnaceInChunk extends OneArgFunction {
		/**
		 * 
		 * ChunkX number ChunkZ number CallbackFunction function boolean Calls the
		 * specified callback for each furnace in the chunk. Returns true if all
		 * furnaces in the chunk have been processed (including when there are zero
		 * furnaces), or false if the callback has aborted the enumeration by returning
		 * true. The CallbackFunction has the following signature: function
		 * Callback(FurnaceEntity)The callback should return false or no value to
		 * continue with the next furnace, or true to abort the enumeration.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ForEachFurnaceInChunk is not yet implemented.");
			return NIL;
		}
	}

	class ForEachLoadedChunk extends OneArgFunction {
		/**
		 * 
		 * CallbackFunction function boolean Calls the specified callback for each
		 * loaded chunk in the world. Returns true if all chunks have been processed, or
		 * false if the callback has aborted the enumeration by returning true. The
		 * CallbackFunction has the following signature: function Callback(ChunkX,
		 * ChunkZ)The callback should return false or no value to continue with the next
		 * chunk, or true to abort the enumeration.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ForEachLoadedChunk is not yet implemented.");
			return NIL;
		}
	}

	class ForEachPlayer extends TwoArgFunction {
		/**
		 * 
		 * CallbackFunction function boolean Calls the specified callback for each
		 * player in the loaded world. Returns true if all the players have been
		 * processed (including when there are zero players), or false if the callback
		 * function has aborted the enumeration by returning true. The callback function
		 * has the following signature: function Callback(Player)The callback should
		 * return false or no value to continue with the next player, or true to abort
		 * the enumeration.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue callback) {
			Object[] players = instance.getPlayers().toArray();

			for (int i = 0; i < players.length; i++) {
				Player player = (Player) players[i];
				LuaValue bool = callback.call(new cPlayer(player).luaValue);
				if (bool == TRUE)
					return FALSE;
			}

			return TRUE;
		}
	}

	class GenerateChunk extends ThreeArgFunction {
		/**
		 * 
		 * ChunkX number ChunkZ number Queues the specified chunk in the chunk
		 * generator. Ignored if the chunk is already generated (use RegenerateChunk()
		 * to force chunk re-generation).
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue x, LuaValue z) {
			instance.loadChunk(x.toint(), z.toint());
			return NIL;
		}
	}

	class GetBiomeAt extends ThreeArgFunction {
		/**
		 * 
		 * BlockX number BlockZ number eBiome EMCSBiome Returns the biome at the
		 * specified coords. Reads the biome from the chunk, if it is loaded, otherwise
		 * it uses the chunk generator to provide the biome value.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue x, LuaValue z) {
			Biome biome = instance.getChunkAt(new BlockPosition(x.toint(), 0, z.toint())).getBiomes()[(x.toint() % 16)
					+ ((z.toint() % 16) % 4)];
			return valueOf(biome.getId());
		}
	}

	class GetBlock extends TwoArgFunction {
		/**
		 * 
		 * BlockCoords Vector3i BLOCKTYPE number Returns the block type of the block at
		 * the specified coords, or 0 if the appropriate chunk is not loaded.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue vector) {
			return valueOf(
					Block.fromStateId(instance.getBlockStateId(new Vector3i(vector).toBlockPosition())).ordinal());
		}
	}

	class GetBlockBlockLight extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i number Returns the amount of block light at the specified
		 * coords, or 0 if the appropriate chunk is not loaded.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetBlockBlockLight is not yet implemented.");
			return NIL;
		}
	}

	class GetBlockInfo extends VarArgFunction {
		/**
		 * 
		 * Position Vector3i IsBlockValid boolean BlockType number BlockMeta number
		 * BlockSkyLight number BlockBlockLight number Returns the complete block info
		 * for the block at the specified coords. The first value specifies if the block
		 * is in a valid loaded chunk, the other values are valid only if BlockValid is
		 * true.
		 */
		public Varargs call(LuaValue[] args) {
			BlockPosition position = new Vector3i(args[1]).toBlockPosition();
			LuaValue[] returnValue = { valueOf(Block.fromStateId(instance.getBlockStateId(position)) != Block.AIR),
					valueOf(Block.fromStateId(instance.getBlockStateId(position)).ordinal()),
					// TODO: extra block data
					valueOf(0), valueOf(0), valueOf(0),

			};
			return varargsOf(returnValue);
		}
	}

	class GetBlockMeta extends OneArgFunction {
		/**
		 * 
		 * BlockCoords Vector3i number Returns the block metadata of the block at the
		 * specified coords, or 0 if the appropriate chunk is not loaded.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetBlockMeta is not yet implemented.");
			return NIL;
		}
	}

	class GetBlockSkyLight extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i number Returns the block skylight of the block at the
		 * specified coords, or 0 if the appropriate chunk is not loaded.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetBlockSkyLight is not yet implemented.");
			return NIL;
		}
	}

	class GetBlockTypeMeta extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i IsBlockValid boolean BlockType number BlockMeta number
		 * Returns the block type and metadata for the block at the specified coords.
		 * The first value specifies if the block is in a valid loaded chunk, the other
		 * values are valid only if BlockValid is true.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetBlockTypeMeta is not yet implemented.");
			return NIL;
		}
	}

	class GetDataPath extends OneArgFunction {
		/**
		 * 
		 * string Returns the path to the root of the world data.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetDataPath is not yet implemented.");
			return NIL;
		}
	}

	class GetDefaultWeatherInterval extends OneArgFunction {
		/**
		 * 
		 * Weather eWeather number Returns the default weather interval for the specific
		 * weather type. Returns -1 for any unknown weather.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetDefaultWeatherInterval is not yet implemented.");
			return NIL;
		}
	}

	class GetDimension extends OneArgFunction {
		/**
		 * 
		 * eDimension Returns the dimension of the world - dimOverworld, dimNether or
		 * dimEnd.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			return valueOf(instance.getDimensionType().getId());
		}
	}

	class GetGameMode extends OneArgFunction {
		/**
		 * 
		 * eGameMode Returns the gamemode of the world - gmSurvival, gmCreative or
		 * gmAdventure.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetGameMode is not yet implemented.");
			return NIL;
		}
	}

	class GetGeneratorQueueLength extends OneArgFunction {
		/**
		 * 
		 * number Returns the number of chunks that are queued in the chunk generator.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetGeneratorQueueLength is not yet implemented.");
			return NIL;
		}
	}

	class GetHeight extends ThreeArgFunction {
		/**
		 * 
		 * BlockX number BlockZ number number Returns the maximum height of the
		 * particula block column in the world. If the chunk is not loaded, it waits for
		 * it to load / generate. WARNING: Do not use, Use TryGetHeight() instead for a
		 * non-waiting version, otherwise you run the risk of a deadlock!
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue x, LuaValue z) {
			BlockPosition pos = new BlockPosition(x.toint(), 0, z.toint());
			while (Block.fromStateId(instance.getBlockStateId(pos)) != Block.AIR) {
				pos.add(0, 1, 0);
			}
			return valueOf(pos.getY());
		}
	}

	class GetIniFileName extends OneArgFunction {
		/**
		 * 
		 * string Returns the name of the world.ini file that the world uses to store
		 * the information.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetIniFileName is not yet implemented.");
			return NIL;
		}
	}

	class GetLightingQueueLength extends OneArgFunction {
		/**
		 * 
		 * number Returns the number of chunks in the lighting thread's queue.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetLightingQueueLength is not yet implemented.");
			return NIL;
		}
	}

	class GetLinkedEndWorldName extends OneArgFunction {
		/**
		 * 
		 * string Returns the name of the end world this world is linked to.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetLinkedEndWorldName is not yet implemented.");
			return NIL;
		}
	}

	class GetLinkedNetherWorldName extends OneArgFunction {
		/**
		 * 
		 * string Returns the name of the Netherworld linked to this world.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetLinkedNetherWorldName is not yet implemented.");
			return NIL;
		}
	}

	class GetLinkedOverworldName extends OneArgFunction {
		/**
		 * 
		 * string Returns the name of the world this world is linked to.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetLinkedOverworldName is not yet implemented.");
			return NIL;
		}
	}

	class GetMapManager extends OneArgFunction {
		/**
		 * 
		 * cMapManager Returns the MapManager object used by this world.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetMapManager is not yet implemented.");
			return NIL;
		}
	}

	class GetMaxCactusHeight extends OneArgFunction {
		/**
		 * 
		 * number Returns the configured maximum height to which cacti will grow
		 * naturally.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetMaxCactusHeight is not yet implemented.");
			return NIL;
		}
	}

	class GetMaxNetherPortalHeight extends OneArgFunction {
		/**
		 * 
		 * number Returns the maximum height for a nether portal
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetMaxNetherPortalHeight is not yet implemented.");
			return NIL;
		}
	}

	class GetMaxNetherPortalWidth extends OneArgFunction {
		/**
		 * 
		 * number Returns the maximum width for a nether portal
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetMaxNetherPortalWidth is not yet implemented.");
			return NIL;
		}
	}

	class GetMaxSugarcaneHeight extends OneArgFunction {
		/**
		 * 
		 * number Returns the configured maximum height to which sugarcane will grow
		 * naturally.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetMaxSugarcaneHeight is not yet implemented.");
			return NIL;
		}
	}

	class GetMaxViewDistance extends OneArgFunction {
		/**
		 * 
		 * number Returns the maximum viewdistance that players can see in this world.
		 * The view distance is the amount of chunks around the player that the player
		 * can see.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetMaxViewDistance is not yet implemented.");
			return NIL;
		}
	}

	class GetMinNetherPortalHeight extends OneArgFunction {
		/**
		 * 
		 * number Returns the minimum height for a nether portal
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetMinNetherPortalHeight is not yet implemented.");
			return NIL;
		}
	}

	class GetMinNetherPortalWidth extends OneArgFunction {
		/**
		 * 
		 * number Returns the minimum width for a nether portal
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetMinNetherPortalWidth is not yet implemented.");
			return NIL;
		}
	}

	class GetName extends OneArgFunction {
		/**
		 * 
		 * string Returns the name of the world, as specified in the settings.ini file.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetName is not yet implemented.");
			return NIL;
		}
	}

	class GetNumChunks extends OneArgFunction {
		/**
		 * 
		 * number Returns the number of chunks currently loaded.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetNumChunks is not yet implemented.");
			return NIL;
		}
	}

	class GetNumUnusedDirtyChunks extends OneArgFunction {
		/**
		 * 
		 * number Returns the number of unused dirty chunks. That's the number of chunks
		 * that we can save and then unload.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetNumUnusedDirtyChunks is not yet implemented.");
			return NIL;
		}
	}

	class GetScoreBoard extends OneArgFunction {
		/**
		 * 
		 * cScoreboard Returns the Scoreboard object used by this world.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetScoreBoard is not yet implemented.");
			return NIL;
		}
	}

	class GetSeed extends OneArgFunction {
		/**
		 * 
		 * number Returns the seed of the world.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetSeed is not yet implemented.");
			return NIL;
		}
	}

	class GetSignLines extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i IsValid boolean Line1 string Line2 string Line3 string
		 * Line4 string Returns true and the lines of a sign at the specified coords, or
		 * false if there is no sign at the coords.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetSignLines is not yet implemented.");
			return NIL;
		}
	}

	class GetSpawnX extends OneArgFunction {
		/**
		 * 
		 * number Returns the X coord of the default spawn
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetSpawnX is not yet implemented.");
			return NIL;
		}
	}

	class GetSpawnY extends OneArgFunction {
		/**
		 * 
		 * number Returns the Y coord of the default spawn
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetSpawnY is not yet implemented.");
			return NIL;
		}
	}

	class GetSpawnZ extends OneArgFunction {
		/**
		 * 
		 * number Returns the Z coord of the default spawn
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetSpawnZ is not yet implemented.");
			return NIL;
		}
	}

	class GetStorageLoadQueueLength extends OneArgFunction {
		/**
		 * 
		 * number Returns the number of chunks queued up for loading
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetStorageLoadQueueLength is not yet implemented.");
			return NIL;
		}
	}

	class GetStorageSaveQueueLength extends OneArgFunction {
		/**
		 * 
		 * number Returns the number of chunks queued up for saving
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetStorageSaveQueueLength is not yet implemented.");
			return NIL;
		}
	}

	class GetTNTShrapnelLevel extends OneArgFunction {
		/**
		 * 
		 * ShrapnelLevel eShrapnelLevel Returns the shrapnel level, representing the
		 * block types that are propelled outwards following an explosion. Based on this
		 * value and a random picker, blocks are selectively converted to physics
		 * entities (FallingSand) and flung outwards.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetTNTShrapnelLevel is not yet implemented.");
			return NIL;
		}
	}

	class GetTicksUntilWeatherChange extends OneArgFunction {
		/**
		 * 
		 * number Returns the number of ticks that will pass before the weather is
		 * changed
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetTicksUntilWeatherChange is not yet implemented.");
			return NIL;
		}
	}

	class GetTimeOfDay extends OneArgFunction {
		/**
		 * 
		 * number Returns the number of ticks that have passed from the sunrise, 0 ..
		 * 24000.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			return valueOf(instance.getTime());
		}
	}

	class GetUUID extends OneArgFunction {
		/**
		 * 
		 * string Returns the name of the world, as specified in the settings.ini file.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			return valueOf(instance.getUniqueId().toString());
		}
	}

	class GetWeather extends OneArgFunction {
		/**
		 * 
		 * eWeather Returns the current weather in the world (wSunny, wRain, wStorm). To
		 * check for weather, use IsWeatherXXX() functions instead.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GetWeather is not yet implemented.");
			return NIL;
		}
	}

	class GetWorldAge extends OneArgFunction {
		/**
		 * 
		 * number Returns the total age of the world, in ticks. The age always grows,
		 * cannot be set by plugins and is unrelated to TimeOfDay.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			return valueOf(instance.getWorldAge());
		}
	}

	class GrowPlantAt extends OneArgFunction {
		/**
		 * 
		 * BlockPosition Vector3i NumStages number number Grows the plant at the
		 * specified block by the specified number of stages. Returns the number of
		 * stages actually grown. Returns zero for non-growable blocks.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GrowPlantAt is not yet implemented.");
			return NIL;
		}
	}

	class GrowRipePlant extends OneArgFunction {
		/**
		 * 
		 * BlockPosition Vector3i boolean Grows the plant at the specified coords to its
		 * full. Returns true if the plant was grown, false if not.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GrowRipePlant is not yet implemented.");
			return NIL;
		}
	}

	class GrowTree extends OneArgFunction {
		/**
		 * 
		 * BlockPosition Vector3i boolean Grows a tree based at the specified coords. If
		 * there is a sapling there, grows the tree based on that sapling, otherwise
		 * chooses a tree image based on the biome. Returns true if the tree was grown,
		 * false if not (invalid chunk, insufficient space)
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GrowTree is not yet implemented.");
			return NIL;
		}
	}

	class GrowTreeByBiome extends OneArgFunction {
		/**
		 * 
		 * BlockPosition Vector3i boolean Grows a tree based at the specified coords.
		 * The tree type is picked from types available for the biome at those coords.
		 * Returns true if the tree was grown, false if not (invalid chunk, insufficient
		 * space)
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GrowTreeByBiome is not yet implemented.");
			return NIL;
		}
	}

	class GrowTreeFromSapling extends OneArgFunction {
		/**
		 * 
		 * BlockPosition Vector3i boolean Grows a tree based at the specified coords.
		 * The tree type is determined from the sapling meta. If the sapling is part of
		 * a 2x2 sapling area, grows a large tree. Returns true if the tree was grown,
		 * false if not (invalid chunk, insufficient space)
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("GrowTreeFromSapling is not yet implemented.");
			return NIL;
		}
	}

	class IsBlockDirectlyWatered extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i boolean Returns true if the specified block has a water
		 * block right next to it (on the X/Z axes)
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsBlockDirectlyWatered is not yet implemented.");
			return NIL;
		}
	}

	class IsDaylightCycleEnabled extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the daylight cycle is enabled.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsDaylightCycleEnabled is not yet implemented.");
			return NIL;
		}
	}

	class IsDeepSnowEnabled extends OneArgFunction {
		/**
		 * 
		 * boolean Returns whether the configuration has DeepSnow enabled.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsDeepSnowEnabled is not yet implemented.");
			return NIL;
		}
	}

	class IsGameModeAdventure extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the current gamemode is gmAdventure.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsGameModeAdventure is not yet implemented.");
			return NIL;
		}
	}

	class IsGameModeCreative extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the current gamemode is gmCreative.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsGameModeCreative is not yet implemented.");
			return NIL;
		}
	}

	class IsGameModeSpectator extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the current gamemode is gmSpectator.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsGameModeSpectator is not yet implemented.");
			return NIL;
		}
	}

	class IsGameModeSurvival extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the current gamemode is gmSurvival.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsGameModeSurvival is not yet implemented.");
			return NIL;
		}
	}

	class IsPVPEnabled extends OneArgFunction {
		/**
		 * 
		 * boolean Returns whether PVP is enabled in the world settings. IsSavingEnabled
		 * boolean Returns whether or not saving chunk data is enabled. If disabled, the
		 * world will keep dirty chunks in memory forever, and will simply regenerate
		 * non-dirty chunks that are unloaded.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsPVPEnabled is not yet implemented.");
			return NIL;
		}
	}

	class IsTrapdoorOpen extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i boolean Returns false if there is no trapdoor there or if
		 * the block isn't a trapdoor or if the chunk wasn't loaded. Returns true if
		 * trapdoor is open.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsTrapdoorOpen is not yet implemented.");
			return NIL;
		}
	}

	class IsWeatherRain extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the current weather is rainy.
		 * 
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsWeatherRain is not yet implemented.");
			return NIL;
		}
	}

	class IsWeatherRainAt extends OneArgFunction {
		/**
		 * 
		 * BlockX number BlockZ number boolean Returns true if it is rainy at the
		 * specified location. This takes into account biomes.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsWeatherRainAt is not yet implemented.");
			return NIL;
		}
	}

	class IsWeatherStorm extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the current weather is stormy.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsWeatherStorm is not yet implemented.");
			return NIL;
		}
	}

	class IsWeatherStormAt extends OneArgFunction {
		/**
		 * 
		 * BlockX number BlockZ number boolean Returns true if it is stormy at the
		 * specified location. This takes into account biomes.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsWeatherStormAt is not yet implemented.");
			return NIL;
		}
	}

	class IsWeatherSunny extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the current weather is sunny.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsWeatherSunny is not yet implemented.");
			return NIL;
		}
	}

	class IsWeatherSunnyAt extends OneArgFunction {
		/**
		 * 
		 * BlockX number BlockZ number boolean Returns true if it is sunny at the
		 * specified location. This takes into account biomes.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsWeatherSunnyAt is not yet implemented.");
			return NIL;
		}
	}

	class IsWeatherWet extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the world currently has any precipitation - rain,
		 * storm or snow.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsWeatherWet is not yet implemented.");
			return NIL;
		}
	}

	class IsWeatherWetAt extends OneArgFunction {
		/**
		 * 
		 * BlockX number BlockZ number boolean Returns true if it is raining or storming
		 * at the specified location. This takes into account biomes.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsWeatherWetAt is not yet implemented.");
			return NIL;
		}
	}

	class IsWeatherWetAtXYZ extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i boolean Returns true if the specified location has wet
		 * weather (rain or storm), using the same logic as IsWeatherWetAt, except that
		 * any rain-blocking blocks above the specified position will block the
		 * precipitation and this function will return false.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("IsWeatherWetAtXYZ is not yet implemented.");
			return NIL;
		}
	}

	class PickupsFromBlock extends OneArgFunction {
		/**
		 * 
		 * BlockPosition Vector3i Digger cEntity Tool cItem Items cItems Returns all the
		 * pickups that would result if the Digger dug up the block at BlockPos using
		 * Tool. Digger is usually a cPlayer, but can be nil for natural causes. Tool is
		 * usually the equipped item, can be nil for empty hand. Returns an empty cItems
		 * object if the chunk is not present.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("PickupsFromBlock is not yet implemented.");
			return NIL;
		}
	}

	class PrepareChunk extends OneArgFunction {
		/**
		 * 
		 * ChunkX number ChunkZ number Callback function Queues the chunk for preparing
		 * - making sure that it's generated and lit. It is legal to call with no
		 * callback. The callback function has the following signature: function
		 * Callback(ChunkX, ChunkZ)
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("PrepareChunk is not yet implemented.");
			return NIL;
		}
	}

	class QueueBlockForTick extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i TicksToWait number Queues the specified block to be ticked
		 * after the specified number of gameticks.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("QueueBlockForTick is not yet implemented.");
			return NIL;
		}
	}

	class QueueSaveAllChunks extends OneArgFunction {
		/**
		 * 
		 * Queues all chunks to be saved in the world storage thread
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("QueueSaveAllChunks is not yet implemented.");
			return NIL;
		}
	}

	class QueueTask extends OneArgFunction {
		/**
		 * 
		 * TaskFunction function Queues the specified function to be executed in the
		 * tick thread. This is the primary means of interaction with a cWorld from the
		 * WebAdmin page handlers (see WebWorldThreads). The function signature is
		 * function(World) All return values from the function are ignored. Note that
		 * this function is actually called *after* the QueueTask() function returns.
		 * Note that it is unsafe to store references to Cuberite objects, such as
		 * entities, across from the caller to the task handler function; store the
		 * EntityID instead.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("QueueTask is not yet implemented.");
			return NIL;
		}
	}

	class QueueUnloadUnusedChunks extends OneArgFunction {
		/**
		 * 
		 * Queues a cTask that unloads chunks that are no longer needed and are saved.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("QueueUnloadUnusedChunks is not yet implemented.");
			return NIL;
		}
	}

	class RegenerateChunk extends OneArgFunction {
		/**
		 * 
		 * ChunkX number ChunkZ number Queues the specified chunk to be re-generated,
		 * overwriting the current data. To queue a chunk for generating only if it
		 * doesn't exist, use the GenerateChunk() instead.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("RegenerateChunk is not yet implemented.");
			return NIL;
		}
	}

	class ScheduleTask extends ThreeArgFunction {
		/**
		 * 
		 * DelayTicks number TaskFunction function Queues the specified function to be
		 * executed in the world's tick thread after a the specified number of ticks.
		 * This enables operations to be queued for execution in the future. The
		 * function signature is function(World) All return values from the function are
		 * ignored. Note that it is unsafe to store references to Cuberite objects, such
		 * as entities, across from the caller to the task handler function; store the
		 * EntityID instead.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue ticks, LuaValue function) {
			instance.scheduleNextTick((instance) -> {
				MinecraftServer.getSchedulerManager().buildTask(new Runnable() {
					@Override
					public void run() {
						function.call(luaValue);
					}
				}).delay(ticks.toint(), TimeUnit.TICK).schedule();
			});
			return NIL;
		}
	}

	class SendBlockTo extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i Player cPlayer Sends the block at the specified coords to
		 * the specified player's client, as an UpdateBlock packet.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SendBlockTo is not yet implemented.");
			return NIL;
		}
	}

	class SetAreaBiome extends OneArgFunction {
		/**
		 * 
		 * Cuboid cCuboid Biome EMCSBiome boolean Sets the biome in the cuboid
		 * specified. Returns true if successful, false if any of the chunks were
		 * unloaded. The cuboid needn't be sorted.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetAreaBiome is not yet implemented.");
			return NIL;
		}
	}

	class SetBiomeAt extends OneArgFunction {
		/**
		 * 
		 * BlockX number BlockZ number Biome EMCSBiome boolean Sets the biome at the
		 * specified block coords. Returns true if successful, false otherwise.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetBiomeAt is not yet implemented.");
			return NIL;
		}
	}

	class SetBlock extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i BlockType number BlockMeta number Sets the block at the
		 * specified coords, replaces the block entities for the previous block type,
		 * creates a new block entity for the new block, if appropriate, and wakes up
		 * the simulators. This is the preferred way to set blocks, as opposed to
		 * FastSetBlock(), which is only to be used under special circumstances.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetBlock is not yet implemented.");
			return NIL;
		}
	}

	class SetBlockMeta extends OneArgFunction {
		/**
		 * 
		 * BlockCoords Vector3i BlockMeta number Sets the meta for the block at the
		 * specified coords. Any call to SetBlockMeta will not generate a simulator
		 * update (water, lava, redstone), consider using SetBlock instead.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetBlockMeta is not yet implemented.");
			return NIL;
		}
	}

	class SetChunkAlwaysTicked extends OneArgFunction {
		/**
		 * 
		 * ChunkX number ChunkZ number IsAlwaysTicked boolean Sets the chunk to always
		 * be ticked and loaded even when it doesn't contain any clients. IsAlwaysTicked
		 * set to true turns forced ticking on, set to false turns it off. Every call
		 * with 'true' should be paired with a later call with 'false', otherwise the
		 * ticking won't stop. Multiple actions can request ticking independently, the
		 * ticking will continue until the last call with 'false'.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetChunkAlwaysTicked is not yet implemented.");
			return NIL;
		}
	}

	class SetCommandBlockCommand extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i Command string boolean Sets the command to be executed in a
		 * command block at the specified coordinates. Returns if command was changed.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetCommandBlockCommand is not yet implemented.");
			return NIL;
		}
	}

	class SetCommandBlocksEnabled extends OneArgFunction {
		/**
		 * 
		 * AreEnabled boolean Sets whether command blocks should be enabled on the
		 * (entire) server.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetCommandBlocksEnabled is not yet implemented.");
			return NIL;
		}
	}

	class SetDaylightCycleEnabled extends OneArgFunction {
		/**
		 * 
		 * IsEnabled boolean Starts or stops the daylight cycle.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetDaylightCycleEnabled is not yet implemented.");
			return NIL;
		}
	}

	class SetLinkedEndWorldName extends OneArgFunction {
		/**
		 * 
		 * WorldName string Sets the name of the world that the end portal should link
		 * to.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetLinkedEndWorldName is not yet implemented.");
			return NIL;
		}
	}

	class SetLinkedNetherWorldName extends OneArgFunction {
		/**
		 * 
		 * WorldName string Sets the name of the world that the nether portal should
		 * link to.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetLinkedNetherWorldName is not yet implemented.");
			return NIL;
		}
	}

	class SetLinkedOverworldName extends OneArgFunction {
		/**
		 * 
		 * WorldName string Sets the name of the world that the nether portal should
		 * link to?
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetLinkedOverworldName is not yet implemented.");
			return NIL;
		}
	}

	class SetMaxNetherPortalHeight extends OneArgFunction {
		/**
		 * 
		 * Height number Sets the maximum height for a nether portal
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetMaxNetherPortalHeight is not yet implemented.");
			return NIL;
		}
	}

	class SetMaxNetherPortalWidth extends OneArgFunction {
		/**
		 * 
		 * Width number Sets the maximum width for a nether portal
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetMaxNetherPortalWidth is not yet implemented.");
			return NIL;
		}
	}

	class SetMaxViewDistance extends OneArgFunction {
		/**
		 * 
		 * MaxViewDistance number Sets the maximum viewdistance of the players in the
		 * world. This maximum takes precedence over each player's ViewDistance setting.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetMaxViewDistance is not yet implemented.");
			return NIL;
		}
	}

	class SetMinNetherPortalHeight extends OneArgFunction {
		/**
		 * 
		 * Height number Sets the minimum height for a nether portal
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetMinNetherPortalHeight is not yet implemented.");
			return NIL;
		}
	}

	class SetMinNetherPortalWidth extends OneArgFunction {
		/**
		 * 
		 * Width number Sets the minimum width for a nether portal
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetMinNetherPortalWidth is not yet implemented.");
			return NIL;
		}
	}

	class SetNextBlockToTick extends OneArgFunction {
		/**
		 * 
		 * BlockPosition Vector3i Requests that the specified block be ticked at the
		 * start of the next world tick. Only one block per chunk can be queued this
		 * way; a second call to the same chunk overwrites the previous call.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetNextBlockToTick is not yet implemented.");
			return NIL;
		}
	}

	class SetSavingEnabled extends OneArgFunction {
		/**
		 * 
		 * SavingEnabled boolean Sets whether saving chunk data is enabled. If disabled,
		 * dirty chunks will stay in memory forever, which may cause performance and
		 * stability issues.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetSavingEnabled is not yet implemented.");
			return NIL;
		}
	}

	class SetShouldUseChatPrefixes extends OneArgFunction {
		/**
		 * 
		 * ShouldUseChatPrefixes boolean Sets whether coloured chat prefixes such as
		 * [INFO] is used with the SendMessageXXX() or BroadcastChatXXX(), or simply the
		 * entire message is coloured in the respective colour.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetShouldUseChatPrefixes is not yet implemented.");
			return NIL;
		}
	}

	class SetSignLines extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i Line1 string Line2 string Line3 string Line4 string Player
		 * cPlayer Sets the sign text at the specified coords. The sign-updating hooks
		 * are called for the change. The Player parameter is used to indicate the
		 * player from whom the change has come, it may be nil.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetSignLines is not yet implemented.");
			return NIL;
		}
	}

	class SetSpawn extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i boolean Sets the default spawn at the specified coords.
		 * Returns false if the new spawn couldn't be stored in the INI file.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetSpawn is not yet implemented.");
			return NIL;
		}
	}

	class SetTNTShrapnelLevel extends OneArgFunction {
		/**
		 * 
		 * ShrapnelLevel eShrapnelLevel Sets the Shrapnel level of the world.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetTNTShrapnelLevel is not yet implemented.");
			return NIL;
		}
	}

	class SetTicksUntilWeatherChange extends OneArgFunction {
		/**
		 * 
		 * NumTicks number Sets the number of ticks after which the weather will be
		 * changed.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetTicksUntilWeatherChange is not yet implemented.");
			return NIL;
		}
	}

	class SetTimeOfDay extends TwoArgFunction {
		/**
		 * 
		 * TimeOfDayTicks number Sets the time of day, expressed as number of ticks past
		 * sunrise, in the range 0 .. 24000.
		 */
		@Override
		public LuaValue call(LuaValue world, LuaValue value) {
			instance.setTime(value.tolong());
			return NIL;
		}
	}

	class SetTrapdoorOpen extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i IsOpen boolean boolean Opens or closes a trapdoor at the
		 * specific coordinates. Returns true on success, false if there is no trapdoor
		 * or it's already in the requested state.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetTrapdoorOpen is not yet implemented.");
			return NIL;
		}
	}

	class SetWeather extends OneArgFunction {
		/**
		 * 
		 * Weather eWeather Sets the current weather (wSunny, wRain, wStorm) and resets
		 * the TicksUntilWeatherChange to the default value for the new weather. The
		 * normal weather-changing hooks are called for the change.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SetWeather is not yet implemented.");
			return NIL;
		}
	}

	class ShouldBroadcastAchievementMessages extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the server should broadcast achievement messages in
		 * this world.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ShouldBroadcastAchievementMessages is not yet implemented.");
			return NIL;
		}
	}

	class ShouldBroadcastDeathMessages extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the server should broadcast death messages in this
		 * world.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ShouldBroadcastDeathMessages is not yet implemented.");
			return NIL;
		}
	}

	class ShouldLavaSpawnFire extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if the world is configured to spawn fires near lava
		 * (world.ini: [Physics].ShouldLavaSpawnFire value)
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ShouldLavaSpawnFire is not yet implemented.");
			return NIL;
		}
	}

	class ShouldUseChatPrefixes extends OneArgFunction {
		/**
		 * 
		 * boolean Returns whether coloured chat prefixes are prepended to chat messages
		 * or the entire message is simply coloured.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("ShouldUseChatPrefixes is not yet implemented.");
			return NIL;
		}
	}

	class SpawnBoat extends OneArgFunction {
		/**
		 * 
		 * Position Vector3d Material eMaterial EntityID number Spawns a boat at the
		 * specific coordinates. Returns the EntityID of the new boat, or
		 * cEntity#INVALID_ID if no boat was created.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SpawnBoat is not yet implemented.");
			return NIL;
		}
	}

	class SpawnEnderCrystal extends OneArgFunction {
		/**
		 * 
		 * Position Vector3d ShowBottom boolean EntityID number Spawns an ender crystal
		 * at the specified coords. Returns the EntityID of the new ender crystal, or
		 * cEntity#INVALID_ID if no ender crystal was created.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SpawnEnderCrystal is not yet implemented.");
			return NIL;
		}
	}

	class SpawnExperienceOrb extends OneArgFunction {
		/**
		 * 
		 * Position Vector3d Reward number EntityID number Spawns an experience orb at
		 * the specified coords, with the given reward. Returns the EntityID of the new
		 * experience orb, or cEntity#INVALID_ID if no experience orb was created.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SpawnExperienceOrb is not yet implemented.");
			return NIL;
		}
	}

	class SpawnFallingBlock extends OneArgFunction {
		/**
		 * 
		 * BlockPosition Vector3i BlockType number BlockMeta number EntityID number
		 * Spawns a Falling Block entity in the middle of the specified block, with the
		 * given block type/meta. Returns the EntityID of the new falling block, or
		 * cEntity#INVALID_ID if no falling block was created.
		 * 
		 * Position Vector3d BlockType number BlockMeta number EntityID number Spawns a
		 * Falling Block entity at exactly the specified coords, with the given block
		 * type/meta. Returns the EntityID of the new falling block, or
		 * cEntity#INVALID_ID if no falling block was created.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SpawnFallingBlock is not yet implemented.");
			return NIL;
		}
	}

	class SpawnItemPickup extends OneArgFunction {
		/**
		 * 
		 * Position Vector3d Item cItem Speed Vector3d LifetimeTicks number CanCombine
		 * boolean EntityID number Creates a single pickup entity of the given item at
		 * the given position with the given speed, and returns the entities unique ID.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SpawnItemPickup is not yet implemented.");
			return NIL;
		}
	}

	class SpawnItemPickups extends OneArgFunction {
		/**
		 * 
		 * Pickups cItems Position Vector3d Speed Vector3d IsPlayerCreated boolean
		 * Spawns the specified pickups at the position specified. All the pickups fly
		 * away from the spawn position using the specified speed. The IsPlayerCreated
		 * parameter (default: false) is used to initialize the created cPickup object's
		 * IsPlayerCreated value.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SpawnItemPickups is not yet implemented.");
			return NIL;
		}
	}

	class SpawnMinecart extends OneArgFunction {
		/**
		 * 
		 * Position Vector3d MinecartType number Item cItem BlockHeight number EntityID
		 * number Spawns a minecart at the specific coordinates. MinecartType is the
		 * item type of the minecart. If the minecart is an empty minecart then the
		 * given Item (default: empty) is the block to be displayed inside the minecart,
		 * and BlockHeight (default: 1) is the relative distance of the block from the
		 * minecart. Returns the EntityID of the new minecart, or cEntity#INVALID_ID if
		 * no minecart was created.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SpawnMinecart is not yet implemented.");
			return NIL;
		}
	}

	class SpawnMob extends OneArgFunction {
		/**
		 * 
		 * Position Vector3d MonsterType eMonsterType IsBaby boolean EntityID number
		 * Spawns the specified type of mob at the specified coords. If the Baby
		 * parameter is true, the mob will be a baby. Returns the EntityID of the
		 * created entity, or cEntity#INVALID_ID on failure.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SpawnMob is not yet implemented.");
			return NIL;
		}
	}

	class SpawnPrimedTNT extends OneArgFunction {
		/**
		 * 
		 * Position Vector3d FuseTicks number InitialVelocityCoeff number
		 * ShouldPlayFuseSound boolean EntityID number Spawns a primed TNT entity at the
		 * specified coords, with the given fuse ticks. The entity gets a random speed
		 * multiplied by the InitialVelocityCoeff, 1 being the default value. Returns
		 * the EntityID of the new spawned primed tnt, or cEntity#INVALID_ID if no
		 * primed tnt was created.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SpawnPrimedTNT is not yet implemented.");
			return NIL;
		}
	}

	class SpawnSplitExperienceOrbs extends OneArgFunction {
		/**
		 * 
		 * Position Vector3d Reward number EntityID table Spawns experience orbs of the
		 * specified total value at the given location. The orbs' values are split
		 * according to regular Minecraft rules. Returns an array-table of UniqueID of
		 * all the orbs.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("SpawnSplitExperienceOrbs is not yet implemented.");
			return NIL;
		}
	}

	class TryGetHeight extends OneArgFunction {
		/**
		 * 
		 * BlockX number BlockZ number IsValid boolean Height number Returns true and
		 * height of the highest non-air block if the chunk is loaded, or false
		 * otherwise.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("TryGetHeight is not yet implemented.");
			return NIL;
		}
	}

	class UpdateSign extends OneArgFunction {
		/**
		 * 
		 * Position Vector3i Line1 string Line2 string Line3 string Line4 string Player
		 * cPlayer (DEPRECATED) Please use SetSignLines().
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("UpdateSign is not yet implemented.");
			return NIL;
		}
	}

	class UseBlockEntity extends OneArgFunction {
		/**
		 * 
		 * Player cPlayer Position Vector3i Makes the specified Player use the block
		 * entity at the specified coords (open chest UI, etc.) If the cords are in an
		 * unloaded chunk or there's no block entity, ignores the call.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("UseBlockEntity is not yet implemented.");
			return NIL;
		}
	}

	class VillagersShouldHarvestCrops extends OneArgFunction {
		/**
		 * 
		 * boolean Returns true if villagers can harvest crops.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("VillagersShouldHarvestCrops is not yet implemented.");
			return NIL;
		}
	}

	class WakeUpSimulators extends OneArgFunction {
		/**
		 * 
		 * Block Vector3i Wakes up the simulators for the specified block.
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("WakeUpSimulators is not yet implemented.");
			return NIL;
		}
	}

	class WakeUpSimulatorsInArea extends OneArgFunction {
		/**
		 * 
		 * Area cCuboid Wakes up the simulators for all the blocks in the specified area
		 * (edges inclusive).
		 * 
		 * 
		 * MinPosition Vector3i MaxPosition Vector3i Wakes up the simulators for all the
		 * blocks in the specified area (edges inclusive). (DEPRECATED, use
		 * vector-parametered version)
		 */
		@Override
		public LuaValue call(LuaValue world) {
			System.out.println("WakeUpSimulatorsInArea is not yet implemented.");
			return NIL;
		}
	}

	class ToString extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			String output = "cWorld(" + instance.getUniqueId() + ")";
			return LuaValue.valueOf(output);
		}
	}

	static class Concat extends TwoArgFunction {
		@Override
		public LuaValue call(LuaValue valueA, LuaValue valueB) {
			String stringA = valueA.tojstring();
			String stringB = valueB.tojstring();
			LuaValue functionA = valueA.getmetatable().get("__tostring");
			LuaValue functionB = valueB.getmetatable().get("__tostring");

			if (functionA.isfunction()) {
				stringA = functionA.call(valueA).tojstring();
			}

			if (functionB.isfunction()) {
				stringB = functionB.call(valueB).tojstring();
			}

			return LuaValue.valueOf(stringA.concat(stringB));
		}
	}

	/**
	 * Static Initialization
	 * 
	 * @param globals
	 */
	public cWorld(Globals globals) {

		luaValue = LuaValue.tableOf();

		globals.set("cWorld", luaValue);
	}

	/**
	 * Dynamic Initialization
	 * 
	 * @param somePlayer
	 */
	public cWorld(Instance someInstance) {
		instance = someInstance;

		// Check if player already exists
		if (instances.containsKey(someInstance)) {
			this.luaValue = instances.get(someInstance);
			return;
		}

		luaValue = LuaValue.tableOf();

		luaValue.set("AreCommandBlocksEnabled", new AreCommandBlocksEnabled());
		luaValue.set("BroadcastBlockAction", new BroadcastBlockAction());
		luaValue.set("BroadcastChat", new BroadcastChat());
		luaValue.set("BroadcastChatDeath", new BroadcastChatDeath());
		luaValue.set("BroadcastChatFailure", new BroadcastChatFailure());
		luaValue.set("BroadcastChatFatal", new BroadcastChatFatal());
		luaValue.set("BroadcastChatInfo", new BroadcastChatInfo());
		luaValue.set("BroadcastChatSuccess", new BroadcastChatSuccess());
		luaValue.set("BroadcastChatWarning", new BroadcastChatWarning());
		luaValue.set("BroadcastEntityAnimation", new BroadcastEntityAnimation());
		luaValue.set("BroadcastParticleEffect", new BroadcastParticleEffect());
		luaValue.set("BroadcastSoundEffect", new BroadcastSoundEffect());
		luaValue.set("BroadcastSoundParticleEffect", new BroadcastSoundParticleEffect());
		luaValue.set("CastThunderbolt", new CastThunderbolt());
		luaValue.set("ChangeWeather", new ChangeWeather());
		luaValue.set("ChunkStay", new ChunkStay());
		luaValue.set("CreateProjectile", new CreateProjectile());
		luaValue.set("DigBlock", new DigBlock());
		luaValue.set("DoExplosionAt", new DoExplosionAt());
		luaValue.set("DoWithBeaconAt", new DoWithBeaconAt());
		luaValue.set("DoWithBedAt", new DoWithBedAt());
		luaValue.set("DoWithBlockEntityAt", new DoWithBlockEntityAt());
		luaValue.set("DoWithBrewingstandAt", new DoWithBrewingstandAt());
		luaValue.set("DoWithChestAt", new DoWithChestAt());
		luaValue.set("DoWithCommandBlockAt", new DoWithCommandBlockAt());
		luaValue.set("DoWithDispenserAt", new DoWithDispenserAt());
		luaValue.set("DoWithDropSpenserAt", new DoWithDropSpenserAt());
		luaValue.set("DoWithDropperAt", new DoWithDropperAt());
		luaValue.set("DoWithEntityByID", new DoWithEntityByID());
		luaValue.set("DoWithFlowerPotAt", new DoWithFlowerPotAt());
		luaValue.set("DoWithFurnaceAt", new DoWithFurnaceAt());
		luaValue.set("DoWithHopperAt", new DoWithHopperAt());
		luaValue.set("DoWithMobHeadAt", new DoWithMobHeadAt());
		luaValue.set("DoWithNearestPlayer", new DoWithNearestPlayer());
		luaValue.set("DoWithNoteBlockAt", new DoWithNoteBlockAt());
		luaValue.set("DoWithPlayer", new DoWithPlayer());
		luaValue.set("DoWithPlayerByUUID", new DoWithPlayerByUUID());
		luaValue.set("DropBlockAsPickups", new DropBlockAsPickups());
		luaValue.set("FastSetBlock", new FastSetBlock());
		luaValue.set("FindAndDoWithPlayer", new FindAndDoWithPlayer());
		luaValue.set("ForEachBlockEntityInChunk", new ForEachBlockEntityInChunk());
		luaValue.set("ForEachBrewingstandInChunk", new ForEachBrewingstandInChunk());
		luaValue.set("ForEachChestInChunk", new ForEachChestInChunk());
		luaValue.set("ForEachEntity", new ForEachEntity());
		luaValue.set("ForEachEntityInBox", new ForEachEntityInBox());
		luaValue.set("ForEachEntityInChunk", new ForEachEntityInChunk());
		luaValue.set("ForEachFurnaceInChunk", new ForEachFurnaceInChunk());
		luaValue.set("ForEachLoadedChunk", new ForEachLoadedChunk());
		luaValue.set("ForEachPlayer", new ForEachPlayer());
		luaValue.set("GenerateChunk", new GenerateChunk());
		luaValue.set("GetBiomeAt", new GetBiomeAt());
		luaValue.set("GetBlock", new GetBlock());
		luaValue.set("GetBlockBlockLight", new GetBlockBlockLight());
		luaValue.set("GetBlockInfo", new GetBlockInfo());
		luaValue.set("GetBlockMeta", new GetBlockMeta());
		luaValue.set("GetBlockSkyLight", new GetBlockSkyLight());
		luaValue.set("GetBlockTypeMeta", new GetBlockTypeMeta());
		luaValue.set("GetDataPath", new GetDataPath());
		luaValue.set("GetDefaultWeatherInterval", new GetDefaultWeatherInterval());
		luaValue.set("GetDimension", new GetDimension());
		luaValue.set("GetGameMode", new GetGameMode());
		luaValue.set("GetGeneratorQueueLength", new GetGeneratorQueueLength());
		luaValue.set("GetHeight", new GetHeight());
		luaValue.set("GetIniFileName", new GetIniFileName());
		luaValue.set("GetLightingQueueLength", new GetLightingQueueLength());
		luaValue.set("GetLinkedEndWorldName", new GetLinkedEndWorldName());
		luaValue.set("GetLinkedNetherWorldName", new GetLinkedNetherWorldName());
		luaValue.set("GetLinkedOverworldName", new GetLinkedOverworldName());
		luaValue.set("GetMapManager", new GetMapManager());
		luaValue.set("GetMaxCactusHeight", new GetMaxCactusHeight());
		luaValue.set("GetMaxNetherPortalHeight", new GetMaxNetherPortalHeight());
		luaValue.set("GetMaxNetherPortalWidth", new GetMaxNetherPortalWidth());
		luaValue.set("GetMaxSugarcaneHeight", new GetMaxSugarcaneHeight());
		luaValue.set("GetMaxViewDistance", new GetMaxViewDistance());
		luaValue.set("GetMinNetherPortalHeight", new GetMinNetherPortalHeight());
		luaValue.set("GetMinNetherPortalWidth", new GetMinNetherPortalWidth());
		luaValue.set("GetName", new GetName());
		luaValue.set("GetNumChunks", new GetNumChunks());
		luaValue.set("GetNumUnusedDirtyChunks", new GetNumUnusedDirtyChunks());
		luaValue.set("GetScoreBoard", new GetScoreBoard());
		luaValue.set("GetSeed", new GetSeed());
		luaValue.set("GetSignLines", new GetSignLines());
		luaValue.set("GetSpawnX", new GetSpawnX());
		luaValue.set("GetSpawnY", new GetSpawnY());
		luaValue.set("GetSpawnZ", new GetSpawnZ());
		luaValue.set("GetStorageLoadQueueLength", new GetStorageLoadQueueLength());
		luaValue.set("GetStorageSaveQueueLength", new GetStorageSaveQueueLength());
		luaValue.set("GetTNTShrapnelLevel", new GetTNTShrapnelLevel());
		luaValue.set("GetTicksUntilWeatherChange", new GetTicksUntilWeatherChange());
		luaValue.set("GetTimeOfDay", new GetTimeOfDay());
		luaValue.set("GetUUID", new GetUUID());
		luaValue.set("GetWeather", new GetWeather());
		luaValue.set("GetWorldAge", new GetWorldAge());
		luaValue.set("GrowPlantAt", new GrowPlantAt());
		luaValue.set("GrowRipePlant", new GrowRipePlant());
		luaValue.set("GrowTree", new GrowTree());
		luaValue.set("GrowTreeByBiome", new GrowTreeByBiome());
		luaValue.set("GrowTreeFromSapling", new GrowTreeFromSapling());
		luaValue.set("IsBlockDirectlyWatered", new IsBlockDirectlyWatered());
		luaValue.set("IsDaylightCycleEnabled", new IsDaylightCycleEnabled());
		luaValue.set("IsDeepSnowEnabled", new IsDeepSnowEnabled());
		luaValue.set("IsGameModeAdventure", new IsGameModeAdventure());
		luaValue.set("IsGameModeCreative", new IsGameModeCreative());
		luaValue.set("IsGameModeSpectator", new IsGameModeSpectator());
		luaValue.set("IsGameModeSurvival", new IsGameModeSurvival());
		luaValue.set("IsPVPEnabled", new IsPVPEnabled());
		luaValue.set("IsTrapdoorOpen", new IsTrapdoorOpen());
		luaValue.set("IsWeatherRain", new IsWeatherRain());
		luaValue.set("IsWeatherRainAt", new IsWeatherRainAt());
		luaValue.set("IsWeatherStorm", new IsWeatherStorm());
		luaValue.set("IsWeatherStormAt", new IsWeatherStormAt());
		luaValue.set("IsWeatherSunny", new IsWeatherSunny());
		luaValue.set("IsWeatherSunnyAt", new IsWeatherSunnyAt());
		luaValue.set("IsWeatherWet", new IsWeatherWet());
		luaValue.set("IsWeatherWetAt", new IsWeatherWetAt());
		luaValue.set("IsWeatherWetAtXYZ", new IsWeatherWetAtXYZ());
		luaValue.set("PickupsFromBlock", new PickupsFromBlock());
		luaValue.set("PrepareChunk", new PrepareChunk());
		luaValue.set("QueueBlockForTick", new QueueBlockForTick());
		luaValue.set("QueueSaveAllChunks", new QueueSaveAllChunks());
		luaValue.set("QueueTask", new QueueTask());
		luaValue.set("QueueUnloadUnusedChunks", new QueueUnloadUnusedChunks());
		luaValue.set("RegenerateChunk", new RegenerateChunk());
		luaValue.set("ScheduleTask", new ScheduleTask());
		luaValue.set("SendBlockTo", new SendBlockTo());
		luaValue.set("SetAreaBiome", new SetAreaBiome());
		luaValue.set("SetBiomeAt", new SetBiomeAt());
		luaValue.set("SetBlock", new SetBlock());
		luaValue.set("SetBlockMeta", new SetBlockMeta());
		luaValue.set("SetChunkAlwaysTicked", new SetChunkAlwaysTicked());
		luaValue.set("SetCommandBlockCommand", new SetCommandBlockCommand());
		luaValue.set("SetCommandBlocksEnabled", new SetCommandBlocksEnabled());
		luaValue.set("SetDaylightCycleEnabled", new SetDaylightCycleEnabled());
		luaValue.set("SetLinkedEndWorldName", new SetLinkedEndWorldName());
		luaValue.set("SetLinkedNetherWorldName", new SetLinkedNetherWorldName());
		luaValue.set("SetLinkedOverworldName", new SetLinkedOverworldName());
		luaValue.set("SetMaxNetherPortalHeight", new SetMaxNetherPortalHeight());
		luaValue.set("SetMaxNetherPortalWidth", new SetMaxNetherPortalWidth());
		luaValue.set("SetMaxViewDistance", new SetMaxViewDistance());
		luaValue.set("SetMinNetherPortalHeight", new SetMinNetherPortalHeight());
		luaValue.set("SetMinNetherPortalWidth", new SetMinNetherPortalWidth());
		luaValue.set("SetNextBlockToTick", new SetNextBlockToTick());
		luaValue.set("SetSavingEnabled", new SetSavingEnabled());
		luaValue.set("SetShouldUseChatPrefixes", new SetShouldUseChatPrefixes());
		luaValue.set("SetSignLines", new SetSignLines());
		luaValue.set("SetSpawn", new SetSpawn());
		luaValue.set("SetTNTShrapnelLevel", new SetTNTShrapnelLevel());
		luaValue.set("SetTicksUntilWeatherChange", new SetTicksUntilWeatherChange());
		luaValue.set("SetTimeOfDay", new SetTimeOfDay());
		luaValue.set("SetTrapdoorOpen", new SetTrapdoorOpen());
		luaValue.set("SetWeather", new SetWeather());
		luaValue.set("ShouldBroadcastAchievementMessages", new ShouldBroadcastAchievementMessages());
		luaValue.set("ShouldBroadcastDeathMessages", new ShouldBroadcastDeathMessages());
		luaValue.set("ShouldLavaSpawnFire", new ShouldLavaSpawnFire());
		luaValue.set("ShouldUseChatPrefixes", new ShouldUseChatPrefixes());
		luaValue.set("SpawnBoat", new SpawnBoat());
		luaValue.set("SpawnEnderCrystal", new SpawnEnderCrystal());
		luaValue.set("SpawnExperienceOrb", new SpawnExperienceOrb());
		luaValue.set("SpawnFallingBlock", new SpawnFallingBlock());
		luaValue.set("SpawnItemPickup", new SpawnItemPickup());
		luaValue.set("SpawnItemPickups", new SpawnItemPickups());
		luaValue.set("SpawnMinecart", new SpawnMinecart());
		luaValue.set("SpawnMob", new SpawnMob());
		luaValue.set("SpawnPrimedTNT", new SpawnPrimedTNT());
		luaValue.set("SpawnSplitExperienceOrbs", new SpawnSplitExperienceOrbs());
		luaValue.set("TryGetHeight", new TryGetHeight());
		luaValue.set("UpdateSign", new UpdateSign());
		luaValue.set("UseBlockEntity", new UseBlockEntity());
		luaValue.set("VillagersShouldHarvestCrops", new VillagersShouldHarvestCrops());
		luaValue.set("WakeUpSimulators", new WakeUpSimulators());
		luaValue.set("WakeUpSimulatorsInArea", new WakeUpSimulatorsInArea());

		// metatable
		LuaValue metatable = LuaValue.tableOf();

		metatable.set("__tostring", new ToString());
		metatable.set("__concat", new Concat());

		luaValue.setmetatable(metatable);

		instances.put(someInstance, luaValue);
	}
}