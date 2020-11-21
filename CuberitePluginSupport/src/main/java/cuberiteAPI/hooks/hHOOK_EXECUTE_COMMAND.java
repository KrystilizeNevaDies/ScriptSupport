package cuberiteAPI.hooks;

import java.util.ArrayList;

import org.luaj.vm2.LuaValue;

public enum hHOOK_EXECUTE_COMMAND {
	INSTANCE;
	
	
	private ArrayList<LuaValue> hookList = new ArrayList<LuaValue>();
	
	public void add(LuaValue function) {
		hookList.add(function);
	}
	
	public void start() {
		// Setup hook logic
		
	}
	
	///////////////////////////////////////
	//             hHOOK_EXECUTE_COMMAND             //
	///////////////////////////////////////
}
