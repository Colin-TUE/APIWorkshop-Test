package CircEval;

public abstract class LogicGate {
	
	protected boolean isBool=false;
	
	protected abstract double evaluate();
	
	public boolean isBool(){
		return this.isBool;
	}

}
