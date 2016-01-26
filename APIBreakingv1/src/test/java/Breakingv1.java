/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import nl.tu.api.apiworkshopteam2.AbstractFactory;
import nl.tu.api.apiworkshopteam2.CircuitTarget;
import nl.tu.api.apiworkshopteam2.ConcreteFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CLambrec
 */
public class Breakingv1 {
    
    public Breakingv1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    //=====Test For API Version 1===============================================
    /**
     * Create a circuit to evaluate x1 and x2 and then verify that its result is
     * false for input (false, true) and it is true for input (true, true).
     */
    @org.junit.Test
    public void testX1andX2() {
        AbstractFactory cirIns = new ConcreteFactory();
        CircuitTarget cirTarg;
        cirIns.initiliazeEmptyCircuit();
        //circuitIncirInsstance.createCicruit("X1 AND X2");          
        cirIns.addInput("X1");
        cirIns.moveGate(1);
        cirIns.addInput("X2");
        cirIns.moveGate(2);
        cirIns.addGate("and");
        cirIns.moveGate(1);
        //CircuitTarget ct = new CircuitAdapter(cirIns);
        //ct = cirIns.createCicruit();
        cirTarg = cirIns.createCicruit();
        cirTarg.setInput(true, "X1");
        cirTarg.setInput(true, "X2");
        System.out.println(cirTarg.evaluate());
        assertEquals(cirTarg.evaluate(), true);

    }

    /**
     * Create a circuit to evaluate (x1 and x2) or x3 and then verify that its
     * result is false for input (false, true, false) and it is true for input
     * (false, false, true).
     */
    @org.junit.Test
    public void testX1andX2orX3() {
        AbstractFactory circuitInstance = new ConcreteFactory();
        circuitInstance.initiliazeEmptyCircuit();
        //circuitInstance.createCicruit("X1 AND X2 OR X3");
        circuitInstance.addInput("X1");
        circuitInstance.moveGate(1);
        circuitInstance.addInput("X2");
        circuitInstance.moveGate(2);
        circuitInstance.addGate("and");
        circuitInstance.moveGate(1);
        circuitInstance.addInput("X3");
        circuitInstance.moveGate(2);
        circuitInstance.addGate("or");
        circuitInstance.moveGate(1);
        //TODO: 

        CircuitTarget cirTarg;
        cirTarg = circuitInstance.createCicruit();

        cirTarg.setInput(true, "X1");
        cirTarg.setInput(true, "X2");
        cirTarg.setInput(true, "X3");
        System.out.println(cirTarg.evaluate());
        assertTrue(cirTarg.evaluate());
        //assertEquals(cirTarg.evaluate(), Boolean.TRUE);

    }

    /**
     * Create a circuit to evaluate (x1 or not(x1)) and then verify that its
     * result is true for all values of x1.
     */
    @org.junit.Test
    public void testAlwaysTrue() {
        AbstractFactory circuitInstance = new ConcreteFactory();
        circuitInstance.initiliazeEmptyCircuit();
        //circuitInstance.createCicruit("X1 OR NOT X1");
        circuitInstance.addInput("X1");
        circuitInstance.moveGate(1);
        circuitInstance.addGate("not");
        circuitInstance.moveGate(1);
        CircuitTarget cirTarg;
        cirTarg = circuitInstance.createCicruit();
        System.out.println(cirTarg.evaluate());
        assertTrue(cirTarg.evaluate());
    }

