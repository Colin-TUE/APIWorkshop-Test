package CircEval;

public class Circuit {

	private LogicGate output;
	
	/**
	 * This is the constructor of a Circuit. It expects no arguments.
	 * 
	 */
	public Circuit()
	{
		
	}
	
	/**
	 * Here you can define the circuit's output.
	 *  @param LogicGate out is the gate that is going to give the final value of the circuit
	 */
	public void setOutput(LogicGate out)
	{
		this.output=out;
	}
	
	/**
	 * Here you can get the output of this circuit.
	 * @return boolean The output of the circuit.
	 */
	public Object evalCircuit()
	{
		double result = this.output.evaluate();
		if (this.output.isBool())
			return (result==1.0)?true:false;
		else
			return result;
	}
}
