package cuberiteAPI;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.VarArgFunction;

import cuberitePluginSupport.Plugin;

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
	
	
	static class LOG extends VarArgFunction { // TODO: Complete this class
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
	}
}
