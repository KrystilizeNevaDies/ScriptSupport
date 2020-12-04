package cuberite.api;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

import cuberite.plugin.cVector;

public class Vector3f extends cVector {
	
	public static class Vector3fConstructor extends ThreeArgFunction {
		public LuaValue call(LuaValue X, LuaValue Y, LuaValue Z) {
			if (X.isnumber()) {
				X.checknumber();
				Y.checknumber();
				Z.checknumber();
				return from(X, Y, Z);
			} else {
				return from();
			}
		}
	}
	
	static class multiply extends TwoArgFunction {
		public LuaValue call(LuaValue vector, LuaValue value) {
			if (value.isnumber()) {
				return from(
				vector.get("x").mul(value.tofloat()),
				vector.get("y").mul(value.tofloat()),
				vector.get("z").mul(value.tofloat())
				);
			} else {
				double X = vector.get("x").todouble();
				double Y = vector.get("y").todouble();
				double Z = vector.get("z").todouble();
				
				vector.set("x", X * value.get("x").tofloat());
				vector.set("y", Y * value.get("y").tofloat());
				vector.set("z", Z * value.get("z").tofloat());
				return LuaValue.NIL;
			}
		}
	}
	
	static class add extends TwoArgFunction {
		public LuaValue call(LuaValue vector, LuaValue value) {
			if (value.isnumber()) {
				return from(
				vector.get("x").add(value.tofloat()),
				vector.get("y").add(value.tofloat()),
				vector.get("z").add(value.tofloat())
				);
			} else {
				return from(
				vector.get("x").add(value.get("x").tofloat()),
				vector.get("y").add(value.get("y").tofloat()),
				vector.get("z").add(value.get("z").tofloat())
				);
			}
		}
	}
	
	static class subtract extends TwoArgFunction {
		public LuaValue call(LuaValue vector, LuaValue value) {
			if (value.isnumber()) {
				return from(
				vector.get("x").sub(value.tofloat()),
				vector.get("y").sub(value.tofloat()),
				vector.get("z").sub(value.tofloat())
				);
			} else {
				return from(
				vector.get("x").sub(value.get("x").tofloat()),
				vector.get("y").sub(value.get("y").tofloat()),
				vector.get("z").sub(value.get("z").tofloat())
				);
			}
		}
	}
	
	static class divide extends TwoArgFunction {
		public LuaValue call(LuaValue vector, LuaValue value) {
			if (value.isnumber()) {
				return from(
				vector.get("x").div(value.tofloat()),
				vector.get("y").div(value.tofloat()),
				vector.get("z").div(value.tofloat())
				);
			} else {
				return from(
				vector.get("x").div(value.get("x").tofloat()),
				vector.get("y").div(value.get("y").tofloat()),
				vector.get("z").div(value.get("z").tofloat())
				);
			}
		}
	}
	
	static class Abs extends OneArgFunction {
		/**
		Updates each coord to its absolute value.
		*/
		public LuaValue call(LuaValue vector) {
			vector.set("x", Math.abs(vector.get("x").tofloat()));
			vector.set("y", Math.abs(vector.get("y").tofloat()));
			vector.set("z", Math.abs(vector.get("z").tofloat()));
			return vector;
		}
	}

	static class Ceil extends TwoArgFunction {
		/**
		Vector3i
		Returns a new Vector3i object with coords set to math.ceil of this vector's coords.
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			vector.set("x", Math.ceil(vector.get("x").tofloat()));
			vector.set("y", Math.ceil(vector.get("y").tofloat()));
			vector.set("z", Math.ceil(vector.get("z").tofloat()));
			return vector;
		}
	}

	static class Clamp extends ThreeArgFunction {
		/**
		minnumber
		maxnumber
		Clamps each coord into the specified range.
		*/
		public LuaValue call(LuaValue vector, LuaValue min, LuaValue max) {
			float mn = min.tofloat();
			float mx = min.tofloat();
			float x = vector.get("x").tofloat();
			float y = vector.get("y").tofloat();
			float z = vector.get("z").tofloat();
			if (x < mn) {vector.set("x", min);} else if (x > mx) {vector.set("x", max);};
			if (y < mn) {vector.set("y", min);} else if (y > mx) {vector.set("y", max);};
			if (z < mn) {vector.set("z", min);} else if (z > mx) {vector.set("z", max);};
			return vector;
		}
	}

