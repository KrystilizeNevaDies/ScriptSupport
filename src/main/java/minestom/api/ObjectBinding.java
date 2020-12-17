package minestom.api;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

public class ObjectBinding {
	
	private static Map<LuaTable, Object> mappings = new HashMap<LuaTable, Object>();
	
	public static LuaValue getBinding(Object value) {
		try {
			return generateBindingSub(((Field) value).get(null));
		} catch (Throwable e) {
			return generateBindingSub(value);
		}
	}
	
	private static LuaValue generateBindingSub(Object value) {
		// Check of object is in mappings
		for (Entry<LuaTable, Object> entry : mappings.entrySet()) {
	        if (entry.getValue().equals(value)) {
	            return entry.getKey();
	        }
	    }
		
		// If not, register object
		LuaTable luaTable = LuaTable.tableOf();
		
		luaTable.set("ClassName", value.getClass().getName());
		
		luaTable.set("Hash", value.hashCode());
		
		LuaValue metaTable = LuaValue.tableOf();
		
		metaTable.set("__tostring", new ToStringFunction());
		
		luaTable.setmetatable(metaTable);
		
		mappings.put(luaTable, value);
		
		return luaTable;
	}
	
	public static Object getJavaObject(LuaTable object) {
		return mappings.get(object);
	}
	public static LuaTable getLuaObject(Object object) {
		for (Entry<LuaTable, Object> entry : mappings.entrySet()) {
	        if (entry.getValue().equals(object)) {
	            return entry.getKey();
	        }
	    }
		return null;
	}
	
	
	
	public static Object toJavaObject(LuaValue value) {
		switch (value.type()) {
			case LuaValue.TBOOLEAN: return value.toboolean();
			case LuaValue.TINT: return value.toint();
			case LuaValue.TNIL: return null;
			case LuaValue.TNONE: return null;
			case LuaValue.TNUMBER: return value.todouble();
			case LuaValue.TSTRING: return value.tojstring();
			case LuaValue.TTABLE: return toJavaArray((LuaTable) value);
			default: return null;
		}
	}

	private static Array toJavaArray(LuaTable value) {
		// TODO: Arrays
		return null;
	}
	
	private static class ToStringFunction extends OneArgFunction {
		@Override
		public LuaValue call(LuaValue table) {
			Object object = getJavaObject((LuaTable) table);
			return LuaValue.valueOf(object.toString());
		}
		
	}
}
