package cuberite.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

import net.minestom.server.MinecraftServer;
import net.minestom.server.attribute.Attributes;
import net.minestom.server.entity.Entity;
import net.minestom.server.entity.EntityCreature;
import net.minestom.server.entity.EntityType;
import net.minestom.server.entity.LivingEntity;
import net.minestom.server.entity.Player;
import net.minestom.server.entity.damage.DamageType;
import net.minestom.server.utils.Position;

public class cEntity {

	private static Map<Entity, LuaTable> entities = new HashMap<Entity, LuaTable>();

	public LuaTable luaValue;

	private Entity entity;

	/**
	 * cEntity class A cEntity object represents an object in the world, it has a
	 * position and orientation. cEntity is an abstract class, and can not be
	 * instantiated directly, instead, all entities are implemented as subclasses.
	 * The cEntity class works as the common interface for the operations that all
	 * (most) entities support.
	 * 
	 * All cEntity objects have an Entity Type so it can be determined what kind of
	 * entity it is efficiently. Entities also have a class inheritance awareness,
	 * they know their class name, their parent class' name and can decide if there
	 * is a class within their inheritance chain. Since these functions operate on
	 * strings, they are slightly slower than checking the entity type directly, on
	 * the other hand, they are more specific directly. To check if the entity is a
	 * spider, you need to call IsMob(), then cast the object to cMonster and
	 * finally compare cMonster:GetMonsterType() to mtSpider. GetClass(), on the
	 * other hand, returns "cSpider" directly.
	 * 
	 * Note that you should not store a cEntity object between two hooks' calls,
	 * because Cuberite may despawn / remove that entity in between the calls. If
	 * you need to refer to an entity later, use its UniqueID and cWorld's entity
	 * manipulation functions DoWithEntityByID(), ForEachEntity() or
	 * ForEachEntityInChunk() to access the entity again.
	 */

