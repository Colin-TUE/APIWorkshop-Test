/**
 * 
 */
package nl.tue.api.gates;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IMikovsk
 *
 */
public class Not<T> extends Gate<T>{
	
	private T input;
	private T output;
	private static final String TYPE = Gate.NOT;

	List<Gate<T>> inLinks = new ArrayList<>();
 	@Override
	public T eval() {
		
		if(input instanceof Boolean){
			Boolean b1 = (Boolean) input;
			Boolean res = ! b1;
			output = (T) res;
		}
		
		if(input instanceof Double){
	        try {
	            if ((Double)input >= 0  && (Double)input <= 1) {
	            	Double b1 = (Double) input;
	            	Double res = 1 - b1;
	            	output = (T) res;
	            } else {
            throw new IllegalArgumentException ("Error, number can't be negative or greater than 1.");
        }
	        } catch (NumberFormatException e) {
	        	System.err.println("NumberFormatException: " + e.getMessage());
	        }
		}
		return output;
	}
	
	public T getInput() {
		return input;
	}


	public void setInput(T input) {
		this.input = input;
		setChanged();
	    notifyObservers();
	}
	
	public void setInput(Gate input) {
		 inLinks.add(input);
	}


	public T getOutput() {
		return output;
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	public List<Gate<T>> getInLinks() {
		return inLinks;
	}
}