    //=====Test For API Version 2===============================================
//    /**
//     * First of all create a circuit which will evaluate expression (X1 and X2)
//     * or not(x1). Hold the circuit in some variable.
//     *
//     * Feed this circuit with x1=true, x2=false, assert result is false
//     *
//     * Feed the same circuit with x1=false, x2=true, assert result is true
//     *
//     * Feed the same circuit with x1=0.0, x2=1.0, assert result is 1.0
//     *
//     * Feed the same circuit with x1=0.5, x2=0.5, assert result is 0.625
//     *
//     * Feed the same circuit with x1=0.0, x2=2.0, make sure it throws an
//     * exception
//     */
//    @org.junit.Test
//    public void testX1andX2orNotX1() {
//        AbstractFactory circuitInstance = new ConcreteFactory();
//        circuitInstance.initiliazeEmptyCircuit();
//        circuitInstance.addInput("X1");
//        circuitInstance.moveGate(1);
//        circuitInstance.addInput("X2");
//        circuitInstance.moveGate(2);
//        circuitInstance.addGate("and");
//        circuitInstance.moveGate(2);
//        circuitInstance.addInput("X1");
//        circuitInstance.moveGate(1);
//        circuitInstance.addGate("not");
//        circuitInstance.moveGate(1);
//        circuitInstance.addGate("or");
//        circuitInstance.moveGate(1);
//
//        CircuitTarget cirTarg;
//        cirTarg = circuitInstance.createCicruit();
//
//        cirTarg.setInput(true, "X1");
//        cirTarg.setInput(false, "X2");
//        System.out.println(cirTarg.evaluate());
//        assertTrue(!cirTarg.evaluate());
//
//        cirTarg.setInput(false, "X1");
//        cirTarg.setInput(true, "X2");
//        System.out.println(cirTarg.evaluate());
//        assertTrue(cirTarg.evaluate());
//
//        cirTarg.setInput(0.0, "X1");
//        cirTarg.setInput(1.0, "X2");
//        System.out.println(cirTarg.evaluate());
//        assertEquals(cirTarg.evaluate(), true);
//        System.out.println(cirTarg.evaluateD());
//        assertEquals(1.0, cirTarg.evaluateD(), 0.000000000000001);
//
//        cirTarg.setInput(0.5, "X1");
//        cirTarg.setInput(0.5, "X2");
//        System.out.println(cirTarg.evaluate());
//        assertTrue(cirTarg.evaluate());
//        System.out.println(cirTarg.evaluateD());
//        assertEquals(0.625, cirTarg.evaluateD(), 0.000000000000001);
//
//        try {
//            cirTarg.setInput(0.0, "X1");
//            cirTarg.setInput(2.0, "X2");
//            fail("Should have thrown");
//        } catch (IllegalArgumentException e) {
//            assertTrue(true);
//        }
//
//    }
//
//    /**
//     * Ensure that one variable cannot be filled with two different values.
//     * Create a circuit for x1 and x1. Make sure that for any usage of your API
//     * that would not lead to x1 * x1 result, an exception is thrown. For
//     * example if there was a way to feed the circuit with two different values
//     * 0.3 and 0.5 an exception is thrown indicating that this is improper use
//     * of the circuit.
//     */
//    @org.junit.Test
//    public void testImproperUseOfTheCircuit() {
//        //TODO: Wandering how important it is to actually test this, as we internally use the same referenced input
//        AbstractFactory cirInst = new ConcreteFactory();
//        cirInst.initiliazeEmptyCircuit();
//
//        cirInst.addInput("x1");
//        cirInst.moveGate(1);
//        cirInst.addInput("x1");
//        cirInst.moveGate(2);
//        cirInst.addGate("and");
//        cirInst.moveGate(1);
//        //TODO maybe define here an operator max and show the property using this. 
//        CircuitTarget cir = cirInst.createCicruit();
//
//        cir.setInput(0.3, "x1");
//        System.out.println(cir.evaluateD());
//        assertEquals(0.09, cir.evaluateD(), 0.00000000000001);
//        cir.setInput(0.5, "x1");
//        System.out.println(cir.evaluateD());
//        assertEquals(0.25, cir.evaluateD(), 0.00000000000001);
//    }
//
//    /**
//     * Write your own element type called "gte" that will have two inputs and
//     * one output. The output value will be 1 if x1 >= x2 and 0 otherwise.
//     *
//     * Create circuit for following expression: (x1 and not(x1)) gte x1
//     *
//     * Feed the circuit with 0.5 and verify the result is 0
//     *
//     * Feed the same circuit with 1 and verify the result is 0
//     *
//     * Feed the same circuit with 0 and verify the result is 1
//     */
//    @org.junit.Test
//    public void testGreaterThanElement() {
//
//        AbstractFactory cirInst = new ConcreteFactory();
//
//        cirInst.addCustomOperation(GTE.class, "gte");
//
//        cirInst.initiliazeEmptyCircuit();
//        cirInst.addInput("x1");
//        cirInst.moveGate(1);
//        cirInst.addInput("x1");
//        cirInst.moveGate(2);
//        cirInst.addGate("gte");
//        cirInst.moveGate(1);
//        //cirInst.addGate("gte");
//        //cirInst.moveGate(1);
//        CircuitTarget cir = cirInst.createCicruit();
//
//        cir.setInput(0.1, "x1");
//        cir.evaluateD();
//        System.out.println(cir.evaluateD());
//        assertEquals(1.0, cir.evaluateD(), 0.00000000000001);
//
//        cirInst.initiliazeEmptyCircuit();
//        cirInst.addInput("x1");
//        cirInst.moveGate(1);
//        cirInst.addInput("x1");
//        cirInst.moveGate(2);
//        cirInst.addGate("not");
//        cirInst.moveGate(1);
//        cirInst.addGate("and");
//        cirInst.moveGate(1);
//        cirInst.addInput("x1");
//        cirInst.moveGate(2);
//        cirInst.addGate("gte");
//        cirInst.moveGate(1);
//        cir = cirInst.createCicruit();
//
//        cir.setInput(0.5, "x1");
//        System.out.println(cir.evaluateD());
//        assertEquals(0.0, cir.evaluateD(), 0.00000000000001);
//        
//        cir.setInput(1.0, "x1");
//        System.out.println(cir.evaluateD());
//        assertEquals(0.0, cir.evaluateD(), 0.00000000000001);
//        
//        cir.setInput(0.0, "x1");
//        System.out.println(cir.evaluateD());
//        assertEquals(1.0, cir.evaluateD(), 0.00000000000001);
//
//        cirInst.addCustomOperation(Half.class, "half");
//        cirInst.initiliazeEmptyCircuit();
//        cirInst.addInput("x1");
//        cirInst.moveGate(1);
//        cirInst.addGate("half");
//        cirInst.moveGate(1);
//        //cirInst.addGate("gte");
//        //cirInst.moveGate(1);
//        cir = cirInst.createCicruit();
//        
//        cir.setInput(0.5, "x1");
//        System.out.println(cir.evaluateD());
//        assertEquals(0.25, cir.evaluateD(), 0.00000000000001);
//    }
}
