package cuberite.api.hooks;

import java.util.Date;

import org.luaj.vm2.LuaValue;

import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.client.ClientPlayPacket;
import net.minestom.server.timer.SchedulerManager;
import net.minestom.server.utils.time.TimeUnit;

public enum hHOOK_TICK implements Hook {
	INSTANCE;

	@Override
	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	private LuaValue[] hookList = {};

	@Override public LuaValue[] getFunctions() {return this.hookList;}

	@Override public void setFunctions(LuaValue[] newFunctions) {this.hookList = newFunctions;}

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
		LuaValue[] args = {LuaValue.valueOf(delta)};
		call(args, getFunctions());

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