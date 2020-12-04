package cuberite.plugin;

import org.luaj.vm2.LuaValue;

import net.minestom.server.utils.BlockPosition;
import net.minestom.server.utils.Position;
import net.minestom.server.utils.Vector;

public class cVector {
	
	public static LuaValue from() {
		LuaValue vector = LuaValue.tableOf();
		vector.set("x", LuaValue.valueOf(0));
		vector.set("y", LuaValue.valueOf(0));
		vector.set("z", LuaValue.valueOf(0));
		registerFunctions(vector);
		return vector;
	}
	
	public static LuaValue from(double X, double Y, double Z) {
		LuaValue vector = LuaValue.tableOf();
		vector.set("x", X);
		vector.set("y", Y);
		vector.set("z", Z);
		registerFunctions(vector);
		return vector;
	}
	
	public static LuaValue from(LuaValue X, LuaValue Y, LuaValue Z) {
		LuaValue vector = LuaValue.tableOf();
		vector.set("x", X);
		vector.set("y", Y);
		vector.set("z", Z);
		registerFunctions(vector);
		return vector;
	}
	
	public static Position toPosition(LuaValue vector) {
		return new Position(
		vector.get("x").tofloat(),
		vector.get("y").tofloat(),
		vector.get("z").tofloat()
		);
	}
	
	public static LuaValue from(Position position) {
		LuaValue vector = LuaValue.tableOf();
		vector.set("x", position.getX());
		vector.set("y", position.getY());
		vector.set("z", position.getZ());
		registerFunctions(vector);
		return vector;
	}
	
	public static Vector toVector(LuaValue vector) {
		return new Vector(
		vector.get("x").tofloat(),
		vector.get("y").tofloat(),
		vector.get("z").tofloat()
		);
	}
	
	public static LuaValue from(Vector someVector) {
		LuaValue vector = LuaValue.tableOf();
		vector.set("x", someVector.getX());
		vector.set("y", someVector.getY());
		vector.set("z", someVector.getZ());
		registerFunctions(vector);
		return vector;
	}
	
	public static BlockPosition toBlockPosition(LuaValue vector) {
		return new BlockPosition(
		vector.get("x").toint(),
		vector.get("y").toint(),
		vector.get("z").toint()
		);
	}
	
	public static LuaValue from(BlockPosition position) {
		LuaValue vector = LuaValue.tableOf();
		vector.set("x", position.getX());
		vector.set("y", position.getY());
		vector.set("z", position.getZ());
		registerFunctions(vector);
		return vector;
	}
	
	protected static void registerFunctions(LuaValue vector) {
		
	}
}
