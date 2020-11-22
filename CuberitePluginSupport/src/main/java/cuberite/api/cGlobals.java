package cuberite.api;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

import cuberite.plugin.Plugin;

public class cGlobals {
	
	// Global Functions
	
	static class AddFaceDirection extends VarArgFunction { // TODO: Complete this class
		/**
		* BlockPos	Vector3i
		* BlockFace	eBlockFace
		* IsInverse	boolean
		* BlockPos	Vector3i
		* Returns the coords of a block adjacent to the specified block through the specified face
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}

	static class Base64Decode extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Input	string
		string
		Decodes a Base64-encoded string into the raw data.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}
	
	static class Base64Encode extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Input	string
		string
		Encodes a string into Base64.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
		}
	}
	static class BiomeToString extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Biome	EMCSBiome
		string
		Translates biome enum into biome string. Returns empty string on failure (unknown biome).
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class BlockFaceToString extends VarArgFunction { // TODO: Complete this class
		/**
		*
		eBlockFace	eBlockFace
		string
		Returns the string representation of the eBlockFace constant. Uses the axis-direction-based names, such as BLOCK_FACE_XP.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class BlockStringToType extends VarArgFunction { // TODO: Complete this class
		/**
		*
		BlockTypeString	string
		BLOCKTYPE	number
		Returns the block type parsed from the given string
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class Clamp extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Number	number
		Min	number
		Max	number
		number
		Clamp the number to the specified range.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class ClickActionToString extends VarArgFunction { // TODO: Complete this class
		/**
		*
		ClickAction	eClickAction
		string
		Returns a string description of the ClickAction enumerated value
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class DamageTypeToString extends VarArgFunction { // TODO: Complete this class
		/**
		*
		DamageType	eDamageType
		string
		Converts the DamageType to a string representation
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class DimensionToString extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Dimension	eDimension
		string
		Converts an eDimension to a string value. Returns Overworld on failure.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class EscapeString extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Input	string
		string
		Returns a copy of the string with all quotes and backslashes escaped by a backslash
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class GetIniItemSet extends VarArgFunction { // TODO: Complete this class
		/**
		*
		IniFile	cIniFile
		SectionName	string
		KeyName	string
		DefaultValue	string
		cItem
		Returns the item that has been read from the specified INI file value. If the value is not present in the INI file, the DefaultValue is stored in the file and parsed as the result. Returns empty item if the value cannot be parsed.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class GetSnowStartHeight extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Biome	EMCSBiome
		number
		Returns the height at which snow will start falling in the Biome. Check functions IsBiomeCold and IsBiomeVeryCold for more informations.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class GetTime extends VarArgFunction { // TODO: Complete this class
		/**
		* number
		* Returns the current OS time, as a unix time stamp (number of seconds since Jan 1, 1970)
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class IsBiomeCold extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Biome	EMCSBiome
		boolean
		Returns true if the biome is cold (has snow and snowfall at higher elevations but not at regular heights). Doesn't report Very Cold biomes, use IsBiomeVeryCold() for those.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class IsBiomeMesa extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Biome	EMCSBiome
		boolean
		Returns true if the biome is a type of Mesa (mutations of the Mesa biome).
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class IsBiomeMountain extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Biome	EMCSBiome
		boolean
		Returns true if the biome is mountainous (mutations of the extreme hills biome).
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class IsBiomeNoDownfall extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Biome	EMCSBiome
		boolean
		Returns true if the biome is 'dry', that is, there is no precipitation during rains and storms.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class IsBiomeOcean extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Biome	EMCSBiome
		boolean
		Returns true if the biome is an ocean biome.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class IsBiomeVeryCold extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Biome	EMCSBiome
		boolean
		Returns true if the biome is very cold (has snow on ground everywhere, turns top water to ice, has snowfall instead of rain everywhere). Doesn't report mildly cold biomes (where it snows above certain elevation), use IsBiomeCold() for those.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class IsValidBlock extends VarArgFunction { // TODO: Complete this class
		/**
		*
		BlockType	number
		boolean
		Returns true if BlockType is a known block type
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class IsValidItem extends VarArgFunction { // TODO: Complete this class
		/**
		*
		ItemType	number
		boolean
		Returns true if ItemType is a known item type
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class ItemToFullString extends VarArgFunction { // TODO: Complete this class
		/**
		*
		cItem	cItem
		string
		Returns the string representation of the item, in the format 'ItemTypeText:ItemDamage * Count'
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class ItemToString extends VarArgFunction { // TODO: Complete this class
		/**
		*
		cItem	cItem
		string
		Returns the string representation of the item type
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class ItemTypeToString extends VarArgFunction { // TODO: Complete this class
		/**
		*
		ItemType	number
		string
		Returns the string representation of ItemType
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	
	static class LOG extends OneArgFunction { // TODO: Complete this class
		/**
		 * Message	cCompositeChat
		 * Logs the cCompositeChat's human-readable text into the server console. The severity is converted from the CompositeChat's MessageType.
		 * 
		 * @author Krystilize
		 *
		 */
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
		Message	cCompositeChat
		Logs the cCompositeChat's human-readable text into the server console and logfile using 'error' severity (black text on red background)
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}

	
	static class LOGINFO extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Message	cCompositeChat
		Logs the cCompositeChat's human-readable text into the server console and logfile using 'info' severity (yellow text)
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}

	
	static class LOGWARN extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Message	cCompositeChat
		Logs the cCompositeChat's human-readable text into the server console and logfile using 'warning' severity (red text); OBSOLETE, use LOGWARNING() instead
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class LOGWARNING extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Message	cCompositeChat
		Logs the cCompositeChat's human-readable text into the server console and logfile using 'warning' severity (red text)
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}

	
	static class MirrorBlockFaceY extends VarArgFunction { // TODO: Complete this class
		/**
		*
		eBlockFace	eBlockFace
		eBlockFace
		Returns the eBlockFace that corresponds to the given eBlockFace after mirroring it around the Y axis (or rotating 180 degrees around it).
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class NoCaseCompare extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Value1	string
		Value2	string
		number
		Case-insensitive string comparison; returns 0 if the strings are the same, -1 if Value1 is smaller and 1 if Value2 is smaller
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class NormalizeAngleDegrees extends VarArgFunction { // TODO: Complete this class
		/**
		*
		AngleDegrees	number
		AngleDegrees	number
		Returns the angle, wrapped into the [-180, +180) range.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class ReplaceString extends VarArgFunction { // TODO: Complete this class
		/**
		*
		full-string	string
		to-be-replaced-string	string
		to-replace-string	string
		string
		Replaces *each* occurence of to-be-replaced-string in full-string with to-replace-string
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class ReverseBlockFace extends VarArgFunction { // TODO: Complete this class
		/**
		*
		BlockFace	eBlockFace
		eBlockFace
		Returns the reversed eBlockFace.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class RotateBlockFaceCCW extends VarArgFunction { // TODO: Complete this class
		/**
		*
		eBlockFace	eBlockFace
		eBlockFace
		Returns the eBlockFace that corresponds to the given eBlockFace after rotating it around the Y axis 90 degrees counter-clockwise.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class RotateBlockFaceCW extends VarArgFunction { // TODO: Complete this class
		/**
		*
		eBlockFace	eBlockFace
		eBlockFace
		Returns the eBlockFace that corresponds to the given eBlockFace after rotating it around the Y axis 90 degrees clockwise.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class StringSplit extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Input	string
		SeperatorsString	string
		table
		Seperates string into multiple by splitting every time any of the characters in SeperatorsString is encountered. Returns and array-table of strings.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class StringSplitAndTrim extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Input	string
		SeperatorsString	string
		table
		Seperates string into multiple by splitting every time any of the characters in SeperatorsString is encountered. Each of the separate strings is trimmed (whitespace removed from the beginning and end of the string). Returns an array-table of strings.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class StringSplitWithQuotes extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Input	string
		SeperatorsString	string
		table
		Seperates string into multiple by splitting every time any of the characters in SeperatorsString is encountered. Whitespace wrapped with single or double quotes will be ignored. Returns an array-table of strings.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class StringToBiome extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Input	string
		BiomeType	EMCSBiome
		Converts a string representation to a BiomeType enumerated value. Returns biInvalidBiome if the input is not a recognized biome.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class StringToDamageType extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Input	string
		DamageType	eDamageType
		Converts a string representation to a DamageType enumerated value. Returns -1 if the inupt is not a recognized damage type.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class StringToDimension extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Input	string
		Dimension	eDimension
		Converts a string representation to a eDimension enumerated value. Returns dimNotSet if the input is not a recognized dimension.
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class StringToItem extends VarArgFunction { // TODO: Complete this class
		/**
		*
		StringToParse	string
		DestItem	cItem
		boolean
		Parses the item specification in the given string and sets it into DestItem; returns true if successful
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class StringToMobType extends VarArgFunction { // TODO: Complete this class
		/**
		*
		MobTypeString	string
		MobType	eMonsterType
		(DEPRECATED!) Please use cMonster:StringToMobType(). Converts a string representation to an eMonsterType enumerated value
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class StripColorCodes extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Input	string
		string
		Removes all control codes used by MC for colors and styles
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}
	
	static class TrimString extends VarArgFunction { // TODO: Complete this class
		/**
		*
		Input	string
		string
		Removes whitespace at both ends of the string
		*/
		@Override
		public LuaValue call(LuaValue value) {
			System.out.println("This Function Is Not Yet Implemented");
			return LuaValue.NIL;
	    }
	}


	public static void initialize(Plugin plugin, LuaValue luaTable) {
		
		// Functions
		
		luaTable.set("AddFaceDirection", new AddFaceDirection());
		luaTable.set("Base64Decode", new Base64Decode());
		luaTable.set("Base64Encode", new Base64Encode());
		luaTable.set("BiomeToString", new BiomeToString());
		luaTable.set("BlockFaceToString", new BlockFaceToString());
		luaTable.set("BlockStringToType", new BlockStringToType());
		luaTable.set("Clamp", new Clamp());
		luaTable.set("ClickActionToString", new ClickActionToString());
		luaTable.set("DamageTypeToString", new DamageTypeToString());
		luaTable.set("DimensionToString", new DimensionToString());
		luaTable.set("EscapeString", new EscapeString());
		luaTable.set("GetIniItemSet", new GetIniItemSet());
		luaTable.set("GetSnowStartHeight", new GetSnowStartHeight());
		luaTable.set("GetTime", new GetTime());
		luaTable.set("IsBiomeCold", new IsBiomeCold());
		luaTable.set("IsBiomeMesa", new IsBiomeMesa());
		luaTable.set("IsBiomeMountain", new IsBiomeMountain());
		luaTable.set("IsBiomeNoDownfall", new IsBiomeNoDownfall());
		luaTable.set("IsBiomeOcean", new IsBiomeOcean());
		luaTable.set("IsBiomeVeryCold", new IsBiomeVeryCold());
		luaTable.set("IsValidBlock", new IsValidBlock());
		luaTable.set("IsValidItem", new IsValidItem());
		luaTable.set("ItemToFullString", new ItemToFullString());
		luaTable.set("ItemToString", new ItemToString());
		luaTable.set("ItemTypeToString", new ItemTypeToString());
		luaTable.set("LOG", new LOG());
		luaTable.set("LOGERROR", new LOGERROR());
		luaTable.set("LOGINFO", new LOGINFO());
		luaTable.set("LOGWARN", new LOGWARN());
		luaTable.set("LOGWARNING", new LOGWARNING());
		luaTable.set("MirrorBlockFaceY", new MirrorBlockFaceY());
		luaTable.set("NoCaseCompare", new NoCaseCompare());
		luaTable.set("NormalizeAngleDegrees", new NormalizeAngleDegrees());
		luaTable.set("ReplaceString", new ReplaceString());
		luaTable.set("ReverseBlockFace", new ReverseBlockFace());
		luaTable.set("RotateBlockFaceCCW", new RotateBlockFaceCCW());
		luaTable.set("RotateBlockFaceCW", new RotateBlockFaceCW());
		luaTable.set("StringSplit", new StringSplit());
		luaTable.set("StringSplitAndTrim", new StringSplitAndTrim());
		luaTable.set("StringSplitWithQuotes", new StringSplitWithQuotes());
		luaTable.set("StringToBiome", new StringToBiome());
		luaTable.set("StringToDamageType", new StringToDamageType());
		luaTable.set("StringToDimension", new StringToDimension());
		luaTable.set("StringToItem", new StringToItem());
		luaTable.set("StringToMobType", new StringToMobType());
		luaTable.set("StripColorCodes", new StripColorCodes());
		luaTable.set("TrimString", new TrimString());
		
		// Constants
		
		luaTable.set("MAX_EXPERIENCE_ORB_SIZE", LuaValue.valueOf(2000)); //
		luaTable.set("_CuberiteInternal_PluginName", LuaValue.valueOf("APIDump")); //
		luaTable.set("_VERSION", LuaValue.valueOf("Lua 5.1")); //
		luaTable.set("ctAboveActionBar", LuaValue.valueOf(2)); //
		luaTable.set("ctChatBox", LuaValue.valueOf(0)); //
		luaTable.set("ctSystem", LuaValue.valueOf(1)); //
		luaTable.set("esBed", LuaValue.valueOf(0)); //A bed explosion. The SourceData param is the position of the bed.
		luaTable.set("esEnderCrystal", LuaValue.valueOf(1)); //An ender crystal entity explosion. The SourceData param is the ender crystal entity object.
		luaTable.set("esGhastFireball", LuaValue.valueOf(2)); //A ghast fireball explosion. The SourceData param is the ghast fireball entity object.
		luaTable.set("esMax", LuaValue.valueOf(9)); //
		luaTable.set("esMonster", LuaValue.valueOf(3)); //A monster explosion (creeper). The SourceData param is the monster entity object.
		luaTable.set("esOther", LuaValue.valueOf(4)); //Any other explosion. The SourceData param is unused.
		luaTable.set("esPlugin", LuaValue.valueOf(5)); //An explosion started by a plugin, without any further information. The SourceData param is unused.
		luaTable.set("esPrimedTNT", LuaValue.valueOf(6)); //A TNT explosion. The SourceData param is the TNT entity object.
		luaTable.set("esWitherBirth", LuaValue.valueOf(7)); //An explosion at a wither's birth. The SourceData param is the wither entity object.
		luaTable.set("esWitherSkull", LuaValue.valueOf(8)); //A wither skull explosion. The SourceData param is the wither skull entity object.
		luaTable.set("eWeather_Rain", LuaValue.valueOf(1)); //
		luaTable.set("eWeather_Sunny", LuaValue.valueOf(0)); //
		luaTable.set("eWeather_ThunderStorm", LuaValue.valueOf(2)); //
		luaTable.set("wRain", LuaValue.valueOf(1)); //
		luaTable.set("wStorm", LuaValue.valueOf(2)); //
		luaTable.set("wSunny", LuaValue.valueOf(0)); //
		luaTable.set("wThunderstorm", LuaValue.valueOf(2)); //
		luaTable.set("spCape", LuaValue.valueOf(1)); //The cape skin part
		luaTable.set("spHat", LuaValue.valueOf(64)); //The hat/head skin part
		luaTable.set("spJacket", LuaValue.valueOf(2)); //The jacket skin part
		luaTable.set("spLeftPants", LuaValue.valueOf(16)); //The left pants leg skin part
		luaTable.set("spLeftSleeve", LuaValue.valueOf(4)); //The left sleeve skin part
		luaTable.set("spMask", LuaValue.valueOf(127)); //A mask of all valid skin parts combined
		luaTable.set("spRightPants", LuaValue.valueOf(32)); //The right pants leg skin part
		luaTable.set("spRightSleeve", LuaValue.valueOf(8)); //The right sleeve skin part
		luaTable.set("E_META_BANNER_BLACK", LuaValue.valueOf(0)); //
		luaTable.set("E_META_BANNER_BLUE", LuaValue.valueOf(4)); //
		luaTable.set("E_META_BANNER_BROWN", LuaValue.valueOf(3)); //
		luaTable.set("E_META_BANNER_CYAN", LuaValue.valueOf(6)); //
		luaTable.set("E_META_BANNER_GRAY", LuaValue.valueOf(8)); //
		luaTable.set("E_META_BANNER_GREEN", LuaValue.valueOf(2)); //
		luaTable.set("E_META_BANNER_LIGHTBLUE", LuaValue.valueOf(12)); //
		luaTable.set("E_META_BANNER_LIGHTGRAY", LuaValue.valueOf(7)); //
		luaTable.set("E_META_BANNER_LIGHTGREEN", LuaValue.valueOf(10)); //
		luaTable.set("E_META_BANNER_MAGENTA", LuaValue.valueOf(13)); //
		luaTable.set("E_META_BANNER_ORANGE", LuaValue.valueOf(14)); //
		luaTable.set("E_META_BANNER_PINK", LuaValue.valueOf(9)); //
		luaTable.set("E_META_BANNER_PURPLE", LuaValue.valueOf(5)); //
		luaTable.set("E_META_BANNER_RED", LuaValue.valueOf(1)); //
		luaTable.set("E_META_BANNER_WHITE", LuaValue.valueOf(15)); //
		luaTable.set("E_META_BANNER_YELLOW", LuaValue.valueOf(11)); //
		luaTable.set("E_META_BIG_FLOWER_DOUBLE_TALL_GRASS", LuaValue.valueOf(2)); //
		luaTable.set("E_META_BIG_FLOWER_LARGE_FERN", LuaValue.valueOf(3)); //
		luaTable.set("E_META_BIG_FLOWER_LILAC", LuaValue.valueOf(1)); //
		luaTable.set("E_META_BIG_FLOWER_PEONY", LuaValue.valueOf(5)); //
		luaTable.set("E_META_BIG_FLOWER_ROSE_BUSH", LuaValue.valueOf(4)); //
		luaTable.set("E_META_BIG_FLOWER_SUNFLOWER", LuaValue.valueOf(0)); //
		luaTable.set("E_META_BIG_FLOWER_TOP", LuaValue.valueOf(10)); //The metadata of a big flower block that indicates it is the top block.
		luaTable.set("E_META_BREWING_STAND_FILLED_SLOT_XM_ZM", LuaValue.valueOf(4)); //
		luaTable.set("E_META_BREWING_STAND_FILLED_SLOT_XM_ZP", LuaValue.valueOf(2)); //
		luaTable.set("E_META_BREWING_STAND_FILLED_SLOT_XP", LuaValue.valueOf(1)); //
		luaTable.set("E_META_CARPET_BLACK", LuaValue.valueOf(15)); //
		luaTable.set("E_META_CARPET_BLUE", LuaValue.valueOf(11)); //
		luaTable.set("E_META_CARPET_BROWN", LuaValue.valueOf(12)); //
		luaTable.set("E_META_CARPET_CYAN", LuaValue.valueOf(9)); //
		luaTable.set("E_META_CARPET_GRAY", LuaValue.valueOf(7)); //
		luaTable.set("E_META_CARPET_GREEN", LuaValue.valueOf(13)); //
		luaTable.set("E_META_CARPET_LIGHTBLUE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_CARPET_LIGHTGRAY", LuaValue.valueOf(8)); //
		luaTable.set("E_META_CARPET_LIGHTGREEN", LuaValue.valueOf(5)); //
		luaTable.set("E_META_CARPET_MAGENTA", LuaValue.valueOf(2)); //
		luaTable.set("E_META_CARPET_ORANGE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_CARPET_PINK", LuaValue.valueOf(6)); //
		luaTable.set("E_META_CARPET_PURPLE", LuaValue.valueOf(10)); //
		luaTable.set("E_META_CARPET_RED", LuaValue.valueOf(14)); //
		luaTable.set("E_META_CARPET_WHITE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_CARPET_YELLOW", LuaValue.valueOf(4)); //
		luaTable.set("E_META_CHEST_FACING_XM", LuaValue.valueOf(4)); //
		luaTable.set("E_META_CHEST_FACING_XP", LuaValue.valueOf(5)); //
		luaTable.set("E_META_CHEST_FACING_ZM", LuaValue.valueOf(2)); //
		luaTable.set("E_META_CHEST_FACING_ZP", LuaValue.valueOf(3)); //
		luaTable.set("E_META_COAL_CHARCOAL", LuaValue.valueOf(1)); //
		luaTable.set("E_META_COAL_NORMAL", LuaValue.valueOf(0)); //
		luaTable.set("E_META_CONCRETE_BLACK", LuaValue.valueOf(15)); //A flag in the metadata of concete that indicates that the concrete is black.
		luaTable.set("E_META_CONCRETE_BLUE", LuaValue.valueOf(11)); //A flag in the metadata of concete that indicates that the concrete is blue.
		luaTable.set("E_META_CONCRETE_BROWN", LuaValue.valueOf(12)); //A flag in the metadata of concete that indicates that the concrete is brown.
		luaTable.set("E_META_CONCRETE_CYAN", LuaValue.valueOf(9)); //A flag in the metadata of concete that indicates that the concrete is cyan.
		luaTable.set("E_META_CONCRETE_GRAY", LuaValue.valueOf(7)); //A flag in the metadata of concete that indicates that the concrete is gray.
		luaTable.set("E_META_CONCRETE_GREEN", LuaValue.valueOf(13)); //A flag in the metadata of concete that indicates that the concrete is green.
		luaTable.set("E_META_CONCRETE_LIGHTBLUE", LuaValue.valueOf(3)); //A flag in the metadata of concete that indicates that the concrete is light blue.
		luaTable.set("E_META_CONCRETE_LIGHTGRAY", LuaValue.valueOf(8)); //A flag in the metadata of concete that indicates that the concrete is light gray.
		luaTable.set("E_META_CONCRETE_LIGHTGREEN", LuaValue.valueOf(5)); //A flag in the metadata of concete that indicates that the concrete is light green.
		luaTable.set("E_META_CONCRETE_MAGENTA", LuaValue.valueOf(2)); //A flag in the metadata of concete that indicates that the concrete is magenta.
		luaTable.set("E_META_CONCRETE_ORANGE", LuaValue.valueOf(1)); //A flag in the metadata of concete that indicates that the concrete is orange.
		luaTable.set("E_META_CONCRETE_PINK", LuaValue.valueOf(6)); //A flag in the metadata of concete that indicates that the concrete is pink.
		luaTable.set("E_META_CONCRETE_POWDER_BLACK", LuaValue.valueOf(15)); //A flag in the metadata of concete powder that indicates that the concrete powder is black.
		luaTable.set("E_META_CONCRETE_POWDER_BLUE", LuaValue.valueOf(11)); //A flag in the metadata of concete powder that indicates that the concrete powder is blue.
		luaTable.set("E_META_CONCRETE_POWDER_BROWN", LuaValue.valueOf(12)); //A flag in the metadata of concete powder that indicates that the concrete powder is brown.
		luaTable.set("E_META_CONCRETE_POWDER_CYAN", LuaValue.valueOf(9)); //A flag in the metadata of concete powder that indicates that the concrete powder is cyan.
		luaTable.set("E_META_CONCRETE_POWDER_GRAY", LuaValue.valueOf(7)); //A flag in the metadata of concete powder that indicates that the concrete powder is gray.
		luaTable.set("E_META_CONCRETE_POWDER_GREEN", LuaValue.valueOf(13)); //A flag in the metadata of concete powder that indicates that the concrete powder is green.
		luaTable.set("E_META_CONCRETE_POWDER_LIGHTBLUE", LuaValue.valueOf(3)); //A flag in the metadata of concete powder that indicates that the concrete powder is light blue.
		luaTable.set("E_META_CONCRETE_POWDER_LIGHTGRAY", LuaValue.valueOf(8)); //A flag in the metadata of concete powder that indicates that the concrete powder is light gray.
		luaTable.set("E_META_CONCRETE_POWDER_LIGHTGREEN", LuaValue.valueOf(5)); //A flag in the metadata of concete powder that indicates that the concrete powder is light green.
		luaTable.set("E_META_CONCRETE_POWDER_MAGENTA", LuaValue.valueOf(2)); //A flag in the metadata of concete powder that indicates that the concrete powder is magenta.
		luaTable.set("E_META_CONCRETE_POWDER_ORANGE", LuaValue.valueOf(1)); //A flag in the metadata of concete powder that indicates that the concrete powder is orange.
		luaTable.set("E_META_CONCRETE_POWDER_PINK", LuaValue.valueOf(6)); //A flag in the metadata of concete powder that indicates that the concrete powder is pink.
		luaTable.set("E_META_CONCRETE_POWDER_PURPLE", LuaValue.valueOf(10)); //A flag in the metadata of concete powder that indicates that the concrete powder is purple.
		luaTable.set("E_META_CONCRETE_POWDER_RED", LuaValue.valueOf(14)); //A flag in the metadata of concete powder that indicates that the concrete powder is red.
		luaTable.set("E_META_CONCRETE_POWDER_WHITE", LuaValue.valueOf(0)); //A flag in the metadata of concete powder that indicates that the concrete powder is white.
		luaTable.set("E_META_CONCRETE_POWDER_YELLOW", LuaValue.valueOf(4)); //A flag in the metadata of concete powder that indicates that the concrete powder is yellow.
		luaTable.set("E_META_CONCRETE_PURPLE", LuaValue.valueOf(10)); //A flag in the metadata of concete that indicates that the concrete is purple.
		luaTable.set("E_META_CONCRETE_RED", LuaValue.valueOf(14)); //A flag in the metadata of concete that indicates that the concrete is red.
		luaTable.set("E_META_CONCRETE_WHITE", LuaValue.valueOf(0)); //A flag in the metadata of concete that indicates that the concrete is white.
		luaTable.set("E_META_CONCRETE_YELLOW", LuaValue.valueOf(4)); //A flag in the metadata of concete that indicates that the concrete is yellow.
		luaTable.set("E_META_COOKED_FISH_FISH", LuaValue.valueOf(0)); //
		luaTable.set("E_META_COOKED_FISH_SALMON", LuaValue.valueOf(1)); //
		luaTable.set("E_META_DIRT_COARSE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_DIRT_GRASSLESS", LuaValue.valueOf(1)); //
		luaTable.set("E_META_DIRT_NORMAL", LuaValue.valueOf(0)); //
		luaTable.set("E_META_DIRT_PODZOL", LuaValue.valueOf(2)); //
		luaTable.set("E_META_DOUBLE_STONE_SLAB_BRICK", LuaValue.valueOf(4)); //
		luaTable.set("E_META_DOUBLE_STONE_SLAB_COBBLESTONE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_DOUBLE_STONE_SLAB_NETHER_BRICK", LuaValue.valueOf(6)); //
		luaTable.set("E_META_DOUBLE_STONE_SLAB_QUARTZ", LuaValue.valueOf(7)); //
		luaTable.set("E_META_DOUBLE_STONE_SLAB_SANDSTON", LuaValue.valueOf(1)); //
		luaTable.set("E_META_DOUBLE_STONE_SLAB_SMOOTH_SANDSTONE", LuaValue.valueOf(9)); //
		luaTable.set("E_META_DOUBLE_STONE_SLAB_SMOOTH_STONE", LuaValue.valueOf(8)); //
		luaTable.set("E_META_DOUBLE_STONE_SLAB_STONE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_DOUBLE_STONE_SLAB_STONE_BRICK", LuaValue.valueOf(5)); //
		luaTable.set("E_META_DOUBLE_STONE_SLAB_TILE_QUARTZ", LuaValue.valueOf(10)); //
		luaTable.set("E_META_DOUBLE_STONE_SLAB_WOODEN", LuaValue.valueOf(2)); //
		luaTable.set("E_META_DROPSPENSER_ACTIVATED", LuaValue.valueOf(8)); //A flag in the metadata of droppers and dispensers that indicates that the dropper or dispenser is currently activated. If this flag is set, the block must be unpowered first and powered again to shoot the next item.
		luaTable.set("E_META_DROPSPENSER_FACING_MASK", LuaValue.valueOf(7)); //A mask that indicates the bits of the metadata that specify the facing of droppers and dispensers.
		luaTable.set("E_META_DROPSPENSER_FACING_XM", LuaValue.valueOf(4)); //A flag in the metadata of droppers and dispensers that indicates that the dropper or dispenser is looking in the negative X direction.
		luaTable.set("E_META_DROPSPENSER_FACING_XP", LuaValue.valueOf(5)); //A flag in the metadata of droppers and dispensers that indicates that the dropper or dispenser is looking in the positive X direction.
		luaTable.set("E_META_DROPSPENSER_FACING_YM", LuaValue.valueOf(0)); //A flag in the metadata of droppers and dispensers that indicates that the dropper or dispenser is looking in the negative Y direction.
		luaTable.set("E_META_DROPSPENSER_FACING_YP", LuaValue.valueOf(1)); //A flag in the metadata of droppers and dispensers that indicates that the dropper or dispenser is looking in the positive Y direction.
		luaTable.set("E_META_DROPSPENSER_FACING_ZM", LuaValue.valueOf(2)); //A flag in the metadata of droppers and dispensers that indicates that the dropper or dispenser is looking in the negative Z direction.
		luaTable.set("E_META_DROPSPENSER_FACING_ZP", LuaValue.valueOf(3)); //A flag in the metadata of droppers and dispensers that indicates that the dropper or dispenser is looking in the positive Z direction.
		luaTable.set("E_META_DYE_BLACK", LuaValue.valueOf(0)); //
		luaTable.set("E_META_DYE_BLUE", LuaValue.valueOf(4)); //
		luaTable.set("E_META_DYE_BROWN", LuaValue.valueOf(3)); //
		luaTable.set("E_META_DYE_CYAN", LuaValue.valueOf(6)); //
		luaTable.set("E_META_DYE_GRAY", LuaValue.valueOf(8)); //
		luaTable.set("E_META_DYE_GREEN", LuaValue.valueOf(2)); //
		luaTable.set("E_META_DYE_LIGHTBLUE", LuaValue.valueOf(12)); //
		luaTable.set("E_META_DYE_LIGHTGRAY", LuaValue.valueOf(7)); //
		luaTable.set("E_META_DYE_LIGHTGREEN", LuaValue.valueOf(10)); //
		luaTable.set("E_META_DYE_MAGENTA", LuaValue.valueOf(13)); //
		luaTable.set("E_META_DYE_ORANGE", LuaValue.valueOf(14)); //
		luaTable.set("E_META_DYE_PINK", LuaValue.valueOf(9)); //
		luaTable.set("E_META_DYE_PURPLE", LuaValue.valueOf(5)); //
		luaTable.set("E_META_DYE_RED", LuaValue.valueOf(1)); //
		luaTable.set("E_META_DYE_WHITE", LuaValue.valueOf(15)); //
		luaTable.set("E_META_DYE_YELLOW", LuaValue.valueOf(11)); //
		luaTable.set("E_META_END_PORTAL_FRAME_EYE", LuaValue.valueOf(4)); //A flag in the metadata of end portal frames that indicates that the portal frame has an eye in it.
		luaTable.set("E_META_END_PORTAL_FRAME_NO_EYE", LuaValue.valueOf(0)); //The lack of the flag in the metadata of end portal frames indicating that the portal frame has an eye in it.
		luaTable.set("E_META_END_PORTAL_FRAME_XM", LuaValue.valueOf(1)); //A flag in the metadata of end portal frames that indicates that the portal frame is facing the negative X direction.
		luaTable.set("E_META_END_PORTAL_FRAME_XM_EYE", LuaValue.valueOf(5)); //A flag in the metadata of end portal frames that indicates that the portal frame is facing the negative X direction and has an ender eye in it.
		luaTable.set("E_META_END_PORTAL_FRAME_XP", LuaValue.valueOf(3)); //A flag in the metadata of end portal frames that indicates that the portal frame is facing the positive X direction.
		luaTable.set("E_META_END_PORTAL_FRAME_XP_EYE", LuaValue.valueOf(7)); //A flag in the metadata of end portal frames that indicates that the portal frame is facing the positive X direction and has an ender eye in it.
		luaTable.set("E_META_END_PORTAL_FRAME_ZM", LuaValue.valueOf(2)); //A flag in the metadata of end portal frames that indicates that the portal frame is facing the negative Z direction.
		luaTable.set("E_META_END_PORTAL_FRAME_ZM_EYE", LuaValue.valueOf(6)); //A flag in the metadata of end portal frames that indicates that the portal frame is facing the negative Z direction and has an ender eye in it.
		luaTable.set("E_META_END_PORTAL_FRAME_ZP", LuaValue.valueOf(0)); //A flag in the metadata of end portal frames that indicates that the portal frame is facing the positive Z direction.
		luaTable.set("E_META_END_PORTAL_FRAME_ZP_EYE", LuaValue.valueOf(4)); //A flag in the metadata of end portal frames that indicates that the portal frame is facing the positive Z direction and has an ender eye in it.
		luaTable.set("E_META_FLOWER_ALLIUM", LuaValue.valueOf(2)); //
		luaTable.set("E_META_FLOWER_BLUE_ORCHID", LuaValue.valueOf(1)); //
		luaTable.set("E_META_FLOWER_ORANGE_TULIP", LuaValue.valueOf(5)); //
		luaTable.set("E_META_FLOWER_OXEYE_DAISY", LuaValue.valueOf(8)); //
		luaTable.set("E_META_FLOWER_PINK_TULIP", LuaValue.valueOf(7)); //
		luaTable.set("E_META_FLOWER_POPPY", LuaValue.valueOf(0)); //
		luaTable.set("E_META_FLOWER_RED_TULIP", LuaValue.valueOf(4)); //
		luaTable.set("E_META_FLOWER_WHITE_TULIP", LuaValue.valueOf(6)); //
		luaTable.set("E_META_GOLDEN_APPLE_ENCHANTED", LuaValue.valueOf(1)); //
		luaTable.set("E_META_GOLDEN_APPLE_NORMAL", LuaValue.valueOf(0)); //
		luaTable.set("E_META_HEAD_CREEPER", LuaValue.valueOf(4)); //A flag in the metadata of heads that indicates that the head is a creeper head.
		luaTable.set("E_META_HEAD_DRAGON", LuaValue.valueOf(5)); //A flag in the metadata of heads that indicates that the head is a dragon head.
		luaTable.set("E_META_HEAD_PLAYER", LuaValue.valueOf(3)); //A flag in the metadata of heads that indicates that the head is a player head.
		luaTable.set("E_META_HEAD_SKELETON", LuaValue.valueOf(0)); //A flag in the metadata of heads that indicates that the head is a skeleton head.
		luaTable.set("E_META_HEAD_WITHER", LuaValue.valueOf(1)); //A flag in the metadata of heads that indicates that the head is a wither head.
		luaTable.set("E_META_HEAD_ZOMBIE", LuaValue.valueOf(2)); //A flag in the metadata of heads that indicates that the head is a zombie head.
		luaTable.set("E_META_HOPPER_FACING_XM", LuaValue.valueOf(4)); //
		luaTable.set("E_META_HOPPER_FACING_XP", LuaValue.valueOf(5)); //
		luaTable.set("E_META_HOPPER_FACING_YM", LuaValue.valueOf(0)); //
		luaTable.set("E_META_HOPPER_FACING_ZM", LuaValue.valueOf(2)); //
		luaTable.set("E_META_HOPPER_FACING_ZP", LuaValue.valueOf(3)); //
		luaTable.set("E_META_HOPPER_UNATTACHED", LuaValue.valueOf(1)); //
		luaTable.set("E_META_JUKEBOX_OFF", LuaValue.valueOf(0)); //
		luaTable.set("E_META_JUKEBOX_ON", LuaValue.valueOf(1)); //
		luaTable.set("E_META_LEAVES_APPLE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_LEAVES_APPLE_CHECK_DECAY", LuaValue.valueOf(8)); //
		luaTable.set("E_META_LEAVES_APPLE_NO_DECAY", LuaValue.valueOf(4)); //
		luaTable.set("E_META_LEAVES_BIRCH", LuaValue.valueOf(2)); //
		luaTable.set("E_META_LEAVES_BIRCH_CHECK_DECAY", LuaValue.valueOf(10)); //
		luaTable.set("E_META_LEAVES_BIRCH_NO_DECAY", LuaValue.valueOf(6)); //
		luaTable.set("E_META_LEAVES_CONIFER", LuaValue.valueOf(1)); //
		luaTable.set("E_META_LEAVES_CONIFER_CHECK_DECAY", LuaValue.valueOf(9)); //
		luaTable.set("E_META_LEAVES_CONIFER_NO_DECAY", LuaValue.valueOf(5)); //
		luaTable.set("E_META_LEAVES_JUNGLE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_LEAVES_JUNGLE_CHECK_DECAY", LuaValue.valueOf(11)); //
		luaTable.set("E_META_LEAVES_JUNGLE_NO_DECAY", LuaValue.valueOf(7)); //
		luaTable.set("E_META_LOG_APPLE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_LOG_BIRCH", LuaValue.valueOf(2)); //
		luaTable.set("E_META_LOG_BIRCH_BARK_ONLY", LuaValue.valueOf(14)); //
		luaTable.set("E_META_LOG_BIRCH_UP_DOWN", LuaValue.valueOf(2)); //
		luaTable.set("E_META_LOG_BIRCH_X", LuaValue.valueOf(6)); //
		luaTable.set("E_META_LOG_BIRCH_Z", LuaValue.valueOf(10)); //
		luaTable.set("E_META_LOG_CONIFER", LuaValue.valueOf(1)); //
		luaTable.set("E_META_LOG_JUNGLE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_LOG_JUNGLE_BARK_ONLY", LuaValue.valueOf(15)); //
		luaTable.set("E_META_LOG_JUNGLE_UP_DOWN", LuaValue.valueOf(3)); //
		luaTable.set("E_META_LOG_JUNGLE_X", LuaValue.valueOf(7)); //
		luaTable.set("E_META_LOG_JUNGLE_Z", LuaValue.valueOf(11)); //
		luaTable.set("E_META_LOG_OAK_BARK_ONLY", LuaValue.valueOf(12)); //
		luaTable.set("E_META_LOG_OAK_UP_DOWN", LuaValue.valueOf(0)); //
		luaTable.set("E_META_LOG_OAK_X", LuaValue.valueOf(4)); //
		luaTable.set("E_META_LOG_OAK_Z", LuaValue.valueOf(8)); //
		luaTable.set("E_META_LOG_SPRUCE_BARK_ONLY", LuaValue.valueOf(13)); //
		luaTable.set("E_META_LOG_SPRUCE_UP_DOWN", LuaValue.valueOf(1)); //
		luaTable.set("E_META_LOG_SPRUCE_X", LuaValue.valueOf(5)); //
		luaTable.set("E_META_LOG_SPRUCE_Z", LuaValue.valueOf(9)); //
		luaTable.set("E_META_NEWLEAVES_ACACIA", LuaValue.valueOf(0)); //
		luaTable.set("E_META_NEWLEAVES_ACACIA_CHECK_DECAY", LuaValue.valueOf(8)); //
		luaTable.set("E_META_NEWLEAVES_ACACIA_NO_DECAY", LuaValue.valueOf(4)); //
		luaTable.set("E_META_NEWLEAVES_DARK_OAK", LuaValue.valueOf(1)); //
		luaTable.set("E_META_NEWLEAVES_DARK_OAK_CHECK_DECAY", LuaValue.valueOf(9)); //
		luaTable.set("E_META_NEWLEAVES_DARK_OAK_NO_DECAY", LuaValue.valueOf(5)); //
		luaTable.set("E_META_NEWLOG_ACACIA_BARK_ONLY", LuaValue.valueOf(12)); //
		luaTable.set("E_META_NEWLOG_ACACIA_UP_DOWN", LuaValue.valueOf(0)); //
		luaTable.set("E_META_NEWLOG_ACACIA_X", LuaValue.valueOf(4)); //
		luaTable.set("E_META_NEWLOG_ACACIA_Z", LuaValue.valueOf(8)); //
		luaTable.set("E_META_NEWLOG_DARK_OAK_BARK_ONLY", LuaValue.valueOf(13)); //
		luaTable.set("E_META_NEWLOG_DARK_OAK_UP_DOWN", LuaValue.valueOf(1)); //
		luaTable.set("E_META_NEWLOG_DARK_OAK_X", LuaValue.valueOf(5)); //
		luaTable.set("E_META_NEWLOG_DARK_OAK_Z", LuaValue.valueOf(9)); //
		luaTable.set("E_META_NEW_LOG_ACACIA_WOOD", LuaValue.valueOf(0)); //
		luaTable.set("E_META_NEW_LOG_DARK_OAK_WOOD", LuaValue.valueOf(1)); //
		luaTable.set("E_META_PISTON_DOWN", LuaValue.valueOf(0)); //
		luaTable.set("E_META_PISTON_EXTENDED", LuaValue.valueOf(8)); //
		luaTable.set("E_META_PISTON_HEAD_STICKY", LuaValue.valueOf(8)); //
		luaTable.set("E_META_PISTON_U", LuaValue.valueOf(1)); //
		luaTable.set("E_META_PISTON_XM", LuaValue.valueOf(4)); //
		luaTable.set("E_META_PISTON_XP", LuaValue.valueOf(5)); //
		luaTable.set("E_META_PISTON_ZM", LuaValue.valueOf(2)); //
		luaTable.set("E_META_PISTON_ZP", LuaValue.valueOf(3)); //
		luaTable.set("E_META_PLANKS_ACACIA", LuaValue.valueOf(4)); //
		luaTable.set("E_META_PLANKS_BIRCH", LuaValue.valueOf(2)); //
		luaTable.set("E_META_PLANKS_DARK_OAK", LuaValue.valueOf(5)); //
		luaTable.set("E_META_PLANKS_JUNGLE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_PLANKS_OAK", LuaValue.valueOf(0)); //
		luaTable.set("E_META_PLANKS_SPRUCE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_PRESSURE_PLATE_DEPRESSED", LuaValue.valueOf(1)); //
		luaTable.set("E_META_PRESSURE_PLATE_RAISED", LuaValue.valueOf(0)); //
		luaTable.set("E_META_PRISMARINE_BLOCK_BRICKS", LuaValue.valueOf(1)); //
		luaTable.set("E_META_PRISMARINE_BLOCK_DARK", LuaValue.valueOf(2)); //
		luaTable.set("E_META_PRISMARINE_BLOCK_ROUGH", LuaValue.valueOf(0)); //
		luaTable.set("E_META_QUARTZ_CHISELLED", LuaValue.valueOf(1)); //
		luaTable.set("E_META_QUARTZ_NORMAL", LuaValue.valueOf(0)); //
		luaTable.set("E_META_QUARTZ_PILLAR", LuaValue.valueOf(2)); //
		luaTable.set("E_META_RAIL_ASCEND_XM", LuaValue.valueOf(3)); //
		luaTable.set("E_META_RAIL_ASCEND_XP", LuaValue.valueOf(2)); //
		luaTable.set("E_META_RAIL_ASCEND_ZM", LuaValue.valueOf(4)); //
		luaTable.set("E_META_RAIL_ASCEND_ZP", LuaValue.valueOf(5)); //
		luaTable.set("E_META_RAIL_CURVED_ZM_XM", LuaValue.valueOf(8)); //
		luaTable.set("E_META_RAIL_CURVED_ZM_XP", LuaValue.valueOf(9)); //
		luaTable.set("E_META_RAIL_CURVED_ZP_XM", LuaValue.valueOf(7)); //
		luaTable.set("E_META_RAIL_CURVED_ZP_XP", LuaValue.valueOf(6)); //
		luaTable.set("E_META_RAIL_XM_XP", LuaValue.valueOf(1)); //
		luaTable.set("E_META_RAIL_ZM_ZP", LuaValue.valueOf(0)); //
		luaTable.set("E_META_RAW_FISH_CLOWNFISH", LuaValue.valueOf(2)); //
		luaTable.set("E_META_RAW_FISH_FISH", LuaValue.valueOf(0)); //
		luaTable.set("E_META_RAW_FISH_PUFFERFISH", LuaValue.valueOf(3)); //
		luaTable.set("E_META_RAW_FISH_SALMON", LuaValue.valueOf(1)); //
		luaTable.set("E_META_REDSTONE_REPEATER_FACING_MASK", LuaValue.valueOf(3)); //A mask that indicates the bits of the metadata that specify the facing of redstone repeaters.
		luaTable.set("E_META_REDSTONE_REPEATER_FACING_XM", LuaValue.valueOf(3)); //A flag in the metadata of redstone repeaters that indicates that the repeater is looking in the negative X direction.
		luaTable.set("E_META_REDSTONE_REPEATER_FACING_XP", LuaValue.valueOf(1)); //A flag in the metadata of redstone repeaters that indicates that the repeater is looking in the positive X direction.
		luaTable.set("E_META_REDSTONE_REPEATER_FACING_ZM", LuaValue.valueOf(0)); //A flag in the metadata of redstone repeaters that indicates that the repeater is looking in the negative Z direction.
		luaTable.set("E_META_REDSTONE_REPEATER_FACING_ZP", LuaValue.valueOf(2)); //A flag in the metadata of redstone repeaters that indicates that the repeater is looking in the positive Z direction.
		luaTable.set("E_META_RED_SANDSTONE_NORMAL", LuaValue.valueOf(0)); //
		luaTable.set("E_META_RED_SANDSTONE_ORNAMENT", LuaValue.valueOf(1)); //
		luaTable.set("E_META_RED_SANDSTONE_SMOOTH", LuaValue.valueOf(2)); //
		luaTable.set("E_META_SANDSTONE_NORMAL", LuaValue.valueOf(0)); //
		luaTable.set("E_META_SANDSTONE_ORNAMENT", LuaValue.valueOf(1)); //
		luaTable.set("E_META_SANDSTONE_SMOOTH", LuaValue.valueOf(2)); //
		luaTable.set("E_META_SAND_NORMAL", LuaValue.valueOf(0)); //
		luaTable.set("E_META_SAND_RED", LuaValue.valueOf(1)); //
		luaTable.set("E_META_SAPLING_ACACIA", LuaValue.valueOf(4)); //
		luaTable.set("E_META_SAPLING_APPLE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_SAPLING_BIRCH", LuaValue.valueOf(2)); //
		luaTable.set("E_META_SAPLING_CONIFER", LuaValue.valueOf(1)); //
		luaTable.set("E_META_SAPLING_DARK_OAK", LuaValue.valueOf(5)); //
		luaTable.set("E_META_SAPLING_JUNGLE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_SILVERFISH_EGG_CHISELED_STONE_BRICK", LuaValue.valueOf(5)); //A flag in the metadata of the silverfish egg that the block is made from chiseled stone bricks
		luaTable.set("E_META_SILVERFISH_EGG_COBBLESTONE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_SILVERFISH_EGG_CRACKED_STONE_BRICK", LuaValue.valueOf(4)); //A flag in the metadata of the silverfish egg that the block is made from cracked stone bricks
		luaTable.set("E_META_SILVERFISH_EGG_MOSSY_STONE_BRICK", LuaValue.valueOf(3)); //A flag in the metadata of the silverfish egg that the block is made from mossy stone bricks
		luaTable.set("E_META_SILVERFISH_EGG_STONE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_SILVERFISH_EGG_STONE_BRICK", LuaValue.valueOf(2)); //
		luaTable.set("E_META_SNOW_LAYER_EIGHT", LuaValue.valueOf(7)); //
		luaTable.set("E_META_SNOW_LAYER_FIVE", LuaValue.valueOf(4)); //
		luaTable.set("E_META_SNOW_LAYER_FOUR", LuaValue.valueOf(3)); //
		luaTable.set("E_META_SNOW_LAYER_ONE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_SNOW_LAYER_SEVEN", LuaValue.valueOf(6)); //
		luaTable.set("E_META_SNOW_LAYER_SIX", LuaValue.valueOf(5)); //
		luaTable.set("E_META_SNOW_LAYER_THREE", LuaValue.valueOf(2)); //
		luaTable.set("E_META_SNOW_LAYER_TWO", LuaValue.valueOf(1)); //
		luaTable.set("E_META_SPAWN_EGG_ARROW", LuaValue.valueOf(10)); //
		luaTable.set("E_META_SPAWN_EGG_BAT", LuaValue.valueOf(65)); //
		luaTable.set("E_META_SPAWN_EGG_BLAZE", LuaValue.valueOf(61)); //
		luaTable.set("E_META_SPAWN_EGG_BOAT", LuaValue.valueOf(41)); //
		luaTable.set("E_META_SPAWN_EGG_CAVE_SPIDER", LuaValue.valueOf(59)); //
		luaTable.set("E_META_SPAWN_EGG_CHICKEN", LuaValue.valueOf(93)); //
		luaTable.set("E_META_SPAWN_EGG_COW", LuaValue.valueOf(92)); //
		luaTable.set("E_META_SPAWN_EGG_CREEPER", LuaValue.valueOf(50)); //
		luaTable.set("E_META_SPAWN_EGG_ENDERMAN", LuaValue.valueOf(58)); //
		luaTable.set("E_META_SPAWN_EGG_ENDER_CRYSTAL", LuaValue.valueOf(200)); //
		luaTable.set("E_META_SPAWN_EGG_ENDER_DRAGON", LuaValue.valueOf(63)); //
		luaTable.set("E_META_SPAWN_EGG_ENDER_PEARL", LuaValue.valueOf(14)); //
		luaTable.set("E_META_SPAWN_EGG_EXPERIENCE_ORB", LuaValue.valueOf(2)); //
		luaTable.set("E_META_SPAWN_EGG_EXP_BOTTLE", LuaValue.valueOf(17)); //
		luaTable.set("E_META_SPAWN_EGG_EYE_OF_ENDER", LuaValue.valueOf(15)); //
		luaTable.set("E_META_SPAWN_EGG_FALLING_BLOCK", LuaValue.valueOf(21)); //
		luaTable.set("E_META_SPAWN_EGG_FIREBALL", LuaValue.valueOf(12)); //
		luaTable.set("E_META_SPAWN_EGG_FIREWORK", LuaValue.valueOf(22)); //
		luaTable.set("E_META_SPAWN_EGG_GHAST", LuaValue.valueOf(56)); //
		luaTable.set("E_META_SPAWN_EGG_GIANT", LuaValue.valueOf(53)); //
		luaTable.set("E_META_SPAWN_EGG_GUARDIAN", LuaValue.valueOf(68)); //
		luaTable.set("E_META_SPAWN_EGG_HORSE", LuaValue.valueOf(100)); //
		luaTable.set("E_META_SPAWN_EGG_IRON_GOLEM", LuaValue.valueOf(99)); //
		luaTable.set("E_META_SPAWN_EGG_ITEM_FRAME", LuaValue.valueOf(18)); //
		luaTable.set("E_META_SPAWN_EGG_LEASH_KNOT", LuaValue.valueOf(8)); //
		luaTable.set("E_META_SPAWN_EGG_MAGMA_CUBE", LuaValue.valueOf(62)); //
		luaTable.set("E_META_SPAWN_EGG_MINECART", LuaValue.valueOf(42)); //
		luaTable.set("E_META_SPAWN_EGG_MINECART_CHEST", LuaValue.valueOf(43)); //
		luaTable.set("E_META_SPAWN_EGG_MINECART_FURNACE", LuaValue.valueOf(44)); //
		luaTable.set("E_META_SPAWN_EGG_MINECART_HOPPER", LuaValue.valueOf(46)); //
		luaTable.set("E_META_SPAWN_EGG_MINECART_SPAWNER", LuaValue.valueOf(47)); //
		luaTable.set("E_META_SPAWN_EGG_MINECART_TNT", LuaValue.valueOf(45)); //
		luaTable.set("E_META_SPAWN_EGG_MOOSHROOM", LuaValue.valueOf(96)); //
		luaTable.set("E_META_SPAWN_EGG_OCELOT", LuaValue.valueOf(98)); //
		luaTable.set("E_META_SPAWN_EGG_PAINTING", LuaValue.valueOf(9)); //
		luaTable.set("E_META_SPAWN_EGG_PICKUP", LuaValue.valueOf(1)); //
		luaTable.set("E_META_SPAWN_EGG_PIG", LuaValue.valueOf(90)); //
		luaTable.set("E_META_SPAWN_EGG_PRIMED_TNT", LuaValue.valueOf(20)); //
		luaTable.set("E_META_SPAWN_EGG_RABBIT", LuaValue.valueOf(101)); //
		luaTable.set("E_META_SPAWN_EGG_SHEEP", LuaValue.valueOf(91)); //
		luaTable.set("E_META_SPAWN_EGG_SILVERFISH", LuaValue.valueOf(60)); //
		luaTable.set("E_META_SPAWN_EGG_SKELETON", LuaValue.valueOf(51)); //
		luaTable.set("E_META_SPAWN_EGG_SLIME", LuaValue.valueOf(55)); //
		luaTable.set("E_META_SPAWN_EGG_SMALL_FIREBALL", LuaValue.valueOf(13)); //
		luaTable.set("E_META_SPAWN_EGG_SNOWBALL", LuaValue.valueOf(11)); //
		luaTable.set("E_META_SPAWN_EGG_SNOW_GOLEM", LuaValue.valueOf(97)); //
		luaTable.set("E_META_SPAWN_EGG_SPIDER", LuaValue.valueOf(52)); //
		luaTable.set("E_META_SPAWN_EGG_SPLASH_POTION", LuaValue.valueOf(16)); //
		luaTable.set("E_META_SPAWN_EGG_SQUID", LuaValue.valueOf(94)); //
		luaTable.set("E_META_SPAWN_EGG_VILLAGER", LuaValue.valueOf(120)); //
		luaTable.set("E_META_SPAWN_EGG_WITCH", LuaValue.valueOf(66)); //
		luaTable.set("E_META_SPAWN_EGG_WITHER", LuaValue.valueOf(64)); //
		luaTable.set("E_META_SPAWN_EGG_WITHER_SKELETON", LuaValue.valueOf(5)); //
		luaTable.set("E_META_SPAWN_EGG_WITHER_SKULL", LuaValue.valueOf(19)); //
		luaTable.set("E_META_SPAWN_EGG_WOLF", LuaValue.valueOf(95)); //
		luaTable.set("E_META_SPAWN_EGG_ZOMBIE", LuaValue.valueOf(54)); //
		luaTable.set("E_META_SPAWN_EGG_ZOMBIE_PIGMAN", LuaValue.valueOf(57)); //
		luaTable.set("E_META_SPAWN_EGG_ZOMBIE_VILLAGER", LuaValue.valueOf(27)); //
		luaTable.set("E_META_SPONGE_DRY", LuaValue.valueOf(0)); //A flag in the metadata of sponges that indicates that the sponge is dry.
		luaTable.set("E_META_SPONGE_WET", LuaValue.valueOf(1)); //A flag in the metadata of sponges that indicates that the sponge is wet.
		luaTable.set("E_META_STAINED_CLAY_BLACK", LuaValue.valueOf(15)); //
		luaTable.set("E_META_STAINED_CLAY_BLUE", LuaValue.valueOf(11)); //
		luaTable.set("E_META_STAINED_CLAY_BROWN", LuaValue.valueOf(12)); //
		luaTable.set("E_META_STAINED_CLAY_CYAN", LuaValue.valueOf(9)); //
		luaTable.set("E_META_STAINED_CLAY_GRAY", LuaValue.valueOf(7)); //
		luaTable.set("E_META_STAINED_CLAY_GREEN", LuaValue.valueOf(13)); //
		luaTable.set("E_META_STAINED_CLAY_LIGHTBLUE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_STAINED_CLAY_LIGHTGRAY", LuaValue.valueOf(8)); //
		luaTable.set("E_META_STAINED_CLAY_LIGHTGREEN", LuaValue.valueOf(5)); //
		luaTable.set("E_META_STAINED_CLAY_MAGENTA", LuaValue.valueOf(2)); //
		luaTable.set("E_META_STAINED_CLAY_ORANGE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_STAINED_CLAY_PINK", LuaValue.valueOf(6)); //
		luaTable.set("E_META_STAINED_CLAY_PURPLE", LuaValue.valueOf(10)); //
		luaTable.set("E_META_STAINED_CLAY_RED", LuaValue.valueOf(14)); //
		luaTable.set("E_META_STAINED_CLAY_WHITE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_STAINED_CLAY_YELLOW", LuaValue.valueOf(4)); //
		luaTable.set("E_META_STAINED_GLASS_BLACK", LuaValue.valueOf(15)); //
		luaTable.set("E_META_STAINED_GLASS_BLUE", LuaValue.valueOf(11)); //
		luaTable.set("E_META_STAINED_GLASS_BROWN", LuaValue.valueOf(12)); //
		luaTable.set("E_META_STAINED_GLASS_CYAN", LuaValue.valueOf(9)); //
		luaTable.set("E_META_STAINED_GLASS_GRAY", LuaValue.valueOf(7)); //
		luaTable.set("E_META_STAINED_GLASS_GREEN", LuaValue.valueOf(13)); //
		luaTable.set("E_META_STAINED_GLASS_LIGHTBLUE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_STAINED_GLASS_LIGHTGRAY", LuaValue.valueOf(8)); //
		luaTable.set("E_META_STAINED_GLASS_LIGHTGREEN", LuaValue.valueOf(5)); //
		luaTable.set("E_META_STAINED_GLASS_MAGENTA", LuaValue.valueOf(2)); //
		luaTable.set("E_META_STAINED_GLASS_ORANGE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_BLACK", LuaValue.valueOf(15)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_BLUE", LuaValue.valueOf(11)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_BROWN", LuaValue.valueOf(12)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_CYAN", LuaValue.valueOf(9)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_GRAY", LuaValue.valueOf(7)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_GREEN", LuaValue.valueOf(13)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_LIGHTBLUE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_LIGHTGRAY", LuaValue.valueOf(8)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_LIGHTGREEN", LuaValue.valueOf(5)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_MAGENTA", LuaValue.valueOf(2)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_ORANGE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_PINK", LuaValue.valueOf(6)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_PURPLE", LuaValue.valueOf(10)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_RED", LuaValue.valueOf(14)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_WHITE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_STAINED_GLASS_PANE_YELLOW", LuaValue.valueOf(4)); //
		luaTable.set("E_META_STAINED_GLASS_PINK", LuaValue.valueOf(6)); //
		luaTable.set("E_META_STAINED_GLASS_PURPLE", LuaValue.valueOf(10)); //
		luaTable.set("E_META_STAINED_GLASS_RED", LuaValue.valueOf(14)); //
		luaTable.set("E_META_STAINED_GLASS_WHITE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_STAINED_GLASS_YELLOW", LuaValue.valueOf(4)); //
		luaTable.set("E_META_STONE_ANDESITE", LuaValue.valueOf(5)); //
		luaTable.set("E_META_STONE_BRICK_CRACKED", LuaValue.valueOf(2)); //
		luaTable.set("E_META_STONE_BRICK_MOSSY", LuaValue.valueOf(1)); //
		luaTable.set("E_META_STONE_BRICK_NORMAL", LuaValue.valueOf(0)); //
		luaTable.set("E_META_STONE_BRICK_ORNAMENT", LuaValue.valueOf(3)); //
		luaTable.set("E_META_STONE_DIORITE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_STONE_GRANITE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_STONE_POLISHED_ANDESITE", LuaValue.valueOf(6)); //
		luaTable.set("E_META_STONE_POLISHED_DIORITE", LuaValue.valueOf(4)); //
		luaTable.set("E_META_STONE_POLISHED_GRANITE", LuaValue.valueOf(2)); //
		luaTable.set("E_META_STONE_SLAB_BRICK", LuaValue.valueOf(4)); //
		luaTable.set("E_META_STONE_SLAB_COBBLESTONE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_STONE_SLAB_NETHER_BRICK", LuaValue.valueOf(6)); //
		luaTable.set("E_META_STONE_SLAB_PLANKS", LuaValue.valueOf(2)); //
		luaTable.set("E_META_STONE_SLAB_QUARTZ", LuaValue.valueOf(7)); //
		luaTable.set("E_META_STONE_SLAB_SANDSTONE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_STONE_SLAB_STONE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_STONE_SLAB_STONE_BRICK", LuaValue.valueOf(5)); //
		luaTable.set("E_META_STONE_STONE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_TALL_GRASS_BIOME", LuaValue.valueOf(3)); //
		luaTable.set("E_META_TALL_GRASS_DEAD_SHRUB", LuaValue.valueOf(0)); //
		luaTable.set("E_META_TALL_GRASS_FERN", LuaValue.valueOf(2)); //
		luaTable.set("E_META_TALL_GRASS_GRASS", LuaValue.valueOf(1)); //
		luaTable.set("E_META_TORCH_EAST", LuaValue.valueOf(1)); //
		luaTable.set("E_META_TORCH_FLOOR", LuaValue.valueOf(5)); //
		luaTable.set("E_META_TORCH_NORTH", LuaValue.valueOf(4)); //
		luaTable.set("E_META_TORCH_SOUTH", LuaValue.valueOf(3)); //
		luaTable.set("E_META_TORCH_WEST", LuaValue.valueOf(2)); //
		luaTable.set("E_META_TORCH_XM", LuaValue.valueOf(1)); //
		luaTable.set("E_META_TORCH_XP", LuaValue.valueOf(2)); //
		luaTable.set("E_META_TORCH_ZM", LuaValue.valueOf(3)); //
		luaTable.set("E_META_TORCH_ZP", LuaValue.valueOf(4)); //
		luaTable.set("E_META_TRACKS_X", LuaValue.valueOf(1)); //
		luaTable.set("E_META_TRACKS_Z", LuaValue.valueOf(0)); //
		luaTable.set("E_META_WOODEN_DOUBLE_SLAB_ACACIA", LuaValue.valueOf(4)); //
		luaTable.set("E_META_WOODEN_DOUBLE_SLAB_BIRCH", LuaValue.valueOf(2)); //
		luaTable.set("E_META_WOODEN_DOUBLE_SLAB_DARK_OAK", LuaValue.valueOf(5)); //
		luaTable.set("E_META_WOODEN_DOUBLE_SLAB_JUNGLE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_WOODEN_DOUBLE_SLAB_OAK", LuaValue.valueOf(0)); //
		luaTable.set("E_META_WOODEN_DOUBLE_SLAB_SPRUCE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_WOODEN_SLAB_ACACIA", LuaValue.valueOf(4)); //
		luaTable.set("E_META_WOODEN_SLAB_BIRCH", LuaValue.valueOf(2)); //
		luaTable.set("E_META_WOODEN_SLAB_DARK_OAK", LuaValue.valueOf(5)); //
		luaTable.set("E_META_WOODEN_SLAB_JUNGLE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_WOODEN_SLAB_OAK", LuaValue.valueOf(0)); //
		luaTable.set("E_META_WOODEN_SLAB_SPRUCE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_WOODEN_SLAB_UPSIDE_DOWN", LuaValue.valueOf(8)); //
		luaTable.set("E_META_WOOL_BLACK", LuaValue.valueOf(15)); //
		luaTable.set("E_META_WOOL_BLUE", LuaValue.valueOf(11)); //
		luaTable.set("E_META_WOOL_BROWN", LuaValue.valueOf(12)); //
		luaTable.set("E_META_WOOL_CYAN", LuaValue.valueOf(9)); //
		luaTable.set("E_META_WOOL_GRAY", LuaValue.valueOf(7)); //
		luaTable.set("E_META_WOOL_GREEN", LuaValue.valueOf(13)); //
		luaTable.set("E_META_WOOL_LIGHTBLUE", LuaValue.valueOf(3)); //
		luaTable.set("E_META_WOOL_LIGHTGRAY", LuaValue.valueOf(8)); //
		luaTable.set("E_META_WOOL_LIGHTGREEN", LuaValue.valueOf(5)); //
		luaTable.set("E_META_WOOL_MAGENTA", LuaValue.valueOf(2)); //
		luaTable.set("E_META_WOOL_ORANGE", LuaValue.valueOf(1)); //
		luaTable.set("E_META_WOOL_PINK", LuaValue.valueOf(6)); //
		luaTable.set("E_META_WOOL_PURPLE", LuaValue.valueOf(10)); //
		luaTable.set("E_META_WOOL_RED", LuaValue.valueOf(14)); //
		luaTable.set("E_META_WOOL_WHITE", LuaValue.valueOf(0)); //
		luaTable.set("E_META_WOOL_YELLOW", LuaValue.valueOf(4)); //
		luaTable.set("caCtrlDropKey", LuaValue.valueOf(15)); //Drop a full stack
		luaTable.set("caDblClick", LuaValue.valueOf(29)); //Double click action
		luaTable.set("caDropKey", LuaValue.valueOf(14)); //Drop a single item
		luaTable.set("caLeftClick", LuaValue.valueOf(0)); //Left click on a slot
		luaTable.set("caLeftClickOutside", LuaValue.valueOf(16)); //Left click outside of inventory
		luaTable.set("caLeftClickOutsideHoldNothing", LuaValue.valueOf(18)); //Left click outside inventory holding nothing
		luaTable.set("caLeftPaintBegin", LuaValue.valueOf(20)); //Begining of left click paint drag action
		luaTable.set("caLeftPaintEnd", LuaValue.valueOf(26)); //End of left click paint drag action
		luaTable.set("caLeftPaintProgress", LuaValue.valueOf(23)); //Add slot for left click paint drag action
		luaTable.set("caMiddleClick", LuaValue.valueOf(13)); //Middle click, only valid for creative players
		luaTable.set("caMiddlePaintBegin", LuaValue.valueOf(22)); //Begining of middle click paint drag action, only valid for creative players
		luaTable.set("caMiddlePaintEnd", LuaValue.valueOf(28)); //End of middle click paint drag action, only valid for creative players
		luaTable.set("caMiddlePaintProgress", LuaValue.valueOf(25)); //Add slot for middle click paint drag action, only valid for creative players
		luaTable.set("caNumber1", LuaValue.valueOf(4)); //Number key 1
		luaTable.set("caNumber2", LuaValue.valueOf(5)); //Number key 2
		luaTable.set("caNumber3", LuaValue.valueOf(6)); //Number key 3
		luaTable.set("caNumber4", LuaValue.valueOf(7)); //Number key 4
		luaTable.set("caNumber5", LuaValue.valueOf(8)); //Number key 5
		luaTable.set("caNumber6", LuaValue.valueOf(9)); //Number key 6
		luaTable.set("caNumber7", LuaValue.valueOf(10)); //Number key 7
		luaTable.set("caNumber8", LuaValue.valueOf(11)); //Number key 8
		luaTable.set("caNumber9", LuaValue.valueOf(12)); //Number key 9
		luaTable.set("caRightClick", LuaValue.valueOf(1)); //Right click on a slot
		luaTable.set("caRightClickOutside", LuaValue.valueOf(17)); //Right click outside of inventory
		luaTable.set("caRightClickOutsideHoldNothing", LuaValue.valueOf(19)); //Right click outside inventory holding nothing
		luaTable.set("caRightPaintBegin", LuaValue.valueOf(21)); //Begining of right click paint drag action
		luaTable.set("caRightPaintEnd", LuaValue.valueOf(27)); //End of right click paint drag action
		luaTable.set("caRightPaintProgress", LuaValue.valueOf(24)); //Add slot for right click paint drag action
		luaTable.set("caShiftLeftClick", LuaValue.valueOf(2)); //Shift + left click on a slot
		luaTable.set("caShiftRightClick", LuaValue.valueOf(3)); //Shift + right click on a slot
		luaTable.set("caUnknown", LuaValue.valueOf(255)); //Unknown click action
		luaTable.set("SKULL_TYPE_CREEPER", LuaValue.valueOf(4)); //A creeper skull
		luaTable.set("SKULL_TYPE_DRAGON", LuaValue.valueOf(5)); //A dragon skull
		luaTable.set("SKULL_TYPE_PLAYER", LuaValue.valueOf(3)); //A player skull
		luaTable.set("SKULL_TYPE_SKELETON", LuaValue.valueOf(0)); //A skeleton skull
		luaTable.set("SKULL_TYPE_WITHER", LuaValue.valueOf(1)); //A wither skull
		luaTable.set("SKULL_TYPE_ZOMBIE", LuaValue.valueOf(2)); //A zombie skull
		luaTable.set("dimEnd", LuaValue.valueOf(1)); //
		luaTable.set("dimNether", LuaValue.valueOf(-1)); //
		luaTable.set("dimNotSet", LuaValue.valueOf(255)); //
		luaTable.set("dimOverworld", LuaValue.valueOf(0)); //
		luaTable.set("dtAdmin", LuaValue.valueOf(16)); //Damage applied by an admin command
		luaTable.set("dtArrow", LuaValue.valueOf(1)); //Damage received by being attacked by a projectile, possibly from a mob
		luaTable.set("dtArrowAttack", LuaValue.valueOf(1)); //Damage received by being attacked by a projectile, possibly from a mob
		luaTable.set("dtAttack", LuaValue.valueOf(0)); //Damage recieved by being attacked by a mob
		luaTable.set("dtBurning", LuaValue.valueOf(11)); //Damage from being on fire
		luaTable.set("dtCacti", LuaValue.valueOf(7)); //Damage from contact with a cactus block
		luaTable.set("dtCactus", LuaValue.valueOf(7)); //Damage from contact with a cactus block
		luaTable.set("dtCactusContact", LuaValue.valueOf(7)); //Damage from contact with a cactus block
		luaTable.set("dtCactuses", LuaValue.valueOf(7)); //Damage from contact with a cactus block
		luaTable.set("dtDrown", LuaValue.valueOf(4)); //Damage received by drowning in water / lava
		luaTable.set("dtDrowning", LuaValue.valueOf(4)); //Damage received by drowning in water / lava
		luaTable.set("dtEnderPearl", LuaValue.valueOf(15)); //Damage received by throwing an ender pearl and being teleported by it
		luaTable.set("dtEntityAttack", LuaValue.valueOf(0)); //Damage recieved by being attacked by a mob
		luaTable.set("dtEnvironment", LuaValue.valueOf(18)); //Damage dealt to mobs from environment: enderman in rain, snow golem in desert
		luaTable.set("dtExplosion", LuaValue.valueOf(17)); //Damage applied by an explosion
		luaTable.set("dtFall", LuaValue.valueOf(3)); //Damage from falling down. Dealt when hitting the ground
		luaTable.set("dtFalling", LuaValue.valueOf(3)); //Damage from falling down. Dealt when hitting the ground
		luaTable.set("dtFireContact", LuaValue.valueOf(12)); //Damage received by standing inside a fire block
		luaTable.set("dtHunger", LuaValue.valueOf(6)); //Damage received from hunger
		luaTable.set("dtInFire", LuaValue.valueOf(12)); //Damage received by standing inside a fire block
		luaTable.set("dtInVoid", LuaValue.valueOf(13)); //Damage received by falling into the Void (Y < 0)
		luaTable.set("dtLava", LuaValue.valueOf(8)); //Damage received by a contact with a lava block
		luaTable.set("dtLavaContact", LuaValue.valueOf(8)); //Damage received by a contact with a lava block
		luaTable.set("dtLightning", LuaValue.valueOf(2)); //Damage from being hit by a lightning strike
		luaTable.set("dtMob", LuaValue.valueOf(0)); //Damage received by being attacked by a mob
		luaTable.set("dtMobAttack", LuaValue.valueOf(0)); //Damage received by being attacked by a mob
		luaTable.set("dtOnFire", LuaValue.valueOf(11)); //Damage from being on fire
		luaTable.set("dtPawnAttack", LuaValue.valueOf(0)); //Damage received by being attacked by a mob
		luaTable.set("dtPlugin", LuaValue.valueOf(16)); //Damage applied by an admin command
		luaTable.set("dtPoison", LuaValue.valueOf(9)); //Damage applied by the poison effect
		luaTable.set("dtPoisoning", LuaValue.valueOf(9)); //Damage applied by the poison effect
		luaTable.set("dtPotionOfHarming", LuaValue.valueOf(14)); //Damage applied by the potion of harming
		luaTable.set("dtProjectile", LuaValue.valueOf(1)); //Damage received by being attacked by a projectile, possibly from a mob
		luaTable.set("dtRangedAttack", LuaValue.valueOf(1)); //Damage received by being attacked by a projectile, possibly from a mob
		luaTable.set("dtStarvation", LuaValue.valueOf(6)); //Damage received from hunger
		luaTable.set("dtStarving", LuaValue.valueOf(6)); //Damage received from hunger
		luaTable.set("dtSuffocating", LuaValue.valueOf(5)); //Damage from suffocating inside a block
		luaTable.set("dtSuffocation", LuaValue.valueOf(5)); //Damage from suffocating inside a block
		luaTable.set("dtWither", LuaValue.valueOf(10)); //Damage from the wither effect
		luaTable.set("dtWithering", LuaValue.valueOf(10)); //Damage from the wither effect
		luaTable.set("eGameMode_Adventure", LuaValue.valueOf(2)); //
		luaTable.set("eGameMode_Creative", LuaValue.valueOf(1)); //
		luaTable.set("eGameMode_NotSet", LuaValue.valueOf(-1)); //
		luaTable.set("eGameMode_Spectator", LuaValue.valueOf(3)); //
		luaTable.set("eGameMode_Survival", LuaValue.valueOf(0)); //
		luaTable.set("gmAdventure", LuaValue.valueOf(2)); //
		luaTable.set("gmCreative", LuaValue.valueOf(1)); //
		luaTable.set("gmMax", LuaValue.valueOf(4)); //
		luaTable.set("gmMin", LuaValue.valueOf(0)); //
		luaTable.set("gmNotSet", LuaValue.valueOf(-1)); //
		luaTable.set("gmSpectator", LuaValue.valueOf(3)); //
		luaTable.set("gmSurvival", LuaValue.valueOf(0)); //
		luaTable.set("biBeach", LuaValue.valueOf(16)); //
		luaTable.set("biBirchForest", LuaValue.valueOf(27)); //
		luaTable.set("biBirchForestHills", LuaValue.valueOf(28)); //
		luaTable.set("biBirchForestHillsM", LuaValue.valueOf(156)); //
		luaTable.set("biBirchForestM", LuaValue.valueOf(155)); //
		luaTable.set("biColdBeach", LuaValue.valueOf(26)); //
		luaTable.set("biColdTaiga", LuaValue.valueOf(30)); //
		luaTable.set("biColdTaigaHills", LuaValue.valueOf(31)); //
		luaTable.set("biColdTaigaM", LuaValue.valueOf(158)); //
		luaTable.set("biDeepOcean", LuaValue.valueOf(24)); //
		luaTable.set("biDesert", LuaValue.valueOf(2)); //
		luaTable.set("biDesertHills", LuaValue.valueOf(17)); //
		luaTable.set("biDesertM", LuaValue.valueOf(130)); //
		luaTable.set("biEnd", LuaValue.valueOf(9)); //
		luaTable.set("biExtremeHills", LuaValue.valueOf(3)); //
		luaTable.set("biExtremeHillsEdge", LuaValue.valueOf(20)); //
		luaTable.set("biExtremeHillsM", LuaValue.valueOf(131)); //
		luaTable.set("biExtremeHillsPlus", LuaValue.valueOf(34)); //
		luaTable.set("biExtremeHillsPlusM", LuaValue.valueOf(162)); //
		luaTable.set("biFirstBiome", LuaValue.valueOf(0)); //
		luaTable.set("biFirstVariantBiome", LuaValue.valueOf(129)); //
		luaTable.set("biFlowerForest", LuaValue.valueOf(132)); //
		luaTable.set("biForest", LuaValue.valueOf(4)); //
		luaTable.set("biForestHills", LuaValue.valueOf(18)); //
		luaTable.set("biFrozenOcean", LuaValue.valueOf(10)); //
		luaTable.set("biFrozenRiver", LuaValue.valueOf(11)); //
		luaTable.set("biHell", LuaValue.valueOf(8)); //
		luaTable.set("biIceMountains", LuaValue.valueOf(13)); //
		luaTable.set("biIcePlains", LuaValue.valueOf(12)); //
		luaTable.set("biIcePlainsSpikes", LuaValue.valueOf(140)); //
		luaTable.set("biInvalidBiome", LuaValue.valueOf(-1)); //
		luaTable.set("biJungle", LuaValue.valueOf(21)); //
		luaTable.set("biJungleEdge", LuaValue.valueOf(23)); //
		luaTable.set("biJungleEdgeM", LuaValue.valueOf(151)); //
		luaTable.set("biJungleHills", LuaValue.valueOf(22)); //
		luaTable.set("biJungleM", LuaValue.valueOf(149)); //
		luaTable.set("biMaxBiome", LuaValue.valueOf(39)); //
		luaTable.set("biMaxVariantBiome", LuaValue.valueOf(167)); //
		luaTable.set("biMegaSpruceTaiga", LuaValue.valueOf(160)); //
		luaTable.set("biMegaSpruceTaigaHills", LuaValue.valueOf(161)); //
		luaTable.set("biMegaTaiga", LuaValue.valueOf(32)); //
		luaTable.set("biMegaTaigaHills", LuaValue.valueOf(33)); //
		luaTable.set("biMesa", LuaValue.valueOf(37)); //
		luaTable.set("biMesaBryce", LuaValue.valueOf(165)); //
		luaTable.set("biMesaPlateau", LuaValue.valueOf(39)); //
		luaTable.set("biMesaPlateauF", LuaValue.valueOf(38)); //
		luaTable.set("biMesaPlateauFM", LuaValue.valueOf(166)); //
		luaTable.set("biMesaPlateauM", LuaValue.valueOf(167)); //
		luaTable.set("biMushroomIsland", LuaValue.valueOf(14)); //
		luaTable.set("biMushroomShore", LuaValue.valueOf(15)); //
		luaTable.set("biNether", LuaValue.valueOf(8)); //
		luaTable.set("biNumBiomes", LuaValue.valueOf(40)); //
		luaTable.set("biNumVariantBiomes", LuaValue.valueOf(168)); //
		luaTable.set("biOcean", LuaValue.valueOf(0)); //
		luaTable.set("biPlains", LuaValue.valueOf(1)); //
		luaTable.set("biRiver", LuaValue.valueOf(7)); //
		luaTable.set("biRoofedForest", LuaValue.valueOf(29)); //
		luaTable.set("biRoofedForestM", LuaValue.valueOf(157)); //
		luaTable.set("biSavanna", LuaValue.valueOf(35)); //
		luaTable.set("biSavannaM", LuaValue.valueOf(163)); //
		luaTable.set("biSavannaPlateau", LuaValue.valueOf(36)); //
		luaTable.set("biSavannaPlateauM", LuaValue.valueOf(164)); //
		luaTable.set("biSky", LuaValue.valueOf(9)); //
		luaTable.set("biStoneBeach", LuaValue.valueOf(25)); //
		luaTable.set("biSunflowerPlains", LuaValue.valueOf(129)); //
		luaTable.set("biSwampland", LuaValue.valueOf(6)); //
		luaTable.set("biSwamplandM", LuaValue.valueOf(134)); //
		luaTable.set("biTaiga", LuaValue.valueOf(5)); //
		luaTable.set("biTaigaHills", LuaValue.valueOf(19)); //
		luaTable.set("biTaigaM", LuaValue.valueOf(133)); //
		luaTable.set("biTundra", LuaValue.valueOf(12)); //
		luaTable.set("biVariant", LuaValue.valueOf(128)); //
		luaTable.set("E_BLOCK_ACACIA_DOOR", LuaValue.valueOf(196)); //The blocktype for acacia door
		luaTable.set("E_BLOCK_ACACIA_FENCE", LuaValue.valueOf(192)); //The blocktype for acacia fence
		luaTable.set("E_BLOCK_ACACIA_FENCE_GATE", LuaValue.valueOf(187)); //The blocktype for acacia fence gate
		luaTable.set("E_BLOCK_ACACIA_WOOD_STAIRS", LuaValue.valueOf(163)); //The blocktype for acacia wood stairs
		luaTable.set("E_BLOCK_ACTIVATOR_RAIL", LuaValue.valueOf(157)); //The blocktype for activator rail
		luaTable.set("E_BLOCK_ACTIVE_COMPARATOR", LuaValue.valueOf(150)); //The blocktype for active comparator
		luaTable.set("E_BLOCK_AIR", LuaValue.valueOf(0)); //The blocktype for air
		luaTable.set("E_BLOCK_ANVIL", LuaValue.valueOf(145)); //The blocktype for anvil
		luaTable.set("E_BLOCK_ANVIL_HIGH_DAMAGE", LuaValue.valueOf(8)); //The blocktype for anvil high damage
		luaTable.set("E_BLOCK_ANVIL_LOW_DAMAGE", LuaValue.valueOf(4)); //The blocktype for anvil low damage
		luaTable.set("E_BLOCK_ANVIL_NO_DAMAGE", LuaValue.valueOf(0)); //The blocktype for anvil no damage
		luaTable.set("E_BLOCK_ANVIL_X", LuaValue.valueOf(1)); //The blocktype for anvil x
		luaTable.set("E_BLOCK_ANVIL_Z", LuaValue.valueOf(0)); //The blocktype for anvil z
		luaTable.set("E_BLOCK_BARRIER", LuaValue.valueOf(166)); //The blocktype for barrier
		luaTable.set("E_BLOCK_BEACON", LuaValue.valueOf(138)); //The blocktype for beacon
		luaTable.set("E_BLOCK_BED", LuaValue.valueOf(26)); //The blocktype for bed
		luaTable.set("E_BLOCK_BEDROCK", LuaValue.valueOf(7)); //The blocktype for bedrock
		luaTable.set("E_BLOCK_BED_BED_HEAD", LuaValue.valueOf(8)); //The blocktype for bed bed head
		luaTable.set("E_BLOCK_BED_OCCUPIED", LuaValue.valueOf(4)); //The blocktype for bed occupied
		luaTable.set("E_BLOCK_BED_XM", LuaValue.valueOf(1)); //The blocktype for bed xm
		luaTable.set("E_BLOCK_BED_XP", LuaValue.valueOf(3)); //The blocktype for bed xp
		luaTable.set("E_BLOCK_BED_ZM", LuaValue.valueOf(2)); //The blocktype for bed zm
		luaTable.set("E_BLOCK_BED_ZP", LuaValue.valueOf(0)); //The blocktype for bed zp
		luaTable.set("E_BLOCK_BEETROOTS", LuaValue.valueOf(207)); //The blocktype for beetroots
		luaTable.set("E_BLOCK_BIG_FLOWER", LuaValue.valueOf(175)); //The blocktype for big flower
		luaTable.set("E_BLOCK_BIRCH_DOOR", LuaValue.valueOf(194)); //The blocktype for birch door
		luaTable.set("E_BLOCK_BIRCH_FENCE", LuaValue.valueOf(189)); //The blocktype for birch fence
		luaTable.set("E_BLOCK_BIRCH_FENCE_GATE", LuaValue.valueOf(184)); //The blocktype for birch fence gate
		luaTable.set("E_BLOCK_BIRCH_WOOD_STAIRS", LuaValue.valueOf(135)); //The blocktype for birch wood stairs
		luaTable.set("E_BLOCK_BLACK_GLAZED_TERRACOTTA", LuaValue.valueOf(250)); //The blocktype for black terracotta
		luaTable.set("E_BLOCK_BLACK_SHULKER_BOX", LuaValue.valueOf(234)); //The blocktype for black shulker box
		luaTable.set("E_BLOCK_BLOCK_OF_COAL", LuaValue.valueOf(173)); //The blocktype for block of coal
		luaTable.set("E_BLOCK_BLOCK_OF_REDSTONE", LuaValue.valueOf(152)); //The blocktype for block of redstone
		luaTable.set("E_BLOCK_BLUE_GLAZED_TERRACOTTA", LuaValue.valueOf(246)); //The blocktype for blue glazed terracotta
		luaTable.set("E_BLOCK_BLUE_SHULKER_BOX", LuaValue.valueOf(230)); //The blocktype for blue shulker box
		luaTable.set("E_BLOCK_BONE_BLOCK", LuaValue.valueOf(216)); //The blocktype for bone block
		luaTable.set("E_BLOCK_BOOKCASE", LuaValue.valueOf(47)); //The blocktype for bookcase
		luaTable.set("E_BLOCK_BREWING_STAND", LuaValue.valueOf(117)); //The blocktype for brewing stand
		luaTable.set("E_BLOCK_BRICK", LuaValue.valueOf(45)); //The blocktype for brick
		luaTable.set("E_BLOCK_BRICK_STAIRS", LuaValue.valueOf(108)); //The blocktype for brick stairs
		luaTable.set("E_BLOCK_BROWN_GLAZED_TERRACOTTA", LuaValue.valueOf(247)); //The blocktype for brown glazed terracotta
		luaTable.set("E_BLOCK_BROWN_MUSHROOM", LuaValue.valueOf(39)); //The blocktype for brown mushroom
		luaTable.set("E_BLOCK_BROWN_SHULKER_BOX", LuaValue.valueOf(231)); //The blocktype for brown shulker box
		luaTable.set("E_BLOCK_BURNING_FURNACE", LuaValue.valueOf(62)); //The blocktype for burning furnace
		luaTable.set("E_BLOCK_BUTTON_PRESSED", LuaValue.valueOf(8)); //The blocktype for button pressed
		luaTable.set("E_BLOCK_BUTTON_XM", LuaValue.valueOf(2)); //The blocktype for button xm
		luaTable.set("E_BLOCK_BUTTON_XP", LuaValue.valueOf(1)); //The blocktype for button xp
		luaTable.set("E_BLOCK_BUTTON_YM", LuaValue.valueOf(0)); //The blocktype for button ym
		luaTable.set("E_BLOCK_BUTTON_YP", LuaValue.valueOf(5)); //The blocktype for button yp
		luaTable.set("E_BLOCK_BUTTON_ZM", LuaValue.valueOf(4)); //The blocktype for button zm
		luaTable.set("E_BLOCK_BUTTON_ZP", LuaValue.valueOf(3)); //The blocktype for button zp
		luaTable.set("E_BLOCK_CACTUS", LuaValue.valueOf(81)); //The blocktype for cactus
		luaTable.set("E_BLOCK_CAKE", LuaValue.valueOf(92)); //The blocktype for cake
		luaTable.set("E_BLOCK_CARPET", LuaValue.valueOf(171)); //The blocktype for carpet
		luaTable.set("E_BLOCK_CARROTS", LuaValue.valueOf(141)); //The blocktype for carrots
		luaTable.set("E_BLOCK_CAULDRON", LuaValue.valueOf(118)); //The blocktype for cauldron
		luaTable.set("E_BLOCK_CHAIN_COMMAND_BLOCK", LuaValue.valueOf(211)); //The blocktype for chain command block
		luaTable.set("E_BLOCK_CHEST", LuaValue.valueOf(54)); //The blocktype for chest
		luaTable.set("E_BLOCK_CHORUS_FLOWER", LuaValue.valueOf(200)); //The blocktype for chorus flower
		luaTable.set("E_BLOCK_CHORUS_PLANT", LuaValue.valueOf(199)); //The blocktype for chorus plant
		luaTable.set("E_BLOCK_CLAY", LuaValue.valueOf(82)); //The blocktype for clay
		luaTable.set("E_BLOCK_COAL_ORE", LuaValue.valueOf(16)); //The blocktype for coal ore
		luaTable.set("E_BLOCK_COBBLESTONE", LuaValue.valueOf(4)); //The blocktype for cobblestone
		luaTable.set("E_BLOCK_COBBLESTONE_STAIRS", LuaValue.valueOf(67)); //The blocktype for cobblestone stairs
		luaTable.set("E_BLOCK_COBBLESTONE_WALL", LuaValue.valueOf(139)); //The blocktype for cobblestone wall
		luaTable.set("E_BLOCK_COBWEB", LuaValue.valueOf(30)); //The blocktype for cobweb
		luaTable.set("E_BLOCK_COCOA_POD", LuaValue.valueOf(127)); //The blocktype for cocoa pod
		luaTable.set("E_BLOCK_COMMAND_BLOCK", LuaValue.valueOf(137)); //The blocktype for command block
		luaTable.set("E_BLOCK_CONCRETE", LuaValue.valueOf(251)); //The blocktype for concrete
		luaTable.set("E_BLOCK_CONCRETE_POWDER", LuaValue.valueOf(252)); //The blocktype for concrete powder
		luaTable.set("E_BLOCK_CRAFTING_TABLE", LuaValue.valueOf(58)); //The blocktype for crafting table
		luaTable.set("E_BLOCK_CROPS", LuaValue.valueOf(59)); //The blocktype for crops
		luaTable.set("E_BLOCK_CYAN_GLAZED_TERRACOTTA", LuaValue.valueOf(244)); //The blocktype for cyan glazed terracotta
		luaTable.set("E_BLOCK_CYAN_SHULKER_BOX", LuaValue.valueOf(228)); //The blocktype for cyan shulker box
		luaTable.set("E_BLOCK_DANDELION", LuaValue.valueOf(37)); //The blocktype for dandelion
		luaTable.set("E_BLOCK_DARK_OAK_DOOR", LuaValue.valueOf(197)); //The blocktype for dark oak door
		luaTable.set("E_BLOCK_DARK_OAK_FENCE", LuaValue.valueOf(191)); //The blocktype for dark oak fence
		luaTable.set("E_BLOCK_DARK_OAK_FENCE_GATE", LuaValue.valueOf(186)); //The blocktype for dark oak fence gate
		luaTable.set("E_BLOCK_DARK_OAK_WOOD_STAIRS", LuaValue.valueOf(164)); //The blocktype for dark oak wood stairs
		luaTable.set("E_BLOCK_DAYLIGHT_SENSOR", LuaValue.valueOf(151)); //The blocktype for daylight sensor
		luaTable.set("E_BLOCK_DEAD_BUSH", LuaValue.valueOf(32)); //The blocktype for dead bush
		luaTable.set("E_BLOCK_DETECTOR_RAIL", LuaValue.valueOf(28)); //The blocktype for detector rail
		luaTable.set("E_BLOCK_DIAMOND_BLOCK", LuaValue.valueOf(57)); //The blocktype for diamond block
		luaTable.set("E_BLOCK_DIAMOND_ORE", LuaValue.valueOf(56)); //The blocktype for diamond ore
		luaTable.set("E_BLOCK_DIRT", LuaValue.valueOf(3)); //The blocktype for dirt
		luaTable.set("E_BLOCK_DISPENSER", LuaValue.valueOf(23)); //The blocktype for dispenser
		luaTable.set("E_BLOCK_DOUBLE_RED_SANDSTONE_SLAB", LuaValue.valueOf(181)); //The blocktype for double red sandstone slab
		luaTable.set("E_BLOCK_DOUBLE_STONE_SLAB", LuaValue.valueOf(43)); //The blocktype for double stone slab
		luaTable.set("E_BLOCK_DOUBLE_WOODEN_SLAB", LuaValue.valueOf(125)); //The blocktype for double wooden slab
		luaTable.set("E_BLOCK_DRAGON_EGG", LuaValue.valueOf(122)); //The blocktype for dragon egg
		luaTable.set("E_BLOCK_DROPPER", LuaValue.valueOf(158)); //The blocktype for dropper
		luaTable.set("E_BLOCK_EMERALD_BLOCK", LuaValue.valueOf(133)); //The blocktype for emerald block
		luaTable.set("E_BLOCK_EMERALD_ORE", LuaValue.valueOf(129)); //The blocktype for emerald ore
		luaTable.set("E_BLOCK_ENCHANTMENT_TABLE", LuaValue.valueOf(116)); //The blocktype for enchantment table
		luaTable.set("E_BLOCK_ENDER_CHEST", LuaValue.valueOf(130)); //The blocktype for ender chest
		luaTable.set("E_BLOCK_END_BRICKS", LuaValue.valueOf(206)); //The blocktype for end bricks
		luaTable.set("E_BLOCK_END_GATEWAY", LuaValue.valueOf(209)); //The blocktype for end gateway
		luaTable.set("E_BLOCK_END_PORTAL", LuaValue.valueOf(119)); //The blocktype for end portal
		luaTable.set("E_BLOCK_END_PORTAL_FRAME", LuaValue.valueOf(120)); //The blocktype for end portal frame
		luaTable.set("E_BLOCK_END_ROD", LuaValue.valueOf(198)); //The blocktype for end rod
		luaTable.set("E_BLOCK_END_STONE", LuaValue.valueOf(121)); //The blocktype for end stone
		luaTable.set("E_BLOCK_FARMLAND", LuaValue.valueOf(60)); //The blocktype for farmland
		luaTable.set("E_BLOCK_FENCE", LuaValue.valueOf(85)); //The blocktype for fence
		luaTable.set("E_BLOCK_FENCE_GATE", LuaValue.valueOf(107)); //The blocktype for fence gate
		luaTable.set("E_BLOCK_FIRE", LuaValue.valueOf(51)); //The blocktype for fire
		luaTable.set("E_BLOCK_FLOWER", LuaValue.valueOf(38)); //The blocktype for flower
		luaTable.set("E_BLOCK_FLOWER_POT", LuaValue.valueOf(140)); //The blocktype for flower pot
		luaTable.set("E_BLOCK_FROSTED_ICE", LuaValue.valueOf(212)); //The blocktype for frosted ice
		luaTable.set("E_BLOCK_FURNACE", LuaValue.valueOf(61)); //The blocktype for furnace
		luaTable.set("E_BLOCK_GLASS", LuaValue.valueOf(20)); //The blocktype for glass
		luaTable.set("E_BLOCK_GLASS_PANE", LuaValue.valueOf(102)); //The blocktype for glass pane
		luaTable.set("E_BLOCK_GLOWSTONE", LuaValue.valueOf(89)); //The blocktype for glowstone
		luaTable.set("E_BLOCK_GOLD_BLOCK", LuaValue.valueOf(41)); //The blocktype for gold block
		luaTable.set("E_BLOCK_GOLD_ORE", LuaValue.valueOf(14)); //The blocktype for gold ore
		luaTable.set("E_BLOCK_GRASS", LuaValue.valueOf(2)); //The blocktype for grass
		luaTable.set("E_BLOCK_GRASS_PATH", LuaValue.valueOf(208)); //The blocktype for grass path
		luaTable.set("E_BLOCK_GRAVEL", LuaValue.valueOf(13)); //The blocktype for gravel
		luaTable.set("E_BLOCK_GRAY_GLAZED_TERRACOTTA", LuaValue.valueOf(242)); //The blocktype for gray glazed terracotta
		luaTable.set("E_BLOCK_GRAY_SHULKER_BOX", LuaValue.valueOf(226)); //The blocktype for gray shulker box
		luaTable.set("E_BLOCK_GREEN_GLAZED_TERRACOTTA", LuaValue.valueOf(248)); //The blocktype for green glazed terracotta
		luaTable.set("E_BLOCK_GREEN_SHULKER_BOX", LuaValue.valueOf(232)); //The blocktype for green shulker box
		luaTable.set("E_BLOCK_HARDENED_CLAY", LuaValue.valueOf(172)); //The blocktype for hardened clay
		luaTable.set("E_BLOCK_HAY_BALE", LuaValue.valueOf(170)); //The blocktype for hay bale
		luaTable.set("E_BLOCK_HEAD", LuaValue.valueOf(144)); //The blocktype for head
		luaTable.set("E_BLOCK_HEAVY_WEIGHTED_PRESSURE_PLATE", LuaValue.valueOf(148)); //The blocktype for heavy weighted pressure plate
		luaTable.set("E_BLOCK_HOPPER", LuaValue.valueOf(154)); //The blocktype for hopper
		luaTable.set("E_BLOCK_HUGE_BROWN_MUSHROOM", LuaValue.valueOf(99)); //The blocktype for huge brown mushroom
		luaTable.set("E_BLOCK_HUGE_RED_MUSHROOM", LuaValue.valueOf(100)); //The blocktype for huge red mushroom
		luaTable.set("E_BLOCK_ICE", LuaValue.valueOf(79)); //The blocktype for ice
		luaTable.set("E_BLOCK_INACTIVE_COMPARATOR", LuaValue.valueOf(149)); //The blocktype for inactive comparator
		luaTable.set("E_BLOCK_INVERTED_DAYLIGHT_SENSOR", LuaValue.valueOf(178)); //The blocktype for inverted daylight sensor
		luaTable.set("E_BLOCK_IRON_BARS", LuaValue.valueOf(101)); //The blocktype for iron bars
		luaTable.set("E_BLOCK_IRON_BLOCK", LuaValue.valueOf(42)); //The blocktype for iron block
		luaTable.set("E_BLOCK_IRON_DOOR", LuaValue.valueOf(71)); //The blocktype for iron door
		luaTable.set("E_BLOCK_IRON_ORE", LuaValue.valueOf(15)); //The blocktype for iron ore
		luaTable.set("E_BLOCK_IRON_TRAPDOOR", LuaValue.valueOf(167)); //The blocktype for iron trapdoor
		luaTable.set("E_BLOCK_JACK_O_LANTERN", LuaValue.valueOf(91)); //The blocktype for jack o lantern
		luaTable.set("E_BLOCK_JUKEBOX", LuaValue.valueOf(84)); //The blocktype for jukebox
		luaTable.set("E_BLOCK_JUNGLE_DOOR", LuaValue.valueOf(195)); //The blocktype for jungle door
		luaTable.set("E_BLOCK_JUNGLE_FENCE", LuaValue.valueOf(190)); //The blocktype for jungle fence
		luaTable.set("E_BLOCK_JUNGLE_FENCE_GATE", LuaValue.valueOf(185)); //The blocktype for jungle fence gate
		luaTable.set("E_BLOCK_JUNGLE_WOOD_STAIRS", LuaValue.valueOf(136)); //The blocktype for jungle wood stairs
		luaTable.set("E_BLOCK_LADDER", LuaValue.valueOf(65)); //The blocktype for ladder
		luaTable.set("E_BLOCK_LAPIS_BLOCK", LuaValue.valueOf(22)); //The blocktype for lapis block
		luaTable.set("E_BLOCK_LAPIS_ORE", LuaValue.valueOf(21)); //The blocktype for lapis ore
		luaTable.set("E_BLOCK_LAVA", LuaValue.valueOf(10)); //The blocktype for lava
		luaTable.set("E_BLOCK_LEAVES", LuaValue.valueOf(18)); //The blocktype for leaves
		luaTable.set("E_BLOCK_LEVER", LuaValue.valueOf(69)); //The blocktype for lever
		luaTable.set("E_BLOCK_LIGHT_BLUE_GLAZED_TERRACOTTA", LuaValue.valueOf(238)); //The blocktype for light blue glazed terracotta
		luaTable.set("E_BLOCK_LIGHT_BLUE_SHULKER_BOX", LuaValue.valueOf(222)); //The blocktype for light blue shulker box
		luaTable.set("E_BLOCK_LIGHT_GRAY_GLAZED_TERRACOTTA", LuaValue.valueOf(243)); //The blocktype for light gray glazed terracotta
		luaTable.set("E_BLOCK_LIGHT_GRAY_SHULKER_BOX", LuaValue.valueOf(227)); //The blocktype for light gray shulker box
		luaTable.set("E_BLOCK_LIGHT_WEIGHTED_PRESSURE_PLATE", LuaValue.valueOf(147)); //The blocktype for light weighted pressure plate
		luaTable.set("E_BLOCK_LILY_PAD", LuaValue.valueOf(111)); //The blocktype for lily pad
		luaTable.set("E_BLOCK_LIME_GLAZED_TERRACOTTA", LuaValue.valueOf(240)); //The blocktype for lime glazed terracotta
		luaTable.set("E_BLOCK_LIME_SHULKER_BOX", LuaValue.valueOf(224)); //The blocktype for lime shulker box
		luaTable.set("E_BLOCK_LIT_FURNACE", LuaValue.valueOf(62)); //The blocktype for lit furnace
		luaTable.set("E_BLOCK_LOG", LuaValue.valueOf(17)); //The blocktype for log
		luaTable.set("E_BLOCK_MAGENTA_GLAZED_TERRACOTTA", LuaValue.valueOf(237)); //The blocktype for magenta glazed terracotta
		luaTable.set("E_BLOCK_MAGENTA_SHULKER_BOX", LuaValue.valueOf(221)); //The blocktype for magenta shulker box
		luaTable.set("E_BLOCK_MAGMA", LuaValue.valueOf(213)); //The blocktype for magma
		luaTable.set("E_BLOCK_MAX_TYPE_ID", LuaValue.valueOf(252)); //The blocktype for max type id
		luaTable.set("E_BLOCK_MELON", LuaValue.valueOf(103)); //The blocktype for melon
		luaTable.set("E_BLOCK_MELON_STEM", LuaValue.valueOf(105)); //The blocktype for melon stem
		luaTable.set("E_BLOCK_MINECART_TRACKS", LuaValue.valueOf(66)); //The blocktype for minecart tracks
		luaTable.set("E_BLOCK_MOB_SPAWNER", LuaValue.valueOf(52)); //The blocktype for mob spawner
		luaTable.set("E_BLOCK_MOSSY_COBBLESTONE", LuaValue.valueOf(48)); //The blocktype for mossy cobblestone
		luaTable.set("E_BLOCK_MYCELIUM", LuaValue.valueOf(110)); //The blocktype for mycelium
		luaTable.set("E_BLOCK_NETHERRACK", LuaValue.valueOf(87)); //The blocktype for netherrack
		luaTable.set("E_BLOCK_NETHER_BRICK", LuaValue.valueOf(112)); //The blocktype for nether brick
		luaTable.set("E_BLOCK_NETHER_BRICK_FENCE", LuaValue.valueOf(113)); //The blocktype for nether brick fence
		luaTable.set("E_BLOCK_NETHER_BRICK_STAIRS", LuaValue.valueOf(114)); //The blocktype for nether brick stairs
		luaTable.set("E_BLOCK_NETHER_PORTAL", LuaValue.valueOf(90)); //The blocktype for nether portal
		luaTable.set("E_BLOCK_NETHER_QUARTZ_ORE", LuaValue.valueOf(153)); //The blocktype for nether quartz ore
		luaTable.set("E_BLOCK_NETHER_WART", LuaValue.valueOf(115)); //The blocktype for nether wart
		luaTable.set("E_BLOCK_NETHER_WART_BLOCK", LuaValue.valueOf(214)); //The blocktype for nether wart block
		luaTable.set("E_BLOCK_NEW_LEAVES", LuaValue.valueOf(161)); //The blocktype for new leaves
		luaTable.set("E_BLOCK_NEW_LOG", LuaValue.valueOf(162)); //The blocktype for new log
		luaTable.set("E_BLOCK_NOTE_BLOCK", LuaValue.valueOf(25)); //The blocktype for note block
		luaTable.set("E_BLOCK_NUMBER_OF_TYPES", LuaValue.valueOf(253)); //The blocktype for number of types
		luaTable.set("E_BLOCK_OAK_DOOR", LuaValue.valueOf(64)); //The blocktype for oak door
		luaTable.set("E_BLOCK_OAK_FENCE_GATE", LuaValue.valueOf(107)); //The blocktype for oak fence gate
		luaTable.set("E_BLOCK_OAK_WOOD_STAIRS", LuaValue.valueOf(53)); //The blocktype for oak wood stairs
		luaTable.set("E_BLOCK_OBSERVER", LuaValue.valueOf(218)); //The blocktype for observer
		luaTable.set("E_BLOCK_OBSIDIAN", LuaValue.valueOf(49)); //The blocktype for obsidian
		luaTable.set("E_BLOCK_ORANGE_GLAZED_TERRACOTTA", LuaValue.valueOf(236)); //The blocktype for orange glazed terracota
		luaTable.set("E_BLOCK_ORANGE_SHULKER_BOX", LuaValue.valueOf(220)); //The blocktype for orange shulker box
		luaTable.set("E_BLOCK_PACKED_ICE", LuaValue.valueOf(174)); //The blocktype for packed ice
		luaTable.set("E_BLOCK_PINK_GLAZED_TERRACOTTA", LuaValue.valueOf(241)); //The blocktype for pink glazed terracotta
		luaTable.set("E_BLOCK_PINK_SHULKER_BOX", LuaValue.valueOf(225)); //The blocktype for pink shulker box
		luaTable.set("E_BLOCK_PISTON", LuaValue.valueOf(33)); //The blocktype for piston
		luaTable.set("E_BLOCK_PISTON_EXTENSION", LuaValue.valueOf(34)); //The blocktype for piston extension
		luaTable.set("E_BLOCK_PISTON_MOVED_BLOCK", LuaValue.valueOf(36)); //The blocktype for piston moved block
		luaTable.set("E_BLOCK_PLANKS", LuaValue.valueOf(5)); //The blocktype for planks
		luaTable.set("E_BLOCK_POTATOES", LuaValue.valueOf(142)); //The blocktype for potatoes
		luaTable.set("E_BLOCK_POWERED_RAIL", LuaValue.valueOf(27)); //The blocktype for powered rail
		luaTable.set("E_BLOCK_PRISMARINE_BLOCK", LuaValue.valueOf(168)); //The blocktype for prismarine block
		luaTable.set("E_BLOCK_PUMPKIN", LuaValue.valueOf(86)); //The blocktype for pumpkin
		luaTable.set("E_BLOCK_PUMPKIN_STEM", LuaValue.valueOf(104)); //The blocktype for pumpkin stem
		luaTable.set("E_BLOCK_PURPLE_GLAZED_TERRACOTTA", LuaValue.valueOf(245)); //The blocktype for purple glazed terracotta
		luaTable.set("E_BLOCK_PURPLE_SHULKER_BOX", LuaValue.valueOf(229)); //The blocktype for purple shulker box
		luaTable.set("E_BLOCK_PURPUR_BLOCK", LuaValue.valueOf(201)); //The blocktype for purpur block
		luaTable.set("E_BLOCK_PURPUR_DOUBLE_SLAB", LuaValue.valueOf(204)); //The blocktype for purpur double slab
		luaTable.set("E_BLOCK_PURPUR_PILLAR", LuaValue.valueOf(202)); //The blocktype for purpur pillar
		luaTable.set("E_BLOCK_PURPUR_SLAB", LuaValue.valueOf(205)); //The blocktype for purpur slab
		luaTable.set("E_BLOCK_PURPUR_STAIRS", LuaValue.valueOf(203)); //The blocktype for purpur stairs
		luaTable.set("E_BLOCK_QUARTZ_BLOCK", LuaValue.valueOf(155)); //The blocktype for quartz block
		luaTable.set("E_BLOCK_QUARTZ_STAIRS", LuaValue.valueOf(156)); //The blocktype for quartz stairs
		luaTable.set("E_BLOCK_RAIL", LuaValue.valueOf(66)); //The blocktype for rail
		luaTable.set("E_BLOCK_REDSTONE_LAMP_OFF", LuaValue.valueOf(123)); //The blocktype for redstone lamp off
		luaTable.set("E_BLOCK_REDSTONE_LAMP_ON", LuaValue.valueOf(124)); //The blocktype for redstone lamp on
		luaTable.set("E_BLOCK_REDSTONE_ORE", LuaValue.valueOf(73)); //The blocktype for redstone ore
		luaTable.set("E_BLOCK_REDSTONE_ORE_GLOWING", LuaValue.valueOf(74)); //The blocktype for redstone ore glowing
		luaTable.set("E_BLOCK_REDSTONE_REPEATER_OFF", LuaValue.valueOf(93)); //The blocktype for redstone repeater off
		luaTable.set("E_BLOCK_REDSTONE_REPEATER_ON", LuaValue.valueOf(94)); //The blocktype for redstone repeater on
		luaTable.set("E_BLOCK_REDSTONE_TORCH_OFF", LuaValue.valueOf(75)); //The blocktype for redstone torch off
		luaTable.set("E_BLOCK_REDSTONE_TORCH_ON", LuaValue.valueOf(76)); //The blocktype for redstone torch on
		luaTable.set("E_BLOCK_REDSTONE_WIRE", LuaValue.valueOf(55)); //The blocktype for redstone wire
		luaTable.set("E_BLOCK_RED_GLAZED_TERRACOTTA", LuaValue.valueOf(249)); //The blocktype for red glazed terracotta
		luaTable.set("E_BLOCK_RED_MUSHROOM", LuaValue.valueOf(40)); //The blocktype for red mushroom
		luaTable.set("E_BLOCK_RED_NETHER_BRICK", LuaValue.valueOf(215)); //The blocktype for red nether brick
		luaTable.set("E_BLOCK_RED_ROSE", LuaValue.valueOf(38)); //The blocktype for red rose
		luaTable.set("E_BLOCK_RED_SANDSTONE", LuaValue.valueOf(179)); //The blocktype for red sandstone
		luaTable.set("E_BLOCK_RED_SANDSTONE_SLAB", LuaValue.valueOf(182)); //The blocktype for red sandstone slab
		luaTable.set("E_BLOCK_RED_SANDSTONE_STAIRS", LuaValue.valueOf(180)); //The blocktype for red sandstone stairs
		luaTable.set("E_BLOCK_RED_SHULKER_BOX", LuaValue.valueOf(233)); //The blocktype for red shulker box
		luaTable.set("E_BLOCK_REEDS", LuaValue.valueOf(83)); //The blocktype for reeds
		luaTable.set("E_BLOCK_REPEATING_COMMAND_BLOCK", LuaValue.valueOf(210)); //The blocktype for repeating command block
		luaTable.set("E_BLOCK_SAND", LuaValue.valueOf(12)); //The blocktype for sand
		luaTable.set("E_BLOCK_SANDSTONE", LuaValue.valueOf(24)); //The blocktype for sandstone
		luaTable.set("E_BLOCK_SANDSTONE_STAIRS", LuaValue.valueOf(128)); //The blocktype for sandstone stairs
		luaTable.set("E_BLOCK_SAPLING", LuaValue.valueOf(6)); //The blocktype for sapling
		luaTable.set("E_BLOCK_SEA_LANTERN", LuaValue.valueOf(169)); //The blocktype for sea lantern
		luaTable.set("E_BLOCK_SIGN_POST", LuaValue.valueOf(63)); //The blocktype for sign post
		luaTable.set("E_BLOCK_SILVERFISH_EGG", LuaValue.valueOf(97)); //The blocktype for silverfish egg
		luaTable.set("E_BLOCK_SLIME_BLOCK", LuaValue.valueOf(165)); //The blocktype for slime block
		luaTable.set("E_BLOCK_SNOW", LuaValue.valueOf(78)); //The blocktype for snow
		luaTable.set("E_BLOCK_SNOW_BLOCK", LuaValue.valueOf(80)); //The blocktype for snow block
		luaTable.set("E_BLOCK_SOULSAND", LuaValue.valueOf(88)); //The blocktype for soulsand
		luaTable.set("E_BLOCK_SPONGE", LuaValue.valueOf(19)); //The blocktype for sponge
		luaTable.set("E_BLOCK_SPRUCE_DOOR", LuaValue.valueOf(193)); //The blocktype for spruce door
		luaTable.set("E_BLOCK_SPRUCE_FENCE", LuaValue.valueOf(188)); //The blocktype for spruce fence
		luaTable.set("E_BLOCK_SPRUCE_FENCE_GATE", LuaValue.valueOf(183)); //The blocktype for spruce fence gate
		luaTable.set("E_BLOCK_SPRUCE_WOOD_STAIRS", LuaValue.valueOf(134)); //The blocktype for spruce wood stairs
		luaTable.set("E_BLOCK_STAINED_CLAY", LuaValue.valueOf(159)); //The blocktype for stained clay
		luaTable.set("E_BLOCK_STAINED_GLASS", LuaValue.valueOf(95)); //The blocktype for stained glass
		luaTable.set("E_BLOCK_STAINED_GLASS_PANE", LuaValue.valueOf(160)); //The blocktype for stained glass pane
		luaTable.set("E_BLOCK_STAIRS_UPSIDE_DOWN", LuaValue.valueOf(4)); //The blocktype for stairs upside down
		luaTable.set("E_BLOCK_STAIRS_XM", LuaValue.valueOf(1)); //The blocktype for stairs xm
		luaTable.set("E_BLOCK_STAIRS_XP", LuaValue.valueOf(0)); //The blocktype for stairs xp
		luaTable.set("E_BLOCK_STAIRS_ZM", LuaValue.valueOf(3)); //The blocktype for stairs zm
		luaTable.set("E_BLOCK_STAIRS_ZP", LuaValue.valueOf(2)); //The blocktype for stairs zp
		luaTable.set("E_BLOCK_STANDING_BANNER", LuaValue.valueOf(176)); //The blocktype for standing banner
		luaTable.set("E_BLOCK_STATIONARY_LAVA", LuaValue.valueOf(11)); //The blocktype for stationary lava
		luaTable.set("E_BLOCK_STATIONARY_WATER", LuaValue.valueOf(9)); //The blocktype for stationary water
		luaTable.set("E_BLOCK_STICKY_PISTON", LuaValue.valueOf(29)); //The blocktype for sticky piston
		luaTable.set("E_BLOCK_STONE", LuaValue.valueOf(1)); //The blocktype for stone
		luaTable.set("E_BLOCK_STONE_BRICKS", LuaValue.valueOf(98)); //The blocktype for stone bricks
		luaTable.set("E_BLOCK_STONE_BRICK_STAIRS", LuaValue.valueOf(109)); //The blocktype for stone brick stairs
		luaTable.set("E_BLOCK_STONE_BUTTON", LuaValue.valueOf(77)); //The blocktype for stone button
		luaTable.set("E_BLOCK_STONE_PRESSURE_PLATE", LuaValue.valueOf(70)); //The blocktype for stone pressure plate
		luaTable.set("E_BLOCK_STONE_SLAB", LuaValue.valueOf(44)); //The blocktype for stone slab
		luaTable.set("E_BLOCK_STRUCTURE_BLOCK", LuaValue.valueOf(255)); //The blocktype for structure block
		luaTable.set("E_BLOCK_STRUCTURE_VOID", LuaValue.valueOf(217)); //The blocktype for structure void
		luaTable.set("E_BLOCK_SUGARCANE", LuaValue.valueOf(83)); //The blocktype for sugarcane
		luaTable.set("E_BLOCK_TALL_GRASS", LuaValue.valueOf(31)); //The blocktype for tall grass
		luaTable.set("E_BLOCK_TERRACOTTA", LuaValue.valueOf(159)); //The blocktype for terracotta (synonym for E_BLOCK_STAINED_CLAY)
		luaTable.set("E_BLOCK_TNT", LuaValue.valueOf(46)); //The blocktype for tnt
		luaTable.set("E_BLOCK_TORCH", LuaValue.valueOf(50)); //The blocktype for torch
		luaTable.set("E_BLOCK_TRAPDOOR", LuaValue.valueOf(96)); //The blocktype for trapdoor
		luaTable.set("E_BLOCK_TRAPPED_CHEST", LuaValue.valueOf(146)); //The blocktype for trapped chest
		luaTable.set("E_BLOCK_TRIPWIRE", LuaValue.valueOf(132)); //The blocktype for tripwire
		luaTable.set("E_BLOCK_TRIPWIRE_HOOK", LuaValue.valueOf(131)); //The blocktype for tripwire hook
		luaTable.set("E_BLOCK_UNFINISHED", LuaValue.valueOf(254)); //Internal blocktype for unfinished block handlers
		luaTable.set("E_BLOCK_VINES", LuaValue.valueOf(106)); //The blocktype for vines
		luaTable.set("E_BLOCK_WALLSIGN", LuaValue.valueOf(68)); //The blocktype for wallsign
		luaTable.set("E_BLOCK_WALL_BANNER", LuaValue.valueOf(177)); //The blocktype for wall banner
		luaTable.set("E_BLOCK_WATER", LuaValue.valueOf(8)); //The blocktype for water
		luaTable.set("E_BLOCK_WHEAT", LuaValue.valueOf(59)); //
		luaTable.set("E_BLOCK_WHITE_GLAZED_TERRACOTTA", LuaValue.valueOf(235)); //The blocktype for white glazed terracotta
		luaTable.set("E_BLOCK_WHITE_SHULKER_BOX", LuaValue.valueOf(219)); //The blocktype for white shulker box
		luaTable.set("E_BLOCK_WOODEN_BUTTON", LuaValue.valueOf(143)); //The blocktype for wooden button
		luaTable.set("E_BLOCK_WOODEN_DOOR", LuaValue.valueOf(64)); //The blocktype for wooden door
		luaTable.set("E_BLOCK_WOODEN_PRESSURE_PLATE", LuaValue.valueOf(72)); //The blocktype for wooden pressure plate
		luaTable.set("E_BLOCK_WOODEN_SLAB", LuaValue.valueOf(126)); //The blocktype for wooden slab
		luaTable.set("E_BLOCK_WOODEN_STAIRS", LuaValue.valueOf(53)); //The blocktype for wooden stairs
		luaTable.set("E_BLOCK_WOOL", LuaValue.valueOf(35)); //The blocktype for wool
		luaTable.set("E_BLOCK_WORKBENCH", LuaValue.valueOf(58)); //The blocktype for workbench
		luaTable.set("E_BLOCK_YELLOW_FLOWER", LuaValue.valueOf(37)); //The blocktype for yellow flower
		luaTable.set("E_BLOCK_YELLOW_GLAZED_TERRACOTTA", LuaValue.valueOf(239)); //The blocktype for yellow glazed terracotta
		luaTable.set("E_BLOCK_YELLOW_SHULKER_BOX", LuaValue.valueOf(223)); //The blocktype for yellow shulker box
		luaTable.set("E_ITEM_11_DISC", LuaValue.valueOf(2266)); //The itemtype for 11 disc
		luaTable.set("E_ITEM_13_DISC", LuaValue.valueOf(2256)); //The itemtype for 13 disc
		luaTable.set("E_ITEM_ACACIA_BOAT", LuaValue.valueOf(447)); //The itemtype for acacia boat
		luaTable.set("E_ITEM_ACACIA_DOOR", LuaValue.valueOf(430)); //The itemtype for acacia door
		luaTable.set("E_ITEM_ARMOR_STAND", LuaValue.valueOf(416)); //The itemtype for armor stand
		luaTable.set("E_ITEM_ARROW", LuaValue.valueOf(262)); //The itemtype for arrow
		luaTable.set("E_ITEM_BAKED_POTATO", LuaValue.valueOf(393)); //The itemtype for baked potato
		luaTable.set("E_ITEM_BANNER", LuaValue.valueOf(425)); //The itemtype for banner
		luaTable.set("E_ITEM_BED", LuaValue.valueOf(355)); //The itemtype for bed
		luaTable.set("E_ITEM_BEETROOT", LuaValue.valueOf(434)); //The itemtype for beetroot
		luaTable.set("E_ITEM_BEETROOT_SEEDS", LuaValue.valueOf(435)); //The itemtype for beetroot seeds
		luaTable.set("E_ITEM_BEETROOT_SOUP", LuaValue.valueOf(436)); //The itemtype for betroot soup
		luaTable.set("E_ITEM_BIRCH_BOAT", LuaValue.valueOf(445)); //The itemtype for birch boat
		luaTable.set("E_ITEM_BIRCH_DOOR", LuaValue.valueOf(428)); //The itemtype for birch door
		luaTable.set("E_ITEM_BLAZE_POWDER", LuaValue.valueOf(377)); //The itemtype for blaze powder
		luaTable.set("E_ITEM_BLAZE_ROD", LuaValue.valueOf(369)); //The itemtype for blaze rod
		luaTable.set("E_ITEM_BLOCKS_DISC", LuaValue.valueOf(2258)); //The itemtype for blocks disc
		luaTable.set("E_ITEM_BOAT", LuaValue.valueOf(333)); //The itemtype for boat
		luaTable.set("E_ITEM_BONE", LuaValue.valueOf(352)); //The itemtype for bone
		luaTable.set("E_ITEM_BOOK", LuaValue.valueOf(340)); //The itemtype for book
		luaTable.set("E_ITEM_BOOK_AND_QUILL", LuaValue.valueOf(386)); //The itemtype for book and quill
		luaTable.set("E_ITEM_BOTTLE_O_ENCHANTING", LuaValue.valueOf(384)); //The itemtype for bottle o enchanting
		luaTable.set("E_ITEM_BOW", LuaValue.valueOf(261)); //The itemtype for bow
		luaTable.set("E_ITEM_BOWL", LuaValue.valueOf(281)); //The itemtype for bowl
		luaTable.set("E_ITEM_BREAD", LuaValue.valueOf(297)); //The itemtype for bread
		luaTable.set("E_ITEM_BREWING_STAND", LuaValue.valueOf(379)); //The itemtype for brewing stand
		luaTable.set("E_ITEM_BUCKET", LuaValue.valueOf(325)); //The itemtype for bucket
		luaTable.set("E_ITEM_CAKE", LuaValue.valueOf(354)); //The itemtype for cake
		luaTable.set("E_ITEM_CARROT", LuaValue.valueOf(391)); //The itemtype for carrot
		luaTable.set("E_ITEM_CARROT_ON_STICK", LuaValue.valueOf(398)); //The itemtype for carrot on stick
		luaTable.set("E_ITEM_CAT_DISC", LuaValue.valueOf(2257)); //The itemtype for cat disc
		luaTable.set("E_ITEM_CAULDRON", LuaValue.valueOf(380)); //The itemtype for cauldron
		luaTable.set("E_ITEM_CHAIN_BOOTS", LuaValue.valueOf(305)); //The itemtype for chain boots
		luaTable.set("E_ITEM_CHAIN_CHESTPLATE", LuaValue.valueOf(303)); //The itemtype for chain chestplate
		luaTable.set("E_ITEM_CHAIN_HELMET", LuaValue.valueOf(302)); //The itemtype for chain helmet
		luaTable.set("E_ITEM_CHAIN_LEGGINGS", LuaValue.valueOf(304)); //The itemtype for chain leggings
		luaTable.set("E_ITEM_CHEST_MINECART", LuaValue.valueOf(342)); //The itemtype for chest minecart
		luaTable.set("E_ITEM_CHIRP_DISC", LuaValue.valueOf(2259)); //The itemtype for chirp disc
		luaTable.set("E_ITEM_CHORUS_FRUIT", LuaValue.valueOf(432)); //The itemtype for chorus fruit
		luaTable.set("E_ITEM_CLAY", LuaValue.valueOf(337)); //The itemtype for clay
		luaTable.set("E_ITEM_CLAY_BRICK", LuaValue.valueOf(336)); //The itemtype for clay brick
		luaTable.set("E_ITEM_CLOCK", LuaValue.valueOf(347)); //The itemtype for clock
		luaTable.set("E_ITEM_COAL", LuaValue.valueOf(263)); //The itemtype for coal
		luaTable.set("E_ITEM_COMPARATOR", LuaValue.valueOf(404)); //The itemtype for comparator
		luaTable.set("E_ITEM_COMPASS", LuaValue.valueOf(345)); //The itemtype for compass
		luaTable.set("E_ITEM_COOKED_CHICKEN", LuaValue.valueOf(366)); //The itemtype for cooked chicken
		luaTable.set("E_ITEM_COOKED_FISH", LuaValue.valueOf(350)); //The itemtype for cooked fish
		luaTable.set("E_ITEM_COOKED_MUTTON", LuaValue.valueOf(424)); //The itemtype for cooked mutton
		luaTable.set("E_ITEM_COOKED_PORKCHOP", LuaValue.valueOf(320)); //The itemtype for cooked porkchop
		luaTable.set("E_ITEM_COOKED_RABBIT", LuaValue.valueOf(412)); //The itemtype for cooked rabbit
		luaTable.set("E_ITEM_COOKIE", LuaValue.valueOf(357)); //The itemtype for cookie
		luaTable.set("E_ITEM_DARK_OAK_BOAT", LuaValue.valueOf(448)); //The itemtype for dark oak boat
		luaTable.set("E_ITEM_DARK_OAK_DOOR", LuaValue.valueOf(431)); //The itemtype for dark oak door
		luaTable.set("E_ITEM_DIAMOND", LuaValue.valueOf(264)); //The itemtype for diamond
		luaTable.set("E_ITEM_DIAMOND_AXE", LuaValue.valueOf(279)); //The itemtype for diamond axe
		luaTable.set("E_ITEM_DIAMOND_BOOTS", LuaValue.valueOf(313)); //The itemtype for diamond boots
		luaTable.set("E_ITEM_DIAMOND_CHESTPLATE", LuaValue.valueOf(311)); //The itemtype for diamond chestplate
		luaTable.set("E_ITEM_DIAMOND_HELMET", LuaValue.valueOf(310)); //The itemtype for diamond helmet
		luaTable.set("E_ITEM_DIAMOND_HOE", LuaValue.valueOf(293)); //The itemtype for diamond hoe
		luaTable.set("E_ITEM_DIAMOND_HORSE_ARMOR", LuaValue.valueOf(419)); //The itemtype for diamond horse armor
		luaTable.set("E_ITEM_DIAMOND_LEGGINGS", LuaValue.valueOf(312)); //The itemtype for diamond leggings
		luaTable.set("E_ITEM_DIAMOND_PICKAXE", LuaValue.valueOf(278)); //The itemtype for diamond pickaxe
		luaTable.set("E_ITEM_DIAMOND_SHOVEL", LuaValue.valueOf(277)); //The itemtype for diamond shovel
		luaTable.set("E_ITEM_DIAMOND_SWORD", LuaValue.valueOf(276)); //The itemtype for diamond sword
		luaTable.set("E_ITEM_DRAGON_BREATH", LuaValue.valueOf(437)); //The itemtype for dragon breath
		luaTable.set("E_ITEM_DYE", LuaValue.valueOf(351)); //The itemtype for dye
		luaTable.set("E_ITEM_EGG", LuaValue.valueOf(344)); //The itemtype for egg
		luaTable.set("E_ITEM_ELYTRA", LuaValue.valueOf(443)); //The itemtype for elytra
		luaTable.set("E_ITEM_EMERALD", LuaValue.valueOf(388)); //The itemtype for emerald
		luaTable.set("E_ITEM_EMPTY", LuaValue.valueOf(-1)); //The itemtype for empty
		luaTable.set("E_ITEM_EMPTY_MAP", LuaValue.valueOf(395)); //The itemtype for empty map
		luaTable.set("E_ITEM_ENCHANTED_BOOK", LuaValue.valueOf(403)); //The itemtype for enchanted book
		luaTable.set("E_ITEM_ENDER_PEARL", LuaValue.valueOf(368)); //The itemtype for ender pearl
		luaTable.set("E_ITEM_END_CRYSTAL", LuaValue.valueOf(426)); //The itemtype for end crystal
		luaTable.set("E_ITEM_EYE_OF_ENDER", LuaValue.valueOf(381)); //The itemtype for eye of ender
		luaTable.set("E_ITEM_FAR_DISC", LuaValue.valueOf(2260)); //The itemtype for far disc
		luaTable.set("E_ITEM_FEATHER", LuaValue.valueOf(288)); //The itemtype for feather
		luaTable.set("E_ITEM_FERMENTED_SPIDER_EYE", LuaValue.valueOf(376)); //The itemtype for fermented spider eye
		luaTable.set("E_ITEM_FIREWORK_ROCKET", LuaValue.valueOf(401)); //The itemtype for firework rocket
		luaTable.set("E_ITEM_FIREWORK_STAR", LuaValue.valueOf(402)); //The itemtype for firework star
		luaTable.set("E_ITEM_FIRE_CHARGE", LuaValue.valueOf(385)); //The itemtype for fire charge
		luaTable.set("E_ITEM_FIRST", LuaValue.valueOf(256)); //The itemtype for first
		luaTable.set("E_ITEM_FIRST_DISC", LuaValue.valueOf(2256)); //The itemtype for first disc
		luaTable.set("E_ITEM_FISHING_ROD", LuaValue.valueOf(346)); //The itemtype for fishing rod
		luaTable.set("E_ITEM_FLINT", LuaValue.valueOf(318)); //The itemtype for flint
		luaTable.set("E_ITEM_FLINT_AND_STEEL", LuaValue.valueOf(259)); //The itemtype for flint and steel
		luaTable.set("E_ITEM_FLOWER_POT", LuaValue.valueOf(390)); //The itemtype for flower pot
		luaTable.set("E_ITEM_FURNACE_MINECART", LuaValue.valueOf(343)); //The itemtype for furnace minecart
		luaTable.set("E_ITEM_GHAST_TEAR", LuaValue.valueOf(370)); //The itemtype for ghast tear
		luaTable.set("E_ITEM_GLASS_BOTTLE", LuaValue.valueOf(374)); //The itemtype for glass bottle
		luaTable.set("E_ITEM_GLISTERING_MELON", LuaValue.valueOf(382)); //The itemtype for glistering melon
		luaTable.set("E_ITEM_GLOWSTONE_DUST", LuaValue.valueOf(348)); //The itemtype for glowstone dust
		luaTable.set("E_ITEM_GOLD", LuaValue.valueOf(266)); //The itemtype for gold
		luaTable.set("E_ITEM_GOLDEN_APPLE", LuaValue.valueOf(322)); //The itemtype for golden apple
		luaTable.set("E_ITEM_GOLDEN_CARROT", LuaValue.valueOf(396)); //The itemtype for golden carrot
		luaTable.set("E_ITEM_GOLD_AXE", LuaValue.valueOf(286)); //The itemtype for gold axe
		luaTable.set("E_ITEM_GOLD_BOOTS", LuaValue.valueOf(317)); //The itemtype for gold boots
		luaTable.set("E_ITEM_GOLD_CHESTPLATE", LuaValue.valueOf(315)); //The itemtype for gold chestplate
		luaTable.set("E_ITEM_GOLD_HELMET", LuaValue.valueOf(314)); //The itemtype for gold helmet
		luaTable.set("E_ITEM_GOLD_HOE", LuaValue.valueOf(294)); //The itemtype for gold hoe
		luaTable.set("E_ITEM_GOLD_HORSE_ARMOR", LuaValue.valueOf(418)); //The itemtype for gold horse armor
		luaTable.set("E_ITEM_GOLD_LEGGINGS", LuaValue.valueOf(316)); //The itemtype for gold leggings
		luaTable.set("E_ITEM_GOLD_NUGGET", LuaValue.valueOf(371)); //The itemtype for gold nugget
		luaTable.set("E_ITEM_GOLD_PICKAXE", LuaValue.valueOf(285)); //The itemtype for gold pickaxe
		luaTable.set("E_ITEM_GOLD_SHOVEL", LuaValue.valueOf(284)); //The itemtype for gold shovel
		luaTable.set("E_ITEM_GOLD_SWORD", LuaValue.valueOf(283)); //The itemtype for gold sword
		luaTable.set("E_ITEM_GUNPOWDER", LuaValue.valueOf(289)); //The itemtype for gunpowder
		luaTable.set("E_ITEM_HEAD", LuaValue.valueOf(397)); //The itemtype for head
		luaTable.set("E_ITEM_IRON", LuaValue.valueOf(265)); //The itemtype for iron
		luaTable.set("E_ITEM_IRON_AXE", LuaValue.valueOf(258)); //The itemtype for iron axe
		luaTable.set("E_ITEM_IRON_BOOTS", LuaValue.valueOf(309)); //The itemtype for iron boots
		luaTable.set("E_ITEM_IRON_CHESTPLATE", LuaValue.valueOf(307)); //The itemtype for iron chestplate
		luaTable.set("E_ITEM_IRON_DOOR", LuaValue.valueOf(330)); //The itemtype for iron door
		luaTable.set("E_ITEM_IRON_HELMET", LuaValue.valueOf(306)); //The itemtype for iron helmet
		luaTable.set("E_ITEM_IRON_HOE", LuaValue.valueOf(292)); //The itemtype for iron hoe
		luaTable.set("E_ITEM_IRON_HORSE_ARMOR", LuaValue.valueOf(417)); //The itemtype for iron horse armor
		luaTable.set("E_ITEM_IRON_LEGGINGS", LuaValue.valueOf(308)); //The itemtype for iron leggings
		luaTable.set("E_ITEM_IRON_NUGGET", LuaValue.valueOf(452)); //The itemtype for iron nugget
		luaTable.set("E_ITEM_IRON_PICKAXE", LuaValue.valueOf(257)); //The itemtype for iron pickaxe
		luaTable.set("E_ITEM_IRON_SHOVEL", LuaValue.valueOf(256)); //The itemtype for iron shovel
		luaTable.set("E_ITEM_IRON_SWORD", LuaValue.valueOf(267)); //The itemtype for iron sword
		luaTable.set("E_ITEM_ITEM_FRAME", LuaValue.valueOf(389)); //The itemtype for item frame
		luaTable.set("E_ITEM_JUNGLE_BOAT", LuaValue.valueOf(446)); //The itemtype for jungle boat
		luaTable.set("E_ITEM_JUNGLE_DOOR", LuaValue.valueOf(429)); //The itemtype for jungle door
		luaTable.set("E_ITEM_LAST", LuaValue.valueOf(2267)); //The itemtype for last
		luaTable.set("E_ITEM_LAST_DISC", LuaValue.valueOf(2267)); //The itemtype for last disc
		luaTable.set("E_ITEM_LAST_DISC_PLUS_ONE", LuaValue.valueOf(2268)); //The itemtype for last disc plus one
		luaTable.set("E_ITEM_LAVA_BUCKET", LuaValue.valueOf(327)); //The itemtype for lava bucket
		luaTable.set("E_ITEM_LEAD", LuaValue.valueOf(420)); //The itemtype for lead
		luaTable.set("E_ITEM_LEASH", LuaValue.valueOf(420)); //The itemtype for lead (E_ITEM_LEAD synonym)
		luaTable.set("E_ITEM_LEATHER", LuaValue.valueOf(334)); //The itemtype for leather
		luaTable.set("E_ITEM_LEATHER_BOOTS", LuaValue.valueOf(301)); //The itemtype for leather boots
		luaTable.set("E_ITEM_LEATHER_CAP", LuaValue.valueOf(298)); //The itemtype for leather cap
		luaTable.set("E_ITEM_LEATHER_PANTS", LuaValue.valueOf(300)); //The itemtype for leather pants
		luaTable.set("E_ITEM_LEATHER_TUNIC", LuaValue.valueOf(299)); //The itemtype for leather tunic
		luaTable.set("E_ITEM_LINGERING_POTION", LuaValue.valueOf(441)); //The itemtype for lingering potion
		luaTable.set("E_ITEM_MAGMA_CREAM", LuaValue.valueOf(378)); //The itemtype for magma cream
		luaTable.set("E_ITEM_MALL_DISC", LuaValue.valueOf(2261)); //The itemtype for mall disc
		luaTable.set("E_ITEM_MAP", LuaValue.valueOf(358)); //The itemtype for map
		luaTable.set("E_ITEM_MAX_CONSECUTIVE_TYPE_ID", LuaValue.valueOf(452)); //The itemtype for max consecutive type id
		luaTable.set("E_ITEM_MELLOHI_DISC", LuaValue.valueOf(2262)); //The itemtype for mellohi disc
		luaTable.set("E_ITEM_MELON_SEEDS", LuaValue.valueOf(362)); //The itemtype for melon seeds
		luaTable.set("E_ITEM_MELON_SLICE", LuaValue.valueOf(360)); //The itemtype for melon slice
		luaTable.set("E_ITEM_MILK", LuaValue.valueOf(335)); //The itemtype for milk
		luaTable.set("E_ITEM_MINECART", LuaValue.valueOf(328)); //The itemtype for minecart
		luaTable.set("E_ITEM_MINECART_WITH_COMMAND_BLOCK", LuaValue.valueOf(422)); //The itemtype for minecart with command block
		luaTable.set("E_ITEM_MINECART_WITH_HOPPER", LuaValue.valueOf(408)); //The itemtype for minecart with hopper
		luaTable.set("E_ITEM_MINECART_WITH_TNT", LuaValue.valueOf(407)); //The itemtype for minecart with tnt
		luaTable.set("E_ITEM_MUSHROOM_SOUP", LuaValue.valueOf(282)); //The itemtype for mushroom soup
		luaTable.set("E_ITEM_NAME_TAG", LuaValue.valueOf(421)); //The itemtype for name tag
		luaTable.set("E_ITEM_NETHER_BRICK", LuaValue.valueOf(405)); //The itemtype for nether brick
		luaTable.set("E_ITEM_NETHER_QUARTZ", LuaValue.valueOf(406)); //The itemtype for nether quartz
		luaTable.set("E_ITEM_NETHER_STAR", LuaValue.valueOf(399)); //The itemtype for nether star
		luaTable.set("E_ITEM_NETHER_WART", LuaValue.valueOf(372)); //The itemtype for nether wart
		luaTable.set("E_ITEM_NUMBER_OF_CONSECUTIVE_TYPES", LuaValue.valueOf(453)); //The itemtype for number of consecutive types
		luaTable.set("E_ITEM_PAINTING", LuaValue.valueOf(321)); //The itemtype for painting
		luaTable.set("E_ITEM_PAPER", LuaValue.valueOf(339)); //The itemtype for paper
		luaTable.set("E_ITEM_POISONOUS_POTATO", LuaValue.valueOf(394)); //The itemtype for poisonous potato
		luaTable.set("E_ITEM_POPPED_CHORUS_FRUIT", LuaValue.valueOf(433)); //The itemtype for popped chorus fruit
		luaTable.set("E_ITEM_POTATO", LuaValue.valueOf(392)); //The itemtype for potato
		luaTable.set("E_ITEM_POTION", LuaValue.valueOf(373)); //The itemtype for potion
		luaTable.set("E_ITEM_POTIONS", LuaValue.valueOf(373)); //The itemtype for potion (obsolete, use E_ITEM_POTION instead)
		luaTable.set("E_ITEM_PRISMARINE_CRYSTALS", LuaValue.valueOf(410)); //The itemtype for prismarine crystals
		luaTable.set("E_ITEM_PRISMARINE_SHARD", LuaValue.valueOf(409)); //The itemtype for prismarine shard
		luaTable.set("E_ITEM_PUMPKIN_PIE", LuaValue.valueOf(400)); //The itemtype for pumpkin pie
		luaTable.set("E_ITEM_PUMPKIN_SEEDS", LuaValue.valueOf(361)); //The itemtype for pumpkin seeds
		luaTable.set("E_ITEM_RABBITS_FOOT", LuaValue.valueOf(414)); //The itemtype for rabbits foot
		luaTable.set("E_ITEM_RABBIT_HIDE", LuaValue.valueOf(415)); //The itemtype for rabbit hide
		luaTable.set("E_ITEM_RABBIT_STEW", LuaValue.valueOf(413)); //The itemtype for rabbit stew
		luaTable.set("E_ITEM_RAW_BEEF", LuaValue.valueOf(363)); //The itemtype for raw beef
		luaTable.set("E_ITEM_RAW_CHICKEN", LuaValue.valueOf(365)); //The itemtype for raw chicken
		luaTable.set("E_ITEM_RAW_FISH", LuaValue.valueOf(349)); //The itemtype for raw fish
		luaTable.set("E_ITEM_RAW_MUTTON", LuaValue.valueOf(423)); //The itemtype for raw mutton
		luaTable.set("E_ITEM_RAW_PORKCHOP", LuaValue.valueOf(319)); //The itemtype for raw porkchop
		luaTable.set("E_ITEM_RAW_RABBIT", LuaValue.valueOf(411)); //The itemtype for raw rabbit
		luaTable.set("E_ITEM_REDSTONE_DUST", LuaValue.valueOf(331)); //The itemtype for redstone dust
		luaTable.set("E_ITEM_REDSTONE_REPEATER", LuaValue.valueOf(356)); //The itemtype for redstone repeater
		luaTable.set("E_ITEM_RED_APPLE", LuaValue.valueOf(260)); //The itemtype for red apple
		luaTable.set("E_ITEM_ROTTEN_FLESH", LuaValue.valueOf(367)); //The itemtype for rotten flesh
		luaTable.set("E_ITEM_SADDLE", LuaValue.valueOf(329)); //The itemtype for saddle
		luaTable.set("E_ITEM_SEEDS", LuaValue.valueOf(295)); //The itemtype for seeds
		luaTable.set("E_ITEM_SHEARS", LuaValue.valueOf(359)); //The itemtype for shears
		luaTable.set("E_ITEM_SHIELD", LuaValue.valueOf(442)); //The itemtype for shield
		luaTable.set("E_ITEM_SHULKER_SHELL", LuaValue.valueOf(450)); //The itemtype for shulker shell
		luaTable.set("E_ITEM_SIGN", LuaValue.valueOf(323)); //The itemtype for sign
		luaTable.set("E_ITEM_SLIMEBALL", LuaValue.valueOf(341)); //The itemtype for slimeball
		luaTable.set("E_ITEM_SNOWBALL", LuaValue.valueOf(332)); //The itemtype for snowball
		luaTable.set("E_ITEM_SPAWN_EGG", LuaValue.valueOf(383)); //The itemtype for spawn egg
		luaTable.set("E_ITEM_SPECTRAL_ARROW", LuaValue.valueOf(439)); //The itemtype for spectral arrow
		luaTable.set("E_ITEM_SPIDER_EYE", LuaValue.valueOf(375)); //The itemtype for spider eye
		luaTable.set("E_ITEM_SPLASH_POTION", LuaValue.valueOf(438)); //The itemtype for splash potion
		luaTable.set("E_ITEM_SPRUCE_BOAT", LuaValue.valueOf(444)); //The itemtype for spruce boat
		luaTable.set("E_ITEM_SPRUCE_DOOR", LuaValue.valueOf(427)); //The itemtype for spruce door
		luaTable.set("E_ITEM_STAL_DISC", LuaValue.valueOf(2263)); //The itemtype for stal disc
		luaTable.set("E_ITEM_STEAK", LuaValue.valueOf(364)); //The itemtype for steak
		luaTable.set("E_ITEM_STICK", LuaValue.valueOf(280)); //The itemtype for stick
		luaTable.set("E_ITEM_STONE_AXE", LuaValue.valueOf(275)); //The itemtype for stone axe
		luaTable.set("E_ITEM_STONE_HOE", LuaValue.valueOf(291)); //The itemtype for stone hoe
		luaTable.set("E_ITEM_STONE_PICKAXE", LuaValue.valueOf(274)); //The itemtype for stone pickaxe
		luaTable.set("E_ITEM_STONE_SHOVEL", LuaValue.valueOf(273)); //The itemtype for stone shovel
		luaTable.set("E_ITEM_STONE_SWORD", LuaValue.valueOf(272)); //The itemtype for stone sword
		luaTable.set("E_ITEM_STRAD_DISC", LuaValue.valueOf(2264)); //The itemtype for strad disc
		luaTable.set("E_ITEM_STRING", LuaValue.valueOf(287)); //The itemtype for string
		luaTable.set("E_ITEM_SUGAR", LuaValue.valueOf(353)); //The itemtype for sugar
		luaTable.set("E_ITEM_SUGARCANE", LuaValue.valueOf(338)); //The itemtype for sugarcane
		luaTable.set("E_ITEM_SUGAR_CANE", LuaValue.valueOf(338)); //The itemtype for sugar cane
		luaTable.set("E_ITEM_TIPPED_ARROW", LuaValue.valueOf(440)); //The itemtype for tipped arrow
		luaTable.set("E_ITEM_TOTEM_OF_UNDYING", LuaValue.valueOf(449)); //The itemtype for totem of undying
		luaTable.set("E_ITEM_WAIT_DISC", LuaValue.valueOf(2267)); //The itemtype for wait disc
		luaTable.set("E_ITEM_WARD_DISC", LuaValue.valueOf(2265)); //The itemtype for ward disc
		luaTable.set("E_ITEM_WATER_BUCKET", LuaValue.valueOf(326)); //The itemtype for water bucket
		luaTable.set("E_ITEM_WHEAT", LuaValue.valueOf(296)); //The itemtype for wheat
		luaTable.set("E_ITEM_WOODEN_AXE", LuaValue.valueOf(271)); //The itemtype for wooden axe
		luaTable.set("E_ITEM_WOODEN_DOOR", LuaValue.valueOf(324)); //The itemtype for wooden door
		luaTable.set("E_ITEM_WOODEN_HOE", LuaValue.valueOf(290)); //The itemtype for wooden hoe
		luaTable.set("E_ITEM_WOODEN_PICKAXE", LuaValue.valueOf(270)); //The itemtype for wooden pickaxe
		luaTable.set("E_ITEM_WOODEN_SHOVEL", LuaValue.valueOf(269)); //The itemtype for wooden shovel
		luaTable.set("E_ITEM_WOODEN_SWORD", LuaValue.valueOf(268)); //The itemtype for wooden sword
		luaTable.set("E_ITEM_WRITTEN_BOOK", LuaValue.valueOf(387)); //The itemtype for written book
		luaTable.set("ssFireSpread", LuaValue.valueOf(0)); //
		luaTable.set("ssGrassSpread", LuaValue.valueOf(1)); //
		luaTable.set("ssMushroomSpread", LuaValue.valueOf(2)); //
		luaTable.set("ssMycelSpread", LuaValue.valueOf(3)); //
		luaTable.set("ssVineSpread", LuaValue.valueOf(4)); //
		luaTable.set("slAll", LuaValue.valueOf(2)); //
		luaTable.set("slGravityAffectedOnly", LuaValue.valueOf(1)); //
		luaTable.set("slNone", LuaValue.valueOf(0)); //
		luaTable.set("mhLeft", LuaValue.valueOf(0)); //The left hand is the main hand
		luaTable.set("mhRight", LuaValue.valueOf(1)); //The right hand is the main hand
		luaTable.set("hMain", LuaValue.valueOf(0)); //The main hand
		luaTable.set("hOff", LuaValue.valueOf(1)); //The off hand
		luaTable.set("mtCustom", LuaValue.valueOf(0)); //Send raw data without any processing
		luaTable.set("mtDeath", LuaValue.valueOf(6)); //Denotes death of player
		luaTable.set("mtError", LuaValue.valueOf(1)); //Something could not be done (i.e. command not executed due to insufficient privilege)
		luaTable.set("mtFail", LuaValue.valueOf(1)); //Something could not be done (i.e. command not executed due to insufficient privilege)
		luaTable.set("mtFailure", LuaValue.valueOf(1)); //Something could not be done (i.e. command not executed due to insufficient privilege)
		luaTable.set("mtFatal", LuaValue.valueOf(5)); //Something catastrophic occured (i.e. plugin crash)
		luaTable.set("mtInfo", LuaValue.valueOf(2)); //Informational message (i.e. command usage)
		luaTable.set("mtInformation", LuaValue.valueOf(2)); //Informational message (i.e. command usage)
		luaTable.set("mtJoin", LuaValue.valueOf(8)); //A player has joined the server
		luaTable.set("mtLeave", LuaValue.valueOf(9)); //A player has left the server
		luaTable.set("mtMaxPlusOne", LuaValue.valueOf(10)); //The first invalid type, used for checking on LuaAPI boundaries
		luaTable.set("mtPM", LuaValue.valueOf(7)); //Player to player messaging identifier
		luaTable.set("mtPrivateMessage", LuaValue.valueOf(7)); //Player to player messaging identifier
		luaTable.set("mtSuccess", LuaValue.valueOf(3)); //Something executed successfully
		luaTable.set("mtWarning", LuaValue.valueOf(4)); //Something concerning (i.e. reload) is about to happen
		luaTable.set("BLOCK_FACE_BOTTOM", LuaValue.valueOf(0)); //Please use BLOCK_FACE_YM instead. Interacting with the bottom face of the block.
		luaTable.set("BLOCK_FACE_EAST", LuaValue.valueOf(5)); //Please use BLOCK_FACE_XM instead. Interacting with the eastern face of the block.
		luaTable.set("BLOCK_FACE_MAX", LuaValue.valueOf(5)); //Used for range checking - highest legal value for an eBlockFace
		luaTable.set("BLOCK_FACE_MIN", LuaValue.valueOf(-1)); //Used for range checking - lowest legal value for an eBlockFace
		luaTable.set("BLOCK_FACE_NONE", LuaValue.valueOf(-1)); //Interacting with no block face - swinging the item in the air
		luaTable.set("BLOCK_FACE_NORTH", LuaValue.valueOf(2)); //Please use BLOCK_FACE_ZM instead. Interacting with the northern face of the block.
		luaTable.set("BLOCK_FACE_SOUTH", LuaValue.valueOf(3)); //Please use BLOCK_FACE_ZP instead. Interacting with the southern face of the block.
		luaTable.set("BLOCK_FACE_TOP", LuaValue.valueOf(1)); //Please use BLOCK_FACE_YP instead. Interacting with the top face of the block.
		luaTable.set("BLOCK_FACE_WEST", LuaValue.valueOf(4)); //Please use BLOCK_FACE_XP instead. Interacting with the western face of the block.
		luaTable.set("BLOCK_FACE_XM", LuaValue.valueOf(4)); //Interacting with the X- face of the block
		luaTable.set("BLOCK_FACE_XP", LuaValue.valueOf(5)); //Interacting with the X+ face of the block
		luaTable.set("BLOCK_FACE_YM", LuaValue.valueOf(0)); //Interacting with the Y- face of the block
		luaTable.set("BLOCK_FACE_YP", LuaValue.valueOf(1)); //Interacting with the Y+ face of the block
		luaTable.set("BLOCK_FACE_ZM", LuaValue.valueOf(2)); //Interacting with the Z- face of the block
		luaTable.set("BLOCK_FACE_ZP", LuaValue.valueOf(3)); //Interacting with the Z+ face of the block
		luaTable.set("DIG_STATUS_CANCELLED", LuaValue.valueOf(1)); //The player has let go of the mine block key before finishing mining the block
		luaTable.set("DIG_STATUS_DROP_HELD", LuaValue.valueOf(4)); //The player has dropped a single item using the Drop Item key (default: Q)
		luaTable.set("DIG_STATUS_DROP_STACK", LuaValue.valueOf(3)); //The player has dropped a full stack of items using the Drop Item key (default: Q) while holding down a specific modifier key (in windows, control)
		luaTable.set("DIG_STATUS_FINISHED", LuaValue.valueOf(2)); //The player thinks that it has finished mining a block
		luaTable.set("DIG_STATUS_SHOOT_EAT", LuaValue.valueOf(5)); //The player has finished shooting a bow or finished eating
		luaTable.set("DIG_STATUS_STARTED", LuaValue.valueOf(0)); //The player has started digging
		luaTable.set("DIG_STATUS_SWAP_ITEM_IN_HAND", LuaValue.valueOf(6)); //The player has swapped their held item with the item in their offhand slot (1.9)
		luaTable.set("mtBat", LuaValue.valueOf(0)); //
		luaTable.set("mtBlaze", LuaValue.valueOf(1)); //
		luaTable.set("mtCaveSpider", LuaValue.valueOf(2)); //
		luaTable.set("mtChicken", LuaValue.valueOf(3)); //
		luaTable.set("mtCow", LuaValue.valueOf(4)); //
		luaTable.set("mtCreeper", LuaValue.valueOf(5)); //
		luaTable.set("mtEnderDragon", LuaValue.valueOf(6)); //
		luaTable.set("mtEnderman", LuaValue.valueOf(7)); //
		luaTable.set("mtGhast", LuaValue.valueOf(8)); //
		luaTable.set("mtGiant", LuaValue.valueOf(9)); //
		luaTable.set("mtGuardian", LuaValue.valueOf(10)); //
		luaTable.set("mtHorse", LuaValue.valueOf(11)); //
		luaTable.set("mtInvalidType", LuaValue.valueOf(-1)); //Invalid monster type. Returned when monster type not recognized
		luaTable.set("mtIronGolem", LuaValue.valueOf(12)); //
		luaTable.set("mtMagmaCube", LuaValue.valueOf(13)); //
		luaTable.set("mtMooshroom", LuaValue.valueOf(14)); //
		luaTable.set("mtOcelot", LuaValue.valueOf(15)); //
		luaTable.set("mtPig", LuaValue.valueOf(16)); //
		luaTable.set("mtRabbit", LuaValue.valueOf(17)); //
		luaTable.set("mtSheep", LuaValue.valueOf(18)); //
		luaTable.set("mtSilverfish", LuaValue.valueOf(19)); //
		luaTable.set("mtSkeleton", LuaValue.valueOf(20)); //
		luaTable.set("mtSlime", LuaValue.valueOf(21)); //
		luaTable.set("mtSnowGolem", LuaValue.valueOf(22)); //
		luaTable.set("mtSpider", LuaValue.valueOf(23)); //
		luaTable.set("mtSquid", LuaValue.valueOf(24)); //
		luaTable.set("mtVillager", LuaValue.valueOf(25)); //
		luaTable.set("mtWitch", LuaValue.valueOf(26)); //
		luaTable.set("mtWither", LuaValue.valueOf(27)); //
		luaTable.set("mtWitherSkeleton", LuaValue.valueOf(28)); //
		luaTable.set("mtWolf", LuaValue.valueOf(29)); //
		luaTable.set("mtZombie", LuaValue.valueOf(30)); //
		luaTable.set("mtZombiePigman", LuaValue.valueOf(31)); //
		luaTable.set("mtZombieVillager", LuaValue.valueOf(32)); //
		luaTable.set("SKULL_ROTATION_EAST", LuaValue.valueOf(4)); //
		luaTable.set("SKULL_ROTATION_EAST_NORTH_EAST", LuaValue.valueOf(3)); //
		luaTable.set("SKULL_ROTATION_EAST_SOUTH_EAST", LuaValue.valueOf(5)); //
		luaTable.set("SKULL_ROTATION_NORTH", LuaValue.valueOf(0)); //
		luaTable.set("SKULL_ROTATION_NORTH_EAST", LuaValue.valueOf(2)); //
		luaTable.set("SKULL_ROTATION_NORTH_NORTH_EAST", LuaValue.valueOf(1)); //
		luaTable.set("SKULL_ROTATION_NORTH_NORTH_WEST", LuaValue.valueOf(15)); //
		luaTable.set("SKULL_ROTATION_NORTH_WEST", LuaValue.valueOf(14)); //
		luaTable.set("SKULL_ROTATION_SOUTH", LuaValue.valueOf(8)); //
		luaTable.set("SKULL_ROTATION_SOUTH_EAST", LuaValue.valueOf(6)); //
		luaTable.set("SKULL_ROTATION_SOUTH_SOUTH_EAST", LuaValue.valueOf(7)); //
		luaTable.set("SKULL_ROTATION_SOUTH_SOUTH_WEST", LuaValue.valueOf(9)); //
		luaTable.set("SKULL_ROTATION_SOUTH_WEST", LuaValue.valueOf(10)); //
		luaTable.set("SKULL_ROTATION_WEST", LuaValue.valueOf(12)); //
		luaTable.set("SKULL_ROTATION_WEST_NORTH_WEST", LuaValue.valueOf(13)); //
		luaTable.set("SKULL_ROTATION_WEST_SOUTH_WEST", LuaValue.valueOf(11)); //
		
	}
}
