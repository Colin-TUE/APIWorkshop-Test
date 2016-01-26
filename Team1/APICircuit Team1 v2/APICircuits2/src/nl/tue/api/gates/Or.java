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
public class Or<T> extends Gate<T>{
	private T leftInput;
	private T rightInput;
	private T output;
	private static final String TYPE = Gate.OR;
	
//	private List<Gate<T>> outLinks = new ArrayList<>();
	private List<Gate<T>> inLinks = new ArrayList<>();
	
	
	public List<Gate<T>> getInLinks() {
		return inLinks;
	}

	public T eval() {
		
		if(leftInput instanceof Boolean && rightInput instanceof Boolean){
			Boolean b1 = (Boolean) leftInput;
			Boolean b2 = (Boolean) rightInput;
			Boolean b3 = b1 || b2;
			output = (T) b3;
		}
		
		if(leftInput instanceof Double && rightInput instanceof Double){
	        try {
	            if ((Double)leftInput >= 0 && (Double)rightInput >=0 && (Double)leftInput <= 1 && (Double)rightInput <=1) {
	            	Double b1 = (Double) leftInput;
					Double b2 = (Double) rightInput;
					Double res = 1 - (1 - b1) * (1 - b2);
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
	
	public void setInput(final T leftHandSide, final T rightHandSide){
		leftInput = leftHandSide;
		rightInput = rightHandSide;
	}
	
	public T getLeftInput() {
		return leftInput;
	}

	public void setLeftInput(T leftInput) {
		this.leftInput = leftInput;
		setChanged();
	    notifyObservers();
	}
	public void setLeftInput(Gate leftInput) {
		inLinks.add(leftInput);
	}

	public T getRightInput() {
		return rightInput;
	}

	public void setRightInput(T rightInput) {
		this.rightInput = rightInput;
		setChanged();
	    notifyObservers();
	}
	
	public void setRightInput(Gate rightInput) {
		inLinks.add(rightInput);
	}

	public T getOutput() {
		return output;
	}

	@Override
	public String getType() {
		return TYPE;
	}


	

}
