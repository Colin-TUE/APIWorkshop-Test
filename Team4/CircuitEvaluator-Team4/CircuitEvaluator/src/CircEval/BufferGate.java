package CircEval;

public class BufferGate extends LogicGate {
	
private boolean input;
	
	/**
	 * This the constructor of a BufferGate. It expects no arguments.
	 * 
	 */
	public BufferGate()
	{
		
	}
	
	/**
	 * This method is used to evaluate the result of this gate. No arguments are expected
	 */
	public boolean evaluate()
	{
			return input;
	}
	
	/**
	 * This method is used to set the value of this BufferGate.
	 * @param boolean Val is the value of this BufferGate.
	 */
	public void setValue(boolean Val)
	{
		this.input=Val;
	}

}
