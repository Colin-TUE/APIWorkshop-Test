import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import CircEval.BufferGate;

public class InputDoubleGate extends BufferGate{	
	
	boolean recurs = false;

	public void setValue(double val) {
		MethodHandle h1;
		try {
			h1 = MethodHandles.lookup().findSpecial(BufferGate.class, "setValue",
			        MethodType.methodType(double.class),
			        InputDoubleGate.class);
			MethodHandle h2 = MethodHandles.lookup().findSpecial(Object.class, "setValue",
			        MethodType.methodType(double.class),
			        InputDoubleGate.class);
			    h1.invoke(new InputDoubleGate());  
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Throwable e) {
			super.setValue(true);
		}
	}
}
