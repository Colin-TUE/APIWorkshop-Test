import CircEval.AndGate;
import CircEval.LogicGate;

public class AndGate2 extends AndGate {
	
	public AndGate2(LogicGate A, LogicGate B) {
		super(A, B);
	}
	
	public Object evaluateObject() {
		return (Object) super.evaluate();
	}
	
}