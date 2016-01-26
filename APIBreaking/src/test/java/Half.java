

import nl.tu.api.apiworkshopteam2.UniGate;
import nl.tu.api.apiworkshopteam2.Gate;

/**
 *
 * @author Colin
 */
public class Half extends UniGate {

    public Half(Gate in1) {
        super(in1);
    }

    @Override
    public double evaluate() {
        return input.evaluate() / 2.0;
    }
}
