package minestom.api;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.TwoArgFunction;

public class ClassBinding {
	
	static LuaValue get(Class<?> aClass, Globals globals) {
		
		LuaValue binding = globals.get("luajava").get("bindClass").call(LuaValue.valueOf(aClass.getName()));
		
		LuaTable metaTable = LuaTable.tableOf();
		
		metaTable.set("__index", new IndexFunction());
		
		return binding;
	}
	
	static class IndexFunction extends TwoArgFunction {
		@Override
		public LuaValue call(LuaValue table, LuaValue key) {
			return table.get(key);
		}
	}
}
