package cuberite.api;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

import cuberite.plugin.Plugin;
import cuberite.utility.TextType;
import net.minestom.server.instance.block.BlockFace;

public class cGlobals {

	// Global Functions

	static class AddFaceDirection extends VarArgFunction { // TODO: Complete this class
		/**
		 * BlockPos Vector3i BlockFace eBlockFace IsInverse boolean BlockPos Vector3i
		 * Returns the coords of a block adjacent to the specified block through the
		 * specified face
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("AddFaceDirection Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class Base64Decode extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Input string string Decodes a Base64-encoded string into the raw data.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("Base64Decode Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class Base64Encode extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Input string string Encodes a string into Base64.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("Base64Encode Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class BiomeToString extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Biome EMCSBiome string Translates biome enum into biome string. Returns empty
		 * string on failure (unknown biome).
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("BiomeToString Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class BlockFaceToString extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * eBlockFace eBlockFace string Returns the string representation of the
		 * eBlockFace constant. Uses the axis-direction-based names, such as
		 * BLOCK_FACE_XP.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("BlockFaceToString Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class BlockStringToType extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * BlockTypeString string BLOCKTYPE number Returns the block type parsed from
		 * the given string
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("BlockStringToType Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class Clamp extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Number number Min number Max number number Clamp the number to the specified
		 * range.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("Clamp Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class ClickActionToString extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * ClickAction eClickAction string Returns a string description of the
		 * ClickAction enumerated value
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ClickActionToString Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class DamageTypeToString extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * DamageType eDamageType string Converts the DamageType to a string
		 * representation
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("DamageTypeToString Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class DimensionToString extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Dimension eDimension string Converts an eDimension to a string value. Returns
		 * Overworld on failure.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("DimensionToString Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class EscapeString extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Input string string Returns a copy of the string with all quotes and
		 * backslashes escaped by a backslash
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("EscapeString Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class GetIniItemSet extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * IniFile cIniFile SectionName string KeyName string DefaultValue string cItem
		 * Returns the item that has been read from the specified INI file value. If the
		 * value is not present in the INI file, the DefaultValue is stored in the file
		 * and parsed as the result. Returns empty item if the value cannot be parsed.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("GetIniItemSet Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class GetSnowStartHeight extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Biome EMCSBiome number Returns the height at which snow will start falling in
		 * the Biome. Check functions IsBiomeCold and IsBiomeVeryCold for more
		 * informations.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("GetSnowStartHeight Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class GetTime extends VarArgFunction { // TODO: Complete this class
		/**
		 * number Returns the current OS time, as a unix time stamp (number of seconds
		 * since Jan 1, 1970)
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("GetTime Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class IsBiomeCold extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Biome EMCSBiome boolean Returns true if the biome is cold (has snow and
		 * snowfall at higher elevations but not at regular heights). Doesn't report
		 * Very Cold biomes, use IsBiomeVeryCold() for those.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("IsBiomeCold Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class IsBiomeMesa extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Biome EMCSBiome boolean Returns true if the biome is a type of Mesa
		 * (mutations of the Mesa biome).
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("IsBiomeMesa Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class IsBiomeMountain extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Biome EMCSBiome boolean Returns true if the biome is mountainous (mutations
		 * of the extreme hills biome).
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("IsBiomeMountain Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class IsBiomeNoDownfall extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Biome EMCSBiome boolean Returns true if the biome is 'dry', that is, there is
		 * no precipitation during rains and storms.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("IsBiomeNoDownfall Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class IsBiomeOcean extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Biome EMCSBiome boolean Returns true if the biome is an ocean biome.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("IsBiomeOcean Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class IsBiomeVeryCold extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Biome EMCSBiome boolean Returns true if the biome is very cold (has snow on
		 * ground everywhere, turns top water to ice, has snowfall instead of rain
		 * everywhere). Doesn't report mildly cold biomes (where it snows above certain
		 * elevation), use IsBiomeCold() for those.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("IsBiomeVeryCold Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class IsValidBlock extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * BlockType number boolean Returns true if BlockType is a known block type
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("IsValidBlock Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class IsValidItem extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * ItemType number boolean Returns true if ItemType is a known item type
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("IsValidItem Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class ItemToFullString extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * cItem cItem string Returns the string representation of the item, in the
		 * format 'ItemTypeText:ItemDamage * Count'
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ItemToFullString Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class ItemToString extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * cItem cItem string Returns the string representation of the item type
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ItemToString Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class ItemTypeToString extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * ItemType number string Returns the string representation of ItemType
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ItemTypeToString Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class LOG extends OneArgFunction { // TODO: Complete this class
		/**
		 * Message cCompositeChat Logs the cCompositeChat's human-readable text into the
		 * server console. The severity is converted from the CompositeChat's
		 * MessageType.
		 * 
		 * @author Krystilize
		 *
		 */
		@Override
		public LuaValue call(LuaValue value) {
			if (value.isstring()) {
				System.out.println(value);
			} else {
				// TODO: cCompositeChat
			}
			return LuaValue.NIL;
		}
	}

