package main.apicircuit;

/**
 * Created by IAnastas on 1/25/2016.
 */
public abstract class BinaryLogicalExpression extends Element
{
    protected Element right;
    protected Element left;

    public abstract boolean getValue();

    public Element getRight()
    {
        return right;
    }

    public Element getLeft()
    {
        return left;
    }
}
