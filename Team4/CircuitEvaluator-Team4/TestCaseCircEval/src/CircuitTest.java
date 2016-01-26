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
    
}

