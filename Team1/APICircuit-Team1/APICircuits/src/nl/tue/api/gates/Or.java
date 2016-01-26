/**
 * 
 */
package nl.tue.api.gates;

/**
 * @author IMikovsk
 *
 */
public class Or implements Gate{
	private Boolean leftInput;
	private Boolean rightInput;
	private Boolean output;
	private static final String TYPE = Gate.OR;
	@Override
	public Boolean eval() {
		output = leftInput || rightInput;
		return output;
	}
	
	public void setInput(final Boolean leftHandSide, final Boolean rightHandSide){
		leftInput = leftHandSide;
		rightInput = rightHandSide;
	}
	
	public Boolean getLeftInput() {
		return leftInput;
	}

	public void setLeftInput(Boolean leftInput) {
		this.leftInput = leftInput;
	}

	public Boolean getRightInput() {
		return rightInput;
	}

	public void setRightInput(Boolean rightInput) {
		this.rightInput = rightInput;
	}

	public Boolean getOutput() {
		return output;
	}

	@Override
	public String getType() {
		return TYPE;
	}


	

}
