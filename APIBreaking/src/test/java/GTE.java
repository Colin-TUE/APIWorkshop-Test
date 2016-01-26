/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import nl.tu.api.apiworkshopteam2.BiGate;
import nl.tu.api.apiworkshopteam2.Gate;

public class GTE extends BiGate {

    public GTE(Gate in1, Gate in2) {
        super(in1, in2);
    }

    @Override
    public double evaluate() {
        return (input1.evaluate() >= input2.evaluate()) ? 1.0 : 0.0;
    }
}
