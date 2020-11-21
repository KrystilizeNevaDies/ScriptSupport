package cuberiteAPI.hooks;

import java.util.ArrayList;
import java.util.Date;

import org.luaj.vm2.LuaValue;

import net.minestom.server.MinecraftServer;
import net.minestom.server.timer.SchedulerManager;
import net.minestom.server.utils.time.TimeUnit;

public enum hHOOK_TICK {
	INSTANCE;
	
	
	private ArrayList<LuaValue> hookList = new ArrayList<LuaValue>();
	
	public void add(LuaValue function) {
		hookList.add(function);
	}
	
	public void start() {
		loop();
	}
	
	///////////////////////////////////////
	//             HOOK_TICK             //
	///////////////////////////////////////
	
	
	Long time = new Date().getTime();
	
	private void doLoop() {
		Long newTime = new Date().getTime();
		Long delta = newTime - time;
		time = newTime;
		
		ArrayList<Object> removeList = new ArrayList<Object>();
		
		for (int i = 0; i < hookList.size(); i++) {
			LuaValue value = hookList.get(i);
			
			if (value.isfunction()) {
				value.call(LuaValue.valueOf(delta));
			} else {
				// save non-functional callbacks
				removeList.add(value);
			}
		}
		
		// Remove non-functioning callbacks
		removeList.forEach((object) -> {
			hookList.remove(object);
		});
		
	}
	
	private void loop() {
		SchedulerManager manager = MinecraftServer.getSchedulerManager();
		
		manager.buildTask(new Runnable() {
            @Override
            public void run() {
            	doLoop();
            	loop();
            }
		}).delay(1, TimeUnit.TICK).schedule();
	}
}