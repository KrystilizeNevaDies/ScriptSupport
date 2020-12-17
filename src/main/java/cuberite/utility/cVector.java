package cuberite.utility;

import org.luaj.vm2.LuaValue;

import net.minestom.server.utils.BlockPosition;
import net.minestom.server.utils.Position;
import net.minestom.server.utils.Vector;

public interface cVector {

	public default Position toPosition() {
		return new Position(getLuaValue().get("x").tofloat(), getLuaValue().get("y").tofloat(),
				getLuaValue().get("z").tofloat());
	}

	public default Vector toVector() {
		return new Vector(getLuaValue().get("x").tofloat(), getLuaValue().get("y").tofloat(),
				getLuaValue().get("z").tofloat());
	}

	default public BlockPosition toBlockPosition() {
		return new BlockPosition(getLuaValue().get("x").toint(), getLuaValue().get("y").toint(),
				getLuaValue().get("z").toint());
	}

	public void registerFunctions(LuaValue vector);

	public LuaValue getLuaValue();
}
