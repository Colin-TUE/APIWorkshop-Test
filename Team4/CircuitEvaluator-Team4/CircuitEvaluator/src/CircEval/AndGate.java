package CircEval;

public class AndGate extends LogicGate {
	
	private LogicGate inputA;
	private LogicGate inputB;
	
	
	/**
	   * This method is used to create an AND gate, given two inputs
	   * @param LogicGate A is the first parameter of the AND gate.
	   * @param LogicGate B is the second parameter of the AND gate.
	   */
	public AndGate(LogicGate A, LogicGate B)
	{
		if(A == null || B == null)
		{
			throw new IllegalArgumentException("cannot accept null parameters");
		}
		this.inputA = A;
		this.inputB = B;
	}
	
	/**
	   * This method is used to evaluate the value of this AND gate
	   * @return boolean This returns the result of A AND B.
	   */
	public boolean evaluate()
	{
		if (inputA.evaluate() == true && inputB.evaluate()== true)
			return true;
		else
			return false;
	}

}
