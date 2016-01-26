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
	 * This method is used to create an NOT gate, given an input of type boolean.
	 * @param boolean A is the parameter which is going to be inverted.
	 */
	public NotGate(boolean A)
	{
		BufferGate b = new BufferGate();
		b.setValue(A);
		this.input = b;
	}
	
	/**
	   * This method is used to evaluate the value of this NOT gate
	   * @return boolean This returns the result of NOT A.
	   */
	public boolean evaluate()
	{
		if (input.evaluate() == false)
			return true;
		else
			return false;
	}

}
