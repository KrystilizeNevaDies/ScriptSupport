package cuberite.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

public class cUUID {

	///////////////////////////////////////////////////////
	// Java API //
	///////////////////////////////////////////////////////

	private static Map<UUID, LuaTable> uuids = new HashMap<UUID, LuaTable>();

	public LuaTable luaValue;

	public UUID uuid;

	///////////////////////////////////////////////////////
	// Lua API //
	///////////////////////////////////////////////////////

	static class UUIDConstructor extends OneArgFunction {
		/**
		 * boolean Returns whether command blocks are enabled on the (entire) server
		 */
		@Override
		public LuaValue call(LuaValue nil) {
			return new cUUID(UUID.randomUUID()).luaValue;
		}
	}

	class Compare extends TwoArgFunction {
		/**
		 * Other cUUID number Compares this UUID with the specified Other UUID, Returns:
		 * 0 when equal to Other, < 0 when less than Other, > 0 when greater than Other
		 */
		@Override
		public LuaValue call(LuaValue luaUuid, LuaValue value) {
			return valueOf(luaUuid.get("ToShortString").call().tojstring()
					.equals(value.get("ToShortString").call().tojstring()));
		}
	}

	class FromString extends TwoArgFunction {
		/**
		 * StringUUID string boolean Tries to interpret the string as a short or long
		 * form UUID and assign from it. On error, returns false and does not set the
		 * value.
		 */
		@Override
		public LuaValue call(LuaValue luaUuid, LuaValue value) {
			try {
				uuid = UUID.fromString(value.tojstring());
				return TRUE;
			} catch (Exception e) {
				return FALSE;
			}
		}
	}

	class GenerateVersion3 extends TwoArgFunction {
		/**
		 * Name string cUUID (STATIC) Generates a version 3, variant 1 UUID based on the
		 * md5 hash of Name.
		 */
		@Override
		public LuaValue call(LuaValue luaUuid, LuaValue value) {
			System.out.println("cUUID():GenerateVersion3() is not yet implemented.");
			return NIL;
		}
	}

	class IsNil extends TwoArgFunction {
		/**
		 * boolean Returns true if this contains the "nil" UUID with all bits set to 0
		 */
		@Override
		public LuaValue call(LuaValue luaUuid, LuaValue value) {
			return FALSE;
		}
	}

	class ToLongString extends TwoArgFunction {
		/**
		 * string Converts the UUID to a long form string (i.e with dashes).
		 */
		@Override
		public LuaValue call(LuaValue luaUuid, LuaValue value) {
			System.out.println("cUUID():ToLongString() is not yet implemented.");
			return NIL;
		}
	}

	class ToShortString extends OneArgFunction {
		/**
		 * string Converts the UUID to a short form string (i.e without dashes).
		 */
		@Override
		public LuaValue call(LuaValue luaUuid) {
			return valueOf(uuid.toString());
		}
	}

	class Variant extends OneArgFunction {
		/**
		 * number Returns the variant number of the UUID
		 */
		@Override
		public LuaValue call(LuaValue luaUuid) {
			System.out.println("cUUID():Variant() is not yet implemented.");
			return valueOf(uuid.variant());
		}
	}

	class Version extends OneArgFunction {
		/**
		 * number Returns the version number of the UUID.
		 */
		@Override
		public LuaValue call(LuaValue luaUuid) {
			return valueOf(uuid.version());
		}
	}

	class ToString extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue plugin) {
			String output = "cUUID(" + uuid.toString() + ")";
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
	public cUUID(Globals globals) {
		globals.set("cUUID", new UUIDConstructor());
	}

	/**
	 * Dynamic Initialization
	 * 
	 * @param somePlayer
	 */
	public cUUID(UUID someUuid) {
		uuid = someUuid;

		// Check if player already exists
		if (uuids.containsKey(someUuid)) {
			this.luaValue = uuids.get(someUuid);
			return;
		}

		LuaTable value = LuaValue.tableOf();

		value.set("Compare", new Compare());
		value.set("FromString", new FromString());
		value.set("GenerateVersion3", new GenerateVersion3());
		value.set("IsNil", new IsNil());
		value.set("ToLongString", new ToLongString());
		value.set("ToShortString", new ToShortString());
		value.set("Variant", new Variant());
		value.set("Version", new Version());

		// metatable
		LuaValue metatable = LuaValue.tableOf();

		metatable.set("__tostring", new ToString());
		metatable.set("__concat", new Concat());

		value.setmetatable(metatable);

		uuids.put(someUuid, value);
	}
}
