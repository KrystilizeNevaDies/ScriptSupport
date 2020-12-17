package cuberite.api.hooks;

import java.util.ArrayList;
import java.util.Arrays;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public interface Hook {

	abstract LuaValue[] getFunctions();

	abstract void setFunctions(LuaValue[] newFunctions);

	public default void remove(LuaValue function) {
		LuaValue[] array = getFunctions();
		ArrayList<LuaValue> list = new ArrayList<LuaValue>(Arrays.asList(array));
		list.remove(function);
		array = Arrays.copyOf(list.toArray(), list.toArray().length, LuaValue[].class);
		;
	}

	abstract Boolean packetEvent(ClientPlayPacket packet, Player player);

	abstract public void start();

	public default Varargs call(LuaValue[] args) {

		Varargs luaargs = LuaValue.varargsOf(args);

		Varargs returnValue = LuaValue.NIL;

		LuaValue[] functions = getFunctions();

		// for each hook
		for (int i = 0; i < functions.length; i++) {
			LuaValue value = functions[i];

			if (value.isfunction()) {
				returnValue = value.invoke(luaargs);
			} else {
				remove(value);
			}
		}

		return returnValue;
	}
}
