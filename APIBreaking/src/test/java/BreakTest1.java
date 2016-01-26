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
public class BreakTest1 {
    
    public BreakTest1() {
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
}
