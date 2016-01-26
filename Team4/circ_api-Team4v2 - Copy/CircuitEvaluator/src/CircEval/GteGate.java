package CircEval;

public class GteGate extends LogicGate{
	
	private LogicGate inputA;
	private LogicGate inputB;
	
	
	/**
	   * This method is used to create an AND gate, given two inputs
	   * @param LogicGate A is the first parameter of the AND gate.
	   * @param LogicGate B is the second parameter of the AND gate.
	   */
	public GteGate(LogicGate A, LogicGate B)
	{
		this.isBool=false;
		if(A == null || B == null)
			throw new IllegalArgumentException("cannot accept null parameters");
		
		this.inputA = A;
		this.inputB = B;
	}
	
	/**
	   * This method is used to evaluate the value of this AND gate
	   * @return boolean This returns the result of A AND B.
	   */
	protected double evaluate()
	{	
		boolean result = inputA.evaluate() >= inputB.evaluate();
		
		if(inputA.isBool() && inputB.isBool())
			throw new IllegalArgumentException("LogicGates need to be of the same type (double)");
		else if (inputA.isBool()!= inputB.isBool())
			throw new IllegalArgumentException("LogicGates need to be of the same type (double)");
		
		return (result==true)?1.0:0.0;
	}

}
