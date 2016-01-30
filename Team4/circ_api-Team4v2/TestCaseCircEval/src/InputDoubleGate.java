import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

import CircEval.BufferGate;

public class InputDoubleGate extends BufferGate{	
	
	boolean recurs = false;

	public void setValue(double val) {
		try {
			Method method = BufferGate.class.getMethod("setValue",  double.class);
			MethodHandle h1 = MethodHandles.lookup().unreflect(method);
			method.invoke(val);
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Throwable e) {
			super.setValue(true);
		}
	}
}
