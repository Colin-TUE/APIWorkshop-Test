package nl.tue.api.test.gate;

import nl.tue.api.gates.Not;

public class Not2<T> extends Not{
	
	private T in;

	public T evalO() {
		return (T) this.eval();
	}
	
	public void setInput(T t) {
		this.in = t;
	}
}
