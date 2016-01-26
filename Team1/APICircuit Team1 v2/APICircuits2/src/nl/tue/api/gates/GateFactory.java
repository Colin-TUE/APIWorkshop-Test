/**
 * 
 */
package nl.tue.api.gates;

/**
 * @author IMikovsk
 *
 */
public class GateFactory {
	
	private static Circuit circuit=null; 
	
	public static Gate getGate(final String type){
		Gate result = null;
		if(type.equalsIgnoreCase(Gate.NOT)){
			result = new Not();
			if(circuit != null){
				circuit.addGate(result);
				result.addObserver(circuit);
			}
		}
		if(type.equalsIgnoreCase(Gate.AND)){
			result = new And();
			if(circuit != null){
				circuit.addGate(result);
				result.addObserver(circuit);
			}
		}
		if(type.equalsIgnoreCase(Gate.OR)){
			result= new Or();
			if(circuit != null){
				circuit.addGate(result);
				result.addObserver(circuit);
			}
		}
		if(type.equalsIgnoreCase(Gate.GTE)){
			result= new Gte();
			if(circuit != null){
				circuit.addGate(result);
				result.addObserver(circuit);
			}
		}
		return result;
	}

	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}
}
