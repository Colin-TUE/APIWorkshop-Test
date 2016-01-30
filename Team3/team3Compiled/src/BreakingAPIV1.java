import junit.framework.TestCase;
import main.apicircuit.BinaryLogicalExpression;
import main.apicircuit.Element;

/**
 * Created by nbui on 1/26/2016.
 */
public class BreakingAPIV1 extends TestCase {

    /*
    Can extend in version 1, not in version 2
    Version 2 has less capabilities than version 1
    This also happened in Not, Or, Constant, ConcreateOperationFactory
     */

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

    public void testEvaluateAnd() {
        AndExtend aEx = new AndExtend(l, r);
    }

    /*
     For BinaryLogicalExpression, it can create an instance with no parameter
      in version 1 but not version 2
      It is the same for UnaryLogicalExpression
     */
    public void testBinaryLogicalExpressionTest() {
        BinaryLogicalExpression bnr = new BinaryLogicalExpression() {
            @Override
            public boolean getValue() {
                return false;
            }
        };
    }


    public void testBinExprTest2() {

        BinExtend bine = new BinExtend(l, r);
    }

}