	static class LOGERROR extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Message cCompositeChat Logs the cCompositeChat's human-readable text into the
		 * server console and logfile using 'error' severity (black text on red
		 * background)
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println(TextType.ERROR.create(value).getMessage());
			return LuaValue.NIL;
		}
	}

	static class LOGINFO extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Message cCompositeChat Logs the cCompositeChat's human-readable text into the
		 * server console and logfile using 'info' severity (yellow text)
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println(TextType.INFO.create(value).getMessage());
			return LuaValue.NIL;
		}
	}

	static class LOGWARN extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Message cCompositeChat Logs the cCompositeChat's human-readable text into the
		 * server console and logfile using 'warning' severity (red text); OBSOLETE, use
		 * LOGWARNING() instead
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println(TextType.WARNING.create(value).getMessage());
			return LuaValue.NIL;
		}
	}

	static class LOGWARNING extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Message cCompositeChat Logs the cCompositeChat's human-readable text into the
		 * server console and logfile using 'warning' severity (red text)
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println(TextType.WARNING.create(value).getMessage());
			return LuaValue.NIL;
		}
	}

	static class MirrorBlockFaceY extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * eBlockFace eBlockFace eBlockFace Returns the eBlockFace that corresponds to
		 * the given eBlockFace after mirroring it around the Y axis (or rotating 180
		 * degrees around it).
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("MirrorBlockFaceY Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class NoCaseCompare extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Value1 string Value2 string number Case-insensitive string comparison;
		 * returns 0 if the strings are the same, -1 if Value1 is smaller and 1 if
		 * Value2 is smaller
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("NoCaseCompare Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class NormalizeAngleDegrees extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * AngleDegrees number AngleDegrees number Returns the angle, wrapped into the
		 * [-180, +180) range.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("NormalizeAngleDegrees Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class ReplaceString extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * full-string string to-be-replaced-string string to-replace-string string
		 * string Replaces *each* occurence of to-be-replaced-string in full-string with
		 * to-replace-string
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ReplaceString Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class ReverseBlockFace extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * BlockFace eBlockFace eBlockFace Returns the reversed eBlockFace.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("ReverseBlockFace Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class RotateBlockFaceCCW extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * eBlockFace eBlockFace eBlockFace Returns the eBlockFace that corresponds to
		 * the given eBlockFace after rotating it around the Y axis 90 degrees
		 * counter-clockwise.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("RotateBlockFaceCCW Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class RotateBlockFaceCW extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * eBlockFace eBlockFace eBlockFace Returns the eBlockFace that corresponds to
		 * the given eBlockFace after rotating it around the Y axis 90 degrees
		 * clockwise.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("RotateBlockFaceCW Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class StringSplit extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Input string SeperatorsString string table Seperates string into multiple by
		 * splitting every time any of the characters in SeperatorsString is
		 * encountered. Returns and array-table of strings.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("StringSplit Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class StringSplitAndTrim extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Input string SeperatorsString string table Seperates string into multiple by
		 * splitting every time any of the characters in SeperatorsString is
		 * encountered. Each of the separate strings is trimmed (whitespace removed from
		 * the beginning and end of the string). Returns an array-table of strings.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("StringSplitAndTrim Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class StringSplitWithQuotes extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Input string SeperatorsString string table Seperates string into multiple by
		 * splitting every time any of the characters in SeperatorsString is
		 * encountered. Whitespace wrapped with single or double quotes will be ignored.
		 * Returns an array-table of strings.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("StringSplitWithQuotes Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class StringToBiome extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Input string BiomeType EMCSBiome Converts a string representation to a
		 * BiomeType enumerated value. Returns biInvalidBiome if the input is not a
		 * recognized biome.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("StringToBiome Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class StringToDamageType extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Input string DamageType eDamageType Converts a string representation to a
		 * DamageType enumerated value. Returns -1 if the inupt is not a recognized
		 * damage type.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("StringToDamageType Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class StringToDimension extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Input string Dimension eDimension Converts a string representation to a
		 * eDimension enumerated value. Returns dimNotSet if the input is not a
		 * recognized dimension.
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("StringToDimension Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class StringToItem extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * StringToParse string DestItem cItem boolean Parses the item specification in
		 * the given string and sets it into DestItem; returns true if successful
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("StringToItem Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class StringToMobType extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * MobTypeString string MobType eMonsterType (DEPRECATED!) Please use
		 * cMonster:StringToMobType(). Converts a string representation to an
		 * eMonsterType enumerated value
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("StringToMobType Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class StripColorCodes extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Input string string Removes all control codes used by MC for colors and
		 * styles
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("StripColorCodes Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class TrimString extends VarArgFunction { // TODO: Complete this class
		/**
		 *
		 * Input string string Removes whitespace at both ends of the string
		 */
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("TrimString Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	public static void initialize(Plugin plugin, Globals globals) {

		// Classes
		globals.set("cRoot", cRoot.luaValue);
		new cPluginManager(plugin, globals);
		new cPlayer(globals);
		new cEntity(globals);
		new cClientHandle(globals);
		new cUUID(globals);
		new cWorld(globals);

		globals.set("Vector3d", new Vector3d.Vector3dConstructor());
		globals.set("Vector3i", new Vector3i.Vector3iConstructor());
		globals.set("Vector3f", new Vector3f.Vector3fConstructor());

		// Functions

		globals.set("AddFaceDirection", new AddFaceDirection());
		globals.set("Base64Decode", new Base64Decode());
		globals.set("Base64Encode", new Base64Encode());
		globals.set("BiomeToString", new BiomeToString());
		globals.set("BlockFaceToString", new BlockFaceToString());
		globals.set("BlockStringToType", new BlockStringToType());
		globals.set("Clamp", new Clamp());
		globals.set("ClickActionToString", new ClickActionToString());
		globals.set("DamageTypeToString", new DamageTypeToString());
		globals.set("DimensionToString", new DimensionToString());
		globals.set("EscapeString", new EscapeString());
		globals.set("GetIniItemSet", new GetIniItemSet());
		globals.set("GetSnowStartHeight", new GetSnowStartHeight());
		globals.set("GetTime", new GetTime());
		globals.set("IsBiomeCold", new IsBiomeCold());
		globals.set("IsBiomeMesa", new IsBiomeMesa());
		globals.set("IsBiomeMountain", new IsBiomeMountain());
		globals.set("IsBiomeNoDownfall", new IsBiomeNoDownfall());
		globals.set("IsBiomeOcean", new IsBiomeOcean());
		globals.set("IsBiomeVeryCold", new IsBiomeVeryCold());
		globals.set("IsValidBlock", new IsValidBlock());
		globals.set("IsValidItem", new IsValidItem());
		globals.set("ItemToFullString", new ItemToFullString());
		globals.set("ItemToString", new ItemToString());
		globals.set("ItemTypeToString", new ItemTypeToString());
		globals.set("LOG", new LOG());
		globals.set("LOGERROR", new LOGERROR());
		globals.set("LOGINFO", new LOGINFO());
		globals.set("LOGWARN", new LOGWARN());
		globals.set("LOGWARNING", new LOGWARNING());
		globals.set("MirrorBlockFaceY", new MirrorBlockFaceY());
		globals.set("NoCaseCompare", new NoCaseCompare());
		globals.set("NormalizeAngleDegrees", new NormalizeAngleDegrees());
		globals.set("ReplaceString", new ReplaceString());
		globals.set("ReverseBlockFace", new ReverseBlockFace());
		globals.set("RotateBlockFaceCCW", new RotateBlockFaceCCW());
		globals.set("RotateBlockFaceCW", new RotateBlockFaceCW());
		globals.set("StringSplit", new StringSplit());
		globals.set("StringSplitAndTrim", new StringSplitAndTrim());
		globals.set("StringSplitWithQuotes", new StringSplitWithQuotes());
		globals.set("StringToBiome", new StringToBiome());
		globals.set("StringToDamageType", new StringToDamageType());
		globals.set("StringToDimension", new StringToDimension());
		globals.set("StringToItem", new StringToItem());
		globals.set("StringToMobType", new StringToMobType());
		globals.set("StripColorCodes", new StripColorCodes());
		globals.set("TrimString", new TrimString());

		// Constants

		globals.set("MAX_EXPERIENCE_ORB_SIZE", LuaValue.valueOf(2000)); //
		globals.set("_CuberiteInternal_PluginName", LuaValue.valueOf("APIDump")); //
		globals.set("_VERSION", LuaValue.valueOf("Lua 5.1")); //
		globals.set("ctAboveActionBar", LuaValue.valueOf(2)); //
		globals.set("ctChatBox", LuaValue.valueOf(0)); //
		globals.set("ctSystem", LuaValue.valueOf(1)); //
		globals.set("esBed", LuaValue.valueOf(0)); // A bed explosion. The SourceData param is the position of the bed.
		globals.set("esEnderCrystal", LuaValue.valueOf(1)); // An ender crystal entity explosion. The SourceData param
															// is the ender crystal entity object.
		globals.set("esGhastFireball", LuaValue.valueOf(2)); // A ghast fireball explosion. The SourceData param is the
																// ghast fireball entity object.
		globals.set("esMax", LuaValue.valueOf(9)); //
		globals.set("esMonster", LuaValue.valueOf(3)); // A monster explosion (creeper). The SourceData param is the
														// monster entity object.
		globals.set("esOther", LuaValue.valueOf(4)); // Any other explosion. The SourceData param is unused.
		globals.set("esPlugin", LuaValue.valueOf(5)); // An explosion started by a plugin, without any further
														// information. The SourceData param is unused.
		globals.set("esPrimedTNT", LuaValue.valueOf(6)); // A TNT explosion. The SourceData param is the TNT entity
															// object.
		globals.set("esWitherBirth", LuaValue.valueOf(7)); // An explosion at a wither's birth. The SourceData param is
															// the wither entity object.
		globals.set("esWitherSkull", LuaValue.valueOf(8)); // A wither skull explosion. The SourceData param is the
															// wither skull entity object.
		globals.set("eWeather_Rain", LuaValue.valueOf(1)); //
		globals.set("eWeather_Sunny", LuaValue.valueOf(0)); //
		globals.set("eWeather_ThunderStorm", LuaValue.valueOf(2)); //
		globals.set("wRain", LuaValue.valueOf(1)); //
		globals.set("wStorm", LuaValue.valueOf(2)); //
		globals.set("wSunny", LuaValue.valueOf(0)); //
		globals.set("wThunderstorm", LuaValue.valueOf(2)); //
		globals.set("spCape", LuaValue.valueOf(1)); // The cape skin part
		globals.set("spHat", LuaValue.valueOf(64)); // The hat/head skin part
		globals.set("spJacket", LuaValue.valueOf(2)); // The jacket skin part
		globals.set("spLeftPants", LuaValue.valueOf(16)); // The left pants leg skin part
		globals.set("spLeftSleeve", LuaValue.valueOf(4)); // The left sleeve skin part
		globals.set("spMask", LuaValue.valueOf(127)); // A mask of all valid skin parts combined
		globals.set("spRightPants", LuaValue.valueOf(32)); // The right pants leg skin part
		globals.set("spRightSleeve", LuaValue.valueOf(8)); // The right sleeve skin part
		globals.set("E_META_BANNER_BLACK", LuaValue.valueOf(0)); //
		globals.set("E_META_BANNER_BLUE", LuaValue.valueOf(4)); //
		globals.set("E_META_BANNER_BROWN", LuaValue.valueOf(3)); //
		globals.set("E_META_BANNER_CYAN", LuaValue.valueOf(6)); //
		globals.set("E_META_BANNER_GRAY", LuaValue.valueOf(8)); //
		globals.set("E_META_BANNER_GREEN", LuaValue.valueOf(2)); //
		globals.set("E_META_BANNER_LIGHTBLUE", LuaValue.valueOf(12)); //
		globals.set("E_META_BANNER_LIGHTGRAY", LuaValue.valueOf(7)); //
		globals.set("E_META_BANNER_LIGHTGREEN", LuaValue.valueOf(10)); //
		globals.set("E_META_BANNER_MAGENTA", LuaValue.valueOf(13)); //
		globals.set("E_META_BANNER_ORANGE", LuaValue.valueOf(14)); //
		globals.set("E_META_BANNER_PINK", LuaValue.valueOf(9)); //
		globals.set("E_META_BANNER_PURPLE", LuaValue.valueOf(5)); //
		globals.set("E_META_BANNER_RED", LuaValue.valueOf(1)); //
		globals.set("E_META_BANNER_WHITE", LuaValue.valueOf(15)); //
		globals.set("E_META_BANNER_YELLOW", LuaValue.valueOf(11)); //
		globals.set("E_META_BIG_FLOWER_DOUBLE_TALL_GRASS", LuaValue.valueOf(2)); //
		globals.set("E_META_BIG_FLOWER_LARGE_FERN", LuaValue.valueOf(3)); //
		globals.set("E_META_BIG_FLOWER_LILAC", LuaValue.valueOf(1)); //
		globals.set("E_META_BIG_FLOWER_PEONY", LuaValue.valueOf(5)); //
		globals.set("E_META_BIG_FLOWER_ROSE_BUSH", LuaValue.valueOf(4)); //
		globals.set("E_META_BIG_FLOWER_SUNFLOWER", LuaValue.valueOf(0)); //
		globals.set("E_META_BIG_FLOWER_TOP", LuaValue.valueOf(10)); // The metadata of a big flower block that indicates
																	// it is the top block.
		globals.set("E_META_BREWING_STAND_FILLED_SLOT_XM_ZM", LuaValue.valueOf(4)); //
		globals.set("E_META_BREWING_STAND_FILLED_SLOT_XM_ZP", LuaValue.valueOf(2)); //
		globals.set("E_META_BREWING_STAND_FILLED_SLOT_XP", LuaValue.valueOf(1)); //
		globals.set("E_META_CARPET_BLACK", LuaValue.valueOf(15)); //
		globals.set("E_META_CARPET_BLUE", LuaValue.valueOf(11)); //
		globals.set("E_META_CARPET_BROWN", LuaValue.valueOf(12)); //
		globals.set("E_META_CARPET_CYAN", LuaValue.valueOf(9)); //
		globals.set("E_META_CARPET_GRAY", LuaValue.valueOf(7)); //
		globals.set("E_META_CARPET_GREEN", LuaValue.valueOf(13)); //
		globals.set("E_META_CARPET_LIGHTBLUE", LuaValue.valueOf(3)); //
		globals.set("E_META_CARPET_LIGHTGRAY", LuaValue.valueOf(8)); //
		globals.set("E_META_CARPET_LIGHTGREEN", LuaValue.valueOf(5)); //
		globals.set("E_META_CARPET_MAGENTA", LuaValue.valueOf(2)); //
		globals.set("E_META_CARPET_ORANGE", LuaValue.valueOf(1)); //
		globals.set("E_META_CARPET_PINK", LuaValue.valueOf(6)); //
		globals.set("E_META_CARPET_PURPLE", LuaValue.valueOf(10)); //
		globals.set("E_META_CARPET_RED", LuaValue.valueOf(14)); //
		globals.set("E_META_CARPET_WHITE", LuaValue.valueOf(0)); //
		globals.set("E_META_CARPET_YELLOW", LuaValue.valueOf(4)); //
		globals.set("E_META_CHEST_FACING_XM", LuaValue.valueOf(4)); //
		globals.set("E_META_CHEST_FACING_XP", LuaValue.valueOf(5)); //
		globals.set("E_META_CHEST_FACING_ZM", LuaValue.valueOf(2)); //
		globals.set("E_META_CHEST_FACING_ZP", LuaValue.valueOf(3)); //
		globals.set("E_META_COAL_CHARCOAL", LuaValue.valueOf(1)); //
		globals.set("E_META_COAL_NORMAL", LuaValue.valueOf(0)); //
		globals.set("E_META_CONCRETE_BLACK", LuaValue.valueOf(15)); // A flag in the metadata of concete that indicates
																	// that the concrete is black.
		globals.set("E_META_CONCRETE_BLUE", LuaValue.valueOf(11)); // A flag in the metadata of concete that indicates
																	// that the concrete is blue.
		globals.set("E_META_CONCRETE_BROWN", LuaValue.valueOf(12)); // A flag in the metadata of concete that indicates
																	// that the concrete is brown.
		globals.set("E_META_CONCRETE_CYAN", LuaValue.valueOf(9)); // A flag in the metadata of concete that indicates
																	// that the concrete is cyan.
		globals.set("E_META_CONCRETE_GRAY", LuaValue.valueOf(7)); // A flag in the metadata of concete that indicates
																	// that the concrete is gray.
		globals.set("E_META_CONCRETE_GREEN", LuaValue.valueOf(13)); // A flag in the metadata of concete that indicates
																	// that the concrete is green.
		globals.set("E_META_CONCRETE_LIGHTBLUE", LuaValue.valueOf(3)); // A flag in the metadata of concete that
																		// indicates that the concrete is light blue.
		globals.set("E_META_CONCRETE_LIGHTGRAY", LuaValue.valueOf(8)); // A flag in the metadata of concete that
																		// indicates that the concrete is light gray.
		globals.set("E_META_CONCRETE_LIGHTGREEN", LuaValue.valueOf(5)); // A flag in the metadata of concete that
																		// indicates that the concrete is light green.
		globals.set("E_META_CONCRETE_MAGENTA", LuaValue.valueOf(2)); // A flag in the metadata of concete that indicates
																		// that the concrete is magenta.
		globals.set("E_META_CONCRETE_ORANGE", LuaValue.valueOf(1)); // A flag in the metadata of concete that indicates
																	// that the concrete is orange.
		globals.set("E_META_CONCRETE_PINK", LuaValue.valueOf(6)); // A flag in the metadata of concete that indicates
																	// that the concrete is pink.
		globals.set("E_META_CONCRETE_POWDER_BLACK", LuaValue.valueOf(15)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is black.
		globals.set("E_META_CONCRETE_POWDER_BLUE", LuaValue.valueOf(11)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is blue.
		globals.set("E_META_CONCRETE_POWDER_BROWN", LuaValue.valueOf(12)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is brown.
		globals.set("E_META_CONCRETE_POWDER_CYAN", LuaValue.valueOf(9)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is cyan.
		globals.set("E_META_CONCRETE_POWDER_GRAY", LuaValue.valueOf(7)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is gray.
		globals.set("E_META_CONCRETE_POWDER_GREEN", LuaValue.valueOf(13)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is green.
		globals.set("E_META_CONCRETE_POWDER_LIGHTBLUE", LuaValue.valueOf(3)); // A flag in the metadata of concete
																				// powder that indicates that the
																				// concrete powder is light blue.
		globals.set("E_META_CONCRETE_POWDER_LIGHTGRAY", LuaValue.valueOf(8)); // A flag in the metadata of concete
																				// powder that indicates that the
																				// concrete powder is light gray.
		globals.set("E_META_CONCRETE_POWDER_LIGHTGREEN", LuaValue.valueOf(5)); // A flag in the metadata of concete
																				// powder that indicates that the
																				// concrete powder is light green.
		globals.set("E_META_CONCRETE_POWDER_MAGENTA", LuaValue.valueOf(2)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is magenta.
		globals.set("E_META_CONCRETE_POWDER_ORANGE", LuaValue.valueOf(1)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is orange.
		globals.set("E_META_CONCRETE_POWDER_PINK", LuaValue.valueOf(6)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is pink.
		globals.set("E_META_CONCRETE_POWDER_PURPLE", LuaValue.valueOf(10)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is purple.
		globals.set("E_META_CONCRETE_POWDER_RED", LuaValue.valueOf(14)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is red.
		globals.set("E_META_CONCRETE_POWDER_WHITE", LuaValue.valueOf(0)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is white.
		globals.set("E_META_CONCRETE_POWDER_YELLOW", LuaValue.valueOf(4)); // A flag in the metadata of concete powder
																			// that indicates that the concrete powder
																			// is yellow.
		globals.set("E_META_CONCRETE_PURPLE", LuaValue.valueOf(10)); // A flag in the metadata of concete that indicates
																		// that the concrete is purple.
		globals.set("E_META_CONCRETE_RED", LuaValue.valueOf(14)); // A flag in the metadata of concete that indicates
																	// that the concrete is red.
		globals.set("E_META_CONCRETE_WHITE", LuaValue.valueOf(0)); // A flag in the metadata of concete that indicates
																	// that the concrete is white.
		globals.set("E_META_CONCRETE_YELLOW", LuaValue.valueOf(4)); // A flag in the metadata of concete that indicates
																	// that the concrete is yellow.
		globals.set("E_META_COOKED_FISH_FISH", LuaValue.valueOf(0)); //
		globals.set("E_META_COOKED_FISH_SALMON", LuaValue.valueOf(1)); //
		globals.set("E_META_DIRT_COARSE", LuaValue.valueOf(1)); //
		globals.set("E_META_DIRT_GRASSLESS", LuaValue.valueOf(1)); //
		globals.set("E_META_DIRT_NORMAL", LuaValue.valueOf(0)); //
		globals.set("E_META_DIRT_PODZOL", LuaValue.valueOf(2)); //
		globals.set("E_META_DOUBLE_STONE_SLAB_BRICK", LuaValue.valueOf(4)); //
		globals.set("E_META_DOUBLE_STONE_SLAB_COBBLESTONE", LuaValue.valueOf(3)); //
		globals.set("E_META_DOUBLE_STONE_SLAB_NETHER_BRICK", LuaValue.valueOf(6)); //
		globals.set("E_META_DOUBLE_STONE_SLAB_QUARTZ", LuaValue.valueOf(7)); //
		globals.set("E_META_DOUBLE_STONE_SLAB_SANDSTON", LuaValue.valueOf(1)); //
		globals.set("E_META_DOUBLE_STONE_SLAB_SMOOTH_SANDSTONE", LuaValue.valueOf(9)); //
		globals.set("E_META_DOUBLE_STONE_SLAB_SMOOTH_STONE", LuaValue.valueOf(8)); //
		globals.set("E_META_DOUBLE_STONE_SLAB_STONE", LuaValue.valueOf(0)); //
		globals.set("E_META_DOUBLE_STONE_SLAB_STONE_BRICK", LuaValue.valueOf(5)); //
		globals.set("E_META_DOUBLE_STONE_SLAB_TILE_QUARTZ", LuaValue.valueOf(10)); //
		globals.set("E_META_DOUBLE_STONE_SLAB_WOODEN", LuaValue.valueOf(2)); //
		globals.set("E_META_DROPSPENSER_ACTIVATED", LuaValue.valueOf(8)); // A flag in the metadata of droppers and
																			// dispensers that indicates that the
																			// dropper or dispenser is currently
																			// activated. If this flag is set, the block
																			// must be unpowered first and powered again
																			// to shoot the next item.
		globals.set("E_META_DROPSPENSER_FACING_MASK", LuaValue.valueOf(7)); // A mask that indicates the bits of the
																			// metadata that specify the facing of
																			// droppers and dispensers.
		globals.set("E_META_DROPSPENSER_FACING_XM", LuaValue.valueOf(4)); // A flag in the metadata of droppers and
																			// dispensers that indicates that the
																			// dropper or dispenser is looking in the
																			// negative X direction.
		globals.set("E_META_DROPSPENSER_FACING_XP", LuaValue.valueOf(5)); // A flag in the metadata of droppers and
																			// dispensers that indicates that the
																			// dropper or dispenser is looking in the
																			// positive X direction.
		globals.set("E_META_DROPSPENSER_FACING_YM", LuaValue.valueOf(0)); // A flag in the metadata of droppers and
																			// dispensers that indicates that the
																			// dropper or dispenser is looking in the
																			// negative Y direction.
		globals.set("E_META_DROPSPENSER_FACING_YP", LuaValue.valueOf(1)); // A flag in the metadata of droppers and
																			// dispensers that indicates that the
																			// dropper or dispenser is looking in the
																			// positive Y direction.
		globals.set("E_META_DROPSPENSER_FACING_ZM", LuaValue.valueOf(2)); // A flag in the metadata of droppers and
																			// dispensers that indicates that the
																			// dropper or dispenser is looking in the
																			// negative Z direction.
		globals.set("E_META_DROPSPENSER_FACING_ZP", LuaValue.valueOf(3)); // A flag in the metadata of droppers and
																			// dispensers that indicates that the
																			// dropper or dispenser is looking in the
																			// positive Z direction.
		globals.set("E_META_DYE_BLACK", LuaValue.valueOf(0)); //
		globals.set("E_META_DYE_BLUE", LuaValue.valueOf(4)); //
		globals.set("E_META_DYE_BROWN", LuaValue.valueOf(3)); //
		globals.set("E_META_DYE_CYAN", LuaValue.valueOf(6)); //
		globals.set("E_META_DYE_GRAY", LuaValue.valueOf(8)); //
		globals.set("E_META_DYE_GREEN", LuaValue.valueOf(2)); //
		globals.set("E_META_DYE_LIGHTBLUE", LuaValue.valueOf(12)); //
		globals.set("E_META_DYE_LIGHTGRAY", LuaValue.valueOf(7)); //
		globals.set("E_META_DYE_LIGHTGREEN", LuaValue.valueOf(10)); //
		globals.set("E_META_DYE_MAGENTA", LuaValue.valueOf(13)); //
		globals.set("E_META_DYE_ORANGE", LuaValue.valueOf(14)); //
		globals.set("E_META_DYE_PINK", LuaValue.valueOf(9)); //
		globals.set("E_META_DYE_PURPLE", LuaValue.valueOf(5)); //
		globals.set("E_META_DYE_RED", LuaValue.valueOf(1)); //
		globals.set("E_META_DYE_WHITE", LuaValue.valueOf(15)); //
		globals.set("E_META_DYE_YELLOW", LuaValue.valueOf(11)); //
		globals.set("E_META_END_PORTAL_FRAME_EYE", LuaValue.valueOf(4)); // A flag in the metadata of end portal frames
																			// that indicates that the portal frame has
																			// an eye in it.
		globals.set("E_META_END_PORTAL_FRAME_NO_EYE", LuaValue.valueOf(0)); // The lack of the flag in the metadata of
																			// end portal frames indicating that the
																			// portal frame has an eye in it.
		globals.set("E_META_END_PORTAL_FRAME_XM", LuaValue.valueOf(1)); // A flag in the metadata of end portal frames
																		// that indicates that the portal frame is
																		// facing the negative X direction.
		globals.set("E_META_END_PORTAL_FRAME_XM_EYE", LuaValue.valueOf(5)); // A flag in the metadata of end portal
																			// frames that indicates that the portal
																			// frame is facing the negative X direction
																			// and has an ender eye in it.
		globals.set("E_META_END_PORTAL_FRAME_XP", LuaValue.valueOf(3)); // A flag in the metadata of end portal frames
																		// that indicates that the portal frame is
																		// facing the positive X direction.
		globals.set("E_META_END_PORTAL_FRAME_XP_EYE", LuaValue.valueOf(7)); // A flag in the metadata of end portal
																			// frames that indicates that the portal
																			// frame is facing the positive X direction
																			// and has an ender eye in it.
		globals.set("E_META_END_PORTAL_FRAME_ZM", LuaValue.valueOf(2)); // A flag in the metadata of end portal frames
																		// that indicates that the portal frame is
																		// facing the negative Z direction.
		globals.set("E_META_END_PORTAL_FRAME_ZM_EYE", LuaValue.valueOf(6)); // A flag in the metadata of end portal
																			// frames that indicates that the portal
																			// frame is facing the negative Z direction
																			// and has an ender eye in it.
		globals.set("E_META_END_PORTAL_FRAME_ZP", LuaValue.valueOf(0)); // A flag in the metadata of end portal frames
																		// that indicates that the portal frame is
																		// facing the positive Z direction.
		globals.set("E_META_END_PORTAL_FRAME_ZP_EYE", LuaValue.valueOf(4)); // A flag in the metadata of end portal
																			// frames that indicates that the portal
																			// frame is facing the positive Z direction
																			// and has an ender eye in it.
		globals.set("E_META_FLOWER_ALLIUM", LuaValue.valueOf(2)); //
		globals.set("E_META_FLOWER_BLUE_ORCHID", LuaValue.valueOf(1)); //
		globals.set("E_META_FLOWER_ORANGE_TULIP", LuaValue.valueOf(5)); //
		globals.set("E_META_FLOWER_OXEYE_DAISY", LuaValue.valueOf(8)); //
		globals.set("E_META_FLOWER_PINK_TULIP", LuaValue.valueOf(7)); //
		globals.set("E_META_FLOWER_POPPY", LuaValue.valueOf(0)); //
		globals.set("E_META_FLOWER_RED_TULIP", LuaValue.valueOf(4)); //
		globals.set("E_META_FLOWER_WHITE_TULIP", LuaValue.valueOf(6)); //
		globals.set("E_META_GOLDEN_APPLE_ENCHANTED", LuaValue.valueOf(1)); //
		globals.set("E_META_GOLDEN_APPLE_NORMAL", LuaValue.valueOf(0)); //
		globals.set("E_META_HEAD_CREEPER", LuaValue.valueOf(4)); // A flag in the metadata of heads that indicates that
																	// the head is a creeper head.
		globals.set("E_META_HEAD_DRAGON", LuaValue.valueOf(5)); // A flag in the metadata of heads that indicates that
																// the head is a dragon head.
		globals.set("E_META_HEAD_PLAYER", LuaValue.valueOf(3)); // A flag in the metadata of heads that indicates that
																// the head is a player head.
		globals.set("E_META_HEAD_SKELETON", LuaValue.valueOf(0)); // A flag in the metadata of heads that indicates that
																	// the head is a skeleton head.
		globals.set("E_META_HEAD_WITHER", LuaValue.valueOf(1)); // A flag in the metadata of heads that indicates that
																// the head is a wither head.
		globals.set("E_META_HEAD_ZOMBIE", LuaValue.valueOf(2)); // A flag in the metadata of heads that indicates that
																// the head is a zombie head.
		globals.set("E_META_HOPPER_FACING_XM", LuaValue.valueOf(4)); //
		globals.set("E_META_HOPPER_FACING_XP", LuaValue.valueOf(5)); //
		globals.set("E_META_HOPPER_FACING_YM", LuaValue.valueOf(0)); //
		globals.set("E_META_HOPPER_FACING_ZM", LuaValue.valueOf(2)); //
		globals.set("E_META_HOPPER_FACING_ZP", LuaValue.valueOf(3)); //
		globals.set("E_META_HOPPER_UNATTACHED", LuaValue.valueOf(1)); //
		globals.set("E_META_JUKEBOX_OFF", LuaValue.valueOf(0)); //
		globals.set("E_META_JUKEBOX_ON", LuaValue.valueOf(1)); //
		globals.set("E_META_LEAVES_APPLE", LuaValue.valueOf(0)); //
		globals.set("E_META_LEAVES_APPLE_CHECK_DECAY", LuaValue.valueOf(8)); //
		globals.set("E_META_LEAVES_APPLE_NO_DECAY", LuaValue.valueOf(4)); //
		globals.set("E_META_LEAVES_BIRCH", LuaValue.valueOf(2)); //
		globals.set("E_META_LEAVES_BIRCH_CHECK_DECAY", LuaValue.valueOf(10)); //
		globals.set("E_META_LEAVES_BIRCH_NO_DECAY", LuaValue.valueOf(6)); //
		globals.set("E_META_LEAVES_CONIFER", LuaValue.valueOf(1)); //
		globals.set("E_META_LEAVES_CONIFER_CHECK_DECAY", LuaValue.valueOf(9)); //
		globals.set("E_META_LEAVES_CONIFER_NO_DECAY", LuaValue.valueOf(5)); //
		globals.set("E_META_LEAVES_JUNGLE", LuaValue.valueOf(3)); //
		globals.set("E_META_LEAVES_JUNGLE_CHECK_DECAY", LuaValue.valueOf(11)); //
		globals.set("E_META_LEAVES_JUNGLE_NO_DECAY", LuaValue.valueOf(7)); //
		globals.set("E_META_LOG_APPLE", LuaValue.valueOf(0)); //
		globals.set("E_META_LOG_BIRCH", LuaValue.valueOf(2)); //
		globals.set("E_META_LOG_BIRCH_BARK_ONLY", LuaValue.valueOf(14)); //
		globals.set("E_META_LOG_BIRCH_UP_DOWN", LuaValue.valueOf(2)); //
		globals.set("E_META_LOG_BIRCH_X", LuaValue.valueOf(6)); //
		globals.set("E_META_LOG_BIRCH_Z", LuaValue.valueOf(10)); //
		globals.set("E_META_LOG_CONIFER", LuaValue.valueOf(1)); //
		globals.set("E_META_LOG_JUNGLE", LuaValue.valueOf(3)); //
		globals.set("E_META_LOG_JUNGLE_BARK_ONLY", LuaValue.valueOf(15)); //
		globals.set("E_META_LOG_JUNGLE_UP_DOWN", LuaValue.valueOf(3)); //
		globals.set("E_META_LOG_JUNGLE_X", LuaValue.valueOf(7)); //
		globals.set("E_META_LOG_JUNGLE_Z", LuaValue.valueOf(11)); //
		globals.set("E_META_LOG_OAK_BARK_ONLY", LuaValue.valueOf(12)); //
		globals.set("E_META_LOG_OAK_UP_DOWN", LuaValue.valueOf(0)); //
		globals.set("E_META_LOG_OAK_X", LuaValue.valueOf(4)); //
		globals.set("E_META_LOG_OAK_Z", LuaValue.valueOf(8)); //
		globals.set("E_META_LOG_SPRUCE_BARK_ONLY", LuaValue.valueOf(13)); //
		globals.set("E_META_LOG_SPRUCE_UP_DOWN", LuaValue.valueOf(1)); //
		globals.set("E_META_LOG_SPRUCE_X", LuaValue.valueOf(5)); //
		globals.set("E_META_LOG_SPRUCE_Z", LuaValue.valueOf(9)); //
		globals.set("E_META_NEWLEAVES_ACACIA", LuaValue.valueOf(0)); //
		globals.set("E_META_NEWLEAVES_ACACIA_CHECK_DECAY", LuaValue.valueOf(8)); //
		globals.set("E_META_NEWLEAVES_ACACIA_NO_DECAY", LuaValue.valueOf(4)); //
		globals.set("E_META_NEWLEAVES_DARK_OAK", LuaValue.valueOf(1)); //
		globals.set("E_META_NEWLEAVES_DARK_OAK_CHECK_DECAY", LuaValue.valueOf(9)); //
		globals.set("E_META_NEWLEAVES_DARK_OAK_NO_DECAY", LuaValue.valueOf(5)); //
		globals.set("E_META_NEWLOG_ACACIA_BARK_ONLY", LuaValue.valueOf(12)); //
		globals.set("E_META_NEWLOG_ACACIA_UP_DOWN", LuaValue.valueOf(0)); //
		globals.set("E_META_NEWLOG_ACACIA_X", LuaValue.valueOf(4)); //
		globals.set("E_META_NEWLOG_ACACIA_Z", LuaValue.valueOf(8)); //
		globals.set("E_META_NEWLOG_DARK_OAK_BARK_ONLY", LuaValue.valueOf(13)); //
		globals.set("E_META_NEWLOG_DARK_OAK_UP_DOWN", LuaValue.valueOf(1)); //
		globals.set("E_META_NEWLOG_DARK_OAK_X", LuaValue.valueOf(5)); //
		globals.set("E_META_NEWLOG_DARK_OAK_Z", LuaValue.valueOf(9)); //
		globals.set("E_META_NEW_LOG_ACACIA_WOOD", LuaValue.valueOf(0)); //
		globals.set("E_META_NEW_LOG_DARK_OAK_WOOD", LuaValue.valueOf(1)); //
		globals.set("E_META_PISTON_DOWN", LuaValue.valueOf(0)); //
		globals.set("E_META_PISTON_EXTENDED", LuaValue.valueOf(8)); //
		globals.set("E_META_PISTON_HEAD_STICKY", LuaValue.valueOf(8)); //
		globals.set("E_META_PISTON_U", LuaValue.valueOf(1)); //
		globals.set("E_META_PISTON_XM", LuaValue.valueOf(4)); //
		globals.set("E_META_PISTON_XP", LuaValue.valueOf(5)); //
		globals.set("E_META_PISTON_ZM", LuaValue.valueOf(2)); //
		globals.set("E_META_PISTON_ZP", LuaValue.valueOf(3)); //
		globals.set("E_META_PLANKS_ACACIA", LuaValue.valueOf(4)); //
		globals.set("E_META_PLANKS_BIRCH", LuaValue.valueOf(2)); //
		globals.set("E_META_PLANKS_DARK_OAK", LuaValue.valueOf(5)); //
		globals.set("E_META_PLANKS_JUNGLE", LuaValue.valueOf(3)); //
		globals.set("E_META_PLANKS_OAK", LuaValue.valueOf(0)); //
		globals.set("E_META_PLANKS_SPRUCE", LuaValue.valueOf(1)); //
		globals.set("E_META_PRESSURE_PLATE_DEPRESSED", LuaValue.valueOf(1)); //
		globals.set("E_META_PRESSURE_PLATE_RAISED", LuaValue.valueOf(0)); //
		globals.set("E_META_PRISMARINE_BLOCK_BRICKS", LuaValue.valueOf(1)); //
		globals.set("E_META_PRISMARINE_BLOCK_DARK", LuaValue.valueOf(2)); //
		globals.set("E_META_PRISMARINE_BLOCK_ROUGH", LuaValue.valueOf(0)); //
		globals.set("E_META_QUARTZ_CHISELLED", LuaValue.valueOf(1)); //
		globals.set("E_META_QUARTZ_NORMAL", LuaValue.valueOf(0)); //
		globals.set("E_META_QUARTZ_PILLAR", LuaValue.valueOf(2)); //
		globals.set("E_META_RAIL_ASCEND_XM", LuaValue.valueOf(3)); //
		globals.set("E_META_RAIL_ASCEND_XP", LuaValue.valueOf(2)); //
		globals.set("E_META_RAIL_ASCEND_ZM", LuaValue.valueOf(4)); //
		globals.set("E_META_RAIL_ASCEND_ZP", LuaValue.valueOf(5)); //
		globals.set("E_META_RAIL_CURVED_ZM_XM", LuaValue.valueOf(8)); //
		globals.set("E_META_RAIL_CURVED_ZM_XP", LuaValue.valueOf(9)); //
		globals.set("E_META_RAIL_CURVED_ZP_XM", LuaValue.valueOf(7)); //
		globals.set("E_META_RAIL_CURVED_ZP_XP", LuaValue.valueOf(6)); //
		globals.set("E_META_RAIL_XM_XP", LuaValue.valueOf(1)); //
		globals.set("E_META_RAIL_ZM_ZP", LuaValue.valueOf(0)); //
		globals.set("E_META_RAW_FISH_CLOWNFISH", LuaValue.valueOf(2)); //
		globals.set("E_META_RAW_FISH_FISH", LuaValue.valueOf(0)); //
		globals.set("E_META_RAW_FISH_PUFFERFISH", LuaValue.valueOf(3)); //
		globals.set("E_META_RAW_FISH_SALMON", LuaValue.valueOf(1)); //
		globals.set("E_META_REDSTONE_REPEATER_FACING_MASK", LuaValue.valueOf(3)); // A mask that indicates the bits of
																					// the metadata that specify the
																					// facing of redstone repeaters.
		globals.set("E_META_REDSTONE_REPEATER_FACING_XM", LuaValue.valueOf(3)); // A flag in the metadata of redstone
																				// repeaters that indicates that the
																				// repeater is looking in the negative X
																				// direction.
		globals.set("E_META_REDSTONE_REPEATER_FACING_XP", LuaValue.valueOf(1)); // A flag in the metadata of redstone
																				// repeaters that indicates that the
																				// repeater is looking in the positive X
																				// direction.
		globals.set("E_META_REDSTONE_REPEATER_FACING_ZM", LuaValue.valueOf(0)); // A flag in the metadata of redstone
																				// repeaters that indicates that the
																				// repeater is looking in the negative Z
																				// direction.
		globals.set("E_META_REDSTONE_REPEATER_FACING_ZP", LuaValue.valueOf(2)); // A flag in the metadata of redstone
																				// repeaters that indicates that the
																				// repeater is looking in the positive Z
																				// direction.
		globals.set("E_META_RED_SANDSTONE_NORMAL", LuaValue.valueOf(0)); //
		globals.set("E_META_RED_SANDSTONE_ORNAMENT", LuaValue.valueOf(1)); //
		globals.set("E_META_RED_SANDSTONE_SMOOTH", LuaValue.valueOf(2)); //
		globals.set("E_META_SANDSTONE_NORMAL", LuaValue.valueOf(0)); //
		globals.set("E_META_SANDSTONE_ORNAMENT", LuaValue.valueOf(1)); //
		globals.set("E_META_SANDSTONE_SMOOTH", LuaValue.valueOf(2)); //
		globals.set("E_META_SAND_NORMAL", LuaValue.valueOf(0)); //
		globals.set("E_META_SAND_RED", LuaValue.valueOf(1)); //
		globals.set("E_META_SAPLING_ACACIA", LuaValue.valueOf(4)); //
		globals.set("E_META_SAPLING_APPLE", LuaValue.valueOf(0)); //
		globals.set("E_META_SAPLING_BIRCH", LuaValue.valueOf(2)); //
		globals.set("E_META_SAPLING_CONIFER", LuaValue.valueOf(1)); //
		globals.set("E_META_SAPLING_DARK_OAK", LuaValue.valueOf(5)); //
		globals.set("E_META_SAPLING_JUNGLE", LuaValue.valueOf(3)); //
		globals.set("E_META_SILVERFISH_EGG_CHISELED_STONE_BRICK", LuaValue.valueOf(5)); // A flag in the metadata of the
																						// silverfish egg that the block
																						// is made from chiseled stone
																						// bricks
		globals.set("E_META_SILVERFISH_EGG_COBBLESTONE", LuaValue.valueOf(1)); //
		globals.set("E_META_SILVERFISH_EGG_CRACKED_STONE_BRICK", LuaValue.valueOf(4)); // A flag in the metadata of the
																						// silverfish egg that the block
																						// is made from cracked stone
																						// bricks
		globals.set("E_META_SILVERFISH_EGG_MOSSY_STONE_BRICK", LuaValue.valueOf(3)); // A flag in the metadata of the
																						// silverfish egg that the block
																						// is made from mossy stone
																						// bricks
		globals.set("E_META_SILVERFISH_EGG_STONE", LuaValue.valueOf(0)); //
		globals.set("E_META_SILVERFISH_EGG_STONE_BRICK", LuaValue.valueOf(2)); //
		globals.set("E_META_SNOW_LAYER_EIGHT", LuaValue.valueOf(7)); //
		globals.set("E_META_SNOW_LAYER_FIVE", LuaValue.valueOf(4)); //
		globals.set("E_META_SNOW_LAYER_FOUR", LuaValue.valueOf(3)); //
		globals.set("E_META_SNOW_LAYER_ONE", LuaValue.valueOf(0)); //
		globals.set("E_META_SNOW_LAYER_SEVEN", LuaValue.valueOf(6)); //
		globals.set("E_META_SNOW_LAYER_SIX", LuaValue.valueOf(5)); //
		globals.set("E_META_SNOW_LAYER_THREE", LuaValue.valueOf(2)); //
		globals.set("E_META_SNOW_LAYER_TWO", LuaValue.valueOf(1)); //
		globals.set("E_META_SPAWN_EGG_ARROW", LuaValue.valueOf(10)); //
		globals.set("E_META_SPAWN_EGG_BAT", LuaValue.valueOf(65)); //
		globals.set("E_META_SPAWN_EGG_BLAZE", LuaValue.valueOf(61)); //
		globals.set("E_META_SPAWN_EGG_BOAT", LuaValue.valueOf(41)); //
		globals.set("E_META_SPAWN_EGG_CAVE_SPIDER", LuaValue.valueOf(59)); //
		globals.set("E_META_SPAWN_EGG_CHICKEN", LuaValue.valueOf(93)); //
		globals.set("E_META_SPAWN_EGG_COW", LuaValue.valueOf(92)); //
		globals.set("E_META_SPAWN_EGG_CREEPER", LuaValue.valueOf(50)); //
		globals.set("E_META_SPAWN_EGG_ENDERMAN", LuaValue.valueOf(58)); //
		globals.set("E_META_SPAWN_EGG_ENDER_CRYSTAL", LuaValue.valueOf(200)); //
		globals.set("E_META_SPAWN_EGG_ENDER_DRAGON", LuaValue.valueOf(63)); //
		globals.set("E_META_SPAWN_EGG_ENDER_PEARL", LuaValue.valueOf(14)); //
		globals.set("E_META_SPAWN_EGG_EXPERIENCE_ORB", LuaValue.valueOf(2)); //
		globals.set("E_META_SPAWN_EGG_EXP_BOTTLE", LuaValue.valueOf(17)); //
		globals.set("E_META_SPAWN_EGG_EYE_OF_ENDER", LuaValue.valueOf(15)); //
		globals.set("E_META_SPAWN_EGG_FALLING_BLOCK", LuaValue.valueOf(21)); //
		globals.set("E_META_SPAWN_EGG_FIREBALL", LuaValue.valueOf(12)); //
		globals.set("E_META_SPAWN_EGG_FIREWORK", LuaValue.valueOf(22)); //
		globals.set("E_META_SPAWN_EGG_GHAST", LuaValue.valueOf(56)); //
		globals.set("E_META_SPAWN_EGG_GIANT", LuaValue.valueOf(53)); //
		globals.set("E_META_SPAWN_EGG_GUARDIAN", LuaValue.valueOf(68)); //
		globals.set("E_META_SPAWN_EGG_HORSE", LuaValue.valueOf(100)); //
		globals.set("E_META_SPAWN_EGG_IRON_GOLEM", LuaValue.valueOf(99)); //
		globals.set("E_META_SPAWN_EGG_ITEM_FRAME", LuaValue.valueOf(18)); //
		globals.set("E_META_SPAWN_EGG_LEASH_KNOT", LuaValue.valueOf(8)); //
		globals.set("E_META_SPAWN_EGG_MAGMA_CUBE", LuaValue.valueOf(62)); //
		globals.set("E_META_SPAWN_EGG_MINECART", LuaValue.valueOf(42)); //
		globals.set("E_META_SPAWN_EGG_MINECART_CHEST", LuaValue.valueOf(43)); //
		globals.set("E_META_SPAWN_EGG_MINECART_FURNACE", LuaValue.valueOf(44)); //
		globals.set("E_META_SPAWN_EGG_MINECART_HOPPER", LuaValue.valueOf(46)); //
		globals.set("E_META_SPAWN_EGG_MINECART_SPAWNER", LuaValue.valueOf(47)); //
		globals.set("E_META_SPAWN_EGG_MINECART_TNT", LuaValue.valueOf(45)); //
		globals.set("E_META_SPAWN_EGG_MOOSHROOM", LuaValue.valueOf(96)); //
		globals.set("E_META_SPAWN_EGG_OCELOT", LuaValue.valueOf(98)); //
		globals.set("E_META_SPAWN_EGG_PAINTING", LuaValue.valueOf(9)); //
		globals.set("E_META_SPAWN_EGG_PICKUP", LuaValue.valueOf(1)); //
		globals.set("E_META_SPAWN_EGG_PIG", LuaValue.valueOf(90)); //
		globals.set("E_META_SPAWN_EGG_PRIMED_TNT", LuaValue.valueOf(20)); //
		globals.set("E_META_SPAWN_EGG_RABBIT", LuaValue.valueOf(101)); //
		globals.set("E_META_SPAWN_EGG_SHEEP", LuaValue.valueOf(91)); //
		globals.set("E_META_SPAWN_EGG_SILVERFISH", LuaValue.valueOf(60)); //
		globals.set("E_META_SPAWN_EGG_SKELETON", LuaValue.valueOf(51)); //
		globals.set("E_META_SPAWN_EGG_SLIME", LuaValue.valueOf(55)); //
		globals.set("E_META_SPAWN_EGG_SMALL_FIREBALL", LuaValue.valueOf(13)); //
		globals.set("E_META_SPAWN_EGG_SNOWBALL", LuaValue.valueOf(11)); //
		globals.set("E_META_SPAWN_EGG_SNOW_GOLEM", LuaValue.valueOf(97)); //
		globals.set("E_META_SPAWN_EGG_SPIDER", LuaValue.valueOf(52)); //
		globals.set("E_META_SPAWN_EGG_SPLASH_POTION", LuaValue.valueOf(16)); //
		globals.set("E_META_SPAWN_EGG_SQUID", LuaValue.valueOf(94)); //
		globals.set("E_META_SPAWN_EGG_VILLAGER", LuaValue.valueOf(120)); //
		globals.set("E_META_SPAWN_EGG_WITCH", LuaValue.valueOf(66)); //
		globals.set("E_META_SPAWN_EGG_WITHER", LuaValue.valueOf(64)); //
		globals.set("E_META_SPAWN_EGG_WITHER_SKELETON", LuaValue.valueOf(5)); //
		globals.set("E_META_SPAWN_EGG_WITHER_SKULL", LuaValue.valueOf(19)); //
		globals.set("E_META_SPAWN_EGG_WOLF", LuaValue.valueOf(95)); //
		globals.set("E_META_SPAWN_EGG_ZOMBIE", LuaValue.valueOf(54)); //
		globals.set("E_META_SPAWN_EGG_ZOMBIE_PIGMAN", LuaValue.valueOf(57)); //
		globals.set("E_META_SPAWN_EGG_ZOMBIE_VILLAGER", LuaValue.valueOf(27)); //
		globals.set("E_META_SPONGE_DRY", LuaValue.valueOf(0)); // A flag in the metadata of sponges that indicates that
																// the sponge is dry.
		globals.set("E_META_SPONGE_WET", LuaValue.valueOf(1)); // A flag in the metadata of sponges that indicates that
																// the sponge is wet.
		globals.set("E_META_STAINED_CLAY_BLACK", LuaValue.valueOf(15)); //
		globals.set("E_META_STAINED_CLAY_BLUE", LuaValue.valueOf(11)); //
		globals.set("E_META_STAINED_CLAY_BROWN", LuaValue.valueOf(12)); //
		globals.set("E_META_STAINED_CLAY_CYAN", LuaValue.valueOf(9)); //
		globals.set("E_META_STAINED_CLAY_GRAY", LuaValue.valueOf(7)); //
		globals.set("E_META_STAINED_CLAY_GREEN", LuaValue.valueOf(13)); //
		globals.set("E_META_STAINED_CLAY_LIGHTBLUE", LuaValue.valueOf(3)); //
		globals.set("E_META_STAINED_CLAY_LIGHTGRAY", LuaValue.valueOf(8)); //
		globals.set("E_META_STAINED_CLAY_LIGHTGREEN", LuaValue.valueOf(5)); //
		globals.set("E_META_STAINED_CLAY_MAGENTA", LuaValue.valueOf(2)); //
		globals.set("E_META_STAINED_CLAY_ORANGE", LuaValue.valueOf(1)); //
		globals.set("E_META_STAINED_CLAY_PINK", LuaValue.valueOf(6)); //
		globals.set("E_META_STAINED_CLAY_PURPLE", LuaValue.valueOf(10)); //
		globals.set("E_META_STAINED_CLAY_RED", LuaValue.valueOf(14)); //
		globals.set("E_META_STAINED_CLAY_WHITE", LuaValue.valueOf(0)); //
		globals.set("E_META_STAINED_CLAY_YELLOW", LuaValue.valueOf(4)); //
		globals.set("E_META_STAINED_GLASS_BLACK", LuaValue.valueOf(15)); //
		globals.set("E_META_STAINED_GLASS_BLUE", LuaValue.valueOf(11)); //
		globals.set("E_META_STAINED_GLASS_BROWN", LuaValue.valueOf(12)); //
		globals.set("E_META_STAINED_GLASS_CYAN", LuaValue.valueOf(9)); //
		globals.set("E_META_STAINED_GLASS_GRAY", LuaValue.valueOf(7)); //
		globals.set("E_META_STAINED_GLASS_GREEN", LuaValue.valueOf(13)); //
		globals.set("E_META_STAINED_GLASS_LIGHTBLUE", LuaValue.valueOf(3)); //
		globals.set("E_META_STAINED_GLASS_LIGHTGRAY", LuaValue.valueOf(8)); //
		globals.set("E_META_STAINED_GLASS_LIGHTGREEN", LuaValue.valueOf(5)); //
		globals.set("E_META_STAINED_GLASS_MAGENTA", LuaValue.valueOf(2)); //
		globals.set("E_META_STAINED_GLASS_ORANGE", LuaValue.valueOf(1)); //
		globals.set("E_META_STAINED_GLASS_PANE_BLACK", LuaValue.valueOf(15)); //
		globals.set("E_META_STAINED_GLASS_PANE_BLUE", LuaValue.valueOf(11)); //
		globals.set("E_META_STAINED_GLASS_PANE_BROWN", LuaValue.valueOf(12)); //
		globals.set("E_META_STAINED_GLASS_PANE_CYAN", LuaValue.valueOf(9)); //
		globals.set("E_META_STAINED_GLASS_PANE_GRAY", LuaValue.valueOf(7)); //
		globals.set("E_META_STAINED_GLASS_PANE_GREEN", LuaValue.valueOf(13)); //
		globals.set("E_META_STAINED_GLASS_PANE_LIGHTBLUE", LuaValue.valueOf(3)); //
		globals.set("E_META_STAINED_GLASS_PANE_LIGHTGRAY", LuaValue.valueOf(8)); //
		globals.set("E_META_STAINED_GLASS_PANE_LIGHTGREEN", LuaValue.valueOf(5)); //
		globals.set("E_META_STAINED_GLASS_PANE_MAGENTA", LuaValue.valueOf(2)); //
		globals.set("E_META_STAINED_GLASS_PANE_ORANGE", LuaValue.valueOf(1)); //
		globals.set("E_META_STAINED_GLASS_PANE_PINK", LuaValue.valueOf(6)); //
		globals.set("E_META_STAINED_GLASS_PANE_PURPLE", LuaValue.valueOf(10)); //
		globals.set("E_META_STAINED_GLASS_PANE_RED", LuaValue.valueOf(14)); //
		globals.set("E_META_STAINED_GLASS_PANE_WHITE", LuaValue.valueOf(0)); //
		globals.set("E_META_STAINED_GLASS_PANE_YELLOW", LuaValue.valueOf(4)); //
		globals.set("E_META_STAINED_GLASS_PINK", LuaValue.valueOf(6)); //
		globals.set("E_META_STAINED_GLASS_PURPLE", LuaValue.valueOf(10)); //
		globals.set("E_META_STAINED_GLASS_RED", LuaValue.valueOf(14)); //
		globals.set("E_META_STAINED_GLASS_WHITE", LuaValue.valueOf(0)); //
		globals.set("E_META_STAINED_GLASS_YELLOW", LuaValue.valueOf(4)); //
		globals.set("E_META_STONE_ANDESITE", LuaValue.valueOf(5)); //
		globals.set("E_META_STONE_BRICK_CRACKED", LuaValue.valueOf(2)); //
		globals.set("E_META_STONE_BRICK_MOSSY", LuaValue.valueOf(1)); //
		globals.set("E_META_STONE_BRICK_NORMAL", LuaValue.valueOf(0)); //
		globals.set("E_META_STONE_BRICK_ORNAMENT", LuaValue.valueOf(3)); //
		globals.set("E_META_STONE_DIORITE", LuaValue.valueOf(3)); //
		globals.set("E_META_STONE_GRANITE", LuaValue.valueOf(1)); //
		globals.set("E_META_STONE_POLISHED_ANDESITE", LuaValue.valueOf(6)); //
		globals.set("E_META_STONE_POLISHED_DIORITE", LuaValue.valueOf(4)); //
		globals.set("E_META_STONE_POLISHED_GRANITE", LuaValue.valueOf(2)); //
		globals.set("E_META_STONE_SLAB_BRICK", LuaValue.valueOf(4)); //
		globals.set("E_META_STONE_SLAB_COBBLESTONE", LuaValue.valueOf(3)); //
		globals.set("E_META_STONE_SLAB_NETHER_BRICK", LuaValue.valueOf(6)); //
		globals.set("E_META_STONE_SLAB_PLANKS", LuaValue.valueOf(2)); //
		globals.set("E_META_STONE_SLAB_QUARTZ", LuaValue.valueOf(7)); //
		globals.set("E_META_STONE_SLAB_SANDSTONE", LuaValue.valueOf(1)); //
		globals.set("E_META_STONE_SLAB_STONE", LuaValue.valueOf(0)); //
		globals.set("E_META_STONE_SLAB_STONE_BRICK", LuaValue.valueOf(5)); //
		globals.set("E_META_STONE_STONE", LuaValue.valueOf(0)); //
		globals.set("E_META_TALL_GRASS_BIOME", LuaValue.valueOf(3)); //
		globals.set("E_META_TALL_GRASS_DEAD_SHRUB", LuaValue.valueOf(0)); //
		globals.set("E_META_TALL_GRASS_FERN", LuaValue.valueOf(2)); //
		globals.set("E_META_TALL_GRASS_GRASS", LuaValue.valueOf(1)); //
		globals.set("E_META_TORCH_EAST", LuaValue.valueOf(1)); //
		globals.set("E_META_TORCH_FLOOR", LuaValue.valueOf(5)); //
		globals.set("E_META_TORCH_NORTH", LuaValue.valueOf(4)); //
		globals.set("E_META_TORCH_SOUTH", LuaValue.valueOf(3)); //
		globals.set("E_META_TORCH_WEST", LuaValue.valueOf(2)); //
		globals.set("E_META_TORCH_XM", LuaValue.valueOf(1)); //
		globals.set("E_META_TORCH_XP", LuaValue.valueOf(2)); //
		globals.set("E_META_TORCH_ZM", LuaValue.valueOf(3)); //
		globals.set("E_META_TORCH_ZP", LuaValue.valueOf(4)); //
		globals.set("E_META_TRACKS_X", LuaValue.valueOf(1)); //
		globals.set("E_META_TRACKS_Z", LuaValue.valueOf(0)); //
		globals.set("E_META_WOODEN_DOUBLE_SLAB_ACACIA", LuaValue.valueOf(4)); //
		globals.set("E_META_WOODEN_DOUBLE_SLAB_BIRCH", LuaValue.valueOf(2)); //
		globals.set("E_META_WOODEN_DOUBLE_SLAB_DARK_OAK", LuaValue.valueOf(5)); //
		globals.set("E_META_WOODEN_DOUBLE_SLAB_JUNGLE", LuaValue.valueOf(3)); //
		globals.set("E_META_WOODEN_DOUBLE_SLAB_OAK", LuaValue.valueOf(0)); //
		globals.set("E_META_WOODEN_DOUBLE_SLAB_SPRUCE", LuaValue.valueOf(1)); //
		globals.set("E_META_WOODEN_SLAB_ACACIA", LuaValue.valueOf(4)); //
		globals.set("E_META_WOODEN_SLAB_BIRCH", LuaValue.valueOf(2)); //
		globals.set("E_META_WOODEN_SLAB_DARK_OAK", LuaValue.valueOf(5)); //
		globals.set("E_META_WOODEN_SLAB_JUNGLE", LuaValue.valueOf(3)); //
		globals.set("E_META_WOODEN_SLAB_OAK", LuaValue.valueOf(0)); //
		globals.set("E_META_WOODEN_SLAB_SPRUCE", LuaValue.valueOf(1)); //
		globals.set("E_META_WOODEN_SLAB_UPSIDE_DOWN", LuaValue.valueOf(8)); //
		globals.set("E_META_WOOL_BLACK", LuaValue.valueOf(15)); //
		globals.set("E_META_WOOL_BLUE", LuaValue.valueOf(11)); //
		globals.set("E_META_WOOL_BROWN", LuaValue.valueOf(12)); //
		globals.set("E_META_WOOL_CYAN", LuaValue.valueOf(9)); //
		globals.set("E_META_WOOL_GRAY", LuaValue.valueOf(7)); //
		globals.set("E_META_WOOL_GREEN", LuaValue.valueOf(13)); //
		globals.set("E_META_WOOL_LIGHTBLUE", LuaValue.valueOf(3)); //
		globals.set("E_META_WOOL_LIGHTGRAY", LuaValue.valueOf(8)); //
		globals.set("E_META_WOOL_LIGHTGREEN", LuaValue.valueOf(5)); //
		globals.set("E_META_WOOL_MAGENTA", LuaValue.valueOf(2)); //
		globals.set("E_META_WOOL_ORANGE", LuaValue.valueOf(1)); //
		globals.set("E_META_WOOL_PINK", LuaValue.valueOf(6)); //
		globals.set("E_META_WOOL_PURPLE", LuaValue.valueOf(10)); //
		globals.set("E_META_WOOL_RED", LuaValue.valueOf(14)); //
		globals.set("E_META_WOOL_WHITE", LuaValue.valueOf(0)); //
		globals.set("E_META_WOOL_YELLOW", LuaValue.valueOf(4)); //
		globals.set("caCtrlDropKey", LuaValue.valueOf(15)); // Drop a full stack
		globals.set("caDblClick", LuaValue.valueOf(29)); // Double click action
		globals.set("caDropKey", LuaValue.valueOf(14)); // Drop a single item
		globals.set("caLeftClick", LuaValue.valueOf(0)); // Left click on a slot
		globals.set("caLeftClickOutside", LuaValue.valueOf(16)); // Left click outside of inventory
		globals.set("caLeftClickOutsideHoldNothing", LuaValue.valueOf(18)); // Left click outside inventory holding
																			// nothing
		globals.set("caLeftPaintBegin", LuaValue.valueOf(20)); // Begining of left click paint drag action
		globals.set("caLeftPaintEnd", LuaValue.valueOf(26)); // End of left click paint drag action
		globals.set("caLeftPaintProgress", LuaValue.valueOf(23)); // Add slot for left click paint drag action
		globals.set("caMiddleClick", LuaValue.valueOf(13)); // Middle click, only valid for creative players
		globals.set("caMiddlePaintBegin", LuaValue.valueOf(22)); // Begining of middle click paint drag action, only
																	// valid for creative players
		globals.set("caMiddlePaintEnd", LuaValue.valueOf(28)); // End of middle click paint drag action, only valid for
																// creative players
		globals.set("caMiddlePaintProgress", LuaValue.valueOf(25)); // Add slot for middle click paint drag action, only
																	// valid for creative players
		globals.set("caNumber1", LuaValue.valueOf(4)); // Number key 1
		globals.set("caNumber2", LuaValue.valueOf(5)); // Number key 2
		globals.set("caNumber3", LuaValue.valueOf(6)); // Number key 3
		globals.set("caNumber4", LuaValue.valueOf(7)); // Number key 4
		globals.set("caNumber5", LuaValue.valueOf(8)); // Number key 5
		globals.set("caNumber6", LuaValue.valueOf(9)); // Number key 6
		globals.set("caNumber7", LuaValue.valueOf(10)); // Number key 7
		globals.set("caNumber8", LuaValue.valueOf(11)); // Number key 8
		globals.set("caNumber9", LuaValue.valueOf(12)); // Number key 9
		globals.set("caRightClick", LuaValue.valueOf(1)); // Right click on a slot
		globals.set("caRightClickOutside", LuaValue.valueOf(17)); // Right click outside of inventory
		globals.set("caRightClickOutsideHoldNothing", LuaValue.valueOf(19)); // Right click outside inventory holding
																				// nothing
		globals.set("caRightPaintBegin", LuaValue.valueOf(21)); // Begining of right click paint drag action
		globals.set("caRightPaintEnd", LuaValue.valueOf(27)); // End of right click paint drag action
		globals.set("caRightPaintProgress", LuaValue.valueOf(24)); // Add slot for right click paint drag action
		globals.set("caShiftLeftClick", LuaValue.valueOf(2)); // Shift + left click on a slot
		globals.set("caShiftRightClick", LuaValue.valueOf(3)); // Shift + right click on a slot
		globals.set("caUnknown", LuaValue.valueOf(255)); // Unknown click action
		globals.set("SKULL_TYPE_CREEPER", LuaValue.valueOf(4)); // A creeper skull
		globals.set("SKULL_TYPE_DRAGON", LuaValue.valueOf(5)); // A dragon skull
		globals.set("SKULL_TYPE_PLAYER", LuaValue.valueOf(3)); // A player skull
		globals.set("SKULL_TYPE_SKELETON", LuaValue.valueOf(0)); // A skeleton skull
		globals.set("SKULL_TYPE_WITHER", LuaValue.valueOf(1)); // A wither skull
		globals.set("SKULL_TYPE_ZOMBIE", LuaValue.valueOf(2)); // A zombie skull
		globals.set("dimEnd", LuaValue.valueOf(1)); //
		globals.set("dimNether", LuaValue.valueOf(-1)); //
		globals.set("dimNotSet", LuaValue.valueOf(255)); //
		globals.set("dimOverworld", LuaValue.valueOf(0)); //
		globals.set("dtAdmin", LuaValue.valueOf(16)); // Damage applied by an admin command
		globals.set("dtArrow", LuaValue.valueOf(1)); // Damage received by being attacked by a projectile, possibly from
														// a mob
		globals.set("dtArrowAttack", LuaValue.valueOf(1)); // Damage received by being attacked by a projectile,
															// possibly from a mob
		globals.set("dtAttack", LuaValue.valueOf(0)); // Damage recieved by being attacked by a mob
		globals.set("dtBurning", LuaValue.valueOf(11)); // Damage from being on fire
		globals.set("dtCacti", LuaValue.valueOf(7)); // Damage from contact with a cactus block
		globals.set("dtCactus", LuaValue.valueOf(7)); // Damage from contact with a cactus block
		globals.set("dtCactusContact", LuaValue.valueOf(7)); // Damage from contact with a cactus block
		globals.set("dtCactuses", LuaValue.valueOf(7)); // Damage from contact with a cactus block
		globals.set("dtDrown", LuaValue.valueOf(4)); // Damage received by drowning in water / lava
		globals.set("dtDrowning", LuaValue.valueOf(4)); // Damage received by drowning in water / lava
		globals.set("dtEnderPearl", LuaValue.valueOf(15)); // Damage received by throwing an ender pearl and being
															// teleported by it
		globals.set("dtEntityAttack", LuaValue.valueOf(0)); // Damage recieved by being attacked by a mob
		globals.set("dtEnvironment", LuaValue.valueOf(18)); // Damage dealt to mobs from environment: enderman in rain,
															// snow golem in desert
		globals.set("dtExplosion", LuaValue.valueOf(17)); // Damage applied by an explosion
		globals.set("dtFall", LuaValue.valueOf(3)); // Damage from falling down. Dealt when hitting the ground
		globals.set("dtFalling", LuaValue.valueOf(3)); // Damage from falling down. Dealt when hitting the ground
		globals.set("dtFireContact", LuaValue.valueOf(12)); // Damage received by standing inside a fire block
		globals.set("dtHunger", LuaValue.valueOf(6)); // Damage received from hunger
		globals.set("dtInFire", LuaValue.valueOf(12)); // Damage received by standing inside a fire block
		globals.set("dtInVoid", LuaValue.valueOf(13)); // Damage received by falling into the Void (Y < 0)
		globals.set("dtLava", LuaValue.valueOf(8)); // Damage received by a contact with a lava block
		globals.set("dtLavaContact", LuaValue.valueOf(8)); // Damage received by a contact with a lava block
		globals.set("dtLightning", LuaValue.valueOf(2)); // Damage from being hit by a lightning strike
		globals.set("dtMob", LuaValue.valueOf(0)); // Damage received by being attacked by a mob
		globals.set("dtMobAttack", LuaValue.valueOf(0)); // Damage received by being attacked by a mob
		globals.set("dtOnFire", LuaValue.valueOf(11)); // Damage from being on fire
		globals.set("dtPawnAttack", LuaValue.valueOf(0)); // Damage received by being attacked by a mob
		globals.set("dtPlugin", LuaValue.valueOf(16)); // Damage applied by an admin command
		globals.set("dtPoison", LuaValue.valueOf(9)); // Damage applied by the poison effect
		globals.set("dtPoisoning", LuaValue.valueOf(9)); // Damage applied by the poison effect
		globals.set("dtPotionOfHarming", LuaValue.valueOf(14)); // Damage applied by the potion of harming
		globals.set("dtProjectile", LuaValue.valueOf(1)); // Damage received by being attacked by a projectile, possibly
															// from a mob
		globals.set("dtRangedAttack", LuaValue.valueOf(1)); // Damage received by being attacked by a projectile,
															// possibly from a mob
		globals.set("dtStarvation", LuaValue.valueOf(6)); // Damage received from hunger
		globals.set("dtStarving", LuaValue.valueOf(6)); // Damage received from hunger
		globals.set("dtSuffocating", LuaValue.valueOf(5)); // Damage from suffocating inside a block
		globals.set("dtSuffocation", LuaValue.valueOf(5)); // Damage from suffocating inside a block
		globals.set("dtWither", LuaValue.valueOf(10)); // Damage from the wither effect
		globals.set("dtWithering", LuaValue.valueOf(10)); // Damage from the wither effect
		globals.set("eGameMode_Adventure", LuaValue.valueOf(2)); //
		globals.set("eGameMode_Creative", LuaValue.valueOf(1)); //
		globals.set("eGameMode_NotSet", LuaValue.valueOf(-1)); //
		globals.set("eGameMode_Spectator", LuaValue.valueOf(3)); //
		globals.set("eGameMode_Survival", LuaValue.valueOf(0)); //
		globals.set("gmAdventure", LuaValue.valueOf(2)); //
		globals.set("gmCreative", LuaValue.valueOf(1)); //
		globals.set("gmMax", LuaValue.valueOf(4)); //
		globals.set("gmMin", LuaValue.valueOf(0)); //
		globals.set("gmNotSet", LuaValue.valueOf(-1)); //
		globals.set("gmSpectator", LuaValue.valueOf(3)); //
		globals.set("gmSurvival", LuaValue.valueOf(0)); //
		globals.set("biBeach", LuaValue.valueOf(16)); //
		globals.set("biBirchForest", LuaValue.valueOf(27)); //
		globals.set("biBirchForestHills", LuaValue.valueOf(28)); //
		globals.set("biBirchForestHillsM", LuaValue.valueOf(156)); //
		globals.set("biBirchForestM", LuaValue.valueOf(155)); //
		globals.set("biColdBeach", LuaValue.valueOf(26)); //
		globals.set("biColdTaiga", LuaValue.valueOf(30)); //
		globals.set("biColdTaigaHills", LuaValue.valueOf(31)); //
		globals.set("biColdTaigaM", LuaValue.valueOf(158)); //
		globals.set("biDeepOcean", LuaValue.valueOf(24)); //
		globals.set("biDesert", LuaValue.valueOf(2)); //
		globals.set("biDesertHills", LuaValue.valueOf(17)); //
		globals.set("biDesertM", LuaValue.valueOf(130)); //
		globals.set("biEnd", LuaValue.valueOf(9)); //
		globals.set("biExtremeHills", LuaValue.valueOf(3)); //
		globals.set("biExtremeHillsEdge", LuaValue.valueOf(20)); //
		globals.set("biExtremeHillsM", LuaValue.valueOf(131)); //
		globals.set("biExtremeHillsPlus", LuaValue.valueOf(34)); //
		globals.set("biExtremeHillsPlusM", LuaValue.valueOf(162)); //
		globals.set("biFirstBiome", LuaValue.valueOf(0)); //
		globals.set("biFirstVariantBiome", LuaValue.valueOf(129)); //
		globals.set("biFlowerForest", LuaValue.valueOf(132)); //
		globals.set("biForest", LuaValue.valueOf(4)); //
		globals.set("biForestHills", LuaValue.valueOf(18)); //
		globals.set("biFrozenOcean", LuaValue.valueOf(10)); //
		globals.set("biFrozenRiver", LuaValue.valueOf(11)); //
		globals.set("biHell", LuaValue.valueOf(8)); //
		globals.set("biIceMountains", LuaValue.valueOf(13)); //
		globals.set("biIcePlains", LuaValue.valueOf(12)); //
		globals.set("biIcePlainsSpikes", LuaValue.valueOf(140)); //
		globals.set("biInvalidBiome", LuaValue.valueOf(-1)); //
		globals.set("biJungle", LuaValue.valueOf(21)); //
		globals.set("biJungleEdge", LuaValue.valueOf(23)); //
		globals.set("biJungleEdgeM", LuaValue.valueOf(151)); //
		globals.set("biJungleHills", LuaValue.valueOf(22)); //
		globals.set("biJungleM", LuaValue.valueOf(149)); //
		globals.set("biMaxBiome", LuaValue.valueOf(39)); //
		globals.set("biMaxVariantBiome", LuaValue.valueOf(167)); //
		globals.set("biMegaSpruceTaiga", LuaValue.valueOf(160)); //
		globals.set("biMegaSpruceTaigaHills", LuaValue.valueOf(161)); //
		globals.set("biMegaTaiga", LuaValue.valueOf(32)); //
		globals.set("biMegaTaigaHills", LuaValue.valueOf(33)); //
		globals.set("biMesa", LuaValue.valueOf(37)); //
		globals.set("biMesaBryce", LuaValue.valueOf(165)); //
		globals.set("biMesaPlateau", LuaValue.valueOf(39)); //
		globals.set("biMesaPlateauF", LuaValue.valueOf(38)); //
		globals.set("biMesaPlateauFM", LuaValue.valueOf(166)); //
		globals.set("biMesaPlateauM", LuaValue.valueOf(167)); //
		globals.set("biMushroomIsland", LuaValue.valueOf(14)); //
		globals.set("biMushroomShore", LuaValue.valueOf(15)); //
		globals.set("biNether", LuaValue.valueOf(8)); //
		globals.set("biNumBiomes", LuaValue.valueOf(40)); //
		globals.set("biNumVariantBiomes", LuaValue.valueOf(168)); //
		globals.set("biOcean", LuaValue.valueOf(0)); //
		globals.set("biPlains", LuaValue.valueOf(1)); //
		globals.set("biRiver", LuaValue.valueOf(7)); //
		globals.set("biRoofedForest", LuaValue.valueOf(29)); //
		globals.set("biRoofedForestM", LuaValue.valueOf(157)); //
		globals.set("biSavanna", LuaValue.valueOf(35)); //
		globals.set("biSavannaM", LuaValue.valueOf(163)); //
		globals.set("biSavannaPlateau", LuaValue.valueOf(36)); //
		globals.set("biSavannaPlateauM", LuaValue.valueOf(164)); //
		globals.set("biSky", LuaValue.valueOf(9)); //
		globals.set("biStoneBeach", LuaValue.valueOf(25)); //
		globals.set("biSunflowerPlains", LuaValue.valueOf(129)); //
		globals.set("biSwampland", LuaValue.valueOf(6)); //
		globals.set("biSwamplandM", LuaValue.valueOf(134)); //
		globals.set("biTaiga", LuaValue.valueOf(5)); //
		globals.set("biTaigaHills", LuaValue.valueOf(19)); //
		globals.set("biTaigaM", LuaValue.valueOf(133)); //
		globals.set("biTundra", LuaValue.valueOf(12)); //
		globals.set("biVariant", LuaValue.valueOf(128)); //
		globals.set("E_BLOCK_ACACIA_DOOR", LuaValue.valueOf(196)); // The blocktype for acacia door
		globals.set("E_BLOCK_ACACIA_FENCE", LuaValue.valueOf(192)); // The blocktype for acacia fence
		globals.set("E_BLOCK_ACACIA_FENCE_GATE", LuaValue.valueOf(187)); // The blocktype for acacia fence gate
		globals.set("E_BLOCK_ACACIA_WOOD_STAIRS", LuaValue.valueOf(163)); // The blocktype for acacia wood stairs
		globals.set("E_BLOCK_ACTIVATOR_RAIL", LuaValue.valueOf(157)); // The blocktype for activator rail
		globals.set("E_BLOCK_ACTIVE_COMPARATOR", LuaValue.valueOf(150)); // The blocktype for active comparator
		globals.set("E_BLOCK_AIR", LuaValue.valueOf(0)); // The blocktype for air
		globals.set("E_BLOCK_ANVIL", LuaValue.valueOf(145)); // The blocktype for anvil
		globals.set("E_BLOCK_ANVIL_HIGH_DAMAGE", LuaValue.valueOf(8)); // The blocktype for anvil high damage
		globals.set("E_BLOCK_ANVIL_LOW_DAMAGE", LuaValue.valueOf(4)); // The blocktype for anvil low damage
		globals.set("E_BLOCK_ANVIL_NO_DAMAGE", LuaValue.valueOf(0)); // The blocktype for anvil no damage
		globals.set("E_BLOCK_ANVIL_X", LuaValue.valueOf(1)); // The blocktype for anvil x
		globals.set("E_BLOCK_ANVIL_Z", LuaValue.valueOf(0)); // The blocktype for anvil z
		globals.set("E_BLOCK_BARRIER", LuaValue.valueOf(166)); // The blocktype for barrier
		globals.set("E_BLOCK_BEACON", LuaValue.valueOf(138)); // The blocktype for beacon
		globals.set("E_BLOCK_BED", LuaValue.valueOf(26)); // The blocktype for bed
		globals.set("E_BLOCK_BEDROCK", LuaValue.valueOf(7)); // The blocktype for bedrock
		globals.set("E_BLOCK_BED_BED_HEAD", LuaValue.valueOf(8)); // The blocktype for bed bed head
		globals.set("E_BLOCK_BED_OCCUPIED", LuaValue.valueOf(4)); // The blocktype for bed occupied
		globals.set("E_BLOCK_BED_XM", LuaValue.valueOf(1)); // The blocktype for bed xm
		globals.set("E_BLOCK_BED_XP", LuaValue.valueOf(3)); // The blocktype for bed xp
		globals.set("E_BLOCK_BED_ZM", LuaValue.valueOf(2)); // The blocktype for bed zm
		globals.set("E_BLOCK_BED_ZP", LuaValue.valueOf(0)); // The blocktype for bed zp
		globals.set("E_BLOCK_BEETROOTS", LuaValue.valueOf(207)); // The blocktype for beetroots
		globals.set("E_BLOCK_BIG_FLOWER", LuaValue.valueOf(175)); // The blocktype for big flower
		globals.set("E_BLOCK_BIRCH_DOOR", LuaValue.valueOf(194)); // The blocktype for birch door
		globals.set("E_BLOCK_BIRCH_FENCE", LuaValue.valueOf(189)); // The blocktype for birch fence
		globals.set("E_BLOCK_BIRCH_FENCE_GATE", LuaValue.valueOf(184)); // The blocktype for birch fence gate
		globals.set("E_BLOCK_BIRCH_WOOD_STAIRS", LuaValue.valueOf(135)); // The blocktype for birch wood stairs
		globals.set("E_BLOCK_BLACK_GLAZED_TERRACOTTA", LuaValue.valueOf(250)); // The blocktype for black terracotta
		globals.set("E_BLOCK_BLACK_SHULKER_BOX", LuaValue.valueOf(234)); // The blocktype for black shulker box
		globals.set("E_BLOCK_BLOCK_OF_COAL", LuaValue.valueOf(173)); // The blocktype for block of coal
		globals.set("E_BLOCK_BLOCK_OF_REDSTONE", LuaValue.valueOf(152)); // The blocktype for block of redstone
		globals.set("E_BLOCK_BLUE_GLAZED_TERRACOTTA", LuaValue.valueOf(246)); // The blocktype for blue glazed
																				// terracotta
		globals.set("E_BLOCK_BLUE_SHULKER_BOX", LuaValue.valueOf(230)); // The blocktype for blue shulker box
		globals.set("E_BLOCK_BONE_BLOCK", LuaValue.valueOf(216)); // The blocktype for bone block
		globals.set("E_BLOCK_BOOKCASE", LuaValue.valueOf(47)); // The blocktype for bookcase
		globals.set("E_BLOCK_BREWING_STAND", LuaValue.valueOf(117)); // The blocktype for brewing stand
		globals.set("E_BLOCK_BRICK", LuaValue.valueOf(45)); // The blocktype for brick
		globals.set("E_BLOCK_BRICK_STAIRS", LuaValue.valueOf(108)); // The blocktype for brick stairs
		globals.set("E_BLOCK_BROWN_GLAZED_TERRACOTTA", LuaValue.valueOf(247)); // The blocktype for brown glazed
																				// terracotta
		globals.set("E_BLOCK_BROWN_MUSHROOM", LuaValue.valueOf(39)); // The blocktype for brown mushroom
		globals.set("E_BLOCK_BROWN_SHULKER_BOX", LuaValue.valueOf(231)); // The blocktype for brown shulker box
		globals.set("E_BLOCK_BURNING_FURNACE", LuaValue.valueOf(62)); // The blocktype for burning furnace
		globals.set("E_BLOCK_BUTTON_PRESSED", LuaValue.valueOf(8)); // The blocktype for button pressed
		globals.set("E_BLOCK_BUTTON_XM", LuaValue.valueOf(2)); // The blocktype for button xm
		globals.set("E_BLOCK_BUTTON_XP", LuaValue.valueOf(1)); // The blocktype for button xp
		globals.set("E_BLOCK_BUTTON_YM", LuaValue.valueOf(0)); // The blocktype for button ym
		globals.set("E_BLOCK_BUTTON_YP", LuaValue.valueOf(5)); // The blocktype for button yp
		globals.set("E_BLOCK_BUTTON_ZM", LuaValue.valueOf(4)); // The blocktype for button zm
		globals.set("E_BLOCK_BUTTON_ZP", LuaValue.valueOf(3)); // The blocktype for button zp
		globals.set("E_BLOCK_CACTUS", LuaValue.valueOf(81)); // The blocktype for cactus
		globals.set("E_BLOCK_CAKE", LuaValue.valueOf(92)); // The blocktype for cake
		globals.set("E_BLOCK_CARPET", LuaValue.valueOf(171)); // The blocktype for carpet
		globals.set("E_BLOCK_CARROTS", LuaValue.valueOf(141)); // The blocktype for carrots
		globals.set("E_BLOCK_CAULDRON", LuaValue.valueOf(118)); // The blocktype for cauldron
		globals.set("E_BLOCK_CHAIN_COMMAND_BLOCK", LuaValue.valueOf(211)); // The blocktype for chain command block
		globals.set("E_BLOCK_CHEST", LuaValue.valueOf(54)); // The blocktype for chest
		globals.set("E_BLOCK_CHORUS_FLOWER", LuaValue.valueOf(200)); // The blocktype for chorus flower
		globals.set("E_BLOCK_CHORUS_PLANT", LuaValue.valueOf(199)); // The blocktype for chorus plant
		globals.set("E_BLOCK_CLAY", LuaValue.valueOf(82)); // The blocktype for clay
		globals.set("E_BLOCK_COAL_ORE", LuaValue.valueOf(16)); // The blocktype for coal ore
		globals.set("E_BLOCK_COBBLESTONE", LuaValue.valueOf(4)); // The blocktype for cobblestone
		globals.set("E_BLOCK_COBBLESTONE_STAIRS", LuaValue.valueOf(67)); // The blocktype for cobblestone stairs
		globals.set("E_BLOCK_COBBLESTONE_WALL", LuaValue.valueOf(139)); // The blocktype for cobblestone wall
		globals.set("E_BLOCK_COBWEB", LuaValue.valueOf(30)); // The blocktype for cobweb
		globals.set("E_BLOCK_COCOA_POD", LuaValue.valueOf(127)); // The blocktype for cocoa pod
		globals.set("E_BLOCK_COMMAND_BLOCK", LuaValue.valueOf(137)); // The blocktype for command block
		globals.set("E_BLOCK_CONCRETE", LuaValue.valueOf(251)); // The blocktype for concrete
		globals.set("E_BLOCK_CONCRETE_POWDER", LuaValue.valueOf(252)); // The blocktype for concrete powder
		globals.set("E_BLOCK_CRAFTING_TABLE", LuaValue.valueOf(58)); // The blocktype for crafting table
		globals.set("E_BLOCK_CROPS", LuaValue.valueOf(59)); // The blocktype for crops
		globals.set("E_BLOCK_CYAN_GLAZED_TERRACOTTA", LuaValue.valueOf(244)); // The blocktype for cyan glazed
																				// terracotta
		globals.set("E_BLOCK_CYAN_SHULKER_BOX", LuaValue.valueOf(228)); // The blocktype for cyan shulker box
		globals.set("E_BLOCK_DANDELION", LuaValue.valueOf(37)); // The blocktype for dandelion
		globals.set("E_BLOCK_DARK_OAK_DOOR", LuaValue.valueOf(197)); // The blocktype for dark oak door
		globals.set("E_BLOCK_DARK_OAK_FENCE", LuaValue.valueOf(191)); // The blocktype for dark oak fence
		globals.set("E_BLOCK_DARK_OAK_FENCE_GATE", LuaValue.valueOf(186)); // The blocktype for dark oak fence gate
		globals.set("E_BLOCK_DARK_OAK_WOOD_STAIRS", LuaValue.valueOf(164)); // The blocktype for dark oak wood stairs
		globals.set("E_BLOCK_DAYLIGHT_SENSOR", LuaValue.valueOf(151)); // The blocktype for daylight sensor
		globals.set("E_BLOCK_DEAD_BUSH", LuaValue.valueOf(32)); // The blocktype for dead bush
		globals.set("E_BLOCK_DETECTOR_RAIL", LuaValue.valueOf(28)); // The blocktype for detector rail
		globals.set("E_BLOCK_DIAMOND_BLOCK", LuaValue.valueOf(57)); // The blocktype for diamond block
		globals.set("E_BLOCK_DIAMOND_ORE", LuaValue.valueOf(56)); // The blocktype for diamond ore
		globals.set("E_BLOCK_DIRT", LuaValue.valueOf(3)); // The blocktype for dirt
		globals.set("E_BLOCK_DISPENSER", LuaValue.valueOf(23)); // The blocktype for dispenser
		globals.set("E_BLOCK_DOUBLE_RED_SANDSTONE_SLAB", LuaValue.valueOf(181)); // The blocktype for double red
																					// sandstone slab
		globals.set("E_BLOCK_DOUBLE_STONE_SLAB", LuaValue.valueOf(43)); // The blocktype for double stone slab
		globals.set("E_BLOCK_DOUBLE_WOODEN_SLAB", LuaValue.valueOf(125)); // The blocktype for double wooden slab
		globals.set("E_BLOCK_DRAGON_EGG", LuaValue.valueOf(122)); // The blocktype for dragon egg
		globals.set("E_BLOCK_DROPPER", LuaValue.valueOf(158)); // The blocktype for dropper
		globals.set("E_BLOCK_EMERALD_BLOCK", LuaValue.valueOf(133)); // The blocktype for emerald block
		globals.set("E_BLOCK_EMERALD_ORE", LuaValue.valueOf(129)); // The blocktype for emerald ore
		globals.set("E_BLOCK_ENCHANTMENT_TABLE", LuaValue.valueOf(116)); // The blocktype for enchantment table
		globals.set("E_BLOCK_ENDER_CHEST", LuaValue.valueOf(130)); // The blocktype for ender chest
		globals.set("E_BLOCK_END_BRICKS", LuaValue.valueOf(206)); // The blocktype for end bricks
		globals.set("E_BLOCK_END_GATEWAY", LuaValue.valueOf(209)); // The blocktype for end gateway
		globals.set("E_BLOCK_END_PORTAL", LuaValue.valueOf(119)); // The blocktype for end portal
		globals.set("E_BLOCK_END_PORTAL_FRAME", LuaValue.valueOf(120)); // The blocktype for end portal frame
		globals.set("E_BLOCK_END_ROD", LuaValue.valueOf(198)); // The blocktype for end rod
		globals.set("E_BLOCK_END_STONE", LuaValue.valueOf(121)); // The blocktype for end stone
		globals.set("E_BLOCK_FARMLAND", LuaValue.valueOf(60)); // The blocktype for farmland
		globals.set("E_BLOCK_FENCE", LuaValue.valueOf(85)); // The blocktype for fence
		globals.set("E_BLOCK_FENCE_GATE", LuaValue.valueOf(107)); // The blocktype for fence gate
		globals.set("E_BLOCK_FIRE", LuaValue.valueOf(51)); // The blocktype for fire
		globals.set("E_BLOCK_FLOWER", LuaValue.valueOf(38)); // The blocktype for flower
		globals.set("E_BLOCK_FLOWER_POT", LuaValue.valueOf(140)); // The blocktype for flower pot
		globals.set("E_BLOCK_FROSTED_ICE", LuaValue.valueOf(212)); // The blocktype for frosted ice
		globals.set("E_BLOCK_FURNACE", LuaValue.valueOf(61)); // The blocktype for furnace
		globals.set("E_BLOCK_GLASS", LuaValue.valueOf(20)); // The blocktype for glass
		globals.set("E_BLOCK_GLASS_PANE", LuaValue.valueOf(102)); // The blocktype for glass pane
		globals.set("E_BLOCK_GLOWSTONE", LuaValue.valueOf(89)); // The blocktype for glowstone
		globals.set("E_BLOCK_GOLD_BLOCK", LuaValue.valueOf(41)); // The blocktype for gold block
		globals.set("E_BLOCK_GOLD_ORE", LuaValue.valueOf(14)); // The blocktype for gold ore
		globals.set("E_BLOCK_GRASS", LuaValue.valueOf(2)); // The blocktype for grass
		globals.set("E_BLOCK_GRASS_PATH", LuaValue.valueOf(208)); // The blocktype for grass path
		globals.set("E_BLOCK_GRAVEL", LuaValue.valueOf(13)); // The blocktype for gravel
		globals.set("E_BLOCK_GRAY_GLAZED_TERRACOTTA", LuaValue.valueOf(242)); // The blocktype for gray glazed
																				// terracotta
		globals.set("E_BLOCK_GRAY_SHULKER_BOX", LuaValue.valueOf(226)); // The blocktype for gray shulker box
		globals.set("E_BLOCK_GREEN_GLAZED_TERRACOTTA", LuaValue.valueOf(248)); // The blocktype for green glazed
																				// terracotta
		globals.set("E_BLOCK_GREEN_SHULKER_BOX", LuaValue.valueOf(232)); // The blocktype for green shulker box
		globals.set("E_BLOCK_HARDENED_CLAY", LuaValue.valueOf(172)); // The blocktype for hardened clay
		globals.set("E_BLOCK_HAY_BALE", LuaValue.valueOf(170)); // The blocktype for hay bale
		globals.set("E_BLOCK_HEAD", LuaValue.valueOf(144)); // The blocktype for head
		globals.set("E_BLOCK_HEAVY_WEIGHTED_PRESSURE_PLATE", LuaValue.valueOf(148)); // The blocktype for heavy weighted
																						// pressure plate
		globals.set("E_BLOCK_HOPPER", LuaValue.valueOf(154)); // The blocktype for hopper
		globals.set("E_BLOCK_HUGE_BROWN_MUSHROOM", LuaValue.valueOf(99)); // The blocktype for huge brown mushroom
		globals.set("E_BLOCK_HUGE_RED_MUSHROOM", LuaValue.valueOf(100)); // The blocktype for huge red mushroom
		globals.set("E_BLOCK_ICE", LuaValue.valueOf(79)); // The blocktype for ice
		globals.set("E_BLOCK_INACTIVE_COMPARATOR", LuaValue.valueOf(149)); // The blocktype for inactive comparator
		globals.set("E_BLOCK_INVERTED_DAYLIGHT_SENSOR", LuaValue.valueOf(178)); // The blocktype for inverted daylight
																				// sensor
		globals.set("E_BLOCK_IRON_BARS", LuaValue.valueOf(101)); // The blocktype for iron bars
		globals.set("E_BLOCK_IRON_BLOCK", LuaValue.valueOf(42)); // The blocktype for iron block
		globals.set("E_BLOCK_IRON_DOOR", LuaValue.valueOf(71)); // The blocktype for iron door
		globals.set("E_BLOCK_IRON_ORE", LuaValue.valueOf(15)); // The blocktype for iron ore
		globals.set("E_BLOCK_IRON_TRAPDOOR", LuaValue.valueOf(167)); // The blocktype for iron trapdoor
		globals.set("E_BLOCK_JACK_O_LANTERN", LuaValue.valueOf(91)); // The blocktype for jack o lantern
		globals.set("E_BLOCK_JUKEBOX", LuaValue.valueOf(84)); // The blocktype for jukebox
		globals.set("E_BLOCK_JUNGLE_DOOR", LuaValue.valueOf(195)); // The blocktype for jungle door
		globals.set("E_BLOCK_JUNGLE_FENCE", LuaValue.valueOf(190)); // The blocktype for jungle fence
		globals.set("E_BLOCK_JUNGLE_FENCE_GATE", LuaValue.valueOf(185)); // The blocktype for jungle fence gate
		globals.set("E_BLOCK_JUNGLE_WOOD_STAIRS", LuaValue.valueOf(136)); // The blocktype for jungle wood stairs
		globals.set("E_BLOCK_LADDER", LuaValue.valueOf(65)); // The blocktype for ladder
		globals.set("E_BLOCK_LAPIS_BLOCK", LuaValue.valueOf(22)); // The blocktype for lapis block
		globals.set("E_BLOCK_LAPIS_ORE", LuaValue.valueOf(21)); // The blocktype for lapis ore
		globals.set("E_BLOCK_LAVA", LuaValue.valueOf(10)); // The blocktype for lava
		globals.set("E_BLOCK_LEAVES", LuaValue.valueOf(18)); // The blocktype for leaves
		globals.set("E_BLOCK_LEVER", LuaValue.valueOf(69)); // The blocktype for lever
		globals.set("E_BLOCK_LIGHT_BLUE_GLAZED_TERRACOTTA", LuaValue.valueOf(238)); // The blocktype for light blue
																					// glazed terracotta
		globals.set("E_BLOCK_LIGHT_BLUE_SHULKER_BOX", LuaValue.valueOf(222)); // The blocktype for light blue shulker
																				// box
		globals.set("E_BLOCK_LIGHT_GRAY_GLAZED_TERRACOTTA", LuaValue.valueOf(243)); // The blocktype for light gray
																					// glazed terracotta
		globals.set("E_BLOCK_LIGHT_GRAY_SHULKER_BOX", LuaValue.valueOf(227)); // The blocktype for light gray shulker
																				// box
		globals.set("E_BLOCK_LIGHT_WEIGHTED_PRESSURE_PLATE", LuaValue.valueOf(147)); // The blocktype for light weighted
																						// pressure plate
		globals.set("E_BLOCK_LILY_PAD", LuaValue.valueOf(111)); // The blocktype for lily pad
		globals.set("E_BLOCK_LIME_GLAZED_TERRACOTTA", LuaValue.valueOf(240)); // The blocktype for lime glazed
																				// terracotta
		globals.set("E_BLOCK_LIME_SHULKER_BOX", LuaValue.valueOf(224)); // The blocktype for lime shulker box
		globals.set("E_BLOCK_LIT_FURNACE", LuaValue.valueOf(62)); // The blocktype for lit furnace
		globals.set("E_BLOCK_LOG", LuaValue.valueOf(17)); // The blocktype for log
		globals.set("E_BLOCK_MAGENTA_GLAZED_TERRACOTTA", LuaValue.valueOf(237)); // The blocktype for magenta glazed
																					// terracotta
		globals.set("E_BLOCK_MAGENTA_SHULKER_BOX", LuaValue.valueOf(221)); // The blocktype for magenta shulker box
		globals.set("E_BLOCK_MAGMA", LuaValue.valueOf(213)); // The blocktype for magma
		globals.set("E_BLOCK_MAX_TYPE_ID", LuaValue.valueOf(252)); // The blocktype for max type id
		globals.set("E_BLOCK_MELON", LuaValue.valueOf(103)); // The blocktype for melon
		globals.set("E_BLOCK_MELON_STEM", LuaValue.valueOf(105)); // The blocktype for melon stem
		globals.set("E_BLOCK_MINECART_TRACKS", LuaValue.valueOf(66)); // The blocktype for minecart tracks
		globals.set("E_BLOCK_MOB_SPAWNER", LuaValue.valueOf(52)); // The blocktype for mob spawner
		globals.set("E_BLOCK_MOSSY_COBBLESTONE", LuaValue.valueOf(48)); // The blocktype for mossy cobblestone
		globals.set("E_BLOCK_MYCELIUM", LuaValue.valueOf(110)); // The blocktype for mycelium
		globals.set("E_BLOCK_NETHERRACK", LuaValue.valueOf(87)); // The blocktype for netherrack
		globals.set("E_BLOCK_NETHER_BRICK", LuaValue.valueOf(112)); // The blocktype for nether brick
		globals.set("E_BLOCK_NETHER_BRICK_FENCE", LuaValue.valueOf(113)); // The blocktype for nether brick fence
		globals.set("E_BLOCK_NETHER_BRICK_STAIRS", LuaValue.valueOf(114)); // The blocktype for nether brick stairs
		globals.set("E_BLOCK_NETHER_PORTAL", LuaValue.valueOf(90)); // The blocktype for nether portal
		globals.set("E_BLOCK_NETHER_QUARTZ_ORE", LuaValue.valueOf(153)); // The blocktype for nether quartz ore
		globals.set("E_BLOCK_NETHER_WART", LuaValue.valueOf(115)); // The blocktype for nether wart
		globals.set("E_BLOCK_NETHER_WART_BLOCK", LuaValue.valueOf(214)); // The blocktype for nether wart block
		globals.set("E_BLOCK_NEW_LEAVES", LuaValue.valueOf(161)); // The blocktype for new leaves
		globals.set("E_BLOCK_NEW_LOG", LuaValue.valueOf(162)); // The blocktype for new log
		globals.set("E_BLOCK_NOTE_BLOCK", LuaValue.valueOf(25)); // The blocktype for note block
		globals.set("E_BLOCK_NUMBER_OF_TYPES", LuaValue.valueOf(253)); // The blocktype for number of types
		globals.set("E_BLOCK_OAK_DOOR", LuaValue.valueOf(64)); // The blocktype for oak door
		globals.set("E_BLOCK_OAK_FENCE_GATE", LuaValue.valueOf(107)); // The blocktype for oak fence gate
		globals.set("E_BLOCK_OAK_WOOD_STAIRS", LuaValue.valueOf(53)); // The blocktype for oak wood stairs
		globals.set("E_BLOCK_OBSERVER", LuaValue.valueOf(218)); // The blocktype for observer
		globals.set("E_BLOCK_OBSIDIAN", LuaValue.valueOf(49)); // The blocktype for obsidian
		globals.set("E_BLOCK_ORANGE_GLAZED_TERRACOTTA", LuaValue.valueOf(236)); // The blocktype for orange glazed
																				// terracota
		globals.set("E_BLOCK_ORANGE_SHULKER_BOX", LuaValue.valueOf(220)); // The blocktype for orange shulker box
		globals.set("E_BLOCK_PACKED_ICE", LuaValue.valueOf(174)); // The blocktype for packed ice
		globals.set("E_BLOCK_PINK_GLAZED_TERRACOTTA", LuaValue.valueOf(241)); // The blocktype for pink glazed
																				// terracotta
		globals.set("E_BLOCK_PINK_SHULKER_BOX", LuaValue.valueOf(225)); // The blocktype for pink shulker box
		globals.set("E_BLOCK_PISTON", LuaValue.valueOf(33)); // The blocktype for piston
		globals.set("E_BLOCK_PISTON_EXTENSION", LuaValue.valueOf(34)); // The blocktype for piston extension
		globals.set("E_BLOCK_PISTON_MOVED_BLOCK", LuaValue.valueOf(36)); // The blocktype for piston moved block
		globals.set("E_BLOCK_PLANKS", LuaValue.valueOf(5)); // The blocktype for planks
		globals.set("E_BLOCK_POTATOES", LuaValue.valueOf(142)); // The blocktype for potatoes
		globals.set("E_BLOCK_POWERED_RAIL", LuaValue.valueOf(27)); // The blocktype for powered rail
		globals.set("E_BLOCK_PRISMARINE_BLOCK", LuaValue.valueOf(168)); // The blocktype for prismarine block
		globals.set("E_BLOCK_PUMPKIN", LuaValue.valueOf(86)); // The blocktype for pumpkin
		globals.set("E_BLOCK_PUMPKIN_STEM", LuaValue.valueOf(104)); // The blocktype for pumpkin stem
		globals.set("E_BLOCK_PURPLE_GLAZED_TERRACOTTA", LuaValue.valueOf(245)); // The blocktype for purple glazed
																				// terracotta
		globals.set("E_BLOCK_PURPLE_SHULKER_BOX", LuaValue.valueOf(229)); // The blocktype for purple shulker box
		globals.set("E_BLOCK_PURPUR_BLOCK", LuaValue.valueOf(201)); // The blocktype for purpur block
		globals.set("E_BLOCK_PURPUR_DOUBLE_SLAB", LuaValue.valueOf(204)); // The blocktype for purpur double slab
		globals.set("E_BLOCK_PURPUR_PILLAR", LuaValue.valueOf(202)); // The blocktype for purpur pillar
		globals.set("E_BLOCK_PURPUR_SLAB", LuaValue.valueOf(205)); // The blocktype for purpur slab
		globals.set("E_BLOCK_PURPUR_STAIRS", LuaValue.valueOf(203)); // The blocktype for purpur stairs
		globals.set("E_BLOCK_QUARTZ_BLOCK", LuaValue.valueOf(155)); // The blocktype for quartz block
		globals.set("E_BLOCK_QUARTZ_STAIRS", LuaValue.valueOf(156)); // The blocktype for quartz stairs
		globals.set("E_BLOCK_RAIL", LuaValue.valueOf(66)); // The blocktype for rail
		globals.set("E_BLOCK_REDSTONE_LAMP_OFF", LuaValue.valueOf(123)); // The blocktype for redstone lamp off
		globals.set("E_BLOCK_REDSTONE_LAMP_ON", LuaValue.valueOf(124)); // The blocktype for redstone lamp on
		globals.set("E_BLOCK_REDSTONE_ORE", LuaValue.valueOf(73)); // The blocktype for redstone ore
		globals.set("E_BLOCK_REDSTONE_ORE_GLOWING", LuaValue.valueOf(74)); // The blocktype for redstone ore glowing
		globals.set("E_BLOCK_REDSTONE_REPEATER_OFF", LuaValue.valueOf(93)); // The blocktype for redstone repeater off
		globals.set("E_BLOCK_REDSTONE_REPEATER_ON", LuaValue.valueOf(94)); // The blocktype for redstone repeater on
		globals.set("E_BLOCK_REDSTONE_TORCH_OFF", LuaValue.valueOf(75)); // The blocktype for redstone torch off
		globals.set("E_BLOCK_REDSTONE_TORCH_ON", LuaValue.valueOf(76)); // The blocktype for redstone torch on
		globals.set("E_BLOCK_REDSTONE_WIRE", LuaValue.valueOf(55)); // The blocktype for redstone wire
		globals.set("E_BLOCK_RED_GLAZED_TERRACOTTA", LuaValue.valueOf(249)); // The blocktype for red glazed terracotta
		globals.set("E_BLOCK_RED_MUSHROOM", LuaValue.valueOf(40)); // The blocktype for red mushroom
		globals.set("E_BLOCK_RED_NETHER_BRICK", LuaValue.valueOf(215)); // The blocktype for red nether brick
		globals.set("E_BLOCK_RED_ROSE", LuaValue.valueOf(38)); // The blocktype for red rose
		globals.set("E_BLOCK_RED_SANDSTONE", LuaValue.valueOf(179)); // The blocktype for red sandstone
		globals.set("E_BLOCK_RED_SANDSTONE_SLAB", LuaValue.valueOf(182)); // The blocktype for red sandstone slab
		globals.set("E_BLOCK_RED_SANDSTONE_STAIRS", LuaValue.valueOf(180)); // The blocktype for red sandstone stairs
		globals.set("E_BLOCK_RED_SHULKER_BOX", LuaValue.valueOf(233)); // The blocktype for red shulker box
		globals.set("E_BLOCK_REEDS", LuaValue.valueOf(83)); // The blocktype for reeds
		globals.set("E_BLOCK_REPEATING_COMMAND_BLOCK", LuaValue.valueOf(210)); // The blocktype for repeating command
																				// block
		globals.set("E_BLOCK_SAND", LuaValue.valueOf(12)); // The blocktype for sand
		globals.set("E_BLOCK_SANDSTONE", LuaValue.valueOf(24)); // The blocktype for sandstone
		globals.set("E_BLOCK_SANDSTONE_STAIRS", LuaValue.valueOf(128)); // The blocktype for sandstone stairs
		globals.set("E_BLOCK_SAPLING", LuaValue.valueOf(6)); // The blocktype for sapling
		globals.set("E_BLOCK_SEA_LANTERN", LuaValue.valueOf(169)); // The blocktype for sea lantern
		globals.set("E_BLOCK_SIGN_POST", LuaValue.valueOf(63)); // The blocktype for sign post
		globals.set("E_BLOCK_SILVERFISH_EGG", LuaValue.valueOf(97)); // The blocktype for silverfish egg
		globals.set("E_BLOCK_SLIME_BLOCK", LuaValue.valueOf(165)); // The blocktype for slime block
		globals.set("E_BLOCK_SNOW", LuaValue.valueOf(78)); // The blocktype for snow
		globals.set("E_BLOCK_SNOW_BLOCK", LuaValue.valueOf(80)); // The blocktype for snow block
		globals.set("E_BLOCK_SOULSAND", LuaValue.valueOf(88)); // The blocktype for soulsand
		globals.set("E_BLOCK_SPONGE", LuaValue.valueOf(19)); // The blocktype for sponge
		globals.set("E_BLOCK_SPRUCE_DOOR", LuaValue.valueOf(193)); // The blocktype for spruce door
		globals.set("E_BLOCK_SPRUCE_FENCE", LuaValue.valueOf(188)); // The blocktype for spruce fence
		globals.set("E_BLOCK_SPRUCE_FENCE_GATE", LuaValue.valueOf(183)); // The blocktype for spruce fence gate
		globals.set("E_BLOCK_SPRUCE_WOOD_STAIRS", LuaValue.valueOf(134)); // The blocktype for spruce wood stairs
		globals.set("E_BLOCK_STAINED_CLAY", LuaValue.valueOf(159)); // The blocktype for stained clay
		globals.set("E_BLOCK_STAINED_GLASS", LuaValue.valueOf(95)); // The blocktype for stained glass
		globals.set("E_BLOCK_STAINED_GLASS_PANE", LuaValue.valueOf(160)); // The blocktype for stained glass pane
		globals.set("E_BLOCK_STAIRS_UPSIDE_DOWN", LuaValue.valueOf(4)); // The blocktype for stairs upside down
		globals.set("E_BLOCK_STAIRS_XM", LuaValue.valueOf(1)); // The blocktype for stairs xm
		globals.set("E_BLOCK_STAIRS_XP", LuaValue.valueOf(0)); // The blocktype for stairs xp
		globals.set("E_BLOCK_STAIRS_ZM", LuaValue.valueOf(3)); // The blocktype for stairs zm
		globals.set("E_BLOCK_STAIRS_ZP", LuaValue.valueOf(2)); // The blocktype for stairs zp
		globals.set("E_BLOCK_STANDING_BANNER", LuaValue.valueOf(176)); // The blocktype for standing banner
		globals.set("E_BLOCK_STATIONARY_LAVA", LuaValue.valueOf(11)); // The blocktype for stationary lava
		globals.set("E_BLOCK_STATIONARY_WATER", LuaValue.valueOf(9)); // The blocktype for stationary water
		globals.set("E_BLOCK_STICKY_PISTON", LuaValue.valueOf(29)); // The blocktype for sticky piston
		globals.set("E_BLOCK_STONE", LuaValue.valueOf(1)); // The blocktype for stone
		globals.set("E_BLOCK_STONE_BRICKS", LuaValue.valueOf(98)); // The blocktype for stone bricks
		globals.set("E_BLOCK_STONE_BRICK_STAIRS", LuaValue.valueOf(109)); // The blocktype for stone brick stairs
		globals.set("E_BLOCK_STONE_BUTTON", LuaValue.valueOf(77)); // The blocktype for stone button
		globals.set("E_BLOCK_STONE_PRESSURE_PLATE", LuaValue.valueOf(70)); // The blocktype for stone pressure plate
		globals.set("E_BLOCK_STONE_SLAB", LuaValue.valueOf(44)); // The blocktype for stone slab
		globals.set("E_BLOCK_STRUCTURE_BLOCK", LuaValue.valueOf(255)); // The blocktype for structure block
		globals.set("E_BLOCK_STRUCTURE_VOID", LuaValue.valueOf(217)); // The blocktype for structure void
		globals.set("E_BLOCK_SUGARCANE", LuaValue.valueOf(83)); // The blocktype for sugarcane
		globals.set("E_BLOCK_TALL_GRASS", LuaValue.valueOf(31)); // The blocktype for tall grass
		globals.set("E_BLOCK_TERRACOTTA", LuaValue.valueOf(159)); // The blocktype for terracotta (synonym for
																	// E_BLOCK_STAINED_CLAY)
		globals.set("E_BLOCK_TNT", LuaValue.valueOf(46)); // The blocktype for tnt
		globals.set("E_BLOCK_TORCH", LuaValue.valueOf(50)); // The blocktype for torch
		globals.set("E_BLOCK_TRAPDOOR", LuaValue.valueOf(96)); // The blocktype for trapdoor
		globals.set("E_BLOCK_TRAPPED_CHEST", LuaValue.valueOf(146)); // The blocktype for trapped chest
		globals.set("E_BLOCK_TRIPWIRE", LuaValue.valueOf(132)); // The blocktype for tripwire
		globals.set("E_BLOCK_TRIPWIRE_HOOK", LuaValue.valueOf(131)); // The blocktype for tripwire hook
		globals.set("E_BLOCK_UNFINISHED", LuaValue.valueOf(254)); // Internal blocktype for unfinished block handlers
		globals.set("E_BLOCK_VINES", LuaValue.valueOf(106)); // The blocktype for vines
		globals.set("E_BLOCK_WALLSIGN", LuaValue.valueOf(68)); // The blocktype for wallsign
		globals.set("E_BLOCK_WALL_BANNER", LuaValue.valueOf(177)); // The blocktype for wall banner
		globals.set("E_BLOCK_WATER", LuaValue.valueOf(8)); // The blocktype for water
		globals.set("E_BLOCK_WHEAT", LuaValue.valueOf(59)); //
		globals.set("E_BLOCK_WHITE_GLAZED_TERRACOTTA", LuaValue.valueOf(235)); // The blocktype for white glazed
																				// terracotta
		globals.set("E_BLOCK_WHITE_SHULKER_BOX", LuaValue.valueOf(219)); // The blocktype for white shulker box
		globals.set("E_BLOCK_WOODEN_BUTTON", LuaValue.valueOf(143)); // The blocktype for wooden button
		globals.set("E_BLOCK_WOODEN_DOOR", LuaValue.valueOf(64)); // The blocktype for wooden door
		globals.set("E_BLOCK_WOODEN_PRESSURE_PLATE", LuaValue.valueOf(72)); // The blocktype for wooden pressure plate
		globals.set("E_BLOCK_WOODEN_SLAB", LuaValue.valueOf(126)); // The blocktype for wooden slab
		globals.set("E_BLOCK_WOODEN_STAIRS", LuaValue.valueOf(53)); // The blocktype for wooden stairs
		globals.set("E_BLOCK_WOOL", LuaValue.valueOf(35)); // The blocktype for wool
		globals.set("E_BLOCK_WORKBENCH", LuaValue.valueOf(58)); // The blocktype for workbench
		globals.set("E_BLOCK_YELLOW_FLOWER", LuaValue.valueOf(37)); // The blocktype for yellow flower
		globals.set("E_BLOCK_YELLOW_GLAZED_TERRACOTTA", LuaValue.valueOf(239)); // The blocktype for yellow glazed
																				// terracotta
		globals.set("E_BLOCK_YELLOW_SHULKER_BOX", LuaValue.valueOf(223)); // The blocktype for yellow shulker box
		globals.set("E_ITEM_11_DISC", LuaValue.valueOf(2266)); // The itemtype for 11 disc
		globals.set("E_ITEM_13_DISC", LuaValue.valueOf(2256)); // The itemtype for 13 disc
		globals.set("E_ITEM_ACACIA_BOAT", LuaValue.valueOf(447)); // The itemtype for acacia boat
		globals.set("E_ITEM_ACACIA_DOOR", LuaValue.valueOf(430)); // The itemtype for acacia door
		globals.set("E_ITEM_ARMOR_STAND", LuaValue.valueOf(416)); // The itemtype for armor stand
		globals.set("E_ITEM_ARROW", LuaValue.valueOf(262)); // The itemtype for arrow
		globals.set("E_ITEM_BAKED_POTATO", LuaValue.valueOf(393)); // The itemtype for baked potato
		globals.set("E_ITEM_BANNER", LuaValue.valueOf(425)); // The itemtype for banner
		globals.set("E_ITEM_BED", LuaValue.valueOf(355)); // The itemtype for bed
		globals.set("E_ITEM_BEETROOT", LuaValue.valueOf(434)); // The itemtype for beetroot
		globals.set("E_ITEM_BEETROOT_SEEDS", LuaValue.valueOf(435)); // The itemtype for beetroot seeds
		globals.set("E_ITEM_BEETROOT_SOUP", LuaValue.valueOf(436)); // The itemtype for betroot soup
		globals.set("E_ITEM_BIRCH_BOAT", LuaValue.valueOf(445)); // The itemtype for birch boat
		globals.set("E_ITEM_BIRCH_DOOR", LuaValue.valueOf(428)); // The itemtype for birch door
		globals.set("E_ITEM_BLAZE_POWDER", LuaValue.valueOf(377)); // The itemtype for blaze powder
		globals.set("E_ITEM_BLAZE_ROD", LuaValue.valueOf(369)); // The itemtype for blaze rod
		globals.set("E_ITEM_BLOCKS_DISC", LuaValue.valueOf(2258)); // The itemtype for blocks disc
		globals.set("E_ITEM_BOAT", LuaValue.valueOf(333)); // The itemtype for boat
		globals.set("E_ITEM_BONE", LuaValue.valueOf(352)); // The itemtype for bone
		globals.set("E_ITEM_BOOK", LuaValue.valueOf(340)); // The itemtype for book
		globals.set("E_ITEM_BOOK_AND_QUILL", LuaValue.valueOf(386)); // The itemtype for book and quill
		globals.set("E_ITEM_BOTTLE_O_ENCHANTING", LuaValue.valueOf(384)); // The itemtype for bottle o enchanting
		globals.set("E_ITEM_BOW", LuaValue.valueOf(261)); // The itemtype for bow
		globals.set("E_ITEM_BOWL", LuaValue.valueOf(281)); // The itemtype for bowl
		globals.set("E_ITEM_BREAD", LuaValue.valueOf(297)); // The itemtype for bread
		globals.set("E_ITEM_BREWING_STAND", LuaValue.valueOf(379)); // The itemtype for brewing stand
		globals.set("E_ITEM_BUCKET", LuaValue.valueOf(325)); // The itemtype for bucket
		globals.set("E_ITEM_CAKE", LuaValue.valueOf(354)); // The itemtype for cake
		globals.set("E_ITEM_CARROT", LuaValue.valueOf(391)); // The itemtype for carrot
		globals.set("E_ITEM_CARROT_ON_STICK", LuaValue.valueOf(398)); // The itemtype for carrot on stick
		globals.set("E_ITEM_CAT_DISC", LuaValue.valueOf(2257)); // The itemtype for cat disc
		globals.set("E_ITEM_CAULDRON", LuaValue.valueOf(380)); // The itemtype for cauldron
		globals.set("E_ITEM_CHAIN_BOOTS", LuaValue.valueOf(305)); // The itemtype for chain boots
		globals.set("E_ITEM_CHAIN_CHESTPLATE", LuaValue.valueOf(303)); // The itemtype for chain chestplate
		globals.set("E_ITEM_CHAIN_HELMET", LuaValue.valueOf(302)); // The itemtype for chain helmet
		globals.set("E_ITEM_CHAIN_LEGGINGS", LuaValue.valueOf(304)); // The itemtype for chain leggings
		globals.set("E_ITEM_CHEST_MINECART", LuaValue.valueOf(342)); // The itemtype for chest minecart
		globals.set("E_ITEM_CHIRP_DISC", LuaValue.valueOf(2259)); // The itemtype for chirp disc
		globals.set("E_ITEM_CHORUS_FRUIT", LuaValue.valueOf(432)); // The itemtype for chorus fruit
		globals.set("E_ITEM_CLAY", LuaValue.valueOf(337)); // The itemtype for clay
		globals.set("E_ITEM_CLAY_BRICK", LuaValue.valueOf(336)); // The itemtype for clay brick
		globals.set("E_ITEM_CLOCK", LuaValue.valueOf(347)); // The itemtype for clock
		globals.set("E_ITEM_COAL", LuaValue.valueOf(263)); // The itemtype for coal
		globals.set("E_ITEM_COMPARATOR", LuaValue.valueOf(404)); // The itemtype for comparator
		globals.set("E_ITEM_COMPASS", LuaValue.valueOf(345)); // The itemtype for compass
		globals.set("E_ITEM_COOKED_CHICKEN", LuaValue.valueOf(366)); // The itemtype for cooked chicken
		globals.set("E_ITEM_COOKED_FISH", LuaValue.valueOf(350)); // The itemtype for cooked fish
		globals.set("E_ITEM_COOKED_MUTTON", LuaValue.valueOf(424)); // The itemtype for cooked mutton
		globals.set("E_ITEM_COOKED_PORKCHOP", LuaValue.valueOf(320)); // The itemtype for cooked porkchop
		globals.set("E_ITEM_COOKED_RABBIT", LuaValue.valueOf(412)); // The itemtype for cooked rabbit
		globals.set("E_ITEM_COOKIE", LuaValue.valueOf(357)); // The itemtype for cookie
		globals.set("E_ITEM_DARK_OAK_BOAT", LuaValue.valueOf(448)); // The itemtype for dark oak boat
		globals.set("E_ITEM_DARK_OAK_DOOR", LuaValue.valueOf(431)); // The itemtype for dark oak door
		globals.set("E_ITEM_DIAMOND", LuaValue.valueOf(264)); // The itemtype for diamond
		globals.set("E_ITEM_DIAMOND_AXE", LuaValue.valueOf(279)); // The itemtype for diamond axe
		globals.set("E_ITEM_DIAMOND_BOOTS", LuaValue.valueOf(313)); // The itemtype for diamond boots
		globals.set("E_ITEM_DIAMOND_CHESTPLATE", LuaValue.valueOf(311)); // The itemtype for diamond chestplate
		globals.set("E_ITEM_DIAMOND_HELMET", LuaValue.valueOf(310)); // The itemtype for diamond helmet
		globals.set("E_ITEM_DIAMOND_HOE", LuaValue.valueOf(293)); // The itemtype for diamond hoe
		globals.set("E_ITEM_DIAMOND_HORSE_ARMOR", LuaValue.valueOf(419)); // The itemtype for diamond horse armor
		globals.set("E_ITEM_DIAMOND_LEGGINGS", LuaValue.valueOf(312)); // The itemtype for diamond leggings
		globals.set("E_ITEM_DIAMOND_PICKAXE", LuaValue.valueOf(278)); // The itemtype for diamond pickaxe
		globals.set("E_ITEM_DIAMOND_SHOVEL", LuaValue.valueOf(277)); // The itemtype for diamond shovel
		globals.set("E_ITEM_DIAMOND_SWORD", LuaValue.valueOf(276)); // The itemtype for diamond sword
		globals.set("E_ITEM_DRAGON_BREATH", LuaValue.valueOf(437)); // The itemtype for dragon breath
		globals.set("E_ITEM_DYE", LuaValue.valueOf(351)); // The itemtype for dye
		globals.set("E_ITEM_EGG", LuaValue.valueOf(344)); // The itemtype for egg
		globals.set("E_ITEM_ELYTRA", LuaValue.valueOf(443)); // The itemtype for elytra
		globals.set("E_ITEM_EMERALD", LuaValue.valueOf(388)); // The itemtype for emerald
		globals.set("E_ITEM_EMPTY", LuaValue.valueOf(-1)); // The itemtype for empty
		globals.set("E_ITEM_EMPTY_MAP", LuaValue.valueOf(395)); // The itemtype for empty map
		globals.set("E_ITEM_ENCHANTED_BOOK", LuaValue.valueOf(403)); // The itemtype for enchanted book
		globals.set("E_ITEM_ENDER_PEARL", LuaValue.valueOf(368)); // The itemtype for ender pearl
		globals.set("E_ITEM_END_CRYSTAL", LuaValue.valueOf(426)); // The itemtype for end crystal
		globals.set("E_ITEM_EYE_OF_ENDER", LuaValue.valueOf(381)); // The itemtype for eye of ender
		globals.set("E_ITEM_FAR_DISC", LuaValue.valueOf(2260)); // The itemtype for far disc
		globals.set("E_ITEM_FEATHER", LuaValue.valueOf(288)); // The itemtype for feather
		globals.set("E_ITEM_FERMENTED_SPIDER_EYE", LuaValue.valueOf(376)); // The itemtype for fermented spider eye
		globals.set("E_ITEM_FIREWORK_ROCKET", LuaValue.valueOf(401)); // The itemtype for firework rocket
		globals.set("E_ITEM_FIREWORK_STAR", LuaValue.valueOf(402)); // The itemtype for firework star
		globals.set("E_ITEM_FIRE_CHARGE", LuaValue.valueOf(385)); // The itemtype for fire charge
		globals.set("E_ITEM_FIRST", LuaValue.valueOf(256)); // The itemtype for first
		globals.set("E_ITEM_FIRST_DISC", LuaValue.valueOf(2256)); // The itemtype for first disc
		globals.set("E_ITEM_FISHING_ROD", LuaValue.valueOf(346)); // The itemtype for fishing rod
		globals.set("E_ITEM_FLINT", LuaValue.valueOf(318)); // The itemtype for flint
		globals.set("E_ITEM_FLINT_AND_STEEL", LuaValue.valueOf(259)); // The itemtype for flint and steel
		globals.set("E_ITEM_FLOWER_POT", LuaValue.valueOf(390)); // The itemtype for flower pot
		globals.set("E_ITEM_FURNACE_MINECART", LuaValue.valueOf(343)); // The itemtype for furnace minecart
		globals.set("E_ITEM_GHAST_TEAR", LuaValue.valueOf(370)); // The itemtype for ghast tear
		globals.set("E_ITEM_GLASS_BOTTLE", LuaValue.valueOf(374)); // The itemtype for glass bottle
		globals.set("E_ITEM_GLISTERING_MELON", LuaValue.valueOf(382)); // The itemtype for glistering melon
		globals.set("E_ITEM_GLOWSTONE_DUST", LuaValue.valueOf(348)); // The itemtype for glowstone dust
		globals.set("E_ITEM_GOLD", LuaValue.valueOf(266)); // The itemtype for gold
		globals.set("E_ITEM_GOLDEN_APPLE", LuaValue.valueOf(322)); // The itemtype for golden apple
		globals.set("E_ITEM_GOLDEN_CARROT", LuaValue.valueOf(396)); // The itemtype for golden carrot
		globals.set("E_ITEM_GOLD_AXE", LuaValue.valueOf(286)); // The itemtype for gold axe
		globals.set("E_ITEM_GOLD_BOOTS", LuaValue.valueOf(317)); // The itemtype for gold boots
		globals.set("E_ITEM_GOLD_CHESTPLATE", LuaValue.valueOf(315)); // The itemtype for gold chestplate
		globals.set("E_ITEM_GOLD_HELMET", LuaValue.valueOf(314)); // The itemtype for gold helmet
		globals.set("E_ITEM_GOLD_HOE", LuaValue.valueOf(294)); // The itemtype for gold hoe
		globals.set("E_ITEM_GOLD_HORSE_ARMOR", LuaValue.valueOf(418)); // The itemtype for gold horse armor
		globals.set("E_ITEM_GOLD_LEGGINGS", LuaValue.valueOf(316)); // The itemtype for gold leggings
		globals.set("E_ITEM_GOLD_NUGGET", LuaValue.valueOf(371)); // The itemtype for gold nugget
		globals.set("E_ITEM_GOLD_PICKAXE", LuaValue.valueOf(285)); // The itemtype for gold pickaxe
		globals.set("E_ITEM_GOLD_SHOVEL", LuaValue.valueOf(284)); // The itemtype for gold shovel
		globals.set("E_ITEM_GOLD_SWORD", LuaValue.valueOf(283)); // The itemtype for gold sword
		globals.set("E_ITEM_GUNPOWDER", LuaValue.valueOf(289)); // The itemtype for gunpowder
		globals.set("E_ITEM_HEAD", LuaValue.valueOf(397)); // The itemtype for head
		globals.set("E_ITEM_IRON", LuaValue.valueOf(265)); // The itemtype for iron
		globals.set("E_ITEM_IRON_AXE", LuaValue.valueOf(258)); // The itemtype for iron axe
		globals.set("E_ITEM_IRON_BOOTS", LuaValue.valueOf(309)); // The itemtype for iron boots
		globals.set("E_ITEM_IRON_CHESTPLATE", LuaValue.valueOf(307)); // The itemtype for iron chestplate
		globals.set("E_ITEM_IRON_DOOR", LuaValue.valueOf(330)); // The itemtype for iron door
		globals.set("E_ITEM_IRON_HELMET", LuaValue.valueOf(306)); // The itemtype for iron helmet
		globals.set("E_ITEM_IRON_HOE", LuaValue.valueOf(292)); // The itemtype for iron hoe
		globals.set("E_ITEM_IRON_HORSE_ARMOR", LuaValue.valueOf(417)); // The itemtype for iron horse armor
		globals.set("E_ITEM_IRON_LEGGINGS", LuaValue.valueOf(308)); // The itemtype for iron leggings
		globals.set("E_ITEM_IRON_NUGGET", LuaValue.valueOf(452)); // The itemtype for iron nugget
		globals.set("E_ITEM_IRON_PICKAXE", LuaValue.valueOf(257)); // The itemtype for iron pickaxe
		globals.set("E_ITEM_IRON_SHOVEL", LuaValue.valueOf(256)); // The itemtype for iron shovel
		globals.set("E_ITEM_IRON_SWORD", LuaValue.valueOf(267)); // The itemtype for iron sword
		globals.set("E_ITEM_ITEM_FRAME", LuaValue.valueOf(389)); // The itemtype for item frame
		globals.set("E_ITEM_JUNGLE_BOAT", LuaValue.valueOf(446)); // The itemtype for jungle boat
		globals.set("E_ITEM_JUNGLE_DOOR", LuaValue.valueOf(429)); // The itemtype for jungle door
		globals.set("E_ITEM_LAST", LuaValue.valueOf(2267)); // The itemtype for last
		globals.set("E_ITEM_LAST_DISC", LuaValue.valueOf(2267)); // The itemtype for last disc
		globals.set("E_ITEM_LAST_DISC_PLUS_ONE", LuaValue.valueOf(2268)); // The itemtype for last disc plus one
		globals.set("E_ITEM_LAVA_BUCKET", LuaValue.valueOf(327)); // The itemtype for lava bucket
		globals.set("E_ITEM_LEAD", LuaValue.valueOf(420)); // The itemtype for lead
		globals.set("E_ITEM_LEASH", LuaValue.valueOf(420)); // The itemtype for lead (E_ITEM_LEAD synonym)
		globals.set("E_ITEM_LEATHER", LuaValue.valueOf(334)); // The itemtype for leather
		globals.set("E_ITEM_LEATHER_BOOTS", LuaValue.valueOf(301)); // The itemtype for leather boots
		globals.set("E_ITEM_LEATHER_CAP", LuaValue.valueOf(298)); // The itemtype for leather cap
		globals.set("E_ITEM_LEATHER_PANTS", LuaValue.valueOf(300)); // The itemtype for leather pants
		globals.set("E_ITEM_LEATHER_TUNIC", LuaValue.valueOf(299)); // The itemtype for leather tunic
		globals.set("E_ITEM_LINGERING_POTION", LuaValue.valueOf(441)); // The itemtype for lingering potion
		globals.set("E_ITEM_MAGMA_CREAM", LuaValue.valueOf(378)); // The itemtype for magma cream
		globals.set("E_ITEM_MALL_DISC", LuaValue.valueOf(2261)); // The itemtype for mall disc
		globals.set("E_ITEM_MAP", LuaValue.valueOf(358)); // The itemtype for map
		globals.set("E_ITEM_MAX_CONSECUTIVE_TYPE_ID", LuaValue.valueOf(452)); // The itemtype for max consecutive type
																				// id
		globals.set("E_ITEM_MELLOHI_DISC", LuaValue.valueOf(2262)); // The itemtype for mellohi disc
		globals.set("E_ITEM_MELON_SEEDS", LuaValue.valueOf(362)); // The itemtype for melon seeds
		globals.set("E_ITEM_MELON_SLICE", LuaValue.valueOf(360)); // The itemtype for melon slice
		globals.set("E_ITEM_MILK", LuaValue.valueOf(335)); // The itemtype for milk
		globals.set("E_ITEM_MINECART", LuaValue.valueOf(328)); // The itemtype for minecart
		globals.set("E_ITEM_MINECART_WITH_COMMAND_BLOCK", LuaValue.valueOf(422)); // The itemtype for minecart with
																					// command block
		globals.set("E_ITEM_MINECART_WITH_HOPPER", LuaValue.valueOf(408)); // The itemtype for minecart with hopper
		globals.set("E_ITEM_MINECART_WITH_TNT", LuaValue.valueOf(407)); // The itemtype for minecart with tnt
		globals.set("E_ITEM_MUSHROOM_SOUP", LuaValue.valueOf(282)); // The itemtype for mushroom soup
		globals.set("E_ITEM_NAME_TAG", LuaValue.valueOf(421)); // The itemtype for name tag
		globals.set("E_ITEM_NETHER_BRICK", LuaValue.valueOf(405)); // The itemtype for nether brick
		globals.set("E_ITEM_NETHER_QUARTZ", LuaValue.valueOf(406)); // The itemtype for nether quartz
		globals.set("E_ITEM_NETHER_STAR", LuaValue.valueOf(399)); // The itemtype for nether star
		globals.set("E_ITEM_NETHER_WART", LuaValue.valueOf(372)); // The itemtype for nether wart
		globals.set("E_ITEM_NUMBER_OF_CONSECUTIVE_TYPES", LuaValue.valueOf(453)); // The itemtype for number of
																					// consecutive types
		globals.set("E_ITEM_PAINTING", LuaValue.valueOf(321)); // The itemtype for painting
		globals.set("E_ITEM_PAPER", LuaValue.valueOf(339)); // The itemtype for paper
		globals.set("E_ITEM_POISONOUS_POTATO", LuaValue.valueOf(394)); // The itemtype for poisonous potato
		globals.set("E_ITEM_POPPED_CHORUS_FRUIT", LuaValue.valueOf(433)); // The itemtype for popped chorus fruit
		globals.set("E_ITEM_POTATO", LuaValue.valueOf(392)); // The itemtype for potato
		globals.set("E_ITEM_POTION", LuaValue.valueOf(373)); // The itemtype for potion
		globals.set("E_ITEM_POTIONS", LuaValue.valueOf(373)); // The itemtype for potion (obsolete, use E_ITEM_POTION
																// instead)
		globals.set("E_ITEM_PRISMARINE_CRYSTALS", LuaValue.valueOf(410)); // The itemtype for prismarine crystals
		globals.set("E_ITEM_PRISMARINE_SHARD", LuaValue.valueOf(409)); // The itemtype for prismarine shard
		globals.set("E_ITEM_PUMPKIN_PIE", LuaValue.valueOf(400)); // The itemtype for pumpkin pie
		globals.set("E_ITEM_PUMPKIN_SEEDS", LuaValue.valueOf(361)); // The itemtype for pumpkin seeds
		globals.set("E_ITEM_RABBITS_FOOT", LuaValue.valueOf(414)); // The itemtype for rabbits foot
		globals.set("E_ITEM_RABBIT_HIDE", LuaValue.valueOf(415)); // The itemtype for rabbit hide
		globals.set("E_ITEM_RABBIT_STEW", LuaValue.valueOf(413)); // The itemtype for rabbit stew
		globals.set("E_ITEM_RAW_BEEF", LuaValue.valueOf(363)); // The itemtype for raw beef
		globals.set("E_ITEM_RAW_CHICKEN", LuaValue.valueOf(365)); // The itemtype for raw chicken
		globals.set("E_ITEM_RAW_FISH", LuaValue.valueOf(349)); // The itemtype for raw fish
		globals.set("E_ITEM_RAW_MUTTON", LuaValue.valueOf(423)); // The itemtype for raw mutton
		globals.set("E_ITEM_RAW_PORKCHOP", LuaValue.valueOf(319)); // The itemtype for raw porkchop
		globals.set("E_ITEM_RAW_RABBIT", LuaValue.valueOf(411)); // The itemtype for raw rabbit
		globals.set("E_ITEM_REDSTONE_DUST", LuaValue.valueOf(331)); // The itemtype for redstone dust
		globals.set("E_ITEM_REDSTONE_REPEATER", LuaValue.valueOf(356)); // The itemtype for redstone repeater
		globals.set("E_ITEM_RED_APPLE", LuaValue.valueOf(260)); // The itemtype for red apple
		globals.set("E_ITEM_ROTTEN_FLESH", LuaValue.valueOf(367)); // The itemtype for rotten flesh
		globals.set("E_ITEM_SADDLE", LuaValue.valueOf(329)); // The itemtype for saddle
		globals.set("E_ITEM_SEEDS", LuaValue.valueOf(295)); // The itemtype for seeds
		globals.set("E_ITEM_SHEARS", LuaValue.valueOf(359)); // The itemtype for shears
		globals.set("E_ITEM_SHIELD", LuaValue.valueOf(442)); // The itemtype for shield
		globals.set("E_ITEM_SHULKER_SHELL", LuaValue.valueOf(450)); // The itemtype for shulker shell
		globals.set("E_ITEM_SIGN", LuaValue.valueOf(323)); // The itemtype for sign
		globals.set("E_ITEM_SLIMEBALL", LuaValue.valueOf(341)); // The itemtype for slimeball
		globals.set("E_ITEM_SNOWBALL", LuaValue.valueOf(332)); // The itemtype for snowball
		globals.set("E_ITEM_SPAWN_EGG", LuaValue.valueOf(383)); // The itemtype for spawn egg
		globals.set("E_ITEM_SPECTRAL_ARROW", LuaValue.valueOf(439)); // The itemtype for spectral arrow
		globals.set("E_ITEM_SPIDER_EYE", LuaValue.valueOf(375)); // The itemtype for spider eye
		globals.set("E_ITEM_SPLASH_POTION", LuaValue.valueOf(438)); // The itemtype for splash potion
		globals.set("E_ITEM_SPRUCE_BOAT", LuaValue.valueOf(444)); // The itemtype for spruce boat
		globals.set("E_ITEM_SPRUCE_DOOR", LuaValue.valueOf(427)); // The itemtype for spruce door
		globals.set("E_ITEM_STAL_DISC", LuaValue.valueOf(2263)); // The itemtype for stal disc
		globals.set("E_ITEM_STEAK", LuaValue.valueOf(364)); // The itemtype for steak
		globals.set("E_ITEM_STICK", LuaValue.valueOf(280)); // The itemtype for stick
		globals.set("E_ITEM_STONE_AXE", LuaValue.valueOf(275)); // The itemtype for stone axe
		globals.set("E_ITEM_STONE_HOE", LuaValue.valueOf(291)); // The itemtype for stone hoe
		globals.set("E_ITEM_STONE_PICKAXE", LuaValue.valueOf(274)); // The itemtype for stone pickaxe
		globals.set("E_ITEM_STONE_SHOVEL", LuaValue.valueOf(273)); // The itemtype for stone shovel
		globals.set("E_ITEM_STONE_SWORD", LuaValue.valueOf(272)); // The itemtype for stone sword
		globals.set("E_ITEM_STRAD_DISC", LuaValue.valueOf(2264)); // The itemtype for strad disc
		globals.set("E_ITEM_STRING", LuaValue.valueOf(287)); // The itemtype for string
		globals.set("E_ITEM_SUGAR", LuaValue.valueOf(353)); // The itemtype for sugar
		globals.set("E_ITEM_SUGARCANE", LuaValue.valueOf(338)); // The itemtype for sugarcane
		globals.set("E_ITEM_SUGAR_CANE", LuaValue.valueOf(338)); // The itemtype for sugar cane
		globals.set("E_ITEM_TIPPED_ARROW", LuaValue.valueOf(440)); // The itemtype for tipped arrow
		globals.set("E_ITEM_TOTEM_OF_UNDYING", LuaValue.valueOf(449)); // The itemtype for totem of undying
		globals.set("E_ITEM_WAIT_DISC", LuaValue.valueOf(2267)); // The itemtype for wait disc
		globals.set("E_ITEM_WARD_DISC", LuaValue.valueOf(2265)); // The itemtype for ward disc
		globals.set("E_ITEM_WATER_BUCKET", LuaValue.valueOf(326)); // The itemtype for water bucket
		globals.set("E_ITEM_WHEAT", LuaValue.valueOf(296)); // The itemtype for wheat
		globals.set("E_ITEM_WOODEN_AXE", LuaValue.valueOf(271)); // The itemtype for wooden axe
		globals.set("E_ITEM_WOODEN_DOOR", LuaValue.valueOf(324)); // The itemtype for wooden door
		globals.set("E_ITEM_WOODEN_HOE", LuaValue.valueOf(290)); // The itemtype for wooden hoe
		globals.set("E_ITEM_WOODEN_PICKAXE", LuaValue.valueOf(270)); // The itemtype for wooden pickaxe
		globals.set("E_ITEM_WOODEN_SHOVEL", LuaValue.valueOf(269)); // The itemtype for wooden shovel
		globals.set("E_ITEM_WOODEN_SWORD", LuaValue.valueOf(268)); // The itemtype for wooden sword
		globals.set("E_ITEM_WRITTEN_BOOK", LuaValue.valueOf(387)); // The itemtype for written book
		globals.set("ssFireSpread", LuaValue.valueOf(0)); //
		globals.set("ssGrassSpread", LuaValue.valueOf(1)); //
		globals.set("ssMushroomSpread", LuaValue.valueOf(2)); //
		globals.set("ssMycelSpread", LuaValue.valueOf(3)); //
		globals.set("ssVineSpread", LuaValue.valueOf(4)); //
		globals.set("slAll", LuaValue.valueOf(2)); //
		globals.set("slGravityAffectedOnly", LuaValue.valueOf(1)); //
		globals.set("slNone", LuaValue.valueOf(0)); //
		globals.set("mhLeft", LuaValue.valueOf(0)); // The left hand is the main hand
		globals.set("mhRight", LuaValue.valueOf(1)); // The right hand is the main hand
		globals.set("hMain", LuaValue.valueOf(0)); // The main hand
		globals.set("hOff", LuaValue.valueOf(1)); // The off hand
		globals.set("mtCustom", LuaValue.valueOf(0)); // Send raw data without any processing
		globals.set("mtDeath", LuaValue.valueOf(6)); // Denotes death of player
		globals.set("mtError", LuaValue.valueOf(1)); // Something could not be done (i.e. command not executed due to
														// insufficient privilege)
		globals.set("mtFail", LuaValue.valueOf(1)); // Something could not be done (i.e. command not executed due to
													// insufficient privilege)
		globals.set("mtFailure", LuaValue.valueOf(1)); // Something could not be done (i.e. command not executed due to
														// insufficient privilege)
		globals.set("mtFatal", LuaValue.valueOf(5)); // Something catastrophic occured (i.e. plugin crash)
		globals.set("mtInfo", LuaValue.valueOf(2)); // Informational message (i.e. command usage)
		globals.set("mtInformation", LuaValue.valueOf(2)); // Informational message (i.e. command usage)
		globals.set("mtJoin", LuaValue.valueOf(8)); // A player has joined the server
		globals.set("mtLeave", LuaValue.valueOf(9)); // A player has left the server
		globals.set("mtMaxPlusOne", LuaValue.valueOf(10)); // The first invalid type, used for checking on LuaAPI
															// boundaries
		globals.set("mtPM", LuaValue.valueOf(7)); // Player to player messaging identifier
		globals.set("mtPrivateMessage", LuaValue.valueOf(7)); // Player to player messaging identifier
		globals.set("mtSuccess", LuaValue.valueOf(3)); // Something executed successfully
		globals.set("mtWarning", LuaValue.valueOf(4)); // Something concerning (i.e. reload) is about to happen
		globals.set("BLOCK_FACE_BOTTOM", LuaValue.valueOf(0)); // Please use BLOCK_FACE_YM instead. Interacting with the
																// bottom face of the block.
		globals.set("BLOCK_FACE_EAST", LuaValue.valueOf(5)); // Please use BLOCK_FACE_XM instead. Interacting with the
																// eastern face of the block.
		globals.set("BLOCK_FACE_MAX", LuaValue.valueOf(5)); // Used for range checking - highest legal value for an
															// eBlockFace
		globals.set("BLOCK_FACE_MIN", LuaValue.valueOf(-1)); // Used for range checking - lowest legal value for an
																// eBlockFace
		globals.set("BLOCK_FACE_NONE", LuaValue.valueOf(-1)); // Interacting with no block face - swinging the item in
																// the air
		globals.set("BLOCK_FACE_NORTH", LuaValue.valueOf(2)); // Please use BLOCK_FACE_ZM instead. Interacting with the
																// northern face of the block.
		globals.set("BLOCK_FACE_SOUTH", LuaValue.valueOf(3)); // Please use BLOCK_FACE_ZP instead. Interacting with the
																// southern face of the block.
		globals.set("BLOCK_FACE_TOP", LuaValue.valueOf(1)); // Please use BLOCK_FACE_YP instead. Interacting with the
															// top face of the block.
		globals.set("BLOCK_FACE_WEST", LuaValue.valueOf(4)); // Please use BLOCK_FACE_XP instead. Interacting with the
																// western face of the block.
		globals.set("BLOCK_FACE_XM", LuaValue.valueOf(4)); // Interacting with the X- face of the block
		globals.set("BLOCK_FACE_XP", LuaValue.valueOf(5)); // Interacting with the X+ face of the block
		globals.set("BLOCK_FACE_YM", LuaValue.valueOf(0)); // Interacting with the Y- face of the block
		globals.set("BLOCK_FACE_YP", LuaValue.valueOf(1)); // Interacting with the Y+ face of the block
		globals.set("BLOCK_FACE_ZM", LuaValue.valueOf(2)); // Interacting with the Z- face of the block
		globals.set("BLOCK_FACE_ZP", LuaValue.valueOf(3)); // Interacting with the Z+ face of the block
		globals.set("DIG_STATUS_CANCELLED", LuaValue.valueOf(1)); // The player has let go of the mine block key before
																	// finishing mining the block
		globals.set("DIG_STATUS_DROP_HELD", LuaValue.valueOf(4)); // The player has dropped a single item using the Drop
																	// Item key (default: Q)
		globals.set("DIG_STATUS_DROP_STACK", LuaValue.valueOf(3)); // The player has dropped a full stack of items using
																	// the Drop Item key (default: Q) while holding down
																	// a specific modifier key (in windows, control)
		globals.set("DIG_STATUS_FINISHED", LuaValue.valueOf(2)); // The player thinks that it has finished mining a
																	// block
		globals.set("DIG_STATUS_SHOOT_EAT", LuaValue.valueOf(5)); // The player has finished shooting a bow or finished
																	// eating
		globals.set("DIG_STATUS_STARTED", LuaValue.valueOf(0)); // The player has started digging
		globals.set("DIG_STATUS_SWAP_ITEM_IN_HAND", LuaValue.valueOf(6)); // The player has swapped their held item with
																			// the item in their offhand slot (1.9)
		globals.set("mtBat", LuaValue.valueOf(0)); //
		globals.set("mtBlaze", LuaValue.valueOf(1)); //
		globals.set("mtCaveSpider", LuaValue.valueOf(2)); //
		globals.set("mtChicken", LuaValue.valueOf(3)); //
		globals.set("mtCow", LuaValue.valueOf(4)); //
		globals.set("mtCreeper", LuaValue.valueOf(5)); //
		globals.set("mtEnderDragon", LuaValue.valueOf(6)); //
		globals.set("mtEnderman", LuaValue.valueOf(7)); //
		globals.set("mtGhast", LuaValue.valueOf(8)); //
		globals.set("mtGiant", LuaValue.valueOf(9)); //
		globals.set("mtGuardian", LuaValue.valueOf(10)); //
		globals.set("mtHorse", LuaValue.valueOf(11)); //
		globals.set("mtInvalidType", LuaValue.valueOf(-1)); // Invalid monster type. Returned when monster type not
															// recognized
		globals.set("mtIronGolem", LuaValue.valueOf(12)); //
		globals.set("mtMagmaCube", LuaValue.valueOf(13)); //
		globals.set("mtMooshroom", LuaValue.valueOf(14)); //
		globals.set("mtOcelot", LuaValue.valueOf(15)); //
		globals.set("mtPig", LuaValue.valueOf(16)); //
		globals.set("mtRabbit", LuaValue.valueOf(17)); //
		globals.set("mtSheep", LuaValue.valueOf(18)); //
		globals.set("mtSilverfish", LuaValue.valueOf(19)); //
		globals.set("mtSkeleton", LuaValue.valueOf(20)); //
		globals.set("mtSlime", LuaValue.valueOf(21)); //
		globals.set("mtSnowGolem", LuaValue.valueOf(22)); //
		globals.set("mtSpider", LuaValue.valueOf(23)); //
		globals.set("mtSquid", LuaValue.valueOf(24)); //
		globals.set("mtVillager", LuaValue.valueOf(25)); //
		globals.set("mtWitch", LuaValue.valueOf(26)); //
		globals.set("mtWither", LuaValue.valueOf(27)); //
		globals.set("mtWitherSkeleton", LuaValue.valueOf(28)); //
		globals.set("mtWolf", LuaValue.valueOf(29)); //
		globals.set("mtZombie", LuaValue.valueOf(30)); //
		globals.set("mtZombiePigman", LuaValue.valueOf(31)); //
		globals.set("mtZombieVillager", LuaValue.valueOf(32)); //
		globals.set("SKULL_ROTATION_EAST", LuaValue.valueOf(4)); //
		globals.set("SKULL_ROTATION_EAST_NORTH_EAST", LuaValue.valueOf(3)); //
		globals.set("SKULL_ROTATION_EAST_SOUTH_EAST", LuaValue.valueOf(5)); //
		globals.set("SKULL_ROTATION_NORTH", LuaValue.valueOf(0)); //
		globals.set("SKULL_ROTATION_NORTH_EAST", LuaValue.valueOf(2)); //
		globals.set("SKULL_ROTATION_NORTH_NORTH_EAST", LuaValue.valueOf(1)); //
		globals.set("SKULL_ROTATION_NORTH_NORTH_WEST", LuaValue.valueOf(15)); //
		globals.set("SKULL_ROTATION_NORTH_WEST", LuaValue.valueOf(14)); //
		globals.set("SKULL_ROTATION_SOUTH", LuaValue.valueOf(8)); //
		globals.set("SKULL_ROTATION_SOUTH_EAST", LuaValue.valueOf(6)); //
		globals.set("SKULL_ROTATION_SOUTH_SOUTH_EAST", LuaValue.valueOf(7)); //
		globals.set("SKULL_ROTATION_SOUTH_SOUTH_WEST", LuaValue.valueOf(9)); //
		globals.set("SKULL_ROTATION_SOUTH_WEST", LuaValue.valueOf(10)); //
		globals.set("SKULL_ROTATION_WEST", LuaValue.valueOf(12)); //
		globals.set("SKULL_ROTATION_WEST_NORTH_WEST", LuaValue.valueOf(13)); //
		globals.set("SKULL_ROTATION_WEST_SOUTH_WEST", LuaValue.valueOf(11)); //

	}

	public static LuaValue BLOCK_FACE(BlockFace face) {
		switch (face) {
		case BOTTOM:
			return LuaValue.valueOf(0);
		case EAST:
			return LuaValue.valueOf(5);
		case NORTH:
			return LuaValue.valueOf(2);
		case SOUTH:
			return LuaValue.valueOf(3);
		case TOP:
			return LuaValue.valueOf(1);
		case WEST:
			return LuaValue.valueOf(4);
		default:
			return LuaValue.NIL;
		}
	}
}