	static class Cross extends TwoArgFunction {
		/**
		OtherVector3d
		Vector3d
		Returns a new Vector3d that is a cross product of this vector and the specified vector.
		(a, b, c) x (d, e, f) = (bf - ce, cd - af, ae - bd)
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			float a = vector.get("x").tofloat();
			float b = vector.get("y").tofloat();
			float c = vector.get("z").tofloat();
			float d = value.get("x").tofloat();
			float e = value.get("y").tofloat();
			float f = value.get("z").tofloat();
			return Vector3f.from(b * f - c * e, c * d - a * f, a * e - b * d);
		}
	}

	static class Dot extends TwoArgFunction {
		/**
		OtherVector3d
		number
		Returns the dot product of this vector and the specified vector.
		(a, b, c) x (d, e, f) = (ad + be + cf)
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			float a = vector.get("x").tofloat();
			float b = vector.get("y").tofloat();
			float c = vector.get("z").tofloat();
			float d = value.get("x").tofloat();
			float e = value.get("y").tofloat();
			float f = value.get("z").tofloat();
			return LuaValue.valueOf(a * d + b * e + c * f);
		}
	}

	static class Equals extends TwoArgFunction {
		/**
		AnotherVector Vector3d
		boolean
		Returns true if this vector is exactly equal to the specified vector. Note that this is subject to (possibly imprecise) floating point math.
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			float a = vector.get("x").tofloat();
			float b = vector.get("y").tofloat();
			float c = vector.get("z").tofloat();
			float d = value.get("x").tofloat();
			float e = value.get("y").tofloat();
			float f = value.get("z").tofloat();
			return LuaValue.valueOf(a == d && b == e && c == f);
		}
	}

	static class EqualsEps extends ThreeArgFunction {
		/**
		AnotherVector Vector3d
		Epsnumber
		boolean
		Returns true if the differences between each corresponding coords of this vector and the one specified are less than the specified Eps.
		*/
		public LuaValue call(LuaValue vector, LuaValue value, LuaValue eps) {
			float a = vector.get("x").tofloat();
			float b = vector.get("y").tofloat();
			float c = vector.get("z").tofloat();
			float d = value.get("x").tofloat();
			float e = value.get("y").tofloat();
			float f = value.get("z").tofloat();
			float dif = eps.tofloat();
			return LuaValue.valueOf(Math.abs(a - d) < dif && Math.abs(b - e) < dif && Math.abs(c - f) < dif);
		}
	}

	static class Floor extends TwoArgFunction {
		/**
		Vector3i
		Returns a new Vector3i object with coords set to math.floor of this vector's coords.
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			vector.set("x", Math.floor(vector.get("x").tofloat()));
			vector.set("y", Math.floor(vector.get("y").tofloat()));
			vector.set("z", Math.floor(vector.get("z").tofloat()));
			return vector;
		}
	}

	static class HasNonZeroLength extends OneArgFunction {
		/**
		boolean
		Returns true if the vector has at least one coord non-zero. Note that this is subject to (possibly imprecise) floating point math.
		*/
		public LuaValue call(LuaValue vector) {
			float a = vector.get("x").tofloat();
			float b = vector.get("y").tofloat();
			float c = vector.get("z").tofloat();
			return LuaValue.valueOf(a != 0 || b != 0 || c != 0);
		}
	}

