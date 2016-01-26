package main.apicircuit;

/**
 * Created by IAnastas on 1/25/2016.
 */
public class And extends BinaryLogicalExpression {
    public And(Element l, Element r)
    {
        this.left = l;
        this.right = r;
    }

    @Override
    public final boolean getValue() {
        return left.getValue() && right.getValue();
    }
}
