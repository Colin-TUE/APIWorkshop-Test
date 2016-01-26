package main.apicircuit;

/**
 * Created by IAnastas on 1/25/2016.
 */
public final class Or extends BinaryLogicalExpression {

    public Or(Element l, Element r) {
        super(l, r);
    }

    @Override
    public final boolean getValue() {
        return left.getValue() || right.getValue();
    }

    @Override
    public final double getDoubleValue() {
        return 1.0 - (1.0 - left.getDoubleValue()) * (1.0 - right.getDoubleValue());
    }
}
