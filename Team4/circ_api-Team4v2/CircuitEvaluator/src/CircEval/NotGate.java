package CircEval;

public class NotGate extends LogicGate {
	
private LogicGate input;

	/**
	 * This method is used to create an NOT gate, given an input of type LogicGate.
	 * @param LogicGate A is the parameter which is going to be inverted.
	 */
	public NotGate(LogicGate A)
	{
		if(A == null)
		{
			throw new IllegalArgumentException("cannot accept null parameters");
		}
		this.input = A;
	}
	
	/**
	   * This method is used to evaluate the value of this NOT gate
	   * @return boolean This returns the result of NOT A.
	   */
	protected double evaluate()
	{
		double result = 1-input.evaluate();
		this.isBool=input.isBool();
		return result;
	}

}
