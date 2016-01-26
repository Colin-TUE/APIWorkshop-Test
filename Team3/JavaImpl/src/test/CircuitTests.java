package test;


import junit.framework.Assert;
import junit.framework.TestCase;
import main.apicircuit.*;


/**
 * Created by IAnastas on 1/25/2016.
 */
public class CircuitTests extends TestCase
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
        BinaryLogicalExpression circuit = factory.getBinOperation("and", new Constant(false), new Constant(true));
        Assert.assertFalse(circuit.getValue());

        ((Constant) circuit.getLeft()).setValue(true);

        Assert.assertTrue(circuit.getValue());
    }

    /**
     * Create a circuit to getValue (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */
    public void testX1andX2orX3()
    {
        BinaryLogicalExpression circuit = factory.getBinOperation("or", factory.getBinOperation("and", new Constant(false), new Constant(true)), new Constant(false));
        Assert.assertFalse(circuit.getValue());

        ((Constant)((BinaryLogicalExpression)circuit.getLeft()).getRight()).setValue(false);
        ((Constant) circuit.getRight()).setValue(true);

        Assert.assertTrue(circuit.getValue());
    }

    /**
     * Create a circuit to getValue (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */
    public void testAlwaysTrue()
    {
        BinaryLogicalExpression circuit = factory.getBinOperation("or", new Constant(false), factory.getUnaryOperation("not", new Constant(false)));
        Assert.assertTrue(circuit.getValue());

        ((Constant)circuit.getLeft()).setValue(true);
        ((Constant) ((UnaryLogicalExpression) circuit.getRight()).getElement()).setValue(true);

        Assert.assertTrue(circuit.getValue());
    }
}