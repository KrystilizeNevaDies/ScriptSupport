package cuberite.api;

import java.util.HashMap;
import java.util.Map;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

import cuberite.utility.TextType;
import net.minestom.server.chat.ChatColor;
import net.minestom.server.chat.ColoredText;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.utils.Position;

public class cPlayer {

	private static Map<Player, LuaTable> players = new HashMap<Player, LuaTable>();

	public LuaTable luaValue;

	private Player player;

	/**
	 * cPlayer class This class describes a player in the server. cPlayer inherits
	 * all functions and members of cPawn. It handles all the aspects of the
	 * gameplay, such as hunger, sprinting, inventory etc.
	 * 
	 * Inheritance This class inherits from the following parent classes:
	 * 
	 * cPawn cEntity
	 */

	class AddFoodExhaustion extends TwoArgFunction {
		/**
		 * AddFoodExhaustion Exhaustionnumber Adds the specified number to the food
		 * exhaustion. Only positive numbers expected.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue number) {
			player.setFoodSaturation(player.getFoodSaturation() + number.tofloat());
			return NIL;
		}
	}

	class CalcLevelFromXp extends OneArgFunction {
		/**
		 * CalcLevelFromXp XPAmountnumber number (STATIC) Returns the level which is
		 * reached with the specified amount of XP. Inverse of XpForLevel().
		 */
		@Override
		public LuaValue call(LuaValue number) {
			float xp = number.tofloat();

			/**
			 * level^2 + 6 × level (at levels 0–16) 1, 6, 0 2.5, -40.5, 360 4.5, -162.5,
			 * 2220 2.5 × level^2 – 40.5 × level + 360 (at levels 17–31) 4.5 × level^2 –
			 * 162.5 × level + 2220 (at levels 32+)
			 */
			if (xp < 394) {
				return valueOf(Math.sqrt(xp + 9) - 3);
			} else if (xp < 1758) {
				return valueOf((Math.sqrt(40 * xp - 7839) + 81) / 10);
			} else {
				return valueOf((Math.sqrt(72 * xp - 54215) + 325) / 18);
			}
		}
	}