	static class Length extends OneArgFunction {
		/**
		number
		Returns the (euclidean) length of the vector.
		*/
		public LuaValue call(LuaValue vector) {
			float a = vector.get("x").tofloat();
			float b = vector.get("y").tofloat();
			float c = vector.get("z").tofloat();
			return LuaValue.valueOf(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)));
		}
	}

	static class LineCoeffToXYPlane extends TwoArgFunction {
		/**
		Vector3d Vector3d
		Znumber number
		Returns the coefficient for the line from the specified vector through this vector to reach the specified Z coord. The result satisfies the following equation: (this + Result * (Param - this)).z = Z. Returns the NO_INTERSECTION constant if there's no intersection.
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class LineCoeffToXZPlane extends TwoArgFunction {
		/**
		Vector3d Vector3d
		Ynumber number
		Returns the coefficient for the line from the specified vector through this vector to reach the specified Y coord. The result satisfies the following equation: (this + Result * (Param - this)).y = Y. Returns the NO_INTERSECTION constant if there's no intersection.
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class LineCoeffToYZPlane extends TwoArgFunction {
		/**
		Vector3d Vector3d
		Xnumber number
		Returns the coefficient for the line from the specified vector through this vector to reach the specified X coord. The result satisfies the following equation: (this + Result * (Param - this)).x = X. Returns the NO_INTERSECTION constant if there's no intersection.
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class Move extends VarArgFunction {
		/**
		Xnumber
		Ynumber
		Znumber
		Adds the specified offsets to each coord, effectively moving the vector by the specified coord offsets.
		*/
		public LuaValue call(LuaValue[] array, Varargs varargs) {
			LuaValue vector = array[0];
			vector.get("x").add(array[1]);
			vector.get("y").add(array[2]);
			vector.get("z").add(array[3]);
			return vector;
		}
	}

	
	static class Normalize extends TwoArgFunction {
		/**
		Changes this vector so that it keeps current direction as this but is exactly 1 unit long.
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class NormalizeCopy extends TwoArgFunction {
		/**
		Vector3d
		Returns a new vector that has the same direction as this but is exactly 1 unit long.
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class Set extends VarArgFunction {
		/**
		Xnumber
		Ynumber
		Znumber
		Sets all the coords in this object.
		*/
		public LuaValue call(LuaValue[] array, Varargs varargs) {
			LuaValue vector = array[0];
			vector.set("x", array[1]);
			vector.set("y", array[2]);
			vector.set("z", array[3]);
			return vector;
		}
	}

	static class SqrLength extends OneArgFunction {
		/**
		number
		Returns the (euclidean) length of this vector, squared. This operation is slightly less computationally expensive than Length(), while it conserves some properties of Length(), such as comparison.
		*/
		public LuaValue call(LuaValue vector) {
			float a = vector.get("x").tofloat();
			float b = vector.get("y").tofloat();
			float c = vector.get("z").tofloat();
			return LuaValue.valueOf(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
		}
	}

	static class TurnCW extends TwoArgFunction {
		/**
		Rotates the vector 90 degrees clockwise around the vertical axis. Note that this is specific to minecraft's axis ordering, which is X+ left, Z+ down.
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}
	
	static class TurnCCW extends TwoArgFunction {
		/**
		Rotates the vector 90 degrees counterclockwise around the vertical axis. Note that this is specific to minecraft's axis ordering, which is X+ left, Z+ down.
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			// TODO: Do this function
			return null;
		}
	}

	static class addedX extends TwoArgFunction {
		/**
		ofsnumber
		Vector3d
		Returns a copy of the vector, moved by the specified offset on the X axis
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			vector.get("x").add(value);
			return vector;
		}
	}

	static class addedXZ extends ThreeArgFunction {
		/**
		ofsXnumber
		ofsZnumber
		Vector3d
		Returns a copy of the vector, moved by the specified offsets on the X and Z axes
		*/
		public LuaValue call(LuaValue vector, LuaValue offsetX, LuaValue offsetZ) {
			vector.get("x").add(offsetX);
			vector.get("y").add(offsetZ);
			return vector;
		}
	}

	static class addedY extends TwoArgFunction {
		/**
		ofsnumber
		Vector3d
		Returns a copy of the vector, moved by the specified offset on the Y axis
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			vector.get("y").add(value);
			return vector;
		}
	}

	static class addedZ extends TwoArgFunction {
		/**
		ofsnumber
		Vector3d
		Returns a copy of the vector, moved by the specified offset on the Z axis
		*/
		public LuaValue call(LuaValue vector, LuaValue value) {
			vector.get("z").add(value);
			return vector;
		}
	}

	static class ToString extends OneArgFunction {
		public LuaValue call(LuaValue vector) {
			String output = "cVector3f(" + vector.get("x") + ", " + vector.get("y") + ", " + vector.get("z") + ")";
			return LuaValue.valueOf(output);
		}
	}
	
	static class Concat extends TwoArgFunction {
		public LuaValue call(LuaValue vectorA, LuaValue vectorB) {
			String stringA = vectorA.tojstring();
			String stringB = vectorB.tojstring();
			LuaValue valueA = vectorA.getmetatable().get("__tostring");
			LuaValue valueB = vectorB.getmetatable().get("__tostring");
			
			if (valueA.isfunction()) {
				stringA = valueA.call(vectorA).tojstring();
			}
			
			if (valueB.isfunction()) {
				stringB = valueB.call(vectorB).tojstring();
			}
			
			return LuaValue.valueOf(stringA.concat(stringB));
		}
	}
	
	protected static void registerFunctions(LuaValue vector) {
		// Setup lua metatable
		LuaValue metatable = LuaValue.tableOf();
		
		metatable.set("__mul", new multiply());
		metatable.set("__add", new add());
		metatable.set("__sub", new subtract());
		metatable.set("__div", new divide());
		metatable.set("__tostring", new ToString());
		metatable.set("__concat", new Concat());
		
		vector.setmetatable(metatable);
		
		vector.set("Abs", new Abs());
		vector.set("Ceil", new Ceil());
		vector.set("Clamp", new Clamp());
		vector.set("Cross", new Cross());
		vector.set("Dot", new Dot());
		vector.set("Equals", new Equals());
		vector.set("EqualsEps", new EqualsEps());
		vector.set("Floor", new Floor());
		vector.set("HasNonZeroLength", new HasNonZeroLength());
		vector.set("Length", new Length());
		vector.set("LineCoeffToXYPlane", new LineCoeffToXYPlane());
		vector.set("LineCoeffToXZPlane", new LineCoeffToXZPlane());
		vector.set("LineCoeffToYZPlane", new LineCoeffToYZPlane());
		vector.set("Move", new Move());
		vector.set("Normalize", new Normalize());
		vector.set("NormalizeCopy", new NormalizeCopy());
		vector.set("Set", new Set());
		vector.set("SqrLength", new SqrLength());
		vector.set("TurnCW", new TurnCW());
		vector.set("TurnCCW", new TurnCCW());
		vector.set("addedX", new addedX());
		vector.set("addedXZ", new addedXZ());
		vector.set("addedY", new addedY());
		vector.set("addedZ", new addedZ());
	}
	
}