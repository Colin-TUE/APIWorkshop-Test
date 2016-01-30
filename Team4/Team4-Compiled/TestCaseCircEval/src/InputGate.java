import CircEval.LogicGate;

public class InputGate extends LogicGate {
	
	public boolean isBool = true;
	boolean input1 = true;
	double input2 = 2.0;
	
	public InputGate() {
		super();
	}

	//this is for the old API
	//@Override
	public boolean evaluate() {
		return input1;
	}
	
	//this is for the new API
	//@Override
	public double evaluateD() {
		return input2;
	}
	
	public void setBool(boolean val) {
		isBool = val; 
	}
	
}