	class CanFly extends OneArgFunction {
		/**
		 * CanFly boolean Returns if the player is able to fly.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.isAllowFlying());
		}
	}

	class CanMobsTarget extends OneArgFunction {
		/**
		 * CanMobsTarget boolean Returns if the player can be targeted by mobs.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return LuaValue
					.valueOf(player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR);
		}
	}

	class CloseWindow extends TwoArgFunction {
		/**
		 * CloseWindow CanRefuseboolean Closes the currently open UI window. If
		 * CanRefuse is true (default), the window may refuse the closing.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue canRefuse) {
			// TODO: add window refusal
			player.closeInventory();
			return NIL;
		}
	}

	class CloseWindowIfID extends OneArgFunction {
		/**
		 * CloseWindowIfID WindowID number CanRefuse boolean Closes the currently open
		 * UI window if its ID matches the given ID. If CanRefuse is true (default), the
		 * window may refuse the closing.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			// TODO: cWindow
			System.out.println("cPlayer:CloseWindowIfID() is not yet implemented");
			return NIL;
		}
	}

	class DeltaExperience extends TwoArgFunction {
		/**
		 * DeltaExperience DeltaXP number Adds or removes XP from the current XP amount.
		 * Won't allow XP to go negative. Returns the new experience, -1 on error (XP
		 * overflow).
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue delta) {
			player.setExp(player.getExp() + delta.tofloat());
			return NIL;
		}
	}

	class Feed extends ThreeArgFunction {
		/**
		 * Feed AddFood number AddSaturation number boolean Tries to add the specified
		 * amounts to food level and food saturation level (only positive amounts
		 * expected). Returns true if player was hungry and the food was consumed, false
		 * if too satiated.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue food, LuaValue saturation) {
			player.setFood(player.getFood() + food.toint());
			player.setFoodSaturation(player.getFoodSaturation() + saturation.toint());
			return TRUE;
		}
	}

	class ForceSetSpeed extends TwoArgFunction {
		/**
		 * ForceSetSpeed DirectionVector3d Forces the player to move to the given
		 * direction.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue vector3d) {
			player.facePosition(Player.FacePoint.EYE, new Position().add(vector3d.get("x").tofloat(),
					vector3d.get("y").tofloat(), vector3d.get("z").tofloat()));
			return NIL;
		}
	}

	class Freeze extends TwoArgFunction {
		/**
		 * Freeze Location Vector3d Teleports the player to "Location" and prevents them
		 * from moving, locking them in place until unfreeze() is called
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue vector3d) {
			player.getData().set("isFrozen", true, Boolean.class);
			return NIL;
		}
	}

	class GetClientHandle extends OneArgFunction {
		/**
		 * GetClientHandle cClientHandle Returns the client handle representing the
		 * player's connection. May be nil (AI players).
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetClientHandle() is not yet implemented");
			return NIL;
		}
	}

	class GetColor extends OneArgFunction {
		/**
		 * GetColor string Returns the full color code to be used for this player's
		 * messages (based on their rank). Prefix player messages with this code.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetColor() is not yet implemented");
			return NIL;
		}
	}

	class GetCurrentXp extends OneArgFunction {
		/**
		 * GetCurrentXp number Returns the current amount of XP
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getExp());
		}
	}

	class GetCustomName extends OneArgFunction {
		/**
		 * GetCustomName string Returns the custom name of this player. If the player
		 * hasn't a custom name, it will return an empty string.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getCustomName().getMessage());
		}
	}

	class GetDraggingItem extends OneArgFunction {
		/**
		 * GetDraggingItem cItem Returns the item the player is dragging in a UI window.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetDraggingItem() is not yet implemented");
			return NIL;
		}
	}

	class GetEffectiveGameMode extends OneArgFunction {
		/**
		 * GetEffectiveGameMode GameModeeGameMode (OBSOLETE) Returns the current
		 * resolved game mode of the player. If the player is set to inherit the world's
		 * gamemode, returns that instead. See also GetGameMode() and IsGameModeXXX()
		 * functions. Note that this function is the same as GetGameMode(), use that
		 * function instead.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			switch (player.getGameMode()) {
			case ADVENTURE:
				return valueOf(eGameMode.eGameMode_Adventure);
			case CREATIVE:
				return valueOf(eGameMode.eGameMode_Creative);
			case SPECTATOR:
				return valueOf(eGameMode.eGameMode_Spectator);
			case SURVIVAL:
				return valueOf(eGameMode.eGameMode_Survival);
			default:
				return valueOf(eGameMode.gmNotSet);
			}
		}
	}

	class GetEquippedItem extends OneArgFunction {
		/**
		 * GetEquippedItem cItem Returns the item that the player is currently holding;
		 * empty item if holding nothing.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetEquippedItem() is not yet implemented");
			return NIL;
		}
	}

	class GetEyeHeight extends OneArgFunction {
		/**
		 * GetEyeHeight number Returns the height of the player's eyes, in absolute
		 * coords
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getEyeHeight());
		}
	}

	class GetEyePosition extends OneArgFunction {
		/**
		 * GetEyePosition EyePositionVectorVector3d Returns the position of the player's
		 * eyes, as a Vector3d
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			Position position = player.getPosition();
			return new Vector3d(position.getX(), player.getEyeHeight(), position.getZ()).getLuaValue();
		}
	}

	class GetFloaterID extends OneArgFunction {
		/**
		 * GetFloaterID number Returns the Entity ID of the fishing hook floater that
		 * belongs to the player. Returns -1 if no floater is associated with the
		 * player. Undefined behavior when the player has used multiple fishing rods
		 * simultanously.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetFloaterID() is not yet implemented");
			return NIL;
		}
	}

	class GetFlyingMaxSpeed extends OneArgFunction {
		/**
		 * GetFlyingMaxSpeed number Returns the maximum flying speed, relative to the
		 * default game flying speed. Defaults to 1, but plugins may modify it for
		 * faster or slower flying.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getFlyingSpeed());
		}
	}

	class GetFoodExhaustionLevel extends OneArgFunction {
		/**
		 * GetFoodExhaustionLevel number Returns the food exhaustion level
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetFoodExhaustionLevel() is not yet implemented");
			return NIL;
		}
	}

	class GetFoodLevel extends OneArgFunction {
		/**
		 * GetFoodLevel number Returns the food level (number of half-drumsticks
		 * on-screen)
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getFood());
		}
	}

	class GetFoodSaturationLevel extends OneArgFunction {
		/**
		 * GetFoodSaturationLevel number Returns the food saturation (overcharge of the
		 * food level, is depleted before food level)
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getFoodSaturation());
		}
	}

	class GetFoodTickTimer extends OneArgFunction {
		/**
		 * GetFoodTickTimer number Returns the number of ticks past the last food-based
		 * heal or damage action; when this timer reaches 80, a new heal / damage is
		 * applied.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetFoodTickTimer() is not yet implemented");
			return NIL;
		}
	}

	class GetGameMode extends OneArgFunction {
		/**
		 * GetGameMode GameModeeGameMode Returns the player's gamemode. The player may
		 * have their gamemode unassigned, in which case they inherit the gamemode from
		 * the current world.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			switch (player.getGameMode()) {
			case ADVENTURE:
				return valueOf(eGameMode.eGameMode_Adventure);
			case CREATIVE:
				return valueOf(eGameMode.eGameMode_Creative);
			case SPECTATOR:
				return valueOf(eGameMode.eGameMode_Spectator);
			case SURVIVAL:
				return valueOf(eGameMode.eGameMode_Survival);
			default:
				return valueOf(eGameMode.gmNotSet);
			}
		}
	}

	class GetIP extends OneArgFunction {
		/**
		 * GetIP string Returns the IP address of the player, if available. Returns an
		 * empty string if there's no IP to report.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getPlayerConnection().getRemoteAddress().toString());
		}
	}

	class GetInventory extends OneArgFunction {
		/**
		 * GetInventory InventorycInventory Returns the player's inventory
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetInventory() is not yet implemented");
			return NIL;
		}
	}

	class GetLastBedPos extends OneArgFunction {
		/**
		 * GetLastBedPos Vector3i Returns the position of the last bed the player has
		 * slept in, or the world's spawn if no such position was recorded.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetLastBedPos() is not yet implemented");
			return NIL;
		}
	}

	class GetMainHand extends OneArgFunction {
		/**
		 * GetMainHand eMainHand Returns the player's main hand.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetMainHand() is not yet implemented");
			return NIL;
		}
	}

	class GetMaxSpeed extends OneArgFunction {
		/**
		 * GetMaxSpeed number Returns the player's current maximum speed, relative to
		 * the game default speed. Takes into account the sprinting / flying status.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getWalkingSpeed());
		}
	}

	class GetName extends OneArgFunction {
		/**
		 * GetName string Returns the player's name
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getUsername());
		}
	}

	class GetNormalMaxSpeed extends OneArgFunction {
		/**
		 * GetNormalMaxSpeed number Returns the player's maximum walking speed, relative
		 * to the game default speed. Defaults to 1, but plugins may modify it for
		 * faster or slower walking.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetNormalMaxSpeed() is not yet implemented");
			return NIL;
		}
	}

	class GetPermissions extends OneArgFunction {
		/**
		 * GetPermissions table Returns an array-table of all permissions (strings) that
		 * the player has assigned to them through their rank.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetPermissions() is not yet implemented");
			return tableOf();
		}
	}

	class GetPlayerListName extends OneArgFunction {
		/**
		 * GetPlayerListName string Returns the name that is used in the playerlist.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getDisplayName().getMessage());
		}
	}

	class GetPrefix extends OneArgFunction {
		/**
		 * GetPrefix string Returns the prefix to player names for messages (based on
		 * their rank), may contain @ format codes.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetPrefix() is not yet implemented");
			return NIL;
		}
	}

	class GetRestrictions extends OneArgFunction {
		/**
		 * GetRestrictions table Returns an array-table of all the restrictions that the
		 * player has assigned to them.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetRestrictions() is not yet implemented");
			return NIL;
		}
	}

	class GetSkinParts extends OneArgFunction {
		/**
		 * GetSkinParts number Returns the player's current set of skin part flags. This
		 * is a bitwise OR of various eSkinPart constants. Note that HasSkinPart may be
		 * easier to use in most situations.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetSkinParts() is not yet implemented");
			return NIL;
		}
	}

	class GetSprintingMaxSpeed extends OneArgFunction {
		/**
		 * GetSprintingMaxSpeed number Returns the player's maximum sprinting speed,
		 * relative to the game default speed. Defaults to 1.3, but plugins may modify
		 * it for faster or slower sprinting.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetSprintingMaxSpeed() is not yet implemented");
			return NIL;
		}
	}

	class GetStance extends OneArgFunction {
		/**
		 * GetStance number Returns the player's stance (Y-pos of player's eyes)
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getEyeHeight());
		}
	}

	class GetSuffix extends OneArgFunction {
		/**
		 * GetSuffix string Returns the suffix to player names for messages (based on
		 * their rank), may contain @ format codes.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetSuffix() is not yet implemented");
			return NIL;
		}
	}

	class GetTeam extends OneArgFunction {
		/**
		 * GetTeam cTeam Returns the team that the player belongs to, or nil if none.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetTeam() is not yet implemented");
			return NIL;
		}
	}

	class GetThrowSpeed extends OneArgFunction {
		/**
		 * GetThrowSpeed SpeedCoeffnumber Vector3d Returns the speed vector for an
		 * object thrown with the specified speed coeff. Basically returns the
		 * normalized look vector multiplied by the coeff, with a slight random
		 * variation.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetThrowSpeed() is not yet implemented");
			return NIL;
		}
	}

	class GetThrowStartPos extends OneArgFunction {
		/**
		 * GetThrowStartPos Vector3d Returns the position where the projectiles should
		 * start when thrown by this player.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetThrowStartPos() is not yet implemented");
			return NIL;
		}
	}

	class GetUUID extends OneArgFunction {
		/**
		 * GetUUID string Returns the (short) UUID that the player is using. Could be
		 * empty string for players that don't have a Mojang account assigned to them
		 * (in the future, bots for example).
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getUuid().toString());
		}
	}

	class GetWindow extends OneArgFunction {
		/**
		 * GetWindow cWindow Returns the currently open UI window. If the player doesn't
		 * have any UI window open, returns the inventory window.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetWindow() is not yet implemented");
			return NIL;
		}
	}

	class GetXpLevel extends OneArgFunction {
		/**
		 * GetXpLevel number Returns the current XP level (based on current XP amount).
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getLevel());
		}
	}

	class GetXpLifetimeTotal extends OneArgFunction {
		/**
		 * GetXpLifetimeTotal number Returns the amount of XP that has been accumulated
		 * throughout the player's lifetime.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetXpLifetimeTotal() is not yet implemented");
			return NIL;
		}
	}

	class GetXpPercentage extends OneArgFunction {
		/**
		 * GetXpPercentage number Returns the percentage of the experience bar - the
		 * amount of XP towards the next XP level. Between 0 and 1.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:GetXpPercentage() is not yet implemented");
			return NIL;
		}
	}

	class HasCustomName extends OneArgFunction {
		/**
		 * HasCustomName boolean Returns true if the player has a custom name.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.isCustomNameVisible());
		}
	}

	class HasPermission extends OneArgFunction {
		/**
		 * HasPermission PermissionStringstring boolean Returns true if the player has
		 * the specified permission
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:HasPermission() is not yet implemented");
			return NIL;
		}
	}

	class HasSkinPart extends OneArgFunction {
		/**
		 * HasSkinPart ParteSkinPart boolean Returns true if the player has the
		 * specified skin part enabled
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:HasSkinPart() is not yet implemented");
			return NIL;
		}
	}

	class Heal extends TwoArgFunction {
		/**
		 * Heal HitPointsnumber Heals the player by the specified amount of HPs. Only
		 * positive amounts are expected. Sends a health update to the client.
		 * 
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue number) {
			player.setHealth(player.getHealth() + number.tofloat());
			return NIL;
		}
	}

	class IsEating extends OneArgFunction {
		/**
		 * IsEating boolean Returns true if the player is currently eating the item in
		 * their hand.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.isEating());
		}
	}

	class IsFireproof extends OneArgFunction {
		/**
		 * IsFireproof boolean Returns true if a player is fireproof. This is when the
		 * flag has been explicitly set, or the player is in creative or spectator mode.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:IsFireproof() is not yet implemented");
			return NIL;
		}
	}

	class IsFishing extends OneArgFunction {
		/**
		 * IsFishing boolean Returns true if the player is currently fishing
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:IsFishing() is not yet implemented");
			return NIL;
		}
	}

	class IsFlying extends OneArgFunction {
		/**
		 * IsFlying boolean Returns true if the player is flying.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.isFlying());
		}
	}

	class IsFrozen extends OneArgFunction {
		/**
		 * IsFrozen boolean Returns true if the player is frozen. See Freeze()
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:IsFrozen() is not yet implemented");
			return NIL;
		}
	}

	class IsGameModeAdventure extends OneArgFunction {
		/**
		 * IsGameModeAdventure boolean Returns true if the player is in the gmAdventure
		 * gamemode, or has their gamemode unset and the world is a gmAdventure world.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getGameMode() == GameMode.ADVENTURE);
		}
	}

	class IsGameModeCreative extends OneArgFunction {
		/**
		 * IsGameModeCreative boolean Returns true if the player is in the gmCreative
		 * gamemode, or has their gamemode unset and the world is a gmCreative world.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getGameMode() == GameMode.CREATIVE);
		}
	}

	class IsGameModeSpectator extends OneArgFunction {
		/**
		 * IsGameModeSpectator boolean Returns true if the player is in the gmSpectator
		 * gamemode, or has their gamemode unset and the world is a gmSpectator world.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getGameMode() == GameMode.SPECTATOR);
		}
	}

	class IsGameModeSurvival extends OneArgFunction {
		/**
		 * IsGameModeSurvival boolean Returns true if the player is in the gmSurvival
		 * gamemode, or has their gamemode unset and the world is a gmSurvival world.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getGameMode() == GameMode.SURVIVAL);
		}
	}

	class IsInBed extends OneArgFunction {
		/**
		 * IsInBed boolean Returns true if the player is currently lying in a bed.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:IsInBed() is not yet implemented");
			return NIL;
		}
	}

	class IsSatiated extends OneArgFunction {
		/**
		 * IsSatiated boolean Returns true if the player is satiated (cannot eat).
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(player.getFoodSaturation() >= 20);
		}
	}

	class IsVisible extends OneArgFunction {
		/**
		 * IsVisible boolean Returns true if the player is visible to other players
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			return valueOf(!player.isInvisible());
		}
	}

	class LoadRank extends OneArgFunction {
		/**
		 * LoadRank Reloads the player's rank, message visuals and permissions from the
		 * cRankManager, based on the player's current rank.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:LoadRank() is not yet implemented");
			return NIL;
		}
	}

	class OpenWindow extends OneArgFunction {
		/**
		 * OpenWindow WindowcWindow Opens the specified UI window for the player.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:OpenWindow() is not yet implemented");
			return NIL;
		}
	}

	class PermissionMatches extends OneArgFunction {
		/**
		 * PermissionMatches Permissionstring Templatestring boolean (STATIC) Returns
		 * true if the specified permission matches the specified template. The template
		 * may contain asterisk as a wildcard for any word.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:PermissionMatches() is not yet implemented");
			return NIL;
		}
	}

	class PlaceBlock extends OneArgFunction {
		/**
		 * PlaceBlock BlockXnumber BlockYnumber BlockZnumber BlockTypenumber
		 * BlockMetanumber boolean Places a block while impersonating the player. The
		 * HOOK_PLAYER_PLACING_BLOCK hook is called before the placement, and if it
		 * succeeds, the block is placed and the HOOK_PLAYER_PLACED_BLOCK hook is
		 * called. Returns true iff the block is successfully placed. Assumes that the
		 * block is in a currently loaded chunk.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:PlaceBlock() is not yet implemented");
			return NIL;
		}
	}

	class ReplaceOneEquippedItemTossRest extends OneArgFunction {
		/**
		 * ReplaceOneEquippedItemTossRest Item cItem Removes one item from the the
		 * current equipped item stack, and attempts to add the specified item stack
		 * back to the same slot. If it is not possible to place the item in the same
		 * slot, tries to place the specified item elsewhere in the inventory. If this
		 * is not possible, then any remaining items are tossed. If the currently
		 * equipped slot is empty, its contents are simply set to the given Item.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:ReplaceOneEquippedItemTossRest() is not yet implemented");
			return NIL;
		}
	}

	class Respawn extends OneArgFunction {
		/**
		 * Respawn Restores the health, extinguishes fire, makes visible and sends the
		 * Respawn packet.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			player.heal();
			player.setOnFire(false);
			player.setInvisible(false);
			player.respawn();
			return NIL;
		}
	}

	class SendAboveActionBarMessage extends TwoArgFunction {
		/**
		 * SendAboveActionBarMessage Message string Sends the specified message to the
		 * player (shows above action bar).
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			player.sendActionBarMessage(ColoredText.of(value.tojstring()));
			return NIL;
		}
	}

	class SendBlocksAround extends OneArgFunction {
		/**
		 * SendBlocksAround BlockXnumber BlockYnumber BlockZnumber BlockRangenumber
		 * Sends all the world's blocks in BlockRange from the specified coords to the
		 * player, as a BlockChange packet. Range defaults to 1 (only one block sent).
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:SendBlocksAround() is not yet implemented");
			return NIL;
		}
	}

	class SendMessage extends TwoArgFunction {
		/**
		 * SendMessage Messagestring Sends the specified message to the player.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			player.sendMessage(value.tojstring());
			return NIL;
		}
	}

	class SendMessageFailure extends TwoArgFunction {
		/**
		 * SendMessageFailure Messagestring Prepends Rose [INFO] / colours entire text
		 * (depending on ShouldUseChatPrefixes()) and sends message to player. For a
		 * command that failed to run because of insufficient permissions, etc.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			player.sendMessage(TextType.FAILURE.create(value));
			return NIL;
		}
	}

	class SendMessageFatal extends TwoArgFunction {
		/**
		 * SendMessageFatal Message string Prepends Red [FATAL] / colours entire text
		 * (depending on ShouldUseChatPrefixes()) and sends message to player. For
		 * something serious, such as a plugin crash, etc.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			player.sendMessage(TextType.FATAL.create(value));
			return NIL;
		}
	}

	class SendMessageInfo extends TwoArgFunction {
		/**
		 * SendMessageInfo Messagestring Prepends Yellow [INFO] / colours entire text
		 * (depending on ShouldUseChatPrefixes()) and sends message to player.
		 * Informational message, such as command usage, etc.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			player.sendMessage(TextType.INFO.create(value));
			return NIL;
		}
	}

	class SendMessagePrivateMsg extends ThreeArgFunction {
		/**
		 * SendMessagePrivateMsg Message string SenderName string Prepends Light Blue
		 * [MSG: *SenderName*] / prepends SenderName and colours entire text (depending
		 * on ShouldUseChatPrefixes()) and sends message to player. For private
		 * messaging.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue string, LuaValue sender) {
			player.sendMessage(
					ColoredText.of(ChatColor.BLUE, "[" + string.tojstring() + "] -> [You]: " + sender.tojstring()));
			return NIL;
		}
	}

	class SendMessageRaw extends TwoArgFunction {
		/**
		 * SendMessageRaw Jsonstring eChatType number Sends the specified json string to
		 * the player. The optional value eChatType (default ctChatBox) can be
		 * ctChatBox, ctSystem or ctAboveActionBar. You can use cJson to build a json
		 * string.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			System.out.println("cPlayer:SendMessageRaw() is not yet implemented");
			return NIL;
		}
	}

	class SendMessageSuccess extends TwoArgFunction {
		/**
		 * SendMessageSuccess Messagestring Prepends Green [INFO] / colours entire text
		 * (depending on ShouldUseChatPrefixes()) and sends message to player. Success
		 * notification.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			player.sendMessage(TextType.SUCCESS.create(value));
			return NIL;
		}
	}

	class SendMessageWarning extends TwoArgFunction {
		/**
		 * SendMessageWarning Messagestring Prepends Rose [WARN] / colours entire text
		 * (depending on ShouldUseChatPrefixes()) and sends message to player. Denotes
		 * that something concerning, such as plugin reload, is about to happen.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			player.sendMessage(TextType.WARNING.create(value));
			return NIL;
		}
	}

	class SendRotation extends ThreeArgFunction {
		/**
		 * SendRotation YawDegreesnumber PitchDegreesnumber Sends the specified rotation
		 * to the player, forcing them to look that way
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue yaw, LuaValue pitch) {
			player.getPosition().setYaw(yaw.tofloat());
			player.getPosition().setPitch(pitch.tofloat());
			return NIL;
		}
	}

	class SendSystemMessage extends TwoArgFunction {
		/**
		 * SendSystemMessage Messagestring Sends the specified message to the player.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			player.sendMessage(TextType.SYSTEM.create(value));
			return NIL;
		}
	}

	class SetBedPos extends OneArgFunction {
		/**
		 * SetBedPos PositionVector3i WorldcWorld Sets the position and world of the
		 * player's respawn point, which is also known as the bed position. The player
		 * will respawn at this position and world upon death. If the world is not
		 * specified, it is set to the player's current world.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:SetBedPos() is not yet implemented");
			return NIL;
		}
	}

	class SetCanFly extends TwoArgFunction {
		/**
		 * SetCanFly CanFlyboolean Sets if the player can fly or not.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue bool) {
			player.setAllowFlying(bool.toboolean());
			return NIL;
		}
	}

	class SetCrouch extends TwoArgFunction {
		/**
		 * SetCrouch IsCrouchedboolean Sets the crouch state, broadcasts the change to
		 * other players.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue bool) {
			player.setSneaking(bool.toboolean());
			return NIL;
		}
	}

	class SetCurrentExperience extends TwoArgFunction {
		/**
		 * SetCurrentExperience XPAmountnumber boolean Sets the current amount of
		 * experience (and indirectly, the XP level).
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue number) {
			player.setExp(number.tofloat());
			return NIL;
		}
	}

	class SetCustomName extends TwoArgFunction {
		/**
		 * SetCustomName CustomNamestring Sets the custom name for this player. If you
		 * want to disable the custom name, simply set an empty string. The custom name
		 * will be used in the tab-list, in the player nametag and in the
		 * tab-completion.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue name) {
			player.setCustomName(ColoredText.of(name.tojstring()));
			return NIL;
		}
	}

	class SetDraggingItem extends OneArgFunction {
		/**
		 * SetDraggingItem ItemcItem Sets the item that the player is dragging in a UI
		 * window. If no UI window is open, this function does nothing.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:SetDraggingItem() is not yet implemented");
			return NIL;
		}
	}

	class SetFlying extends TwoArgFunction {
		/**
		 * SetFlying IsFlyingboolean Sets if the player is flying or not.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			player.setFlying(value.toboolean());
			return NIL;
		}
	}

	class SetFlyingMaxSpeed extends TwoArgFunction {
		/**
		 * SetFlyingMaxSpeed FlyingMaxSpeednumber Sets the flying maximum speed,
		 * relative to the game default speed. The default value is 1. Sends the updated
		 * speed to the client.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue flyingSpeed) {
			player.setFlyingSpeed(flyingSpeed.tofloat());
			return NIL;
		}
	}

	class SetFoodExhaustionLevel extends OneArgFunction {
		/**
		 * SetFoodExhaustionLevel ExhaustionLevelnumber Sets the food exhaustion to the
		 * specified level.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:SetFoodExhaustionLevel() is not yet implemented");
			return NIL;
		}
	}

	class SetFoodLevel extends TwoArgFunction {
		/**
		 * SetFoodLevel FoodLevelnumber Sets the food level (number of half-drumsticks
		 * on-screen)
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			player.setFood(value.toint());
			return NIL;
		}
	}

	class SetFoodSaturationLevel extends TwoArgFunction {
		/**
		 * SetFoodSaturationLevel FoodSaturationLevelnumber Sets the food saturation
		 * (overcharge of the food level).
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue value) {
			player.setFoodSaturation(value.toint());
			return NIL;
		}
	}

	class SetFoodTickTimer extends OneArgFunction {
		/**
		 * SetFoodTickTimer FoodTickTimernumber Sets the number of ticks past the last
		 * food-based heal or damage action; when this timer reaches 80, a new heal /
		 * damage is applied.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:SetFoodTickTimer() is not yet implemented");
			return NIL;
		}
	}

	class SetGameMode extends TwoArgFunction {
		/**
		 * SetGameMode NewGameMode eGameMode Sets the gamemode for the player. The new
		 * gamemode overrides the world's default gamemode, unless it is set to
		 * gmInherit.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue gamemode) {

			switch (gamemode.toint()) {
			case eGameMode.eGameMode_Adventure:
				player.setGameMode(GameMode.ADVENTURE);
				break;
			case eGameMode.eGameMode_Creative:
				player.setGameMode(GameMode.CREATIVE);
				break;
			case eGameMode.eGameMode_Survival:
				player.setGameMode(GameMode.SURVIVAL);
				break;
			case eGameMode.eGameMode_Spectator:
				player.setGameMode(GameMode.SPECTATOR);
				break;
			default:
				return FALSE;
			}
			return TRUE;
		}
	}

	class SetIsFishing extends OneArgFunction {
		/**
		 * SetIsFishing IsFishingboolean FloaterEntityIDnumber Sets the 'IsFishing' flag
		 * for the player. The floater entity ID is expected for the true variant, it
		 * can be omitted when IsFishing is false. Undefined behavior when multiple
		 * fishing rods are used simultanously
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:SetIsFishing() is not yet implemented");
			return NIL;
		}
	}

	class SetMainHand extends OneArgFunction {
		/**
		 * SetMainHand HandeMainHand Sets the main hand of the player. SetName
		 * Namestring Sets the player name. This rename will NOT be visible to any
		 * players already in the server who are close enough to see this player.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:SetMainHand() is not yet implemented");
			return NIL;
		}
	}

	class SetNormalMaxSpeed extends TwoArgFunction {
		/**
		 * SetNormalMaxSpeed NormalMaxSpeednumber Sets the normal (walking) maximum
		 * speed, relative to the game default speed. The default value is 1. Sends the
		 * updated speed to the client, if appropriate.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue speed) {
			player.setWalkingSpeed(speed.tofloat());
			return NIL;
		}
	}

	class SetSkinParts extends OneArgFunction {
		/**
		 * SetSkinParts Partsnumber Sets the skin part flags of the player. The value
		 * should be a bitwise OR of several eSkinPart constants.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:SetSkinParts() is not yet implemented");
			return NIL;
		}
	}

	class SetSprint extends TwoArgFunction {
		/**
		 * SetSprint IsSprintingboolean Sets whether the player is sprinting or not.
		 * SetSprintingMaxSpeed SprintingMaxSpeednumber Sets the sprinting maximum
		 * speed, relative to the game default speed. The default value is 1.3. Sends
		 * the updated speed to the client, if appropriate.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue sprinting) {
			player.setSprinting(sprinting.toboolean());
			return NIL;
		}
	}

	class SetTeam extends OneArgFunction {
		/**
		 * SetTeam TeamcTeam Moves the player to the specified team.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:SetTeam() is not yet implemented");
			return NIL;
		}
	}

	class SetVisible extends TwoArgFunction {
		/**
		 * SetVisible IsVisible boolean Sets the player visibility to other players
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue bool) {
			player.setInvisible(!bool.toboolean());
			return NIL;
		}
	}

	class SpectateEntity extends OneArgFunction {
		/**
		 * SpectateEntity TargetcEntity Spectates the target entity. Does not change the
		 * player's gamemode to spectator mode. When called with self or nil as the
		 * target, resets the spectation.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:SpectateEntity() is not yet implemented");
			return NIL;
		}
	}

	class TossEquippedItem extends TwoArgFunction {
		/**
		 * TossEquippedItem Amountnumber Tosses the item that the player has selected in
		 * their hotbar. Amount defaults to 1.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer, LuaValue amount) {
			// TODO: Item dropping
			player.getItemInMainHand().consume(amount.toint());
			return NIL;
		}
	}

	class TossHeldItem extends OneArgFunction {
		/**
		 * TossHeldItem Amountnumber Tosses the item held by the cursor, when the player
		 * is in a UI window. Amount defaults to 1.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:TossHeldItem() is not yet implemented");
			return NIL;
		}
	}

	class TossPickup extends OneArgFunction {
		/**
		 * TossPickup ItemcItem Tosses a pickup newly created from the specified item.
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println("cPlayer:TossPickup() is not yet implemented");
			return NIL;
		}
	}

	class Unfreeze extends OneArgFunction {
		/**
		 * UnfreezeAllows the player to move again, canceling the effects of Freeze()
		 */
		@Override
		public LuaValue call(LuaValue luaPlayer) {
			System.out.println(
					"cPlayer:UnfreezeAllows the player to move again, canceling the effects of Freeze()() is not yet implemented");
			return NIL;
		}
	}

