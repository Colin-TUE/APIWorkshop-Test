package main.apicircuit;

/**
 * Created by IAnastas on 1/25/2016.
 */
public class Constant extends Element {
    private boolean value;

    public Constant(boolean value){
        this.value=value;
    }

    /**
     *   Constant is a leaf of the formula composite.
     *   Note the implementation of getValue() and add/deleteObserver() typical
     *   for a leaf.
     **/
    @Override
    public boolean getValue() {
        return value;
    }

    public void setValue(boolean newValue)
    {
        value = newValue;
    }
}
