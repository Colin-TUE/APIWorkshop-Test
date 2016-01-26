package test;

import main.apicircuit.BinaryLogicalExpression;
import main.apicircuit.Element;

/**
 * Created by IAnastas on 1/26/2016.
 */
public class Gte extends BinaryLogicalExpression {
    public Gte(Element l, Element r) {
        super(l, r);
    }

    @Override
    public boolean getValue() {
        return false;
    }

    @Override
    public double getDoubleValue() {
        if (left.getDoubleValue() >= right.getDoubleValue())
        {
            return 1.0;
        }
        else
        {
            return 0.0;
        }
    }
}