package minestom.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;

public class MethodBinding extends VarArgFunction {
	
	Method method;
	
	public static LuaValue getBinding(Method method) {
		
		return new MethodBinding(method);
	}
	
	private MethodBinding(Method method) {
		this.method = method;
	}
	
	@Override
	public Varargs invoke(Varargs varargs) {
		LuaValue[] args = new LuaValue[varargs.narg()];
		
		for (int i = 0; i < varargs.narg(); i++) {
			args[i] = varargs.arg(i);
		}
		
		Object[] objectArgs = new Object[args.length];
		
		for(int i = 0; i < args.length; i++) {
			LuaValue value = args[i];
			if (value.get("Hash").isnil()) {
				objectArgs[i] = ObjectBinding.toJavaObject(value);
			} else {
				objectArgs[i] = ObjectBinding.getJavaObject((LuaTable) value);
			}
		}
		
		LuaValue value = LuaValue.NIL;
		
		try {
			Object output = method.invoke(args);
			value = ObjectBinding.getBinding(output);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
