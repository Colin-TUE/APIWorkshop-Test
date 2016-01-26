/**
 * 
 */
package nl.tue.api.gates;


public class Gte<T> extends Gate<T>{
	private T leftInput;
	private T rightInput;
	private T output;
	private static final String TYPE = Gate.GTE;
	
	public T eval() {
		

		if(leftInput instanceof Double && rightInput instanceof Double){
	        try {
	            if ((Double)leftInput >= 0 && (Double)rightInput >=0 && (Double)leftInput <= 1 && (Double)rightInput <=1) {
	            	Double b1 = (Double) leftInput;
					Double b2 = (Double) rightInput;
					if (b1>=b2){
						Double res = 1.0;
						output = (T) res;
					}
					else{
						Double res = 0.0;
						output = (T) res;
					}
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
	}

	public T getRightInput() {
		return rightInput;
	}

	public void setRightInput(T rightInput) {
		this.rightInput = rightInput;
	}

	public T getOutput() {
		return output;
	}

	@Override
	public String getType() {
		return TYPE;
	}


	

}
