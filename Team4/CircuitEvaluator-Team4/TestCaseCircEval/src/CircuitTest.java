import junit.framework.TestCase;
import CircEval.*;


/** The initial quest for this workshop is to create an API for boolean 
 * circuits. Such API shall be able to compose a boolean circuit from
 * basic elements and evaluate the result given initial values for 
 * input variables.
 * <p>
 * The basic elements include:
 * <ul>
 *   <li>negation - has one input and one output and changes 0 on input to 
 *          on output 1 and 1 to 0
 *   <li>and - has two inputs and one output. The output is 1 only if both 
 *          inputs are 1, otherwise it is 0
 *   <li>or - has two inputs and one output. The output is 1 always, except
 *          in the case when both inputs are 0
 * </ul>
 *
 * <p>
 * The boolean circuit can be used to represent boolean formulas and compute
 * the results for certain values of its inputs. The individual tasks described
 * as tests bellow.
 *
 * <p>
 * Links of interest:
 * <ul>
 *   <li><a href="http://en.wikipedia.org/wiki/Truth_table">Truth table</a>
 *   <li><a href="http://en.wikipedia.org/wiki/Tautology_(logic)">Taugology</a>
 * </ul>
 */
public class CircuitTest extends TestCase {
    static {
        // your code shall run without any permissions
    }
    
    public CircuitTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }
    
    
    /** 
     * Create a circuit to evaluate x1 and x2 and then
     * verify that its result is false for input (false, true) and
     * it is true for input (true, true).
     */
    public void testX1andX2() {
	  //fail("testX1andX2");
    	BufferGate X1 = new BufferGate();
    	BufferGate X2 = new BufferGate();
    	AndGate A1 = new AndGate(X1, X2);
    	
    	X1.setValue(false);
    	X2.setValue(true);
    	
    	Circuit Cir = new Circuit();
    	Cir.setOutput(A1);
    	
    	assertEquals(false, Cir.evalCircuit());
    }
    
    /** 
     * Create a circuit to evaluate (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */
    public void testX1andX2orX3() {
	  //fail("testX1andX2orX3");
    	BufferGate X1 = new BufferGate();
    	BufferGate X2 = new BufferGate();
    	BufferGate X3 = new BufferGate();
    	AndGate A1 = new AndGate(X1, X2);
    	OrGate O1 = new OrGate(A1, X3);
    	
    	X1.setValue(false);
    	X2.setValue(true);
    	X3.setValue(true);
    	
    	Circuit Cir = new Circuit();
    	Cir.setOutput(O1);
    	
    	assertEquals(true, Cir.evalCircuit());
    }
    /** 
     * Create a circuit to evaluate (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */
    public void testAlwaysTrue() {
	  //fail("testAlwaysTrue");
    	BufferGate X1 = new BufferGate();
    	NotGate N1 = new NotGate(X1);
    	OrGate O1 = new OrGate(X1, N1);
    	
    	X1.setValue(false);
    	
    	Circuit Cir = new Circuit();
    	Cir.setOutput(O1);
    	
    	assertEquals(true, Cir.evalCircuit());
    }
    
    /**
     * Test to access the evaluate of version 1, which is not accaible by version 2
     */
    public void testPublicv1Version() {
    	BufferGate input1 = new BufferGate();
    	BufferGate input2 = new BufferGate();
    	AndGate and = new AndGate(input1, input2);
    	
    	input1.setValue(true);
    	input2.setValue(true);
    	//this cannot compile in the newer version.
    	assertEquals(true, and.evaluate());
    }
    
    public void testAddedBoolOperator() {
    	BufferGate input1 = new BufferGate();
    	BufferGate input2 = new BufferGate();
    	AndGate2 and = new AndGate2(input1, input2);
    	
    	input1.setValue(true);
    	input2.setValue(true);
    	//this cannot compile in the newer version.
    	assertEquals(true, and.evaluate());
    }
    
    public void testIsBoolException() {
    	InputGate input1 = new InputGate();
    	InputGate input2 = new InputGate();
    	AndGate2 and = new AndGate2(input1, input2);
    	
    	input1.setBool(true);
    	input2.setBool(false);
    	//this cannot compile in the newer version.
    	assertEquals(2.0, input1.evaluateD());
    	assertEquals(2.0, input2.evaluateD());
    	//should not thrown an exception
    }
    
    public void testCircuitResult() {
    	BufferGate input1 = new BufferGate();
    	BufferGate input2 = new BufferGate();
    	AndGate2 and = new AndGate2(input1, input2);
    	
    	Circuit Cir = new Circuit();
    	Cir.setOutput(and);
    	
    	assertEquals(true, Cir.evalCircuit());
    	//uncomment next line to get functional incomb
    	boolean x = Cir.evalCircuit();
    	
    	Object x1 = (Object) Cir.evalCircuit();
    	assertEquals(true, x1);
    }
}



