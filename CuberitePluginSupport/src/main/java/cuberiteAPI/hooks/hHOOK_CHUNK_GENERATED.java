package cuberiteAPI.hooks;

import java.util.ArrayList;

import org.luaj.vm2.LuaValue;

public enum hHOOK_CHUNK_GENERATED {
	INSTANCE;
	
	
	private ArrayList<LuaValue> hookList = new ArrayList<LuaValue>();
	
	public void add(LuaValue function) {
		hookList.add(function);
	}
	
	public void start() {
		// Setup hook logic
		
	}
	
	///////////////////////////////////////
	//             hHOOK_CHUNK_GENERATED             //
	///////////////////////////////////////
}
