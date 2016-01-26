/**
 * 
 */
package nl.tue.api.gates;

/**
 * @author IMikovsk
 *
 */
public class And implements Gate{
	
	private Boolean leftInput;
	private Boolean rightInput;
	private Boolean output;
	private static final String TYPE = Gate.AND;

	@Override
	public Boolean eval() {
		output = leftInput && rightInput;
		return output;
	}

	public Boolean getLeftInput() {
		return leftInput;
	}

	public void setLeftInput(final Boolean leftInput) {
		this.leftInput = leftInput;
	}

	public Boolean getRightInput() {
		return rightInput;
	}

	public void setRightInput(final Boolean rightInput) {
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
