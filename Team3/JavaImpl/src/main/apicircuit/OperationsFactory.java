package main.apicircuit;

/**
 * Created by IAnastas on 1/25/2016.
 */
public abstract class OperationsFactory {
    public abstract BinaryLogicalExpression getBinOperation(String operation, Element l, Element r);
    public abstract UnaryLogicalExpression getUnaryOperation(String operation, Element e);
}
