package main.apicircuit;

/**
 * Created by IAnastas on 1/25/2016.
 */
public abstract class BinaryLogicalExpression extends Element
{
    public BinaryLogicalExpression(Element l, Element r)
    {
        this.left = l;
        this.right = r;
    }

    protected Element right;
    protected Element left;

    public final Element getRight()
    {
        return right;
    }

    public final Element getLeft()
    {
        return left;
    }
}
