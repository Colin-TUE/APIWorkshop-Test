package main.apicircuit;

/**
 * Created by IAnastas on 1/25/2016.
 */
public final class ConcreteOperationsFactory extends OperationsFactory {
    @Override
    public BinaryLogicalExpression getBinOperation(String operation, Element l, Element r)
    {
        String op = operation.toUpperCase();
        switch (op)
        {
            case "AND":
                return new And(l, r);
            case "OR":
                return new Or(l, r);
            default:
                throw new UnsupportedOperationException("Method does not exists: " + operation);
        }
    }

    @Override
    public UnaryLogicalExpression getUnaryOperation(String operation, Element e)
    {
        String op = operation.toUpperCase();
        switch (op)
        {
            case "NOT":
                return new Not(e);
            default:
                throw new UnsupportedOperationException("Method does not exists: " + operation);
        }
    }
}