	class XpForLevel extends OneArgFunction {
		/**
		 * XpForLevel XPLevelnumber number (STATIC) Returns the total amount of XP
		 * needed for the specified XP level. Inverse of CalcLevelFromXp().
		 */
		@Override
		public LuaValue call(LuaValue XPLevelnumber) {
			float level = XPLevelnumber.tofloat();

			if (level < 17) {
				return valueOf(Math.pow(level, 2.0) + (6.0 * level));
			} else if (level < 32) {
				return valueOf(2.5 * Math.pow(level, 2.0) - 40.5 * level + 360);
			} else {
				return valueOf(4.5 * Math.pow(level, 2.0) - 162.5 * level + 2220);
			}
		}
	}

	class ToString extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue vector) {
			String output = "cPlayer(" + player.getUsername() + ")";
			return valueOf(output);
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

			return valueOf(stringA.concat(stringB));
		}
	}

	/**
	 * Static Initialization
	 * 
	 * @param globals
	 */
	public cPlayer(Globals globals) {

		luaValue = LuaValue.tableOf();

		luaValue.set("CalcLevelFromXp", new CalcLevelFromXp());
		luaValue.set("PermissionMatches", new PermissionMatches());
		luaValue.set("XpForLevel", new XpForLevel());

		globals.set("cPlayer", luaValue);
	}

	/**
	 * Dynamic Initialization
	 * 
	 * @param somePlayer
	 */
	public cPlayer(Player somePlayer) {
		player = somePlayer;

		// Check if player already exists
		if (players.containsKey(somePlayer)) {
			this.luaValue = players.get(somePlayer);
			return;
		}

		luaValue = LuaValue.tableOf();

		luaValue.set("AddFoodExhaustion", new AddFoodExhaustion());
		luaValue.set("CalcLevelFromXp", new CalcLevelFromXp());
		luaValue.set("CanFly", new CanFly());
		luaValue.set("CanMobsTarget", new CanMobsTarget());
		luaValue.set("CloseWindow", new CloseWindow());
		luaValue.set("CloseWindowIfID", new CloseWindowIfID());
		luaValue.set("DeltaExperience", new DeltaExperience());
		luaValue.set("Feed", new Feed());
		luaValue.set("ForceSetSpeed", new ForceSetSpeed());
		luaValue.set("Freeze", new Freeze());
		luaValue.set("GetClientHandle", new GetClientHandle());
		luaValue.set("GetColor", new GetColor());
		luaValue.set("GetCurrentXp", new GetCurrentXp());
		luaValue.set("GetCustomName", new GetCustomName());
		luaValue.set("GetDraggingItem", new GetDraggingItem());
		luaValue.set("GetEffectiveGameMode", new GetEffectiveGameMode());
		luaValue.set("GetEquippedItem", new GetEquippedItem());
		luaValue.set("GetEyeHeight", new GetEyeHeight());
		luaValue.set("GetEyePosition", new GetEyePosition());
		luaValue.set("GetFloaterID", new GetFloaterID());
		luaValue.set("GetFlyingMaxSpeed", new GetFlyingMaxSpeed());
		luaValue.set("GetFoodExhaustionLevel", new GetFoodExhaustionLevel());
		luaValue.set("GetFoodLevel", new GetFoodLevel());
		luaValue.set("GetFoodSaturationLevel", new GetFoodSaturationLevel());
		luaValue.set("GetFoodTickTimer", new GetFoodTickTimer());
		luaValue.set("GetGameMode", new GetGameMode());
		luaValue.set("GetIP", new GetIP());
		luaValue.set("GetInventory", new GetInventory());
		luaValue.set("GetLastBedPos", new GetLastBedPos());
		luaValue.set("GetMainHand", new GetMainHand());
		luaValue.set("GetMaxSpeed", new GetMaxSpeed());
		luaValue.set("GetName", new GetName());
		luaValue.set("GetNormalMaxSpeed", new GetNormalMaxSpeed());
		luaValue.set("GetPermissions", new GetPermissions());
		luaValue.set("GetPlayerListName", new GetPlayerListName());
		luaValue.set("GetPrefix", new GetPrefix());
		luaValue.set("GetRestrictions", new GetRestrictions());
		luaValue.set("GetSkinParts", new GetSkinParts());
		luaValue.set("GetSprintingMaxSpeed", new GetSprintingMaxSpeed());
		luaValue.set("GetStance", new GetStance());
		luaValue.set("GetSuffix", new GetSuffix());
		luaValue.set("GetTeam", new GetTeam());
		luaValue.set("GetThrowSpeed", new GetThrowSpeed());
		luaValue.set("GetThrowStartPos", new GetThrowStartPos());
		luaValue.set("GetUUID", new GetUUID());
		luaValue.set("GetWindow", new GetWindow());
		luaValue.set("GetXpLevel", new GetXpLevel());
		luaValue.set("GetXpLifetimeTotal", new GetXpLifetimeTotal());
		luaValue.set("GetXpPercentage", new GetXpPercentage());
		luaValue.set("HasCustomName", new HasCustomName());
		luaValue.set("HasPermission", new HasPermission());
		luaValue.set("HasSkinPart", new HasSkinPart());
		luaValue.set("Heal", new Heal());
		luaValue.set("IsEating", new IsEating());
		luaValue.set("IsFireproof", new IsFireproof());
		luaValue.set("IsFishing", new IsFishing());
		luaValue.set("IsFlying", new IsFlying());
		luaValue.set("IsFrozen", new IsFrozen());
		luaValue.set("IsGameModeAdventure", new IsGameModeAdventure());
		luaValue.set("IsGameModeCreative", new IsGameModeCreative());
		luaValue.set("IsGameModeSpectator", new IsGameModeSpectator());
		luaValue.set("IsGameModeSurvival", new IsGameModeSurvival());
		luaValue.set("IsInBed", new IsInBed());
		luaValue.set("IsSatiated", new IsSatiated());
		luaValue.set("IsVisible", new IsVisible());
		luaValue.set("LoadRank", new LoadRank());
		luaValue.set("OpenWindow", new OpenWindow());
		luaValue.set("PermissionMatches", new PermissionMatches());
		luaValue.set("PlaceBlock", new PlaceBlock());
		luaValue.set("ReplaceOneEquippedItemTossRest", new ReplaceOneEquippedItemTossRest());
		luaValue.set("Respawn", new Respawn());
		luaValue.set("SendAboveActionBarMessage", new SendAboveActionBarMessage());
		luaValue.set("SendBlocksAround", new SendBlocksAround());
		luaValue.set("SendMessage", new SendMessage());
		luaValue.set("SendMessageFailure", new SendMessageFailure());
		luaValue.set("SendMessageFatal", new SendMessageFatal());
		luaValue.set("SendMessageInfo", new SendMessageInfo());
		luaValue.set("SendMessagePrivateMsg", new SendMessagePrivateMsg());
		luaValue.set("SendMessageRaw", new SendMessageRaw());
		luaValue.set("SendMessageSuccess", new SendMessageSuccess());
		luaValue.set("SendMessageWarning", new SendMessageWarning());
		luaValue.set("SendRotation", new SendRotation());
		luaValue.set("SendSystemMessage", new SendSystemMessage());
		luaValue.set("SetBedPos", new SetBedPos());
		luaValue.set("SetCanFly", new SetCanFly());
		luaValue.set("SetCrouch", new SetCrouch());
		luaValue.set("SetCurrentExperience", new SetCurrentExperience());
		luaValue.set("SetCustomName", new SetCustomName());
		luaValue.set("SetDraggingItem", new SetDraggingItem());
		luaValue.set("SetFlying", new SetFlying());
		luaValue.set("SetFlyingMaxSpeed", new SetFlyingMaxSpeed());
		luaValue.set("SetFoodExhaustionLevel", new SetFoodExhaustionLevel());
		luaValue.set("SetFoodLevel", new SetFoodLevel());
		luaValue.set("SetFoodSaturationLevel", new SetFoodSaturationLevel());
		luaValue.set("SetFoodTickTimer", new SetFoodTickTimer());
		luaValue.set("SetGameMode", new SetGameMode());
		luaValue.set("SetIsFishing", new SetIsFishing());
		luaValue.set("SetMainHand", new SetMainHand());
		luaValue.set("SetNormalMaxSpeed", new SetNormalMaxSpeed());
		luaValue.set("SetSkinParts", new SetSkinParts());
		luaValue.set("SetSprint", new SetSprint());
		luaValue.set("SetTeam", new SetTeam());
		luaValue.set("SetVisible", new SetVisible());
		luaValue.set("SpectateEntity", new SpectateEntity());
		luaValue.set("TossEquippedItem", new TossEquippedItem());
		luaValue.set("TossHeldItem", new TossHeldItem());
		luaValue.set("TossPickup", new TossPickup());
		luaValue.set("Unfreeze", new Unfreeze());
		luaValue.set("XpForLevel", new XpForLevel());

		// metatable
		LuaValue metatable = LuaValue.tableOf();

		metatable.set("__tostring", new ToString());
		metatable.set("__concat", new Concat());

		luaValue.setmetatable(metatable);

		players.put(somePlayer, luaValue);

	}
}
