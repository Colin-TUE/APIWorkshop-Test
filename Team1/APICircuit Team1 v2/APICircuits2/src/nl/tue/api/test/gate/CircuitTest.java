package nl.tue.api.test.gate;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import nl.tue.api.gates.And;
import nl.tue.api.gates.Gate;
import nl.tue.api.gates.GateFactory;
import nl.tue.api.gates.Not;
import nl.tue.api.gates.Or;

public class CircuitTest extends TestCase{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAND_OR() {
		And and1 = (And) GateFactory.getGate(Gate.AND);
		Or or1 = (Or) GateFactory.getGate(Gate.OR);
		and1.setLeftInput(Boolean.FALSE);
		and1.setRightInput(Boolean.TRUE);
		and1.eval();
		or1.setLeftInput(and1.getOutput());
		or1.setRightInput(Boolean.FALSE);
		assertEquals(Boolean.FALSE,  or1.eval());
	}

	public void testAND(){
		And and = (And) GateFactory.getGate(Gate.AND);
		and.setLeftInput(Boolean.TRUE);
		and.setRightInput(Boolean.TRUE);
		assertTrue((Boolean) and.eval());
	}
	
	public void testOR_NOT(){
		Or or = (Or) GateFactory.getGate(Gate.OR);
		Not not = (Not) GateFactory.getGate(Gate.NOT);
		or.setLeftInput(Boolean.TRUE);
		not.setInput(Boolean.TRUE);
		or.setRightInput(not.eval());
		assertTrue((Boolean) or.eval());
	}
}
