/**
 * 
 */
package nl.tue.api.gates;

/**
 * @author IMikovsk
 *
 */
public class GateFactory {
	
	
	public static Gate getGate(final String type){
		Gate result = null;
		if(type.equalsIgnoreCase(Gate.NOT)){
			result = new Not();
		}
		if(type.equalsIgnoreCase(Gate.AND)){
			result = new And();
				}
		if(type.equalsIgnoreCase(Gate.OR)){
			result= new Or();
		}
		return result;
	}
}
