package CircEval;

public class OrGate extends LogicGate {
	
	private LogicGate inputA;
	private LogicGate inputB;
	
	/**
	   * This method is used to create an OR gate, given two inputs
	   * @param LogicGate A is the first parameter of the OR gate.
	   * @param LogicGate B is the second parameter of the OR gate.
	   */
	public OrGate(LogicGate A, LogicGate B)
	{
		this.isBool=false;
		if(A == null || B == null)
			throw new IllegalArgumentException("cannot accept null parameters");
		
		if(A.isBool() && B.isBool())
			this.isBool=true;
		else if (A.isBool()!=B.isBool())
			throw new IllegalArgumentException("LogicGates need to be of the same type (boolean or double)");
		
		this.inputA = A;
		this.inputB = B;
	}
	
	/**
	   * This method is used to evaluate the value of this OR gate
	   * @return boolean This returns the result of A OR B.
	   */
	protected double evaluate()
	{
		double result = 1-(1-inputA.evaluate())*(1-inputB.evaluate());
		
		if(inputA.isBool() && inputB.isBool())
			this.isBool=true;
		else if (inputA.isBool()!= inputB.isBool())
			throw new IllegalArgumentException("LogicGates need to be of the same type (boolean or double)");
		
		return result;
	}

}