	class AddPosX extends TwoArgFunction {
		/**
		 * OffsetX number Moves the entity by the specified amount in the X axis
		 * direction
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getPosition().add(value.tofloat(), 0, 0);
			return NIL;
		}
	}

	class AddPosY extends TwoArgFunction {
		/**
		 * OffsetY number Moves the entity by the specified amount in the Y axis
		 * direction
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getPosition().add(0, value.tofloat(), 0);
			return NIL;
		}
	}

	class AddPosZ extends TwoArgFunction {
		/**
		 * OffsetZ number Moves the entity by the specified amount in the Z axis
		 * direction
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getPosition().add(0, 0, value.tofloat());
			return NIL;
		}
	}

	class AddPosition extends TwoArgFunction {
		/**
		 * Offset Vector3d Moves the entity by the specified amount in each direction
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue vector) {
			entity.getPosition().add(new Vector3d(vector).toPosition());
			return NIL;
		}
	}

	class AddSpeed extends TwoArgFunction {
		/**
		 * Add Vector3d Adds the specified amount of speed in each axis direction.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue vector) {
			entity.getVelocity().add(new Vector3d(vector).toVector());
			return NIL;
		}
	}

	class AddSpeedX extends TwoArgFunction {
		/**
		 * AddX number Adds the specified amount of speed in the X axis direction.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getVelocity().add(value.tofloat(), 0, 0);
			return NIL;
		}
	}

	class AddSpeedY extends TwoArgFunction {
		/**
		 * AddY number Adds the specified amount of speed in the Y axis direction.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getVelocity().add(0, value.tofloat(), 0);
			return NIL;
		}
	}

	class AddSpeedZ extends TwoArgFunction {
		/**
		 * AddZ number Adds the specified amount of speed in the Z axis direction.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getVelocity().add(0, 0, value.tofloat());
			return NIL;
		}
	}

	class ApplyArmorDamage extends TwoArgFunction {
		/**
		 * DamageBlocked number Lowers armor durability, as if the armor blocked the
		 * given amount of damage.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("ApplyArmorDamage is not yet implemented.");
			return NIL;
		}
	}

	class ArmorCoversAgainst extends TwoArgFunction {
		/**
		 * DamageType eDamageType boolean Returns whether armor will protect against the
		 * specified damage type
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("ArmorCoversAgainst is not yet implemented.");
			return NIL;
		}
	}

	class Destroy extends TwoArgFunction {
		/**
		 * ShouldBroadcast (DEPRECATED) boolean Schedules the entity to be destroyed;
		 * broadcasts the DestroyEntity packet
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.remove();
			return NIL;
		}
	}

	class DoesPreventBlockPlacement extends TwoArgFunction {
		/**
		 * boolean Returns true if this entity doesn't allow blocks to be placed
		 * intersecting the entity.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("DoesPreventBlockPlacement is not yet implemented.");
			return NIL;
		}
	}

	class GetAirLevel extends TwoArgFunction {
		/**
		 * number Returns the air level (number of ticks of air left). Note, this
		 * function is only updated with mobs or players.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetAirLevel is not yet implemented.");
			return NIL;
		}
	}

	class GetArmorCoverAgainst extends TwoArgFunction {
		/**
		 * AttackerEntity cEntity DamageType eDamageType RawDamage number number Returns
		 * the number of hitpoints out of RawDamage that the currently equipped armor
		 * would cover. See TakeDamageInfo for more information on attack damage.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetArmorCoverAgainst is not yet implemented.");
			return NIL;
		}
	}

	class GetBoundingBox extends TwoArgFunction {
		/**
		 * cBoundingBox Returns the bounding box of the entity, which has width and
		 * height corresponding to the entity, and is aligned with the block grid.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			// TODO: cBoundingBox
			System.out.println("GetBoundingBox is not yet implemented.");
			return NIL;
		}
	}

	class GetChunkX extends TwoArgFunction {
		/**
		 * number Returns the X-coord of the chunk in which the entity is placed
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			valueOf(entity.getChunk().getChunkX());
			return NIL;
		}
	}

	class GetChunkZ extends TwoArgFunction {
		/**
		 * number Returns the Z-coord of the chunk in which the entity is placed
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			valueOf(entity.getChunk().getChunkZ());
			return NIL;
		}
	}

	class GetClass extends TwoArgFunction {
		/**
		 * string Returns the classname of the entity, such as "cSpider" or "cPickup"
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getClass().getSimpleName());
		}
	}

	static class GetClassStatic extends TwoArgFunction {
		/**
		 * string (STATIC) Returns the entity classname that this class implements. Each
		 * descendant overrides this function.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf("cEntity");
		}
	}

	class GetEnchantmentBlastKnockbackReduction extends TwoArgFunction {
		/**
		 * number Returns explosion knock back reduction percent from blast protection
		 * level.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetEnchantmentBlastKnockbackReduction is not yet implemented.");
			return NIL;
		}
	}

	class GetEnchantmentCoverAgainst extends TwoArgFunction {
		/**
		 * AttackerEntity cEntity DamageType eDamageType RawDamage number number Returns
		 * the number of hitpoints out of RawDamage that the enchantments on the
		 * currently equipped armor would cover. See TakeDamageInfo for more information
		 * on attack damage.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetEnchantmentCoverAgainst is not yet implemented.");
			return NIL;
		}
	}

	class GetEntityType extends TwoArgFunction {
		/**
		 * EntityType eEntityType Returns the type of the entity, one of the etXXX
		 * constants. Note that to check specific entity type, you should use one of the
		 * IsXXX functions instead of comparing the value returned by this call.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetEntityType is not yet implemented.");
			return NIL;
		}
	}

	class GetEquippedBoots extends TwoArgFunction {
		/**
		 * cItem Returns the boots that the entity has equipped. Returns an empty cItem
		 * if no boots equipped or not applicable.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			// TODO: cItem
			System.out.println("GetEquippedBoots is not yet implemented.");
			return NIL;
		}
	}

	class GetEquippedChestplate extends TwoArgFunction {
		/**
		 * cItem Returns the chestplate that the entity has equipped. Returns an empty
		 * cItem if no chestplate equipped or not applicable.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetEquippedChestplate is not yet implemented.");
			return NIL;
		}
	}

	class GetEquippedHelmet extends TwoArgFunction {
		/**
		 * cItem Returns the helmet that the entity has equipped. Returns an empty cItem
		 * if no helmet equipped or not applicable.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetEquippedHelmet is not yet implemented.");
			return NIL;
		}
	}

	class GetEquippedLeggings extends TwoArgFunction {
		/**
		 * cItem Returns the leggings that the entity has equipped. Returns an empty
		 * cItem if no leggings equipped or not applicable.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetEquippedLeggings is not yet implemented.");
			return NIL;
		}
	}

	class GetEquippedWeapon extends TwoArgFunction {
		/**
		 * cItem Returns the weapon that the entity has equipped. Returns an empty cItem
		 * if no weapon equipped or not applicable.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetEquippedWeapon is not yet implemented.");
			return NIL;
		}
	}

	class GetGravity extends TwoArgFunction {
		/**
		 * number Returns the number that is used as the gravity for physics simulation.
		 * 1G (9.78) by default.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(9.78);
		}
	}

	class GetHeadYaw extends TwoArgFunction {
		/**
		 * number Returns the pitch of the entity's head (FIXME: Rename to
		 * GetHeadPitch() ).
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getPosition().getPitch());
		}
	}

	class GetHealth extends TwoArgFunction {
		/**
		 * number Returns the current health of the entity.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			if (entity instanceof EntityCreature) {
				valueOf(((EntityCreature) entity).getHealth());
			}
			return NIL;
		}
	}

	class GetHeight extends TwoArgFunction {
		/**
		 * number Returns the height (Y size) of the entity
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getBoundingBox().getHeight());
		}
	}

	class GetInvulnerableTicks extends TwoArgFunction {
		/**
		 * number Returns the number of ticks that this entity will be invulnerable for.
		 * This is used for after-hit recovery - the entities are invulnerable for half
		 * a second after being hit.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetInvulnerableTicks is not yet implemented.");
			return NIL;
		}
	}

	class GetKnockbackAmountAgainst extends TwoArgFunction {
		/**
		 * ReceiverEntity cEntity number Returns the amount of knockback that the
		 * currently equipped items would cause when attacking the ReceiverEntity.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetKnockbackAmountAgainst is not yet implemented.");
			return NIL;
		}
	}

	class GetLookVector extends TwoArgFunction {
		/**
		 * Vector3f Returns the vector that defines the direction in which the entity is
		 * looking
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return new Vector3f(entity.getPosition().getDirection()).getLuaValue();
		}
	}

	class GetMass extends TwoArgFunction {
		/**
		 * number Returns the mass of the entity. Currently unused.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class GetMaxHealth extends TwoArgFunction {
		/**
		 * number Returns the maximum number of hitpoints this entity is allowed to
		 * have.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			if (entity instanceof EntityCreature) {
				valueOf(((EntityCreature) entity).getMaxHealth());
			}
			return NIL;
		}
	}

	class GetOffHandEquipedItem extends TwoArgFunction {
		/**
		 * cItem Returns the item that the entity has equipped on off-hand. Returns an
		 * empty cItem if no item equipped or not applicable.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetOffHandEquipedItem is not yet implemented.");
			return NIL;
		}
	}

	class GetParentClass extends TwoArgFunction {
		/**
		 * string Returns the name of the direct parent class or this entity
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetParentClass is not yet implemented.");
			return NIL;
		}
	}

	class GetPitch extends TwoArgFunction {
		/**
		 * number Returns the pitch (nose-down rotation) of the entity. Measured in
		 * degrees, normal values range from -90 to +90. +90 means looking down, 0 means
		 * looking straight ahead, -90 means looking up.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getPosition().getPitch());
		}
	}

	class GetPosX extends TwoArgFunction {
		/**
		 * number Returns the X-coord of the entity's pivot
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getPosition().getX());
		}
	}

	class GetPosY extends TwoArgFunction {
		/**
		 * number Returns the Y-coord of the entity's pivot
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getPosition().getY());
		}
	}

	class GetPosZ extends TwoArgFunction {
		/**
		 * number Returns the Z-coord of the entity's pivot
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getPosition().getZ());
		}
	}

	class GetPosition extends TwoArgFunction {
		/**
		 * Vector3d Returns the entity's pivot position as a 3D vector
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return new Vector3d(entity.getPosition()).getLuaValue();
		}
	}

	class GetRawDamageAgainst extends TwoArgFunction {
		/**
		 * ReceiverEntity cEntity number Returns the raw damage that this entity's
		 * equipment would cause when attacking the ReceiverEntity. This includes this
		 * entity's weapon enchantments, but excludes the receiver's armor or potion
		 * effects. See TakeDamageInfo for more information on attack damage.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetRawDamageAgainst is not yet implemented.");
			return NIL;
		}
	}

	class GetRoll extends TwoArgFunction {
		/**
		 * number Returns the roll (sideways rotation) of the entity. Currently unused.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class GetSpeed extends TwoArgFunction {
		/**
		 * Vector3d Returns the complete speed vector of the entity
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return new Vector3d(entity.getVelocity()).getLuaValue();
		}
	}

	class GetSpeedX extends TwoArgFunction {
		/**
		 * number Returns the X-part of the speed vector
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getVelocity().getX());
		}
	}

	class GetSpeedY extends TwoArgFunction {
		/**
		 * number Returns the Y-part of the speed vector
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getVelocity().getY());
		}
	}

	class GetSpeedZ extends TwoArgFunction {
		/**
		 * number Returns the Z-part of the speed vector
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getVelocity().getZ());
		}
	}

	class GetTicksAlive extends TwoArgFunction {
		/**
		 * number Returns the number of ticks that this entity has been alive for.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getAliveTicks());
		}
	}

	class GetUniqueID extends TwoArgFunction {
		/**
		 * number Returns the ID that uniquely identifies the entity within the running
		 * server. Note that this ID is not persisted to the data files.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityId());
		}
	}

	class GetWidth extends TwoArgFunction {
		/**
		 * number Returns the width (X and Z size) of the entity.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("GetWidth is not yet implemented.");
			return NIL;
		}
	}

	class GetWorld extends TwoArgFunction {
		/**
		 * cWorld Returns the world where the entity resides
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return new cWorld(entity.getInstance()).luaValue;
		}
	}

	class GetYaw extends TwoArgFunction {
		/**
		 * number Returns the yaw (direction) of the entity. Measured in degrees, values
		 * range from -180 to +180. 0 means ZP, 90 means XM, -180 means ZM, -90 means
		 * XP.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getPosition().getYaw());
		}
	}

	class HandleSpeedFromAttachee extends TwoArgFunction {
		/**
		 * ForwardAmount number SidewaysAmount number Updates the entity's speed based
		 * on the attachee exerting the specified force forward and sideways. Used for
		 * entities being driven by other entities attached to them - usually players
		 * driving minecarts and boats.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("HandleSpeedFromAttachee is not yet implemented.");
			return NIL;
		}
	}

	class Heal extends TwoArgFunction {
		/**
		 * Hitpoints number Heals the specified number of hitpoints. Hitpoints is
		 * expected to be a positive number.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			if (entity instanceof EntityCreature) {
				((EntityCreature) entity).setHealth(((EntityCreature) entity).getHealth() + value.tofloat());
			}
			return NIL;
		}
	}

	class IsA extends TwoArgFunction {
		/**
		 * ClassName string boolean Returns true if the entity class s a descendant of
		 * the specified class name, or the specified class itself
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("IsA is not yet implemented.");
			return NIL;
		}
	}

	class IsArrow extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is an arrow.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.ARROW);
		}
	}

	class IsBoat extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is a boat.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.BOAT);
		}
	}

	class IsCrouched extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is crouched. Always false for entities
		 * that don't support crouching.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			if (entity instanceof Player) {
				return valueOf(((Player) entity).isSneaking());
			}
			return FALSE;
		}
	}

	class IsEnderCrystal extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is an ender crystal.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.END_CRYSTAL);
		}
	}

	class IsExpOrb extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity represents an experience orb
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.EXPERIENCE_ORB);
		}
	}

	class IsFallingBlock extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity represents a cFallingBlock entity.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.FALLING_BLOCK);
		}
	}

	class IsFireproof extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity takes no damage from being on fire.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("IsFireproof is not yet implemented.");
			return NIL;
		}
	}

	class IsFloater extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity represents a fishing rod floater
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.FISHING_BOBBER);
		}
	}

	class IsHeadInWater extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity's head is in a water block
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class IsInFire extends TwoArgFunction {
		/**
		 * boolean Returns true if any part of the entity is in a fire block
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class IsInLava extends TwoArgFunction {
		/**
		 * boolean Returns true if any part of the entity is in a lava block
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class IsInWater extends TwoArgFunction {
		/**
		 * boolean Returns true if any part of the entity is in a water block
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class IsInvisible extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is invisible
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.isInvisible());
		}
	}

	class IsItemFrame extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is an item frame.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.ITEM_FRAME);
		}
	}

	class IsLeashKnot extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is a leash knot.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.LEASH_KNOT);
		}
	}

	class IsMinecart extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity represents a minecart
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.MINECART);
		}
	}

	class IsMob extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity represents any mob.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("IsMob is not yet implemented.");
			return NIL;
		}
	}

	class IsOnFire extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is on fire
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class IsOnGround extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is on ground (not falling, not jumping,
		 * not flying)
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class IsPainting extends TwoArgFunction {
		/**
		 * boolean Returns if this entity is a painting.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.PAINTING);
		}
	}

	class IsPawn extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is a cPawn descendant.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("IsPawn is not yet implemented.");
			return NIL;
		}
	}

	class IsPickup extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity represents a pickup.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.ITEM);
		}
	}

	class IsPlayer extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity represents a player
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.PLAYER);
		}
	}

	class IsProjectile extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is a cProjectileEntity descendant.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("IsProjectile is not yet implemented.");
			return NIL;
		}
	}

	class IsRiding extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is attached to (riding) another entity.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("IsRiding is not yet implemented.");
			return NIL;
		}
	}

	class IsSprinting extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is sprinting. Entities that cannot sprint
		 * return always false
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("IsSprinting is not yet implemented.");
			return NIL;
		}
	}

	class IsSubmerged extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity's head is in a water block Currently
		 * deprecated in favour of IsHeadInWater()
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("IsSubmerged is not yet implemented.");
			return NIL;
		}
	}

	class IsSwimming extends TwoArgFunction {
		/**
		 * boolean Returns true if any part of the entity is in a water block. Note,
		 * this function is only updated with mobs or players. Currently deprecated in
		 * favour of IsInWater()
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("IsSwimming is not yet implemented.");
			return NIL;
		}
	}

	class IsTNT extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity represents a TNT entity
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.getEntityType() == EntityType.TNT);
		}
	}

	class IsTicking extends TwoArgFunction {
		/**
		 * boolean Returns true if the entity is valid and ticking. Returns false if the
		 * entity is not ticking and is about to leave its current world either via
		 * teleportation or destruction. If this returns false, you must stop using the
		 * cEntity pointer you have.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return valueOf(entity.isActive());
		}
	}

	class Killed extends TwoArgFunction {
		/**
		 * Victim cEntity This entity has killed another entity (the Victim). For
		 * players, adds the scoreboard statistics about the kill.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("Killed is not yet implemented.");
			return NIL;
		}
	}

	class MoveToWorld extends VarArgFunction {
		/**
		 * World cWorld Position Vector3d ShouldSetPortalCooldown boolean
		 * ShouldSendRespawn boolean boolean Removes the entity from this world and
		 * starts moving it to the specified world. Note that to avoid deadlocks, the
		 * move is asynchronous - the entity is moved into a queue and will be moved
		 * from that queue into the destination world at some (unpredictable) time in
		 * the future. If ShouldSetPortalCooldown is false (default), doesn't set any
		 * portal cooldown, if it is true, the default portal cooldown is applied to the
		 * entity. ShouldSendRespawn is used only for players, it specifies whether the
		 * player should be sent a Respawn packet upon leaving the world (The client
		 * handles respawns only between different dimensions). The Position parameter
		 * specifies the location that the entity should be placed in, in the new world.
		 */
		public LuaValue call(LuaValue[] args) {

			MinecraftServer.getInstanceManager().getInstances().forEach((instance) -> {
				UUID uuid = UUID.fromString(args[1].get("GetUUID").call(args[1]).tojstring());
				if (instance.getUniqueId() == uuid) {
					entity.setInstance(instance);
					if (args[4].toboolean() && entity instanceof Player) {
						((Player) entity).respawn();
					}
					instance.scheduleNextTick((deltaInstance) -> {
						entity.teleport(new Vector3d(args[2]).toPosition());
					});
				}
			});

			return NIL;
		}
	}

