package nl.tue.api.test.gate;

import nl.tue.api.gates.Gate;

public class Gate2 implements Gate{

	@Override
	public Boolean eval() {
		return true;
	}

	@Override
	public String getType() {
		return "Gate2";
	}

}
