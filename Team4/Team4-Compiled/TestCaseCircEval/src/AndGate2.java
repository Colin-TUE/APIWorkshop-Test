import CircEval.AndGate;
import CircEval.LogicGate;

public class AndGate2 extends AndGate {
	
	private boolean isBool = true;
	
	public AndGate2(LogicGate A, LogicGate B) {
		super(A, B);
		isBool = true;
	}

	//this is for the old API
	//@Override
	public boolean evaluate() {
		return isBool;
	}
	
	//this is for the new API
	/*public double evaluate() {
		isBool = true;
		return 1.0;
	}*/
	
}