	class ScheduleMoveToWorld extends VarArgFunction {
		/**
		 * World cWorld NewPosition Vector3d ShouldSetPortalCooldown boolean
		 * ShouldSendRespawn boolean Schedules a MoveToWorld call to occur on the next
		 * Tick of the entity. If ShouldSetPortalCooldown is false (default), doesn't
		 * set any portal cooldown, if it is true, the default portal cooldown is
		 * applied to the entity. If ShouldSendRespawn is false, no respawn packet is
		 * sent, if it is true (default) then a respawn packet is sent to the client.
		 * OBSOLETE, use MoveToWorld instead.
		 */
		public LuaValue call(LuaValue[] args) {

			MinecraftServer.getInstanceManager().getInstances().forEach((instance) -> {
				UUID uuid = UUID.fromString(args[1].get("GetUUID").call(args[1]).tojstring());
				if (instance.getUniqueId() == uuid) {
					entity.setInstance(instance);
					if (args[4].toboolean() && entity instanceof Player) {
						((Player) entity).respawn();
					}
					instance.scheduleNextTick((deltaInstance) -> {
						entity.teleport(new Vector3d(args[2]).toPosition());
					});
				}
			});

			return NIL;
		}
	}

	class SetGravity extends TwoArgFunction {
		/**
		 * Gravity number Sets the number that is used as the gravity for physics
		 * simulation. 1G (9.78) by default.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("SetGravity is not yet implemented.");
			return NIL;
		}
	}

	class SetHeadYaw extends TwoArgFunction {
		/**
		 * HeadPitch number Sets the head pitch (FIXME: Rename to SetHeadPitch() ).
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getPosition().setPitch(value.tofloat());
			return NIL;
		}
	}

	class SetHealth extends TwoArgFunction {
		/**
		 * Hitpoints number Sets the entity's health to the specified amount of
		 * hitpoints. Doesn't broadcast any hurt animation. Doesn't kill the entity if
		 * health drops below zero. Use the TakeDamage() function instead for taking
		 * damage.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			if (entity instanceof EntityCreature) {
				((EntityCreature) entity).setHealth(value.tofloat());
			}
			return NIL;
		}
	}

	class SetInvulnerableTicks extends TwoArgFunction {
		/**
		 * NumTicks number Sets the amount of ticks for which the entity will not
		 * receive any damage from other entities.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("SetInvulnerableTicks is not yet implemented.");
			return NIL;
		}
	}

	class SetIsFireproof extends TwoArgFunction {
		/**
		 * IsFireproof boolean Sets whether the entity receives damage from being on
		 * fire.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("SetIsFireproof is not yet implemented.");
			return NIL;
		}
	}

	class SetMass extends TwoArgFunction {
		/**
		 * Mass number Sets the mass of the entity. Currently unused.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class SetMaxHealth extends TwoArgFunction {
		/**
		 * MaxHitpoints number Sets the maximum hitpoints of the entity. If current
		 * health is above MaxHitpoints, it is capped to MaxHitpoints.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			if (entity instanceof EntityCreature) {
				((EntityCreature) entity).getAttribute(Attributes.MAX_HEALTH).setBaseValue(value.tofloat());
				;
			}
			return NIL;
		}
	}

	class SetPitch extends TwoArgFunction {
		/**
		 * Pitch number Sets the pitch (nose-down rotation) of the entity
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getPosition().setPitch(value.tofloat());
			return NIL;
		}
	}

	class SetPitchFromSpeed extends TwoArgFunction {
		/**
		 * Sets the entity pitch to match its speed (entity looking forwards as it
		 * moves)
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			// TODO: mafs
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class SetPosX extends TwoArgFunction {
		/**
		 * PosX number Sets the X-coord of the entity's pivot
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getPosition().setX(value.tofloat());
			return NIL;
		}
	}

	class SetPosY extends TwoArgFunction {
		/**
		 * PosY number Sets the Y-coord of the entity's pivot
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getPosition().setY(value.tofloat());
			return NIL;
		}
	}

	class SetPosZ extends TwoArgFunction {
		/**
		 * PosZ number Sets the Z-coord of the entity's pivot
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getPosition().setZ(value.tofloat());
			return NIL;
		}
	}

	class SetPosition extends TwoArgFunction {
		/**
		 * Vector3d Vector3d Sets all three coords of the entity's pivot
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue vector) {
			entity.getPosition().copyCoordinates(new Vector3d(vector).toPosition());
			return NIL;
		}
	}

	class SetRoll extends TwoArgFunction {
		/**
		 * Roll number Sets the roll (sideways rotation) of the entity. Currently
		 * unused.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			return NIL;
		}
	}

	class SetSpeed extends TwoArgFunction {
		/**
		 * Speed Vector3d Sets the current speed of the entity
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue vector) {
			entity.getVelocity().copyCoordinates(new Vector3d(vector).toVector());
			return NIL;
		}
	}

	class SetSpeedX extends TwoArgFunction {
		/**
		 * SpeedX number Sets the X component of the entity speed
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getVelocity().add(value.tofloat(), 0, 0);
			return NIL;
		}
	}

	class SetSpeedY extends TwoArgFunction {
		/**
		 * SpeedY number Sets the Y component of the entity speed
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getVelocity().add(0, value.tofloat(), 0);
			return NIL;
		}
	}

	class SetSpeedZ extends TwoArgFunction {
		/**
		 * SpeedZ number Sets the Z component of the entity speed
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getVelocity().add(0, 0, value.tofloat());
			return NIL;
		}
	}

	class SetYaw extends TwoArgFunction {
		/**
		 * Yaw number Sets the yaw (direction) of the entity.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			entity.getPosition().setYaw(value.tofloat());
			return NIL;
		}
	}

	class SetYawFromSpeed extends TwoArgFunction {
		/**
		 * Sets the entity's yaw to match its current speed (entity looking forwards as
		 * it moves).
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class StartBurning extends TwoArgFunction {
		/**
		 * NumTicks number Sets the entity on fire for the specified number of ticks. If
		 * entity is on fire already, makes it burn for either NumTicks or the number of
		 * ticks left from the previous fire, whichever is larger.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).setFireForDuration(value.toint());
			}
			return NIL;
		}
	}

	class SteerVehicle extends TwoArgFunction {
		/**
		 * ForwardAmount number SidewaysAmount number Applies the specified steering to
		 * the vehicle this entity is attached to. Ignored if not attached to any
		 * entity.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class StopBurning extends TwoArgFunction {
		/**
		 * Extinguishes the entity fire, cancels all fire timers.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue value) {
			System.out.println("This is not yet implemented.");
			return NIL;
		}
	}

	class TakeDamage extends VarArgFunction {
		/**
		 * DamageType eDamageType AttackerEntity cEntity RawDamage number FinalDamage
		 * number KnockbackAmount number Causes this entity to take damage of the
		 * specified type, from the specified attacker (may be nil). The values are
		 * wrapped into a TakeDamageInfo structure and applied directly.
		 */
		public LuaValue call(LuaValue[] args) {
			if (entity instanceof LivingEntity) {
				// TODO: eDamageType
				((LivingEntity) entity).damage(DamageType.VOID, args[5].tofloat());
			}
			return NIL;
		}
	}

