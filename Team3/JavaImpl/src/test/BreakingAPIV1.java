package test;

import main.apicircuit.*;

/**
 * Created by nbui on 1/26/2016.
 */
public class BreakingAPIV1 {

    /*
    Can extend in version 1, not in version 2
    Version 2 has less capabilities than version 1
    This also happened in Not, Or, Constant, ConcreateOperationFactory
     */
    public class AndExtend extends And {
        public AndExtend(Element l, Element r) {
            super(l, r);
        }
    }
    Element l = new Element() {
        @Override
        public boolean getValue() {
            return true;
        }


    };
    Element r = new Element() {
        @Override
        public boolean getValue() {
            return false;
        }
    };

    public void EvaluateAnd()
    {
        AndExtend eEx = new AndExtend(l,r);
    }

    /*
     For BinaryLogicalExpression, it can create an instance with no parameter
      in version 1 but not version 2
      It is the same for UnaryLogicalExpression
     */
    public void BinaryLogicalExpressionTest()
    {
        BinaryLogicalExpression bnr = new BinaryLogicalExpression() {
            @Override
            public boolean getValue() {
                return false;
            }
        };
    }


}
