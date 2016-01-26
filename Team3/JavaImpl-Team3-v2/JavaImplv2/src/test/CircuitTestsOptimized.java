package test;


import junit.framework.Assert;
import junit.framework.TestCase;
import main.apicircuit.*;


/**
 * Created by IAnastas on 1/25/2016.
 */
public class CircuitTestsOptimized extends TestCase
{
    OperationsFactory factory;

    public void setUp()
    {
        factory = new ConcreteOperationsFactory();
    }

    /**
     * Create a circuit to getValue x1 and x2 and then
     * verify that its result is false for input (false, true) and
     * it is true for input (true, true).
     */
    public void testX1andX2()
    {
        Constant x1 = new Constant(false);
        Constant x2 = new Constant(true);

        BinaryLogicalExpression circuit = factory.getBinOperation("and", x1, x2);
        Assert.assertFalse(circuit.getValue());

        x1.setValue(true);

        Assert.assertTrue(circuit.getValue());
    }

    /**
     * Create a circuit to getValue (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */
    public void testX1andX2orX3()
    {
        Constant x1 = new Constant(false);
        Constant x2 = new Constant(true);
        Constant x3 = new Constant(false);

        BinaryLogicalExpression circuit = factory.getBinOperation("or", factory.getBinOperation("and", x1, x2), x3);
        Assert.assertFalse(circuit.getValue());

        x2.setValue(false);
        x3.setValue(true);

        Assert.assertTrue(circuit.getValue());
    }

    /**
     * Create a circuit to getValue (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */
    public void testAlwaysTrue()
    {
        Constant x1 = new Constant(false);

        BinaryLogicalExpression circuit = factory.getBinOperation("or", x1, factory.getUnaryOperation("not", x1));
        Assert.assertTrue(circuit.getValue());

        x1.setValue(true);

        Assert.assertTrue(circuit.getValue());
    }
}