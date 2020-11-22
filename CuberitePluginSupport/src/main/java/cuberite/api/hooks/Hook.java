package cuberite.api.hooks;

import java.util.ArrayList;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public interface Hook {

	ArrayList<LuaValue> hookList = new ArrayList<LuaValue>();

	default void add(LuaValue function) {
		hookList.add(function);
	}

	abstract Boolean packetEvent(ClientPlayPacket packet, Player player);

	public void start();

	public default Varargs call(LuaValue[] args) {
		Varargs luaargs = LuaValue.varargsOf(args);
		
		Varargs returnValue = null;
		
		ArrayList<Object> removeList = new ArrayList<Object>();

		// for each hook
		for (int i = 0; i < hookList.size(); i++) {
			LuaValue value = hookList.get(i);

			if (value.isfunction()) {
				returnValue = value.invoke(luaargs);
			} else {
				// save non-functional callbacks
				removeList.add(value);
			}
		}

		// Remove non-functioning callbacks
		removeList.forEach((object) -> {
			hookList.remove(object);
		});
		return returnValue;
	}
}
