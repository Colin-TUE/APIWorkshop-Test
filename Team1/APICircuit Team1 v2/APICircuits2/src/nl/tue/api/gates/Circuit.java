/**
 * 
 */
package nl.tue.api.gates;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author IMikovsk
 *
 */
public class Circuit implements Observer{

	List<Gate<?>> gates = new ArrayList<>();
	GateFactory factory = null;
	
	public Circuit() {
		factory = new GateFactory();
		factory.setCircuit(this);
	}
	
	public GateFactory getFactory() {
		return factory;
	}

	public void addGate(Gate gate) {
		gates.add(gate);
	}
	
	public Object eval(){
		for(Gate g : gates){
//			if(!g.getInLinks().isEmpty()){
//				
//			}
			g.eval();
		}
		Gate aux = gates.get(gates.size()-1);
		return aux.eval();
	}

	@Override
	public void update(Observable gate, Object arg) {
		eval();
	}
}
