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
    
    public void testPublicv1Version() {
    	BufferGate input1 = new BufferGate();
    	BufferGate input2 = new BufferGate();
    	AndGate and = new AndGate(input1, input2);
    	
    	input1.setValue(true);
    	input2.setValue(true);
    	
    	//SRC
    	assertEquals(true, and.evaluate());
    }
    
    
    public void testAddedBoolOperator() {
    	BufferGate input1 = new BufferGate();
    	BufferGate input2 = new BufferGate();
    	AndGate2 and = new AndGate2(input1, input2);
    	
    	input1.setValue(true);
    	input2.setValue(true);
    	
    	//FUN
    	Object y = and.evaluateObject();
    	System.out.println("AddedBoolTest: " + y.toString());
    	assertEquals(true, and.evaluateObject());
    	
    	//SRC
    	boolean x = and.evaluate();
    }
    
    public void testCircuitResult() {
    	BufferGate input1 = new BufferGate();
    	BufferGate input2 = new BufferGate();
    	AndGate2 and = new AndGate2(input1, input2);
    	  	
    	Circuit Cir = new Circuit();
    	Cir.setOutput(and);
    	
    	input1.setValue(true);
    	input2.setValue(true);
    	
    	//FUN
    	Object x1 = Cir.evalCircuit();
    	System.out.println("CircuitResultTest: "+ x1.toString());
    	
    	//SRC
    	boolean x = Cir.evalCircuit();
    	
    	assertEquals(true, x1);
     	assertEquals(true, Cir.evalCircuit());
    }
    
    public void testInputDoubles() {
    	InputDoubleGate input1 = new InputDoubleGate();
    	InputDoubleGate input2 = new InputDoubleGate();
    	AndGate2 and = new AndGate2(input1, input2);
    	
    	input1.setValue(true);
    	try {
    		input2.setValue(2.0);
    		assertTrue(true);
    	} catch (IllegalArgumentException e) {
    		//FUN
    		fail("Should not throw exception");
    	}
    }
}
