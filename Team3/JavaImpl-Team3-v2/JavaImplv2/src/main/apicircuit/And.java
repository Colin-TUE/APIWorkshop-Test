package main.apicircuit;

/**
 * Created by IAnastas on 1/25/2016.
 */
public final class And extends BinaryLogicalExpression {

    public And(Element l, Element r) {
        super(l, r);
    }

    @Override
    public final boolean getValue() {
        return left.getValue() && right.getValue();
    }

    @Override
    public final double getDoubleValue() {
        return left.getDoubleValue() * right.getDoubleValue();
    }
}