	class TeleportToCoords extends TwoArgFunction {
		/**
		 * Vector3d vector Teleports the entity to the specified coords. Asks plugins if
		 * the teleport is allowed.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue vector) {
			// TODO: Call hook
			entity.teleport(new Vector3d(vector).toPosition());
			return NIL;
		}
	}

	class TeleportToEntity extends TwoArgFunction {
		/**
		 * DestEntity cEntity Teleports this entity to the specified destination entity.
		 * Asks plugins if the teleport is allowed.
		 */
		@Override
		public LuaValue call(LuaValue luaEntity, LuaValue destEntity) {
			UUID worldUuid = UUID.fromString(destEntity.get("GetWorld").call().get("GetUUID").call().tojstring());

			MinecraftServer.getInstanceManager().getInstances().forEach((instance) -> {
				if (worldUuid.equals(instance.getUniqueId())) {
					Position dest = Entity.getEntity(destEntity.get("GetUniqueID").call().toint()).getPosition();
					entity.setInstance(instance);
					// TODO: Call hook
					entity.teleport(dest);
				}
			});
			return NIL;
		}
	}

	class ToString extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue vector) {
			String output = "cEntity(" + entity.getEntityType().name() + ", ID: " + entity.getEntityId() + ")";
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
	public cEntity(Globals globals) {

		luaValue = LuaValue.tableOf();

		// Constants
		luaValue.set("etBoat", 7); // The entity is a cBoat
		luaValue.set("etEnderCrystal", 1); // The entity is a cEnderCrystal
		luaValue.set("etEntity", 0); // No further specialization available
		luaValue.set("etExpOrb", 10); // The entity is a cExpOrb
		luaValue.set("etFallingBlock", 5); // The entity is a cFallingBlock
		luaValue.set("etFloater", 11); // The entity is a fishing rod floater
		luaValue.set("etItemFrame", 12); // The entity is an item frame
		luaValue.set("etLeashKnot", 14); // The entity is a leash knot
		luaValue.set("etMinecart", 6); // The entity is a cMinecart descendant
		luaValue.set("etMob", 4); // The entity is a cMonster descendant
		luaValue.set("etMonster", 4); // The entity is a cMonster descendant
		luaValue.set("etPainting", 13); // The entity is a cPainting
		luaValue.set("etPickup", 3); // The entity is a cPickup
		luaValue.set("etPlayer", 2); // The entity is a cPlayer
		luaValue.set("etProjectile", 9); // The entity is a cProjectileEntity descendant
		luaValue.set("etTNT", 8); // The entity is a cTNTEntity

		globals.set("cEntity", luaValue);
	}

	/**
	 * Dynamic Initialization
	 * 
	 * @param someEntity
	 */
	public cEntity(Entity someEntity) {
		entity = someEntity;

		// Check if player already exists
		if (entities.containsKey(someEntity)) {
			this.luaValue = entities.get(someEntity);
			return;
		}

		luaValue = LuaValue.tableOf();

		luaValue.set("AddPosX", new AddPosX());
		luaValue.set("AddPosY", new AddPosY());
		luaValue.set("AddPosZ", new AddPosZ());
		luaValue.set("AddPosition", new AddPosition());
		luaValue.set("AddSpeed", new AddSpeed());
		luaValue.set("AddSpeedX", new AddSpeedX());
		luaValue.set("AddSpeedY", new AddSpeedY());
		luaValue.set("AddSpeedZ", new AddSpeedZ());
		luaValue.set("ApplyArmorDamage", new ApplyArmorDamage());
		luaValue.set("ArmorCoversAgainst", new ArmorCoversAgainst());
		luaValue.set("Destroy", new Destroy());
		luaValue.set("DoesPreventBlockPlacement", new DoesPreventBlockPlacement());
		luaValue.set("GetAirLevel", new GetAirLevel());
		luaValue.set("GetArmorCoverAgainst", new GetArmorCoverAgainst());
		luaValue.set("GetBoundingBox", new GetBoundingBox());
		luaValue.set("GetChunkX", new GetChunkX());
		luaValue.set("GetChunkZ", new GetChunkZ());
		luaValue.set("GetClass", new GetClass());
		luaValue.set("GetClassStatic", new GetClassStatic());
		luaValue.set("GetEnchantmentBlastKnockbackReduction", new GetEnchantmentBlastKnockbackReduction());
		luaValue.set("GetEnchantmentCoverAgainst", new GetEnchantmentCoverAgainst());
		luaValue.set("GetEntityType", new GetEntityType());
		luaValue.set("GetEquippedBoots", new GetEquippedBoots());
		luaValue.set("GetEquippedChestplate", new GetEquippedChestplate());
		luaValue.set("GetEquippedHelmet", new GetEquippedHelmet());
		luaValue.set("GetEquippedLeggings", new GetEquippedLeggings());
		luaValue.set("GetEquippedWeapon", new GetEquippedWeapon());
		luaValue.set("GetGravity", new GetGravity());
		luaValue.set("GetHeadYaw", new GetHeadYaw());
		luaValue.set("GetHealth", new GetHealth());
		luaValue.set("GetHeight", new GetHeight());
		luaValue.set("GetInvulnerableTicks", new GetInvulnerableTicks());
		luaValue.set("GetKnockbackAmountAgainst", new GetKnockbackAmountAgainst());
		luaValue.set("GetLookVector", new GetLookVector());
		luaValue.set("GetMass", new GetMass());
		luaValue.set("GetMaxHealth", new GetMaxHealth());
		luaValue.set("GetOffHandEquipedItem", new GetOffHandEquipedItem());
		luaValue.set("GetParentClass", new GetParentClass());
		luaValue.set("GetPitch", new GetPitch());
		luaValue.set("GetPosX", new GetPosX());
		luaValue.set("GetPosY", new GetPosY());
		luaValue.set("GetPosZ", new GetPosZ());
		luaValue.set("GetPosition", new GetPosition());
		luaValue.set("GetRawDamageAgainst", new GetRawDamageAgainst());
		luaValue.set("GetRoll", new GetRoll());
		luaValue.set("GetSpeed", new GetSpeed());
		luaValue.set("GetSpeedX", new GetSpeedX());
		luaValue.set("GetSpeedY", new GetSpeedY());
		luaValue.set("GetSpeedZ", new GetSpeedZ());
		luaValue.set("GetTicksAlive", new GetTicksAlive());
		luaValue.set("GetUniqueID", new GetUniqueID());
		luaValue.set("GetWidth", new GetWidth());
		luaValue.set("GetWorld", new GetWorld());
		luaValue.set("GetYaw", new GetYaw());
		luaValue.set("HandleSpeedFromAttachee", new HandleSpeedFromAttachee());
		luaValue.set("Heal", new Heal());
		luaValue.set("IsA", new IsA());
		luaValue.set("IsArrow", new IsArrow());
		luaValue.set("IsBoat", new IsBoat());
		luaValue.set("IsCrouched", new IsCrouched());
		luaValue.set("IsEnderCrystal", new IsEnderCrystal());
		luaValue.set("IsExpOrb", new IsExpOrb());
		luaValue.set("IsFallingBlock", new IsFallingBlock());
		luaValue.set("IsFireproof", new IsFireproof());
		luaValue.set("IsFloater", new IsFloater());
		luaValue.set("IsHeadInWater", new IsHeadInWater());
		luaValue.set("IsInFire", new IsInFire());
		luaValue.set("IsInLava", new IsInLava());
		luaValue.set("IsInWater", new IsInWater());
		luaValue.set("IsInvisible", new IsInvisible());
		luaValue.set("IsItemFrame", new IsItemFrame());
		luaValue.set("IsLeashKnot", new IsLeashKnot());
		luaValue.set("IsMinecart", new IsMinecart());
		luaValue.set("IsMob", new IsMob());
		luaValue.set("IsOnFire", new IsOnFire());
		luaValue.set("IsOnGround", new IsOnGround());
		luaValue.set("IsPainting", new IsPainting());
		luaValue.set("IsPawn", new IsPawn());
		luaValue.set("IsPickup", new IsPickup());
		luaValue.set("IsPlayer", new IsPlayer());
		luaValue.set("IsProjectile", new IsProjectile());
		luaValue.set("IsRiding", new IsRiding());
		luaValue.set("IsSprinting", new IsSprinting());
		luaValue.set("IsSubmerged", new IsSubmerged());
		luaValue.set("IsSwimming", new IsSwimming());
		luaValue.set("IsTNT", new IsTNT());
		luaValue.set("IsTicking", new IsTicking());
		luaValue.set("Killed", new Killed());
		luaValue.set("MoveToWorld", new MoveToWorld());
		luaValue.set("ScheduleMoveToWorld", new ScheduleMoveToWorld());
		luaValue.set("SetGravity", new SetGravity());
		luaValue.set("SetHeadYaw", new SetHeadYaw());
		luaValue.set("SetHealth", new SetHealth());
		luaValue.set("SetInvulnerableTicks", new SetInvulnerableTicks());
		luaValue.set("SetIsFireproof", new SetIsFireproof());
		luaValue.set("SetMass", new SetMass());
		luaValue.set("SetMaxHealth", new SetMaxHealth());
		luaValue.set("SetPitch", new SetPitch());
		luaValue.set("SetPitchFromSpeed", new SetPitchFromSpeed());
		luaValue.set("SetPosX", new SetPosX());
		luaValue.set("SetPosY", new SetPosY());
		luaValue.set("SetPosZ", new SetPosZ());
		luaValue.set("SetPosition", new SetPosition());
		luaValue.set("SetRoll", new SetRoll());
		luaValue.set("SetSpeed", new SetSpeed());
		luaValue.set("SetSpeedX", new SetSpeedX());
		luaValue.set("SetSpeedY", new SetSpeedY());
		luaValue.set("SetSpeedZ", new SetSpeedZ());
		luaValue.set("SetYaw", new SetYaw());
		luaValue.set("SetYawFromSpeed", new SetYawFromSpeed());
		luaValue.set("StartBurning", new StartBurning());
		luaValue.set("SteerVehicle", new SteerVehicle());
		luaValue.set("StopBurning", new StopBurning());
		luaValue.set("TakeDamage", new TakeDamage());
		luaValue.set("TeleportToCoords", new TeleportToCoords());
		luaValue.set("TeleportToEntity", new TeleportToEntity());

		// metatable
		LuaValue metatable = LuaValue.tableOf();

		metatable.set("__tostring", new ToString());
		metatable.set("__concat", new Concat());

		luaValue.setmetatable(metatable);

		entities.put(someEntity, luaValue);

	}

}