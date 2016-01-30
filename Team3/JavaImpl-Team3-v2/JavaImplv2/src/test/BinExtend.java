package test;

import main.apicircuit.BinaryLogicalExpression;
import main.apicircuit.Element;

/**
 * Created by CLambrec on 30/01/2016.
 */
public class BinExtend extends BinaryLogicalExpression {

        public BinExtend(Element l, Element r) {
            super();
            this.right  = r;
            this.left = l;
        }

        @Override
        public boolean getValue() {
            return true;
        }

    public double getDoubleValue() {
        return 2.0;
    }
}
