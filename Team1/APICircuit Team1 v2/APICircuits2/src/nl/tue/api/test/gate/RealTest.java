/**
 * 
 */
package nl.tue.api.test.gate;

import junit.framework.TestCase;
import nl.tue.api.gates.And;
import nl.tue.api.gates.Circuit;
import nl.tue.api.gates.Gate;
import nl.tue.api.gates.GateFactory;
import nl.tue.api.gates.Gte;
import nl.tue.api.gates.Not;
import nl.tue.api.gates.Or;

/**
 * @author IMikovsk
 *
 */
/** This file contains the workshop assignment for day 2. Simply, turn the 
 * boolean circuit into circuit that can compute with double values from 0 to 1.
 * <p>
 * This means that where ever a boolean was used to represent input or 
 * output values, one can now use any double number from >= 0 and <= 1.
 * Still, to support backward compatibility, the operations with booleans
 * has to be kept available and have to work. In fact False shall be 
 * treated as 0 and True as 1.
 * <p>
 * The basic elements has to be modified to work on doubles in the following
 * way:
 * <ul>
 *   <li>negation - neg(x) = 1 - x, this is correct extension as neg(false)=neg(0)=1-0=1=true
 *   <li>and - and(x,y) = x * y, again this is fine as and(true,true)=1*1=true and also
 *             and(false,true)=0*1=0=false
 *   <li>or - or(x,y) = 1 - (1 - x) * (1 - y) and this is also ok as
 *             or(false,false) = 1 - (1 - 0) * (1 - 0) = 1 - 1 = 0 = false
 *             or(true,false) = 1 - (1 - 1) * (1 - 0) = 1 - 0 * 1 = 1 = true
 * </ul>
 * <p>
 * However as the circuits with doubles are more rich than plain boolean circuits,
 * there is additional requirement to allow any user of your API to write its 
 * own "element" type. This is all going to be exercise in the tests bellow
 * which you are supposed to implement.
 */
public class RealTest extends TestCase {
    static {
        // your code shall run without any permissions
    }
    
    public RealTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }
    
    
    /** First of all create a circuit which will evaluate
     * expression (X1 and X2) or not(x1). Hold the circuit
     * in some variable.
     *
     * Feed this circuit with x1=true, x2=false, assert result is false
     *
     * Feed the same circuit with x1=false, x2=true, assert result is true
     *
     * Feed the same circuit with x1=0.0, x2=1.0, assert result is 1.0
     *
     * Feed the same circuit with x1=0.5, x2=0.5, assert result is 0.625
     *
     * Feed the same circuit with x1=0.0, x2=2.0, make sure it throws an exception
     */
    public void testX1andX2orNotX1() {
    	Circuit circuit = new Circuit();
    	
    	Boolean b1 = Boolean.TRUE;
    	Boolean b2 = Boolean.FALSE;
    	And and = (And) circuit.getFactory().getGate(Gate.AND);
		Not not = (Not) circuit.getFactory().getGate(Gate.NOT);
		Or or = (Or) circuit.getFactory().getGate(Gate.OR);
		and.setLeftInput(b1);
		and.setRightInput(b2);
		and.eval();
		not.setInput(b1);
		not.eval();
		or.setLeftInput(and.getOutput());
		or.setRightInput(not.getOutput());
		assertEquals(Boolean.FALSE, or.eval());
		assertEquals(Boolean.FALSE, circuit.eval());
//		==========================================
		b1 = Boolean.FALSE;
    	b2 = Boolean.TRUE;
//    	and.eval();
//    	not.eval();
    	assertEquals(Boolean.FALSE, circuit.eval());
//    	============================================
    	Double d1 = 0.0;
    	Double d2 = 1.0;
    	and.setLeftInput(d1);
		and.setRightInput(d2);
		not.setInput(d1);
		or.setLeftInput(and.getOutput());
		or.setRightInput(not.getOutput());
    	assertEquals( new Double(1.0), or.eval());
//    	============================================
    	d1 = 0.5;
    	d2 = 0.5;
    	and.setLeftInput(d1);
		and.setRightInput(d2);
    	and.eval();
    	not.setInput(d1);
    	not.eval();
		or.setLeftInput(and.getOutput());
		or.setRightInput(not.getOutput());
    	assertEquals( new Double(0.625), or.eval());
//    	============================================
    	try {
        	d1 = 0.5;
        	d2 = 2.0;
        	and.setLeftInput(d1);
    		and.setRightInput(d2);
        	and.eval();
        	not.setInput(d1);
        	not.eval();
    		or.setLeftInput(and.getOutput());
    		or.setRightInput(not.getOutput());
        	assertEquals( new Double(0.625), or.eval());
    	} catch (IllegalArgumentException e) {
    		System.err.println("IllegalArgumentException: " + e.getMessage());
    	}

    }
    
    /** Ensure that one variable cannot be filled with two different values.
     * Create a circuit for x1 and x1. Make sure that for any usage of your
     * API that would not lead to x1 * x1 result, an exception is thrown.
     * For example if there was a way to feed the circuit with two different 
     * values 0.3 and 0.5 an exception is thrown indicating that this is 
     * improper use of the circuit.
     */
    public void testImproperUseOfTheCircuit() {
 	  fail("testImproperUseOfTheCircuit");
    }
    
    /** Write your own element type called "gte" that will have two inputs and one output.
     * The output value will be 1 if x1 >= x2 and 0 otherwise. 
     * 
     * Create 
     * circuit for following expression: (x1 and not(x1)) gte x1
     *
     * Feed the circuit with 0.5 and verify the result is 0
     *
     * Feed the same circuit with 1 and verify the result is 0
     *
     * Feed the same circuit with 0 and verify the result is 1
     */
    public void testGreaterThanElement() {
	 //  fail("testGreaterThanElement");
    	Circuit circuit = new Circuit();
    	Double x1 = 0.5;
    	And and = (And) circuit.getFactory().getGate(Gate.AND);
		Not not = (Not) circuit.getFactory().getGate(Gate.NOT);
		Gte gte1 = (Gte) circuit.getFactory().getGate(Gate.GTE);
    	and.setLeftInput(x1);
    	not.setInput(x1);
    	not.eval();
    	and.setRightInput(not.getOutput());
		and.eval();
    	gte1.setLeftInput(and.getOutput());
		gte1.setRightInput(x1);
    	assertEquals( new Double(0.0), gte1.eval());
    }
}


