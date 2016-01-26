package main.apicircuit;

/**
 * Created by IAnastas on 1/25/2016.
 */
public final class Constant extends Element
{
    private double doubleValue;
    private boolean value;

    public Constant(boolean value)
    {
       setValue(value);
    }

    public Constant(double value)
    {
        setValue(value);
    }

    @Override
    public final boolean getValue()
    {
        return value;
    }

    @Override
    public final double getDoubleValue()
    {
        return  doubleValue;
    }

    public final void setValue(boolean newValue)
    {
        value = newValue;
        if (value)
        {
            doubleValue = 1.0;
        }
        else
        {
            doubleValue = 0.0;
        }
    }

    public final void setValue(double newValue)
    {
        if (newValue < 0 || newValue > 1)
        {
            throw new IllegalArgumentException("Values need to be between 0 and 1");
        }

        doubleValue = newValue;
    }
}
