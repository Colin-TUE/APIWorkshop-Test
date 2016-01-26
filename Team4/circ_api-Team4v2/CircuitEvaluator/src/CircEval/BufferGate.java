package CircEval;

public class BufferGate extends LogicGate {
	
private double input;
	
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
	protected double evaluate()
	{
			return input;
	}
	
	/**
	 * This method is used to set the value of this BufferGate.
	 * @param boolean Val is the value of this BufferGate.
	 */
	public void setValue(boolean Val)
	{
		this.isBool=true;
		this.input=(Val==true)?1.0:0.0;
	}
	/**
	 * This method is used to set the value of this BufferGate.
	 * @param double Val is the value of this BufferGate.
	 */
	public void setValue(double Val)
	{
		if(Val>1.0 || Val<0.0)
			throw new IllegalArgumentException("Value out of expected range [0.0,1.0]");
		this.isBool=false;
		this.input=Val;
	}

}
