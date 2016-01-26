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
		if(A == null || B == null)
		{
			throw new IllegalArgumentException("cannot accept null parameters");
		}
		this.inputA = A;
		this.inputB = B;
	}
	
	/**
	   * This method is used to evaluate the value of this OR gate
	   * @return boolean This returns the result of A OR B.
	   */
	public boolean evaluate()
	{
		if (inputA.evaluate() == false && inputB.evaluate()== false)
			return false;
		else
			return true;
	}

}
