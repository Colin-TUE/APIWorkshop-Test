package nl.tue.api.test.gate;
import static org.junit.Assert.*;

import javax.swing.event.AncestorEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.TestClass;

import junit.framework.TestCase;
import nl.tue.api.gates.And;
import nl.tue.api.gates.Gate;
import nl.tue.api.gates.GateFactory;
import nl.tue.api.gates.Not;
import nl.tue.api.gates.Or;



public class BreakingAPI {

	/*
	 * Source compatibility: or.eval() is type BOOLEAN in V1, but is 
	 * type Object in V2. So we need the type casting in V2.
	 * ALL the tests for V1 do not work in V2.
	 *  (e.g. assertFalse will not be working in V2)
	 */
	@Test
	public void testAND_OR1() {
		And and1 = (And) GateFactory.getGate(Gate.AND);
		Or or1 = (Or) GateFactory.getGate(Gate.OR);
		and1.setLeftInput(Boolean.FALSE);
		and1.setRightInput(Boolean.TRUE);
		and1.eval();
		or1.setLeftInput(and1.getOutput());
		or1.setRightInput(Boolean.FALSE);
		assertFalse(or1.eval());
}
	
	@Test
	public void testGateInterface(){
		/*
		 * See testGate file
		 * * Can create a class to implement Gate in V1 but not V2 because 
		 * in V1, Gate is an interface, but in V2 it isn't, it's an abstract class
		 */
	}
	
	
}



