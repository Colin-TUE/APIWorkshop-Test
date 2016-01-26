package test;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.apicircuit.*;

/**
 * Created by IAnastas on 1/25/2016.
 */
public class RealTest extends TestCase
{
    OperationsFactory factory;

    public void setUp()
    {
        factory = new ConcreteOperationsFactory();
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
     * Feed the same circuit with x1=0.0, x2ret=2.0, make sure it throws an exception
     */
    public void testX1andX2orNotX1()
    {
        // Feed this circuit with x1=true, x2=false, assert result is false
        Constant x1 = new Constant(true);
        Constant x2 = new Constant(false);
        BinaryLogicalExpression circuit = factory.getBinOperation("or", factory.getBinOperation("and", x1, x2), factory.getUnaryOperation("not", x1));
        Assert.assertFalse(circuit.getValue());


        // Feed the same circuit with x1=false, x2=true, assert result is true
        x1.setValue(false);
        x2.setValue(true);

        Assert.assertTrue(circuit.getValue());

        // Feed the same circuit with x1=0.0, x2=1.0, assert result is 1.0

        x1.setValue(0.0);
        x2.setValue(1.0);

        Assert.assertEquals(1.0, circuit.getDoubleValue());

        // Feed the same circuit with x1=0.5, x2=0.5, assert result is 0.625

        x1.setValue(0.5);
        x2.setValue(0.5);

        Assert.assertEquals(0.625, circuit.getDoubleValue());

        //Feed the same circuit with x1=0.0, x2ret=2.0, make sure it throws an exception

        try
        {
            x1.setValue(0.0);
            x2.setValue(2.0);

            fail("IllegalArgumentException was not thrown" );
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertTrue(true);
        }
    }

    /** Ensure that one variable cannot be filled with two different values.
     * Create a circuit for x1 and x1. Make sure that for any usage of your
     * API that would not lead to x1 * x1 result, an exception is thrown.
     * For example if there was a way to feed the circuit with two different
     * values 0.3 and 0.5 an exception is thrown indicating that this is
     * improper use of the circuit.
     */
    public void testImproperUseOfTheCircuit()
    {
        Constant x1 = new Constant(0.3);
        BinaryLogicalExpression circuit = factory.getBinOperation("and", x1, x1);

        ((Constant)circuit.getLeft()).setValue(0.5);

        Assert.assertEquals(0.5, (circuit.getRight()).getDoubleValue());

        ((Constant)circuit.getRight()).setValue(0.7);

        Assert.assertEquals(0.7, (circuit.getLeft()).getDoubleValue());
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
    public void testGreaterThanElement()
    {
        Constant x1 = new Constant(0.5);
        BinaryLogicalExpression circuit = new Gte(factory.getBinOperation("and", x1, factory.getUnaryOperation("not", x1)), x1);
        Assert.assertEquals(0.0, circuit.getDoubleValue());

        // Feed the same circuit with 1 and verify the result is 0
        x1.setValue(1.0);
        Assert.assertEquals(0.0, circuit.getDoubleValue());

        //Feed the same circuit with 0 and verify the result is 1
        x1.setValue(0.0);
        Assert.assertEquals(1.0, circuit.getDoubleValue());

    }
}
