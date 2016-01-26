package main.apicircuit;

/**
 * Created by IAnastas on 1/25/2016.
 */
public class Or extends BinaryLogicalExpression {
    public Or(Element l, Element r)
    {
        right = r;
        left = l;
    }

    @Override
    public final boolean getValue() {
        return left.getValue() || right.getValue();
    }
}
