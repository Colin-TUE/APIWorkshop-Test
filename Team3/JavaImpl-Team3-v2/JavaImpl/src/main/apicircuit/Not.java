package main.apicircuit;

/**
 * Created by IAnastas on 1/25/2016.
 */
public final class Not extends UnaryLogicalExpression {

    public Not(Element e) {
        this.element = e;
    }

    @Override
    public final boolean getValue()
    {
        return ! element.getValue();
    }

    @Override
    public final double getDoubleValue() {
        return 1.0 - element.getDoubleValue();
    }
}
